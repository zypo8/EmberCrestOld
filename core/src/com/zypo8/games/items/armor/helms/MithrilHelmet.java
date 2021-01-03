package com.zypo8.games.items.armor.helms;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.armor.SetPart;
import com.zypo8.games.items.armor.SetsBonusses;
import com.zypo8.games.items.armor.SlotType;

public class MithrilHelmet extends SetPart {
    public MithrilHelmet(ItemLocation itemLocation) {
        super(Assets.mithril_helm, 3, SlotType.Head, ItemRarity.UnCommon, itemLocation, "Mithril Helmet");
        armor = 19;
        description.setText("19 Armor");
        setBonus = SetsBonusses.MithrilSet;
        setBuff = new MithrilSetBonusEffect();
        vendorPrice = 55;
        setUpHoverWindow();
    }
}
