package com.zypo8.games.actors.player;


import static com.zypo8.games.ui.HUD.setCombatText;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.StageGameScreen;
import com.zypo8.games.Screens.load_game_system.LoadGame;
import com.zypo8.games.actors.Interactable;
import com.zypo8.games.ui.HUDStage;
import com.zypo8.games.ui.hud.playerFrame.PlayerFrame;
import com.zypo8.games.ui.windows.EquipmentWindow;
import com.zypo8.games.ui.windows.InventoryWindow;
import com.zypo8.games.ui.windows.SpellBoockWindow;
import com.zypo8.games.ui.windows.TalentsWindow;

public class Player extends Character{


    private StageGameScreen gameScreenStage;
    public PlayerStats playerStats;
    public static Interactable playerInteractNPC;

    //move
    private final float speed = 256f;
    private String move;
    public static int destX, destY;
    public static boolean Player_moving;
    public static int steps;
    //collision
    private TiledMapTileLayer collisionLayer;
    private TiledMapTileLayer collisionLayer1;
    private boolean colision;
    private float tileWidth, tileHeight;

    //battle system
    public boolean playerBattle, playerBattleStart;



    //player UI
    public static InventoryWindow inventoryWindow;
    public static TalentsWindow talentsWindow;
    public static EquipmentWindow equipmentWindow;
    public static SpellBoockWindow spellBoockWindow;
    public int PlayerClassId;


    public Player(AssetDescriptor activeSprite, int posX, int posY, int PlayerClassId) {
        super(activeSprite, posX, posY, "Player");
        playerStats = new PlayerStats();
        this.PlayerClassId = PlayerClassId;

        destY = posY;
        destX = posX;

        destX = (int) LoadGame.PlayerX;
        destY = (int) LoadGame.PlayerY;
        setY(LoadGame.PlayerY);
        setX(LoadGame.PlayerX);

        inventoryWindow = new InventoryWindow();
        talentsWindow = new TalentsWindow(PlayerClassId);
        equipmentWindow = new EquipmentWindow();
        spellBoockWindow = new SpellBoockWindow(PlayerClassId);

        inventoryWindow.setVisible(false);
        talentsWindow.setVisible(false);
        equipmentWindow.setVisible(false);
        spellBoockWindow.setVisible(false);
        
    }

    public static void addExp(int exp) {
        if(PlayerStats.getEXP()+exp >= PlayerStats.getExpToNextLevel()){
            levelUP();
            int leftExp = PlayerStats.getEXP()+exp - PlayerStats.getExpToNextLevel();
            PlayerStats.setEXP(leftExp);
        }else {
            PlayerStats.setEXP(PlayerStats.getEXP()+exp);
            PlayerFrame.refreshPlayerFrame();
        }
        setCombatText("+ "+exp+" XP", new Color(0x0ee9e9ff));

    }

    public static void DamagePlayer(int amount){
        setCombatText("- "+amount, Color.RED);
        if(amount*PlayerStats.getDMGTakenMod() >= PlayerStats.getHEALTH()){
            //setScreen(new GameOverScreen);
        }
        PlayerStats.setHEALTH(PlayerStats.getHEALTH()-(int)(amount*PlayerStats.getDMGTakenMod()));
        PlayerFrame.refreshPlayerFrame();
    }
    public static void HealPlayer(int amount){
        setCombatText("+ "+amount, Color.GREEN);
        PlayerStats.setHEALTH(PlayerStats.getHEALTH()+(int)(amount*PlayerStats.getHEALDoneMod()));
        PlayerFrame.refreshPlayerFrame();
    }

    private static void levelUP() {
        PlayerStats.setLEVEL(PlayerStats.getLEVEL()+1);
    }

    @Override
    public void firstOption() {
        showInventory();
    }

    @Override
    public void act(float delta) {
        Player_moving = moving;
        move(delta);
    }

