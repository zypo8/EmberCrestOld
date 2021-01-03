package com.zypo8.games.ui.windows.options.all_options;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.options.LoadOptions;
import com.zypo8.games.ui.windows.options.SaveOptions;

public class KeybindsOptions extends Table {
    public static String W="W";
    Label label = new Label("KeybindsOptions", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    public CheckBox checkBox;
    TextButton applyButton;
    public KeybindsOptions() {
        initOptions();
        initTable();

    }

    private void initOptions() {
        checkBox = new CheckBox("Dupa", Tools.getSkin());
        applyButton = new TextButton("Apply", Tools.getSkin());
        applyButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SaveOptions.createSave();
                new LoadOptions();
            }
        });
        //on load load from fili
    }

    private void initTable() {
        setDebug(true);
        add(label).expand().colspan(2);
        row();
        add(checkBox).expand();
        add().expand();
        row();
        add().expand();
        add().expand();
        row();
        add().expand();
        add().expand();
        row();
        add().expand();
        add().expand();
        row();
        add().expand();
        add().expand();
        row();
        add().expand();
        add().expand();
        row();
        add().expand();
        add(applyButton).expand();
    }
}
