package com.collywobble.blockstacker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
    public Batch batch;
    final public int WIDTH = 480;
    final public int HEIGHT = 800;

	@Override
	public void create () {
        batch = new SpriteBatch();
        this.setScreen(new OnePlayerMode(this));

	}

	@Override
	public void render () {
		super.render();
	}
}
