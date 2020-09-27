package com.zypo8.games.ui.hud.playerFrame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.ui.hud.tools.ProgressBar2;

public class ExpBar extends ProgressBar2 {
    public ExpBar() {
        super(PlayerStats.getEXP(), 100, 0.01f, true, new ProgressBar.ProgressBarStyle());
        setWidth(58);
        setHeight(58);
        setBounds(getX(), getY(), getWidth(), getHeight());
        //getStyle().background = GetDrawableArc.getColoredDrawable(26, Color.BLACK);
        getStyle().knob = GetDrawableArc.getColoredDrawable(0, new Color(0x32cfc7ff));
        getStyle().knobBefore = GetDrawableArc.getColoredDrawable(29, new Color(0x32cfc7ff));
        getStyle().background = GetDrawableArc.getColoredDrawable(29, Color.DARK_GRAY);
        //getStyle(). = GetDrawableArc.getColoredDrawable(29, new Color(0x91cdcaff));

        setValue(50);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("dupa");
            }
        });

    }
}
