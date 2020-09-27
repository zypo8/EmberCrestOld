package com.zypo8.games.items.consumable;

import com.zypo8.games.items.Item;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;

public class Consumable extends Item {

    public Consumable(String spriteFIle, int itemID, ItemRarity itemRarity, Location location, String name) {
        super(spriteFIle, itemID, itemRarity, location, name);
        stackAmount = 20;
        vendorPrice = 200;
    }

    @Override
    public void setUpFirstOption() {
        consume();
    }
}
