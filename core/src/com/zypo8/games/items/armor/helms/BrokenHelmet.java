package com.zypo8.games.items.armor.helms;

import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.armor.Armor;
import com.zypo8.games.items.armor.SlotType;

public class BrokenHelmet extends Armor {
    public BrokenHelmet(Location location) {
        super("img/items/armor/broken_helmet.png", 4, SlotType.Head, ItemRarity.Common, location, "Broken Helmet");
        armor = 3;
        description.setText("+3 armor");
    }
}
