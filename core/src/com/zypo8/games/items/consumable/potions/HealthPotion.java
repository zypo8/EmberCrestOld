package com.zypo8.games.items.consumable.potions;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.consumable.Consumable;

public class HealthPotion extends Consumable {
    public HealthPotion(ItemLocation itemLocation) {
        super(Assets.hp_pot, 8, ItemRarity.UnCommon, itemLocation, "Health Potion");
        description.setText("regenerates 50 hp");
        vendorPrice = 140;
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
        System.out.println("regenerated 50 hp");
        Player.HealPlayer(999999999);
        super.consume();
    }
}
