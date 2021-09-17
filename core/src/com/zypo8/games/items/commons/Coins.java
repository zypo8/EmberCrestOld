package com.zypo8.games.items.commons;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.items.Item;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.InventoryWindow;

public class Coins extends Item {
    private Label coinsLabel;
    private final int count;
    public Coins(int count, ItemLocation itemLocation) {
        super(Assets.coin, 30, ItemRarity.Common, itemLocation, "Coins");
        this.count = count;
        description.setText(count);
    }

    @Override
    public void itemHoverWindow(Window window, Skin skin) {
        coinsLabel = new Label(count+"", Tools.getSkin());
        if(count > 1000 && count < 1000000)
            coinsLabel = new Label(count+"", Tools.getSkin());
        if(count >=1000000)
            coinsLabel = new Label(count+"", Tools.getSkin());
        window.add(coinsLabel);
    }

    @Override
    public void itemInteractWindow(Window window, Skin skin) {
        window.add(interactItemButtons.addTakeButton(this));
    }

    @Override
    public void firstOption() {
        take();
    }

    @Override
    public void take() {
        InventoryWindow.addCoins(count);
        HUDStage.lastClickedSlot.removeItem();
    }
}
