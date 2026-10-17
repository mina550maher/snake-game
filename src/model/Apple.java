package model;

import util.IntRandomGen;
import view.Board;

import javax.swing.*;
import java.awt.*;

public class Apple {
    private Image appleImg;
    private Point pos;
    private Board board;


    public void setRandomPos() {
        if (pos == null) pos = new Point();
        pos.x = IntRandomGen.next(board.getNoCols() - 1);
        pos.y = IntRandomGen.next(board.getNoRows() - 1);
    }

    public Image getAppleImg() {
        return appleImg;
    }

    public void setAppleImg(Image appleImg) {
        this.appleImg = appleImg;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
