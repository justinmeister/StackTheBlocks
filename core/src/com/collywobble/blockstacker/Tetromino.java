package com.collywobble.blockstacker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.HashMap;
import java.util.Map;

public class Tetromino extends Actor {
    int fallFreq = 2000;
    long moveTimer;
    Map<String, Integer> topLeftPos;
    Texture texture;
    Array<Rectangle> rectArray;
    Array<int[][]> positions;
    int positionIndex;
    int[][] position;
    int[][] boardArray;
    boolean blankLeftColumn = false;

    final String TOP = "top";
    final String LEFT = "left";

    public Tetromino(Color color, Array<int[][]> positions, int[][] boardArray) {
        topLeftPos = new HashMap<String, Integer>();
        moveTimer = TimeUtils.millis();
        this.positions = positions;
        positionIndex = 0;
        position = this.positions.get(positionIndex);
        this.boardArray = boardArray;

        setupTopLeftPos();
        setupTexture(color);
        rectArray = makeRectArray();

    }

    private Array<Rectangle> makeRectArray() {
        Array<Rectangle> tempRectArray = new Array<Rectangle>();
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                if (position[i][j] != 0) {
                    Rectangle rectangle = new Rectangle(
                            (topLeftPos.get(LEFT) + j) * 25,
                            800 - ((topLeftPos.get(TOP) + i) * 25) - 25,
                            25,
                            25);
                    tempRectArray.add(rectangle);
                }
            }
        }
        return tempRectArray;
    }

    private void setupTexture(Color color) {
        Pixmap pixmap = new Pixmap(25, 25, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();

        texture = new Texture(pixmap);
    }

    private void setupTopLeftPos() {
        topLeftPos = new HashMap<String, Integer>();
        topLeftPos.put(TOP, 1);
        topLeftPos.put(LEFT, 5);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Rectangle rect : rectArray) {
            batch.draw(texture, rect.getX(), rect.getY());
        }
    }

    @Override
    public void act(float delta) {
        moveDown();
    }

    public void moveDown() {
        if (TimeUtils.timeSinceMillis(moveTimer) > fallFreq && bottomEmpty()) {
            topLeftPos.put(TOP, topLeftPos.get(TOP) + 1);
            rectArray = makeRectArray();
            moveTimer = TimeUtils.millis();
        }
    }

    private boolean bottomEmpty() {
        boolean bottomEmpty = true;

        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                int y = i + topLeftPos.get(TOP) + 1;
                int x = j + topLeftPos.get(LEFT);

                if (boardArray[y][x] != 0 && position[i][j] != 0) {
                    bottomEmpty = false;
                }
            }
        }
        Gdx.app.log("bottomEmpty", String.valueOf(bottomEmpty));
        return bottomEmpty;
    }

    public void rotate() {
        if (okToRotate()) {
            positionIndex = (positionIndex + 1) % (positions.size);
            position = positions.get(positionIndex);
            rectArray = makeRectArray();
        }
    }

    private boolean okToRotate() {
        boolean okToRotate = true;

        int tempPositionIndex = (positionIndex + 1) % (positions.size);
        int[][] tempPosition = positions.get(tempPositionIndex);

        for (int i = 0; i < tempPosition.length; i++) {
            for (int j = 0; j < tempPosition[i].length; j++) {
                int y = i + topLeftPos.get(TOP);
                int x = j + topLeftPos.get(LEFT);
                if (tempPosition[i][j] != 0 && boardArray[y][x] != 0) {
                    okToRotate = false;
                }
            }
        }
        return okToRotate;
    }

    public void moveRight() {
        if (rightSideOpen()) {
            topLeftPos.put(LEFT, topLeftPos.get(LEFT) + 1);
            rectArray = makeRectArray();
        }
    }

    public void moveLeft() {
        if (leftSideOpen()) {
            topLeftPos.put(LEFT, topLeftPos.get(LEFT) - 1);
            rectArray = makeRectArray();
        }
    }

    private boolean rightSideOpen() {
        boolean rightEmpty = true;

        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                int y = i + topLeftPos.get(TOP);
                int x = j + topLeftPos.get(LEFT) + 1;

                if (boardArray[y][x] != 0 && position[i][j] != 0) {
                    rightEmpty = false;
                }
            }
        }
        return rightEmpty;
    }

    private boolean leftSideOpen() {
        boolean leftEmpty = true;

        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                int y = i + topLeftPos.get(TOP);
                int x = j + topLeftPos.get(LEFT) - 1;

                if (boardArray[y][x] != 0 && position[i][j] != 0) {
                    leftEmpty = false;
                }
            }
        }
        return leftEmpty;
    }

    public int getFallFreq() {
        return fallFreq;
    }

    public void setFallFreq(int fallFreq) {
        this.fallFreq = fallFreq;
    }

}
