package edu.buffalo.creatures;

import edu.buffalo.GameBoard;
import edu.buffalo.Location;
import edu.buffalo.creatures.enemystates.EnemyState;
import edu.buffalo.creatures.enemystates.Hunting;
import edu.buffalo.creatures.enemystates.Sleeping;

import javax.swing.*;
public class IceDragon extends Creature{

    // Implement the IceDragon to have a max hp of 5, attack of 2, initial state of sleeping, and the
    // state changes to hunting a creature whenever a creature is encountered

    private static final int ICE_DRAGON_HP = 5;
    private static final int ICE_DRAGON_ATTACK = 2;
    private EnemyState state;

    public IceDragon(){
        super(IceDragon.ICE_DRAGON_HP);
        this.state = new Sleeping();
    }

    @Override
    public void takeTurn(GameBoard gameBoard, Location location){
        this.state.takeTurn(this, gameBoard, location);
    }

    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon("assets/ice_dragon.png");
    }

    @Override
    public void encounterCreature(Creature creature){
        creature.hurt(IceDragon.ICE_DRAGON_ATTACK);
        this.state = new Hunting(creature);
    }
}