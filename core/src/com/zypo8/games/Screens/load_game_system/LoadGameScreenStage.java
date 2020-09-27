package com.zypo8.games.Screens.load_game_system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.Screens.new_game_system.ClassIcon;
import com.zypo8.games.ui.windows.SaveContainerWindow;

public class LoadGameScreenStage extends Stage {
    public SaveContainerWindow saveContainerWindow;

    private Vector2 coord;
    private ClassIcon hitActor;

    public LoadGameScreenStage(Viewport viewport, SpriteBatch batch) {
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
        System.out.println("CLICKED");
        if(hitActor != null) {
            Gdx.app.log("HIT", hitActor.getName());
            if(button == 0){
                System.out.println(hitActor.getName());
            }
        }
        else {
            return false;
        }
        return true;
    }

//    @Override
//    public boolean scrolled(int amount) {
//        saveContainerWindow.table.setY(saveContainerWindow.table.getY()+amount*25);
//        return true;
//    }

    public void setSaveContainerWindow(SaveContainerWindow saveContainerWindow) {
        this.saveContainerWindow = saveContainerWindow;
    }

}
