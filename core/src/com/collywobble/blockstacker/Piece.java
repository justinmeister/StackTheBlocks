package com.collywobble.blockstacker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.fsm.StateMachine;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Piece extends Actor {
    String type;
    Array<int[][]> positions;
    int index;
    Color color;
    Array<Array<Rectangle>> blockGrid;
    final int WIDTH = 25;
    final int HEIGHT = 25;
    Texture texture;
    int[][] position;
    final int SCREEN_HEIGHT = 800;
    long moveTimer;
    public StateMachine<Piece> stateMachine;

    public Piece(String type, Array<int[][]> positions, Color color) {
        stateMachine = new DefaultStateMachine<Piece>(this, PieceState.WAITING);
        this.type = type;
        this.positions = positions;
        moveTimer = TimeUtils.millis();
        index = 0;
        this.color = color;
        position = positions.get(index);
        blockGrid = makeBlockGrid();
        Pixmap pixmap = new Pixmap(25, 25, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        texture = new Texture(pixmap);
    }


    private Array<Array<Rectangle>> makeBlockGrid() {
        Array<Array<Rectangle>> blockGrid = new Array<Array<Rectangle>>();
        for (int y = 0; y < 4; y++) {
            Array<Rectangle> row = new Array<Rectangle>();
            for (int x = 0; x < 4; x++) {
                Rectangle rectangle = new Rectangle((x+2+10+2)*25,
                        SCREEN_HEIGHT - ((y+1)*25),
                        WIDTH,
                        HEIGHT);
                row.add(rectangle);
            }
            blockGrid.add(row);
        }
        return blockGrid;
    }

    @Override
    public void draw(Batch batch, float alpha) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(position[i][j] == 1) {
                    Array<Rectangle> row =  blockGrid.get(i);
                    Rectangle rectangle = row.get(j);
                    batch.draw(texture, rectangle.getX(), rectangle.getY());
                }
            }
        }
    }

    @Override
    public void act(float alpha) {
        stateMachine.update();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setBlockPosition() {
        position = positions.get(index);
    }

    public void moveLeft() {
        for (Array<Rectangle> row : blockGrid) {
            for (Rectangle rect : row) {
                rect.setX(rect.getX() - 25);
            }
        }
    }

    public void moveRight() {
        for (Array<Rectangle> row : blockGrid) {
            for (Rectangle rect : row) {
                rect.setX(rect.getX() + 25);
                if (intersectsWithWall()) {
                    rect.setX((rect.getX() - 25));
                }
            }
        }
    }

    private boolean intersectsWithWall() {
        Array<Rectangle> row = blockGrid.get(0);
        Rectangle topLeft = row.get(0);
        Rectangle topRight = row.get(row.size-1);

        if (topLeft.getX() < 50) {
            return true;
        } else if ((topRight.getX() + 25) > 300) {
            return true;
        } else {
            return false;
        }
    }

    private Array<Rectangle> getRectanglesForBlocks() {
        Array<Rectangle> rectArray = new Array<Rectangle>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (position[i][j] == 1) {
                    Array<Rectangle> row = blockGrid.get(i);
                    rectArray.add(row.get(j));
                }
            }
        }
        return rectArray;
    }

    public void setPosition(float newX, float newY) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Array<Rectangle> row = blockGrid.get(i);
                Rectangle rect = row.get(j);
                rect.setX(newX + (j * 25));
                rect.setY(newY - (i * 25));
            }
        }
    }
}
