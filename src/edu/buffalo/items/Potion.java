package edu.buffalo.items;

import edu.buffalo.creatures.Creature;

import javax.swing.ImageIcon;


public class Potion extends Item{

    private static final int HEAL_AMOUNT = 3;

    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon("assets/ruby.png");
    }

    @Override
    public void encounterCreature(Creature creature){
//        System.out.println("potion");
        creature.heal(HEAL_AMOUNT);
    }

}
