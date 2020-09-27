package com.zypo8.games.ui.hud.tools;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Window which features the close button in top right corner (button moved outside of the window bounds).
 *
 * @author serhiy
 */
public class WindowWithTopRightCornerCloseButton extends Window {
    public WindowWithTopRightCornerCloseButton(String title, Skin skin) {
        super(title, skin);

        final Button closeButton = new TextButton("X", skin);
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setVisible(false);
            }
        });
        getTitleTable().add(closeButton).size(14, 14).padRight(2).padTop(1);

        setClip(false);
        setTransform(true);
    }
}