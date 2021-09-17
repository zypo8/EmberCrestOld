package com.zypo8.games.ui.windows;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.tools.InfoWindow;

public class SelectAmountWindow extends Group {
    private InfoWindow infoWindow;
    public static int selectedAmount;
    public static int maxAmount = 20;
    private final Label label;
    private Table table;
    private static Slider slider;
    private final TextButton cancelBTN;
    private final TextButton okBTN;

    public SelectAmountWindow(){
        cancelBTN = new TextButton("Cancel", Tools.getSkin());
        okBTN = new TextButton("ok", Tools.getSkin());
        cancelBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setVisible(false);
            }
        });

        okBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                actionOnOkClick();
                setVisible(false);
            }
        });
        label = new Label("", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        slider = new Slider(0, 20, 1, false, Tools.getSkin());
        table = new Table();
        table.add(label).expand().center().colspan(2);
        table.row();
        table.add(slider).expand().center().colspan(2);
        table.row();
        table.add(cancelBTN);
        table.add(okBTN);
        infoWindow = new InfoWindow(table, table.getPrefWidth()+30, table.getPrefHeight()+30);
        setWidth(infoWindow.getWidth());
        setHeight(infoWindow.getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
        setTouchable(Touchable.enabled);
        addActor(infoWindow);
        setVisible(false);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }


    public void changeMaxValue(int value){
        clear();
        maxAmount = value;
        slider = new Slider(1, value, 1, false, Tools.getSkin());
        selectedAmount = (int) slider.getValue();
        label.setText(selectedAmount+" / "+maxAmount);
        slider.addListener(new ChangeListener() {
                               @Override
                               public void changed(ChangeEvent event, Actor actor) {
                                       selectedAmount = (int) slider.getValue();
                                       label.setText(selectedAmount+" / "+maxAmount);

                               }
                           });
                table = new Table();
        table.add(label).expand().center().colspan(2);
        table.row();
        table.add(slider).expand().center().colspan(2);
        table.row();
        table.add(cancelBTN);
        table.add(okBTN);
        infoWindow = new InfoWindow(table, table.getPrefWidth()+30, table.getPrefHeight()+30);
        addActor(infoWindow);

    }

    public void actionOnOkClick(){

    }

}
