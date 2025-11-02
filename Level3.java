import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level 3 of the game.
 */
public class Level3 extends Level
{
    public Level3(Mario mario)
    {
        super(mario);

        Text levelText = new Text("LEVEL 3", Color.WHITE, 23);
        addObject(levelText, 40,20);

        StoneBlocks(450, 180, 3);
        CoinBlocks(300, getHeight()/3*2, 2);

        addObject(new Goomba(), 428,356);

        addObject(new Bush(), 200,370);

        addObject(new Pipe(), 450, 149);
    }
}
