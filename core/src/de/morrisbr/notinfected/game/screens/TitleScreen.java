package de.morrisbr.notinfected.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.morrisbr.notinfected.game.NotInfected;
import de.morrisbr.notinfected.game.entity.entitys.Player;
import de.morrisbr.notinfected.game.gameobjects.Location;
import de.morrisbr.notinfected.game.world.World;
import de.morrisbr.notinfected.game.world.worlds.Level1World;

public class TitleScreen extends ScreenAdapter {

    private NotInfected notInfected;
    private Skin skin;
    private TextureAtlas atlas;
    private Stage stage;

    public TitleScreen(NotInfected notInfected) {
        this.notInfected = notInfected;
    }


    @Override
    public void show() {
        skin = new Skin(Gdx.files.internal("metalui/metal-ui.json"));

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        TextButton play2DButton = new TextButton("Spiele 2D Spiel", skin);
        root.add(play2DButton).expand();

        TextButton play3DButton = new TextButton("Spiele 3D Spiel", skin);
        root.add(play3DButton).expand();


        play2DButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(notInfected));
            }
        });

        play3DButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreenThreeDScreen(notInfected));
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }


    @Override
    public void dispose() {
        skin.dispose();
        stage.dispose();
        this.dispose();
    }



}
