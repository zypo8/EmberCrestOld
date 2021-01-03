package com.zypo8.games.ui.hud.buff_bar;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.InventorySlot;

public class Buffbar extends Group {
    public static Array<InventorySlot> inventorySlots;
    private final Table table;

    public Buffbar(){
        setTouchable(Touchable.enabled);
        inventorySlots = new Array<>(true, 18);
        for(int i=0;i<18;i++) {
            inventorySlots.add(new InventorySlot(false));
        }
        table= new Table();
        table.setFillParent(true);
        for(int i=0;i<18;i++) {
            table.add(inventorySlots.get(i)).padTop(15).padRight(7).padLeft(7);
            if((i+1)%9==0)
                table.row();
        }
        addActor(table);

    }

    public static boolean addItem(InventorySlot lastClickedSlot) {
        for (int i = 0;i < inventorySlots.size;i++){
            if(inventorySlots.get(i).getItem() == null)
                continue;
            if (lastClickedSlot.getItem().getItemID() == inventorySlots.get(i).getItem().getItemID()){
                if(inventorySlots.get(i).getAmount()+lastClickedSlot.getAmount() <= inventorySlots.get(i).getItem().getStackAmount()) {
                    inventorySlots.get(i).setAmount(inventorySlots.get(i).getAmount() + lastClickedSlot.getAmount());
                    lastClickedSlot.getItem().use();
                    Player.getEquipmentWindow().refreshStats();
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        for (int i = 0;i < inventorySlots.size;i++){
            if (inventorySlots.get(i).getItem() == null){
                inventorySlots.get(i).setItem(lastClickedSlot.getItem());
                inventorySlots.get(i).setAmount(lastClickedSlot.getAmount());
                GameScreen.hud.hudStage.addActor(lastClickedSlot.getItem().getItemDescriptionWIndow());
                lastClickedSlot.getItem().use();
                Player.getEquipmentWindow().refreshStats();
                return true;
            }
        }
        return false;
    }
}
