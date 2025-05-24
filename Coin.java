import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author(William Li)  
 * @version (a version number or a date)
 */

public class Coin extends Actor {
    private int speed = -8;
    private int gravity = 1;
    private int originalY;

    protected void addedToWorld(World world) {
        originalY = getY(); 
    }

    public void act() {
        setLocation(getX(), getY() + speed);
        speed += gravity;

        if (getY() >= originalY) {
            getWorld().removeObject(this);
        }
    }
}

