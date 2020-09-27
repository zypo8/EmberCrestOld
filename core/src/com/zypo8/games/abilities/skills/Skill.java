package com.zypo8.games.abilities.skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.Item;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;

public class Skill extends Item {
    protected int amount;
    public boolean isActive;
    public Sprite inActiveSprite;
    public int manaCost;

    public Skill(String spriteFIle, String inActiveSpriteFile, int itemID, String name) {
        super(spriteFIle, itemID, name);
        this.inActiveSprite = new Sprite(new Texture(Gdx.files.internal(inActiveSpriteFile)));
        setName("ability");
    }

    public void cast(){
        if(PlayerStats.getMANA() >= manaCost){
            PlayerStats.setMANA(PlayerStats.getMANA()- manaCost);
            abilityEffect();
            PlayerFrame.refreshMana();
            PlayerFrame.refreshHp();
        }
        else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Not enough mana");
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }
    }

    public void abilityEffect() {
    }

    @Override
    public void itemInteractWindow(Window window, Skin skin) {
        window.setVisible(false);
    }
    @Override
    public void removeFromActionBar() {
        HUDStage.lastClickedSlot.removeItem();
    }

    @Override
    public void firstOption() {
        cast();
    }

    @Override
    public void use() {
        System.out.println("Skill Used "+this.getName());
    }
    //getters and setters

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}
