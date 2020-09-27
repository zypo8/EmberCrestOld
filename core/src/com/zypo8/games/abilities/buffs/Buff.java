package com.zypo8.games.abilities.buffs;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.Item;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;

public class Buff extends Item {
    public boolean dontSave;
    //public ArrayList<BuffsFlags> buffsFlags;

    public Buff(String spriteFIle, int itemID, boolean isDeBuff, String name, boolean dontSave){
        this(spriteFIle, itemID, isDeBuff, name);
        this.dontSave = dontSave;
    }
    public Buff(String spriteFIle, int itemID, boolean isDeBuff, String name) {
        super(spriteFIle, itemID, name);
        this.isDeBuff = isDeBuff;
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
        PlayerFrame.refreshMana();
        PlayerFrame.refreshHp();
    }

    public void dispel() {
        System.out.println("superclass method used, ERROR\n BUFF EFFECT ISNT REMOVED");
    }

    //public void modifyDmagageDdne(){}
    //public void modifyDamageTaken(){}

}
