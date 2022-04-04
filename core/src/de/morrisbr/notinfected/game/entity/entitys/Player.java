package de.morrisbr.notinfected.game.entity.entitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.morrisbr.notinfected.game.entity.ai.ZombieAI;
import de.morrisbr.notinfected.game.gameobjects.Location;
import de.morrisbr.notinfected.game.entity.Entity;
import de.morrisbr.notinfected.game.gameobjects.objects.ShotObject;

public class Player extends Entity {

    //private SpriteBatch batch = new SpriteBatch();
    private float jumpStrength = 220f;

    public Player(Location location) {
        setLocation(location);
    }

    public Player(Location location, float speed, String texturePath) {
        setId(0);
        setLocation(location);
        setSpeed(speed);
        setTexture(texturePath);
    }

    public Player() {}


    public void jump()
    {
        if (getAccumulatedGravity() == 0f)
        {
            setAccumulatedGravity(getAccumulatedGravity()-jumpStrength);
        }
    }

    public void shot() {
        ShotObject shotObject = new ShotObject(4, getLocation());
        getLocation().getWorld().addObject(shotObject);
    }

    public void updateMovement(MoveAction moveAction, float delta) {
        switch (moveAction) {
            case FRONT:
                break;
            case BACK:
                break;
            case LEFT:
                getLocation().setX(getLocation().getX() - (getSpeed()*delta));
                break;
            case RIGHT:
                getLocation().setX(getLocation().getX() + (getSpeed()*delta));
                break;
            case JUMP:
                break;
        }
    }


    @Override
    public void init() {
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            jump();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.F)) {
            shot();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            updateMovement(MoveAction.RIGHT, delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            updateMovement(MoveAction.LEFT, delta);
        }

    }

    @Override
    public void draw(float delta, SpriteBatch batch) {
        getSprite().draw(batch);
    }
    @Override
    public void dispose() {
        //batch.dispose();
        getTexture().dispose();
    }

    public enum MoveAction {
        FRONT, BACK, LEFT, RIGHT, JUMP;
    }

}
