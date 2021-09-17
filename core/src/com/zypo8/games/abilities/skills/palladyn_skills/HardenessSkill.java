package com.zypo8.games.abilities.skills.palladyn_skills;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.abilities.buffs.buffs.Hardeness;
import com.zypo8.games.abilities.skills.Skill;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;

public class HardenessSkill extends Skill {
    public HardenessSkill() {
        this(ItemLocation.SpellBoock);
    }
    public HardenessSkill(ItemLocation itemLocation) {
        super(Assets.hardeness, Assets.hardeness_inactive, 44, "Hardeness", itemLocation);
        description.setText("buff: +20hp, max 3 charges");
        stackAmount = 1;
        levelReq = 1;
        setManaCost(17);
    }

    @Override
    public void abilityEffect() {
        if(Buffbar.addItem(new InventorySlot(new Hardeness(), 1))){
            System.out.println("Hardeness Used");
        }
    }
}
