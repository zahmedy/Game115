package edu.buffalo.creatures.enemystates;

import edu.buffalo.GameBoard;
import edu.buffalo.Location;
import edu.buffalo.creatures.Creature;

/**
 * Defines the current behavior of an enemy when it's their turn to move
 */
public interface EnemyState{

    /**
     * Takes a creatures turn
     *
     * @param thisCreature the creature who's turn it is to move
     * @param gameBoard    the board for the current game
     * @param location     the location of thisCreature on the game board
     */
    void takeTurn(Creature thisCreature, GameBoard gameBoard, Location location);

}