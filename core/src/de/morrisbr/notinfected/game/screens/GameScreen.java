package de.morrisbr.notinfected.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.ControllerMapping;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.morrisbr.notinfected.game.NotInfected;
import de.morrisbr.notinfected.game.entity.entitys.Player;
import de.morrisbr.notinfected.game.gameobjects.GameObject;
import de.morrisbr.notinfected.game.gameobjects.Location;
import de.morrisbr.notinfected.game.input.InputService;
import de.morrisbr.notinfected.game.world.World;
import de.morrisbr.notinfected.game.world.WorldService;
import de.morrisbr.notinfected.game.world.worlds.Level1World;

public class GameScreen extends ScreenAdapter {

    private final NotInfected notInfected;
    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private final Viewport viewport;
    private final World world;

    private WorldService worldService;
    private InputService inputService;


    public GameScreen(NotInfected notInfected) {
        this.notInfected = notInfected;
        this.batch = new SpriteBatch();
        this.notInfected.player = new Player(new Location(0f, 0f), 20f, "player.png");
        this.notInfected.player.getLocation().setWorld(new Level1World(batch));
        this.world = NotInfected.getInstance().player.getLocation().getWorld();

        this.worldService = new WorldService();
        this.inputService = new InputService(notInfected);

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        camera.update();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


    }


    @Override
    public void show() {
        //viewport.setUnitsPerPixel(1f / Gdx.graphics.getDensity());

        worldService.load(new Level1World(batch));

        Gdx.graphics.setTitle("NotInfected2D - Version v1.0");
        Gdx.input.setCursorCatched(false);
        Gdx.input.setInputProcessor(inputService);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0.5f, 0.8f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        world.draw(delta);
        batch.end();

    }


    @Override
    public void dispose() {
        world.dispose();
        batch.dispose();
    }


    public void update(float delta) {
        world.update(delta);
        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
