package com.zypo8.games.levels;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.actors.gatherable.MithrillOre;
import com.zypo8.games.actors.npc.Vendor;
import com.zypo8.games.actors.stairs.Stairs;
import com.zypo8.games.ui.HUDStage;

public class SetUpNPC extends Group {
    private final HUDStage hudStage;
    private final SetUpNpc0 setUpNpc0;
    private final SetUpNpc1 setUpNpc1;
    private final SetUpNpc2 setUpNpc2;
    private final SetUpNpc3 setUpNpc3;
    private final SetUpNpc4 setUpNpc4;
    public SetUpNPC(HUDStage hudStage){
        this.hudStage = hudStage;
        setUpNpc0 = new SetUpNpc0();
        setUpNpc1 = new SetUpNpc1();
        setUpNpc2 = new SetUpNpc2();
        setUpNpc3 = new SetUpNpc3();
        setUpNpc4 = new SetUpNpc4();
        addActor(setUpNpc0);
        addActor(setUpNpc1);
        addActor(setUpNpc2);
        addActor(setUpNpc3);
        addActor(setUpNpc4);
    }

    public void update(int floor){
        setUpNpc0.setVisible(false);
        setUpNpc1.setVisible(false);
        setUpNpc2.setVisible(false);
        setUpNpc3.setVisible(false);
        setUpNpc4.setVisible(false);
        if(floor == 0) {
            setUpNpc0.setVisible(true);
        }
        else if(floor == 1) {
            setUpNpc1.setVisible(true);
        }
        else if(floor == 2) {
            setUpNpc2.setVisible(true);
        }
        else if(floor == 3) {
            setUpNpc3.setVisible(true);
        }
        else if(floor == 4) {
            setUpNpc4.setVisible(true);
        }
    }


    private class SetUpNpc0 extends Group {
        public SetUpNpc0() {
            addActor(new Vendor(10*32, 9*32,hudStage));
            addActor(new MithrillOre(8*32, 8*32, hudStage));
            addActor(new Stairs(Assets.stairs, 9*32,9*32,hudStage, "Stairs",0,1));
        }
    }

    private class SetUpNpc1 extends Group {
        public SetUpNpc1() {
            addActor(new Vendor(4*32, 4*32, hudStage));
            addActor(new Stairs(Assets.stairs, 9*32, 9*32, hudStage, "Stairs", 0, 1));
        }
    }


    private class SetUpNpc2 extends Group {
        public SetUpNpc2() {
            addActor(new Vendor(4*32, 4*32, hudStage));
            addActor(new Stairs(Assets.stairs, 9*32, 9*32, hudStage, "Stairs", 0, 1));
        }
    }


    private class SetUpNpc3 extends Group {
        public SetUpNpc3() {

        }
    }


    private class SetUpNpc4 extends Group {
        public SetUpNpc4() {

        }
    }
}
