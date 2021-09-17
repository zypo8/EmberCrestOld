package com.zypo8.games.ui.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zypo8.games.Screens.load_game_system.GameSaveButton;
import com.zypo8.games.Screens.load_game_system.GetSaves;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.tools.SpriteActor;

public class SaveContainerWindow extends Window {
    public Table table;
    public ImageButton saveButtonUp, saveButtonDown;
    public SpriteActor sprite = new SpriteActor("img/placeHolders/Untitled.png");
    public SaveContainerWindow() {
        super("Select Save", Tools.getSkin());
        getTitleLabel().setAlignment(1);
        getTitleLabel().setFontScale(1.5f);
        setMovable(false);
        setSize(Gdx.graphics.getWidth() / 10 * 3, Gdx.graphics.getHeight() / 10 * 9);
        setY(Gdx.graphics.getHeight() / 2 - getHeight() / 2);
        setX(Gdx.graphics.getWidth() / 2 - getWidth() / 2);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setVisible(true);
        new GetSaves();
        setUpTable();
        addActor(table);
        //table.setY(-table.getPrefHeight());

        Drawable saveButtonDownImage0 = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/saveButtonDownImage0.png"))));
        saveButtonDownImage0.setMinWidth(getWidth());
        //Drawable saveButtonDownImage1 = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("saveButtonDownImage1.png"))));
        saveButtonDown = new ImageButton(saveButtonDownImage0);//, saveButtonDownImage1);
        Drawable saveButtonUpImage0 = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/saveButtonUpImage0.png"))));
        saveButtonUpImage0.setMinWidth(getWidth());
        //Drawable saveButtonUpImage1 = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("saveButtonUpImage1.png"))));
        saveButtonUp = new ImageButton(saveButtonUpImage0);//, saveButtonUpImage1);
        saveButtonUp.setPosition(0, getHeight()-saveButtonUp.getHeight()-50);
        addActor(saveButtonDown);
        addActor(saveButtonUp);

        saveButtonDown.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!(table.getY() >= 300))
                    table.setY(table.getY()+100);
            }
        });

        saveButtonUp.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!(table.getY() <= -table.getPrefHeight()+Gdx.graphics.getHeight()-200))
                    table.setY(table.getY()-100);
            }
        });
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
    }

    private void setUpTable() {
        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);

        for(GameSaveButton save:GetSaves.gameSaveButtons) {
            table.add(save);
            table.row();
        }
    }
}
