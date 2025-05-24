import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Code for game timer.
 * @author (William Li) 
 * @version (05/16/25)
 */
public class Timer extends Actor
{
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int FRAMES_PER_SEC = 60;
    private static int GAME_TIME_SEC = 60 * FRAMES_PER_SEC; 
    
    private int timeLeft; 

    public Timer()
    {
        resetTimer();
        updateTimer();
    }

    public void act()
    {
        timeLeft--;
        if (timeLeft <= 0) {
            timeLeft = 0;
        }
        updateTimer();
    }

    private void updateTimer()
    {
        GreenfootImage img = new GreenfootImage("Time: " + (timeLeft/60), 24, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(img);
    }
    
    public void resetTimer() {
        this.timeLeft = GAME_TIME_SEC;
    }

    public int getTimeLeft()
    {
        return timeLeft;
    }

    private void showTimesUp()
    {
        getWorld().showText("TIME'S UP!", getWorld().getWidth()/2, getWorld().getHeight()/2);
    }

}
