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

        Text levelText = new Text("LEVEL 2", Color.WHITE, 23);
        addObject(levelText, 40,20);

        StoneBlocks(100, getHeight()/2, 3);
        CoinBlocks(300, getHeight()/3*2, 3);
        CoinBlocks(500, getHeight()/5*3, 1);

        addObject(new Goomba(), 100, 370);

        addObject(new Pipe(), 594, 360);

    }
}
