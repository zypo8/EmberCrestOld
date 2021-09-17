package com.zypo8.games.Screens.load_screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.load_game_system.LoadGame;
import com.zypo8.games.Screens.load_game_system.LoadGameScreen;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.playerFrame.GetDrawableBar;

public class LoadScreen implements Screen {

    public  MyRPGGame game;
    private final OrthographicCamera camera;
    private final Viewport viewport;
    private final Stage stage;
    private final Sprite backgroundSprite;


    public static AssetManager assetManager;
    private final ProgressBar progressBar;

    public LoadScreen(MyRPGGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        camera.setToOrtho(false, 1280, 720);
        stage = new Stage(viewport, game.batch);
        Gdx.input.setInputProcessor(stage);
        backgroundSprite = new Sprite(new Texture(Gdx.files.internal("img/backgrounds/menuBackground.jpg")));
        progressBar = new ProgressBar(0, 1, 0.01f, false, Tools.getSkin());
        progressBar.setWidth(300);
        progressBar.setHeight(30);
        progressBar.getStyle().knob = GetDrawableBar.getColoredDrawable(0, 30, new Color(0x2CA120ff));
        progressBar.getStyle().knobBefore = GetDrawableBar.getColoredDrawable(300, 30, new Color(0x2CA120ff));
        progressBar.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        stage.addActor(progressBar);

    }

    @Override
    public void show() {
        assetManager = new AssetManager();
        Assets.addAssetsToArray();
        for(AssetDescriptor assetDescriptor:Assets.allAssets)
            assetManager.load(assetDescriptor);

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        backgroundSprite.draw(stage.getBatch());
        stage.getBatch().end();
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        stage.draw();
        if(assetManager.update()){
            assetManager.finishLoading();
            new LoadGame(game, LoadGameScreen.SelectedSave).LoadGame();
        }else {
            progressBar.setValue(assetManager.getProgress());
        }

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
