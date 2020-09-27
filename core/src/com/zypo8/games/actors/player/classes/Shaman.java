package com.zypo8.games.actors.player.classes;

import com.zypo8.games.actors.player.Player;

public class Shaman extends Player {
    public Shaman() {
        super("img/characters/player.gif", 32 * 10, 32 * 10, 3);
    }
//    public Shaman() {
//        super("img/characters/player.gif", 32 * 10, 32 * 10, GameScreen.hud.hudStage, GameScreen.stage, (TiledMapTileLayer) GameScreen.getWorld().map.getLayers().get(0), 3);
//    }
}
