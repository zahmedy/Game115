package edu.buffalo;

import edu.buffalo.creatures.*;
import edu.buffalo.items.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Controls the game logic including user inputs and movement as well as creating and
 * placing enemies, items, and the player. Implements KeyListener to handle keyboard inputs
 */
public class GameController implements KeyListener{

    private GameBoard board;
    private Player player;
    private ArrayList<Creature> monsters;

    /**
     * Initializes the game by adding all the game objects to the board
     */
    public GameController(GameBoard board){
        this.board = board;
        init();
    }


    private void init(){
        this.monsters = new ArrayList<>();
        this.addItems(20);
        this.addEnemies(10);
        this.player = new Player();
        this.board.addObject(this.player, this.board.randomPassableLocation());
        this.board.updateHUD(this.player);
    }

    private void addEnemies(int numberOfCreatures){
        for(int i = 0; i < numberOfCreatures; i++){
            double random = Math.random();
            Creature enemy;
            if(random < 0.7){
                enemy = new Rat();
            }else{
                enemy = new Thief();
            }
            while(!this.board.addObject(enemy, this.board.randomPassableLocation()));
            this.monsters.add(enemy);
        }

        // 1 Ice Dragon
        Creature iceDragon = new IceDragon();
        while(!this.board.addObject(iceDragon, this.board.randomPassableLocation()));
        this.monsters.add(iceDragon);
    }

    private void addItems(int numberOfItems){
        for(int i = 0; i < numberOfItems; i++){
            Item item;
            if(Math.random() < 0.5){
                item = new Potion();
            }else{
                item = new Gold(100*(((int) (Math.random()*10)) + 1));
            }
            while(!this.board.addObject(item, this.board.randomPassableLocation()));
        }
    }


    private void takePlayerTurn(int dx, int dy){
        if(!this.player.collapsed()){
            Location currentLocation = this.board.getObjectLocation(player);
            this.board.moveCreature(this.player, currentLocation.translated(dx, dy));
        }

        for(Creature monster : this.monsters){
            if(!monster.collapsed()){
                monster.takeTurn(this.board, this.board.getObjectLocation(monster));
            }
        }

        this.update();
        this.board.updateHUD(this.player);
    }

    private void update(){
        List<Creature> toRemove = new ArrayList<>();
        for(Creature monster : this.monsters){
            if(monster.collapsed()){
                toRemove.add(monster);
                this.board.removeObject(monster);
            }
        }
        this.monsters.removeAll(toRemove);
    }

    @Override
    public void keyTyped(KeyEvent e){
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W){
            this.takePlayerTurn(0, -1);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            this.takePlayerTurn(0, 1);
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            this.takePlayerTurn(-1, 0);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            this.takePlayerTurn(1, 0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e){

    }


}
