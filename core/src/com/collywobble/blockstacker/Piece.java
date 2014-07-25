package com.collywobble.blockstacker;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

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

    public Piece(String type, Array<int[][]> positions, Color color) {
        this.type = type;
        this.positions = positions;
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
                Rectangle rectangle = new Rectangle((x+2)*25,
                        SCREEN_HEIGHT - ((y+2)*25),
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



}
