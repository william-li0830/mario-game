import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 5 of the game.
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

        Text levelText = new Text("LEVEL 5", Color.WHITE, 23);
        addObject(levelText, 40,20);

        CoinBlocks(100, getHeight()/2, 3);
        StoneBlocks(300, getHeight()/3*2, 3);

        CoinBlocks(410, 120, 1);
        StoneBlocks(438, 120, 3);

        addObject(new Koopa(), 428,356);
        addObject(new Pipe(), 480, 90);

    }
}
