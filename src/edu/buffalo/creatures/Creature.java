package edu.buffalo.creatures;

import edu.buffalo.GameBoard;
import edu.buffalo.GameObject;
import edu.buffalo.Location;

/**
 * Anything that moves
 */
public abstract class Creature extends GameObject{

    protected int health;
    protected int maxHealth;
    protected int gold;

    public Creature(int maxHealth){
        super();
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.gold= 0;
    }


    public void hurt(int damage){
        health -= damage;
    }

    public void heal(int heal){
        health += heal;
        if(health > maxHealth){
            health = maxHealth;
        }
    }

    public boolean collapsed(){
        return health <= 0;
    }

    public int getHealth(){
        return health;
    }


    public int getMaxHealth(){
        return maxHealth;
    }


    public abstract void takeTurn(GameBoard gameBoard, Location location);


    public int getGold(){
        return gold;
    }
    public void addGold(int amount){
        gold += amount;
    }
    public void takeGold(int amount){
        addGold(-amount);
    }

    @Override
    public boolean passable(){
        return false;
    }
}
