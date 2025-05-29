import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelManager extends Actor
{

    private int currentLevel = 1;
    
    public LevelManager() {
    }
    public void act()
    {
        if (shouldAdvance()) {
            advanceLevel();
        }
    }

    private boolean shouldAdvance()
    {
        return false; //TODO
    }

    private void advanceLevel()
    {
        if (currentLevel == 1) {
            Greenfoot.setWorld(new Level2());
        } else if (currentLevel == 2) {
            //Greenfoot.setWorld(new Level3());
        }
        currentLevel++;
    }
}
