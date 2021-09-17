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

public class AudioOptions  extends Table {
    Label label = new Label("AudioOptions", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    public CheckBox checkBox;
    TextButton applyButton;
    public AudioOptions() {
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
