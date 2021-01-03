package com.zypo8.games.items.armor;

public enum SetsBonusses {
    MithrilSet(3, -1, -1, -1, -1, 9, 11, -1, 10, -1);



    SetsBonusses(int helmId, int neckId, int shouldersId, int mainHandId, int offHandId, int chestId,int leggsId, int ringId, int bootsId, int glovesId){
        this.helmId = helmId;
        this.neckId = neckId;
        this.shouldersId = shouldersId;
        this.mainHandId = mainHandId;
        this.offHandId = offHandId;
        this.chestId = chestId;
        this.leggsId = leggsId;
        this.ringId = ringId;
        this.bootsId = bootsId;
        this.glovesId = glovesId;
        setItemsRequired[0] = helmId;
        setItemsRequired[1] = (neckId);
        setItemsRequired[2] = (shouldersId);
        setItemsRequired[3] = (mainHandId);
        setItemsRequired[4] = (offHandId);
        setItemsRequired[5] = (chestId);
        setItemsRequired[6] = (leggsId);
        setItemsRequired[7] = (ringId);
        setItemsRequired[8] = (bootsId);
        setItemsRequired[9] = (glovesId);
    }

    public Integer[] getSetItemsRequired(){
        return setItemsRequired;
    }

    int helmId, neckId, shouldersId, mainHandId, offHandId, chestId, leggsId, ringId, bootsId, glovesId;
    Integer[] setItemsRequired = new Integer[10];
}
