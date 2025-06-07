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
    public Level3(Mario mario)
    {
        super(mario);
        
        Text levelText = new Text("LEVEL 3", Color.WHITE, 23);
        addObject(levelText, 40,20);

        StoneBlocks(100, getHeight()/2, 3);
        CoinBlocks(300, getHeight()/3*2, 2);

        addObject(new Goomba(), 428,356);
        // TODO: addObject(new Paratroopa(),400,356);

        addObject(new Bush(), 200,370);

        addObject(new Pipe(), 594, 360);
    }
}
