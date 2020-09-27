package com.zypo8.games.Screens.new_game_system;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.zypo8.games.actors.player.classes.Classes;

public class MagicIcons extends Group {
    private static ClassIcon warriorIcon;
    private static ClassIcon hutnerIcon;
    private static ClassIcon barbarianIcon;
    private static ClassIcon mageIcon;

    private Table table = new Table();
    public MagicIcons(){
        setUpClasses();
        table.setDebug(false);
        table.add(warriorIcon).expand().left().padTop(40);
        table.row();
        table.add(hutnerIcon).expand().left().padTop(40);
        table.row();
        table.add(barbarianIcon).expand().left().padTop(40);
        table.row();
        table.add(mageIcon).expand().left().padTop(40);
        table.row();
        addActor(table);
    }
    private void setUpClasses() {
        warriorIcon = new ClassIcon();
        hutnerIcon = new ClassIcon();
        barbarianIcon = new ClassIcon();
        mageIcon = new ClassIcon();
        warriorIcon.setName("warrior");
        hutnerIcon.setName("hunter");
        barbarianIcon.setName("barbarian");
        mageIcon.setName("mage");
        mageIcon.setPlayerCLass(Classes.Mage);
        warriorIcon.setPlayerCLass(Classes.Warrior);
        hutnerIcon.setPlayerCLass(Classes.Hunter);
        barbarianIcon.setPlayerCLass(Classes.Barbarian);
    }
    public static void unSelectAll(){
        warriorIcon.setSelected(false);
        hutnerIcon.setSelected(false);
        barbarianIcon.setSelected(false);
        mageIcon.setSelected(false);
    }

}
