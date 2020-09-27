package com.zypo8.games.ui.hud.tools;

import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.zypo8.games.ui.Tools;

public class ExpBarr extends ProgressBar {
    public ExpBarr() {
        super(0, 1000, 1, false, Tools.getSkin());
    }
}
