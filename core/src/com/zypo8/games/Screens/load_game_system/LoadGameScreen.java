package com.zypo8.games.Screens.load_game_system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.MenuScreen;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.SaveContainerWindow;

import java.io.File;

public class LoadGameScreen implements Screen {
    public static File SelectedSave;
    public SaveContainerWindow saveContainerWindow;
    private MyRPGGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private LoadGameScreenStage stage;
    private Table table;
    private TextButton backButton, loadButton;
    private Sprite backgroundSprite;

    public LoadGameScreen(MyRPGGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        camera.setToOrtho(false, 1280, 720);
        stage = new LoadGameScreenStage(viewport, game.batch);
        Gdx.input.setInputProcessor(stage);
        setUpButtons();
        backgroundSprite = new Sprite(new Texture(Gdx.files.internal("img/backgrounds/menuBackground.jpg")));
    }

    @Override
    public void show() {
        saveContainerWindow = new SaveContainerWindow();
        stage.setSaveContainerWindow(saveContainerWindow);
        stage.addActor(saveContainerWindow);
        setUpTable();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        stage.act();
        //saveContainerWindow.scrollPane.;
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
        loadButton = new TextButton("Load game ->", Tools.getSkin());


        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
                dispose();
            }
        });
        loadButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                load();
            }
        });
    }
    private void load(){
        if(SelectedSave == null){
            System.out.println("SELECT SAVE");
            return;
        }
        System.out.println("LOADING");
        dispose();
        new LoadGame(game, SelectedSave).LoadGame();
    }


    private void setUpTable() {
        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);

//        for(GameSaveButton save:saves) {
//            table.add(save);
//        }
        table.add();

        table.row();

        table.add(backButton).expand();
        table.add();
        table.add(loadButton).expand();
    }


    @Override
    public void resize(int width, int height) {
        saveContainerWindow.setSize(Gdx.graphics.getWidth() / 10 * 3, Gdx.graphics.getHeight() / 10 * 9);
        //saveContainerWindow.scrollPanel.setSize(Gdx.graphics.getWidth() / 10 * 3, Gdx.graphics.getHeight() / 10 * 9);
        saveContainerWindow.setPosition(Gdx.graphics.getWidth() / 2 - saveContainerWindow.getWidth() / 2, Gdx.graphics.getHeight() / 2 - saveContainerWindow.getHeight() / 2);
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
