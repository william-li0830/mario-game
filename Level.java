import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Level extends World
{
    private Scoreboard scoreboard;
    private Mario mario;
    private Text timesUpText;

    private boolean gameOver;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level(Mario mario)
    {    
        super(600, 400, 1); 
        this.mario = mario;
        
        GreenfootImage bg = new GreenfootImage("MarioBackground.png");
        bg.scale(600, 400);
        setBackground(bg);
        prepare();

        timesUpText = new Text("TIME'S UP!", Color.RED, 100);

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addFloor();

        addObject(this.mario,235,356);

        addObject(new Timer(), 300,20);

        HealthHearts(mario.getHealth(), 96, 20);
        
        addObject(LevelManager.getScoreboard(), getWidth() - 70, 20);

        addFloor();
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
            if (t.getTimeLeft() == 0 && t.isRunning()) {
                addObject(timesUpText, 300, 350);
                gameOver();
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

}

