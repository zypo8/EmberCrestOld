package com.zypo8.games.actors.gatherable;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.actors.Interactable;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.windows.LootWindow;

public class LootDrop extends Interactable {
    protected LootWindow lootWindow;
    protected boolean isActive = true;
    public LootDrop(int posX, int posY, HUDStage hudStage,String actorName) {
        super(Assets.loot, posX, posY, hudStage, actorName);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }


    @Override
    public void interactWindow(Window window, Skin skin) {
        firstOption();
    }

    @Override
    public void firstOption() {
        hudStage.addActor(lootWindow);
    }

    public void addItemsToLootWindow() {
    }

}
