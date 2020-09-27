package com.zypo8.games.Screens.new_game_system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.zypo8.games.actors.player.classes.Classes;


public class ClassIcon extends Actor {
    private Sprite selectedSprite = new Sprite(new Texture(Gdx.files.internal("img/placeHolders/palladin.png"))),
            sprite = new Sprite(new Texture(Gdx.files.internal("img/placeHolders/mithrilNeck.png")));

    private boolean selected;
    public Classes PlayerCLass;



    public ClassIcon(){
        this.setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        this.setTouchable(Touchable.enabled);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(selected){
            selectedSprite.draw(batch);
        }
        else {
            sprite.draw(batch);
        }
    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
        selectedSprite.setPosition(getX(), getY());
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Classes getPlayerCLass() {
        return PlayerCLass;
    }

    public void setPlayerCLass(Classes playerCLass) {
        PlayerCLass = playerCLass;
    }
}
