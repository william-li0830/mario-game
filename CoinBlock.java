import greenfoot.*;

/**
 * A CoinBlock contains a few coins that can be released when hit.
 * Changes to an empty block when all coins are used.
 */
public class CoinBlock extends Platform
{
    private int coins;

    public CoinBlock() {
        // A coin block can have 1-3 coins
        coins = Greenfoot.getRandomNumber(3) + 1;
    }

    public void spawnCoin() 
    {
        // Spawns a coin if available
        if (coins > 0) 
        {
            getWorld().addObject(new Coin(), getX(), getY() - 20);
            coins--;
        }

        // Changes to empty image when empty
        if (coins <= 0 ) 
        {
            setImage("EmptyBlock.png");
        }

        Scoreboard scoreboard = LevelManager.getScoreboard();
        scoreboard.update(1);
    }
}
