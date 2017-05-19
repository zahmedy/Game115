package edu.buffalo.tiles;

import javax.swing.*;

public class FloorTile extends Tile{

    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon("assets/grey_dirt1.png");
    }

    @Override
    public boolean passable(){
        return this.content.passable();
    }



}
