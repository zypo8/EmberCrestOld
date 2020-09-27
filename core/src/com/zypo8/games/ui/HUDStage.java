package com.zypo8.games.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.zypo8.games.abilities.buffs.Buff;
import com.zypo8.games.actors.player.Player;
import com.zypo8.games.items.InventorySlot;
import com.zypo8.games.items.Item;
import com.zypo8.games.ui.hud.actionBar.Actionbar;
import com.zypo8.games.ui.windows.InteractWindow;
import com.zypo8.games.ui.windows.ItemDescriptionWIndow;

public class HUDStage extends Stage implements InputProcessor {
    private InteractWindow window;
    private Actor hitActor, lastHitActor;
    private InventorySlot hitInventorySlot;
    private Vector2 coord;

    public Player player;


    public static InventorySlot lastClickedSlot;

    public HUDStage(Viewport viewport, Batch batch) {
        super(viewport, batch);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        coord = screenToStageCoordinates(new Vector2((float)screenX, (float)screenY));
        System.out.println(hit(coord.x, coord.y, true));
        try {
            hitInventorySlot = (InventorySlot) hit(coord.x, coord.y, true);
            System.out.println(hitInventorySlot);
        }
        catch (ClassCastException e){
            hitInventorySlot = null;
            Player.getEquipmentWindow().refreshStats();
            if(window != null)
                window.remove();
            return true;
        }
        System.out.println(hitInventorySlot);
        if(hitInventorySlot != null){
            System.out.println(hitInventorySlot.getClass().getName());
            if (hitInventorySlot.getClass().getName().substring(0, 21).equals("com.zypo8.games.items")) {
                if (window != null) {
                    window.remove();
                }
                if(hitInventorySlot != null && hitInventorySlot.getItem() != null)
                    Gdx.app.log("HIT, HudStage", hitInventorySlot.getItem().getName());
                else
                    Gdx.app.log("HIT, HudStage", "Empty Slot");
                lastClickedSlot = hitInventorySlot;
                if(hitInventorySlot.getItem() != null) {
                    if(button == 0){hitInventorySlot.getItem().firstOption();return true;}
                    else if(button == 1) {
                        if(hitInventorySlot.getItem().getClass().getName().length() == 36 &&
                                hitInventorySlot.getItem().getClass().getName().substring(0, 36).equals("com.zypo8.games.abilities.buffs.Buff")) {
                            Player.getEquipmentWindow().refreshStats();
                            return true;
                        }
                        if(hitInventorySlot.getItem() instanceof Buff){
                            hitInventorySlot.getItem().itemInteractWindow(window, Tools.getSkin());
                            Player.getEquipmentWindow().refreshStats();
                            return true;
                        }
                        else {
                            window = new InteractWindow(hitInventorySlot.getItem().getName() + " " + hitInventorySlot.getAmount(), Tools.getSkin());
                            window.setPosition(coord.x + 32, coord.y);
                            hitInventorySlot.getItem().itemInteractWindow(window, Tools.getSkin());
                            if (hitInventorySlot.getItem() != null)
                                addActor(window);
                            Player.getEquipmentWindow().refreshStats();
                            return true;
                        }
                    }
                    return true;
                }
                if(hitInventorySlot.getTalent() != null) {
                    if(button == 0){hitInventorySlot.getTalent().firstOption();}
                    else if(button == 1) {
                        hitInventorySlot.getTalent().removeTalentPoint();
                        Player.getEquipmentWindow().refreshStats();
                        return true;
                    }
                }
                else {
                    Player.getEquipmentWindow().refreshStats();
                }
            }
        }
        else {
            if (window != null) {
                window.remove();
                //lastClickedSlot.getItem().selected = false;
            }
            Player.getEquipmentWindow().refreshStats();
        }
        Player.getEquipmentWindow().refreshStats();
        return hit(coord.x, coord.y, true) instanceof Actor;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        coord = screenToStageCoordinates(new Vector2((float)screenX, (float)screenY));
        lastHitActor = hitActor;
        hitActor = hit(coord.x, coord.y, true);
        if(hitActor instanceof InventorySlot){
            hitInventorySlot = (InventorySlot) hitActor;
            Item item = hitInventorySlot.getItem();
            if(item != null) {
                if(!item.getItemDescriptionWIndow().isVisible()) {
                    Gdx.app.log("Hover ", hitInventorySlot.getName());
                    Vector2 itemTruePosition = hitActor.localToStageCoordinates(new Vector2(hitActor.getX(), hitActor.getY()));
                    if(item instanceof Buff) {
                        Gdx.app.log("Hover ", hitInventorySlot.getName());
                        ItemDescriptionWIndow itemDescriptionWIndow = item.getItemDescriptionWIndow();
                        addActor(itemDescriptionWIndow);
                        if (!((Buff) item).isDeBuff) {
                            Gdx.app.log("Hover ", hitInventorySlot.getName());
                            item.getItemDescriptionWIndow().setPosition(itemTruePosition.x- itemDescriptionWIndow.getWidth()-hitActor.getX(), itemTruePosition.y-itemDescriptionWIndow.getHeight()-34);
                        }else {
                            item.getItemDescriptionWIndow().setPosition(itemTruePosition.x-hitActor.getX()-itemDescriptionWIndow.getWidth(), itemTruePosition.y-hitActor.getY()-itemDescriptionWIndow.getHeight());
                            System.out.println(item.getItemDescriptionWIndow().getX());
                        }
                    }else
                        item.getItemDescriptionWIndow().setPosition(itemTruePosition.x-hitActor.getX()+34, itemTruePosition.y-hitActor.getY()+34);
                    item.getItemDescriptionWIndow().setVisible(true);
                    System.out.println("YES");
                }
            }
            if(hitInventorySlot.getTalent() != null){
                if(!hitInventorySlot.getTalent().getItemDescriptionWIndow().isVisible()) {
                    Gdx.app.log("Hover ", hitInventorySlot.getName());
                    hitInventorySlot.getTalent().getItemDescriptionWIndow().setPosition(hitInventorySlot.getX()+32+2+hitInventorySlot.getTalent().getTalentTree().getX()+ Gdx.graphics.getWidth()/2-700/2, hitInventorySlot.getY()+32+2+hitInventorySlot.getTalent().getTalentTree().getY()+ Gdx.graphics.getHeight()/2-800/2);
                    hitInventorySlot.getTalent().getItemDescriptionWIndow().setVisible(true);
                    System.out.println("YES");
                }
            }
        }

        if(hitActor != lastHitActor){
            if(lastHitActor instanceof InventorySlot){
                hitInventorySlot = (InventorySlot) lastHitActor;
                if(hitInventorySlot.getItem() != null){
                    hitInventorySlot.getItem().getItemDescriptionWIndow().setVisible(false);
                    System.out.println("NO");
                }
                if(hitInventorySlot.getTalent() != null){
                    hitInventorySlot.getTalent().getItemDescriptionWIndow().setVisible(false);
                    System.out.println("NO");
                }
            }
        }
        return hitActor != null;
    }

