package com.zypo8.games.items.consumable.potions;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.consumable.Consumable;

public class ExpPotion extends Consumable {
    public ExpPotion(ItemLocation itemLocation) {
        super(Assets.hp_pot, 13, ItemRarity.Rare, itemLocation, "Exp Potion");
        description.setText("gives 50 exp");
        vendorPrice = 500;
        setUpHoverWindow();
    }

    @Override
    public void setUpButtons(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactItemButtons.addConsumeButton(this));
        window.row();
        window.add(interactItemButtons.addDropButton(this));
        window.row();

    }

    @Override
    public void consume() {
        System.out.println("gives 20 exp");
        Player.addExp(20);
        //InventoryWindow.addItem(new InventorySlot(new ExpPotion(ItemLocation.Inventory), 1));
        super.consume();
    }
}
