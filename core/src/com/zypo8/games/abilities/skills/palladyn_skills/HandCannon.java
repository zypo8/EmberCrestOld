package com.zypo8.games.abilities.skills.palladyn_skills;

import com.zypo8.games.abilities.buffs.buffs.Hardeness;
import com.zypo8.games.abilities.skills.Skill;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;

public class HandCannon extends Skill {
    public HandCannon() {
        super("img/ability/Slash.png", "img/ability/Slash_inactive.png", 44, "Hand Cannon");
        description.setText("buff: +10 Intelect");
        setManaCost(17);
    }

    @Override
    public void abilityEffect() {
        System.out.println("Hand Cannon Used");
        if(!Buffbar.addItem(new InventorySlot(new Hardeness(), 1))){
            PlayerStats.setMANA(PlayerStats.getMANA() + manaCost);
        }
    }
}
