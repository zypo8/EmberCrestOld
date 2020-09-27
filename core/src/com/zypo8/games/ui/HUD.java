package com.zypo8.games.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.ui.hud.CastBar;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;
import com.zypo8.games.ui.hud.buff_bar.DeBuffbar;
import com.zypo8.games.ui.hud.minimap.Minimap;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;
import com.zypo8.games.ui.hud.status.StatusButtons;

public class HUD {
    //statics
    public static CastBar castBar;
    public static Label warningLabel = new Label("", new Label.LabelStyle(new BitmapFont(), Color.RED));

    //requied
    public HUDStage hudStage;
    public Viewport viewport;
    private OrthographicCamera camera;

    //HUD
    public static PlayerFrame playerFrame;
    public Actionbar actionbar;
    public Buffbar buffbar;
    public DeBuffbar deBuffbar;
    public StatusButtons statusButtons;
    public Minimap minimap;
    Label chat;

    public HUD(SpriteBatch batch){
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        hudStage = new HUDStage(viewport, batch);
        camera.setToOrtho(false, 1280, 720);
        warningLabel.setFontScale(2f);
        warningLabel.addAction(Actions.alpha(0, 4));
        warningLabel.setTouchable(Touchable.disabled);

        playerFrame = new PlayerFrame();

        actionbar = new Actionbar();
        buffbar = new Buffbar();
        deBuffbar = new DeBuffbar();
        statusButtons = new StatusButtons();
        castBar = new CastBar();

        minimap = new Minimap();
        chat = new Label("chat", new Label.LabelStyle(new BitmapFont(), Color.WHITE));



        Table table = new Table();
        table.setDebug(false);
        table.setFillParent(true);

        table.add(playerFrame).expand().left().top().height(Gdx.graphics.getHeight()/100f*10).width((Gdx.graphics.getWidth()/100f)*18).padLeft(80).padTop(25);
        table.add(buffbar).center().top().width((Gdx.graphics.getWidth()/100f)*50).height(Gdx.graphics.getHeight()/100f*10);
        table.add(minimap).height(Gdx.graphics.getHeight()/100f*30).width((Gdx.graphics.getWidth()/100f)*18).top().right().padTop(10).padRight(10);
        table.row();
        table.add();
        table.add(warningLabel).padRight(32).padTop(-Gdx.graphics.getHeight()/2);
        table.add(deBuffbar).expand().padTop(-90).top();
        table.row();
        table.add(castBar).colspan(3).center().height(Gdx.graphics.getHeight()/100f*8);
        table.row();
        table.row();
        table.add(actionbar).colspan(3).center().height(Gdx.graphics.getHeight()/100f*8);
        table.row();
        table.add().height(Gdx.graphics.getHeight()/100f*18);
        table.add().height(Gdx.graphics.getHeight()/100f*18);
        table.add(statusButtons).height(Gdx.graphics.getHeight()/100f*18);
        table.row();

        hudStage.addActor(table);
    }


    public void setToOrthooo(int width, int height){
        camera.setToOrtho(false, width, height);
    }
}
