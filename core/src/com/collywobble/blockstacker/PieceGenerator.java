package com.collywobble.blockstacker;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class PieceGenerator extends Actor {
    Array I_positions;
    Array O_positions;
    Array T_positions;
    Array S_positions;
    Array Z_positions;
    Array J_positions;
    Array L_positions;

    public PieceGenerator(String type) {
        I_positions = makeIPositions();
        O_positions = makeOPositions();
        T_positions = makeTPositions();
        S_positions = makeSPositions();
        Z_positions = makeZPositions();
        J_positions = makeJPositions();
        L_positions = makeLPositions();

    }

    private Array makeIPositions(){
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

    private Array makeOPositions(){
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

    private Array makeTPositions(){
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

    private Array makeSPositions() {
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

    private Array makeZPositions() {
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

    private Array makeJPositions(){
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

    private Array makeLPositions(){
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


    private Array makeBlockArray() {
        return new Array();
    }
}
