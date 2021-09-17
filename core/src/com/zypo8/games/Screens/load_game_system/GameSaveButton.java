package com.zypo8.games.Screens.load_game_system;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zypo8.games.ui.Tools;

import java.io.File;

public class GameSaveButton extends Group {
    private final Window window;
    private File file;
    private boolean selected;
    public GameSaveButton(final File file){
        this.file = file;
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), 120, 300);
        window = new Window(file.getName().substring(0, file.getName().length()-4), Tools.getSkin());
        window.getTitleLabel().setAlignment(1);
        window.setMovable(false);
        window.setHeight(80);
        window.setWidth(300);
        setBounds(0, 0, window.getWidth(), window.getHeight());
        window.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                GetSaves.UnSelectAll();
                selected = true;
                LoadGameScreen.SelectedSave = file;
            }
        });
        addActor(window);

    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if(selected){
            window.setHeight(120);
        }
        else
            window.setHeight(80);
    }

    public void unselect() {
        selected = false;
    }
    public boolean getSelected(){
        return selected;
    }
}