    private void move(float delta) {
        if(getY() == destY && getX() == destX){
            if(moving) {
                steps++;
                playerInteractNPC = null;
            }
            moving = false;
        }
        if(gameScreenStage.wsad.size-1 >= 0){
            move = gameScreenStage.wsad.get(gameScreenStage.wsad.size-1);
            switch (move) {
                case "W":
                    if (!moving) {
                        characterAnimatoin = walkUp;
                        if (!(collision("collision", 0, +32))) {
                            moving = true;
                            destY += 32;
                            if (collision("grass", 0, +32))
                                playerBattle = true;
                            if (collision("door", 0, -32)) {

                            }
                        }
                    }
                    break;
                case "A":
                    if (!moving) {
                        characterAnimatoin = walkLeft;
                        if (!(collision("collision", -32, 0))) {
                            moving = true;
                            destX -= 32;
                            if (collision("grass", -32, 0))
                                playerBattle = true;
                            if (collision("door", 0, -32)) {

                            }
                        }
                    }
                    break;
                case "S":
                    if (!moving) {
                        characterAnimatoin = walkDown;
                        if (!(collision("collision", 0, -32))) {
                            moving = true;
                            destY -= 32;
                            if (collision("grass", 0, -32))
                                playerBattle = true;
                            if (collision("door", 0, -32)) {

                            }
                        }
                    }
                    break;
                case "D":
                    if (!moving) {
                        characterAnimatoin = walkRight;
                        if (!(collision("collision", 32, 0))) {
                            moving = true;
                            destX += 32;
                            if (collision("grass", 32, 0))
                                playerBattle = true;
                            if (collision("door", 0, -32)) {

                            }
                        }
                    }
                    break;
            }
        }
        if(moving){
            if(destY > getY())
                setY(getY()+speed/64);
            if(destY < getY())
                setY(getY()-speed/64);
            if(destX > getX())
                setX(getX()+speed/64);
            if(destX < getX())
                setX(getX()-speed/64);
        }
    }

    protected boolean collision(String KeyWord, int x, int y) {
        colision = collisionLayer.getCell((int) ((getX()+x)/ tileWidth), (int) ((getY()+y)/tileHeight)).getTile().getProperties().containsKey(KeyWord);
        if(!colision) {
            if(collisionLayer1 != null && collisionLayer1.getCell((int) ((getX() + x) / tileWidth), (int) ((getY() + y) / tileHeight)) != null)
                colision = collisionLayer1.getCell((int) ((getX() + x) / tileWidth), (int) ((getY() + y) / tileHeight)).getTile().getProperties().containsKey(KeyWord);
        }
        System.out.println((int)((getX())/ tileWidth) + ":"+(int)((getY())/tileHeight)+ colision+ "|"+ (int) ((getX()+x)/ tileWidth)+ ":"+ (int) ((getY()+y)/tileHeight));
        return colision;
    }

    @Override
    public void interactWindow(Window window, Skin skin) {
        window.setHeight(120);
        window.add(interactButtons.addInventoryButton(this));
        window.row();
        window.add(interactButtons.addTalentsButton(this));
        window.row();
        window.add(interactButtons.addEquipmentButton(this));
    }

    @Override
    public void showInventory() {
        System.out.println("player inventory");
        inventoryWindow.setVisible(true);
    }

    @Override
    public void showTalents() {
        System.out.println("player talents");
        talentsWindow.setVisible(true);
    }

    @Override
    public void showEquipment() {
        System.out.println("player eq");
        equipmentWindow.setVisible(true);
    }


    public void setGameScreenStage(StageGameScreen gameScreenStage) {
        this.gameScreenStage = gameScreenStage;
    }

    public void setCollisionLayer(MapLayers collisionLayer) {
        this.collisionLayer = (TiledMapTileLayer)collisionLayer.get(0);
        //System.out.println(collisionLayer.size());
        this.collisionLayer1 = (TiledMapTileLayer)collisionLayer.get(1);
        tileWidth = this.collisionLayer.getTileWidth();
        tileHeight = this.collisionLayer.getTileHeight();
    }

    @Override
    public void setHudStage(HUDStage hudStage) {
        super.setHudStage(hudStage);
        hudStage.addActor(inventoryWindow);
        hudStage.addActor(talentsWindow);
        hudStage.addActor(equipmentWindow);
        hudStage.addActor(MyRPGGame.menuWIndow);
        hudStage.addActor(spellBoockWindow);
    }

    public static EquipmentWindow getEquipmentWindow() {
        return equipmentWindow;
    }

    public static void setEquipmentWindow(EquipmentWindow equipmentWindow) {
        Player.equipmentWindow = equipmentWindow;
    }
}