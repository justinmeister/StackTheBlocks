package com.collywobble.blockstacker;

import com.badlogic.gdx.Gdx;
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
    Array blockGrid;
    final int WIDTH = 25;
    final int HEIGHT = 25;
    Texture texture;
    final int SCREEN_HEIGHT = 800;

    public Piece(String type, Array<int[][]> positions, Color color) {
        this.type = type;
        this.positions = positions;
        index = 0;
        this.color = color;
        blockGrid = makeBlockGrid();
        Pixmap pixmap = new Pixmap(25, 25, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        texture = new Texture(pixmap);

    }

    private Array makeBlockGrid() {
        Array<Array> blockGrid = new Array<Array>();
        for (int y = 0; y < 4; y++) {
            Array<Rectangle> row = new Array<Rectangle>();
            for (int x = 0; x < 4; x++) {
                Rectangle rectangle = new Rectangle(x, SCREEN_HEIGHT - y, WIDTH, HEIGHT);
                row.add(rectangle);
            }
            blockGrid.add(row);
        }
        return blockGrid;
    }

    @Override
    public void draw(Batch batch, float alpha) {
    }



}
