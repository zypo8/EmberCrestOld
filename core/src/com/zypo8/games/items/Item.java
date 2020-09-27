package com.zypo8.games.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.armor.SlotType;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;
import com.zypo8.games.ui.windows.InteractItemButtons;
import com.zypo8.games.ui.windows.InventoryWindow;
import com.zypo8.games.ui.windows.ItemDescriptionWIndow;

public class Item extends Group {

    //stats
    public int Dexterity = 0, Intellect = 0, Strenght = 0, Vitality = 0, HELATH = 0;
    public int armor = 0, armorPiercing = 0, crit= 0, attackPower = 0, focus = 0;

    //normal things
    protected InteractItemButtons interactItemButtons;
    protected ItemRarity itemRarity = ItemRarity.Common;
    protected Location location = Location.Inventory;
    protected int vendorPrice = 100;
    protected SlotType slotType;
    protected int stackAmount = 20;
    protected int itemID;
    public Sprite sprite;
    protected Label description = new Label("", Tools.getSkin());
    protected int CD;
    public boolean selected;
    public ItemDescriptionWIndow itemDescriptionWIndow;

    //talent and buff extension
    public boolean isLocked;
    public boolean isDeBuff;



    public Item(String spriteFIle, int itemID, ItemRarity itemRarity, Location location, SlotType slotType, String name) {
        this(spriteFIle, itemID, itemRarity, location, name);
        this.slotType = slotType;
        stackAmount = 1;
    }

    public Item(String spriteFIle, int itemID, ItemRarity itemRarity, Location location, String name){
        this(spriteFIle, itemID, itemRarity, name);
        this.location = location;

    }

    public Item(String spriteFIle, int itemID, ItemRarity itemRarity, String name){
        this(spriteFIle, itemID, name);
        this.itemRarity = itemRarity;

    }


    public Item(String spriteFIle, int itemID, String name) {
        setName(name);
        sprite = new Sprite(new Texture(Gdx.files.internal(spriteFIle)));
        this.itemID = itemID;
        this.setTouchable(Touchable.disabled);
        this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

        interactItemButtons = new InteractItemButtons(Tools.getSkin());
        setUpHoverWindow();
        addActor(itemDescriptionWIndow);

    }
    public void firstOption(){
        if(location == Location.Vendor){
            buy();
        }
        else if (location == Location.Loot) {
            take();
        }

        else if (location == Location.Equiped) {
            unequip();
        }
        else if(location == Location.Inventory || location == Location.ActionBar){
            setUpFirstOption();
        }
    }

    public boolean unequip() {
        return false;
    }

    public void unequip(int id) {
    }


    // This one you override for left click use effect setup
    public void setUpFirstOption() {
        if(location == Location.ActionBar){
            removeFromActionBar();
        }
        if(location == Location.Inventory){
            addToActionBar();
        }
    }

    //This one YOU DO NOT TOUCH !!!!
    public void itemInteractWindow(Window window, Skin skin){
        if(location == Location.Vendor){
            window.setHeight(70);
            window.add(interactItemButtons.addBuy(this));
            window.row();
            window.add(interactItemButtons.BTNinfo(this));

        }
        if (location == Location.Loot) {
            window.setHeight(70);
            window.add(interactItemButtons.addTakeButton(this));window.row();
            window.row();
            window.add(interactItemButtons.BTNinfo(this));
        }

        if (location == Location.Equiped) {
            window.setHeight(70);
            window.add(interactItemButtons.addUnequipItem(this));
            window.row();
            window.add(interactItemButtons.BTNinfo(this));
            //window.add(interactItemButtons.BTNinfo(this));
        }
        if(location == Location.ActionBar){
            setUpButtons(window, skin);
            window.setHeight(window.getHeight()+35);
            window.add(interactItemButtons.addRemoveFromActionBar(this));
            window.row();
            window.add(interactItemButtons.BTNinfo(this));
            //window.add(interactItemButtons.BTNinfo(this));
        }
        if(location == Location.Inventory){
            setUpButtons(window, skin);
            window.setHeight(window.getHeight()+35);
            window.add(interactItemButtons.addAddToActionBar(this));
            window.row();
            window.add(interactItemButtons.BTNinfo(this));
        }
    }

    // THis method is the one you override to create interact window
    public void setUpButtons(Window window, Skin skin) {
    }

