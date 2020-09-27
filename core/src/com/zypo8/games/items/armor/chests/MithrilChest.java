package com.zypo8.games.items.armor.chests;

import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.armor.SetPart;
import com.zypo8.games.items.armor.SetsBonusses;
import com.zypo8.games.items.armor.SlotType;

public class MithrilChest extends SetPart {
    public MithrilChest(Location location) {
        super("img/placeHolders/mithril_chest.png", 9, SlotType.Chest, ItemRarity.Common, location, "mithril chest");
        armor = 16;
        setBonus = SetsBonusses.MithrilSet;
        setBuff = new MithrilSetBonusEffect();
    }
}
