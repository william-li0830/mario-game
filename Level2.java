import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Level
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {
        super();
        CoinBlocks(100, getHeight()/2);
        CoinBlocks(300, getHeight()/3*2);
        addObject(new Koopa(), 428,356);
    }
}
