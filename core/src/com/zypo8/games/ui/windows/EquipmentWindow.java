package com.zypo8.games.ui.windows;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
import com.zypo8.games.ui.hud.professions.ProfessionBar;
import com.zypo8.games.ui.hud.tools.ExpBarr;
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
    private TextButton buttonSummary, buttonBack;
    private boolean eqShowing = true;

    private Table eqtable, statTable;

    private ExpBarr expBarr;

    public Label LevelLabel, HealthLabel, dexterityLabel, intellectLabel, strenghtLabel, armorLabel, armorPiercingLabel, critLabel, attackPowerLabel;

    public EquipmentWindow() {
        super("Equipment", Tools.getSkin());
        setMovable(true);
        setSize(250, 450);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        inventorySlots = new Array<>(true, 11);
//        for (int i=0;i<11;i++)
//            inventorySlots.add(new InventorySlot());
        slotInit();
        buttonSummary = new TextButton("Stats", Tools.getSkin());
        buttonBack = new TextButton("back", Tools.getSkin());
        buttonSummary.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                buttonSummaryClick();
            }
        });
        buttonBack.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                buttonBackClick();
            }
        });
        expBarr = new ExpBarr();
        expBarr.setValue(30);
        setUpLabels();
        setUpTable();
        addActor(eqtable);
    }

    private void buttonSummaryClick(){
        eqShowing = false;
        removeActor(eqtable);
        addActor(statTable);
    }

    private void buttonBackClick(){
        eqShowing = true;
        removeActor(statTable);
        addActor(eqtable);
    }



    private void setUpTable() {
        eqtable = new Table();
        eqtable.setFillParent(true);
        eqtable.setDebug(false);
        eqtable.add().expand().padTop(20);
        eqtable.add(headSlot).expand().padTop(20);
        eqtable.add().height(20).width(20);
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
        eqtable.add(buttonSummary).width(40);
        eqtable.add(bootsSlot).expand();
        eqtable.add().expand();

        statTable = new Table();
        statTable.setFillParent(true);
        statTable.setDebug(false);
        statTable.add(new Label("Character Level: ", Tools.getSkin())).expand().padTop(25);
        statTable.add(LevelLabel).expand().center().padTop(25);
        statTable.row();
        statTable.add(new Label("Health: ", Tools.getSkin())).expand();
        statTable.add(HealthLabel).expand();
        statTable.row();
        statTable.add(new Label("Intellect: ", Tools.getSkin())).expand();
        statTable.add(intellectLabel).expand();
        statTable.row();
        statTable.add(new Label("Dexterity: ", Tools.getSkin())).expand();
        statTable.add(dexterityLabel).expand();
        statTable.row();
        statTable.add(new Label("Strenght: ", Tools.getSkin())).expand();
        statTable.add(strenghtLabel).expand();
        statTable.row();
        statTable.add(new Label("armor: ", Tools.getSkin())).expand();
        statTable.add(armorLabel).expand();
        statTable.row();
        statTable.add(new Label("armor piercing: ", Tools.getSkin())).expand();
        statTable.add(armorPiercingLabel).expand();
        statTable.row();
        statTable.add(new Label("Crit: ", Tools.getSkin())).expand();
        statTable.add(critLabel).expand();
        statTable.row();
        statTable.add(new Label("attack power: ", Tools.getSkin())).expand();
        statTable.add(attackPowerLabel).expand();
        statTable.row();
        statTable.add(new Label("Gathering: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(PlayerStats.getGatheringLevel()), Tools.getSkin())).expand();
        statTable.row();
        statTable.add(new Label("Crafting: ", Tools.getSkin())).expand();
        statTable.add(new Label(String.valueOf(PlayerStats.getCraftingLevel()), Tools.getSkin())).expand();
        statTable.row();
//        statTable.add(new Label("Armor crafting: ", Tools.getSkin())).expand();
//        statTable.add(new Label(String.valueOf(PlayerStats.getArmorCraftingLevel()), Tools.getSkin())).expand();
        statTable.add(new ProfessionBar());
        statTable.row();
        //System.out.println(buttonBack);
        statTable.add(buttonBack).expand();
        statTable.add(expBarr);

    }

    private void setUpLabels() {

        LevelLabel = new Label(String.valueOf(PlayerStats.getLEVEL()),Tools.getSkin());
        HealthLabel = new Label(PlayerStats.getVitality()+"/"+ PlayerStats.getVitalitypercentage(), Tools.getSkin());
        intellectLabel = new Label(String.valueOf(PlayerStats.getIntellect()), Tools.getSkin());
        dexterityLabel = new Label(String.valueOf(PlayerStats.getDexterity()), Tools.getSkin());
        strenghtLabel = new Label(String.valueOf(PlayerStats.getStrenght()), Tools.getSkin());
        armorLabel = new Label(String.valueOf(PlayerStats.getArmor()), Tools.getSkin());
        armorPiercingLabel = new Label(String.valueOf(PlayerStats.getArmorPiercing()), Tools.getSkin());
        critLabel = new Label(String.valueOf(PlayerStats.getCrit()), Tools.getSkin());
        attackPowerLabel = new Label(String.valueOf(PlayerStats.getAttackPower()), Tools.getSkin());
    }

    public void refreshStats() {
        LevelLabel.setText(String.valueOf(PlayerStats.getLEVEL()));
        HealthLabel.setText(PlayerStats.getVitality()+"/"+ PlayerStats.getVitalitypercentage());
        intellectLabel.setText(String.valueOf(PlayerStats.getIntellect()));
        dexterityLabel.setText(String.valueOf(PlayerStats.getDexterity()));
        strenghtLabel.setText(String.valueOf(PlayerStats.getStrenght()));
        armorLabel.setText(String.valueOf(PlayerStats.getArmor()));
        armorPiercingLabel.setText(String.valueOf(PlayerStats.getArmorPiercing()));
        critLabel.setText(String.valueOf(PlayerStats.getCrit()));
        attackPowerLabel.setText(String.valueOf(PlayerStats.getAttackPower()));
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
