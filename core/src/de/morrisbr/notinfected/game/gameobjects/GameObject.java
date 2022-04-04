package de.morrisbr.notinfected.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.UUID;

public class GameObject {

    private Sprite sprite;
    private Texture texture;

    private int id;
    private UUID uuid;
    private int widht = 64;
    private int height = 64;
    private boolean collision;
    private Location location;



    private float accumulatedGravity = 0f;
    private float gravity = 11.5f;


    public GameObject() {}


    public GameObject(String texturePath, int id, UUID uuid, int widht, int height, Location location) {
        setUuid(uuid);
        setLocation(location);
        setId(id);
        setWidht(widht);
        setHeight(height);
        setTexture(texturePath);
    }

    public GameObject(String texturePath, int id, int widht, int height) {
        setId(id);
        setWidht(widht);
        setHeight(height);
        setTexture(texturePath);
    }


    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getWidht() {
        return widht;
    }

    public void setWidht(int widht) {
        this.widht = widht;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    /**
     *
     * Get the Location from this GameObject
     *
     * @return location
     **/
    public Location getLocation() {
        return location;
    }

    /**
     *
     * Set the Location for this GameObject
     *
     **/
    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTexture(String textureFile) {
        texture = new Texture(Gdx.files.internal(textureFile));
        sprite = new Sprite(texture);
        this.sprite.setPosition(getLocation().getX(), getLocation().getY());
        this.sprite.setSize(getWidht(), getHeight());
    }


    public void init() {}

    /**
     *
     * Draw this GameObject
     *
     * @param delta
     */
    public void draw(float delta, SpriteBatch batch) {}

    /**
     *
     * Update this GameObject
     *
     * @param delta
     */
    public void update(float delta) {

        accumulatedGravity += gravity * delta;
        getLocation().setY(getLocation().getY() - (accumulatedGravity * delta));
        getSprite().setX(getLocation().getX());
        getSprite().setY(getLocation().getY());

    }
    public void dispose() {}



    public float getAccumulatedGravity() {
        return accumulatedGravity;
    }

    public void setAccumulatedGravity(float accumulatedGravity) {
        this.accumulatedGravity = accumulatedGravity;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    /**
     *
     * Set the Collision acictive or inactive for this GameObject
     *
     **/
    public void setCollisionEnabled(boolean collision) {
        this.collision = collision;
    }

    /**
     *
     * Has this GameObject a Collision
     *
     * @return collision
     **/
    public boolean isCollisionEnabled() {
        return collision;
    }

    /**
     *
     * Trigger on collision by Other GameObject
     *
     * @param other
     */
    public void onCollision(GameObject other) {}



}
