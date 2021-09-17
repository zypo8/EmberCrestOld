package com.zypo8.games.Screens.new_game_system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.actors.player.classes.Classes;

public class NewGameStage extends Stage {
    private ClassDescriptionWIndow classDescriptionWIndow;
    private Vector2 coord;
    private ClassIcon hitActor;
    public static Classes PlayerClass;

    public NewGameStage(Viewport viewport, SpriteBatch batch) {
        super(viewport, batch);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        coord = screenToStageCoordinates(new Vector2((float)screenX, (float)screenY));
        try {
            hitActor = (ClassIcon) hit(coord.x, coord.y, true);
        }
        catch (ClassCastException e){
            return false;
        }
        if(hitActor != null) {
            Gdx.app.log("HIT", hitActor.getName());
            if(button == 0){
                System.out.println(hitActor.getName());
                MagicIcons.unSelectAll();
                TechIcons.unSelectAll();
                hitActor.setSelected(true);
                PlayerClass = hitActor.PlayerCLass;
            }
        }
        else {
            return false;
        }
        return true;
    }
}
