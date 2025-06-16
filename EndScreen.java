import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * EndScreen is shown when player finishes all levels
 * Displays a thank-you message and the final score.
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
