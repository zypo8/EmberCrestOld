package com.zypo8.games.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Tools {
    public static Skin skin;
    public static Skin getSkin(){
        skin = new Skin(Gdx.files.internal("skin/metal-ui.json"));
        //skin = new Skin(Gdx.files.internal("vis/skin/x1/uiskin.json"));
        return skin;
    }
}
