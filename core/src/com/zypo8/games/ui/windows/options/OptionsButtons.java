package com.zypo8.games.ui.windows.options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.MyRPGGame;


public class OptionsButtons extends Group {
    public OptionButton generalBTN, interfaceBTN, videoBTN, audioBTN, keybindsBTN, backBTN;
    public Array<OptionButton> buttons;
    public ButtonGroup buttonGroup;
    public Table table;
    public OptionsButtons() {
        buttonGroup = new ButtonGroup();
        generalBTN = new OptionButton("General");
        generalBTN.setSize(Gdx.graphics.getWidth()/30*8, Gdx.graphics.getHeight()/60*8);
        interfaceBTN = new OptionButton("Interface");
        interfaceBTN.setSize(Gdx.graphics.getWidth()/30*8, Gdx.graphics.getHeight()/60*8);
        videoBTN = new OptionButton("Video");
        videoBTN.setSize(Gdx.graphics.getWidth()/30*8, Gdx.graphics.getHeight()/60*8);
        audioBTN = new OptionButton("Audio");
        audioBTN.setSize(Gdx.graphics.getWidth()/30*8, Gdx.graphics.getHeight()/60*8);
        keybindsBTN = new OptionButton("Keybinds");
        keybindsBTN.setSize(Gdx.graphics.getWidth()/30*8, Gdx.graphics.getHeight()/60*8);
        backBTN = new OptionButton("Back");
        backBTN.setSize(Gdx.graphics.getWidth()/30*8, Gdx.graphics.getHeight()/60*8);
        buttonGroup.add(generalBTN);
        buttonGroup.add(interfaceBTN);
        buttonGroup.add(videoBTN);
        buttonGroup.add(audioBTN);
        buttonGroup.add(keybindsBTN);
        buttonGroup.setUncheckLast(true);
        generalBTN.setChecked(true);
        generalBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MyRPGGame.options.refreshOptions(0);
            }
        });
        interfaceBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MyRPGGame.options.refreshOptions(1);
            }
        });
        videoBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MyRPGGame.options.refreshOptions(2);
            }
        });
        audioBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MyRPGGame.options.refreshOptions(3);
            }
        });
        keybindsBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MyRPGGame.options.refreshOptions(4);
            }
        });
        backBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MyRPGGame.options.setVisible(false);
                backBTN.setChecked(false);
                //generalBTN.setChecked(true);
            }
        });
        buttons = new Array<>(5);
        buttons.add(generalBTN);
        buttons.add(interfaceBTN);
        buttons.add(videoBTN);
        buttons.add(audioBTN);
        buttons.add(keybindsBTN);

        setUpTable();
        addActor(table);
    }


    public void setUpTable() {
        clear();
        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        //table.add(interfaceBTN);
        table.add(generalBTN).width(generalBTN.getWidth()).height(generalBTN.getHeight());
        table.row();
        table.add(interfaceBTN).width(interfaceBTN.getWidth()).height(interfaceBTN.getHeight());
        table.row();
        table.add(videoBTN).width(videoBTN.getWidth()).height(videoBTN.getHeight());
        table.row();
        table.add(audioBTN).width(audioBTN.getWidth()).height(audioBTN.getHeight());
        table.row();
        table.add(keybindsBTN).width(keybindsBTN.getWidth()).height(keybindsBTN.getHeight());
        table.row();
        table.add(backBTN).width(backBTN.getWidth()).height(backBTN.getHeight());
        table.row();
        addActor(table);
    }

    class OptionButton extends ImageButton {
        public Label label;

        public OptionButton(String text) {
            super(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/option_button.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/option_button_pressed.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/option_button_checked.png")))));
            label = new Label(text, new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            setName(text);
            this.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                }
            });
            label.setPosition(getWidth()/2-label.getWidth()/2, getHeight()/2-label.getHeight()/2);
            addActor(label);

        }
    }
}
