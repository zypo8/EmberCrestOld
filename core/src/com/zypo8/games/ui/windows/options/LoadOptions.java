package com.zypo8.games.ui.windows.options;

import com.badlogic.gdx.files.FileHandle;
import com.zypo8.games.StaticValues;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
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
    private final FileHandle selectedSave;


    public LoadOptions() {
        selectedSave = new FileHandle("RPGGame/settings.json");
        checkSettingsCorrect();
        setData();

    }

    private void checkSettingsCorrect() {
        try (FileReader reader = new FileReader(selectedSave.file())){
            if(reader.read() == -1){
                selectedSave.write(false);
                selectedSave.writeString(StaticValues.DEFOULT_SETTINGS, false);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setData(){
        final JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(selectedSave.file()))
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
