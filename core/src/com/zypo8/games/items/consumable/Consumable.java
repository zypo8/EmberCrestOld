package com.zypo8.games.items.consumable;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.zypo8.games.items.Item;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;

public class Consumable extends Item {

    public Consumable(AssetDescriptor activeSprite, int itemID, ItemRarity itemRarity, ItemLocation itemLocation, String name) {
        super(activeSprite, itemID, itemRarity, itemLocation, name);
        stackAmount = 20;
        vendorPrice = 200;
    }

    @Override
    public void setUpFirstOption() {
        consume();
    }
}
