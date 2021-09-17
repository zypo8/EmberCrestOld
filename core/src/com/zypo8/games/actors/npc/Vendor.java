package com.zypo8.games.actors.npc;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.actors.player.Character;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.armor.boots.MithrilBoots;
import com.zypo8.games.items.armor.chests.MithrilChest;
import com.zypo8.games.items.armor.helms.BrokenHelmet;
import com.zypo8.games.items.armor.helms.MithrilHelmet;
import com.zypo8.games.items.armor.legs.MithrilLegplates;
import com.zypo8.games.items.armor.necks.EmeraldNeck;
import com.zypo8.games.items.consumable.Apple;
import com.zypo8.games.items.consumable.BadApple;
import com.zypo8.games.items.consumable.potions.ExpPotion;
import com.zypo8.games.items.consumable.potions.HealthPotion;
import com.zypo8.games.items.consumable.potions.ManaPotion;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.VendorWindow;

public class Vendor extends Character {
    private VendorWindow vendorWindow;

    public Vendor(int posX, int posY, HUDStage hudStage) {
        super(Assets.player, posX, posY, hudStage, "Vendor");
        vendorWindowSetUp();
    }

    private void vendorWindowSetUp() {
        vendorWindow = new VendorWindow(getName(), Tools.getSkin());
        vendorWindow.addItem(new InventorySlot(new Apple(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new BrokenHelmet(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new EmeraldNeck(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new MithrilHelmet(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new BadApple(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new ManaPotion(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new HealthPotion(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new MithrilLegplates(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new MithrilChest(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new MithrilBoots(ItemLocation.Vendor), 1));
        vendorWindow.addItem(new InventorySlot(new ExpPotion(ItemLocation.Vendor), 1));


        hudStage.addActor(vendorWindow);
        vendorWindow.setVisible(false);
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        if(vendorWindow.isVisible() && GameScreen.player.moving) {
            vendorWindow.setVisible(false);
            //Interact WIndow removing so that player can not sell item to vendor with whom player isnt interaacting
            if(hudStage.window != null)
                hudStage.window.remove();
        }
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

