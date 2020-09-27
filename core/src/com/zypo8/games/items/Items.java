package com.zypo8.games.items;


import com.zypo8.games.items.armor.boots.MithrilBoots;
import com.zypo8.games.items.armor.chests.MithrilChest;
import com.zypo8.games.items.armor.helms.BrokenHelmet;
import com.zypo8.games.items.armor.helms.MithrilHelmet;
import com.zypo8.games.items.armor.legs.MithrilLegplates;
import com.zypo8.games.items.armor.necks.EmeraldNeck;
import com.zypo8.games.items.consumable.Apple;
import com.zypo8.games.items.consumable.BadApple;
import com.zypo8.games.items.consumable.potions.HealthPotion;
import com.zypo8.games.items.consumable.potions.ManaPotion;

public enum Items {
    Apple(1),
    Apple2(2),
    MithrilHelmet(3),
    BrokenHelmet(4),
    EmeraldNeck(5),
    BadApple(6),
    ManaPotion(7),
    HealthPotion(8),
    MithrilChest(9),
    MithrilBoots(10),
    MithrilLegplates(11),
    Coins(30);



    public int getId() {
        return id;
    }



    private final int id;
    Items(int id) {
        this.id = id;
    }
    public static Item getItemById(int id, Location location){
        switch (id){
            case 1:
                return new Apple(location);
            case 3:
                return new MithrilHelmet(location);
            case 4:
                return new BrokenHelmet(location);
            case 5:
                return new EmeraldNeck(location);
            case 6:
                return new BadApple(location);
            case 7:
                return new ManaPotion(location);
            case 8:
                return new HealthPotion(location);
            case 9:
                return new MithrilChest(location);
            case 10:
                return new MithrilBoots(location);
            case 11:
                return new MithrilLegplates(location);
            default:
                return new BadApple(location);
        }
    }
}
