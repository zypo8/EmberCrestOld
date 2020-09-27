package com.zypo8.games.items.equipmentSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Item;
import com.zypo8.games.items.armor.SlotType;

public class BootsSlot extends InventorySlot {
    public BootsSlot() {
        super(SlotType.Boots);
        backgroundImage = new Sprite(new Texture(Gdx.files.internal("img/ui/HeadSlotBGimg.png")));
    }

    @Override
    public void setItem(Item item) {
        if(item.getSlotType() == SlotType.Boots)
            super.setItem(item);
        else {
            System.out.println("You are not able to wear it.");
        }
    }
}