import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Adds intial objects to the game.
 * @author (William Li) 
 * @version (05/16/25)
 */
public class MyWorld extends greenfoot.World
{
    private Scoreboard scoreboard;
    private Mario mario;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("MarioBackground.png");
        bg.scale(600, 400);
        setBackground(bg);
        prepare();
    }

    public void act()
    {
        checkTimer();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Mario(),235,356);

        scoreboard = new Scoreboard(0);
        addObject(scoreboard, getWidth() - 70, 20);

        addFloor();

        addObject(new Timer(), 300,50);

        //addObject(new Bush(), 400,50);
        //addObject(new Bush(), 400,40);
        //addObject(new Bush(), 400,30);

        //addObject(new Pipe(), 400,50);
        //addObject(new Pipe(), 400,50);
        //addObject(new Pipe(), 400,50);

        CoinBlocks(100, getHeight()/2);
        CoinBlocks(300, getHeight()/3*2);
        CoinBlocks(500, getHeight()/5*3);

        HealthHearts(20,20);

        // addObject(new Goomba(), 300,350);
        addObject(new Koopa(), 428,356);
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
    public void CoinBlocks(int xStart, int yStart)
    {
        CoinBlock coinBlock = new CoinBlock();
        int blockWidth = coinBlock.getImage().getWidth();
        for(int i = 0; i < 3; i++)
        {
            addObject(new CoinBlock(), xStart+(i*blockWidth), yStart);
        }
    }

    // adds StoneBlocks in clumps of 3 
    public void StoneBlocks(int xStart, int yStart)
    {
        StoneBlock stoneBlock = new StoneBlock();
        int blockWidth = stoneBlock.getImage().getWidth();
        for(int i = 0; i < 3; i++)
        {
            addObject(new StoneBlock(), xStart+(i*blockWidth), yStart);
        }
    }

    public void HealthHearts(int xStart, int yStart)
    {  
        HealthHeart healthHeart = new HealthHeart();
        int heartWidth = healthHeart.getImage().getWidth() + 2;
        for(int i = 0; i < 4; i++) 
        {
            addObject(new HealthHeart(), xStart+(i*heartWidth),yStart);
        }
    }

    private void checkTimer() {
        if (!getObjects(Timer.class).isEmpty()) {
            Timer t = (Timer) getObjects(Timer.class).get(0);
            if (t.getTimeLeft() == 0) {
                showText("TIME'S UP!", getWidth() / 2, getHeight() / 2);
            }
        }
    }

    private void GameOver() 
    {
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;

        removeObject(mario);

        Greenfoot.playSound("GAMEOVER.wav");

        //GreenfootImage gameover = new GreenfootImage("GameOver.png");
        //addObject(gameover,centerX, centerY);

        //or

        Text gameoverText = new Text("GAME OVER", Color.RED, 100);
        addObject(gameoverText,centerX, centerY);

        addObject(new RestartButton(), centerX, centerY + 85);

        Text scoreText = new Text("Score: " + scoreboard.getScore(), Color.BLACK,70);
        addObject(scoreText,centerX, centerY - 80);

    }

    public void restartGame() 
    {
        Greenfoot.setWorld(new MyWorld()); // Restarts the game
    }

    public Scoreboard getScoreboard()
    {
        return scoreboard;
    }
}
