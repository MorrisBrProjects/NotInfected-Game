package de.morrisbr.notinfected.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.utils.Array;
import de.morrisbr.notinfected.game.entity.entitys.Player;
import de.morrisbr.notinfected.game.gameobjects.Location;
import de.morrisbr.notinfected.game.input.InputService;
import de.morrisbr.notinfected.game.screens.GameScreen;
import de.morrisbr.notinfected.game.screens.GameScreenThreeDScreen;
import de.morrisbr.notinfected.game.screens.TitleScreen;
import de.morrisbr.notinfected.game.world.WorldService;
import de.morrisbr.notinfected.game.world.worlds.Level1World;

import java.util.UUID;

public class NotInfected extends Game {

	private static NotInfected instance;
	public Player player;
	public NotInfected game;

	public NotInfected() {
		instance = this;
	}

	@Override
	public void create() {
		setScreen(new TitleScreen(instance));
	}

	public static NotInfected getInstance() {
		return instance;
	}
}