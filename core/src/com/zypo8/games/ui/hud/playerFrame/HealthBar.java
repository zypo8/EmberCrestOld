package com.zypo8.games.ui.hud.playerFrame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.ui.hud.tools.ProgressBar2;

public class HealthBar extends ProgressBar2 {

    /**
     * @param width of the health bar
     * @param height of the health bar
     */
    public HealthBar(int width, int height) {
        super(0f, PlayerStats.getMaxHEALTH(), 1, false, new ProgressBar.ProgressBarStyle());
        getStyle().knob = GetDrawableBar.getColoredDrawable(0, height, new Color(0x2CA120ff));
        getStyle().knobBefore = GetDrawableBar.getColoredDrawable(width, height, new Color(0x2CA120ff));

        setWidth(width);
        setHeight(height);

        setAnimateDuration(1.0f);
        setValue(PlayerStats.getHEALTH());

        setAnimateDuration(0.25f);
    }
}