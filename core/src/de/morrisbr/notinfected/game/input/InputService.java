package de.morrisbr.notinfected.game.input;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import de.morrisbr.notinfected.game.NotInfected;
import de.morrisbr.notinfected.game.entity.entitys.Player;
import de.morrisbr.notinfected.game.gameobjects.Location;

public class InputService implements InputProcessor {

    private NotInfected notInfected;
    private Player player;

    public InputService(NotInfected notInfected) {
        this.notInfected = notInfected;
        this.player = NotInfected.getInstance().player;
    }


    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.SPACE) {
            player.jump();
        }

        if(keycode == Input.Keys.F) {
            player.shot();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        System.out.println(player.getLocation().getY());
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(screenX > Gdx.graphics.getWidth()/2) {
            player.updateMovement(Player.MoveAction.RIGHT, Gdx.graphics.getDeltaTime());
        } else if(screenX < Gdx.graphics.getWidth()/2) {
            player.updateMovement(Player.MoveAction.LEFT, Gdx.graphics.getDeltaTime());
        } else if(screenY >= Gdx.graphics.getHeight()/2) {
            player.jump();
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
       // System.out.println(player.getLocation().getY());
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
