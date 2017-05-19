package edu.buffalo;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void start(){
        JFrame frame = new JFrame("A Game!");

        // Initialize the game
        GameBoard board = new GameBoard();
        GameController gameController = new GameController(board);

        // Add the game controller to the frame as a KeyListener to allow keyboard inputs to be read
        frame.addKeyListener(gameController);

        // Add the HUD to the frame
        frame.getContentPane().add(board.getHUDPanel(), BorderLayout.NORTH);

        // Add the game board ot the frame
        JPanel panel = new JPanel();
        panel.add(board.getGamePanel());
        panel.setBackground(Color.BLACK);
        frame.getContentPane().add(panel, BorderLayout.CENTER);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Resize the frame and display it
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                start();
            }
        });
    }

}
