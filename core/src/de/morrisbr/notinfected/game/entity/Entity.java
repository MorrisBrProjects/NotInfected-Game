package de.morrisbr.notinfected.game.entity;

import de.morrisbr.notinfected.game.entity.ai.EntityAI;
import de.morrisbr.notinfected.game.gameobjects.GameObject;
import de.morrisbr.notinfected.game.gameobjects.Location;

import java.util.UUID;

public class Entity extends GameObject {

    private int health;
    private float speed;

    private EntityAI entityAI;


    public Entity() {
    }

    public Entity(String texturePath, int id, UUID uuid, int widht, int height, Location location) {
        super(texturePath, id, uuid, widht, height, location);
    }

    public Entity(String texturePath, int id, int widht, int height) {
        super(texturePath, id, widht, height);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public EntityAI getEntityAI() {
        return entityAI;
    }

    public void setEntityAI(EntityAI entityAI) {
        this.entityAI = entityAI;
    }
}
