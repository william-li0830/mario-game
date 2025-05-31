import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends Level
{
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {
         super();
         
        addFloor();
        Mario mario = new Mario();
        
        addObject(mario,235,356);


        addObject(new Timer(), 300,20);
        
        StoneBlocks(100, getHeight()/2);
        CoinBlocks(300, getHeight()/3*2);
        
        addObject(new Goomba(), 428,356);
        // TODO: addObject(new Paratroopa(),400,356);
        
        //addObject(new Bush(), 300, 470);
        
        addObject(new Pipe(), 600, 500);
    }
}
