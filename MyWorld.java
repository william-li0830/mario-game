import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Mario mario = new Mario();
        addObject(mario,287,195);
        
        addFloor();
        
        tripleBlocks(100, getHeight()/2);
        tripleBlocks(300, getHeight()/3*2);
        tripleBlocks(500, getHeight()/5*3);
    }

    
    // This method auto-generated a floor for the entire level, no matter how long it is! Wohoo generalization :)
    public void addFloor()
    {
        Block block = new Block();
        int blockWidth = block.getImage().getWidth();
        int blockHeight = block.getImage().getHeight();
        int numBlocksFloor = getWidth() / blockWidth;
        
        for (int i = 0; i <= numBlocksFloor; ++i)
        {
            addObject(new Block(), i*blockWidth, getHeight() - blockHeight/2);
        }
    }
    
    // A modular method designed to add blocks in clumps of 3 whever requested
    public void tripleBlocks(int xStart, int yStart)
    {
        CoinBlock cb = new CoinBlock();
        int blockWidth = cb.getImage().getWidth();
        for(int a = 0; a < 3; a++)
        {
            addObject(new CoinBlock(), xStart+(a*blockWidth), yStart);
        }
    }
}
