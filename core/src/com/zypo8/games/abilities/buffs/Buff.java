package com.zypo8.games.abilities.buffs;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.abilities.BuffType;
import com.zypo8.games.items.Item;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;

public class Buff extends Item {
    public boolean dontSave;
    public BuffType buffType = BuffType.Other;

    public Buff(AssetDescriptor activeSprite, int itemID, boolean isDeBuff, String name, boolean dontSave){
        this(activeSprite, itemID, isDeBuff, name);
        this.dontSave = dontSave;
    }
    public Buff(AssetDescriptor activeSprite, int itemID, boolean isDeBuff, String name) {
        super(activeSprite, itemID, name);
        this.isDeBuff = isDeBuff;

    }

    @Override
    public void firstOption() {
    }

    @Override
    public void itemInteractWindow(Window window, Skin skin) {
        if(!isDeBuff) {
            System.out.println("Dispeling"+ getName());
            dispel();
            if(HUDStage.lastClickedSlot.getAmount() > 1)
                HUDStage.lastClickedSlot.setAmount(HUDStage.lastClickedSlot.getAmount()-1);
            else
                HUDStage.lastClickedSlot.removeItem();
        }
        PlayerFrame.refreshPlayerFrame();
    }

    public void dispel() {
        System.out.println("superclass method used, ERROR\n BUFF EFFECT ISNT REMOVED");
    }

}
