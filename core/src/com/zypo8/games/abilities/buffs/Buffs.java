package com.zypo8.games.abilities.buffs;

import com.zypo8.games.abilities.buffs.buffs.FreshMind;
import com.zypo8.games.abilities.buffs.buffs.Hardeness;
import com.zypo8.games.abilities.buffs.buffs.MithrilSetBonusEffect;
import com.zypo8.games.abilities.buffs.buffs.Sickness;

public enum Buffs {
    Sickness(20),
    MithrilSetBonusEffect(27),
    Hardeness(47);


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
            case 47:
                return new Hardeness();
            case 48:
                return new FreshMind();
            default:
                return new Sickness();
        }


    }
}
