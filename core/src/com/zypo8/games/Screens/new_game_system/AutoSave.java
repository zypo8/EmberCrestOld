package com.zypo8.games.Screens.new_game_system;

import com.badlogic.gdx.files.FileHandle;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.Screens.load_game_system.GetSaves;
import com.zypo8.games.Screens.load_game_system.LoadGame;
import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.TalentSlot;
import com.zypo8.games.items.talents.talentSystem.TalentTree;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;
import com.zypo8.games.ui.hud.buff_bar.DeBuffbar;
import com.zypo8.games.ui.windows.EquipmentWindow;
import com.zypo8.games.ui.windows.InventoryWindow;
import com.zypo8.games.ui.windows.TalentsWindow;

import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AutoSave {
    public static FileHandle save;
    public static String name;
    public static int x, y;
    public static int autoSavesCount;


    public static Map data;
    public static Map inventoryData;
    public static Map equipmentData;
    public static Map talentData;
    public static Map talentTreesData;
    public static Map actionBarData;
    public static Map buffBarData;
    public static Map deBuffBarData;

    public AutoSave() {
    }

    public static boolean createAutoSave() {
        createDircectory();
        createHashMap();
        checkAutoSaveCount();

        save = new FileHandle("RPGGame/players/" + LoadGame.PlayerName +"AutoSave"+new Date(System.currentTimeMillis())+ ".sav");

        save.write(false);
        name = LoadGame.PlayerName;
        save.writeString(new JSONObject().toJSONString(data), false);
        return true;
    }


    private static void createHashMap() {
        data = new HashMap();
        data.put("Name", LoadGame.PlayerName);
        data.put("X", Player.destX);
        data.put("Y", Player.destY);
        data.put("Class", LoadGame.PlayerClassId);
        data.put("Coins", InventoryWindow.coins);
        data.put("Floor", GameScreen.floor);

        //inventory:
        saveInventory();
        data.put("Inventory", inventoryData);
        data.put("Equipment", equipmentData);
        data.put("ActionBar", actionBarData);
        data.put("BuffBar", buffBarData);
        data.put("DeBuffBar", deBuffBarData);
        data.put("Talents", talentData);
        data.put("TalentTrees", talentTreesData);
        data.put("Level", PlayerStats.getLEVEL());
        data.put("Exp", PlayerStats.getEXP());
        data.put("GatheringLevel", PlayerStats.getGatheringLevel());
        data.put("CraftingLevel", PlayerStats.getCraftingLevel());
        data.put("ArmorCraftingLevel", 11);
        data.put("GatheringLevel", PlayerStats.getGatheringEXP());
        data.put("CraftingLevel", PlayerStats.getCraftingEXP());
        data.put("ArmorCraftingLevel", PlayerStats.getArmorCraftingEXP());
    }

    private static void saveInventory() {
        inventoryData = new HashMap();
        equipmentData = new HashMap();
        talentData = new HashMap();
        talentTreesData = new HashMap();
        actionBarData = new HashMap();
        buffBarData = new HashMap();
        deBuffBarData = new HashMap();
        for (InventorySlot inventorySlot : InventoryWindow.inventorySlots)
            if (inventorySlot.getItem() != null) {
                inventoryData.put("Slot" + inventorySlot.getSlotID(), inventorySlot.getItem().getItemID());
                inventoryData.put("Slot" + inventorySlot.getSlotID() + "A", inventorySlot.getAmount());
            }
        for (InventorySlot inventorySlot : EquipmentWindow.inventorySlots)
            if (inventorySlot.getItem() != null) {
                equipmentData.put("Slot" + inventorySlot.getSlotID(), inventorySlot.getItem().getItemID());
                equipmentData.put("Slot" + inventorySlot.getSlotID() + "A", inventorySlot.getAmount());

            }
        for (InventorySlot inventorySlot : Actionbar.inventorySlots)
            if (inventorySlot.getItem() != null) {
                actionBarData.put("Slot" + inventorySlot.getSlotID(), inventorySlot.getItem().getItemID());
                actionBarData.put("Slot" + inventorySlot.getSlotID() + "A", inventorySlot.getAmount());

            }
        for (InventorySlot inventorySlot : Buffbar.inventorySlots)
            if (inventorySlot.getItem() != null) {
                if (inventorySlot.getItem() instanceof Buff)
                    if (((Buff) inventorySlot.getItem()).dontSave)
                        continue;
                buffBarData.put("Slot" + inventorySlot.getSlotID(), inventorySlot.getItem().getItemID());
                buffBarData.put("Slot" + inventorySlot.getSlotID() + "A", inventorySlot.getAmount());

            }
        for (InventorySlot inventorySlot : DeBuffbar.inventorySlots)
            if (inventorySlot.getItem() != null) {
                deBuffBarData.put("Slot" + inventorySlot.getSlotID(), inventorySlot.getItem().getItemID());
                deBuffBarData.put("Slot" + inventorySlot.getSlotID() + "A", inventorySlot.getAmount());

            }
        for (TalentSlot talentSlot : TalentsWindow.talentSlots)
            if (talentSlot.getTalent() != null) {
                talentData.put("Slot" + talentSlot.getSlotID(), talentSlot.getTalent().getAmount());
            }

        for (TalentTree talentTree : TalentsWindow.talentTrees) {
            talentTreesData.put("Tree" + talentTree.getTalentTreeID(), talentTree.isTaken());
        }


    }
    private static void checkAutoSaveCount() {
        new GetSaves();
        ArrayList<File> files = GetSaves.files;
        //sprawdzic ile jest juz auto savow
        //jesli 3 to usunac ostatni.
    }


    public static void createDircectory() {
        FileHandle dir = new FileHandle("RPGGame");
        FileHandle settings = new FileHandle("RPGGame/settings.json");
        FileHandle keybinds = new FileHandle("RPGGame/keybinds.json");
        FileHandle players = new FileHandle("RPGGame/players");
        if (!dir.exists())
            dir.mkdirs();
        if (!settings.exists())
            settings.write(false);
        if (!keybinds.exists())
            keybinds.write(false);
        if (!players.exists())
            players.mkdirs();
    }
}
