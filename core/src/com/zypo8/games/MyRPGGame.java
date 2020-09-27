package com.zypo8.games;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.zypo8.games.Screens.MenuScreen;
import com.zypo8.games.ui.windows.menu_in_game.MenuWIndow;
import com.zypo8.games.ui.windows.options.LoadOptions;
import com.zypo8.games.ui.windows.options.Options;

public class MyRPGGame extends Game {
	public static Options options;
	public SpriteBatch batch;
	public static BitmapFont font;
	public Skin skin;
	public static MenuWIndow menuWIndow;
	@Override
	public void create () {
		new LoadOptions();
		batch = new SpriteBatch();
		font = new BitmapFont();
		skin = new Skin(Gdx.files.internal("skin/metal-ui.json"));
		menuWIndow = new MenuWIndow();
		options = new Options();
		setScreen(new MenuScreen(this));
	}
}
