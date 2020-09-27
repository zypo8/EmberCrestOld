package com.zypo8.games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.MyRPGGame;

public class BattleScreen implements Screen {
    private OrthographicCamera camera;
    private MyRPGGame game;
    private GameScreen gameScreen;
    private Viewport viewport;
    private Stage stage;


    public BattleScreen(MyRPGGame game, GameScreen gameScreen) {
        this.game = game;
        this.gameScreen = gameScreen;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        camera.setToOrtho(false, 1280, 720);
        stage = new Stage(viewport, game.batch);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        MyRPGGame.font.draw(game.batch, "BATTLE Click on screen to exit", 305, 250);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(gameScreen);
            dispose();
        }

    }

    @Override
    public void resize(int width, int height) {

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
