package com.zypo8.games.items.equipmentSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Item;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.armor.SlotType;

public class ChestSlot extends InventorySlot {
    public ChestSlot() {
        super(SlotType.Chest);
        backgroundImage = new Sprite(new Texture(Gdx.files.internal("img/ui/HeadSlotBGimg.png")));
    }

    @Override
    public void setItem(Item item) {
        if(item.getSlotType() == SlotType.Chest) {
            super.setItem(item);
            item.setLocation(Location.Equiped);
        }
        else {
            System.out.println("You are not able to wear it.");
        }
    }
}