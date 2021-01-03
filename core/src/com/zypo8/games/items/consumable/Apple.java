package com.zypo8.games.items.consumable;


import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;

public class Apple extends Consumable {

    public Apple(ItemLocation itemLocation) {
        super(Assets.apple, 1, ItemRarity.Legendary, itemLocation, "Apple");
        description.setText("Heal 27 health");
        vendorPrice = 23;
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
        System.out.println("heal for 27"+ itemRarity.getColor());
        //PlayerStats.setHEALTH(Math.min(PlayerStats.getHEALTH() +
        Player.HealPlayer(27);
        super.consume();
    }
}
