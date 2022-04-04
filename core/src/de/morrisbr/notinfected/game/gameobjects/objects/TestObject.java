package de.morrisbr.notinfected.game.gameobjects.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.morrisbr.notinfected.game.gameobjects.GameObject;
import de.morrisbr.notinfected.game.gameobjects.Location;

import java.util.UUID;

public class TestObject extends GameObject {

    //private SpriteBatch batch = new SpriteBatch();

    public TestObject(int id, int widht, int height, Location location) {
        super("badlogic.jpg", id, UUID.randomUUID(), widht, height, location);
        setGravity(0f);
    }

    @Override
    public void draw(float delta, SpriteBatch batch) {
        //batch.begin();
        getSprite().draw(batch);
        //batch.end();
    }

    @Override
    public void dispose() {
        //batch.dispose();
        getTexture().dispose();
    }
}
