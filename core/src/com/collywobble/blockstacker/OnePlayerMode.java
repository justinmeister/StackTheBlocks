package com.collywobble.blockstacker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class OnePlayerMode implements Screen {
    MainGame game;
    GameBoard gameBoard;
    Stage stage;


    public OnePlayerMode(MainGame game) {
        this.game = game;
        stage = new Stage(new StretchViewport(game.WIDTH, game.HEIGHT));
        gameBoard = new GameBoard();
        stage.addActor(gameBoard);

    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.075f, 0.059f, 0.188f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
