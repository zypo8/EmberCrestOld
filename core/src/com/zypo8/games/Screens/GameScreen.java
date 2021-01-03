package com.zypo8.games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.Screens.load_game_system.LoadGame;
import com.zypo8.games.Screens.load_screen.LoadScreen;
import com.zypo8.games.abilities.buffs.Buffs;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.ItemLocation;
import com.zypo8.games.items.Items;
import com.zypo8.games.items.TalentSlot;
import com.zypo8.games.items.armor.Armor;
import com.zypo8.games.levels.GameWorld;
import com.zypo8.games.ui.HUD;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.hud.buff_bar.Buffbar;
import com.zypo8.games.ui.hud.buff_bar.DeBuffbar;
import com.zypo8.games.ui.windows.InventoryWindow;
import com.zypo8.games.ui.windows.TalentsWindow;


public class GameScreen implements Screen {
    private final OrthographicCamera camera;
    public static StageGameScreen stage;
    private final MyRPGGame game;
    public static Player player;
    private final Viewport viewport;
    public static HUD hud;
    private final InputMultiplexer multiplexer = new InputMultiplexer();

    public static GameWorld gameWorld;
    public static int floor;


    public GameScreen(MyRPGGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        stage = new StageGameScreen(viewport, game.batch, game);
        hud = new HUD(game.batch);
        gameWorld = new GameWorld(stage, hud.hudStage);
        gameWorld.update("maps/map");
        camera.setToOrtho(false, 1280, 720);

        player = LoadGame.player;
        player.setHudStage(hud.hudStage);
        player.setGameScreenStage(stage);
        player.setCollisionLayer(gameWorld.map.getLayers());
        hud.hudStage.player = player;
        playerInitInventory();

        stage.addActor(player);
        multiplexer.addProcessor(hud.hudStage);
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);

        hud.hudStage.addActor(MyRPGGame.options);


    }

    private void playerInitInventory() {
        for (InventorySlot inventorySlot:InventoryWindow.inventorySlots) {
            if(LoadGame.inventoryData.get("Slot"+inventorySlot.getSlotID()) != null){
                inventorySlot.setItem(Items.getItemById(LoadGame.toIntExact((Long) LoadGame.inventoryData.get("Slot"+inventorySlot.getSlotID())), ItemLocation.Inventory));
                inventorySlot.setAmount( LoadGame.toIntExact((Long) LoadGame.inventoryData.get("Slot"+inventorySlot.getSlotID()+"A")));
            }
        }
        for(InventorySlot inventorySlot: Actionbar.inventorySlots)
            if(LoadGame.actionBarData.get("Slot"+inventorySlot.getSlotID()) != null){
                System.out.println(LoadGame.actionBarData.get("Slot"+inventorySlot.getSlotID())+"DUPCZIKONGO");
                inventorySlot.setItem(Items.getItemById(LoadGame.toIntExact((Long)LoadGame.actionBarData.get("Slot"+inventorySlot.getSlotID())), ItemLocation.ActionBar));
                inventorySlot.setAmount( LoadGame.toIntExact((Long) LoadGame.actionBarData.get("Slot"+inventorySlot.getSlotID()+"A")));

            }
        for(InventorySlot inventorySlot: Buffbar.inventorySlots)
            if(LoadGame.buffBarData.get("Slot"+inventorySlot.getSlotID()) != null){
                System.out.println(LoadGame.toIntExact(((Long)LoadGame.buffBarData.get("Slot"+inventorySlot.getSlotID()))));
                Buffbar.addItem(new InventorySlot(Buffs.getBuffById(LoadGame.toIntExact(((Long)LoadGame.buffBarData.get("Slot"+inventorySlot.getSlotID())))), LoadGame.toIntExact((Long) LoadGame.buffBarData.get("Slot"+inventorySlot.getSlotID()+"A"))));
//                inventorySlot.setItem(Buffs.getBuffById(LoadGame.toIntExact(((Long)LoadGame.buffBarData.get("Slot"+inventorySlot.getSlotID())))));
//                inventorySlot.setAmount( LoadGame.toIntExact((Long) LoadGame.buffBarData.get("Slot"+inventorySlot.getSlotID()+"A")));
            }
        for(InventorySlot inventorySlot: DeBuffbar.inventorySlots)
            if(LoadGame.deBuffBarData.get("Slot"+inventorySlot.getSlotID()) != null){
                DeBuffbar.addItem(new InventorySlot(Buffs.getBuffById(LoadGame.toIntExact(((Long)LoadGame.deBuffBarData.get("Slot"+inventorySlot.getSlotID())))), LoadGame.toIntExact((Long) LoadGame.deBuffBarData.get("Slot"+inventorySlot.getSlotID()+"A"))));
//                inventorySlot.setItem(Buffs.getBuffById(LoadGame.toIntExact(((Long)LoadGame.deBuffBarData.get("Slot"+inventorySlot.getSlotID())))));
//                inventorySlot.setAmount( LoadGame.toIntExact((Long) LoadGame.deBuffBarData.get("Slot"+inventorySlot.getSlotID()+"A")));

            }
        for(Armor armor:LoadGame.equipment){
            armor.equip();
        }
        InventoryWindow.setCoins(LoadGame.toIntExact((Long) LoadGame.data.get("Coins")));
        for (TalentSlot talentSlot: TalentsWindow.talentSlots){
            hud.hudStage.addActor(talentSlot.getTalent());
        }
        hud.setOnTopHud();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        update(delta);
        cameraUpdate();
        game.batch.setProjectionMatrix(camera.combined);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameWorld.renderer.setView(camera);
        gameWorld.renderer.render();
        stage.draw();

        game.batch.setProjectionMatrix(hud.hudStage.getCamera().combined);
        hud.hudStage.draw();
        //PlayerFrame.refreshHp();
        //PlayerFrame.refreshMana();
    }

    private void update(float delta) {
        stage.act(delta);
        hud.hudStage.act(delta);
    }

    private void cameraUpdate() {
        camera.position.x = camera.position.x + (player.getX() - camera.position.x) * .05f;
        camera.position.y = camera.position.y + (player.getY() - camera.position.y) * .05f;
        camera.update();

    }

    public static void worldUpdate(){
        //world = new World("maps/map", stage, hud.hudStage);
        gameWorld.update("maps/map");
        player.setCollisionLayer(gameWorld.map.getLayers());
    }
    public static GameWorld getGameWorld(){
        return gameWorld;
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        hud.hudStage.getViewport().update(width, height);
        camera.setToOrtho(false, width, height);
        hud.setToOrthooo(width, height);
        camera.position.x = camera.position.x + (player.getX() - camera.position.x);
        camera.position.y = camera.position.y + (player.getY() - camera.position.y);
        camera.update();
        Player.talentsWindow.setY(Gdx.graphics.getHeight()/2-Player.talentsWindow.getHeight()/2);
        Player.talentsWindow.setX(Gdx.graphics.getWidth()/2-Player.talentsWindow.getWidth()/2);
        MyRPGGame.menuWIndow.setY(Gdx.graphics.getHeight()/2-MyRPGGame.menuWIndow.getHeight()/2);
        MyRPGGame.menuWIndow.setX(Gdx.graphics.getWidth()/2-MyRPGGame.menuWIndow.getWidth()/2);
        MyRPGGame.options.refreshOptionsWindpwOnResize();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        gameWorld.map.dispose();
        gameWorld.renderer.dispose();
        stage.dispose();
        LoadScreen.assetManager.dispose();

    }
}