package de.morrisbr.notinfected.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.morrisbr.notinfected.game.NotInfected;
import de.morrisbr.notinfected.game.entity.Entity;
import de.morrisbr.notinfected.game.entity.entitys.Player;
import de.morrisbr.notinfected.game.gameobjects.GameObject;
import de.morrisbr.notinfected.game.gameobjects.Location;

import java.util.concurrent.CopyOnWriteArrayList;

public class World {

    private String name;
    private CopyOnWriteArrayList<GameObject> objects;
    private SpriteBatch batch;

    public World(SpriteBatch batch) {
        this.objects = new CopyOnWriteArrayList<>();
        this.batch = batch;
        onInit();
    }


    public void addObject(GameObject gameObject) {
        objects.add(gameObject);
    }
    public void removeObject(GameObject gameObject) {
        objects.remove(gameObject);
    }

    public void draw(float delta) {
        for (GameObject object : getObjects()) {
            object.draw(delta, batch);
        }
    }


    public void dispose() {
        for (GameObject object : getObjects()) {
            object.dispose();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(float delta) {
        for (GameObject object : getObjects()) {
            object.update(delta);
            checkCollision(object);

            if(object.getLocation().getX() < -object.getWidht() || object.getLocation().getX() > Gdx.graphics.getWidth() + 10) {
                System.out.println(object.getClass().getSimpleName() + " ist despawnt!");
                removeObject(object);
            }
        }


    }

    public CopyOnWriteArrayList<GameObject> getObjects()  {
        return objects;
    }



    private void checkCollision(GameObject gameObject) {
        for (GameObject other : getObjects()) {
            if (!other.equals(gameObject)) {
                Location currentObjlocation = gameObject.getLocation();
                Location otherObjLocation = other.getLocation();

                if (gameObject.isCollisionEnabled()
                        && currentObjlocation.getX()  +  gameObject.getWidht() >= other.getLocation().getX()
                        && other.getLocation().getX() +       other.getWidht() >=  currentObjlocation.getX()
                        && currentObjlocation.getY()  + gameObject.getHeight() >= other.getLocation().getY()
                        && other.getLocation().getY() +      other.getHeight() >=  currentObjlocation.getY()) {


                    onCollision(gameObject, other);
                    other.onCollision(gameObject);
                    gameObject.onCollision(other);
                }
            }
        }
    }




    public void onInit() {}
    public void onCreate() {}
    public void onLoad() {}
    public void onUnload() {}
    public void onCollision(GameObject perpetrator, GameObject victim) {}
}
