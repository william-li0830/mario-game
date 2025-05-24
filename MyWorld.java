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
    private boolean gameOver;

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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        mario = new Mario();
        addObject(mario,235,356);
        HealthHearts(mario.getFullHealth(), 20,20);
        
        scoreboard = new Scoreboard(0);
        addObject(scoreboard, getWidth() - 70, 20);

        addFloor();

        addObject(new Timer(), 300,20);

        //addObject(new Bush(), 400,50);
        //addObject(new Bush(), 400,40);
        //addObject(new Bush(), 400,30);

        //addObject(new Pipe(), 400,50);
        //addObject(new Pipe(), 400,50);
        //addObject(new Pipe(), 400,50);

        CoinBlocks(100, getHeight()/2);
        CoinBlocks(300, getHeight()/3*2);
        CoinBlocks(500, getHeight()/5*3);


        addObject(new Goomba(), 100, 370);
        addObject(new Koopa(), 428,356);
    }

    public void act()
    {
        checkTimer();

        if(mario.getHealth() <= 0 && !gameOver)
        {
            gameOver = true;
            gameOver();
        }
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

    public void HealthHearts(int number, int xStart, int yStart)
    {  
        HealthHeart healthHeart = new HealthHeart();
        int heartWidth = healthHeart.getImage().getWidth() + 2;
        for(int i = 0; i < number; i++) 
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

    private void gameOver() 
    {
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;

        removeObject(mario);
        Greenfoot.playSound("GAMEOVER.wav");
        Timer t = (Timer) getObjects(Timer.class).get(0);
        t.stopTimer();

        addObject(new GameOver(),centerX, centerY - 50);
        addObject(new StartButton(), centerX, centerY + 60);

    }

    public Scoreboard getScoreboard()
    {
        return scoreboard;
    }
}
