package com.zypo8.games.items.armor.legs;

import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.armor.SetPart;
import com.zypo8.games.items.armor.SetsBonusses;
import com.zypo8.games.items.armor.SlotType;

public class MithrilLegplates extends SetPart {
    public MithrilLegplates(Location location) {
        super("img/placeHolders/mithril_legs.png", 11, SlotType.Legs, ItemRarity.Common, location, "mithril leggs");
        armor = 21;
        setBonus = SetsBonusses.MithrilSet;
        setBuff = new MithrilSetBonusEffect();
    }
}
