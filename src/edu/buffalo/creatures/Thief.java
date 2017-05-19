package edu.buffalo.creatures;

import edu.buffalo.GameBoard;
import edu.buffalo.Location;
import edu.buffalo.creatures.enemystates.EnemyState;
import edu.buffalo.creatures.enemystates.RandomWalk;

import javax.swing.*;

public class Thief extends Creature{

    // Complete the Thief class using a structure similar to the Rat class with max hp of 3, attack
    // is 1, and the state is always RandomWalk

    private static final int THIEF_HP = 3;
    private static final int THIEF_ATTACK = 1;
    private EnemyState state;

    public Thief(){
        super(Thief.THIEF_HP);
        this.state = new RandomWalk();
    }

    @Override
    public void takeTurn(GameBoard gameBoard, Location location){
        this.state.takeTurn(this, gameBoard, location);
    }

    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon("assets/deformed_orc.png");
    }

    @Override
    public void encounterCreature(Creature creature){
        // When a Thief encounters a creature, remove 100 gold from that creature in addition to dealing
        // 1 damage to that creature
        creature.hurt(Thief.THIEF_ATTACK);
        creature.takeGold(100);
    }
}