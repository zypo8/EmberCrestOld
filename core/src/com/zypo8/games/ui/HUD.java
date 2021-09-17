package com.zypo8.games.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.ui.hud.CastBar;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;
import com.zypo8.games.ui.hud.buff_bar.DeBuffbar;
import com.zypo8.games.ui.hud.minimap.Minimap;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;
import com.zypo8.games.ui.hud.status.StatusButtons;
import com.zypo8.games.ui.hud.tools.InfoWindow;
import com.zypo8.games.ui.windows.SelectAmountWindow;

import java.util.ArrayList;

public class HUD {
    //statics
    public static CastBar castBar;
    public static Label warningLabel = new Label("", new Label.LabelStyle(new BitmapFont(), Color.RED));
    public static ArrayList<Label> CombatTextArray= new ArrayList<Label>(50);
    public static SelectAmountWindow selectAmountWindow;

    //requied
    public HUDStage hudStage;
    public Viewport viewport;
    private final OrthographicCamera camera;

    //HUD
    public static PlayerFrame playerFrame;
    public Actionbar actionbar;
    public Buffbar buffbar;
    public DeBuffbar deBuffbar;
    public StatusButtons statusButtons;
    public Minimap minimap;
    public InfoWindow infoWindow = new InfoWindow("0/0");
    Label chat;
    Table table;

    public HUD(SpriteBatch batch){
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        hudStage = new HUDStage(viewport, batch);
        camera.setToOrtho(false, 1280, 720);
        warningLabel.setFontScale(2f);
        warningLabel.addAction(Actions.alpha(0, 4));
        warningLabel.setTouchable(Touchable.disabled);

        playerFrame = new PlayerFrame();
        HorizontalGroup playerFrameGroup = new HorizontalGroup();
        playerFrameGroup.addActor(playerFrame);
        //playerFrameGroup.addActor(infowWindow);

        actionbar = new Actionbar();
        buffbar = new Buffbar();
        deBuffbar = new DeBuffbar();
        statusButtons = new StatusButtons();
        castBar = new CastBar();

        minimap = new Minimap();
        chat = new Label("chat", new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        setUpCombatText();

        displayExpInfoWindow();
        table = new Table();
        table.setDebug(true);
        table.setFillParent(true);

        table.add(playerFrameGroup).expand().left().top().height(Gdx.graphics.getHeight()/100f*10).width((Gdx.graphics.getWidth()/100f)*18).padLeft(80).padTop(25);
        table.add(buffbar).center().top().width((Gdx.graphics.getWidth()/100f)*50).height(Gdx.graphics.getHeight()/100f*10).padTop(25);
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

        hudStage.addActor(selectAmountWindow);
        hudStage.addActor(table);
        for(Label combatLabel: CombatTextArray)
            hudStage.addActor(combatLabel);
    }

    private void setUpCombatText() {
        for(int i=0;i<50;i++) {
            CombatTextArray.add(new Label("", new Label.LabelStyle(new BitmapFont(), Color.RED)));
            CombatTextArray.get(i).setFontScale(2f);
            CombatTextArray.get(i).addAction(Actions.alpha(0, 0));
        }
    }

    public static void setCombatText(String text, Color color){
        for(Label combatLabel:CombatTextArray){
            if(combatLabel.hasActions()){
                continue;
            }else {
                combatLabel.setText(text);
                combatLabel.setStyle(new Label.LabelStyle(new BitmapFont(), color));
                combatLabel.setPosition(Gdx.graphics.getWidth()/2-combatLabel.getPrefWidth()/2, Gdx.graphics.getHeight()/2-combatLabel.getPrefHeight()/2);
                combatLabel.clearActions();
                combatLabel.addAction(Actions.alpha(1, 0));
                combatLabel.addAction(Actions.alpha(0, 3.5f));
                combatLabel.addAction(Actions.moveTo(combatLabel.getX(), combatLabel.getY()+ Gdx.graphics.getHeight()/3, 5));
                return;
            }
        }
        CombatTextArray.get(0).setText(text);
        CombatTextArray.get(0).setStyle(new Label.LabelStyle(new BitmapFont(), color));
        CombatTextArray.get(0).setPosition(Gdx.graphics.getWidth()/2-CombatTextArray.get(0).getPrefWidth()/2, Gdx.graphics.getHeight()/2-CombatTextArray.get(0).getPrefHeight()/2);
        CombatTextArray.get(0).clearActions();
        CombatTextArray.get(0).addAction(Actions.alpha(1, 0));
        CombatTextArray.get(0).addAction(Actions.alpha(0, 3.5f));
        CombatTextArray.get(0).addAction(Actions.moveTo(CombatTextArray.get(0).getX(), CombatTextArray.get(0).getY()+ Gdx.graphics.getHeight()/3, 5));
    }

    public void setOnTopHud(){
        table.setZIndex(9999999);
        System.out.println(table.getZIndex()+ " asdadad"+ table.getParent().getChildren().size +"   ");
    }
    public void displayExpInfoWindow() {
        //infowWindow.clearActions();
        infoWindow.setPosition(infoWindow.getX(), infoWindow.getY()- infoWindow.getHeight());
        infoWindow.setText(PlayerStats.getEXP()+ " / "+ PlayerStats.getExpToNextLevel());
        infoWindow.setVisible(true);
        //infowWindow.addAction(Actions.alpha(0, 4));
    }


    public void setToOrthooo(int width, int height){
        camera.setToOrtho(false, width, height);
    }
}
