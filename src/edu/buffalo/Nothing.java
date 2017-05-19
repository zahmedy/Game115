package edu.buffalo;

import edu.buffalo.GameObject;
import edu.buffalo.creatures.Creature;

import javax.swing.*;

public class Nothing extends GameObject{



    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon(new byte[0]);
    }

    @Override
    public boolean passable(){
        return true;
    }

    @Override
    public void encounterCreature(Creature creature){

    }

}
