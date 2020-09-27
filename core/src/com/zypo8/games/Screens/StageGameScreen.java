package com.zypo8.games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.actors.Interactable;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.ui.windows.InteractWindow;


public class StageGameScreen extends Stage {
    private MyRPGGame game;
    private InteractWindow window;
    private Vector2 coord;
    private Interactable hitActor;
    public boolean wPressed, sPressed, aPressed, dPressed;
    public Array<String> wsad = new Array<>(true, 4);

    public StageGameScreen(Viewport viewport, Batch batch, MyRPGGame game) {
        super(viewport, batch);
        this.game = game;
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        coord = screenToStageCoordinates(new Vector2((float)screenX, (float)screenY));
        try {
            hitActor = (Interactable) hit(coord.x, coord.y, true);
        }
        catch (ClassCastException e){
            if (window != null)
                window.remove();
            //e.printStackTrace();
            return false;
        }
        if(hitActor != null) {
            if (hitActor.getClass().getName().substring(0, 22).equals("com.zypo8.games.actors")) {
                if (window != null)
                    window.remove();
                Gdx.app.log("HIT", hitActor.getName());
                if(button == 0){
                    if(Player.destX > hitActor.getX()-33 && Player.destX < hitActor.getX()+33) {
                        if(Player.destY > hitActor.getY()-33 && Player.destY < hitActor.getY()+33) {
                            hitActor.firstOption();
                        }
                    }
                }
                else if(button == 1 && !Player.Player_moving) {
                    window = new InteractWindow(hitActor.getName(), game.skin);
                    window.setPosition(getRoot().findActor(hitActor.getName()).getX() + 32, getRoot().findActor(hitActor.getName()).getY() + 32);
                    hitActor.interactWindow(window, game.skin);

                    if(Player.destX > hitActor.getX()-33 && Player.destX < hitActor.getX()+33) {
                        if(Player.destY > hitActor.getY()-33 && Player.destY < hitActor.getY()+33) {
                            addActor(window);
                        }
                    }

                }
            }
        }
        else {
            if (window != null)
                window.remove();
            return false;
        }
        return true;
    }
    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.W:
                wsad.add("W");
                wPressed = true;
                aPressed = false;
                sPressed = false;
                dPressed = false;
                if (window != null)
                    window.remove();
                break;
            case Input.Keys.S:
                wsad.add("S");
                sPressed = true;
                aPressed = false;
                wPressed = false;
                dPressed = false;
                if (window != null)
                    window.remove();
                break;
            case Input.Keys.A:
                wsad.add("A");
                aPressed = true;
                wPressed = false;
                sPressed = false;
                dPressed = false;
                if (window != null)
                    window.remove();
                break;
            case Input.Keys.D:
                wsad.add("D");
                dPressed = true;
                aPressed = false;
                sPressed = false;
                wPressed = false;
                if (window != null)
                    window.remove();
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.W:
                wsad.removeValue("W", false);
                wPressed = false;
                break;
            case Input.Keys.S:
                wsad.removeValue("S", false);
                sPressed = false;
                break;
            case Input.Keys.A:
                wsad.removeValue("A", false);
                aPressed = false;
                break;
            case Input.Keys.D:
                wsad.removeValue("D", false);
                dPressed = false;
                break;
        }
        return true;
    }

}
