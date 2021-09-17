package com.zypo8.games.items.armor;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Item;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;
import com.zypo8.games.ui.windows.EquipmentWindow;
import com.zypo8.games.ui.windows.InventoryWindow;

public class Armor extends Item {
    private final InventorySlot tempSlot = new InventorySlot();
    public Armor(AssetDescriptor activeSprite, int itemID, SlotType slotType, ItemRarity itemRarity, ItemLocation itemLocation, String name) {
        super(activeSprite, itemID, itemRarity, name);
        this.slotType = slotType;
        this.itemLocation = itemLocation;
        stackAmount = 1;
    }


    @Override
    public void setUpButtons(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactItemButtons.addUseButton(this));
        window.row();
        window.add(interactItemButtons.addDropButton(this));
        window.row();
        window.add(interactItemButtons.addEquipButton(this));
        window.row();
    }

    @Override
    public void setUpFirstOption() {
            equip();
    }

    @Override
    public void equip() {
        switch (this.slotType) {
            case Head:
                if (EquipmentWindow.headSlot.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.headSlot.setItem(this);
                    EquipmentWindow.headSlot.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.headSlot.getItem());

                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
            case Boots:
                if (EquipmentWindow.bootsSlot.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.bootsSlot.setItem(this);
                    EquipmentWindow.bootsSlot.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.bootsSlot.getItem());
                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
            case Ring:
                if (EquipmentWindow.fingerSlot.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.fingerSlot.setItem(this);
                    EquipmentWindow.fingerSlot.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.fingerSlot.getItem());
                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
            case Shoulders:
                if (EquipmentWindow.shoulderSlot.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.shoulderSlot.setItem(this);
                    EquipmentWindow.shoulderSlot.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.shoulderSlot.getItem());
                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
            case Legs:
                if (EquipmentWindow.legsSlot.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.legsSlot.setItem(this);
                    EquipmentWindow.legsSlot.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.legsSlot.getItem());
                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
            case Gloves:
                if (EquipmentWindow.glovesSlot.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.glovesSlot.setItem(this);
                    EquipmentWindow.glovesSlot.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.glovesSlot.getItem());
                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
            case MainHand:
                if (EquipmentWindow.mainHand.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.mainHand.setItem(this);
                    EquipmentWindow.mainHand.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.mainHand.getItem());
                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
            case Offhand:
                if (EquipmentWindow.offHand.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.offHand.setItem(this);
                    EquipmentWindow.offHand.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.offHand.getItem());
                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
            case Chest:
                if (EquipmentWindow.chestSlot.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.chestSlot.setItem(this);
                    EquipmentWindow.chestSlot.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.chestSlot.getItem());
                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
            case Neck:
                if (EquipmentWindow.neckSlot.getItem() == null) {
                    addStats(this);
                    System.out.println(getName() + " Equiped");
                    EquipmentWindow.neckSlot.setItem(this);
                    EquipmentWindow.neckSlot.setAmount(1);
                    if(HUDStage.lastClickedSlot != null)
                        HUDStage.lastClickedSlot.removeItem();
                    itemLocation = ItemLocation.Equiped;
                    setBonusCompute(EquipmentWindow.neckSlot.getItem());
                } else {
                    HUD.warningLabel.clearActions();
                    HUD.warningLabel.addAction(Actions.alpha(1, 0));
                    HUD.warningLabel.setText("That slot is not empty");
                    HUD.warningLabel.addAction(Actions.alpha(0, 4));
                }
                break;
        }
        Player.equipmentWindow.refreshStats();
        PlayerFrame.refreshPlayerFrame();
    }

    @Override
    public boolean unequip() {
        if(InventoryWindow.addItem(HUDStage.lastClickedSlot)){
            System.out.println(this+" unequiped");
            removeStats(this);
            if(HUDStage.lastClickedSlot.getItem() instanceof SetPart){
                for(InventorySlot inventorySlot:Buffbar.inventorySlots){
                    if(inventorySlot.getItem() != null)
                        if(inventorySlot.getItem().getItemID() == ( (SetPart) HUDStage.lastClickedSlot.getItem()).getSetBuff().getItemID()) {
                            InventorySlot tempSlot = HUDStage.lastClickedSlot;
                            HUDStage.lastClickedSlot = inventorySlot;
                            ((Buff)inventorySlot.getItem()).itemInteractWindow(null, null);
                            HUDStage.lastClickedSlot = tempSlot;
                        }
                }
            }

            HUDStage.lastClickedSlot.removeItem();
            //location = Location.Inventory;
            Player.equipmentWindow.refreshStats();
            PlayerFrame.refreshPlayerFrame();
            return true;
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Inventory is Full");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
            Player.equipmentWindow.refreshStats();
            return false;
        }
    }
    private void removeStats(Item item) {
        PlayerStats.setArmor(PlayerStats.getArmor()-item.armor);
        PlayerStats.setCrit(PlayerStats.getCrit()-item.crit);
        PlayerStats.setFocus(PlayerStats.getFocus()-item.focus);
        PlayerStats.setArmorPiercing(PlayerStats.getArmorPiercing()-item.armorPiercing);
        PlayerStats.setAttackPower(PlayerStats.getAttackPower()-item.attackPower);


        //primary
        PlayerStats.setVitality(PlayerStats.getVitality()-item.Vitality);
        PlayerStats.setDexterity(PlayerStats.getDexterity()-item.Dexterity);
        PlayerStats.setStrenght(PlayerStats.getStrenght()-item.Strenght);
        PlayerStats.setIntellect(PlayerStats.getIntellect()-item.Intellect);
        PlayerStats.setMaxHEALTH(PlayerStats.getMaxHEALTH()-item.HELATH);

        //procentage
        PlayerStats.setArmorpercentage(PlayerStats.getArmorpercentage()-item.armorpercentage);
        PlayerStats.setArmorPiercingpercentage(PlayerStats.getArmorPiercingpercentage()-item.armorPiercingpercentage);
        PlayerStats.setCritpercentage(PlayerStats.getCritpercentage()-item.critpercentage);
        PlayerStats.setFocuspercentage(PlayerStats.getFocuspercentage()-item.focuspercentage);
        PlayerStats.setAttackPowerpercentage(PlayerStats.getAttackPowerpercentage()-item.attackPowerpercentage);
        PlayerStats.setVitalitypercentage(PlayerStats.getVitalitypercentage()-item.Vitalitypercentage);
        PlayerStats.setIntellectpercentage(PlayerStats.getIntellectpercentage()-item.Intellectpercentage);
        PlayerStats.setStrenghtpercentage(PlayerStats.getStrenghtpercentage()-item.Strenghtpercentage);
        PlayerStats.setDexteritypercentage(PlayerStats.getDexteritypercentage()-item.Dexteritypercentage);
    }

    private void addStats(Item item) {
        System.out.println(item.getName()+ "  "+item.Strenghtpercentage);
        //secondary
        PlayerStats.setArmor(PlayerStats.getArmor()+item.armor);
        PlayerStats.setCrit(PlayerStats.getCrit()+item.crit);
        PlayerStats.setFocus(PlayerStats.getFocus()+item.focus);
        PlayerStats.setArmorPiercing(PlayerStats.getArmorPiercing()+item.armorPiercing);
        PlayerStats.setAttackPower(PlayerStats.getAttackPower()+item.attackPower);


        //primary
        PlayerStats.setVitality(PlayerStats.getVitality()+item.Vitality);
        PlayerStats.setDexterity(PlayerStats.getDexterity()+item.Dexterity);
        PlayerStats.setStrenght(PlayerStats.getStrenght()+item.Strenght);
        PlayerStats.setIntellect(PlayerStats.getIntellect()+item.Intellect);
        PlayerStats.setMaxHEALTH(PlayerStats.getMaxHEALTH()+item.HELATH);


        //procentage
        PlayerStats.setArmorpercentage(PlayerStats.getArmorpercentage()+item.armorpercentage);
        PlayerStats.setArmorPiercingpercentage(PlayerStats.getArmorPiercingpercentage()+item.armorPiercingpercentage);
        PlayerStats.setCritpercentage(PlayerStats.getCritpercentage()+item.critpercentage);
        PlayerStats.setFocuspercentage(PlayerStats.getFocuspercentage()+item.focuspercentage);
        PlayerStats.setAttackPowerpercentage(PlayerStats.getAttackPowerpercentage()+item.attackPowerpercentage);
        PlayerStats.setVitalitypercentage(PlayerStats.getVitalitypercentage()+item.Vitalitypercentage);
        PlayerStats.setIntellectpercentage(PlayerStats.getIntellectpercentage()+item.Intellectpercentage);
        PlayerStats.setStrenghtpercentage(PlayerStats.getStrenghtpercentage()+item.Strenghtpercentage);
        PlayerStats.setDexteritypercentage(PlayerStats.getDexteritypercentage()+item.Dexteritypercentage);
    }


    private void setBonusCompute(Item item){
        if(item instanceof SetPart){
            System.out.println("Equiped SetPart");
            Array<Integer> requiredItemsIds = new Array<>( true, ((SetPart)item).getSetBonus().getSetItemsRequired(), 0, 10);
            Array<Boolean> setItemsEquiped = checkSetItemsEquiped(requiredItemsIds);
            System.out.println(requiredItemsIds+ "\n"+ setItemsEquiped);
            if(!setItemsEquiped.contains(false, true)){
                System.out.println("SET COMPLETED");
                Buffbar.addItem(new InventorySlot(((SetPart)item).getSetBuff(), 1));
            }
        }
    }
    private Array<Boolean> checkSetItemsEquiped(Array<Integer> requiredItemsIds){
        Array<Boolean> tempArray = new Array<>(10);
        for(int id: requiredItemsIds){
            Boolean breakbool = false;
            if(id == -1){
                tempArray.add(true);
                continue;
            }
            for(InventorySlot inventorySlot: EquipmentWindow.inventorySlots){
                if(inventorySlot.getItem() != null){
                    if(inventorySlot.getItem() instanceof SetPart){
                        if(inventorySlot.getItem().getItemID() == id) {
                            tempArray.add(true);
                            breakbool = true;
                        }
                    }
                }
            }
            if(breakbool)
                continue;
            tempArray.add(false);
        }
        return tempArray;
    }
}
