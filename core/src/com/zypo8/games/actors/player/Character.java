package com.zypo8.games.actors.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.zypo8.games.actors.Interactable;
import com.zypo8.games.ui.HUDStage;

public class Character extends Interactable {
    public boolean moving;

    //Walking animation
    protected float elapsedTime;
    protected Animation<TextureRegion> walkDown;
    protected Animation<TextureRegion> walkLeft;
    protected Animation<TextureRegion> walkRight;
    protected Animation<TextureRegion> walkUp;
    protected Animation<TextureRegion> characterAnimatoin;

    public Character(String spriteFIle, int posX, int posY, String actorName) {
        super(spriteFIle, posX, posY, actorName);
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth()/4, sprite.getHeight()/4);
        setUpAnimation();
    }

    public Character(String spriteFIle, int posX, int posY, HUDStage hudStage, String actorName) {
        super(spriteFIle, posX, posY, hudStage, actorName);
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth()/4, sprite.getHeight()/4);
        setUpAnimation();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        elapsedTime+= Gdx.graphics.getDeltaTime();
        //System.out.println(elapsedTime);
        if(moving)
            batch.draw(characterAnimatoin.getKeyFrame(elapsedTime, true), getX(), getY());
        else
            batch.draw(characterAnimatoin.getKeyFrame(0), getX(), getY());
    }


    private void setUpAnimation() {
        TextureRegion[][] tmp = TextureRegion.split(sprite.getTexture(), 32, 48);
        TextureRegion[] walkDownFrames = new TextureRegion[4];
        TextureRegion[] walkLeftFrames = new TextureRegion[4];
        TextureRegion[] walkRightFrames = new TextureRegion[4];
        TextureRegion[] walkUpFrames = new TextureRegion[4];

        for (int i = 0; i < 4; i++) {
            walkDownFrames[i] = tmp[0][i];
            walkLeftFrames[i] = tmp[1][i];
            walkRightFrames[i] = tmp[2][i];
            walkUpFrames[i] = tmp[3][i];
        }
        walkDown = new Animation<>(0.125f, walkDownFrames);
        walkLeft = new Animation<>(0.125f, walkLeftFrames);
        walkRight = new Animation<>(0.125f, walkRightFrames);
        walkUp = new Animation<>(0.125f, walkUpFrames);
        characterAnimatoin = walkDown;
    }

    public void firstOptionPositionRequirement() {
    }

    @Override
    public void firstOption() {
        if(Player.destX > getX()-33 && Player.destX < getX()+33) {
            if(Player.destY > getY()-33 && Player.destY < getY()+33) {
                firstOptionPositionRequirement();
            }
        }
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}