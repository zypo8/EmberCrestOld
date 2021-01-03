package com.zypo8.games.items.armor.legs;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.armor.SetPart;
import com.zypo8.games.items.armor.SetsBonusses;
import com.zypo8.games.items.armor.SlotType;

public class MithrilLegplates extends SetPart {
    public MithrilLegplates(ItemLocation itemLocation) {
        super(Assets.mithril_legs, 11, SlotType.Legs, ItemRarity.Common, itemLocation, "mithril leggs");
        armor = 21;
        setBonus = SetsBonusses.MithrilSet;
        setBuff = new MithrilSetBonusEffect();
        setUpHoverWindow();
    }
}
