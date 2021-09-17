package com.zypo8.games.ui.windows;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.equipmentSystem.BootsSlot;
import com.zypo8.games.items.equipmentSystem.ChestSlot;
import com.zypo8.games.items.equipmentSystem.CostamSlot;
import com.zypo8.games.items.equipmentSystem.FingerSlot;
import com.zypo8.games.items.equipmentSystem.GlovesSlot;
import com.zypo8.games.items.equipmentSystem.HeadSlot;
import com.zypo8.games.items.equipmentSystem.LegsSlot;
import com.zypo8.games.items.equipmentSystem.MainSlot;
import com.zypo8.games.items.equipmentSystem.NeckSlot;
import com.zypo8.games.items.equipmentSystem.OffSlot;
import com.zypo8.games.items.equipmentSystem.ShoulderSlot;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.tools.SpriteActor;
import com.zypo8.games.ui.hud.tools.WindowWithTopRightCornerCloseButton;


public class EquipmentWindow extends WindowWithTopRightCornerCloseButton {
    public static Array<InventorySlot> inventorySlots;
    public static HeadSlot headSlot;
    public static NeckSlot neckSlot;
    public static ShoulderSlot shoulderSlot;
    public static CostamSlot costamSlot;
    public static ChestSlot chestSlot;
    public static LegsSlot legsSlot;
    public static BootsSlot bootsSlot;
    public static GlovesSlot glovesSlot;
    public static FingerSlot fingerSlot;
    public static MainSlot mainHand;
    public static OffSlot offHand;
    public static Group PrimaryStatContainer, SecondaryStatContainer, GatheringBars, CraftingBars;
    private Table eqtable;


    public Label vitalityLabel, dexterityLabel, intellectLabel, strenghtLabel, armorLabel, armorPiercingLabel, critLabel, attackPowerLabel, focusLabel;

    public EquipmentWindow() {
        super("", Tools.getSkin());
        setMovable(true);
        setSize(250, 450);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        inventorySlots = new Array<>(true, 11);
        slotInit();
        setUpLabels();
        setUpStatCointainers();
        setUpProfesonBars();
        setUpTable();
        addActor(eqtable);
    }

    private void setUpProfesonBars() {
    }

    private void setUpStatCointainers() {
        PrimaryStatContainer = new Group();
        SecondaryStatContainer = new Group();
        PrimaryStatContainer.setTouchable(Touchable.enabled);
        SecondaryStatContainer.setTouchable(Touchable.enabled);
        PrimaryStatContainer.setBounds(0, 0, 50, 70);
        SecondaryStatContainer.setBounds(0, 0, 50, 70);
        //Primary
        SpriteActor IntellectSprite = new SpriteActor("img/ui/icons/IntellectStat.png");
        SpriteActor StrengthSprite = new SpriteActor("img/placeHolders/asdad.png");
        SpriteActor DextrinitySprite = new SpriteActor("img/placeHolders/asdad.png");
        SpriteActor VitalitySprite = new SpriteActor("img/placeHolders/asdad.png");
        PrimaryStatContainer.addActor(IntellectSprite);
        PrimaryStatContainer.addActor(StrengthSprite);
        PrimaryStatContainer.addActor(DextrinitySprite);
        PrimaryStatContainer.addActor(VitalitySprite);
        PrimaryStatContainer.addActor(intellectLabel);
        PrimaryStatContainer.addActor(strenghtLabel);
        PrimaryStatContainer.addActor(dexterityLabel);
        PrimaryStatContainer.addActor(vitalityLabel);
        IntellectSprite.setPosition(0, 72);
        StrengthSprite.setPosition(0, 48);
        DextrinitySprite.setPosition(0, 24);
        VitalitySprite.setPosition(0, 0);
        intellectLabel.setPosition(20, 72+intellectLabel.getPrefHeight()/2);
        strenghtLabel.setPosition(20, 48+strenghtLabel.getPrefHeight()/2);
        dexterityLabel.setPosition(20, 24+dexterityLabel.getPrefHeight()/2);
        vitalityLabel.setPosition(20, 0+vitalityLabel.getPrefHeight()/2);

        //Secondary
        SpriteActor ArmorSprite = new SpriteActor("img/ui/icons/DefenceStat.png");
        SpriteActor ArmorPiercingSprite = new SpriteActor("img/placeHolders/asdad.png");
        SpriteActor CritSprite = new SpriteActor("img/placeHolders/asdad.png");
        SpriteActor FocusSprite = new SpriteActor("img/placeHolders/asdad.png");
        SpriteActor AttackPowerSprite = new SpriteActor("img/placeHolders/asdad.png");
        ArmorSprite.setPosition(-20, 72);
        ArmorPiercingSprite.setPosition(-20, 54);
        CritSprite.setPosition(-20, 36);
        FocusSprite.setPosition(-20, 18);
        AttackPowerSprite.setPosition(-20, 0);
        armorLabel.setPosition(0, 72+armorLabel.getPrefHeight()/2);
        armorPiercingLabel.setPosition(0, 54+armorPiercingLabel.getPrefHeight()/2);
        critLabel.setPosition(0, 36+critLabel.getPrefHeight()/2);
        focusLabel.setPosition(0, 9+focusLabel.getPrefHeight()/2);
        attackPowerLabel.setPosition(0, 0+attackPowerLabel.getPrefHeight()/2);
        SecondaryStatContainer.addActor(ArmorSprite);
        SecondaryStatContainer.addActor(ArmorPiercingSprite);
        SecondaryStatContainer.addActor(CritSprite);
        SecondaryStatContainer.addActor(FocusSprite);
        SecondaryStatContainer.addActor(AttackPowerSprite);
        SecondaryStatContainer.addActor(armorLabel);
        SecondaryStatContainer.addActor(armorPiercingLabel);
        SecondaryStatContainer.addActor(critLabel);
        SecondaryStatContainer.addActor(focusLabel);
        SecondaryStatContainer.addActor(attackPowerLabel);

    }


