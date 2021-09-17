package com.zypo8.games.ui.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zypo8.games.actors.npc.Vendor;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.Item;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.HUDStage;

public class InteractItemButtons {
    private TextButton consume, use, drop, equip, unequip, take, addSkillToBar, addTalent,
            removeTalent, addToActionBar, removeFromActionBar, buy, buyBack, BTNinfo, sell, sellOne, sellAll;
    private final Skin skin;

    public InteractItemButtons(Skin skin){
        this.skin = skin;
    }


    public TextButton addConsumeButton(final Item item){
        consume = new TextButton("consume", skin);
        consume.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("consume " + item.getName());
                item.consume();
            }
        });
        return consume;
    }

    public TextButton addUseButton(final Item item){
        use = new TextButton("use", skin);
        use.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("used " + item.getName());
                item.use();
            }
        });
        return use;
    }

    public TextButton addDropButton(final Item item){
        drop = new TextButton("drop", skin);
        drop.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("dropped " + item.getName());
                item.drop();
            }
        });
        return drop;
    }

    public TextButton addEquipButton(final Item item){
        equip = new TextButton("equip", skin);
        equip.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("equiped " + item.getName());
                item.equip();
            }
        });
        return equip;
    }

    public TextButton addTakeButton(final Item item){
        take = new TextButton("take", skin);
        take.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("taked " + item.getName());
                item.take();
            }
        });
        return take;
    }

    public TextButton addSkillToBar(final Item item){
        addSkillToBar = new TextButton("add to bar", skin);
        addSkillToBar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("added to action bar " + item.getName());
                item.addToActionBar(item.getItemID());
            }
        });
        return addSkillToBar;
    }

    public TextButton addUnequipItem(final Item item){
        unequip = new TextButton("unequiped", skin);
        unequip.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("unequiped " + item.getName()+item.getItemLocation());
                item.unequip();
                System.out.println("unequiped " + item.getName()+item.getItemLocation());
            }
        });
        return unequip;
    }

    public TextButton addTalentButton(final Item item){
        addTalent = new TextButton("add", skin);
        addTalent.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("added " + item.getName());
                item.addTalentPoint();
            }
        });
        return addTalent;
    }

    public TextButton addTalentRemoveButton(final Item item){
        removeTalent = new TextButton("remove", skin);
        removeTalent.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Removed " + item.getName());
                item.removeTalentPoint();
            }
        });
        return removeTalent;
    }

    public TextButton addAddToActionBar(final Item item){
        addToActionBar = new TextButton("add to bar", skin);
        addToActionBar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("added to action bar " + item.getName());
                item.addToActionBar();
            }
        });
        return addToActionBar;
    }

    public TextButton addRemoveFromActionBar(final Item item){
        removeFromActionBar = new TextButton("remove", skin);
        removeFromActionBar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("removed from action bar " + item.getName());
                item.removeFromActionBar();
            }
        });
        return removeFromActionBar;
    }

    public TextButton addBuy(final Item item){
        buy = new TextButton("Buy", skin);
        buy.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("bought " + item.getName());
                if(Player.playerInteractNPC instanceof Vendor){
                    ((Vendor)Player.playerInteractNPC).getVendorWindow().showSelectAmountWindow();
                }
            }
        });
        return buy;
    }

    public TextButton addBuyBack(final Item item){
        buyBack = new TextButton("Buy back", skin);
        buyBack.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("bought " + item.getName());
                item.buyback();
            }
        });
        return buyBack;
    }


    public TextButton addSellOne(final Item item){
        sellOne = new TextButton("Sell 1", skin);
        sellOne.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("sold " + item.getName());
                item.sell(1);
            }
        });
        return sellOne;
    }

    public TextButton addSell(final Item item){
        sell = new TextButton("Sell", skin);
        sell.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("sold " + item.getName());
                HUD.selectAmountWindow.changeMaxValue(HUDStage.lastClickedSlot.getAmount());
                HUD.selectAmountWindow.setVisible(true);
                HUD.selectAmountWindow.setPosition(Gdx.input.getX()+40, Gdx.input.getY()+40);
                //HUD.selectAmountWindow.
            }
        });
        return sell;
    }

    public TextButton addSellAll(final Item item){
        sellAll = new TextButton("Sell All", skin);
        sellAll.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("sold " + item.getName());
                item.sell(9999);
            }
        });
        return sellAll;
    }

    public TextButton BTNinfo(final Item item){
        buy = new TextButton("BTNinfo", skin);
        buy.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println(item.getItemLocation()+"BTNinfo  " + item.getName());
                item.BTNinfo();
            }
        });
        return buy;
    }
}
