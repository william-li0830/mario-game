import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends Platform
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
        int pipeHeight = getImage().getHeight();
        int yDistance = pipeHeight / 2 + 1;
        Actor mario = getOneObjectAtOffset(0,-yDistance,Mario.class);
        if(mario!= null && (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))) 
        {  
            LevelManager.advanceLevel();
            Greenfoot.playSound("Pipe.mp3");
        }
    }
}