    private void setUpTable() {
        eqtable = new Table();
        eqtable.setFillParent(true);
        eqtable.setDebug(false);
        eqtable.add(PrimaryStatContainer).expand().padTop(20);
        eqtable.add(headSlot).expand().padTop(20);
        eqtable.add(SecondaryStatContainer).expand().padTop(20);
        eqtable.row();
        eqtable.add(shoulderSlot).expand();
        eqtable.add(neckSlot).expand();
        eqtable.add(costamSlot).expand();
        eqtable.row();
        eqtable.add(glovesSlot).expand();
        eqtable.add(chestSlot).expand();
        eqtable.add(fingerSlot).expand();
        eqtable.row();
        eqtable.add(mainHand).expand();
        eqtable.add(legsSlot).expand();
        eqtable.add(offHand).expand();
        eqtable.row();
        eqtable.add().expand();
        eqtable.add(bootsSlot).expand();
        eqtable.add().expand();

    }

    private void setUpLabels() {
        intellectLabel = new Label("", new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
        dexterityLabel = new Label("", new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
        strenghtLabel = new Label("", new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
        vitalityLabel = new Label("", new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
        armorLabel = new Label("", new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
        armorPiercingLabel = new Label("", new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
        critLabel = new Label("", new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
        attackPowerLabel = new Label("", new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
        focusLabel = new Label(String.valueOf(PlayerStats.getStrenght()), new Label.LabelStyle(new BitmapFont(), new Color(0xc4c118ff)));
    }

    public void refreshStats() {
        if(PlayerStats.getIntellectpercentage() > 0)
            intellectLabel.setText(PlayerStats.getIntellect() + " + " + PlayerStats.getIntellect()*PlayerStats.getIntellectpercentage()/100);
        else if(PlayerStats.getIntellectpercentage() < 0)
            intellectLabel.setText(PlayerStats.getIntellect() + " - " + PlayerStats.getIntellect()*PlayerStats.getIntellectpercentage()/100*-1);
        else intellectLabel.setText(PlayerStats.getIntellect());

        if(PlayerStats.getDexteritypercentage() > 0)
            dexterityLabel.setText(PlayerStats.getDexterity() + " + " + PlayerStats.getDexterity()*PlayerStats.getDexteritypercentage()/100);
        else if(PlayerStats.getDexteritypercentage() < 0)
            dexterityLabel.setText(PlayerStats.getDexterity() + " - " + PlayerStats.getDexterity()*PlayerStats.getDexteritypercentage()/100*-1);
        else dexterityLabel.setText(PlayerStats.getDexterity());

        if(PlayerStats.getStrenghtpercentage() > 0)
            strenghtLabel.setText(PlayerStats.getStrenght() + " + " + PlayerStats.getStrenght()*PlayerStats.getStrenghtpercentage()/100);
        else if(PlayerStats.getStrenghtpercentage() < 0)
            strenghtLabel.setText(PlayerStats.getStrenght() + " - " + PlayerStats.getStrenght()*PlayerStats.getStrenghtpercentage()/100*-1);
        else strenghtLabel.setText(PlayerStats.getStrenght());

        if(PlayerStats.getVitalitypercentage() > 0)
            vitalityLabel.setText(PlayerStats.getVitality() + " + " + PlayerStats.getVitality()*PlayerStats.getVitalitypercentage()/100);
        else if(PlayerStats.getVitalitypercentage() < 0)
            vitalityLabel.setText(PlayerStats.getVitality() + " - " + PlayerStats.getVitality()*PlayerStats.getVitalitypercentage()/100*-1);
        else vitalityLabel.setText(PlayerStats.getVitality());

        if(PlayerStats.getArmorpercentage() > 0)
            armorLabel.setText(PlayerStats.getArmor() + " + " + PlayerStats.getArmor()*PlayerStats.getArmorpercentage()/100);
        else if(PlayerStats.getArmorpercentage() < 0)
            armorLabel.setText(PlayerStats.getArmor() + " - " + PlayerStats.getArmor()*PlayerStats.getArmorpercentage()/100*-1);
        else armorLabel.setText(PlayerStats.getArmor());

        if(PlayerStats.getArmorPiercingpercentage() > 0)
            armorPiercingLabel.setText(PlayerStats.getArmorPiercing() + " + " + PlayerStats.getArmorPiercing()*PlayerStats.getArmorPiercingpercentage()/100);
        else if(PlayerStats.getArmorPiercingpercentage() < 0)
            armorPiercingLabel.setText(PlayerStats.getArmorPiercing() + " - " + PlayerStats.getArmorPiercing()*PlayerStats.getArmorPiercingpercentage()/100*-1);
        else armorPiercingLabel.setText(PlayerStats.getArmorPiercing());

        if(PlayerStats.getCritpercentage() > 0)
            critLabel.setText(PlayerStats.getCrit() + " + " + PlayerStats.getCrit()*PlayerStats.getCritpercentage()/100);
        else if(PlayerStats.getCritpercentage() < 0)
            critLabel.setText(PlayerStats.getCrit() + " - " + PlayerStats.getCrit()*PlayerStats.getCritpercentage()/100*-1);
        else critLabel.setText(PlayerStats.getCrit());

        if(PlayerStats.getAttackPowerpercentage() > 0)
            attackPowerLabel.setText(PlayerStats.getAttackPower() + " + " + PlayerStats.getAttackPower()*PlayerStats.getAttackPowerpercentage()/100);
        else if(PlayerStats.getAttackPowerpercentage() < 0)
            attackPowerLabel.setText(PlayerStats.getAttackPower() + " - " + PlayerStats.getAttackPower()*PlayerStats.getAttackPowerpercentage()/100*-1);
        else attackPowerLabel.setText(PlayerStats.getAttackPower());

        if(PlayerStats.getFocuspercentage() > 0)
            focusLabel.setText(PlayerStats.getFocus() + " + " + PlayerStats.getFocus()*PlayerStats.getFocuspercentage()/100);
        else if(PlayerStats.getFocuspercentage() < 0)
            focusLabel.setText(PlayerStats.getFocus() + " - " + PlayerStats.getFocus()*PlayerStats.getFocuspercentage()/100*-1);
        else focusLabel.setText(PlayerStats.getFocus());

    }

    private void slotInit() {
        headSlot = new HeadSlot();
        neckSlot = new NeckSlot();
        shoulderSlot = new ShoulderSlot();
        costamSlot = new CostamSlot();
        chestSlot = new ChestSlot();
        legsSlot = new LegsSlot();
        glovesSlot = new GlovesSlot();
        fingerSlot = new FingerSlot();
        mainHand = new MainSlot();
        offHand = new OffSlot();
        bootsSlot = new BootsSlot();
        inventorySlots.add(headSlot);
        inventorySlots.add(neckSlot);
        inventorySlots.add(shoulderSlot);
        inventorySlots.add(costamSlot);
        inventorySlots.add(chestSlot);
        inventorySlots.add(legsSlot);
        inventorySlots.add(glovesSlot);
        inventorySlots.add(fingerSlot);
        inventorySlots.add(mainHand);
        inventorySlots.add(offHand);
        inventorySlots.add(bootsSlot);
    }
}
