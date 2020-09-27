package com.zypo8.games.Screens.new_game_system.save_system;

import com.badlogic.gdx.files.FileHandle;
import com.zypo8.games.actors.player.classes.Classes;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateNewSave {
    public static FileHandle save;
    public static String name;
    public static int x, y;
    public static Map data;
    public static Map inventoryData;
    public static Map equipmentData;
    public static Map talentData;
    public static Map talentTreesData;
    public static Map actionBarData;
    public static Map buffBarData;
    public static Map deBuffBarData;
    public CreateNewSave(){
    }

    public static boolean createSave(String nameArg, Classes PlayerClass){
        createDircectory();
        if(PlayerClass == null){
            System.out.println("YOU NEED TO choose A CLASS");
            return false;
        }
        data = new HashMap();
        data.put("Name", nameArg);
        data.put("X", 32 * 10);
        data.put("Y", 32 * 10);
        data.put("Class", PlayerClass.getId());
        data.put("Coins", 0);
        createHashMap();
        save = new FileHandle("RPGGame/players/"+nameArg+".sav");
        if(save.exists()){
            System.out.println("NAME ALREADY IN USE");
            return false;
        }
        else if(nameArg.equals("")){
            System.out.println("NAME CAN NOT BE EMPTY");
            return false;
        }
        else {
            save.write(true);
        }
        name = nameArg;
        save.writeString(new JSONObject().toJSONString(data), false);
        return true;
    }

    private static void createHashMap() {
        inventoryData = new HashMap();
        equipmentData = new HashMap();
        talentData = new HashMap();
        talentTreesData = new HashMap();
        actionBarData = new HashMap();
        buffBarData = new HashMap();
        deBuffBarData = new HashMap();
        data.put("Inventory", inventoryData);
        data.put("Equipment", equipmentData);
        data.put("ActionBar", actionBarData);
        data.put("BuffBar", buffBarData);
        data.put("DeBuffBar", deBuffBarData);
        data.put("Talents", talentData);
        data.put("TalentTrees", talentTreesData);
        data.put("Level", 1);
        data.put("Exp", 0);
        data.put("GatheringLevel", 10);
        data.put("CraftingLevel", 10);
        data.put("ArmorCraftingLevel", 11);
        data.put("GatheringLevel", 10);
    }

    public static void createDircectory(){
        FileHandle dir = new FileHandle("RPGGame");
        FileHandle settings = new FileHandle("RPGGame/settings.json");
        FileHandle keybinds = new FileHandle("RPGGame/keybinds.json");
        FileHandle players = new FileHandle("RPGGame/players");
        if(!dir.exists())
            dir.mkdirs();
        if(!settings.exists())
            settings.write(false);
        if(!keybinds.exists())
            keybinds.write(false);
        if(!players.exists())
            players.mkdirs();
    }
}
