package com.zypo8.games.actors.player;

public class PlayerStats {
    public static int HEALTH = 77, maxHEALTH = 150, MANA = 43, maxMANA = 120, EXP = 11, LEVEL, EXP_TO_NEXT_LEVEL;
    public static float DMGTakenMod = 1, DMGDoneMod = 1, HEALTakenMod = 1, HEALDoneMod = 1;

    //professions
    public static int GatheringLevel = 1, CraftingLevel = 1, ArmorCraftingLevel = 1;
    public static int GatheringEXP, CraftingEXP, ArmorCraftingEXP;

    //base stats
    public static int Dexterity, Intellect, Strenght, Vitality;
    public static int armor, armorPiercing, crit, attackPower, focus;

    //armor stats
    public static int Dexteritypercentage, Intellectpercentage, Strenghtpercentage, Vitalitypercentage;
    public static int armorpercentage, armorPiercingpercentage, critpercentage, attackPowerpercentage, focuspercentage;
    public static int GatheringLevelpercentage, CraftingLevelpercentage, ArmorCraftingLevelpercentage;


    public static int getExpToNextLevel(){
        switch (LEVEL){
            case 1:
                return 100;
            case 2:
                return 100;
            case 3:
                return 100;
            case 4:
                return 100;
            case 5:
                return 100;
            case 6:
                return 100;
            case 7:
                return 100;
            case 8:
                return 100;
            case 9:
                return 100;
            case 10:
                return 100;
            case 11:
                return 100;
            case 12:
                return 100;
            case 13:
                return 100;
            case 14:
                return 100;
            case 15:
                return 100;
            case 16:
                return 100;
            case 17:
                return 100;
            case 18:
                return 100;
            case 19:
                return 100;
            case 20:
                return 100;
            case 21:
                return 100;
            case 22:
                return 100;
            case 23:
                return 100;
            case 24:
                return 100;
            case 25:
                return 100;
            case 26:
                return 100;
            case 27:
                return 100;
            case 28:
                return 100;
            case 29:
                return 100;
            case 30:
                return 100;
            default:
                return 100;

        }
    }
    ///////////Getters and Setters//////////////////////////////

    public static float getDMGTakenMod() {
        return DMGTakenMod;
    }

    public static void setDMGTakenMod(float DMGTakenMod) {
        PlayerStats.DMGTakenMod = DMGTakenMod;
    }

    public static float getDMGDoneMod() {
        return DMGDoneMod;
    }

    public static void setDMGDoneMod(float DMGDoneMod) {
        PlayerStats.DMGDoneMod = DMGDoneMod;
    }

    public static float getHEALTakenMod() {
        return HEALTakenMod;
    }

    public static void setHEALTakenMod(float HEALTakenMod) {
        PlayerStats.HEALTakenMod = HEALTakenMod;
    }

    public static float getHEALDoneMod() {
        return HEALDoneMod;
    }

    public static void setHEALDoneMod(float HEALDoneMod) {
        PlayerStats.HEALDoneMod = HEALDoneMod;
    }

    public static int getDexteritypercentage() {
        return Dexteritypercentage;
    }

    public static void setDexteritypercentage(int dexteritypercentage) {
        Dexteritypercentage = dexteritypercentage;
    }

    public static int getIntellectpercentage() {
        return Intellectpercentage;
    }

    public static void setIntellectpercentage(int intellectpercentage) {
        Intellectpercentage = intellectpercentage;
    }

    public static int getStrenghtpercentage() {
        return Strenghtpercentage;
    }

    public static void setStrenghtpercentage(int strenghtpercentage) {
        Strenghtpercentage = strenghtpercentage;
    }

    public static int getVitalitypercentage() {
        return Vitalitypercentage;
    }

    public static void setVitalitypercentage(int vitalitypercentage) {
        Vitalitypercentage = vitalitypercentage;
    }

    public static int getArmorpercentage() {
        return armorpercentage;
    }

    public static void setArmorpercentage(int armorpercentage) {
        PlayerStats.armorpercentage = armorpercentage;
    }

    public static int getArmorPiercingpercentage() {
        return armorPiercingpercentage;
    }

    public static void setArmorPiercingpercentage(int armorPiercingpercentage) {
        PlayerStats.armorPiercingpercentage = armorPiercingpercentage;
    }

    public static int getCritpercentage() {
        return critpercentage;
    }

    public static void setCritpercentage(int critpercentage) {
        PlayerStats.critpercentage = critpercentage;
    }

    public static int getAttackPowerpercentage() {
        return attackPowerpercentage;
    }

