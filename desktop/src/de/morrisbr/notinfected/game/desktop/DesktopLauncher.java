package de.morrisbr.notinfected.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.morrisbr.notinfected.game.NotInfected;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("badlogic.jpg", Files.FileType.Internal);
		new LwjglApplication(new NotInfected(), config);
	}
}
