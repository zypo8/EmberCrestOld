package com.zypo8.games.abilities.buffs.buffs;

import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.actors.player.PlayerStats;

public class Sickness extends Buff {
    public Sickness() {
        super("img/ability/thunder.png", 20, true, "Sickness");
        stackAmount = 1;
        description.setText("-15 to armor");
        armor = -15;
    }

    @Override
    public void use() {
        PlayerStats.setArmor(PlayerStats.getArmor()+armor);
    }

    @Override
    public void dispel() {
        PlayerStats.setArmor(PlayerStats.getArmor()-armor);
    }
}
