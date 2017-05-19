package edu.buffalo.tiles;

import edu.buffalo.creatures.Creature;

import javax.swing.*;

public class LavaTile extends Tile{

    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon("assets/lava2.png");
    }

    @Override
    public boolean passable(){
        return this.content.passable();
    }

    @Override
    public void encounterCreature(Creature creature){
        // Damage tile. Any creature encountering lava will take 1 damage
        creature.hurt(1);

        // Continue with the default behavior
        super.encounterCreature(creature);
    }
}
