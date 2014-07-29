package com.collywobble.blockstacker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public enum PieceState implements State<Piece> {

    WAITING() {
        @Override
        public void update(Piece piece) {
            if (TimeUtils.timeSinceMillis(piece.moveTimer) > 2000) {
                piece.stateMachine.changeState(MOVING);
                piece.moveTimer = TimeUtils.millis();
            }
        }
    },

    MOVING() {
        @Override
        public void enter(Piece piece) {
            piece.setPosition(150, 775);
        }

        public void update(Piece piece) {
            piece.moveDown();

    }
    };

    @Override
    public void enter(Piece entity) {

    }

    @Override
    public void update(Piece entity) {
        //default
    }

    @Override
    public void exit(Piece entity) {

    }

    @Override
    public boolean onMessage(Telegram telegram) {
        return false;
    }
}
