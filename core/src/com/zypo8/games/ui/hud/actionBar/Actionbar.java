package com.zypo8.games.ui.hud.actionBar;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.items.InventorySlot;

public class Actionbar extends Group {
    public static int freeSpace = 12;
    public static Array<InventorySlot> inventorySlots;
    private Table table;

    public Actionbar(){
        setTouchable(Touchable.enabled);
        inventorySlots = new Array<>(true, 12);
        setBounds(getX(), getY(), getWidth(), getHeight());
        for(int i=0;i<12;i++)
            inventorySlots.add(new InventorySlot());
        table= new Table();
        table.setFillParent(true);
        for(int i=0;i<12;i++)
            table.add(inventorySlots.get(i));
        addActor(table);
    }

    public static boolean addItem(InventorySlot lastClickedSlot) {
        for (int i = 0;i < inventorySlots.size;i++){
            if(inventorySlots.get(i).getItem() == null)
                continue;
            if (lastClickedSlot.getItem().getItemID() == inventorySlots.get(i).getItem().getItemID()){
                if(inventorySlots.get(i).getAmount()+lastClickedSlot.getAmount() <= inventorySlots.get(i).getItem().getStackAmount()) {
                    inventorySlots.get(i).setAmount(inventorySlots.get(i).getAmount() + lastClickedSlot.getAmount());
                    return true;
                }
            }
        }
        for (int i = 0;i < inventorySlots.size;i++){
            if (inventorySlots.get(i).getItem() == null){
                inventorySlots.get(i).setItem(lastClickedSlot.getItem());
                inventorySlots.get(i).setAmount(lastClickedSlot.getAmount());
                return true;
            }
        }
        return false;
    }
}
