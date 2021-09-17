package com.zypo8.games.levels;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.zypo8.games.Screens.GameScreen;
import com.zypo8.games.Screens.StageGameScreen;
import com.zypo8.games.ui.HUDStage;

public class GameWorld {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    private final SetUpNPC setUpNPC;

    public GameWorld(StageGameScreen gameScreenStage, HUDStage hudStage){
        setUpNPC = new SetUpNPC(hudStage);
        gameScreenStage.addActor(setUpNPC);
    }

    public void update(String mapName){
        setUpNPC.update(GameScreen.floor);
        if(GameScreen.floor == 0)
            map = new TmxMapLoader().load(mapName+ GameScreen.floor+".tmx");

        if(GameScreen.floor == 1)
            map = new TmxMapLoader().load(mapName+ GameScreen.floor+".tmx");

        renderer = new OrthogonalTiledMapRenderer(map);

    }
}
