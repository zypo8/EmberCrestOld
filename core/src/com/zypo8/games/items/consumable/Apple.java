package com.zypo8.games.items.consumable;


import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;

public class Apple extends Consumable {

    public Apple(Location location) {
        super("img/items/consumable/item_apple.png", 1, ItemRarity.Legendary, location, "Apple");
        description.setText("Heal 27 health");
        vendorPrice = 23;
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
        System.out.println("heal for 27");
        PlayerStats.setHEALTH(Math.min(PlayerStats.getHEALTH() + 27, PlayerStats.getMaxHEALTH()));
        super.consume();
    }
}
