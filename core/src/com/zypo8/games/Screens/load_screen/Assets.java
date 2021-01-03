package com.zypo8.games.Screens.load_screen;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Assets {
    public static ArrayList<AssetDescriptor> allAssets= new ArrayList<>();

    public static void addAssetsToArray(){
        allAssets.add(debuf_bg);
        allAssets.add(hardeness);
        allAssets.add(hardeness_inactive);
        allAssets.add(mana_cost_texture);
        allAssets.add(slash);
        allAssets.add(slash_inactive);
        allAssets.add(thunder);
        allAssets.add(player);
        allAssets.add(stairs);
        allAssets.add(mithril_ore);
        allAssets.add(mithril_ore_inactive);
        allAssets.add(coin);
        allAssets.add(broken_helmet);
        allAssets.add(emerald_neck);
        allAssets.add(helmet);
        allAssets.add(hp_pot);
        allAssets.add(mana_pot);
        allAssets.add(apple);
        allAssets.add(bad_apple);
        allAssets.add(asdad);
        allAssets.add(loot);
        allAssets.add(minimap);
        allAssets.add(mithril_legs);
        allAssets.add(mithril_helm);
        allAssets.add(mithril_set_bonus);
        allAssets.add(mithril_neck);
        allAssets.add(mithril_chest);
        allAssets.add(mithril_boots);
        allAssets.add(palladin);
    }

    /// Abilities && Buffs
    public static final String DEBUF_BG = "img/ability/debuffBackground.png";
    public static final String HARDENESS = "img/ability/hardeness.png";
    public static final String HARDENESS_INACTIVE = "img/ability/hardenessInactive.png";
    public static final String MANA_COST_TEXTURE = "img/ability/manaCostTexture.png";
    public static final String SLASH = "img/ability/Slash.png";
    public static final String SLASH_INACTIVE = "img/ability/Slash_inactive.png";
    public static final String THUNDER = "img/ability/thunder.png";
    public static final AssetDescriptor debuf_bg = new AssetDescriptor(DEBUF_BG, Texture.class);
    public static final AssetDescriptor hardeness = new AssetDescriptor(HARDENESS, Texture.class);
    public static final AssetDescriptor hardeness_inactive = new AssetDescriptor(HARDENESS_INACTIVE, Texture.class);
    public static final AssetDescriptor mana_cost_texture = new AssetDescriptor(MANA_COST_TEXTURE, Texture.class);
    public static final AssetDescriptor slash = new AssetDescriptor(SLASH, Texture.class);
    public static final AssetDescriptor slash_inactive = new AssetDescriptor(SLASH_INACTIVE, Texture.class);
    public static final AssetDescriptor thunder = new AssetDescriptor(THUNDER, Texture.class);

    /// Interactables
    public static final String PLAYER = "img/characters/player.gif";
    public static final String STAIRS = "img/characters/stairs.png";
    public static final String MITHRIL_ORE = "img/gatherable/mithrilOre/mithril_active.png";
    public static final String MITHRIL_ORE_INACTIVE = "img/gatherable/mithrilOre/mithril_inactive.png";
    public static final AssetDescriptor player = new AssetDescriptor(PLAYER, Texture.class);
    public static final AssetDescriptor stairs = new AssetDescriptor(STAIRS, Texture.class);
    public static final AssetDescriptor mithril_ore = new AssetDescriptor(MITHRIL_ORE, Texture.class);
    public static final AssetDescriptor mithril_ore_inactive = new AssetDescriptor(MITHRIL_ORE_INACTIVE, Texture.class);


    //items
    public static final String COIN = "img/items/materials/Coin.png";
    public static final AssetDescriptor coin = new AssetDescriptor(COIN, Texture.class);
    //armour
    public static final String BROKEN_HEMLET = "img/items/armor/broken_helmet.png";
    public static final String EMERALD_NECK = "img/items/armor/EmeraldNeck.png";
    public static final String HELMET = "img/items/armor/helmet.png";
    public static final AssetDescriptor broken_helmet = new AssetDescriptor(BROKEN_HEMLET, Texture.class);
    public static final AssetDescriptor emerald_neck = new AssetDescriptor(EMERALD_NECK, Texture.class);
    public static final AssetDescriptor helmet = new AssetDescriptor(HELMET, Texture.class);
    //consumable
    public static final String HP_POT = "img/items/consumable/hp_potion.png";
    public static final String MANA_POT = "img/items/consumable/mana_potion.png";
    public static final String APPLE = "img/items/consumable/apple.png";
    public static final String BAD_APPLE = "img/items/consumable/bad_apple.png";
    public static final AssetDescriptor hp_pot = new AssetDescriptor(HP_POT, Texture.class);
    public static final AssetDescriptor mana_pot = new AssetDescriptor(MANA_POT, Texture.class);
    public static final AssetDescriptor apple = new AssetDescriptor(APPLE, Texture.class);
    public static final AssetDescriptor bad_apple = new AssetDescriptor(BAD_APPLE, Texture.class);
    //mats




    //placeholders
    public static final String ASDAD = "img/placeHolders/asdad.png";
    public static final String LOOT = "img/placeHolders/loot.png";
    public static final String MINIMAP = "img/placeHolders/minimap.png";
    public static final String MITHRIL_BOOTS = "img/placeHolders/mithril_boots.png";
    public static final String MITHRIL_CHEST = "img/placeHolders/mithril_chest.png";
    public static final String MITHRIL_LEGS = "img/placeHolders/mithril_legs.png";
    public static final String MITHRIL_SET_BONUS = "img/placeHolders/mithril_set_bonus.png";
    public static final String MITHRIL_HELM = "img/placeHolders/mithrilHelm.png";
    public static final String MITHRIL_NECK = "img/placeHolders/mithrilNeck.png";
    public static final String PALLADIN = "img/placeHolders/palladin.png";
    public static final AssetDescriptor asdad = new AssetDescriptor(ASDAD, Texture.class);
    public static final AssetDescriptor loot = new AssetDescriptor(LOOT, Texture.class);
    public static final AssetDescriptor minimap = new AssetDescriptor(MINIMAP, Texture.class);
    public static final AssetDescriptor mithril_boots = new AssetDescriptor(MITHRIL_BOOTS, Texture.class);
    public static final AssetDescriptor mithril_chest = new AssetDescriptor(MITHRIL_CHEST, Texture.class);
    public static final AssetDescriptor mithril_legs = new AssetDescriptor(MITHRIL_LEGS, Texture.class);
    public static final AssetDescriptor mithril_set_bonus = new AssetDescriptor(MITHRIL_SET_BONUS, Texture.class);
    public static final AssetDescriptor mithril_helm = new AssetDescriptor(MITHRIL_HELM, Texture.class);
    public static final AssetDescriptor mithril_neck = new AssetDescriptor(MITHRIL_NECK, Texture.class);
    public static final AssetDescriptor palladin = new AssetDescriptor(PALLADIN, Texture.class);



    // UI && HUD
//    public static final String PLAYER = "img/characters/player.gif";
//    public static final String STAIRS = "img/characters/stairs.png";
//    public static final String MITHRIL_ORE = "img/gatherable/mithril_active.png";
//    public static final String MITHRIL_ORE_INACTIVE = "img/ability/mithril_inactive.png";
//    public static final AssetDescriptor player = new AssetDescriptor(PLAYER, Texture.class);
//    public static final AssetDescriptor stairs = new AssetDescriptor(STAIRS, Texture.class);
//    public static final AssetDescriptor mithril_ore = new AssetDescriptor(MITHRIL_ORE, Texture.class);
//    public static final AssetDescriptor mithril_ore_inactive = new AssetDescriptor(MITHRIL_ORE_INACTIVE, Texture.class);




}
