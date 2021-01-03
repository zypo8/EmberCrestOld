package com.zypo8.games.items.talents.talentSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.items.Item;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.TalentSlot;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.TalentsWindow;

public class Talent extends Item {
    public int amount;
    public boolean isActive;
    public int talentCount;
    public Sprite inActiveSprite;
    public TalentTree talentTree;

    public Talent(AssetDescriptor assetDescriptor, String inActiveSpriteFile, int itemID, int talentCount, String name) {
        super(assetDescriptor, itemID, name);
        this.inActiveSprite = new Sprite(new Texture(Gdx.files.internal(inActiveSpriteFile)));
        this.talentCount = talentCount;
        //TalentsWindow.talents.add(this);
        TalentsWindow.talentSlots.add(new TalentSlot(this));
    }
    public void effect(boolean add){
    }

    public void effect(int amount){}


    @Override
    public void itemHoverWindow(Window window, Skin skin){
        if(!isLocked)
            window.add(description);
        else {
            window.add(new Label("LOCKED TREE", Tools.getSkin()));
            window.row();
            window.add(description);
        }
    }

    @Override
    public void firstOption() {
        if(!isLocked)
            addTalentPoint();
    }

    @Override
    public void addTalentPoint() {
        System.out.println(talentTree.getTalentTreeID() +" "+ talentTree.talentSpendTree);
        if(TalentSystem.avilableTalentPoints < 1)
            return;
        TalentSystem.avilableTalentPoints--;
        if(talentTree.talentSpendTree == 15)
            return;
        if(amount < talentCount) {
            isActive = true;
            amount++;
            HUDStage.lastClickedSlot.setAmount(HUDStage.lastClickedSlot.getAmount() + 1);
            TalentSystem.talentSpend++;
            addTalentPointToTree();
            effect(true);
        }
    }

    private void addTalentPointToTree() {
        for(TalentTree talentTree:TalentSystem.talentTrees){
            if(this.talentTree.getTalentTreeID() == talentTree.getTalentTreeID()){
                talentTree.addTalentPoint();
            }
        }
    }

    private void removeTalentPointToTree() {
        for(TalentTree talentTree:TalentSystem.talentTrees){
            if(this.talentTree.getTalentTreeID() == talentTree.talentTreeID){
                talentTree.removeTalentPoint();
            }
        }
    }


    @Override
    public void removeTalentPoint() {
        if(amount > 0) {
            if(amount == 1)
                isActive = false;
            amount--;
            HUDStage.lastClickedSlot.setAmount(HUDStage.lastClickedSlot.getAmount() - 1);
            TalentSystem.talentSpend--;
            removeTalentPointToTree();
            effect(false);
            TalentSystem.avilableTalentPoints++;
        }
    }


    //getters and setters
    public int getTalentCount() {
        return talentCount;
    }

    public void setTalentCount(int talentCount) {
        this.talentCount = talentCount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }

    @Override
    public ItemLocation getItemLocation() {
        System.out.println("ASDADADADASD");
        return null;
    }

    public TalentTree getTalentTree() {
        return talentTree;
    }

    public void setTalentTree(TalentTree talentTree) {
        this.talentTree = talentTree;
    }



}
