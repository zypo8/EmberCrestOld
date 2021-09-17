package com.zypo8.games.ui.windows.options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.options.all_options.AudioOptions;
import com.zypo8.games.ui.windows.options.all_options.GeneralOptions;
import com.zypo8.games.ui.windows.options.all_options.InterfaceOptions;
import com.zypo8.games.ui.windows.options.all_options.KeybindsOptions;
import com.zypo8.games.ui.windows.options.all_options.VideoOptions;

public class Options extends Window {
    private final OptionsButtons optionsButtons;
    private Table table;
    public GeneralOptions generalOptions;
    public InterfaceOptions interfaceOptions;
    public AudioOptions audioOptions;
    public KeybindsOptions keybindsOptions;
    public VideoOptions videoOptions;
    public Options() {
        super("", Tools.getSkin());
        setMovable(false);
        setSize(Gdx.graphics.getWidth()/10*8, Gdx.graphics.getHeight()/10*8);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        optionsButtons = new OptionsButtons();
        generalOptions = new GeneralOptions();
        interfaceOptions = new InterfaceOptions();
        audioOptions = new AudioOptions();
        keybindsOptions = new KeybindsOptions();
        videoOptions = new VideoOptions();
        setVisible(false);
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/options_window_bg.png"))));
        setBackground(drawable);
        //edge = 3;
        setY(Gdx.graphics.getHeight()/2-getHeight()/2);
        setX(Gdx.graphics.getWidth()/2-getWidth()/2);
        refreshOptions(0);
        addActor(table);
    }


    public void refreshOptions(int i){
        removeActor(table);
        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        table.add(optionsButtons).height(getHeight()).width(getWidth()/3).left();
        table.add(generalOptions).height(getHeight()).width(getWidth()*2/3).right();
        switch (i){
            case 0:
                table.clear();
                table.add(optionsButtons).height(getHeight()).width(getWidth()/3).left();
                table.add(generalOptions).height(getHeight()).width(getWidth()*2/3).right();
                break;
            case 1:
                table.clear();
                table.add(optionsButtons).height(getHeight()).width(getWidth()/3).left();
                table.add(interfaceOptions).height(getHeight()).width(getWidth()*2/3).right();
                break;
            case 2:
                table.clear();
                table.add(optionsButtons).height(getHeight()).width(getWidth()/3).left();
                table.add(videoOptions).height(getHeight()).width(getWidth()*2/3).right();
                break;
            case 3:
                table.clear();
                table.add(optionsButtons).height(getHeight()).width(getWidth()/3).left();
                table.add(audioOptions).height(getHeight()).width(getWidth()*2/3).right();
                break;
            case 4:
                table.clear();
                table.add(optionsButtons).height(getHeight()).width(getWidth()/3).left();
                table.add(keybindsOptions).height(getHeight()).width(getWidth()*2/3).right();
                break;
        }
        addActor(table);
    }

    public void refreshOptionsWindpwOnResize(){
        setSize(Gdx.graphics.getWidth()/10*8, Gdx.graphics.getHeight()/10*8);
        setY(Gdx.graphics.getHeight()/2- getHeight()/2);
        setX(Gdx.graphics.getWidth()/2-getWidth()/2);
    }
}
