package com.zypo8.games.ui.hud.playerFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.zypo8.games.Screens.load_game_system.LoadGame;
import com.zypo8.games.actors.player.PlayerStats;


public class PlayerFrame extends Group {
    public static Label levelLabel;
    public static HealthBar hp;
    public static ExpBar expBar;
    public static Label hpLabel;
    public static ManaBar mana;
    public static Label manaLabel;


    public Label nameLabel;
    public ActorSprite playerFrame;
    public PlayerFrame() {
        setTouchable(Touchable.enabled);
        setName("Player Frame");
        playerFrame = new ActorSprite();
        setWidth(playerFrame.sprite.getWidth());
        setHeight(playerFrame.sprite.getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
        levelLabel = new Label(String.valueOf(PlayerStats.getLEVEL()), new Label.LabelStyle(new BitmapFont(), Color.FIREBRICK));
        levelLabel.setFontScale(1.4f);
        PlayerFrame.refreshLevelLabelText();

        nameLabel = new Label(LoadGame.PlayerName, new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        nameLabel.setPosition(108-nameLabel.getWidth()/2, 42-nameLabel.getHeight()/2);

        hp = new HealthBar(136, 14);
        hp.setPosition(42, 18);
        hpLabel = new Label(PlayerStats.getHEALTH()+" / "+PlayerStats.getMaxHEALTH(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        hpLabel.setSize(hpLabel.getPrefWidth(), hpLabel.getPrefHeight());
        hpLabel.setPosition(-hpLabel.getWidth()/2+110, -hpLabel.getHeight()/2+25);

        mana = new ManaBar(136, 14);
        mana.setPosition(42, 1);
        manaLabel = new Label(PlayerStats.getMANA()+" / "+PlayerStats.getMaxMANA(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        manaLabel.setSize(manaLabel.getPrefWidth(), hpLabel.getPrefHeight());
        manaLabel.setPosition(-manaLabel.getWidth()/2+110, -manaLabel.getHeight()/2+8);
        levelLabel.setTouchable(Touchable.disabled);

        expBar = new ExpBar();
        expBar.setPosition(35, 55);
        expBar.rotateBy(180);


        addActor(expBar);
        addActor(levelLabel);
        addActor(nameLabel);
        addActor(hp);
        addActor(playerFrame);
        addActor(mana);
        addActor(hpLabel);
        addActor(manaLabel);
        playerFrame.setZIndex(3);
        expBar.setZIndex(1);
        hp.setZIndex(1);
        levelLabel.setZIndex(4);
        mana.setZIndex(0);
        nameLabel.setZIndex(5);
        Actor actor = new Actor();
        actor.setTouchable(Touchable.enabled);
        actor.setName("exp Bar");
        actor.setPosition(-20, 0);
        actor.setBounds(getX(), getY(), expBar.getWidth(), expBar.getHeight());
        addActor(actor);
        actor.setZIndex(9999);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
        playerFrame.setPosition(getX(), getY());
    }


    public static void refreshLevelLabelText() {
        levelLabel.setText(PlayerStats.getLEVEL());
        levelLabel.setSize(levelLabel.getPrefWidth(), levelLabel.getPrefHeight());
        levelLabel.setPosition(-levelLabel.getWidth()/2+4, levelLabel.getHeight()/2-2);
    }
    public static void refreshHp(){
        hp.max = PlayerStats.getMaxHEALTH();
        if(PlayerStats.getHEALTH() > PlayerStats.getMaxHEALTH())
            PlayerStats.setHEALTH(PlayerStats.getMaxHEALTH());
        hp.setValue(PlayerStats.getHEALTH());
        hpLabel.setText(PlayerStats.getHEALTH()+" / "+PlayerStats.getMaxHEALTH());
        hpLabel.setSize(hpLabel.getPrefWidth(), hpLabel.getPrefHeight());
        hpLabel.setPosition(-hpLabel.getWidth()/2+110, -hpLabel.getHeight()/2+25);
    }

    public static void refreshMana(){
        if(PlayerStats.getMANA() > PlayerStats.getMaxMANA())
            PlayerStats.setMANA(PlayerStats.getMaxMANA());
        mana.setValue(PlayerStats.getMANA());
        manaLabel.setText(PlayerStats.getMANA()+" / "+PlayerStats.getMaxMANA());
        manaLabel.setSize(manaLabel.getPrefWidth(), hpLabel.getPrefHeight());
        manaLabel.setPosition(-manaLabel.getWidth()/2+110, -manaLabel.getHeight()/2+8);

    }

    public static void refreshExp() {
        expBar.setValue(PlayerStats.getEXP(), PlayerStats.getExpToNextLevel());
    }

    public static void refreshPlayerFrame(){
        refreshHp();
        refreshExp();
        refreshMana();
        refreshLevelLabelText();
    }




    private class ActorSprite extends Actor {
        Sprite sprite = new Sprite(new Texture(Gdx.files.internal("img/ui/player_frame.png")));
        public ActorSprite() {
            sprite.setScale(1.4f);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            sprite.draw(batch);
        }
    }
}
