package edu.buffalo.creatures.enemystates;

import edu.buffalo.GameBoard;
import edu.buffalo.Location;
import edu.buffalo.creatures.Creature;

public class Hunting implements EnemyState{

    // Implement the Hunting state to always attempt to move closer to the target creature. This can
    // be done using only distance calculations based on the position of the creatures
    // (ie. you don't have to move around walls which would be a much more difficult question task)

    private Creature prey;

    public Hunting(Creature creatureToHunt){
        this.prey = creatureToHunt;
    }

    @Override
    public void takeTurn(Creature thisCreature, GameBoard gameBoard, Location location){
        Location preyLocation = gameBoard.getObjectLocation(this.prey);
        int dx = location.getX() - preyLocation.getX();
        int dy = location.getY() - preyLocation.getY();

        double random = Math.random();
        if(dy == 0 || (dx != 0 && random < 0.5)){
            gameBoard.moveCreature(thisCreature, location.translated(dx < 0 ? 1 : -1, 0));
        }else{
            gameBoard.moveCreature(thisCreature, location.translated(0, dy < 0 ? 1 : -1));
        }
    }
}
