package com.collywobble.blockstacker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Circle;
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
    PieceGenerator pieceGenerator;



    public OnePlayerMode(MainGame game) {
        this.game = game;
        stage = new Stage(new StretchViewport(game.WIDTH, game.HEIGHT));
        gameBoard = new GameBoard();
        pieceGenerator = new PieceGenerator();
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        TextButton rotateButton = new TextButton("ROTATE", skin);
        rotateButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                pieceGenerator.rotatePiece();
            }
        });
        rotateButton.setX(100);
        rotateButton.setY(100);

        TextButton moveLeftButton = new TextButton("LEFT", skin);
        moveLeftButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                pieceGenerator.movePieceLeft();
            }
        });
        moveLeftButton.setX(50);
        moveLeftButton.setY(100);

        TextButton moveRightButton = new TextButton("RIGHT", skin);
        moveRightButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                pieceGenerator.movePieceRight();
            }
        });
        moveRightButton.setX(170);
        moveRightButton.setY(100);

        stage.addActor(gameBoard);
        stage.addActor(pieceGenerator);
        stage.addActor(rotateButton);
        stage.addActor(moveLeftButton);
        stage.addActor(moveRightButton);


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
        pieceGenerator.makePiece();

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
