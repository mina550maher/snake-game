package view;

import model.Apple;
import model.Snake;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private Board board;
    private Apple apple;
    private Snake snake;
    private int gameDelay = 100;

    {
        this.setTitle("Snake Game");
        super.setIconImage(new ImageIcon("resource/images/snake.png").getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(420, 420);
        super.setLocationRelativeTo(null);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    public Game() {
        board = new Board();
        board.setSize(this.getSize());
        board.setCellDimension(new Dimension(20, 20));

        apple = new Apple();
        apple.setBoard(board);
        apple.setAppleImg(new ImageIcon("resource/images/apple.png").getImage());
        apple.setRandomPos();

        snake = new Snake();
        snake.setBoard(board);

        board.setApple(apple);
        board.setSnake(snake);

        this.getContentPane().add(board);
    }


    private void updateState() {
        snake.move();

        if (this.getSnake().isEatingHerSelf()) {
            JOptionPane.showMessageDialog(this, "The snake ate itself!", "Game Over", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        if (snake.canEat()) {
            apple.setRandomPos();
        }
    }

    public void tick() {
        updateState();
        board.repaint();
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getGameDelay() {
        return gameDelay;
    }

    public void setGameDelay(int gameDelay) {
        this.gameDelay = gameDelay;
    }
}
