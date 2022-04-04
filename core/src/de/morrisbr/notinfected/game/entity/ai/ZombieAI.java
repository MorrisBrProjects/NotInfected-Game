package de.morrisbr.notinfected.game.entity.ai;

import com.badlogic.gdx.Gdx;
import de.morrisbr.notinfected.game.entity.Entity;
import de.morrisbr.notinfected.game.gameobjects.Location;

public class ZombieAI extends EntityAI {

    @Override
    public void update(Entity entity) {
        super.update(entity);

        if(entity.getLocation().getX() < -entity.getWidht()+1) {
            entity.setLocation(new Location(Gdx.graphics.getWidth(),60, entity.getLocation().getWorld()));
        }
        entity.setLocation(new Location(entity.getLocation().getX() - 1, entity.getLocation().getY(), entity.getLocation().getWorld()));
    }
}
