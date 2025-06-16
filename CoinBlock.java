import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Code to spill out a coin by the coinBlock if Mario hits it.
 * @author (William Li) 
 * @version (05/16/25)
 */
public class CoinBlock extends Platform
{
    private int coins;

    public CoinBlock() {
        coins = Greenfoot.getRandomNumber(3) + 1;
    }

    public void spawnCoin() 
    {
        if (coins > 0) 
        {
            getWorld().addObject(new Coin(), getX(), getY() - 20);
            coins--;
        }

        if (coins <= 0 ) 
        {
            setImage("EmptyBlock.png");
        }

        Scoreboard scoreboard = LevelManager.getScoreboard();
        scoreboard.update(1);
    }
}
