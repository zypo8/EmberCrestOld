package com.zypo8.games.ui.hud.playerFrame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.ui.hud.tools.ProgressBar2;

public class ManaBar extends ProgressBar2 {

    /**
     * @param width of the health bar
     * @param height of the health bar
     */
    public ManaBar(int width, int height) {
        super(0f, PlayerStats.getMaxMANA(), 0.01f, false, new ProgressBar.ProgressBarStyle());
        getStyle().knob = GetDrawableBar.getColoredDrawable(0, height, new Color(0x346FF5ff));
        getStyle().knobBefore = GetDrawableBar.getColoredDrawable(width, height, new Color(0x346FF5ff));

        setWidth(width);
        setHeight(height);

        setAnimateDuration(0.0f);
        setValue(PlayerStats.getMANA());

        setAnimateDuration(0.25f);
    }
}