package com.collywobble.blockstacker;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameBoard extends Actor {
    Rectangle rectangle;
    Texture rectTexture;
    final int WIDTH = 2 + (25 * 10) + 2;
    final int HEIGHT = 2 + (25 * 20) + 2;
    final int START_X = 50;
    final int START_Y = 800 - HEIGHT - 50;

    public GameBoard() {
        rectangle = new Rectangle(START_X, START_Y, WIDTH, HEIGHT);
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.RED);
        pixmap.drawRectangle(0, 0, WIDTH, HEIGHT);
        rectTexture = new Texture(pixmap);
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(rectTexture, rectangle.getX(), rectangle.getY());
    }
}
