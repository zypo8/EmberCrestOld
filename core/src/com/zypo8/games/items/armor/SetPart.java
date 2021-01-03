package com.zypo8.games.items.armor;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;

public class SetPart extends Armor {
    public int setPartId;
    public SetsBonusses setBonus;
    public Buff setBuff;
    public SetPart(AssetDescriptor activeSprite, int itemID, SlotType slotType, ItemRarity itemRarity, ItemLocation itemLocation, String name) {
        super(activeSprite, itemID, slotType, itemRarity, itemLocation, name);
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
