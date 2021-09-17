package com.zypo8.games.abilities.skills.palladyn_skills;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.abilities.buffs.buffs.FreshMind;
import com.zypo8.games.abilities.skills.Skill;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;

public class HandCannon extends Skill {
    public HandCannon() {
        this(ItemLocation.SpellBoock);
    }

    public HandCannon(ItemLocation itemLocation) {
        super(Assets.slash, Assets.slash_inactive, 45, "Hand Cannon", itemLocation);
        description.setText("buff: +10 Intelect");
        setManaCost(17);
    }

    @Override
    public void abilityEffect() {
        if(Buffbar.addItem(new InventorySlot(new FreshMind(), 1))){
            System.out.println("Fresh Mind Used");
        }
    }
}
