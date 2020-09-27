package com.zypo8.games.actors.gatherable;


import com.zypo8.games.items.Location;
import com.zypo8.games.items.commons.Coins;
import com.zypo8.games.items.consumable.Apple;
import com.zypo8.games.ui.HUDStage;

public class MithrillOre extends Gatherable {
    public MithrillOre(int posX, int posY, HUDStage hudStage) {
        super("img/gatherable/mithrilOre/mithril_active.png", posX, posY, hudStage,
                "img/gatherable/mithrilOre/mithril_inactive.png", 10, "MithrillOre", 1);
        this.setLevelReq(0);
    }

    @Override
    protected void addItemsToLootWindow() {
        lootWindow.getTitleLabel().setText("MithrillOre");
        lootWindow.addItemToLoot(new Apple(Location.Loot), 2);
        lootWindow.addItemToLoot(new Coins(1000, Location.Loot), 1);
    }

}
