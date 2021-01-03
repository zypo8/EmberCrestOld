package com.zypo8.games.items;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.LoadScreen;
import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.abilities.skills.Skill;
import com.zypo8.games.actors.npc.Vendor;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.armor.SlotType;
import com.zypo8.games.items.commons.Coins;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;
import com.zypo8.games.ui.windows.InteractItemButtons;
import com.zypo8.games.ui.windows.InventoryWindow;
import com.zypo8.games.ui.windows.ItemDescriptionWIndow;

import static java.lang.StrictMath.min;

public class Item extends Group {

    //stats
    public int Dexterity = 0, Intellect = 0, Strenght = 0, Vitality = 0, HELATH = 0;
    public int armor = 0, armorPiercing = 0, crit= 0, attackPower = 0, focus = 0;
    public int Dexteritypercentage, Intellectpercentage, Strenghtpercentage, Vitalitypercentage;
    public int armorpercentage, armorPiercingpercentage, critpercentage, attackPowerpercentage, focuspercentage;

    //normal things
    protected InteractItemButtons interactItemButtons;
    protected ItemRarity itemRarity = ItemRarity.Common;
    protected ItemLocation itemLocation = ItemLocation.Inventory;
    protected int vendorPrice = 100;
    protected SlotType slotType;
    protected int stackAmount = 20;
    protected int itemID;
    public Sprite sprite;
    protected Label description = new Label("", new Label.LabelStyle(new BitmapFont(), Color.GREEN));
    public int Desc_Window_Height = 60;
    protected int CD;
    public boolean selected;
    public ItemDescriptionWIndow itemDescriptionWIndow;

    //talent and buff extension
    public boolean isLocked;
    public boolean isDeBuff;



    // for eqipable items
    public Item(AssetDescriptor activeSprite, int itemID, ItemRarity itemRarity, ItemLocation itemLocation, SlotType slotType, String name) {
        this(activeSprite, itemID, itemRarity, itemLocation, name);
        this.slotType = slotType;
        stackAmount = 1;
    }

    // for normal items
    public Item(AssetDescriptor activeSprite, int itemID, ItemRarity itemRarity, ItemLocation itemLocation, String name){
        this(activeSprite, itemID, itemRarity, name);
        this.itemLocation = itemLocation;
    }

    public Item(AssetDescriptor activeSprite, int itemID, ItemRarity itemRarity, String name){
        this.itemRarity = itemRarity;
        setName(name);
        sprite = new Sprite((Texture) LoadScreen.assetManager.get(activeSprite));
        this.itemID = itemID;
        this.setTouchable(Touchable.disabled);
        this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

        interactItemButtons = new InteractItemButtons(Tools.getSkin());
        setUpHoverWindow();

    }


