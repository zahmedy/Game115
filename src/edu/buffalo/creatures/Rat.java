package edu.buffalo.creatures;

import edu.buffalo.GameBoard;
import edu.buffalo.Location;
import edu.buffalo.creatures.enemystates.EnemyState;
import edu.buffalo.creatures.enemystates.RandomWalk;
import edu.buffalo.creatures.enemystates.Sleeping;

import javax.swing.*;

public class Rat extends Creature{

    private static final int RAT_HP = 1;
    private static final int RAT_ATTACK = 1;
    private int numberOfTurns = 0;
    private EnemyState state;

    public Rat(){
        super(Rat.RAT_HP);

        // Set the default state of a Rat to sleeping by setting its state to a new instance of Sleeping
        // that is used in the rat's takeTurn method to define its current behavior
        this.state = new Sleeping();

    }

    @Override
    public void takeTurn(GameBoard gameBoard, Location location){
        // After a rat takes 5 turns it should "wake up" and start randomly walking by setting its state to a
        // a new instance of RandomWalk
        this.numberOfTurns++;
        if(this.numberOfTurns == 5){
            this.state = new RandomWalk();
        }
        this.state.takeTurn(this, gameBoard, location);
    }

    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon("assets/grey_rat.png");
    }

    @Override
    public void encounterCreature(Creature creature){
        // Implement Rat's encounterCreature method to deal 1 damage to the creature (you can call the creature's
        // hurt method to deal damage)
        creature.hurt(Rat.RAT_ATTACK);
    }
}