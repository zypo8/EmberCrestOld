package com.zypo8.games.actors.stairs;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.actors.Interactable;
import com.zypo8.games.ui.HUDStage;

public class Stairs extends Interactable {
    protected int maxFloor, minFloor;
    public Stairs(String spriteFIle, int posX, int posY, HUDStage hudStage, String actorName, int minFloor, int maxFloor) {
        super(spriteFIle, posX, posY, hudStage, actorName);
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    @Override
    public void interactWindow(Window window, Skin skin) {
        window.setHeight(120);
        if(GameScreen.floor < maxFloor)
            window.add(interactButtons.goUp(this));
        window.row();
        if (GameScreen.floor > minFloor )
            window.add(interactButtons.goDown(this));
    }

    @Override
    public void firstOption() {
        if((GameScreen.floor >= minFloor) && (GameScreen.floor < maxFloor))
            goUp();
        else if(GameScreen.floor == maxFloor)
            goDown();
    }

    @Override
    public void goUp() {
        //GameScreen.stage.addActor(GameScreen.player);
        GameScreen.floor++;
        GameScreen.worldUpdate();
    }

    @Override
    public void goDown() {
        //GameScreen.stage.addActor(GameScreen.player);
        GameScreen.floor--;
        GameScreen.worldUpdate();
    }
}
