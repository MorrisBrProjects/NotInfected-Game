package de.morrisbr.notinfected.game.entity.entitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.morrisbr.notinfected.game.entity.Entity;
import de.morrisbr.notinfected.game.entity.ai.EntityAI;
import de.morrisbr.notinfected.game.entity.ai.ZombieAI;
import de.morrisbr.notinfected.game.gameobjects.Location;

public class Zombie extends Entity {

    public Zombie(Location location, float speed) {
        setId(3);
        setLocation(location);
        setSpeed(speed);
        setTexture("zombie.png");
        setEntityAI(new ZombieAI());
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

        getEntityAI().update(this);



        if(getLocation().getX() < -getWidht()) {
            getLocation().getWorld().removeObject(this);
            System.out.println("fdsgfdsf");
        }
    }
}
