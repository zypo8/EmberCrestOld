package com.zypo8.games.actors.player.classes;

import com.zypo8.games.actors.player.Player;

public enum Classes {
    Palladyn(1),
    Archer(2),
    Shaman(3),
    Rogue(4),
    Warrior(5),
    Hunter(6),
    Barbarian(7),
    Mage(8);

    public final int id;
    Classes(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static Player getClassById(long id){
        switch ((int) id){
            case 1:
                return new Palladyn();
            case 2:
                return new Archer();
            case 3:
                return new Shaman();
            case 4:
                return new Rogue();
            case 5:
                return new Warrior();
            case 6:
                return new Hunter();
            case 7:
                return new Barbarian();
            case 8:
                return new Mage();
            default:
                return null;
        }
    }
}
