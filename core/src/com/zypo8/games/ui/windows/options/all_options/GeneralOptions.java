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

public class GeneralOptions extends Table {
    Label label = new Label("GeneralOptions", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    public static CheckBox autoSave, autoLoot, HealAndDamageText;
    TextButton applyButton;
    public GeneralOptions() {
        initOptions();
        initTable();

    }

    private void initOptions() {
        autoSave = new CheckBox("Enables auto Save On(auto save after every battle(up to 3 auto saves))", Tools.getSkin());
        autoLoot = new CheckBox("Enables auto Loot", Tools.getSkin());
        HealAndDamageText = new CheckBox("Displays out of combat heal and damage text", Tools.getSkin());
        applyButton = new TextButton("Apply", Tools.getSkin());
        applyButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SaveOptions.createSave();
                new LoadOptions();
            }
        });
        autoLoot.setChecked((Boolean) LoadOptions.generalData.get("AutoLoot"));
        autoSave.setChecked((Boolean) LoadOptions.generalData.get("AutoSave"));
        HealAndDamageText.setChecked((Boolean) LoadOptions.generalData.get("ScrollCombatText"));
    }

    private void initTable() {
        setDebug(false);
        add(label).expand().colspan(2);
        row();
        add(autoSave).expand().colspan(2);
        row();
        add(autoLoot).expand().colspan(2);
        row();
        add(HealAndDamageText).expand().colspan(2);
        row();
        add().expand().colspan(2);
        row();
        add().expand().colspan(2);
        row();
        add().expand().colspan(2);
        row();
        add().expand();
        add(applyButton).expand();
    }
}
