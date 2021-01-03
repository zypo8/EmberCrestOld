package com.zypo8.games.items.talents.class_talents.palladyn;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.actors.player.PlayerStats;
import com.zypo8.games.items.talents.talentSystem.Talent;
import com.zypo8.games.items.talents.talentSystem.TalentTree;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.windows.ItemDescriptionWIndow;

public class Pal1 extends Talent {
    public Pal1(TalentTree talentTree) {
        super(Assets.slash, "img/ability/Slash_inactive.png",  0, 3, "Dupczkoks Vengance");
        this.setTalentTree(talentTree);
    }

    public Pal1() {
        super(Assets.slash, "img/ability/Slash_inactive.png", 0, 3, "Dupczkoks Vengance");
    }

    @Override
    public void setUpHoverWindow() {
        itemDescriptionWIndow = new ItemDescriptionWIndow(getName(), Tools.getSkin());
        itemDescriptionWIndow.setHeight(100);
        description.setText("Adds 3 Strength");
        itemDescriptionWIndow.add(description);
        itemDescriptionWIndow.setVisible(false);
    }

    @Override
    public void effect(boolean add) {
        if(add)
            PlayerStats.setStrenght(PlayerStats.getStrenght()+3);
        else
            PlayerStats.setStrenght(PlayerStats.getStrenght()-3);
    }

    @Override
    public void effect(int amount) {
        PlayerStats.setStrenght(PlayerStats.getStrenght()+(3*amount));
    }

    @Override
    public void itemHoverWindow(Window window, Skin skin) {
        window.setHeight(100);
        super.itemHoverWindow(window, skin);

    }
}
