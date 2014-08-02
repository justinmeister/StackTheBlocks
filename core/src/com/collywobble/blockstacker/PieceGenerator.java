package com.collywobble.blockstacker;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class PieceGenerator extends Actor {
    Tetromino newPiece;
    GameBoard gameBoard;

    public PieceGenerator(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void rotatePiece() {}

    public void movePieceLeft() {}

    public void movePieceRight() {}

    public void makePiece() {}
}
