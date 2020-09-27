package com.zypo8.games.ui.hud.minimap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Minimap extends Table {
    public Minimap(){
        setName("Minimap");
        setHeight(Gdx.graphics.getHeight()/100f*30);
        setWidth((Gdx.graphics.getWidth()/100f)*18);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setTouchable(Touchable.enabled);
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/placeHolders/minimap.png"))));
        setBackground(drawable);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
