package com.zypo8.games.actors.npc;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.actors.player.Character;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.armor.boots.MithrilBoots;
import com.zypo8.games.items.armor.chests.MithrilChest;
import com.zypo8.games.items.armor.helms.BrokenHelmet;
import com.zypo8.games.items.armor.helms.MithrilHelmet;
import com.zypo8.games.items.armor.legs.MithrilLegplates;
import com.zypo8.games.items.armor.necks.EmeraldNeck;
import com.zypo8.games.items.consumable.Apple;
import com.zypo8.games.items.consumable.BadApple;
import com.zypo8.games.items.consumable.potions.HealthPotion;
import com.zypo8.games.items.consumable.potions.ManaPotion;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.VendorWindow;

public class Vendor extends Character {
    private VendorWindow vendorWindow;

    public Vendor(int posX, int posY, HUDStage hudStage) {
        super("img/characters/player.gif", posX, posY, hudStage, "Vendor");
        vendorWindowSetUp();
    }

    private void vendorWindowSetUp() {
        vendorWindow = new VendorWindow(getName(), Tools.getSkin());
        vendorWindow.addItem(new InventorySlot(new Apple(Location.Vendor), 10));
        vendorWindow.addItem(new InventorySlot(new BrokenHelmet(Location.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new EmeraldNeck(Location.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new MithrilHelmet(Location.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new BadApple(Location.Vendor), 5));
        vendorWindow.addItem(new InventorySlot(new ManaPotion(Location.Vendor), 2));
        vendorWindow.addItem(new InventorySlot(new HealthPotion(Location.Vendor), 2));
        vendorWindow.addItem(new InventorySlot(new MithrilLegplates(Location.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new MithrilChest(Location.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new MithrilBoots(Location.Vendor), 1));


        hudStage.addActor(vendorWindow);
        vendorWindow.setVisible(false);
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        if(vendorWindow.isVisible() && GameScreen.player.moving)
            vendorWindow.setVisible(false);
        }

    public void firstOptionPositionRequirement() {
        showVendor();
    }

    @Override
    public void interactWindow(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactButtons.addVendorButton(this));
        window.row();
        window.add(interactButtons.addTalkButton(this));
    }

    @Override
    public void showVendor() {
        super.showVendor();
        vendorWindow.setVisible(true);
    }

    @Override
    public void talk() {
        super.talk();
    }

    //getters and setters
    public VendorWindow getVendorWindow() {
        return vendorWindow;
    }

    public void setVendorWindow(VendorWindow vendorWindow) {
        this.vendorWindow = vendorWindow;
    }
}