    public void setUpHoverWindow(){
        itemDescriptionWIndow = new ItemDescriptionWIndow(getName(), Tools.getSkin());
        itemDescriptionWIndow.setHeight(100);
        itemDescriptionWIndow.add(description);
        itemDescriptionWIndow.setVisible(false);
    }


    public void itemHoverWindow(Window window, Skin skin){
        window.setHeight(100);
        window.add(description);
    }

    public void consume(){
        System.out.println("consumed "+HUDStage.lastClickedSlot.getItem());
        HUDStage.lastClickedSlot.setAmount(HUDStage.lastClickedSlot.getAmount()-1);
        if(HUDStage.lastClickedSlot.getAmount() == 0) {
            HUDStage.lastClickedSlot.removeItem();
        }
        PlayerFrame.refreshHp();
        PlayerFrame.refreshMana();
        System.out.println(PlayerStats.getHEALTH());
    }

    public void use(){
        System.out.println("Nothing interesting happens.");
    }

    public void addToActionBar(){
        if(Actionbar.addItem(HUDStage.lastClickedSlot)) {
            HUDStage.lastClickedSlot.removeItem();
            System.out.println(HUDStage.lastClickedSlot);
            location = Location.ActionBar;
            Actionbar.freeSpace--;
            InventoryWindow.freeSpace++;
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Actionbar is full");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }

    }

    public void removeFromActionBar(){
        if(InventoryWindow.addItemToInventory(HUDStage.lastClickedSlot)){
            HUDStage.lastClickedSlot.removeItem();
            location = Location.Inventory;
            Actionbar.freeSpace++;
            InventoryWindow.freeSpace--;
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Inventory is full");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }

    }

    public void drop(){
        HUDStage.lastClickedSlot.removeItem();
        InventoryWindow.freeSpace++;
    }

    public void equip(){
        location = Location.Equiped;
        InventoryWindow.freeSpace++;
    }

    public void take(){
        if(InventoryWindow.addItem(HUDStage.lastClickedSlot)) {
            HUDStage.lastClickedSlot.removeItem();
            System.out.println(HUDStage.lastClickedSlot);
            location = Location.Inventory;
            InventoryWindow.freeSpace--;
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Inventory is full");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }

    }

    public void buy(){
        if(InventoryWindow.coins >= vendorPrice*HUDStage.lastClickedSlot.getAmount()) {

            System.out.println(HUDStage.lastClickedSlot);
            if(InventoryWindow.addItem( new InventorySlot(Items.getItemById(HUDStage.lastClickedSlot.getItem().getItemID(), Location.Inventory), HUDStage.lastClickedSlot.getAmount()))){
                InventoryWindow.removeCoins(vendorPrice*HUDStage.lastClickedSlot.getAmount());
                InventoryWindow.freeSpace--;
                setLocation(Location.Vendor);
                System.out.println(HUDStage.lastClickedSlot.getItem() +" Bought");
            }
            else {
                HUD.warningLabel.clearActions();
                HUD.warningLabel.addAction(Actions.alpha(1, 0));
                HUD.warningLabel.setText("Inventory is Full");
                HUD.warningLabel.addAction(Actions.alpha(0, 4));
            }



            //location = Location.Vendor;
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Not Enough Coins");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }
    }

    public void select(){
        selected = true;
        System.out.println("selected");
    }


    public void addTalentPoint(){
        System.out.println("Talent Point Added");
    }

    public void removeTalentPoint(){
        System.out.println("Talent Point Added");
    }


    //Getters and Setters
    public int getItemID() {
        return itemID;
    }


    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public int getStackAmount() {
        return stackAmount;
    }

    public void setStackAmount(int stackAmount) {
        this.stackAmount = stackAmount;
    }

    public int getCD() {
        return CD;
    }

    public void setCD(int CD) {
        this.CD = CD;
    }

    public ItemRarity getItemRarity() {
        return itemRarity;
    }

    public void setItemRarity(ItemRarity itemRarity) {
        this.itemRarity = itemRarity;
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
        super.positionChanged();
    }

    public void BTNinfo() {
        System.out.println("INFO: "+this.getLocation()+ HUDStage.lastClickedSlot.amount);
    }
    public ItemDescriptionWIndow getItemDescriptionWIndow() {
        return itemDescriptionWIndow;
    }


}
