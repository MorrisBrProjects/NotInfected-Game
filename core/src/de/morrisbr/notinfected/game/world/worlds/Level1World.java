package de.morrisbr.notinfected.game.world.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.bullet.collision._btMprSimplex_t;
import de.morrisbr.notinfected.game.NotInfected;
import de.morrisbr.notinfected.game.entity.Entity;
import de.morrisbr.notinfected.game.entity.entitys.Player;
import de.morrisbr.notinfected.game.entity.entitys.Zombie;
import de.morrisbr.notinfected.game.gameobjects.GameObject;
import de.morrisbr.notinfected.game.gameobjects.Location;
import de.morrisbr.notinfected.game.gameobjects.objects.BodenObject;
import de.morrisbr.notinfected.game.gameobjects.objects.ShotObject;
import de.morrisbr.notinfected.game.gameobjects.objects.TestObject;
import de.morrisbr.notinfected.game.world.World;

import java.util.UUID;

public class Level1World extends World {

    private Player player;

    public Level1World(SpriteBatch batch) {
        super(batch);
        setName("level1");
    }

    @Override
    public void onInit() {

        player = NotInfected.getInstance().player;
        player.setLocation(new Location(0, 120, this));
        player.setGravity(200.5f);
        player.setCollisionEnabled(true);
        player.setSpeed(250f);

        TestObject testObject = new TestObject(1, 64, 32, new Location(1f, 200f, this));
        testObject.setCollisionEnabled(false);
        testObject.setGravity(0f);

        BodenObject bodenObject = new BodenObject(Gdx.graphics.getWidth(), 32, new Location(0,0, this));
        bodenObject.setGravity(0f);
        bodenObject.setCollisionEnabled(true);

        Zombie zombie = new Zombie(new Location(Gdx.graphics.getWidth(),60, this), 0.1f);
        zombie.setGravity(200.5f);
        zombie.setCollisionEnabled(true);


        //addObject(1, player);
        addObject(testObject);
        addObject(bodenObject);
        addObject(zombie);
        addObject(player);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onLoad() {


    }

    @Override
    public void onUnload() {

    }


    @Override
    public void draw(float delta) {
        super.draw(delta);
        //player.draw();

    }

    @Override
    public void update(float delta) {
        super.update(delta);
        //player.update(delta);


        if(Gdx.input.isKeyJustPressed(Input.Keys.F)) {
            ShotObject shotObject = new ShotObject(4, player.getLocation());
            addObject(shotObject);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        //player.dispose();
    }

    @Override
    public void onCollision(GameObject perpetrator, GameObject victim) {

        switch (perpetrator.getId()) {
            case 0:
                Player player = (Player) perpetrator;
                player.setAccumulatedGravity(0f);

                if(victim.isCollisionEnabled()) {
                    player.getLocation().setY(victim.getLocation().getY() + victim.getHeight());
                }

                if(victim.getId() == 3) {
                    //removeObject(player);
                }
                break;
            case 3:
                perpetrator.setAccumulatedGravity(0f);
                perpetrator.getLocation().setY(victim.getLocation().getY()+victim.getHeight());
                break;
        }
    }
}
