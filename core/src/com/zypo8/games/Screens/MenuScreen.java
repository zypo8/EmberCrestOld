package com.zypo8.games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.load_game_system.LoadGameScreen;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.talents.talentSystem.TalentSystem;
import com.zypo8.games.items.talents.talentSystem.TalentTree;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;

public class MenuScreen implements Screen {
    public static MyRPGGame game;
    private final OrthographicCamera camera;
    private final Viewport viewport;
    private final Stage stage;
    private Table table;
    private TextButton playButton, settingsButton, newGameButton, exitButton;
    private final Sprite backgroundSprite;

    public MenuScreen(MyRPGGame game) {
        MenuScreen.game = game;
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        camera.setToOrtho(false, 1280, 720);
        stage = new Stage(viewport, game.batch);
        Gdx.input.setInputProcessor(stage);
        setUpButtons();
        setUpTable();
        stage.addActor(table);
        backgroundSprite = new Sprite(new Texture(Gdx.files.internal("img/backgrounds/menuBackground.jpg")));
        stage.addActor(MyRPGGame.menuWIndow);
        stage.addActor(MyRPGGame.options);
    }

    @Override
    public void show() {
        MyRPGGame.menuWIndow.setVisible(false);
        Player.inventoryWindow = null;
        Player.equipmentWindow = null;
        Player.talentsWindow = null;
        InventorySlot.slotsNumber = 0;
        HUDStage.lastClickedSlot = null;
        TalentSystem.talentTrees = null;
        TalentSystem.talentSpend = 0;
        TalentTree.talentTreeCount = 0;
        GameScreen.stage = null;
        GameScreen.hud = null;
        GameScreen.gameWorld = null;
        GameScreen.floor = 1;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        backgroundSprite.draw(stage.getBatch());
        stage.getBatch().end();
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        stage.draw();
    }

    private void setUpButtons() {
        playButton = new TextButton("Play", Tools.getSkin());
        settingsButton = new TextButton("Settings", Tools.getSkin());
        newGameButton = new TextButton("New game", Tools.getSkin());
        exitButton = new TextButton("Exit", Tools.getSkin());

        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new GameScreen(game));
                game.setScreen(new LoadGameScreen(game));
                dispose();
            }
        });
        newGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new NewGameScreen(game));
                dispose();
            }
        });

        settingsButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MyRPGGame.options.setVisible(true);
            }
        });

        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }
    private void setUpTable() {
        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        table.add(playButton);
        table.row();
        table.add(newGameButton).padTop(40);
        table.row();
        table.add(settingsButton).padTop(40);
        table.row();
        table.add(exitButton).padTop(40);
    }


    @Override
    public void resize(int width, int height) {
        MyRPGGame.options.refreshOptionsWindpwOnResize();
        viewport.update(width, height);
        camera.setToOrtho(false, width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}