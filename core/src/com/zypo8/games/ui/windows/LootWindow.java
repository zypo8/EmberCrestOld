package com.zypo8.games.ui.windows;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Item;

public class LootWindow extends Window {
    private Table table;
    private Array<InventorySlot> inventorySlots;
    public LootWindow(String title, Skin skin) {
        super(title, skin);

        final Button closeButton = new TextButton("X", skin);
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                remove();
            }
        });
        getTitleTable().add(closeButton).size(14, 14).padRight(2).padTop(1);

        setClip(false);
        setTransform(true);
        inventorySlots = new Array<InventorySlot>(true, 8);
        setMovable(true);
        setSize(125, 210);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        for (int i=0;i<8;i++)
            inventorySlots.add(new InventorySlot());
        if (table == null)
            setUpTable();
        addActor(table);
    }

    public void addItemToLoot(Item item, int amount){
        for (int i = 0;i < inventorySlots.size;i++){
            if (inventorySlots.get(i).getItem() == null){
                inventorySlots.get(i).setItem(item);
                inventorySlots.get(i).setAmount(amount);
                break;

            }
        }
    }

    private void setUpTable(){
        table = new Table();
        table.setFillParent(true);
        table.add(inventorySlots.get(0)).expand().padTop(25);
        table.add(inventorySlots.get(1)).expand().padTop(25);
        table.row();
        table.add(inventorySlots.get(2)).expand();
        table.add(inventorySlots.get(3)).expand();
        table.row();
        table.add(inventorySlots.get(4)).expand();
        table.add(inventorySlots.get(5)).expand();
        table.row();
        table.add(inventorySlots.get(6)).expand();
        table.add(inventorySlots.get(7)).expand();


    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isVisible() && GameScreen.player.moving){
            remove();
        }
    }

}
