package com.zypo8.games.ui.windows;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.ui.hud.tools.WindowWithTopRightCornerCloseButton;

public class VendorWindow extends WindowWithTopRightCornerCloseButton {
    private Array<InventorySlot> inventorySlots;
    private Table table;
    public VendorWindow(String title, Skin skin) {
        super(title, skin);

        setMovable(true);
        setSize(460, 280);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setName("Vendor_Window");


        inventorySlots = new Array<>(true, 40);
        for (int i=0;i<40;i++)
            inventorySlots.add(new com.zypo8.games.items.InventorySlot());
        if (table == null)
            setUpTable();
        addActor(table);
//        inventorySlots.get(0).setItem(new MithrilHelmet());
//        inventorySlots.get(0).setAmount(1);
//        inventorySlots.get(0).getItem().setLocation(Location.Vendor);
//
//        inventorySlots.get(1).setItem(new EmeraldNeck());
//        inventorySlots.get(1).setAmount(1);
//        inventorySlots.get(1).getItem().setLocation(Location.Vendor);
    }

    private void setUpTable(){
        table = new Table();
        table.setFillParent(true);
        table.add(inventorySlots.get(0)).expand().padTop(20);
        table.add(inventorySlots.get(1)).expand().padTop(20);
        table.add(inventorySlots.get(2)).expand().padTop(20);
        table.add(inventorySlots.get(3)).expand().padTop(20);
        table.add(inventorySlots.get(4)).expand().padTop(20);
        table.add(inventorySlots.get(5)).expand().padTop(20);
        table.add(inventorySlots.get(6)).expand().padTop(20);
        table.add(inventorySlots.get(7)).expand().padTop(20);
        table.row();
        table.add(inventorySlots.get(8)).expand();
        table.add(inventorySlots.get(9)).expand();
        table.add(inventorySlots.get(10)).expand();
        table.add(inventorySlots.get(11)).expand();
        table.add(inventorySlots.get(12)).expand();
        table.add(inventorySlots.get(13)).expand();
        table.add(inventorySlots.get(14)).expand();
        table.add(inventorySlots.get(15)).expand();
        table.row();
        table.add(inventorySlots.get(16)).expand();
        table.add(inventorySlots.get(17)).expand();
        table.add(inventorySlots.get(18)).expand();
        table.add(inventorySlots.get(19)).expand();
        table.add(inventorySlots.get(20)).expand();
        table.add(inventorySlots.get(21)).expand();
        table.add(inventorySlots.get(22)).expand();
        table.add(inventorySlots.get(23)).expand();
        table.row();
        table.add(inventorySlots.get(24)).expand();
        table.add(inventorySlots.get(25)).expand();
        table.add(inventorySlots.get(26)).expand();
        table.add(inventorySlots.get(27)).expand();
        table.add(inventorySlots.get(28)).expand();
        table.add(inventorySlots.get(29)).expand();
        table.add(inventorySlots.get(30)).expand();
        table.add(inventorySlots.get(31)).expand();
        table.row();
        table.add(inventorySlots.get(32)).expand();
        table.add(inventorySlots.get(33)).expand();
        table.add(inventorySlots.get(34)).expand();
        table.add(inventorySlots.get(35)).expand();
        table.add(inventorySlots.get(36)).expand();
        table.add(inventorySlots.get(37)).expand();
        table.add(inventorySlots.get(38)).expand();
        table.add(inventorySlots.get(39)).expand();
        table.row();

    }

    public void addItem(InventorySlot newInventorySlot){
        for (int i = 0;i < inventorySlots.size;i++){
            if(inventorySlots.get(i).getItem() == null)
                continue;
            if (newInventorySlot.getItem().getItemID() == inventorySlots.get(i).getItem().getItemID()){
                if(inventorySlots.get(i).getAmount()+newInventorySlot.getAmount() <= inventorySlots.get(i).getItem().getStackAmount()) {
                    inventorySlots.get(i).setAmount(inventorySlots.get(i).getAmount() + newInventorySlot.getAmount());
                    return;
                }
            }
        }
        for (int i = 0;i < inventorySlots.size;i++){
            if (inventorySlots.get(i).getItem() == null){
                inventorySlots.get(i).setItem(newInventorySlot.getItem());
                inventorySlots.get(i).setAmount(newInventorySlot.getAmount());
                return;
            }
        }
    }
}
