package edu.buffalo.creatures.enemystates;


import edu.buffalo.GameBoard;
import edu.buffalo.Location;
import edu.buffalo.creatures.Creature;

public class RandomWalk implements EnemyState{

    // Implement the RandomWalk state to move thisCreature either up, down, left, or right by 1 position.
    // Each of the 4 directions should have [close to] an equal probability of being chosen

    @Override
    public void takeTurn(Creature thisCreature, GameBoard gameBoard, Location location){
        double random = Math.random();
        if(random < 0.25){
            gameBoard.moveCreature(thisCreature, location.translated(0, 1));
        }else if(random < 0.5){
            gameBoard.moveCreature(thisCreature, location.translated(1, 0));
        }else if(random < 0.75){
            gameBoard.moveCreature(thisCreature, location.translated(0, -1));
        }else{
            gameBoard.moveCreature(thisCreature, location.translated(-1, 0));
        }
    }
}