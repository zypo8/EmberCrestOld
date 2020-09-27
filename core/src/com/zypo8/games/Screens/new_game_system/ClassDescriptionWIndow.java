package com.zypo8.games.Screens.new_game_system;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class ClassDescriptionWIndow extends Window {
    public ClassDescriptionWIndow(String title, Skin skin) {
        super(title, skin);
        setMovable(true);
        setSize(180, 180);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());

    }
}
