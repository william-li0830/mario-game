import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Pipe platform that Mario can enter to advance to the next level.
 */
public class Pipe extends Platform
{ 
    // I used the pipe so Mario can teleport to the next level(before there was no pipe in the game but I took advantage of the pipe image in this project folder)
    public void act()
    {
        topChecker();
    }

    // Checks if Mario is standing on top of the pipe.
    private void topChecker()
    {
        int pipeHeight = getImage().getHeight();
        int yDistance = pipeHeight / 2 + 1;
        Actor mario = getOneObjectAtOffset(0,-yDistance,Mario.class);
        if(mario!= null && (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))) // Mario goes down the pipe to next the level
        {  
            LevelManager.advanceLevel();
            Greenfoot.playSound("Pipe.mp3");
        }
    }
}
