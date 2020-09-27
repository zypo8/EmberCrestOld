package com.zypo8.games.items.consumable;


import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;

public class BadApple extends Consumable {

    public BadApple(Location location) {
        super("img/items/consumable/item_bad_apple.png", 6, ItemRarity.Legendary, location, "BadApple");

        description.setText("Damage for 27 health");
        vendorPrice = 27;
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
        System.out.println("damage for 27");
        PlayerStats.setHEALTH(PlayerStats.getHEALTH()-27);
        super.consume();
    }

}
