package com.zypo8.games.ui.hud.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zypo8.games.ui.Tools;

public class InfoWindow extends Window {
    private final Drawable BackgroundImage;
    private Label label;
    public InfoWindow(String text, Color fontColor) {
        this(text);
    }

    public InfoWindow(String text) {
        super("", Tools.getSkin());
        BackgroundImage = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/InfoWindowBG.png"))));
        label = new Label(text, new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
        setWidth(label.getPrefWidth()+25);
        setHeight(label.getPrefHeight()+20);
        setBounds(getX(), getY(), getWidth(), getHeight());
        addActor(label);
        label.setAlignment(1);
        setTouchable(Touchable.disabled);
        setBounds(getX(), getY(), getWidth(),getHeight());
        setBackground(BackgroundImage);
    }
    public InfoWindow(int width, int height) {
        super("", Tools.getSkin());
        BackgroundImage = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/InfoWindowBG.png"))));
        setWidth(width);
        setHeight(height);
        setTouchable(Touchable.disabled);
        setBounds(getX(), getY(), getWidth(),getHeight());
        setBackground(BackgroundImage);
    }
    public InfoWindow(Group actor, float width, float height){
        super("", Tools.getSkin());
        BackgroundImage = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/InfoWindowBG.png"))));
        setTouchable(Touchable.enabled);
        addActor(actor);
        setWidth(width);
        setHeight(height);
        actor.setPosition(getWidth()/2-actor.getWidth()/2, getHeight()/2-actor.getHeight()/2);
        setBounds(getX(), getY(), getWidth(),getHeight());
        setBackground(BackgroundImage);
    }

    public void setText(String text){
        label.setText(text);
        setWidth(label.getPrefWidth()+25);
        setHeight(label.getPrefHeight()+20);
        setBounds(getX(), getY(), getWidth(), getHeight());
        label.setAlignment(1);
    }



}
