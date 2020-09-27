package com.zypo8.games.Screens.load_game_system;

import com.badlogic.gdx.utils.Array;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.actors.player.classes.Classes;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Items;
import com.zypo8.games.items.Location;
import com.zypo8.games.items.TalentSlot;
import com.zypo8.games.items.armor.Armor;
import com.zypo8.games.items.talents.talentSystem.TalentTree;
import com.zypo8.games.ui.windows.EquipmentWindow;
import com.zypo8.games.ui.windows.TalentsWindow;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoadGame {
    public static Map inventoryData;
    public static Map equipmentData;
    public static Map talentsData;
    public static Map talentTreesData;
    public static Map actionBarData;
    public static Map buffBarData;
    public static Map deBuffBarData;
    public static Map data;


    public static String PlayerName;
    public static long PlayerClassId;
    public static long PlayerX, PlayerY;
    public static Player player;
    public static Array<Armor> equipment;

    private MyRPGGame game;
    private File selectedSave;


    public LoadGame(MyRPGGame game, File selectedSave) {
        this.game = game;
        this.selectedSave = selectedSave;
        setData();
        initData();

    }

    private void initData() {
        PlayerX = (long) data.get("X");
        PlayerY = (long) data.get("Y");
        PlayerName = (String) data.get("Name");
        PlayerClassId = (long) data.get("Class");
        player = Classes.getClassById(LoadGame.PlayerClassId);
        PlayerStats.setLEVEL(toIntExact((long)data.get("Level")));
        if(data.get("Floor") != null)
            GameScreen.floor = toIntExact((long)data.get("Floor"));
        initInventory();


    }

    private void initInventory() {
        //System.out.println(inventoryData);
        equipment = new Array<>(11);
        for(InventorySlot inventorySlot:EquipmentWindow.inventorySlots){
            if(equipmentData.get("Slot"+inventorySlot.getSlotID()) != null)
                equipment.add((Armor)Items.getItemById(toIntExact((Long) equipmentData.get("Slot" + inventorySlot.getSlotID())), Location.Equiped));
        }
        for (TalentSlot talentSlot: TalentsWindow.talentSlots){
            if(talentsData.get("Slot"+talentSlot.getSlotID()) != null){
                talentSlot.getTalent().setAmount(toIntExact((Long) talentsData.get("Slot" + talentSlot.getSlotID())));
                talentSlot.getTalent().effect(toIntExact((Long) talentsData.get("Slot" + talentSlot.getSlotID())));

                talentSlot.getTalent().getTalentTree().talentSpendTree += toIntExact((Long) talentsData.get("Slot" + talentSlot.getSlotID()));
                if (toIntExact((Long) talentsData.get("Slot" + talentSlot.getSlotID())) > 0)
                    talentSlot.getTalent().setActive(true);
            }
        }

        for (TalentTree talentTree: TalentsWindow.talentTrees){
            //System.out.println(talentTreesData.get("Tree"+talentTree.getTalentTreeID()));
            if(talentTreesData.get("Tree"+talentTree.getTalentTreeID()) != null) {
                if ((boolean) talentTreesData.get("Tree" + talentTree.getTalentTreeID())) {
                    talentTree.take();
                }
            }
        }
        Player.getEquipmentWindow().refreshStats();
    }

    private void setData(){
        final JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(selectedSave))
        {
            data = (HashMap)jsonParser.parse(reader);
            //inventoryData = (HashMap) jsonParser.parse(reader);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        inventoryData = new HashMap((Map) data.get("Inventory"));
        equipmentData = new HashMap((Map) data.get("Equipment"));
        talentsData = new HashMap((Map) data.get("Talents"));
        talentTreesData = new HashMap((Map) data.get("TalentTrees"));
        //System.out.println(talentTreesData);
        actionBarData = new HashMap((Map) data.get("ActionBar"));
        buffBarData = new HashMap((Map) data.get("BuffBar"));
        deBuffBarData = new HashMap((Map) data.get("DeBuffBar"));
    }

    public void LoadGame(){
        game.setScreen(new GameScreen(game));
    }

    public static int toIntExact(long value) {
        if ((int)value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (int)value;
    }
}
