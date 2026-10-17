package controller;

import model.Snake;
import model.SnakeHeadDirection;
import view.Game;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController {

    private Game game;

    public void start() {
        SwingUtilities.invokeLater(() -> {
            game = new Game();
            registerListeners();
            game.setVisible(true);
            new Timer(game.getGameDelay(), (_) -> game.tick()).start();
        });
    }


    private void registerListeners() {
        game.addComponentListener(new GameWindowAction());
        game.addKeyListener(new MovementKeyAction());
        game.addKeyListener(new MovementKeyAction());
    }

    private class MovementKeyAction extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            final Snake snake = game.getSnake();
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                snake.setHeadDirection(SnakeHeadDirection.UP);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                snake.setHeadDirection(SnakeHeadDirection.DOWN);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                snake.setHeadDirection(SnakeHeadDirection.LEFT);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                snake.setHeadDirection(SnakeHeadDirection.RIGHT);
            }
        }
    }

    private class GameWindowAction extends ComponentAdapter {
        @Override
        public void componentResized(ComponentEvent e) {
            game.getBoard().setSize(e.getComponent().getWidth(), e.getComponent().getHeight());
            game.getBoard().repaint();
        }
    }

}
