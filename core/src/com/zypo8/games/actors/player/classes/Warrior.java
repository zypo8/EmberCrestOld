package com.zypo8.games.actors.player.classes;

import com.zypo8.games.actors.player.Player;

public class Warrior extends Player {
    public Warrior() {
        super("img/characters/player.gif", 32 * 10, 32 * 10, 5);
    }
//    public Warrior() {
//        super("img/characters/player.gif", 32 * 10, 32 * 10, GameScreen.hud.hudStage, GameScreen.stage, (TiledMapTileLayer) GameScreen.getWorld().map.getLayers().get(0), 5);
//    }
}
