package com.collywobble.blockstacker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class PieceGenerator extends Actor {
    Array<int[][]> I_positions;
    Array<int[][]> O_positions;
    Array<int[][]> T_positions;
    Array<int[][]> S_positions;
    Array<int[][]> Z_positions;
    Array<int[][]> J_positions;
    Array<int[][]> L_positions;
    Piece newPiece;
    long newPieceTimer;


    public PieceGenerator() {
        newPieceTimer = TimeUtils.millis();
        I_positions = makeIPositions();
        O_positions = makeOPositions();
        T_positions = makeTPositions();
        S_positions = makeSPositions();
        Z_positions = makeZPositions();
        J_positions = makeJPositions();
        L_positions = makeLPositions();
    }

    @Override
    public void act(float delta) {
        if (TimeUtils.timeSinceMillis(newPieceTimer) > 5000) {
            if (newPiece == null) {
                newPiece = makePiece();
            }
        }
    }

    @Override
    public void draw(Batch batch, float alpha) {
        if (newPiece != null) {
            newPiece.draw(batch, alpha);
        }
    }

    private Array<int[][]> makeIPositions(){
        int[][] position0 = new int[][]{
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };

        int[][] position1 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 1}
        };

        Array<int[][]> IPositions = new Array<int[][]>();
        IPositions.add(position0);
        IPositions.add(position1);

        return IPositions;
    }

    private Array<int[][]> makeOPositions(){
        int[][] position0 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0}
        };

        Array<int[][]> OPositions = new Array<int[][]>();
        OPositions.add(position0);

        return OPositions;
    }

    private Array<int[][]> makeTPositions(){
        int[][] position0 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0}
        };


        int[][] position1 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
        };


        int[][] position2 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        };


        int[][] position3 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0}
        };

        Array<int[][]> TPositions = new Array<int[][]>();
        TPositions.add(position0);
        TPositions.add(position1);
        TPositions.add(position2);
        TPositions.add(position3);

        return TPositions;
    }

    private Array<int[][]> makeSPositions() {
        int[][] position0 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {1, 1, 0, 0}
        };


        int[][] position1 = new int[][]{
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
        };

        Array<int[][]> SPositions = new Array<int[][]>();
        SPositions.add(position0);
        SPositions.add(position1);

        return SPositions;
    }

    private Array<int[][]> makeZPositions() {
        int[][] position0 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
        };


        int[][] position1 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0}
        };

        Array<int[][]> ZPositions = new Array<int[][]>();
        ZPositions.add(position0);
        ZPositions.add(position1);

        return ZPositions;
    }

    private Array<int[][]> makeJPositions(){
        int[][] position0 = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };


        int[][] position1 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        };


        int[][] position2 = new int[][]{
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };


        int[][] position3 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 1, 0}
        };

        Array<int[][]> JPositions = new Array<int[][]>();
        JPositions.add(position0);
        JPositions.add(position1);
        JPositions.add(position2);
        JPositions.add(position3);

        return JPositions;
    }

    private Array<int[][]> makeLPositions(){
        int[][] position0 = new int[][]{
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0}
        };


        int[][] position1 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 0, 0, 0}
        };


        int[][] position2 = new int[][]{
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };


        int[][] position3 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {1, 1, 1, 0}
        };

        Array<int[][]> LPositions = new Array<int[][]>();
        LPositions.add(position0);
        LPositions.add(position1);
        LPositions.add(position2);
        LPositions.add(position3);

        return LPositions;
    }

    public Piece makePiece() {
        return new Piece("L", L_positions, Color.RED);
    }
}
