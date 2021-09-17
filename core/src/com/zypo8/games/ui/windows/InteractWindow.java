package com.zypo8.games.ui.windows;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class InteractWindow extends Window {
    public InteractWindow(String title, Skin skin) {
        super(title, skin);
        setMovable(true);
        setSize(90, 50);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
    }
}
