package com.collywobble.blockstacker;

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
    int fallFreq = 500;
    long moveTimer;
    Map<String, Integer> topLeftPos;
    Texture texture;
    Array<Rectangle> rectArray;
    Array<int[][]> positions;
    int positionIndex;
    int[][] position;
    int[][] boardArray;
    int maxPieceWidth;
    int maxPieceHeight = 0;

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
        makeRectArray();

    }

    private void makeRectArray() {
        maxPieceWidth = 0;
        int tempRowWidth = 0;

        rectArray = new Array<Rectangle>();
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                if (position[i][j] != 0) {
                    Rectangle rectangle = new Rectangle(
                            50 + (topLeftPos.get(LEFT) + j) * 25,
                            800 - (topLeftPos.get(TOP) + i) * 25 - 25,
                            25,
                            25);
                    rectArray.add(rectangle);
                    tempRowWidth++;
                }
            }
            if (maxPieceWidth < tempRowWidth) {
                maxPieceWidth = tempRowWidth;
            }
            tempRowWidth = 0;
        }
    }

    private void setupTexture(Color color) {
        Pixmap pixmap = new Pixmap(25, 25, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();

        texture = new Texture(pixmap);
    }

    private void setupTopLeftPos() {
        topLeftPos = new HashMap<String, Integer>();
        topLeftPos.put(TOP, 0);
        topLeftPos.put(LEFT, 3);
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
        if (TimeUtils.timeSinceMillis(moveTimer) > fallFreq) {
            makeRectArray();
            moveTimer = TimeUtils.millis();
            topLeftPos.put(TOP, topLeftPos.get(TOP) + 1);
        }
    }

    public void rotate() {
        positionIndex = (positionIndex + 1) % (position.length);
        position = positions.get(positionIndex);
        makeRectArray();
    }

    public void moveRight() {
        if (rightSideOpen()) {
            topLeftPos.put(LEFT, topLeftPos.get(LEFT) + 1);
            makeRectArray();
        }
    }

    public void moveLeft() {
        if (leftSideOpen()) {
            topLeftPos.put(LEFT, topLeftPos.get(LEFT) - 1);
            makeRectArray();
        }
    }

    private boolean rightSideOpen() {
        boolean rightEmpty = true;

        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < maxPieceWidth; j++) {
                int y = i + topLeftPos.get(TOP);
                int x = j + topLeftPos.get(LEFT) + 1;

                if (x >= 0
                        && x < 10
                        && y >= 0
                        && y < 20) {
                    if (boardArray[y][x] != 0) {
                        rightEmpty = false;
                    }
                } else rightEmpty = false;
            }
        }
        return rightEmpty;
    }

    private boolean leftSideOpen() {
        boolean leftEmpty = true;

        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < maxPieceWidth; j++) {
                int y = i + topLeftPos.get(TOP);
                int x = j + topLeftPos.get(LEFT) - 1;

                if (x >= 0
                        && x < 10
                        && y >= 0
                        && y < 20) {
                    if (boardArray[y][x] != 0) {
                        leftEmpty = false;
                    }
                } else leftEmpty = false;
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
