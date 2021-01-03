package com.zypo8.games.abilities.classSpellBoocks;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.zypo8.games.items.InventorySlot;

import java.util.ArrayList;

public class ClassSpellBook {
    public static Array<InventorySlot> spellBookPage1, spellBookPage2, spellBookPage3, spellBookPage4, spellBookPage5, spellBookPage6;
    public ArrayList<Table> tables;


    public ClassSpellBook(){
        spellBookPage1 = new Array<>(24);
        spellBookPage2 = new Array<>(24);
        spellBookPage3 = new Array<>(24);
        spellBookPage4 = new Array<>(24);
        spellBookPage5 = new Array<>(24);
        spellBookPage6 = new Array<>(24);
        tables = new ArrayList<>(6);
    }

    public Table setUpTable(Array<InventorySlot> inventorySlots){
        Table table = new Table();
        table.setFillParent(true);
        table.row();
        table.add(inventorySlots.get(0)).expand().padTop(20);
        table.add(inventorySlots.get(1)).expand().padTop(20);
        table.add(inventorySlots.get(2)).expand().padTop(20);
        table.add(inventorySlots.get(3)).expand().padTop(20);
        table.row();
        table.add(inventorySlots.get(4)).expand();
        table.add(inventorySlots.get(5)).expand();
        table.add(inventorySlots.get(6)).expand();
        table.add(inventorySlots.get(7)).expand();
        table.row();
        table.add(inventorySlots.get(8)).expand();
        table.add(inventorySlots.get(9)).expand();
        table.add(inventorySlots.get(10)).expand();
        table.add(inventorySlots.get(11)).expand();
        table.row();
        table.add(inventorySlots.get(12)).expand();
        table.add(inventorySlots.get(13)).expand();
        table.add(inventorySlots.get(14)).expand();
        table.add(inventorySlots.get(15)).expand();
        table.row();
        table.add(inventorySlots.get(16)).expand();
        table.add(inventorySlots.get(17)).expand();
        table.add(inventorySlots.get(18)).expand();
        table.add(inventorySlots.get(19)).expand();
        table.row();
        table.add(inventorySlots.get(20)).expand();
        table.add(inventorySlots.get(21)).expand();
        table.add(inventorySlots.get(22)).expand();
        table.add(inventorySlots.get(23)).expand();
        return table;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }
}
