package com.collywobble.blockstacker;

import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.badlogic.gdx.ai.fsm.StateMachine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
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

    final String TOP = "top";
    final String LEFT = "left";

    public Tetromino(Color color, Array<int[][]> positions) {
        topLeftPos = new HashMap<String, Integer>();
        moveTimer = TimeUtils.millis();
        this.positions = positions;
        positionIndex = 0;
        position = this.positions.get(positionIndex);

        setupTopLeftPos();
        setupTexture(color);
        getRectArray();

    }

    private void getRectArray() {
        rectArray = new Array<Rectangle>();
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                Rectangle rectangle = new Rectangle(
                        25,
                        25,
                        50 + (topLeftPos.get(LEFT) + j) * 25,
                        50 + (topLeftPos.get(TOP) + i) * 25);
                rectArray.add(rectangle);
            }
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
        topLeftPos.put(LEFT, 0);
    }

    @Override
    public void act(float delta) {
        moveDown();
    }

    public void moveDown() {
        if (TimeUtils.timeSinceMillis(moveTimer) > fallFreq) {
            moveTimer = TimeUtils.millis();
            topLeftPos.put(TOP, topLeftPos.get(TOP) + 1);
        }
    }

    public int getFallFreq() {
        return fallFreq;
    }

    public void setFallFreq(int fallFreq) {
        this.fallFreq = fallFreq;
    }

}
