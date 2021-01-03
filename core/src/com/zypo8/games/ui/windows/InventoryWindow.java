package com.zypo8.games.ui.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.hud.tools.SpriteActor;
import com.zypo8.games.ui.hud.tools.WindowWithTopRightCornerCloseButton;

public class InventoryWindow extends WindowWithTopRightCornerCloseButton {
    public static Array<InventorySlot> inventorySlots;
    private Table table;
    public static int coins;
    public static Label coinsLabel = new Label(String.valueOf(coins), Tools.getSkin());
    public static SpriteActor coinsSprite = new SpriteActor(new Texture(Gdx.files.internal("img/items/materials/Coin.png")));


    public InventoryWindow() {
        super("", Tools.getSkin());
        setMovable(true);
        setSize(250, 450);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setName("Player Inventory Window");
        setUpCoinsLabel();
        //setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/inv1.png")))));
        //coinsLabelAndSprite.add(coinsLabel);
        coinsSprite.setPosition(35, -coinsSprite.getHeight()/2);
        //coinsLabel.setPosition(0, 0);
        HUD.selectAmountWindow = new SelectAmountWindow(){
            @Override
            public void actionOnOkClick() {
                HUDStage.lastClickedSlot.getItem().sell(selectedAmount);
            }
        };

        inventorySlots = new Array<>(true, 28);
        for (int i=0;i<28;i++)
            inventorySlots.add(new InventorySlot());
        if (table == null)
            setUpTable();
        addActor(table);

    }



    private void setUpTable(){
        table = new Table();
        table.setFillParent(true);
        table.add(coinsSprite).expand().padTop(20).colspan(2).right();
        table.add(coinsLabel).expand().padTop(20).colspan(2).left();
        table.row();
        table.add(inventorySlots.get(0)).expand().padTop(20);
        table.add(inventorySlots.get(1)).expand().padTop(20);
        table.add(inventorySlots.get(2)).expand().padTop(20);
        table.add(inventorySlots.get(3)).expand().padTop(20);
        table.row();
        table.add(inventorySlots.get(4)).expand();
        table.add(inventorySlots.get(5)).expand();
        table.add(inventorySlots.get(6)).expand();
        table.add(inventorySlots.get(7)).expand();
        table.row();
        table.add(inventorySlots.get(8)).expand();
        table.add(inventorySlots.get(9)).expand();
        table.add(inventorySlots.get(10)).expand();
        table.add(inventorySlots.get(11)).expand();
        table.row();
        table.add(inventorySlots.get(12)).expand();
        table.add(inventorySlots.get(13)).expand();
        table.add(inventorySlots.get(14)).expand();
        table.add(inventorySlots.get(15)).expand();
        table.row();
        table.add(inventorySlots.get(16)).expand();
        table.add(inventorySlots.get(17)).expand();
        table.add(inventorySlots.get(18)).expand();
        table.add(inventorySlots.get(19)).expand();
        table.row();
        table.add(inventorySlots.get(20)).expand();
        table.add(inventorySlots.get(21)).expand();
        table.add(inventorySlots.get(22)).expand();
        table.add(inventorySlots.get(23)).expand();
        table.row();
        table.add(inventorySlots.get(24)).expand();
        table.add(inventorySlots.get(25)).expand();
        table.add(inventorySlots.get(26)).expand();
        table.add(inventorySlots.get(27)).expand();
        table.row();

    }

    public static boolean addItem(InventorySlot newInventorySlot){
        System.out.println("Adding "+newInventorySlot.getAmount()+"amount of "+ newInventorySlot.getItem()+" to inventory");
        for (int i = 0;i < inventorySlots.size;i++){
            if(inventorySlots.get(i).getItem() == null)
                continue;
            if (newInventorySlot.getItem().getItemID() == inventorySlots.get(i).getItem().getItemID()){
                if(inventorySlots.get(i).getAmount()+newInventorySlot.getAmount() <= inventorySlots.get(i).getItem().getStackAmount()) {
                    inventorySlots.get(i).setAmount(inventorySlots.get(i).getAmount() + newInventorySlot.getAmount());
                    return true;
                }
            }
        }
        for (int i = 0;i < Actionbar.inventorySlots.size;i++){
            if(Actionbar.inventorySlots.get(i).getItem() == null)
                continue;
            if (newInventorySlot.getItem().getItemID() == Actionbar.inventorySlots.get(i).getItem().getItemID()){
                if(Actionbar.inventorySlots.get(i).getAmount()+newInventorySlot.getAmount() <= Actionbar.inventorySlots.get(i).getItem().getStackAmount()) {
                    Actionbar.inventorySlots.get(i).setAmount(Actionbar.inventorySlots.get(i).getAmount() + newInventorySlot.getAmount());
                    return true;
                }
            }
        }
        for (int i = 0;i < inventorySlots.size;i++){
            if (inventorySlots.get(i).getItem() == null){
                inventorySlots.get(i).setItem(newInventorySlot.getItem());
                inventorySlots.get(i).setAmount(newInventorySlot.getAmount());
                inventorySlots.get(i).getItem().setItemLocation(ItemLocation.Inventory);
                return true;
            }
        }
        for (int i = 0;i < Actionbar.inventorySlots.size;i++){
            if (Actionbar.inventorySlots.get(i).getItem() == null){
                Actionbar.inventorySlots.get(i).setItem(newInventorySlot.getItem());
                Actionbar.inventorySlots.get(i).setAmount(newInventorySlot.getAmount());
                Actionbar.inventorySlots.get(i).getItem().setItemLocation(ItemLocation.ActionBar);
                return true;
            }
        }
        return false;
    }
    public static boolean addItemToInventory(InventorySlot newInventorySlot){
        System.out.println("Adding "+newInventorySlot.getAmount()+"amount of "+ newInventorySlot.getItem()+" to inventory only");
        for (int i = 0;i < inventorySlots.size;i++){
            if(inventorySlots.get(i).getItem() == null)
                continue;
            if (newInventorySlot.getItem().getItemID() == inventorySlots.get(i).getItem().getItemID()){
                if(inventorySlots.get(i).getAmount()+newInventorySlot.getAmount() <= inventorySlots.get(i).getItem().getStackAmount()) {
                    inventorySlots.get(i).setAmount(inventorySlots.get(i).getAmount() + newInventorySlot.getAmount());
                    return true;
                }
            }
        }

        for (int i = 0;i < inventorySlots.size;i++){
            if (inventorySlots.get(i).getItem() == null){
                inventorySlots.get(i).setItem(newInventorySlot.getItem());
                inventorySlots.get(i).setAmount(newInventorySlot.getAmount());
                inventorySlots.get(i).getItem().setItemLocation(ItemLocation.Inventory);
                return true;
            }
        }
        return false;
    }


    public static void addCoins(int newCoins){
        coins += newCoins;
        setUpCoinsLabel();
    }

    private static void setUpCoinsLabel() {

        coinsLabel.setText(coins);
        if(coins >= 10000 && coins < 1000000)
            coinsLabel.setText(coins/1000+"K");
        if(coins >=1000000)
            coinsLabel.setText(coins/1000000+"M");
        //coinsLabel.setAlignment(1);
    }

    public static void removeCoins(int vendorPrice) {
        coins -= vendorPrice;setUpCoinsLabel();
    }

    public static void setCoins(int newCoins) {
        coins = newCoins;
        setUpCoinsLabel();
    }

}
