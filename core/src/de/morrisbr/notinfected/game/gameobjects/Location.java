package de.morrisbr.notinfected.game.gameobjects;

import de.morrisbr.notinfected.game.world.World;

public class Location {

    private float x, y;
    private World world;

    public Location() {}

    public Location(float x, float y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
    }

    public Location(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Location clone() {
        return new Location(x, y, world);
    }
}
