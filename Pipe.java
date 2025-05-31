import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends Actor
{ 
    
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        topChecker();
    }
    
    private void topChecker()
    {
        // Information about Mario's dimensions to process collisions
        int pipeHeight = getImage().getHeight();
        int yDistance = pipeHeight / 2 + 1;
        Actor mario = getOneObjectAtOffset(0,-yDistance,Mario.class);
        if(mario!= null && Greenfoot.isKeyDown("down") ) 
        {  
            advanceLevel();
            Greenfoot.playSound("Pipe.mp3");
        }
}

 private void advanceLevel()
    {
    if (LevelManager.currentLevel == 1) {
        LevelManager.currentLevel++;
        Greenfoot.setWorld(new Level2());
    } else if (LevelManager.currentLevel == 2) {
        LevelManager.currentLevel++;
        Greenfoot.setWorld(new Level3());
    } else if (LevelManager.currentLevel == 3) {
        LevelManager.currentLevel++;
        Greenfoot.setWorld(new Level4());
    } else if (LevelManager.currentLevel == 4) {
        LevelManager.currentLevel++;
        Greenfoot.setWorld(new FinalLevel());
    } else {
        Greenfoot.setWorld(new EndScreen());
    }
    LevelManager.currentLevel++; 
    }
}