    public static void setAttackPowerpercentage(int attackPowerpercentage) {
        PlayerStats.attackPowerpercentage = attackPowerpercentage;
    }

    public static int getFocuspercentage() {
        return focuspercentage;
    }

    public static void setFocuspercentage(int focuspercentage) {
        PlayerStats.focuspercentage = focuspercentage;
    }

    public static int getGatheringLevelpercentage() {
        return GatheringLevelpercentage;
    }

    public static void setGatheringLevelpercentage(int gatheringLevelpercentage) {
        GatheringLevelpercentage = gatheringLevelpercentage;
    }

    public static int getCraftingLevelpercentage() {
        return CraftingLevelpercentage;
    }

    public static void setCraftingLevelpercentage(int craftingLevelpercentage) {
        CraftingLevelpercentage = craftingLevelpercentage;
    }

    public static int getArmorCraftingLevelpercentage() {
        return ArmorCraftingLevelpercentage;
    }

    public static void setArmorCraftingLevelpercentage(int armorCraftingLevelpercentage) {
        ArmorCraftingLevelpercentage = armorCraftingLevelpercentage;
    }
        public static int getHEALTH() {
        return HEALTH;
    }

    public static void setHEALTH(int HEALTH) {
        PlayerStats.HEALTH = HEALTH;
    }

    public static int getMaxHEALTH() {
        return maxHEALTH;
    }

    public static void setMaxHEALTH(int maxHEALTH) {
        PlayerStats.maxHEALTH = maxHEALTH;
    }

    public static int getEXP() {
        return EXP;
    }

    public static void setEXP(int EXP) {
        PlayerStats.EXP = EXP;
    }

    public static int getLEVEL() {
        return LEVEL;
    }

    public static void setLEVEL(int LEVEL) {
        PlayerStats.LEVEL = LEVEL;
    }

    public static int getDexterity() {
        return Dexterity;
    }

    public static void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public static int getIntellect() {
        return Intellect;
    }

    public static void setIntellect(int intellect) {
        Intellect = intellect;
    }

    public static int getStrenght() {
        return Strenght;
    }

    public static void setStrenght(int strenght) {
        Strenght = strenght;
    }

    public static int getVitality() {
        return Vitality;
    }

    public static void setVitality(int vitality) {
        Vitality = vitality;
    }

    public static int getArmor() {
        return armor;
    }

    public static void setArmor(int armor) {
        PlayerStats.armor = armor;
    }

    public static int getArmorPiercing() {
        return armorPiercing;
    }

    public static void setArmorPiercing(int armorPiercing) {
        PlayerStats.armorPiercing = armorPiercing;
    }

    public static int getCrit() {
        return crit;
    }

    public static void setCrit(int crit) {
        PlayerStats.crit = crit;
    }

    public static int getAttackPower() {
        return attackPower;
    }

    public static void setAttackPower(int attackPower) {
        PlayerStats.attackPower = attackPower;
    }

    public static int getFocus() {
        return focus;
    }

    public static void setFocus(int focus) {
        PlayerStats.focus = focus;
    }

    public static int getGatheringLevel() {
        return GatheringLevel;
    }

    public static void setGatheringLevel(int gatheringLevel) {
        GatheringLevel = gatheringLevel;
    }

    public static int getCraftingLevel() {
        return CraftingLevel;
    }

    public static void setCraftingLevel(int craftingLevel) {
        CraftingLevel = craftingLevel;
    }

    public static int getArmorCraftingLevel() {
        return ArmorCraftingLevel;
    }

    public static void setArmorCraftingLevel(int armorCraftingLevel) {
        ArmorCraftingLevel = armorCraftingLevel;
    }

    public static int getGatheringEXP() {
        return GatheringEXP;
    }

    public static void setGatheringEXP(int gatheringEXP) {
        GatheringEXP = gatheringEXP;
    }

    public static int getCraftingEXP() {
        return CraftingEXP;
    }

    public static void setCraftingEXP(int craftingEXP) {
        CraftingEXP = craftingEXP;
    }

    public static int getArmorCraftingEXP() {
        return ArmorCraftingEXP;
    }

    public static void setArmorCraftingEXP(int armorCraftingEXP) {
        ArmorCraftingEXP = armorCraftingEXP;
    }
    public static int getMANA() {
        return MANA;
    }

    public static void setMANA(int MANA) {
        PlayerStats.MANA = MANA;
    }

    public static int getMaxMANA() {
        return maxMANA;
    }

    public static void setMaxMANA(int maxMANA) {
        PlayerStats.maxMANA = maxMANA;
    }

}
