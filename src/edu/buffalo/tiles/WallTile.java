package edu.buffalo.tiles;

import javax.swing.*;

public class WallTile extends Tile{

    @Override
    public ImageIcon getImageIcon(){
        return new ImageIcon("assets/wall_vines1.png");
    }

    @Override
    public boolean passable(){
        return false;
    }


}
