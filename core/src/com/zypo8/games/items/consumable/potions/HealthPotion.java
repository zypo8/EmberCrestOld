package com.zypo8.games.items.consumable.potions;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.consumable.Consumable;

public class HealthPotion extends Consumable {
    public HealthPotion(Location location) {
        super("img/items/consumable/hp_potion.png", 8, ItemRarity.UnCommon, location, "Health Potion");
        description.setText("regenerates 50 hp");
        vendorPrice = 140;
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
        System.out.println("regenerated 50 hp");
        PlayerStats.setHEALTH(Math.min(PlayerStats.getHEALTH() + 50, PlayerStats.getMaxHEALTH()));
        super.consume();
    }
}
