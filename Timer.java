import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A simple game timer counting down from 30 seconds.
 * Updates its text every frame and stops when time runs out.
 */

public class Timer extends Actor
{
    private static int FRAMES_PER_SEC = 60;
    private static int GAME_TIME_SEC = 30 * FRAMES_PER_SEC; 

    private int timeLeft; 
    private boolean isRunning;

    public Timer()
    {
        isRunning = true;
        resetTimer();
        updateTimer();
    }

    public void act()
    {
        if (isRunning)
        {
            timeLeft--;
            if (timeLeft <= 0) {
                timeLeft = 0;
            }
            updateTimer();
        }
    }

    private void updateTimer()
    {
        GreenfootImage img = new GreenfootImage("TIME: " + (timeLeft/60), 24, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(img);
    }

    public void resetTimer() {
        isRunning = true;
        this.timeLeft = GAME_TIME_SEC;
    }

    public void stopTimer() {
        isRunning = false;
    }

    public int getTimeLeft()
    {
        return timeLeft;
    }
    
    public boolean isRunning()
    {
        return isRunning;
    }
}
