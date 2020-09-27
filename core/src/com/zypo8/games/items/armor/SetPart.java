package com.zypo8.games.items.armor;

import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;

public class SetPart extends Armor {
    public int setPartId;
    public SetsBonusses setBonus;
    public Buff setBuff;
    public SetPart(String spriteFIle, int itemID, SlotType slotType, ItemRarity itemRarity, Location location, String name) {
        super(spriteFIle, itemID, slotType, itemRarity, location, name);
    }

    public void applySetBonus(){

    }
    public void dispelSetBonus(){

    }

    public SetsBonusses getSetBonus() {
        return setBonus;
    }

    public void setSetBonus(SetsBonusses setBonus) {
        this.setBonus = setBonus;
    }
    public Buff getSetBuff() {
        return setBuff;
    }

    public void setSetBuff(Buff setBuff) {
        this.setBuff = setBuff;
    }

}
