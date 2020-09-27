package com.zypo8.games.abilities.buffs.buffs;

import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.actors.player.PlayerStats;

public class MithrilSetBonusEffect extends Buff {
    public MithrilSetBonusEffect() {
        super("img/placeHolders/mithril_set_bonus.png", 27, false, "MithrilSetBonus");
        stackAmount = 1;
        setName("Mithril set bonus");
        description.setText("+ 11% str");
        dontSave = true;

    }

    @Override
    public void use() {
        PlayerStats.setStrenghtpercentage(PlayerStats.getStrenghtpercentage()+11);
    }
}
