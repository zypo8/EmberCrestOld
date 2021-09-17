package com.zypo8.games.abilities.buffs.buffs;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.abilities.BuffType;
import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;

public class FreshMind extends Buff {
    public FreshMind() {
        super(Assets.thunder, 48, false, "FreshMind");
        stackAmount = 2;
        buffType = BuffType.Magic;
        description.setText("+11 intellect");
        setUpHoverWindow();
    }

    @Override
    public void use() {
        PlayerStats.setIntellect(PlayerStats.getIntellect()+11);
    }

    @Override
    public void dispel() {
        PlayerStats.setIntellect(PlayerStats.getIntellect()-11);
        PlayerFrame.refreshPlayerFrame();
    }
}
