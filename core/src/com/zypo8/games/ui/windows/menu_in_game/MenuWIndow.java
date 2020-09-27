package com.zypo8.games.ui.windows.menu_in_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.Screens.MenuScreen;
import com.zypo8.games.Screens.new_game_system.save_system.SaveGame;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.talents.talentSystem.TalentSystem;
import com.zypo8.games.items.talents.talentSystem.TalentTree;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.Tools;

public class MenuWIndow extends Window {
    private TextButton optionsBTN, interfaceBTN, reasumeBTN, menuAndSaveBTN;
    private Table table;
    public MenuWIndow() {
        super("", Tools.getSkin());
        Drawable menuBackground = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/windows/MenuWindow.png"))));
        setBackground(menuBackground);
        setMovable(false);
        setSize(125, 210);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setUpButtons();
        setVisible(false);
        setY(Gdx.graphics.getHeight()/2-getHeight()/2);
        setX(Gdx.graphics.getWidth()/2-getWidth()/2);
        //posiionUpdate();
        if (table == null)
            setUpTable();
        addActor(table);
    }


    private void setUpButtons() {
        optionsBTN = new TextButton("Options", Tools.getSkin());
        interfaceBTN = new TextButton("Interface", Tools.getSkin());
        reasumeBTN = new TextButton("Reasume", Tools.getSkin());
        menuAndSaveBTN = new TextButton("Save & Exit", Tools.getSkin());
        optionsBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MyRPGGame.options.setVisible(true);
                MyRPGGame.options.hit(0, 0, true);
            }
        });
        interfaceBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //buttonBackClick();
            }
        });
        menuAndSaveBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new SaveGame().createSave();
                Player.inventoryWindow = null;
                Player.equipmentWindow = null;
                Player.talentsWindow = null;
                InventorySlot.slotsNumber = 0;
                HUDStage.lastClickedSlot = null;
                TalentSystem.talentTrees = null;
                TalentSystem.talentSpend = 0;
                TalentTree.talentTreeCount = 0;
                GameScreen.stage = null;
                GameScreen.hud = null;
                GameScreen.gameWorld = null;
                GameScreen.floor = 0;
                MyRPGGame.options.setVisible(false);
                MenuScreen.game.setScreen(new MenuScreen(MenuScreen.game));
            }
        });
        reasumeBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setVisible(false);
            }
        });
    }

    private void setUpTable(){
        table = new Table();
        table.setFillParent(true);
        table.add(optionsBTN).expand();
        table.row();
        table.add(interfaceBTN).expand();
        table.row();
        table.add(menuAndSaveBTN).expand();
        table.row();
        table.add(reasumeBTN).expand();
        table.row();
    }
}
