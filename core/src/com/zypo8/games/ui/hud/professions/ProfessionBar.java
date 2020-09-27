package com.zypo8.games.ui.hud.professions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.zypo8.games.ui.Tools;

public class ProfessionBar extends Group {
    private ProgressBar progressBar = new ProgressBar(0, 100, 0.1f, false, Tools.getSkin());
    private Sprite sprite = new Sprite(new Texture(Gdx.files.internal("img/ui/professions/crafting.png")));
    public ProfessionBar(){
        progressBar.setHeight(40);
        progressBar.setWidth(80);
        setBounds(getX(), getY(), progressBar.getWidth(), progressBar.getHeight());
        setTouchable(Touchable.enabled);
        addActor(progressBar);
        sprite.setPosition(getX(), getY());

        progressBar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showProfession();
            }
        });

        progressBar.addListener(new ClickListener(){
            @Override
            public boolean isOver(Actor actor, float x, float y) {
                System.out.println("progressBar clicked");
                return true;
            }
        });
    }


    private void showProfession(){
        System.out.println("Showing profession");
    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
    }
}
