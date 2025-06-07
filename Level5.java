import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5 extends Level
{
    /**
     * Constructor for objects of class Level5.
     * 
     */
    public Level5(Mario mario)
    {
        super(mario);

        Text levelText = new Text("Level 5", Color.WHITE, 23);
        addObject(levelText, 40,20);

        StoneBlocks(100, getHeight()/2);
        CoinBlocks(300, getHeight()/3*2);
        CoinBlocks(500, getHeight()/5*3);

        addObject(new Goomba(), 100, 370);

        addObject(new Pipe(), 600, 500);
    }
}
