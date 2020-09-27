package com.zypo8.games.ui.windows.options;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoadOptions {
    public static Map data;
    public static Map generalData;
    public static Map interfaceData;
    public static Map videoData;
    public static Map audioData;
    public static Map KeybindsData;
    private File selectedSave;


    public LoadOptions() {
        selectedSave = new File("./RPGGame/settings.json");
        setData();

    }

    private void setData(){
        final JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(selectedSave))
        {
            data = (HashMap)jsonParser.parse(reader);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        generalData = new HashMap((Map) data.get("generalData"));
        interfaceData = new HashMap((Map) data.get("interfaceData"));
        videoData = new HashMap((Map) data.get("videoData"));
        audioData = new HashMap((Map) data.get("audioData"));
        KeybindsData = new HashMap((Map) data.get("KeybindsData"));
    }

    public void refreshGame(){
    }

    public static int toIntExact(long value) {
        if ((int)value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (int)value;
    }
}
