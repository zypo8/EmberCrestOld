package com.zypo8.games.ui.hud;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.zypo8.games.ui.Tools;

public class CastBar extends ProgressBar{
    public CastBar() {
        super(0, 100, 0.1f, false, Tools.getSkin());
        setTouchable(Touchable.disabled);
        setBounds(getX(), getY(), getWidth(), getHeight());

        setValue(0);
        setVisible(false);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //setValue(getValue()+1);
        if(isVisible())
            if(getValue() == getMaxValue()){
                setVisible(false);
            }
    }

    @Override
    protected void positionChanged() {
        setPosition(getX(), getY());
    }

    public void reset(){
        setVisible(false);
    }

    @Override
    public boolean setValue(float value) {
        setVisible(true);
        return super.setValue(value);
    }
}
