package de.morrisbr.notinfected.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class NotInfectedCOPY extends ApplicationAdapter {

	private PerspectiveCamera camera;
	private Model model;
	private ModelInstance modelInstance;
	private Environment environment;
	private FPSControll camera_controller;
	public ModelBatch model_batch;
	private Model box;
	private ModelInstance boxInstance;

	public final float field_of_view = 67;
	public final float camera_near = 1;
	public final float camera_far = 300;
	public final float camera_velocity = 15;
	public final float camera_degrees_per_pixel = 0.08f;
	public final float crosshair_size = 25;

	@Override
	public void create() {

		model_batch = new ModelBatch();

		// A ModelBuilder can be used to build meshes by hand
		ModelBuilder modelBuilder = new ModelBuilder();
		box = modelBuilder.createBox(2f, 2f, 2f,
				new Material(ColorAttribute.createDiffuse(Color.BLUE)),
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal
		);
		boxInstance = new ModelInstance(box,0,0,0);

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.5f, 0.5f, 0.5f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.5f));
		environment.add(new DirectionalLight().set(0.2f, 0.2f, 0.2f, 1f, 0.8f, 0.5f));

		camera = new PerspectiveCamera(75,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		camera.position.set(10f,10f,10f);
		camera.lookAt(0f,0f,0f);

		camera.near = 0.1f;
		camera.far = 300.0f;
		camera.update();


		camera_controller = new FPSControll(camera) {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				if (button == 0) {

				} else if (button == 1) {

				}
				return super.touchDown(screenX, screenY, pointer, button);
			}
		};
		camera_controller.setDegreesPerPixel(camera_degrees_per_pixel);
		camera_controller.setVelocity(camera_velocity);
		Gdx.input.setInputProcessor(camera_controller);
		Gdx.input.setCursorCatched(true);

	}

	@Override
	public void dispose() {
		model_batch.dispose();
		box.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		camera_controller.update();
		Gdx.gl.glClearColor(0.5f, 0.8f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		model_batch.begin(camera);
		model_batch.render(boxInstance, environment);
		model_batch.end();

		Gdx.graphics.setTitle("FPS: " + Gdx.graphics.getFramesPerSecond());
	}
}