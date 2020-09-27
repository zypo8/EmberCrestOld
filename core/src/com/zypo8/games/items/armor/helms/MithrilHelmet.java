package com.zypo8.games.items.armor.helms;

import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.armor.SetPart;
import com.zypo8.games.items.armor.SetsBonusses;
import com.zypo8.games.items.armor.SlotType;

public class MithrilHelmet extends SetPart {
    public MithrilHelmet(Location location) {
        super("img/placeHolders/mithrilHelm.png", 3, SlotType.Head, ItemRarity.UnCommon, location, "Mithril Helmet");
        armor = 19;
        description.setText("19 Armor");
        setBonus = SetsBonusses.MithrilSet;
        setBuff = new MithrilSetBonusEffect();
    }
}
