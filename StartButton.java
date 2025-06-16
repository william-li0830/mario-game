import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Starts the game when clicked
 */

public class StartButton extends Actor
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StartButton()
    {
        getImage().scale(150, 75);
    }

    public void act()
    {
        if(Greenfoot.mousePressed(this))
        {
            // Let LevelManager starts the game and sets the world
            LevelManager.startGame();
        }
    }
}
