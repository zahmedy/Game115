package edu.buffalo.items;

import edu.buffalo.GameObject;

public abstract class Item extends GameObject{

    @Override
    public boolean passable(){
        return true;
    }

}
