package com.zypo8.games.actors.player.classes;

import com.zypo8.games.actors.player.Player;

public class Rogue extends Player {
    public Rogue() {
        super("img/characters/player.gif", 32 * 10, 32 * 10, 4);
    }
//    public Rogue() {
//        super("img/characters/player.gif", 32 * 10, 32 * 10, GameScreen.hud.hudStage, GameScreen.stage, (TiledMapTileLayer) GameScreen.getWorld().map.getLayers().get(0), 4);
//    }
}
