package com.zypo8.games.items.consumable.potions;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.consumable.Consumable;

public class ManaPotion extends Consumable {
    public ManaPotion(ItemLocation itemLocation) {
        super(Assets.mana_pot, 7, ItemRarity.UnCommon, itemLocation, "Mana Potion");
        description.setText("Regenerates 15 mana");
        vendorPrice = 175;
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
        System.out.println("regenerated 50 mana");
        PlayerStats.setMANA(Math.min(PlayerStats.getMANA() + 17, PlayerStats.getMaxMANA()));
        super.consume();
    }
}
