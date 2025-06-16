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
    public static Mario mario; // the same Mario is carried over from previous level to the next(including health)
    public static Scoreboard scoreboard; //so that the score doesn't reset every level

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

    public static void advanceLevel() // My sister helped me with this 
    {
        if (currentLevel == 1) {
            currentLevel++;
            scoreboard.update(10);
            Greenfoot.setWorld(new Level2(mario));
        } else if (currentLevel == 2) {
            currentLevel++;
            scoreboard.update(20);
            Greenfoot.setWorld(new Level3(mario));
        } else if (currentLevel == 3) {
            currentLevel++;
            scoreboard.update(30);
            Greenfoot.setWorld(new Level4(mario));
        } else if (currentLevel == 4) {
            currentLevel++;
            scoreboard.update(40);
            Greenfoot.setWorld(new Level5(mario));
        } else if (currentLevel == 5) {
            scoreboard.update(50);
            Greenfoot.setWorld(new EndScreen());
        } 
    }
}

