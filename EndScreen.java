import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    private Text thankYouForPlaying;

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    { 
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;

        GreenfootImage bg = new GreenfootImage("MarioBackground.png");
        bg.scale(600, 400);
        setBackground(bg);

        thankYouForPlaying = new Text("THANK YOU FOR PLAYING!", Color.RED, 40);
        addObject(thankYouForPlaying, centerX, centerY-40);

        Scoreboard scoreboard = LevelManager.getScoreboard();

        Text yourScore = new Text("YOUR SCORE: " + scoreboard.getScore(), Color.RED,40);

        addObject(yourScore, centerX, centerY + 50);
    }
}
