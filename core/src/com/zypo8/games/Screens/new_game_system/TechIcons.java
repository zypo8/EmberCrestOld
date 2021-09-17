package com.zypo8.games.Screens.new_game_system;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.zypo8.games.actors.player.classes.Classes;

public class TechIcons extends Group {
    private static ClassIcon palladynIcon;
    private static ClassIcon archerIcon;
    private static ClassIcon shamanIcon;
    private static ClassIcon rogueIcon;

    private final Table table = new Table();
    public TechIcons(){
        setUpClasses();
        table.setDebug(false);
        table.add(palladynIcon).expand().left().padTop(40);
        table.row();
        table.add(archerIcon).expand().left().padTop(40);
        table.row();
        table.add(shamanIcon).expand().left().padTop(40);
        table.row();
        table.add(rogueIcon).expand().left().padTop(40);
        table.row();
        addActor(table);
    }
    private void setUpClasses() {
        palladynIcon = new ClassIcon();
        archerIcon = new ClassIcon();
        shamanIcon = new ClassIcon();
        rogueIcon = new ClassIcon();
        palladynIcon.setName("palladyn");
        archerIcon.setName("archer");
        shamanIcon.setName("shaman");
        rogueIcon.setName("rouge");
        palladynIcon.setPlayerCLass(Classes.Palladyn);
        archerIcon.setPlayerCLass(Classes.Archer);
        shamanIcon.setPlayerCLass(Classes.Shaman);
        rogueIcon.setPlayerCLass(Classes.Rogue);
    }
    public static void unSelectAll(){
        palladynIcon.setSelected(false);
        archerIcon.setSelected(false);
        shamanIcon.setSelected(false);
        rogueIcon.setSelected(false);
    }
}
