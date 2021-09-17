package com.zypo8.games.items.armor.helms;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.armor.Armor;
import com.zypo8.games.items.armor.SlotType;

public class BrokenHelmet extends Armor {
    public BrokenHelmet(ItemLocation itemLocation) {
        super(Assets.broken_helmet, 4, SlotType.Head, ItemRarity.Common, itemLocation, "Broken Helmet");
        armor = 3;
        vendorPrice = 18;
        setUpHoverWindow();
    }
}
