import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manages the game's levels, Mario character, and scoreboard
 * 
 * The same Mario and scoreboard are used across levels to carry over health and score
 * 
 */
public class LevelManager extends Actor
{
    // I addded a level manager class to manage game levels
    
    public static int currentLevel = 1;
    public static Mario mario;            // Static so the same Mario is carried over from previous level to the next(including health)
    public static Scoreboard scoreboard;  // Static so that the score doesn't reset every level

    // Starts the game on level 1, initialize scoreboard and Mario
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

    /**
     * My sister helped me with this 
     * 
     * Advances to the next level, updating the score and loading the new world.
     * Ends the game after the last level.
     */
    public static void advanceLevel()
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

