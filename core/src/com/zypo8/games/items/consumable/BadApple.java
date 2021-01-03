package com.zypo8.games.items.consumable;


import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.abilities.buffs.buffs.Sickness;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.ui.hud.buff_bar.DeBuffbar;

public class BadApple extends Consumable {

    public BadApple(ItemLocation itemLocation) {
        super(Assets.bad_apple, 6, ItemRarity.Legendary, itemLocation, "BadApple");
        description.setText("Damage for 27 health");
        vendorPrice = 27;
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
        System.out.println("damage for 27");
        Player.DamagePlayer(27);
        DeBuffbar.addItem(new InventorySlot(new Sickness(), 1));
        super.consume();
    }

}
