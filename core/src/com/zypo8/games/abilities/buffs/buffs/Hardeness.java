package com.zypo8.games.abilities.buffs.buffs;

import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;

public class Hardeness extends Buff {
    public Hardeness() {
        super("img/ability/hardeness.png", 47, false, "Hardeness");
        stackAmount = 3;
        description.setText("+20 max health");
    }

    @Override
    public void use() {
        PlayerStats.setMaxHEALTH(PlayerStats.getMaxHEALTH()+20);
    }

    @Override
    public void dispel() {
        PlayerStats.setMaxHEALTH(PlayerStats.getMaxHEALTH()-20);
        PlayerFrame.refreshHp();
    }
}
