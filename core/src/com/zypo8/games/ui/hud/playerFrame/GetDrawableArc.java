package com.zypo8.games.ui.hud.playerFrame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GetDrawableArc {
    public static Drawable getColoredDrawable(int radius, Color color) {
        Pixmap pixmap=new Pixmap(2*radius+1, 2*radius+1, Pixmap.Format.RGBA8888);
        //Pixmap pixmap2=new Pixmap(2*radius+1, 2*radius+1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillCircle(radius, radius, radius);
        //pixmap2.setColor(new Color(0x32cfc7ff));
        //pixmap2.fillCircle(radius, radius, radius);
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));

        pixmap.dispose();

        return drawable;
    }
}