    @Override
    public boolean keyTyped(char character) {
        switch (character){
            case '1':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(0);
                if( Actionbar.inventorySlots.get(0).getItem() != null)
                    Actionbar.inventorySlots.get(0).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '2':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(1);
                if( Actionbar.inventorySlots.get(1).getItem() != null)
                    Actionbar.inventorySlots.get(1).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '3':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(2);
                if( Actionbar.inventorySlots.get(2).getItem() != null)
                    Actionbar.inventorySlots.get(2).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '4':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(3);
                if( Actionbar.inventorySlots.get(3).getItem() != null)
                    Actionbar.inventorySlots.get(3).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '5':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(4);
                if( Actionbar.inventorySlots.get(4).getItem() != null)
                    Actionbar.inventorySlots.get(4).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '6':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(5);
                if( Actionbar.inventorySlots.get(5).getItem() != null)
                    Actionbar.inventorySlots.get(5).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '7':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(6);
                if( Actionbar.inventorySlots.get(6).getItem() != null)
                    Actionbar.inventorySlots.get(6).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '8':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(7);
                if( Actionbar.inventorySlots.get(7).getItem() != null)
                    Actionbar.inventorySlots.get(7).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '9':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(8);
                if( Actionbar.inventorySlots.get(8).getItem() != null)
                    Actionbar.inventorySlots.get(8).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '0':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(9);
                if( Actionbar.inventorySlots.get(9).getItem() != null)
                    Actionbar.inventorySlots.get(9).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '-':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(10);
                if( Actionbar.inventorySlots.get(10).getItem() != null)
                    Actionbar.inventorySlots.get(10).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            case '=':
                HUDStage.lastClickedSlot = Actionbar.inventorySlots.get(11);
                if( Actionbar.inventorySlots.get(11).getItem() != null)
                    Actionbar.inventorySlots.get(11).getItem().firstOption();
                Player.getEquipmentWindow().refreshStats();
                return true;
            default:
                return false;
        }
    }

}
