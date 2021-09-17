package com.zypo8.games.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.Screens.load_screen.LoadScreen;
import com.zypo8.games.abilities.skills.Skill;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.armor.SlotType;
import com.zypo8.games.items.talents.talentSystem.Talent;


public class InventorySlot extends Group {
    public static int slotsNumber = 0;
    public int slotID;
    protected int amount;
    protected Sprite backgroundImage;
    protected Item item;
    protected Talent talent;
    protected SlotType slotType;
    protected boolean drawBackground = true;
    private final Texture debuffBackground = (Texture) LoadScreen.assetManager.get(Assets.debuf_bg);
    private final Texture manaCostTexture = (Texture) LoadScreen.assetManager.get(Assets.mana_cost_texture);

    public InventorySlot(Item item, int amount){
        this();
        this.item = item;
        this.amount = amount;
        addActor(item);
    }

    public InventorySlot(boolean drawBackground){
        this();
        this.drawBackground = drawBackground;
    }

    public  InventorySlot(SlotType slotType){
        this();
        this.slotType = slotType;
    }
    public InventorySlot(){
        slotID = slotsNumber;
        backgroundImage = new Sprite(new Texture(Gdx.files.internal("img/ui/inventorySlotBGimg.png")));
        setBounds(backgroundImage.getX(), backgroundImage.getY(), backgroundImage.getWidth(), backgroundImage.getHeight());
        setTouchable(Touchable.enabled);
        setName("InventorySlot"+slotID);
        slotsNumber++;
        MyRPGGame.font.setColor(Color.WHITE);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if(drawBackground)
            backgroundImage.draw(batch);
        if(item != null){
            if(item.isDeBuff){
                batch.draw(debuffBackground, getX()-1, getY()-1);
            }
            if(item instanceof Skill) {
                if (PlayerStats.getLEVEL() >= ((Skill)item).levelReq)
                    batch.draw(((Skill)item).sprite, getX(), getY());
                else
                    batch.draw(((Skill)item).inActiveSprite, getX(), getY());
                if(((Skill)item).manaCost > PlayerStats.getMANA()){
                    batch.draw(manaCostTexture, getX(), getY());
                }
            }
            else {
                batch.draw(item.sprite, getX(), getY());
            }
//            if(item.itemLocation == ItemLocation.Vendor || item.itemLocation == ItemLocation.Sold){
//                if (item.vendorPrice > 1 && item.vendorPrice < 10) {
//                    MyRPGGame.font.setColor(Color.GOLD);
//                    MyRPGGame.font.draw(batch, String.valueOf(item.vendorPrice)+"$", getX() + 22, getY() + 14);
//                }
//                if (item.vendorPrice >= 10 && item.vendorPrice <= 99) {
//                    MyRPGGame.font.setColor(Color.GOLD);
//                    MyRPGGame.font.draw(batch, String.valueOf(item.vendorPrice)+"$", getX() + 14, getY() + 14);
//                }
//                else {
//                    MyRPGGame.font.setColor(Color.GOLD);
//                    MyRPGGame.font.draw(batch, String.valueOf(item.vendorPrice)+"$", getX() + 6, getY() + 14);
//                }
//            }
            if (amount > 1 && amount < 10) {
                MyRPGGame.font.setColor(Color.WHITE);
                MyRPGGame.font.draw(batch, String.valueOf(amount), getX() + 22, getY() + 14);
            }
            if (amount >= 10) {
                MyRPGGame.font.setColor(Color.WHITE);
                MyRPGGame.font.draw(batch, String.valueOf(amount), getX() + 14, getY() + 14);
            }

        }
    }


    public Item getItem() {
        return item;
    }

//    public <T extends  Item> Item getItem2() {
//        return Item;
//    }




    public void setItem(Item item) {
        this.item = item;
        GameScreen.hud.hudStage.addActor(item);
    }

    public void removeItem(){
        item.getItemDescriptionWIndow().setVisible(false);
        amount = 0;
        item = null;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }

    @Override
    protected void positionChanged() {
        backgroundImage.setPosition(getX(), getY());
        super.positionChanged();
    }

    public int getSlotID() {
        return slotID;
    }



}
