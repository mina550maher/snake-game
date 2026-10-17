package view;

import model.Apple;
import model.Snake;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private final Image boardBgImg = new ImageIcon("resource/images/board-bg.jpg").getImage();

    private Dimension cellDimension;
    private Apple apple;
    private Snake snake;

    public Image getBoardBgImg() {
        return boardBgImg;
    }

    public Dimension getCellDimension() {
        return cellDimension;
    }

    public void setCellDimension(Dimension cellDimension) {
        this.cellDimension = cellDimension;
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

    public int getNoCols() {
        return this.getWidth() / (int) cellDimension.getWidth() - 1;
    }

    public int getNoRows() {
        return this.getHeight() / (int) cellDimension.getHeight() - 1;
    }


    private void drawImg(Image img, int x, int y, Graphics g) {
        g.drawImage(img, x * (int) cellDimension.getWidth(), y * (int) cellDimension.getHeight(), this);
    }

    private void drawImg(Image img, Point p, Graphics g) {
        drawImg(img, p.x, p.y, g);
    }

    private void drawApple(Graphics g) {
        drawImg(apple.getAppleImg(), apple.getPos().x, apple.getPos().y, g);
    }


    private void drawVerticalLines(Graphics g) {
        final int cellWidth = (int) cellDimension.getWidth();
        for (int i = cellWidth, w = this.getWidth(), h = this.getHeight(); i <= w; i += cellWidth) {
            g.drawLine(i, 0, i, h);
        }
    }

    private void drawHorizontalLines(Graphics g) {
        final int cellHeight = (int) cellDimension.getHeight();
        for (int i = cellHeight, w = this.getWidth(), h = this.getHeight(); i <= h; i += cellHeight) {
            g.drawLine(0, i, w, i);
        }
    }


    private void fillCell(int x, int y, Graphics g) {
        final int cellHeight = (int) cellDimension.getHeight(), cellWidth = (int) cellDimension.getWidth();
        g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
    }

    private void fillCell(Point p, Graphics g) {
        fillCell(p.x, p.y, g);
    }

    private void drawSnake(Graphics g) {

        g.setColor(Color.BLUE);
        for (int i = snake.getSnakeBody().size() - 1; i > 0; --i) {
            fillCell(snake.getSnakeBody().get(i), g);
        }

        g.setColor(Color.RED);
        fillCell(snake.getSnakeBody().getFirst(), g);

        g.setColor(Color.BLACK);
    }

    private void drawBackgroundImage(Graphics g) {
        g.drawImage(boardBgImg, 0, 0, getWidth(), getHeight(), this);
    }

    private void drawBoard(Graphics g) {
        drawBackgroundImage(g);
        drawVerticalLines(g);
        drawHorizontalLines(g);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawApple(g);
        drawSnake(g);
    }

}