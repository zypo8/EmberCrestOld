package com.zypo8.games.abilities.skills.palladyn_skills;

import com.zypo8.games.abilities.buffs.buffs.Hardeness;
import com.zypo8.games.abilities.skills.Skill;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;

public class HardenessSkill extends Skill {
    public HardenessSkill() {
        super("img/ability/hardeness.png", "img/ability/hardeness.png", 44, "Hardeness");
        description.setText("buff: +20hp, max 3 charges");
        setManaCost(17);
    }

    @Override
    public void abilityEffect() {
        if(!Buffbar.addItem(new InventorySlot(new Hardeness(), 1))){
            System.out.println("Hardeness Used");
            PlayerStats.setMANA(PlayerStats.getMANA() + manaCost);
        }
    }
}
