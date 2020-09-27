package com.zypo8.games.items;

import com.badlogic.gdx.graphics.Color;

public enum ItemRarity {
    Common(Color.BLACK, 1),
    UnCommon(Color.GREEN, 1),
    Rare(Color.BLUE, 1),
    Epic(Color.PURPLE, 1),
    Legendary(Color.CYAN, 1);


    public Color getColor() {
        return color;
    }

    public float getChances() {
        return chances;
    }

    private final Color color;
    private final float chances;
    ItemRarity(Color color, float chances) {
        this.color = color;
        this.chances = chances;
    }
}
