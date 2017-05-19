package edu.buffalo;

import edu.buffalo.creatures.*;
import edu.buffalo.tiles.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Defines the game board as a grid of tiles and stores the locations of all game objects on the board
 */
public class GameBoard{

    public static final int ROWS = 20;
    public static final int COLUMNS = 30;
    public static final double WALL_PERCENTAGE = 0.25;
    public static final double LAVA_PERCENTAGE = 0.05;
    public static final int TILE_SIZE = 32;

    private List<Tile> tiles;
    private Map<GameObject, Location> objectLocations;

    private JPanel gamePanel;
    private JPanel hudPanel;
    private JLabel hudLabel;


    public GameBoard(){
        init();
    }


    /**
     * Generate tiles and construct the game board
     */
    private void init(){
        this.tiles = new ArrayList<>();
        this.objectLocations = new LinkedHashMap<>();

        this.gamePanel = new JPanel();
        this.gamePanel.setBackground(Color.BLACK);
        this.gamePanel.setLayout(new GridLayout(GameBoard.ROWS, GameBoard.COLUMNS));

        for(int i = 0; i < GameBoard.ROWS; i++){
            for(int j = 0; j < GameBoard.COLUMNS; j++){
                Tile tile;
                double randomNumber = Math.random();
                if(randomNumber < GameBoard.WALL_PERCENTAGE){
                    tile = new WallTile();
                }else if(randomNumber < GameBoard.LAVA_PERCENTAGE + GameBoard.WALL_PERCENTAGE){
                    tile = new LavaTile();
                }else{
                    tile = new FloorTile();
                }
                this.tiles.add(tile);
                this.gamePanel.add(tile.getLabel());
            }
        }

        initHUD();
    }


    /**
     * Setup the HUD (Heads Up Display)
     */
    private void initHUD(){
        this.hudPanel = new JPanel();
        this.hudLabel = new JLabel("default");
        this.hudPanel.add(this.hudLabel);
    }


    /**
     * Adds a GameObject to the board and the specified Location. Does not add object to impassable tiles.
     *
     * @param object   the object to be added
     * @param location the desired location of the object
     * @return true if the object was successfully added, false otherwise
     */
    public boolean addObject(GameObject object, Location location){
        if(getTile(location).passable()){
            this.objectLocations.put(object, location);
            getTile(location).setContent(object);
            return true;
        }else{
            return false;
        }
    }


    /**
     * Removes an object form the board
     *
     * @param object the object to be removed
     */
    public void removeObject(Creature object){
        if(!this.objectLocations.containsKey(object)){
            System.out.println("Creature not found");
        }else{
            Location location = this.objectLocations.get(object);
            getTile(location).setContent(new Nothing());
            this.objectLocations.remove(object);
        }

    }


    /**
     * Moves a creature on the board and triggers the destination tile to encounter a creature
     *
     * @param creature    the creature to be moved
     * @param newLocation the intended location of the creature
     */
    public void moveCreature(Creature creature, Location newLocation){
        if(!this.objectLocations.containsKey(creature)){
            return;
        }
        if(!this.onBoard(newLocation)){
            return;
        }

        Tile currentTile = getTile(this.objectLocations.get(creature));
        Tile possibleTile = getTile(newLocation);

        possibleTile.encounterCreature(creature);

        if(possibleTile.passable()){
            currentTile.setContent(new Nothing());
            possibleTile.setContent(creature);
            this.objectLocations.put(creature, newLocation);
        }

    }


    /**
     * Gets the location of a particular object
     *
     * @param object the object to find
     * @return the location of the object, or (-1, -1) if the object is not found
     */
    public Location getObjectLocation(GameObject object){
        if(!this.objectLocations.containsKey(object)){
//            System.out.println("Creature not found");
            return new Location(-1, -1);
        }else{
            return this.objectLocations.get(object);
        }
    }


    public Player getPlayer(){
        for(GameObject object : this.objectLocations.keySet()){
            if(object instanceof Player){
                return (Player) object;
            }
        }
        return null;
    }

    public Map<GameObject, Location> getObjectsAndLocations(){
        return this.objectLocations;
    }

    /**
     * Updates the HUD text based on the state of the player
     *
     * @param player the player of the game
     */
    public void updateHUD(Player player){
        if(player.collapsed()){
            this.hudLabel.setText("GAME OVER");
        }else{
            this.hudLabel.setText("Health: " + player.getHealth() + "/" + player.getMaxHealth() +
                    "  |  " + "Gold: " + player.getGold());
        }
    }


    /**
     * Gets a random location on the board
     *
     * @return a random location
     */
    public Location randomLocation(){
        return new Location((int) (Math.random() * COLUMNS), (int) (Math.random() * ROWS));
    }


    /**
     * Gets a random location that is passable. Caution: This method will loop infinitely if there are no passable tiles
     *
     * @return a random passable location
     */
    public Location randomPassableLocation(){
        Location location = null;
        while(location == null || !getTile(location).passable()){
            location = randomLocation();
        }
        return location;
    }


    /**
     * Gets the game panel containing the display for the game board
     *
     * @return the game panel
     */
    public JPanel getGamePanel(){
        return this.gamePanel;
    }


    /**
     * Get the HUD panel containing the HUD label
     *
     * @return the HUD panel
     */
    public JPanel getHUDPanel(){
        return this.hudPanel;
    }


    /***
     * private methods
     ***/

    private boolean onBoard(Location location){
        return !(location.getX() < 0 || location.getX() >= GameBoard.COLUMNS ||
                location.getY() < 0 || location.getY() >= GameBoard.ROWS);
    }

    private int getTileNumber(Location location){
        return COLUMNS * location.getY() + location.getX();
    }

    private Tile getTile(Location location){
        return this.tiles.get(getTileNumber(location));
    }


}
