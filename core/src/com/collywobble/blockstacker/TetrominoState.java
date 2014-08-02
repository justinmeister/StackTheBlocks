package com.collywobble.blockstacker;

import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.utils.TimeUtils;

public enum TetrominoState implements State<Tetromino> {

    WAITING() {
        @Override
        public void update(Tetromino tetromino) {
            if (TimeUtils.timeSinceMillis(tetromino.moveTimer) > 2000) {
                tetromino.stateMachine.changeState(MOVING);
            }
        }
        @Override
        public void exit(Tetromino tetromino) {
            tetromino.moveTimer = TimeUtils.millis();
        }
    },

    MOVING() {
        @Override
        public void enter(Tetromino tetromino) {
            tetromino.topLeftPos.put("row", 0);
            tetromino.topLeftPos.put("column", 0);
        }

        public void update(Tetromino tetromino) {
            tetromino.moveDown();

    }
    };

    @Override
    public void enter(Tetromino entity) {

    }

    @Override
    public void update(Tetromino entity) {

    }

    @Override
    public void exit(Tetromino entity) {

    }

    @Override
    public boolean onMessage(Telegram telegram) {
        return false;
    }
}
