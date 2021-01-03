package com.zypo8.games.ui.hud.playerFrame;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.ui.hud.tools.SpriteActor;

public class ExpBar extends Group {
    public SpriteActor spriteActor = new SpriteActor("img/ui/ExpBarTexture.png");

    public ExpBar() {
        setTouchable(Touchable.enabled);
        setBounds(spriteActor.getX(), spriteActor.getY(), spriteActor.getWidth(), spriteActor.getHeight());
        addActor(spriteActor);
        spriteActor.setZIndex(0);
        setValue(PlayerStats.getEXP(), PlayerStats.getExpToNextLevel());
    }

    public void UpdateExpBar(float factor){
        removeActor(spriteActor);
        Pixmap pixmap = new Pixmap(Gdx.files.getFileHandle("img/ui/ExpBarTexture.png", Files.FileType.Internal));

        Pixmap partTexture = new Pixmap((int)spriteActor.getWidth(), (int)spriteActor.getHeight(), Pixmap.Format.RGBA8888);
        partTexture.drawPixmap(pixmap, 0, 0, 0, 0, (int)spriteActor.getWidth(), (int)(spriteActor.getHeight()*factor));

        spriteActor = new SpriteActor(new Texture(partTexture, Pixmap.Format.RGBA8888, false));
        addActor(spriteActor);
        pixmap.dispose();
        partTexture.dispose();


    }

    public void setValue(float value, float maxValue){
        float ratio = value/maxValue;
        UpdateExpBar(ratio);
    }
}
