package com.zypo8.games.ui.windows.options;

import com.badlogic.gdx.files.FileHandle;
import com.zypo8.games.ui.windows.options.all_options.GeneralOptions;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SaveOptions {
    public static FileHandle setingsFile;

    public static Map data;
    public static Map generalData;
    public static Map interfaceData;
    public static Map videoData;
    public static Map audioData;
    public static Map KeybindsData;

    public static boolean createSave() {
        createDircectory();
        createHashMap();

        setingsFile = new FileHandle("RPGGame/settings.json");

        setingsFile.write(false);
        setingsFile.writeString(new JSONObject().toJSONString(data), false);
        return true;
    }

    private static void createHashMap() {
        data = new HashMap();

        saveSettings();
        data.put("generalData", generalData);
        data.put("interfaceData", interfaceData);
        data.put("videoData", videoData);
        data.put("audioData", audioData);
        data.put("KeybindsData", KeybindsData);
    }

    private static void saveSettings() {
        generalData = new HashMap();
        interfaceData = new HashMap();
        videoData = new HashMap();
        audioData = new HashMap();
        KeybindsData = new HashMap();
        generalData.put("AutoSave", GeneralOptions.autoSave.isChecked());
        generalData.put("AutoLoot", GeneralOptions.autoLoot.isChecked());
        generalData.put("ScrollCombatText", GeneralOptions.HealAndDamageText.isChecked());
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
