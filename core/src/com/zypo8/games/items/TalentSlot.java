package com.zypo8.games.items;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.zypo8.games.MyRPGGame;
import com.zypo8.games.items.talents.talentSystem.Talent;

public class TalentSlot extends InventorySlot {
    public TalentSlot(Talent talent) {
        this.talent = talent;
        addActor(talent);
    }

    public TalentSlot(boolean drawBackground){
        super(drawBackground);
    }

    public TalentSlot(){
        super();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(drawBackground)
            backgroundImage.draw(batch);
        if(talent != null){
            //item.sprite.draw(batch);
            if(talent.isActive)
                batch.draw(talent.sprite, getX(), getY());
            else
                batch.draw(talent.inActiveSprite, getX(), getY());
            if(talent.amount == 0) {
                MyRPGGame.font.setColor(Color.RED);
                MyRPGGame.font.draw(batch, (talent.amount)+"/"+(talent.talentCount), getX(), getY() + 14);
            }
            else if(talent.amount > 0 && talent.amount < talent.getTalentCount()) {
                MyRPGGame.font.setColor(Color.WHITE);
                MyRPGGame.font.draw(batch, (talent.amount)+"/"+(talent.talentCount), getX(), getY() + 14);
            }
            else if(talent.amount == talent.getTalentCount()) {
                MyRPGGame.font.setColor(Color.YELLOW);
                MyRPGGame.font.draw(batch, (talent.amount)+"/"+(talent.talentCount), getX(), getY() + 14);
            }
        }
    }
}
