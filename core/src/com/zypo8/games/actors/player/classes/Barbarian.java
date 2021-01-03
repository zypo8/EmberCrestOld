package com.zypo8.games.actors.player.classes;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.actors.player.Player;

public class Barbarian extends Player {
    public Barbarian() {
        super(Assets.player, 32 * 10, 32 * 10, 7);
    }
//    public Barbarian() {
//        super("img/characters/player.gif", 32 * 10, 32 * 10, GameScreen.hud.hudStage, GameScreen.stage, (TiledMapTileLayer) GameScreen.getWorld().map.getLayers().get(0), 7);
//    }
}
