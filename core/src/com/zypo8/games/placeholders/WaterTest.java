package com.zypo8.games.placeholders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class WaterTest extends Actor {
    private boolean state1 = true;
    private Sprite sprite, sprite2;

    public WaterTest(String file1, String file2, int x, int y){
        sprite = new Sprite(new Texture(Gdx.files.internal(file1)));
        sprite2 = new Sprite(new Texture(Gdx.files.internal(file2)));
        setPosition(x, y);
    }


    @Override
    public void act(float delta) {
        System.out.println((System.currentTimeMillis()/1000)%2);
        state1 = (System.currentTimeMillis() / 1000) % 2 != 0;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(state1){
            sprite.draw(batch);
        }
        else {
            sprite2.draw(batch);
        }
    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
        sprite2.setPosition(getX(), getY());
    }
}