    public Item(AssetDescriptor activeSprite, int itemID, String name) {
        setName(name);
        sprite = new Sprite((Texture) LoadScreen.assetManager.get(activeSprite));
        this.itemID = itemID;
        this.setTouchable(Touchable.disabled);
        this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

        interactItemButtons = new InteractItemButtons(Tools.getSkin());
        setUpHoverWindow();
        //addActor(itemDescriptionWIndow);

    }
    public void firstOption(){
        if(itemLocation == ItemLocation.Vendor){
            buy(1); ////////////////???????????? HERE IS BUG
        }
        else if (itemLocation == ItemLocation.Loot) {
            take();
        }
        else if (itemLocation == ItemLocation.Equiped) {
            unequip();
        }
        else if(itemLocation == ItemLocation.Inventory || itemLocation == ItemLocation.ActionBar){
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
        if(itemLocation == ItemLocation.ActionBar){
            removeFromActionBar();
        }
        if(itemLocation == ItemLocation.Inventory){
            addToActionBar();
        }
    }

    //This one YOU DO NOT TOUCH !!!!
    public void itemInteractWindow(Window window, Skin skin){
        window.getTitleLabel().setStyle(new Label.LabelStyle(new BitmapFont(), itemRarity.getColor()));
        if(itemLocation == ItemLocation.Sold){
            window.setHeight(70);
            window.add(interactItemButtons.addBuyBack(this));
            window.row();
            window.add(interactItemButtons.BTNinfo(this));
        }
        if(itemLocation == ItemLocation.Vendor){
            window.setHeight(70);
            window.add(interactItemButtons.addBuy(this));
            window.row();
            window.add(interactItemButtons.BTNinfo(this));

        }
        if (itemLocation == ItemLocation.Loot) {
            window.setHeight(70);
            window.add(interactItemButtons.addTakeButton(this));
            window.row();
            window.add(interactItemButtons.BTNinfo(this));
        }

        if (itemLocation == ItemLocation.Equiped) {
            window.setHeight(70);
            window.add(interactItemButtons.addUnequipItem(this));
            window.row();
            window.add(interactItemButtons.BTNinfo(this));
        }
        if(itemLocation == ItemLocation.ActionBar){
            setUpButtons(window, skin);
            window.setHeight(window.getHeight()+35);
            window.add(interactItemButtons.addRemoveFromActionBar(this));
            window.row();
            window.add(interactItemButtons.BTNinfo(this));
        }
        if(itemLocation == ItemLocation.Inventory){
            setUpButtons(window, skin);
            if(Player.playerInteractNPC instanceof Vendor && ((Vendor)Player.playerInteractNPC).getVendorWindow().isVisible()) {
                window.setHeight(window.getHeight() + 75);
                window.add(interactItemButtons.addSellOne(this));
                window.row();
                window.add(interactItemButtons.addSell(this));
                window.row();
                window.add(interactItemButtons.addSellAll(this));
                window.row();
            }
            else {
                window.setHeight(window.getHeight() + 35);
                window.add(interactItemButtons.addAddToActionBar(this));
                window.row();
            }
            window.add(interactItemButtons.BTNinfo(this));
        }
    }

    // THis method is the one you override to create interact window
    public void setUpButtons(Window window, Skin skin) {
    }

    public void setUpHoverWindow(){
        itemDescriptionWIndow = new ItemDescriptionWIndow(getName(), Tools.getSkin());
        itemDescriptionWIndow.getTitleLabel().setStyle(new Label.LabelStyle(new BitmapFont(), itemRarity.getColor()));

        if(Strenght != 0){
            if(Strenghtpercentage != 0)
                itemDescriptionWIndow.add(new Label(((Strenght > 0) ? " +" : " ") + Strenght+" Str + " + Strenghtpercentage + "%", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            else
                itemDescriptionWIndow.add(new Label(((Strenght > 0) ? " +" : " ")+Strenght+" Str", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
        if(Intellect != 0){
            if(Intellectpercentage != 0)
                itemDescriptionWIndow.add(new Label(((Intellect > 0) ? " +" : " ") + Intellect+" Int + " + Intellectpercentage + "%", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            else
                itemDescriptionWIndow.add(new Label(((Intellect > 0) ? " +" : " ")+Intellect+" Int", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
        if(Dexterity != 0){
            if(Dexteritypercentage != 0)
                itemDescriptionWIndow.add(new Label(((Dexterity > 0) ? " +" : " ") + Dexterity+" Dex + " + Dexteritypercentage + "%", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            else
                itemDescriptionWIndow.add(new Label(((Dexterity > 0) ? " +" : " ")+Dexterity+" Dex", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
        if(Vitality != 0){
            if(Vitalitypercentage != 0)
                itemDescriptionWIndow.add(new Label(((Vitality > 0) ? " +" : " ") + Vitality+" Vit + " + Vitalitypercentage + "%", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            else
                itemDescriptionWIndow.add(new Label(((Vitality > 0) ? " +" : " ")+Vitality+" Vit", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
        if(HELATH != 0){
            itemDescriptionWIndow.add(new Label(((HELATH > 0) ? " +" : " ")+HELATH+" HP", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
        if(armor != 0){
            if(armorpercentage != 0)
                itemDescriptionWIndow.add(new Label(((armor > 0) ? " +" : " ") + armor+" armor + " + armorpercentage + "%", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            else
                itemDescriptionWIndow.add(new Label(((armor > 0) ? " +" : " ")+armor+" armor", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
        if(armorPiercing != 0){
            if(armorPiercingpercentage != 0)
                itemDescriptionWIndow.add(new Label(((armorPiercing > 0) ? " +" : " ") + armorPiercing+" armor piercing + " + armorPiercingpercentage + "%", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            else
                itemDescriptionWIndow.add(new Label(((armorPiercing > 0) ? " +" : " ")+armorPiercing+" armor piercing", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
        if(crit != 0){
            if(critpercentage != 0)
                itemDescriptionWIndow.add(new Label(((crit > 0) ? " +" : " ") + crit+" crit + " + critpercentage + "%", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            else
                itemDescriptionWIndow.add(new Label(((crit > 0) ? " +" : " ")+crit+" crit", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
        if(attackPower != 0){
            if(attackPowerpercentage != 0)
                itemDescriptionWIndow.add(new Label(((attackPower > 0) ? " +" : " ") + attackPower+" attack power + " + attackPowerpercentage + "%", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            else
                itemDescriptionWIndow.add(new Label(((attackPower > 0) ? " +" : " ")+attackPower+" attack power", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
        if(focus != 0){
            if(focuspercentage != 0)
                itemDescriptionWIndow.add(new Label(((focus > 0) ? " +" : " ") + focus+" focus + " + focuspercentage + "%", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            else
                itemDescriptionWIndow.add(new Label(((focus > 0) ? " +" : " ")+focus+" focus", new Label.LabelStyle(new BitmapFont(), Color.YELLOW))).expand().left();
            itemDescriptionWIndow.row();
            Desc_Window_Height += 20;
        }
//        if(this instanceof SetPart && ((SetPart)this).getSetBonus() != null){
//            ArrayList<String> itemsNames = new ArrayList<>(11);
//            for(int i:((SetPart)this).getSetBonus().getSetItemsRequired()) {
//                if (i > 0)
//                    //itemsNames.add(Items.getItemById(i, ItemLocation.Inventory).getName());       /// nieskonczona petla
//            }
//            System.out.println(itemsNames);
//            return;
//
//        }

        itemDescriptionWIndow.setVisible(false);
        itemDescriptionWIndow.add(description);
        itemDescriptionWIndow.row();
        if(itemLocation == ItemLocation.Sold) {
            itemDescriptionWIndow.add(new Label("Buy Back Price: " + vendorPrice / 3, new Label.LabelStyle(new BitmapFont(), Color.GOLD))).expand().right();
            itemDescriptionWIndow.setHeight(Desc_Window_Height+20);
            return;
        }
        if(this instanceof Coins || this instanceof Skill)
            return;
        if(this instanceof Buff && ((Buff)this).buffType != null){
            itemDescriptionWIndow.add(new Label(((Buff)this).buffType.getString(), new Label.LabelStyle(new BitmapFont(), Color.CORAL))).expand().right();
            itemDescriptionWIndow.setHeight(Desc_Window_Height+20);
            return;
        }else if(this instanceof Buff) return;

        itemDescriptionWIndow.add(new Label(((itemLocation == ItemLocation.Vendor) ? " Buy Price: "+vendorPrice + " coins" : " Sell Price: "+vendorPrice/4 + " coins"), new Label.LabelStyle(new BitmapFont(), Color.GOLD))).expand().right();
        itemDescriptionWIndow.setHeight(Desc_Window_Height+20);
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
        PlayerFrame.refreshPlayerFrame();
        System.out.println(PlayerStats.getEXP() +" "+ PlayerStats.getExpToNextLevel());
        System.out.println(PlayerStats.getHEALTH() + " Health \n"+ PlayerStats.getEXP()+" EXP");
    }

    public void use(){
        System.out.println("Nothing interesting happens.");
    }

    public void addToActionBar(){
        if(Actionbar.addItem(HUDStage.lastClickedSlot)) {
            HUDStage.lastClickedSlot.removeItem();
            System.out.println(HUDStage.lastClickedSlot);
            itemLocation = ItemLocation.ActionBar;
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Actionbar is full");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }

    }
    public void addToActionBar(int id){
        if(Actionbar.addItem(new InventorySlot(Items.getItemById(id, ItemLocation.ActionBar), 1))) {
            System.out.println(HUDStage.lastClickedSlot);
            itemLocation = ItemLocation.ActionBar;
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
            itemLocation = ItemLocation.Inventory;
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
    }

    public void equip(){
        itemLocation = ItemLocation.Equiped;
    }

    public void take(){
        if(InventoryWindow.addItem(HUDStage.lastClickedSlot)) {
            HUDStage.lastClickedSlot.removeItem();
            System.out.println(HUDStage.lastClickedSlot);
            itemLocation = ItemLocation.Inventory;
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Inventory is full");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }

    }

    public void buy(int amount){
        if(amount == 0)return;
        if(InventoryWindow.coins >= vendorPrice*amount) {

            System.out.println(HUDStage.lastClickedSlot);
            if(InventoryWindow.addItem( new InventorySlot(Items.getItemById(HUDStage.lastClickedSlot.getItem().getItemID(), ItemLocation.Inventory), amount))){
                InventoryWindow.removeCoins(vendorPrice*amount);
                System.out.println(HUDStage.lastClickedSlot.getItem() +" Bought");
            }
            else {
                HUD.warningLabel.clearActions();
                HUD.warningLabel.addAction(Actions.alpha(1, 0));
                HUD.warningLabel.setText("Inventory is Full");
                HUD.warningLabel.addAction(Actions.alpha(0, 4));
            }
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Not Enough Coins");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }
    }

    public void buyback(){
        if(InventoryWindow.coins >= vendorPrice*HUDStage.lastClickedSlot.getAmount()/3) {

            System.out.println(HUDStage.lastClickedSlot);
            if(InventoryWindow.addItem( new InventorySlot(Items.getItemById(HUDStage.lastClickedSlot.getItem().getItemID(), ItemLocation.Inventory), HUDStage.lastClickedSlot.getAmount()))){
                InventoryWindow.removeCoins(vendorPrice*HUDStage.lastClickedSlot.getAmount()/3);
                System.out.println(HUDStage.lastClickedSlot.getItem() +" Bought back");
                HUDStage.lastClickedSlot.removeItem();
            }
            else {
                HUD.warningLabel.clearActions();
                HUD.warningLabel.addAction(Actions.alpha(1, 0));
                HUD.warningLabel.setText("Inventory is Full");
                HUD.warningLabel.addAction(Actions.alpha(0, 4));
            }
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Not Enough Coins");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }
    }

    public void sell(int amount){
        if(amount < 1)
            return;
        amount = min(amount, HUDStage.lastClickedSlot.amount);
        if(Player.playerInteractNPC instanceof Vendor){
            Vendor vendor = (Vendor)Player.playerInteractNPC;
            vendor.getVendorWindow().addItem(new InventorySlot(Items.getItemById(HUDStage.lastClickedSlot.getItem().getItemID(), ItemLocation.Sold), amount));
            InventoryWindow.addCoins((int) HUDStage.lastClickedSlot.getItem().vendorPrice/4*amount);
            HUDStage.lastClickedSlot.amount -= amount;
            if(HUDStage.lastClickedSlot.amount < 1)
                HUDStage.lastClickedSlot.removeItem();
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
    public ItemLocation getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(ItemLocation itemLocation) {
        this.itemLocation = itemLocation;
    }



    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
        super.positionChanged();
    }

    public void BTNinfo() {
        System.out.println("INFO: "+this.getItemLocation()+ HUDStage.lastClickedSlot.amount);
    }
    public ItemDescriptionWIndow getItemDescriptionWIndow() {
        return itemDescriptionWIndow;
    }




}
