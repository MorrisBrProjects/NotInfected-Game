package de.morrisbr.notinfected.game.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class WorldService {

    private HashMap<String, World> worlds;
    private World currentWorld;

    public WorldService() {
        this.worlds = new HashMap<>();
    }

    public void addWorld(String name, World world) {
        world.setName(name);
        worlds.put(name, world);
    }

    public void removeWorld(String name) {
        worlds.remove(name);
    }

    public World getWorld(String name) {
        return worlds.get(name);
    }

    public ArrayList<World> getWorlds() {
        return new ArrayList<>(worlds.values());
    }

    public World getCurrentWorld() {
        return currentWorld;
    }

    public void setCurrentWorld(World currentWorld) {
        this.currentWorld = currentWorld;
    }


    public void load(String name) {
        if(getWorld(name) != null) {
            if(currentWorld != null) {
                currentWorld.onUnload();
            }
            getWorld(name).onLoad();
            setCurrentWorld(getWorld(name));
        }
    }

    public void load(World world) {
        if(currentWorld != null) {
            currentWorld.onUnload();
        }
        world.onLoad();
        setCurrentWorld(world);
    }



}
