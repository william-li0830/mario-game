import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Coin that pops up and falls back down due to gravity.
 * Disappears after returning to its original position.
 */

public class Coin extends Actor {
    // I added the coin to the game(before it was just and image in the project folder not being used)

    private int speed = -8;
    private int gravity = 1;
    private int originalY;

    // Stores original Y position when added to the world
    protected void addedToWorld(World world) {
        originalY = getY(); 
    }

    // Moves the coin and removes it after it falls back down
    public void act() {
        setLocation(getX(), getY() + speed);
        speed += gravity;

        if (getY() >= originalY) {
            getWorld().removeObject(this);
        }
    }
}

