package com.collywobble.blockstacker;

import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.badlogic.gdx.ai.fsm.StateMachine;
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
    private PieceGenerator pieceGenerator;

    public Piece(String type, Array<int[][]> positions, Color color, PieceGenerator pieceGenerator) {
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
        this.pieceGenerator = pieceGenerator;
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
        if (!intersectsWithLeftWall()) {
            for (Array<Rectangle> row : blockGrid) {
                for (Rectangle rect : row) {
                    rect.setX(rect.getX() - 25);
                }
            }
        }
    }

    public void moveRight() {
        if (!intersectsWithRightWall()) {
            for (Array<Rectangle> row : blockGrid) {
                for (Rectangle rect : row) {
                    rect.setX(rect.getX() + 25);
                    }
                }
            }
        }

    private boolean intersectsWithLeftWall() {
        Array<Rectangle> blockRectangles = getBlockRectangles();

        for (Rectangle rect : blockRectangles) {
            rect.setX(rect.getX() - 1);
            if (!withinGameBoard()) {
                rect.setX(rect.getX() + 1);
                return true;
            }
            rect.setX(rect.getX() + 1);
        }
        return false;
    }

    private boolean withinGameBoard() {
        Array<Rectangle> blockRectangles = getBlockRectangles();

        for (Rectangle rect : blockRectangles) {
            if (rect.x < 50 || rect.x + 25 > 300) {
                return false;
            }
        }
        return true;
    }

    private boolean intersectsWithRightWall() {
        Array<Rectangle> blockRectangles = getBlockRectangles();

        for (Rectangle rect : blockRectangles) {
            rect.setX(rect.getX() + 1);
            if (!withinGameBoard()) {
                rect.setX(rect.getX() - 1);
                return true;
            }
            rect.setX(rect.getX() - 1);
        }
        return false;
    }

    private boolean touchesFloor() {
        Array<Rectangle> blockRectangles = getBlockRectangles();

        for (Rectangle rect : blockRectangles) {
            rect.setY(rect.getY() - 1);
            if (rect.getY() < 250) {
                rect.setY(rect.getY() + 1);
                return true;
            }
            rect.setY(rect.getY() + 1);
        }
        return false;
    }

    public Array<Rectangle> getBlockRectangles() {
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

    public void rotate() {
        int oldIndex = getIndex();
        int newIndex = (oldIndex + 1) % (positions.size);
        setIndex(newIndex);
        setBlockPosition();
        if (!withinGameBoard()) {
            setIndex(oldIndex);
            setBlockPosition();
        }
    }

    public void moveDown() {
        if (TimeUtils.timeSinceMillis(moveTimer) > 500) {
            if (touchesFloor()) {
                pieceGenerator.addPieceToGameBoard(this);
            } else {
                moveTimer = TimeUtils.millis();
                for (Array<Rectangle> rowArray : blockGrid) {
                    for (Rectangle rectangle : rowArray) {
                        rectangle.setY(rectangle.getY() - 25);
                    }
                }
            }
        }
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
