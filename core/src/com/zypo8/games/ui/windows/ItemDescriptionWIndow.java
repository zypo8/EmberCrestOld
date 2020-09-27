package com.zypo8.games.ui.windows;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;


public class ItemDescriptionWIndow extends Window {
    private WindowStyle windowStyle;
    public ItemDescriptionWIndow(String title, Skin skin) {
        super(title, skin);
        setMovable(true);
        setSize(230, 50);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());

    }

    public ItemDescriptionWIndow(String title, Skin skin, Color color){
        this(title, skin);
        windowStyle = getStyle();
        windowStyle.titleFontColor = color;
        setStyle(windowStyle);
    }
}
