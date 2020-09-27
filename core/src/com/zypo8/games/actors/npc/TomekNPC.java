package com.zypo8.games.actors.npc;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.actors.player.Character;
import com.zypo8.games.ui.HUDStage;

public class TomekNPC extends Character {
    public TomekNPC(String spriteFIle, int posX, int posY, HUDStage hudStage) {
        super(spriteFIle, posX, posY, hudStage, "Tomek");
    }

    @Override
    public void interactWindow(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactButtons.addInventoryButton(this));
        window.row();
        window.add(interactButtons.addOptionsButton(this));
        window.row();
        window.add(interactButtons.addQuestButton(this));
    }

}
