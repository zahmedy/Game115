package edu.buffalo.tiles;

import edu.buffalo.creatures.Creature;
import edu.buffalo.GameObject;
import edu.buffalo.Nothing;

public abstract class Tile extends GameObject{

    protected GameObject content;

    public Tile(){
        super();
        setContent(new Nothing());
    }

    /**
     * Add a game object to the tile. A tile can only hold 1 object and this method will replace any previous object
     * on the tile
     * @param content the game object to be added to this tile
     */
    public void setContent(GameObject content){
        this.content = content;
        this.label.removeAll();
        this.label.add(this.content.getLabel());
        this.label.repaint();
    }


    @Override
    public void encounterCreature(Creature creature){
        this.content.encounterCreature(creature);
        if(this.content instanceof Creature){
            creature.encounterCreature((Creature) content);
        }
    }

}
