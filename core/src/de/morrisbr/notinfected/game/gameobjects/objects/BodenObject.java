package de.morrisbr.notinfected.game.gameobjects.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.morrisbr.notinfected.game.gameobjects.GameObject;
import de.morrisbr.notinfected.game.gameobjects.Location;

import java.util.UUID;

public class BodenObject extends GameObject {

    public BodenObject(int widht, int height, Location location) {
        setId(2);
        setGravity(0f);
        setCollisionEnabled(true);
        setWidht(widht);
        setHeight(height);
        setLocation(location);
        setTexture("ground.jpg");
    }

    @Override
    public void draw(float delta, SpriteBatch batch) {
        getSprite().draw(batch);
    }

    @Override
    public void dispose() {
        getTexture().dispose();
    }
}
