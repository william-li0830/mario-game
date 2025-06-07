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

        // My sister designed this level
        StoneBlocks(100, 300, 2);
        CoinBlocks(100 + BLOCK_SIZE*2, 300, 1);
        StoneBlocks(100 + BLOCK_SIZE*3, 300, 1);

        Blocks(230, 240, 2);
        CoinBlocks(230 + BLOCK_SIZE*2, 240, 1);

        StoneBlocks(350, 180, 6);

        CoinBlocks(390, 112, 1);
        Blocks(390 + BLOCK_SIZE, 112, 2);
        
        addObject(new Pipe(), 420, 80);

        addObject(new Goomba(), 100, 370);


    }
}
