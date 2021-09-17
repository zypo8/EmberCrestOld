package com.zypo8.games.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.zypo8.games.MyRPGGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.backgroundFPS = 60;
		config.title = "RPG";
		config.width = 1280;
		config.height = 720;
//		config.width = 1920;DependencyBank
//		config.height = 1080;
		new LwjglApplication(new MyRPGGame(), config);
	}
}
