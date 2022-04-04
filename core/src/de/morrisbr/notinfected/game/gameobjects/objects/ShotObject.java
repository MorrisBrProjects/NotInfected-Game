package de.morrisbr.notinfected.game.gameobjects.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.morrisbr.notinfected.game.gameobjects.GameObject;
import de.morrisbr.notinfected.game.gameobjects.Location;

public class ShotObject extends GameObject {


    public ShotObject(int id, Location location) {
        setId(id);
        setLocation(location);
        setTexture("shot.png");
        setGravity(0f);
        setCollisionEnabled(false);
        setHeight(32);
        setWidht(64);
        getSprite().setSize(164, 32);

    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void draw(float delta, SpriteBatch batch) {
        super.draw(delta, batch);
        getSprite().draw(batch);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        setLocation(new Location(getLocation().getX() + 20, getLocation().getY(), getLocation().getWorld()));
        System.out.println(getLocation().getX());
    }

    @Override
    public void onCollision(GameObject other) {
        super.onCollision(other);

        if(other.getId() == 3) {
            other.getLocation().getWorld().removeObject(other);
            other.getLocation().getWorld().removeObject(this);
        }
    }


    public void spawn() {
        getLocation().getWorld().addObject(this);
    }
}
