package com.zypo8.games.abilities.buffs;

import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.abilities.buffs.buffs.Sickness;

public enum Buffs {
    Sickness(20),
    MithrilSetBonusEffect(27);


    Buffs(int id){
        this.id = id;
    }
    private final int id;
    public static Buff getBuffById(int id){
        switch (id){
            case 20:
                return new Sickness();
            case 27:
                return new MithrilSetBonusEffect();
            default:
                return new Sickness();
        }


    }
}
