package com.collywobble.blockstacker;

import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.badlogic.gdx.ai.fsm.StateMachine;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.HashMap;
import java.util.Map;

public class Tetromino extends Actor {
    int fallFreq;
    long moveTimer;
    StateMachine<Tetromino> stateMachine;
    Map<String, Integer> topLeftPos;

    public Tetromino() {
        topLeftPos = new HashMap<String, Integer>();
    }

    public void moveDown() {
        //pass
    }

    public int getFallFreq() {
        return fallFreq;
    }

    public void setFallFreq(int fallFreq) {
        this.fallFreq = fallFreq;
    }
}
