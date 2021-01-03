package com.zypo8.games.abilities.skills;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.LoadScreen;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.Item;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;

public class Skill extends Item {
    public boolean isActive;
    public int levelReq;
    public Sprite inActiveSprite;
    public int manaCost;

    public Skill(AssetDescriptor activeSprite, AssetDescriptor inActiveSprite, int itemID, String name, ItemLocation itemLocation) {
        super(activeSprite, itemID, ItemRarity.Skill, itemLocation, name);
        this.inActiveSprite = new Sprite((Texture) LoadScreen.assetManager.get(inActiveSprite));
        setName("ability");
    }

    public void cast(){
        if(levelReq <= PlayerStats.getLEVEL()) {
            if (PlayerStats.getMANA() >= manaCost) {
                PlayerStats.setMANA(PlayerStats.getMANA() - manaCost);
                abilityEffect();
                PlayerFrame.refreshPlayerFrame();
            } else {
                HUD.warningLabel.clearActions();
                HUD.warningLabel.addAction(Actions.alpha(1, 0));
                HUD.warningLabel.setText("Not enough mana");
                HUD.warningLabel.addAction(Actions.alpha(0, 4));
            }
        }else {
            HUD.warningLabel.clearActions();
            HUD.warningLabel.addAction(Actions.alpha(1, 0));
            HUD.warningLabel.setText("Required Level "+levelReq);
            HUD.warningLabel.addAction(Actions.alpha(0, 4));
        }
    }
    @Override
    public void itemInteractWindow(Window window, Skin skin) {
        if(itemLocation == ItemLocation.SpellBoock){
            window.add(interactItemButtons.addSkillToBar(this));
        }
        else{
            window.add(interactItemButtons.addDropButton(this));
        }
    }

    public void abilityEffect() {
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
