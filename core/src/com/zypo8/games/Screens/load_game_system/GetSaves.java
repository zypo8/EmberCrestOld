package com.zypo8.games.Screens.load_game_system;

import com.badlogic.gdx.utils.Array;

import java.io.File;
import java.util.ArrayList;

public class GetSaves {
    public static File file;
    public static ArrayList<File> files;
    public static Array<GameSaveButton> gameSaveButtons;
    public GetSaves(){
        files = new ArrayList<>();
        file = new File("./RPGGame/players");
        for(File fille: file.listFiles()) {
            if(extension(fille.getName()).equals("sav")){
                files.add(fille);
            }
        }
        gameSaveButtons = new Array<>();
        for (int i = 0; i < files.size(); i++){
            gameSaveButtons.add(new GameSaveButton(files.get(i)));
        }
        System.out.println(files);
    }
    public String extension (String name) {
        int dotIndex = name.lastIndexOf('.');
        if (dotIndex == -1) return "";
        return name.substring(dotIndex + 1);
    }
    public static void UnSelectAll(){
        for (GameSaveButton gameSaveButton:gameSaveButtons){
            gameSaveButton.unselect();
        }
    }
    public static GameSaveButton GetSelectedSave(){
        for (GameSaveButton gameSaveButton: gameSaveButtons){
            if(gameSaveButton.getSelected()){
                return gameSaveButton;
            }
        }
        return null;
    }
}
