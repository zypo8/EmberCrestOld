package com.zypo8.games.items.armor.necks;

import com.zypo8.games.Screens.load_screen.Assets;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.ItemRarity;
import com.zypo8.games.items.armor.Armor;
import com.zypo8.games.items.armor.SlotType;

public class EmeraldNeck extends Armor {
    public EmeraldNeck(ItemLocation itemLocation) {
        super(Assets.emerald_neck, 5, SlotType.Neck, ItemRarity.Common, itemLocation, "Emerald Neck");
        Intellect = 20;
        Strenght = 20;
        Dexterity = 20;
        armor = 20;
        armorPiercing = 20;
        crit = 20;
        focus = 20;
        attackPower = 20;
        Vitality = 20;
        HELATH = 20;
        Dexteritypercentage = 20;
        Intellectpercentage = -20;
        Strenghtpercentage = 20;
        Vitalitypercentage = 20;
        armorpercentage = 20;
        armorPiercingpercentage = 20;
        critpercentage = 20;
        attackPowerpercentage = 20;
        focuspercentage = 20;
        description.setText("on use Heal 27 health\non use Heal 27 health\non use Heal 27 health");
        Desc_Window_Height = 100;
        setUpHoverWindow();
    }
}
