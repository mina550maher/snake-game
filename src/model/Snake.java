package model;

import view.Board;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake implements Moveable {

    private List<Point> snakeBody;
    private SnakeHeadDirection headDirection;
    private Board board;

    public Snake() {
        this(new ArrayList<>(), SnakeHeadDirection.RIGHT);
        snakeBody.add(new Point(0, 0));
    }

    public Snake(List<Point> snakeBody, SnakeHeadDirection headDirection) {
        this.snakeBody = snakeBody;
        this.headDirection = headDirection;
    }

    @Override
    public void move() {
        moveBody();
        switch (getHeadDirection()) {
            case UP ->
                    snakeBody.getFirst().y = snakeBody.getFirst().y <= 0 ? board.getNoRows() : snakeBody.getFirst().y - 1;
            case DOWN ->
                    snakeBody.getFirst().y = snakeBody.getFirst().y == board.getNoRows() ? 0 : snakeBody.getFirst().y + 1;
            case LEFT ->
                    snakeBody.getFirst().x = snakeBody.getFirst().x == 0 ? board.getNoCols() : snakeBody.getFirst().x - 1;
            case RIGHT ->
                    snakeBody.getFirst().x = snakeBody.getFirst().x == board.getNoCols() ? 0 : snakeBody.getFirst().x + 1;
        }
    }

    private void moveBody() {
        for (int i = snakeBody.size() - 1; i > 0; --i) {
            snakeBody.get(i).y = snakeBody.get(i - 1).y;
            snakeBody.get(i).x = snakeBody.get(i - 1).x;
        }
    }


    public boolean isEatingHerSelf() {
        for (int i = 1; i < snakeBody.size(); ++i) {
            if (snakeBody.get(i).equals(snakeBody.getFirst())) {
                return true;
            }
        }
        return false;
    }

    public boolean canEat() {
        if (board.getApple().getPos().equals(snakeBody.getFirst())) {
            snakeBody.addLast(new Point(snakeBody.getLast()));
            return true;
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    public synchronized List<Point> getSnakeBody() {
        return snakeBody;
    }

    public synchronized void setSnakeBody(List<Point> snakeBody) {
        this.snakeBody = snakeBody;
    }

    public synchronized SnakeHeadDirection getHeadDirection() {
        return headDirection;
    }

    public synchronized void setHeadDirection(SnakeHeadDirection headDirection) {
        this.headDirection = headDirection;
    }
}
