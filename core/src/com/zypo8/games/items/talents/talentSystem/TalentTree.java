package com.zypo8.games.items.talents.talentSystem;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.TalentSlot;
import com.zypo8.games.items.talents.class_talents.palladyn.Pal1;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.tools.SpriteActor;

import java.util.Random;


public class TalentTree extends Group {
    private final SpriteActor spriteDPS;
    private final SpriteActor spriteTANK;
    private final SpriteActor spriteHEAL;
    private final SpriteActor spriteUTILITY;
    private final SpriteActor spriteLocked;
    private final int talentTreeType;
    public static int talentTreeCount = 0;
    protected int talentTreeID;
    protected boolean isTaken, active;
    protected TextButton take;
    public Array<TalentSlot> talentSlots;
    public int talentSpendTree;
    public boolean treeLocked;
    public Label LevelReq = new Label("Required Level: ", new Label.LabelStyle(new BitmapFont(), Color.FIREBRICK));

    private Table talentTable, summaryTable;

    public TalentTree(){
        talentTreeCount++;
        setBounds(getX(), getY(), 150, 150);
        talentTreeID = talentTreeCount;
        take = new TextButton("Take", Tools.getSkin());
        take.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                take();
            }
        });
        talentSlots = new Array<>(true, 16);
        for (int i=0;i<16;i++) {
            talentSlots.add(new TalentSlot(false));
        }
        setUpTalents();
        setUpTable();
        setUpSummary();
        addActor(summaryTable);
        spriteDPS = new SpriteActor("img/ui/dps_talent_tree.png");
        spriteTANK = new SpriteActor("img/ui/tank_talent_tree.png");
        spriteHEAL = new SpriteActor("img/ui/heal_talent_tree.png");
        spriteUTILITY = new SpriteActor("img/ui/utility_talent_tree.png");
        spriteLocked = new SpriteActor("img/ui/locked_talent_tree.png");
        spriteLocked.setVisible(false);
        Random r = new Random();
        talentTreeType  = r.nextInt(4);
        if(talentTreeType == 0)
            addActor(spriteDPS);
        if(talentTreeType == 1)
            addActor(spriteTANK);
        if(talentTreeType == 2)
            addActor(spriteHEAL);
        if(talentTreeType == 3)
            addActor(spriteUTILITY);
        addActor(spriteLocked);
        spriteDPS.setZIndex(0);
        spriteTANK.setZIndex(0);
        spriteHEAL.setZIndex(0);
        spriteUTILITY.setZIndex(0);
        summaryTable.setZIndex(1);

        if(talentTreeID <= 4){
            LevelReq.setText("Required Level: 10");
        }
        else if(talentTreeID <= 8){
            LevelReq.setText("Required Level: 25");
        }
        else if(talentTreeID <= 12){
            LevelReq.setText("Required Level: 40");
        }
        else
            LevelReq.setText("Required Level: 50");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public void lockTree(){
        for (int i =0;i<16;i++){
            if(talentSlots.get(i).getTalent() != null)
                talentSlots.get(i).getTalent().isLocked = true;
        }
        spriteLocked.setVisible(true);
    }

    public void unlockTree(){
        for (int i =0;i<16;i++){
            if(talentSlots.get(i).getTalent() != null)
                talentSlots.get(i).getTalent().isLocked = false;
        }
        spriteLocked.setVisible(false);
    }
    public void addTalentPoint(){
        talentSpendTree++;
//        if(talentSpendTree >= 12){
//            //TalentSystem.unLockRow(talentTreeID);
//            TalentSystem.talentActive(talentTreeID);
//        }
    }

    public void removeTalentPoint(){
        talentSpendTree--;
//        if(talentSpendTree < 12){
//            TalentSystem.talentUnActive(talentTreeID);
//        }
    }

    protected void setUpSummary() {
        summaryTable = new Table();
        summaryTable.setDebug(false);
        summaryTable.setFillParent(true);
        summaryTable.add();
        summaryTable.add(take).top();
        summaryTable.add();
        summaryTable.row();
        summaryTable.add();
        summaryTable.add(LevelReq);
        summaryTable.add();
    }

    protected void setUpTalents() {
        talentSlots.get(0).setItem(new Pal1(this));
        talentSlots.get(1).setItem(new Pal1(this));
        talentSlots.get(2).setItem(new Pal1(this));
        talentSlots.get(3).setItem(new Pal1(this));
        talentSlots.get(4).setItem(new Pal1(this));
        talentSlots.get(5).setItem(new Pal1(this));
        talentSlots.get(6).setItem(new Pal1(this));
        talentSlots.get(7).setItem(new Pal1(this));
        talentSlots.get(8).setItem(new Pal1(this));
        talentSlots.get(9).setItem(new Pal1(this));
        talentSlots.get(10).setItem(new Pal1(this));
        talentSlots.get(11).setItem(new Pal1(this));
        talentSlots.get(12).setItem(new Pal1(this));
        talentSlots.get(13).setItem(new Pal1(this));
        talentSlots.get(14).setItem(new Pal1(this));
        talentSlots.get(15).setItem(new Pal1(this));
    }

    protected void setUpTable(){
        talentTable = new Table();
        talentTable.setDebug(false);
        talentTable.setFillParent(true);
        talentTable.add(talentSlots.get(0)).expand();
        talentTable.add(talentSlots.get(1)).expand();
        talentTable.add(talentSlots.get(2)).expand();
        talentTable.add(talentSlots.get(3)).expand();
        talentTable.row();
        talentTable.add(talentSlots.get(4)).expand();
        talentTable.add(talentSlots.get(5)).expand();
        talentTable.add(talentSlots.get(6)).expand();
        talentTable.add(talentSlots.get(7)).expand();
        talentTable.row();
        talentTable.add(talentSlots.get(8)).expand();
        talentTable.add(talentSlots.get(9)).expand();
        talentTable.add(talentSlots.get(10)).expand();
        talentTable.add(talentSlots.get(11)).expand();
        talentTable.row();
        talentTable.add(talentSlots.get(12)).expand();
        talentTable.add(talentSlots.get(13)).expand();
        talentTable.add(talentSlots.get(14)).expand();
        talentTable.add(talentSlots.get(15)).expand();

    }

    protected void setActive(boolean active){
        this.active = active;
        if(active){
            removeActor(summaryTable);
            addActor(talentTable);
        }
    }

    public boolean isTaken() {
        return isTaken;
    }

    public int getTalentTreeID() {
        return talentTreeID;
    }

    public void take() {
        if(talentTreeID <= 4){
            if(PlayerStats.getLEVEL() > 10){
                isTaken = true;
                TalentSystem.talentActive(talentTreeID);
                removeActor(summaryTable);
                addActor(talentTable);
            }
        }
        if(talentTreeID <= 8){
            if(PlayerStats.getLEVEL() > 25){
                isTaken = true;
                TalentSystem.talentActive(talentTreeID);
                removeActor(summaryTable);
                addActor(talentTable);
            }
        }
        if(talentTreeID <= 12){
            if(PlayerStats.getLEVEL() > 40){
                isTaken = true;
                TalentSystem.talentActive(talentTreeID);
                removeActor(summaryTable);
                addActor(talentTable);
            }
        }
        if(talentTreeID <= 16){
            if(PlayerStats.getLEVEL() > 50){
                isTaken = true;
                TalentSystem.talentActive(talentTreeID);
                removeActor(summaryTable);
                addActor(talentTable);
            }
        }

    }
}
