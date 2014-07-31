package com.collywobble.blockstacker;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class GameBoard extends Actor {
    Rectangle rectangle;
    Texture rectTexture;
    final int WIDTH = 1 + (25 * 10) + 1;
    final int HEIGHT = 1 + (25 * 20) + 1;
    final int START_X = 50 - 1;
    final int START_Y = 800 - HEIGHT - 50 + 1;
    int[][] rectArray;
    Array<Color> colorArray;

    public GameBoard() {
        rectangle = new Rectangle(START_X, START_Y, WIDTH, HEIGHT);
        rectTexture = makeTexture(Color.RED);
        rectArray = new int[20][10];
        colorArray = makeColorArray();

    }

    private Texture makeTexture(Color color) {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.drawRectangle(0, 0, WIDTH, HEIGHT);
        return new Texture(pixmap);
    }

    private Array<Color> makeColorArray() {
        Array<Color> newColorArray = new Array<Color>();

        newColorArray.add(Color.BLACK);
        newColorArray.add(Color.BLUE);
        newColorArray.add(Color.PINK);
        newColorArray.add(Color.CYAN);
        newColorArray.add(Color.ORANGE);
        newColorArray.add(Color.RED);
        newColorArray.add(Color.MAGENTA);
        newColorArray.add(Color.GREEN);

        return newColorArray;
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(rectTexture, rectangle.getX(), rectangle.getY());
        for (int i = 0; i < rectArray.length; i++) {
            for (int j = 0; j < rectArray[i].length; j++) {
                if (rectArray[i][j] != 0) {
                    int xPos = (25 * j) + 50;
                    int yPos = 800 - (25 * i) - 75;
                    Rectangle rect = new Rectangle(xPos, yPos, 25, 25);

                    Color newColor = colorArray.get(rectArray[i][j]);
                    Pixmap pixmap = new Pixmap(25, 25, Pixmap.Format.RGBA8888);
                    pixmap.setColor(newColor);
                    pixmap.fill();
                    Texture newTexture = new Texture(pixmap);
                    batch.draw(newTexture, rect.getX(), rect.getY());
                }
            }
        }
    }
}
