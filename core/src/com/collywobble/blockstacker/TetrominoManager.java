package com.collywobble.blockstacker;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class TetrominoManager extends Actor {
    Tetromino newPiece;
    GameBoard gameBoard;
    Array<int[][]> T_POSITIONS;
    Array<int[][]> I_POSITIONS;
    Array<int[][]> J_POSITIONS;
    Array<int[][]> L_POSITIONS;
    Array<int[][]> S_POSITIONS;
    Array<int[][]> Z_POSITIONS;
    Array<int[][]> O_POSITIONS;


    public TetrominoManager(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        setupPositions();
        newPiece = new Tetromino(Color.GREEN, T_POSITIONS, gameBoard.getArray());
    }

    @Override
    public void act(float delta) {
        newPiece.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Rectangle rect : newPiece.rectArray) {
            batch.draw(newPiece.texture, rect.getX(), rect.getY());
        }


    }

    public void rotatePiece() {
        newPiece.rotate();
    }

    public void movePieceLeft() {
        newPiece.moveLeft();
    }

    public void movePieceRight() {
        newPiece.moveRight();
    }

    public void makePiece() {}

    private void setupPositions() {
        int[][] position0 = new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] position1 = new int[][]{
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };

        I_POSITIONS = new Array<int[][]>();
        I_POSITIONS.add(position0);
        I_POSITIONS.add(position1);

        int[][] position2 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0}
        };

        O_POSITIONS = new Array<int[][]>();
        O_POSITIONS.add(position2);

        int[][] position3 = new int[][]{
                {1, 1, 1},
                {0, 1, 0}
        };


        int[][] position4 = new int[][]{
                {0, 1},
                {1, 1},
                {0, 1}
        };


        int[][] position5 = new int[][]{
                {0, 1, 0},
                {1, 1, 1}
        };


        int[][] position6 = new int[][]{
                {0, 1, 0},
                {0, 1, 1},
                {0, 1, 0}
        };

        T_POSITIONS = new Array<int[][]>();
        T_POSITIONS.add(position3);
        T_POSITIONS.add(position4);
        T_POSITIONS.add(position5);
        T_POSITIONS.add(position6);

        int[][] position7 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {1, 1, 0, 0}
        };


        int[][] position8 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0}
        };

        S_POSITIONS = new Array<int[][]>();
        S_POSITIONS.add(position7);
        S_POSITIONS.add(position8);

        int[][] position9 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
        };


        int[][] position10 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0}
        };

        Z_POSITIONS = new Array<int[][]>();
        Z_POSITIONS.add(position9);
        Z_POSITIONS.add(position10);

        int[][] position11 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 1, 0}
        };

        int[][] position12 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };


        int[][] position13 = new int[][]{
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        };


        int[][] position14 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };



        J_POSITIONS = new Array<int[][]>();
        J_POSITIONS.add(position11);
        J_POSITIONS.add(position12);
        J_POSITIONS.add(position13);
        J_POSITIONS.add(position14);

        int[][] position15 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 0, 0, 0}
        };

        int[][] position16 = new int[][]{
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };

        int[][] position17 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int[][] position18 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0}
        };

        L_POSITIONS = new Array<int[][]>();
        L_POSITIONS.add(position15);
        L_POSITIONS.add(position16);
        L_POSITIONS.add(position17);
        L_POSITIONS.add(position18);
    }
}
