package com.collywobble.blockstacker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;


public class OnePlayerMode implements Screen {
    MainGame game;
    GameBoard gameBoard;
    Stage stage;
    TetrominoManager tetrominoManager;
    final int FAST_FALL_FREQ = 25;
    final int SLOW_FALL_FREQ = 500;

    public OnePlayerMode(MainGame game) {
        this.game = game;
        stage = new Stage(new StretchViewport(game.WIDTH, game.HEIGHT));
        gameBoard = new GameBoard();
        tetrominoManager = new TetrominoManager(gameBoard);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        TextButton rotateButton = new TextButton("ROTATE", skin);
        rotateButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                tetrominoManager.rotatePiece();
            }
        });
        rotateButton.setX(150);
        rotateButton.setY(100);
        rotateButton.setSize(100, 100);

        TextButton moveLeftButton = new TextButton("LEFT", skin);
        moveLeftButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                tetrominoManager.movePieceLeft();
            }
        });
        moveLeftButton.setX(50);
        moveLeftButton.setY(100);
        moveLeftButton.setSize(100, 100);

        TextButton moveRightButton = new TextButton("RIGHT", skin);
        moveRightButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                tetrominoManager.movePieceRight();
            }
        });
        moveRightButton.setX(250);
        moveRightButton.setY(100);
        moveRightButton.setSize(100, 100);

        TextButton moveFastButton = new TextButton("FAST DOWN", skin);
        moveFastButton.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent e, float x, float y, int pointer, int button) {
                tetrominoManager.newPiece.setFallFreq(SLOW_FALL_FREQ);
            }
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int pointer, int button) {
                tetrominoManager.newPiece.setFallFreq(FAST_FALL_FREQ);
                return true;
            }
        });
        moveFastButton.setX(50);
        moveFastButton.setY(0);
        moveFastButton.setSize(100, 100);

        stage.addActor(gameBoard);
        stage.addActor(tetrominoManager);
        stage.addActor(rotateButton);
        stage.addActor(moveLeftButton);
        stage.addActor(moveRightButton);
        stage.addActor(moveFastButton);


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
        Gdx.input.setInputProcessor(stage);
        tetrominoManager.makePiece();

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
