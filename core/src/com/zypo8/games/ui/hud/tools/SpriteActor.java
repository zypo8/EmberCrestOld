package com.zypo8.games.ui.hud.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class SpriteActor extends Actor {
    Sprite sprite;
    public SpriteActor(String filePath) {
        sprite = new Sprite(new Texture(Gdx.files.internal(filePath)));
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }
}