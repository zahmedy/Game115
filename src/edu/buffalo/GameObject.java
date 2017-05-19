package edu.buffalo;

import edu.buffalo.creatures.Creature;

import javax.swing.*;
import java.awt.*;

/**
 * A generic object that can be placed on the game grid
 */
public abstract class GameObject{

    protected JLabel label;


    public GameObject(){
        this.label = new JLabel(this.getImageIcon());
        this.label.setLayout(new BorderLayout());
    }

    /**
     * Gets the JLabel containing the object's sprite
     * @return this objects sprite
     */
    public JLabel getLabel(){
        return this.label;
    }

    /**
     * Returns the sprite for the object as a an ImageIcon
     * @return the object's sprite
     */
    public abstract ImageIcon getImageIcon();

    /**
     * Determines if the object can be passed through by a creature or not. For example, well should return false
     * @return true if the object is passable, false otherwise
     */
    public abstract boolean passable();

    /**
     * Called when a creature encounters this GameObject
     * @param creature the creature being encountered
     */
    public abstract void encounterCreature(Creature creature);
}
