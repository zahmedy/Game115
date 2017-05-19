package edu.buffalo.creatures.enemystates;

import edu.buffalo.GameBoard;
import edu.buffalo.Location;
import edu.buffalo.creatures.Creature;

/**
 * Enemies in the sleeping state do nothing
 */
public class Sleeping implements EnemyState{

    @Override
    public void takeTurn(Creature thisCreature, GameBoard gameBoard, Location location){}
}