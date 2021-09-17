package com.zypo8.games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.new_game_system.CreateNewSave;
import com.zypo8.games.Screens.new_game_system.MagicIcons;
import com.zypo8.games.Screens.new_game_system.NewGameStage;
import com.zypo8.games.Screens.new_game_system.TechIcons;
import com.zypo8.games.ui.Tools;

public class NewGameScreen implements Screen {
    private final MyRPGGame game;
    private final OrthographicCamera camera;
    private final Viewport viewport;
    private final NewGameStage stage;
    private Table table;
    private TextButton backButton, createButton;
    private TextField nameField;

    private final MagicIcons magicIcons;
    private final TechIcons techIcons;
    private final Sprite backgroundSprite;

    public NewGameScreen(MyRPGGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        camera.setToOrtho(false, 1280, 720);
        stage = new NewGameStage(viewport, game.batch);
        Gdx.input.setInputProcessor(stage);
        magicIcons = new MagicIcons();
        techIcons = new TechIcons();
        setUpButtons();
        setUpTable();
        stage.addActor(table);
        backgroundSprite = new Sprite(new Texture(Gdx.files.internal("img/backgrounds/menuBackground.jpg")));
    }

    @Override
    public void show() {
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
        backButton = new TextButton("<- Back", Tools.getSkin());
        createButton = new TextButton("Create ->", Tools.getSkin());
        nameField = new TextField("", Tools.getSkin());


        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
                dispose();
            }
        });
        createButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(CreateNewSave.createSave(nameField.getText(), NewGameStage.PlayerClass)){
                    game.setScreen(new MenuScreen(game));
                    dispose();
                }
            }
        });
    }


    private void setUpTable() {
        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);

        table.add(magicIcons).expand();
        table.add().expand();
        table.add(techIcons).expand();

        table.row();

        table.add(backButton).expand();
        table.add(nameField).expand();
        table.add(createButton).expand();
    }



    @Override
    public void resize(int width, int height) {
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