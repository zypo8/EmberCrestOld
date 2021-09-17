package com.zypo8.games.items;


import com.zypo8.games.abilities.skills.palladyn_skills.HandCannon;
import com.zypo8.games.abilities.skills.palladyn_skills.HardenessSkill;
import com.zypo8.games.items.armor.boots.MithrilBoots;
import com.zypo8.games.items.armor.chests.MithrilChest;
import com.zypo8.games.items.armor.helms.BrokenHelmet;
import com.zypo8.games.items.armor.helms.MithrilHelmet;
import com.zypo8.games.items.armor.legs.MithrilLegplates;
import com.zypo8.games.items.armor.necks.EmeraldNeck;
import com.zypo8.games.items.consumable.Apple;
import com.zypo8.games.items.consumable.BadApple;
import com.zypo8.games.items.consumable.potions.ExpPotion;
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
    ExpPotion(12),
    Coins(30);



    public int getId() {
        return id;
    }



    private final int id;
    Items(int id) {
        this.id = id;
    }
    public static Item getItemById(int id, ItemLocation itemLocation){
        switch (id){
            case 1:
                return new Apple(itemLocation);
            case 3:
                return new MithrilHelmet(itemLocation);
            case 4:
                return new BrokenHelmet(itemLocation);
            case 5:
                return new EmeraldNeck(itemLocation);
            case 6:
                return new BadApple(itemLocation);
            case 7:
                return new ManaPotion(itemLocation);
            case 8:
                return new HealthPotion(itemLocation);
            case 9:
                return new MithrilChest(itemLocation);
            case 10:
                return new MithrilBoots(itemLocation);
            case 11:
                return new MithrilLegplates(itemLocation);
            case 13:
                return new ExpPotion(itemLocation);
            case 44:
                return new HardenessSkill(itemLocation);
            case 45:
                return new HandCannon(itemLocation);
            default:
                return new BadApple(itemLocation);
        }
    }
}
