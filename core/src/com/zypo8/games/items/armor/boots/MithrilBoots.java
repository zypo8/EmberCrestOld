package com.zypo8.games.items.armor.boots;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.armor.SetPart;
import com.zypo8.games.items.armor.SetsBonusses;
import com.zypo8.games.items.armor.SlotType;

public class MithrilBoots extends SetPart {
    public MithrilBoots(ItemLocation itemLocation) {
        super(Assets.mithril_boots, 10, SlotType.Boots, ItemRarity.Common, itemLocation, "Mithril boots");
        armor = 7;
        setBonus = SetsBonusses.MithrilSet;
        setBuff = new MithrilSetBonusEffect();
        vendorPrice = 29;
        setUpHoverWindow();
    }
}
