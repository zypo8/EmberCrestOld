package com.zypo8.games.items.armor.chests;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.armor.SetPart;
import com.zypo8.games.items.armor.SetsBonusses;
import com.zypo8.games.items.armor.SlotType;

public class MithrilChest extends SetPart {
    public MithrilChest(ItemLocation itemLocation) {
        super(Assets.mithril_chest, 9, SlotType.Chest, ItemRarity.Common, itemLocation, "mithril chest");
        armor = 16;
        setBonus = SetsBonusses.MithrilSet;
        setBuff = new MithrilSetBonusEffect();
        vendorPrice = 183;
        description.setText("");
        setUpHoverWindow();
    }
}
