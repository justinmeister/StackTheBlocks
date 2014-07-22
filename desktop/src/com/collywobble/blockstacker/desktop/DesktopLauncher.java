package com.collywobble.blockstacker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.collywobble.blockstacker.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Stack the Blocks!";
        config.width = 480;
        config.height = 800;
		new LwjglApplication(new MainGame(), config);
	}
}
