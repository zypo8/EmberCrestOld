package com.zypo8.games.actors;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class InteractButtons extends Group {
    private TextButton inventory, talents, vendor, quest, equipment, options, talk, goUp, goDown, gather;
    private final Skin skin;

    public InteractButtons(Skin skin){
        this.skin = skin;
    }


    public TextButton addInventoryButton(final Interactable interactable){
        inventory = new TextButton("inventory", skin);
        inventory.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("inventory " + interactable.getName());
                interactable.showInventory();
            }
        });
        return inventory;
    }

    public TextButton addTalentsButton(final Interactable interactable){
        talents = new TextButton("talents", skin);
        talents.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("talents " + interactable.getName());
                interactable.showTalents();
            }
        });
        return talents;
    }

    public TextButton addVendorButton(final Interactable interactable){
        vendor = new TextButton("vendor", skin);
        vendor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("vendor " + interactable.getName());
                interactable.showVendor();
            }
        });
        return vendor;
    }

    public TextButton addQuestButton(final Interactable interactable){
        quest = new TextButton("quest", skin);
        quest.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("quest " + interactable.getName());
                interactable.showQuest();
            }
        });
        return quest;
    }

    public TextButton addEquipmentButton(final Interactable interactable){
        equipment = new TextButton("equipment", skin);
        equipment.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("equipment " + interactable.getName());
                interactable.showEquipment();
            }
        });
        return equipment;
    }

    public TextButton addOptionsButton(final Interactable interactable){
        options = new TextButton("options", skin);
        options.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("options " + interactable.getName());
            }
        });
        return options;
    }

    public TextButton addGatherButton(final Interactable interactable){
        gather = new TextButton("gather", skin);
        gather.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("gathered " + interactable.getName());
                interactable.showGather();
            }
        });
        return gather;
    }

    public TextButton goDown(final Interactable interactable){
        goDown = new TextButton("down", skin);
        goDown.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("down " + interactable.getName());
                interactable.goDown();
            }
        });
        return goDown;
    }

    public TextButton goUp(final Interactable interactable){
        goUp = new TextButton("up", skin);
        goUp.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("up " + interactable.getName());
                interactable.goUp();
            }
        });
        return goUp;
    }

    public TextButton addTalkButton(final Interactable interactable){
        talk = new TextButton("Talk", skin);
        talk.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Talked with " + interactable.getName());
                interactable.talk();
            }
        });
        return talk;
    }

}
