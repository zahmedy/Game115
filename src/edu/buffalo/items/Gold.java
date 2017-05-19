package edu.buffalo.items;

import edu.buffalo.creatures.Creature;

import javax.swing.ImageIcon;


public class Gold extends Item{

    private int amount;

    public Gold(int amount){
        super();
        this.amount = amount;
    }

    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon("assets/gold_pile.png");
    }

    @Override
    public void encounterCreature(Creature creature){
        creature.addGold(amount);
    }

}
