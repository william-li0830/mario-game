import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 4 of the game.
 */
public class Level4 extends Level
{
    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4(Mario mario)
    {
        super(mario);
        
        Text levelText = new Text("LEVEL 4", Color.WHITE, 23);
        addObject(levelText, 40,20);

        CoinBlocks(100, getHeight()/2, 3);
        CoinBlocks(300, getHeight()/3*2, 3);
        StoneBlocks(500, getHeight()/5*3, 3);

        addObject(new Goomba(), 100, 370);
        addObject(new Koopa(), 428,356);

        addObject(new Pipe(), 500, 210);
    }
}
