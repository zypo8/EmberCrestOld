package com.zypo8.games.actors.gatherable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.LoadScreen;
import com.zypo8.games.actors.Interactable;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.LootWindow;
import com.zypo8.games.ui.windows.options.LoadOptions;

public class Gatherable extends Interactable {
    protected LootWindow lootWindow;
    protected boolean isActive = true, isBeingGathered;
    protected Sprite inActiveSprite;
    protected int levelReq = 0;
    protected float cd, gatheringTimeReq;
    protected long time, gathering_time;
    public int expRewqrd;
    public Gatherable(AssetDescriptor activeSprite, int posX, int posY, HUDStage hudStage, AssetDescriptor inActiveSprite, float cd, String actorName, float gatheringTimeReq) {
        super(activeSprite, posX, posY, hudStage, actorName);
        this.inActiveSprite = new Sprite((Texture) LoadScreen.assetManager.get(inActiveSprite));
        this.inActiveSprite.setPosition(getX(), getY());
        this.cd = cd;
        this.gatheringTimeReq = gatheringTimeReq;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(isActive)
            sprite.draw(batch);
        else {
            inActiveSprite.draw(batch);
        }
    }

    @Override
    public void act(float delta) {
        if (!isActive) {
            if(time <= System.currentTimeMillis())
                isActive = true;
        }
        else {
            time = System.currentTimeMillis();
        }

        if(isBeingGathered){
            HUD.castBar.setValue(HUD.castBar.getValue()+(100f/60*1/gatheringTimeReq));
            if(gathering_time <= System.currentTimeMillis()){
                isBeingGathered = false;
                // Reward Player With EXP
                //
                //
                //
                //
                //
                setUpLoot();
                HUD.castBar.reset();
            }
            if(Player.Player_moving){
                isBeingGathered = false;
                HUD.castBar.reset();
            }
        }else {
            gathering_time = System.currentTimeMillis();
        }
    }

    @Override
    public void interactWindow(Window window, Skin skin) {
        if(isActive) {
            if(levelReq <= PlayerStats.getGatheringLevel()) {
                window.setHeight(60);
                window.add(interactButtons.addGatherButton(this));
            }
            else {
                window.setHeight(60);
                window.add(new Label("Level 20", skin));
            }
        }
        else {
            window.setHeight(60);
            window.add(new Label("CD: "+(time-System.currentTimeMillis())/1000, skin));
        }

    }

    @Override
    public void firstOption() {
        if(isActive) {
            if (levelReq <= PlayerStats.getGatheringLevel()) {
                showGather();
            }
        }
    }

    @Override
    public void showGather() {
        if(Player.destX > getX()-33 && Player.destX < getX()+33) {
            if(Player.destY > getY()-33 && Player.destY < getY()+33) {
                HUD.castBar.setValue(0);
                gatherBar();
            }
        }
    }

    private void gatherBar() {
        gathering_time += (long) gatheringTimeReq*1000;
        isBeingGathered = true;
    }

    public void setUpLoot(){
        HUD.castBar.reset();
        time += (long) cd * 1000;
        isActive = false;
        lootWindow = new LootWindow("", Tools.getSkin());
        lootWindow.setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
        addItemsToLootWindow();
        if((Boolean) LoadOptions.generalData.get("AutoLoot")) {
            System.out.println("AUTOLOOT IS IN MAINTAINCE");
        }
        hudStage.addActor(lootWindow);
    }

    protected void addItemsToLootWindow() {
    }

    public int getLevelReq() {
        return levelReq;
    }

    public void setLevelReq(int levelReq) {
        this.levelReq = levelReq;
    }

    public int getExpRewqrd() {
        return expRewqrd;
    }

    public void setExpRewqrd(int expRewqrd) {
        this.expRewqrd = expRewqrd;
    }
}
