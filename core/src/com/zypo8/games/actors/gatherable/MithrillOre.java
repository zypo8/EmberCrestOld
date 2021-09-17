package com.zypo8.games.actors.gatherable;


import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.commons.Coins;
import com.zypo8.games.items.consumable.Apple;
import com.zypo8.games.ui.HUDStage;

public class MithrillOre extends Gatherable {
    public MithrillOre(int posX, int posY, HUDStage hudStage) {
        super(Assets.mithril_ore, posX, posY, hudStage,
                Assets.mithril_ore_inactive, 10, "MithrillOre", 1);
        this.setLevelReq(0);
        this.setExpRewqrd(14);
    }

    @Override
    protected void addItemsToLootWindow() {
        lootWindow.getTitleLabel().setText("MithrillOre");
        lootWindow.addItemToLoot(new Apple(ItemLocation.Loot), 2);
        lootWindow.addItemToLoot(new Coins(400, ItemLocation.Loot), 1);
    }

}
