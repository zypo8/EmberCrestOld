package com.zypo8.games.items.armor.boots;

import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.armor.SetPart;
import com.zypo8.games.items.armor.SetsBonusses;
import com.zypo8.games.items.armor.SlotType;

public class MithrilBoots extends SetPart {
    public MithrilBoots(Location location) {
        super("img/placeHolders/mithril_boots.png", 10, SlotType.Boots, ItemRarity.Common, location, "Mithril boots");
        armor = 7;
        setBonus = SetsBonusses.MithrilSet;
        setBuff = new MithrilSetBonusEffect();
    }
}
