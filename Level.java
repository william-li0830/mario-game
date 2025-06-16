import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract/super class for game levels
 * Initializes shared components to the world
 * Handles game timer, Mario health display and game over logic
 */
public abstract class Level extends World
{
    protected static final int BLOCK_SIZE = 28;

    private Scoreboard scoreboard;
    private Mario mario;
    private Text timesUpText;

    private boolean gameOver;

    // Sets up the world size and background, and prepares initial objects.
    public Level(Mario mario)
    {    
        super(600, 400, 1); 
        this.mario = mario;

        GreenfootImage bg = new GreenfootImage("MarioBackground.png");
        bg.scale(600, 400);
        setBackground(bg);
        prepare();
    }

    // Prepare initial objects: floor, Mario, timer, health hearts, scoreboard
    private void prepare()
    {
        addFloor();

        addObject(this.mario,300,0);

        addObject(new Timer(), 300,20);

        HealthHearts(mario.getHealth(), 96, 20);

        addObject(LevelManager.getScoreboard(), getWidth() - 70, 20);
    }

    public void act()
    {
        checkTimer();

        // Trigger game over if mario loses all health
        if(mario.getHealth() <= 0 && !gameOver)
        {
            gameOver = true;
            gameOver();
        }
    }

    // This method auto-generated a floor for the entire level, no matter how long it is
    public void addFloor()
    {
        GrassBlock block = new GrassBlock();
        int blockWidth = block.getImage().getWidth();
        int blockHeight = block.getImage().getHeight();
        int numBlocksFloor = getWidth() / blockWidth;

        for (int i = 0; i <= numBlocksFloor; ++i)
        {
            addObject(new GrassBlock(), i*blockWidth, getHeight() - blockHeight/2);
        }
    }

    // Add multiple CoinBlocks horizontally
    public void CoinBlocks(int xStart, int yStart, int number)
    {
        CoinBlock coinBlock = new CoinBlock();
        int blockWidth = coinBlock.getImage().getWidth();
        for(int i = 0; i < number; i++)
        {
            addObject(new CoinBlock(), xStart+(i*blockWidth), yStart);
        }
    }

    // Add multiple Blocks horizontally
    public void Blocks(int xStart, int yStart, int number)
    {
        Block block = new Block();
        int blockWidth = block.getImage().getWidth();
        for(int i = 0; i < number; i++)
        {
            addObject(new Block(), xStart+(i*blockWidth), yStart);
        }
    }

    // Add multiple StoneBlocks horizontally
    public void StoneBlocks(int xStart, int yStart, int number)
    {
        StoneBlock stoneBlock = new StoneBlock();
        int blockWidth = stoneBlock.getImage().getWidth();
        for(int i = 0; i < number; i++)
        {
            addObject(new StoneBlock(), xStart+(i*blockWidth), yStart);
        }
    }

    // Add multipel HealthHearts horizontally
    public void HealthHearts(int number, int xStart, int yStart)
    {  
        HealthHeart healthHeart = new HealthHeart();
        int heartWidth = healthHeart.getImage().getWidth() + 2;
        for(int i = 0; i < number; i++) 
        {
            addObject(new HealthHeart(), xStart+(i*heartWidth),yStart);
        }
    }

    // Checks the timer, and if time is up, displays "TIME'S UP!" and triggers game over.
    private void checkTimer() {
        if (!getObjects(Timer.class).isEmpty()) {
            Timer t = (Timer) getObjects(Timer.class).get(0);
            if (t.getTimeLeft() == 0 && t.isRunning()) {
                timesUpText = new Text("TIMES UP!", Color.RED, 100);
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

        // Shows GameOver banner and a button to start again
        addObject(new GameOver(),centerX, centerY - 50);
        addObject(new StartButton(), centerX, centerY + 60);

    }
}

