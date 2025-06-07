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
    public Level2(Mario mario)
    {
        super(mario);
        
        Text levelText = new Text("Level 2", Color.WHITE, 23);
        addObject(levelText, 40,20);
        
        CoinBlocks(100, getHeight()/2);
        StoneBlocks(300, getHeight()/3*2);

        addObject(new Koopa(), 428,356);

        addObject(new Pipe(), 600, 500);

    }
}
