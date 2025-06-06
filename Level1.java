import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Level
{
    /**
     * Constructor for objects of class Level1.
     * 
     */  
    public Level1(Mario mario)
    {
        super(mario);
        Text levelText = new Text("LEVEL 1", Color.WHITE, 23);
        addObject(levelText, 40,20);

        CoinBlocks(100, getHeight()/2, 3);
        CoinBlocks(300, getHeight()/3*2, 2);
        CoinBlocks(500, getHeight()/5*3, 3);

        addObject(new Goomba(), 100, 370);
        addObject(new Koopa(), 428,356);

        addObject(new Bush(),200,370);

        addObject(new Pipe(), 594, 360);

    }
}
