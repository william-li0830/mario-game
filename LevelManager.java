import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelManager extends Actor
{
    public static int currentLevel = 1;
    public static Mario mario;
    public static Scoreboard scoreboard;
    
    public static void startGame() {
        scoreboard = new Scoreboard(0);
        currentLevel = 1;
        mario = new Mario();
        Greenfoot.setWorld(new Level1(mario));
    }
    
    public static Scoreboard getScoreboard()
    {
        return scoreboard;
    }
    
    public static void advanceLevel() 
    {
        if (currentLevel == 1) {
            currentLevel++;
            Greenfoot.setWorld(new Level2(mario));
        } else if (currentLevel == 2) {
            currentLevel++;
            Greenfoot.setWorld(new Level3(mario));
        } else if (currentLevel == 3) {
            currentLevel++;
            Greenfoot.setWorld(new Level4(mario));
        } else if (currentLevel == 4) {
            currentLevel++;
            Greenfoot.setWorld(new Level5(mario));
        } else if (currentLevel == 5) {
            Greenfoot.setWorld(new EndScreen());
        } 
    }
}

