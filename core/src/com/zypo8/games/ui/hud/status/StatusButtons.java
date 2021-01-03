package com.zypo8.games.ui.hud.status;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.new_game_system.AutoSave;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.Tools;

public class StatusButtons extends Group {
    private ImageButton inventoryIB, talentsIB, questLogIB, equipmentIB, spellBookIB, saveIB, optionsIB;
    private Table table;
    public StatusButtons(){

        //scaleBy(0.7f);
        setUpButtons();
        setUpTable();
        addActor(table);
    }

    private void setUpButtons() {
        Drawable inventoryIBImage = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/inventory.png"))));
        Drawable talentsIBImage = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/talents.png"))));
        Drawable questLogIBImage = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/talents.png"))));
        Drawable eqIBImage = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/eq.png"))));
        Drawable spellBookIBImage = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/talents.png"))));
        Drawable saveIBImage = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/save.png"))));
        Drawable saveIBImagePressed = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/save2.png"))));
        Drawable optionsIBImage = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/options.png"))));

        //Drawable optionsIBImage = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/options.png"))));
        inventoryIB = new ImageButton(inventoryIBImage);
        talentsIB = new ImageButton(talentsIBImage);
        questLogIB = new ImageButton(Tools.getSkin());
        equipmentIB = new ImageButton(eqIBImage);
        spellBookIB = new ImageButton(talentsIBImage);
        saveIB = new ImageButton(saveIBImage, saveIBImagePressed);
        optionsIB = new ImageButton(optionsIBImage);




        inventoryIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Player.inventoryWindow.setVisible(!Player.inventoryWindow.isVisible());
            }
        });
        talentsIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Player.talentsWindow.setZIndex(99999);
                Player.talentsWindow.setVisible(!Player.talentsWindow.isVisible());
            }
        });
        questLogIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Quest Log");
            }
        });
        equipmentIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Player.equipmentWindow.setVisible(!Player.equipmentWindow.isVisible());
            }
        });
        spellBookIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Player.spellBoockWindow.setVisible(!Player.spellBoockWindow.isVisible());
            }
        });
        saveIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //new SaveGame().createSave();
                new AutoSave().createAutoSave();
                System.out.println("Saved");
                HUD.warningLabel.clearActions();
                HUD.warningLabel.addAction(Actions.alpha(1, 0));
                HUD.warningLabel.setText("Saved Succesfull");
                HUD.warningLabel.addAction(Actions.alpha(0, 4));
            }
        });
        optionsIB.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("optionsIB ");
                MyRPGGame.menuWIndow.setVisible(!MyRPGGame.menuWIndow.isVisible());
                //MyRPGGame.menuWIndow.hit(0, 0, true);
            }
        });
    }

    private void setUpTable(){
        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        table.add(inventoryIB).width(28).height(28);
        table.add(talentsIB).width(28).height(28);
        table.add(questLogIB).width(28).height(28);
        table.add(equipmentIB).width(28).height(28);
        table.add(spellBookIB).width(28).height(28);
        table.add(saveIB).width(28).height(28);
        table.add(optionsIB).width(28).height(28);
    }
}
