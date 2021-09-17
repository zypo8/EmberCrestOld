package com.zypo8.games.ui.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.items.TalentSlot;
import com.zypo8.games.items.talents.talentSystem.TalentSystem;
import com.zypo8.games.items.talents.talentSystem.TalentTree;
import com.zypo8.games.items.talents.talentSystem.class_talent_system.MageTalentSystem;
import com.zypo8.games.ui.Tools;

public class TalentsWindow extends Window {
    //public static Array<Talent> talents;
    public static Array<TalentSlot> talentSlots;
    private TalentSystem talentSystem;
    public static Array<TalentTree> talentTrees;


    public TalentsWindow(int id){
        super("", Tools.getSkin());
        setSize(700, 800);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setMovable(false);
        talentSlots = new Array<>(true, 256);
        setY(Gdx.graphics.getHeight()/2-getHeight()/2);
        setX(Gdx.graphics.getWidth()/2-getWidth()/2);
        Drawable talentBackground = new TextureRegionDrawable(new TextureRegion( new Texture(Gdx.files.internal("img/ui/windows/talentBackgound.png"))));
        background(talentBackground);

        switch (id){
            case 1:
                talentSystem = new TalentSystem();
                break;
            case 2:
                talentSystem = new TalentSystem();
                break;
            case 3:
                talentSystem = new TalentSystem();
                break;
            case 4:
                talentSystem = new TalentSystem();
                break;
            case 5:
                talentSystem = new TalentSystem();
                break;
            case 6:
                talentSystem = new TalentSystem();
                break;
            case 7:
                talentSystem = new TalentSystem();
                break;
            case 8:
                talentSystem = new MageTalentSystem();
                break;
            default:
                talentSystem = new TalentSystem();
        }
        addActor(talentSystem.getTable());

        talentTrees = new Array<>(true, 16);
        for (TalentTree talentTree: TalentSystem.talentTrees)
            talentTrees.add(talentTree);
    }


    public TalentsWindow() {
        super("Talents", Tools.getSkin());
        setMovable(true);
        setSize(600, 700);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());

        talentSystem = new TalentSystem();

        addActor(talentSystem.getTable());
    }

    public TalentSystem getTalentSystem() {
        return talentSystem;
    }

    public void setTalentSystem(TalentSystem talentSystem) {
        this.talentSystem = talentSystem;
    }

}
