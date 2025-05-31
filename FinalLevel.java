import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalLevel extends Level
{
    /**
     * Constructor for objects of class Level5.
     * 
     */
    public FinalLevel()
    {
         super();
        
        addFloor();
        
        Mario mario = new Mario();
        
        addObject(mario,235,356);


        addObject(new Timer(), 300,20);

        StoneBlocks(100, getHeight()/2);
        CoinBlocks(300, getHeight()/3*2);
    CoinBlocks(500, getHeight()/5*3);

        addObject(new Goomba(), 100, 370);
        
        
        addObject(new Pipe(), 600, 500);
    }
}
