package edu.buffalo.creatures;

import edu.buffalo.GameBoard;
import edu.buffalo.Location;

import javax.swing.*;

public class Player extends Creature{

    private static final int MAX_PLAYER_HEALTH = 10;
    private int attackPower = 1;

    public Player(){
        super(MAX_PLAYER_HEALTH);
        this.gold = 1000;
    }

    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon("assets/daeva.png");
    }

    @Override
    public void encounterCreature(Creature creature){
        creature.hurt(attackPower);
    }

    @Override
    public void takeTurn(GameBoard gameBoard, Location location){
        // Player movement is controlled in GameController
    }
}
