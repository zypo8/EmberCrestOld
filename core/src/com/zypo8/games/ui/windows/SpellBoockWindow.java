package com.zypo8.games.ui.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.zypo8.games.abilities.classSpellBoocks.ClassSpellBook;
import com.zypo8.games.abilities.classSpellBoocks.WarriorSpellBook;
import com.zypo8.games.ui.Tools;
import com.zypo8.games.ui.hud.tools.WindowWithTopRightCornerCloseButton;

public class SpellBoockWindow extends WindowWithTopRightCornerCloseButton {
    public ImageButton rightBTN, leftBTN;
    public ClassSpellBook classSpellBook;
    private int page = 1;
    private Table table;
    private final Label label = new Label(String.valueOf(page), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));

    public SpellBoockWindow(int id) {
        super("", Tools.getSkin());
        setMovable(true);
        setSize(250, 450);
        setTouchable(Touchable.enabled);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setName("Player SpellBook Window");
        setUpButtons();
        switch (id){
            case 1:
                classSpellBook = new ClassSpellBook();
                break;
            case 2:
                classSpellBook = new ClassSpellBook();
                break;
            case 3:
                classSpellBook = new ClassSpellBook();
                break;
            case 4:
                classSpellBook = new ClassSpellBook();
                break;
            case 5:
                classSpellBook = new WarriorSpellBook();
                break;
            case 6:
                classSpellBook = new ClassSpellBook();
                break;
            case 7:
                classSpellBook = new ClassSpellBook();
                break;
            case 8:
                classSpellBook = new ClassSpellBook();
                break;
            default:
                classSpellBook = new ClassSpellBook();
        }
        goToPage(page);
    }


    public void goToPage(int page){
        removeActor(table);
        label.setText(String.valueOf(page));
        label.setAlignment(1);
        table = null;
        table = classSpellBook.tables.get(page-1);
        table.row();
        if(page > 1)
            table.add(leftBTN);
        else
            table.add((Actor) null);
        table.add(label).colspan(2);
        if(classSpellBook.tables.size() > page)
            table.add(rightBTN);
        else
            table.add((Actor) null);
        addActor(table);
    }

    private void setUpButtons() {
        Drawable RightArrowDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/RightArrow.png"))));
        Drawable LeftArrowDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("img/ui/windows/LeftArrow.png"))));
        rightBTN = new ImageButton(RightArrowDrawable);
        leftBTN = new ImageButton(LeftArrowDrawable);

        rightBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(page < classSpellBook.tables.size()) {
                    page++;
                    goToPage(page);

                }
            }
        });

        leftBTN.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(page > 1) {
                    page--;
                    goToPage(page);

                }
            }
        });
    }
}
