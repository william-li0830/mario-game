import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Goomba enemy that moves, can be flattened by Mario, and gives points when defeated.
 */
public class Goomba extends Enemy
{
    private static int SPEED = 1;
    private static int SCORE = 3;
    private boolean isTouched = false;
    private int flattenTimer = -1; // -1 means not flattened yet

    private GreenfootImage goombaLeft;
    private GreenfootImage goombaRight;

    public Goomba()
    {
        super(SPEED);
        goombaLeft = new GreenfootImage("goombaLeft.png");
        goombaRight = new GreenfootImage("goombaRight.png");
    }

    public void act()
    {
        super.act();

        // Increment flattenTimer if it is greater than 0
        if (flattenTimer >= 0)
        {
            flattenTimer++;
            if (flattenTimer >= 100)
            {
                getWorld().removeObject(this); // remove goomba after 2 seconds
            }
        }

        checkSpeed();
    }

    public void checkSpeed()
    {
        this.speed = super.getSpeed();
    }

    // Flattens Goomba and starts timer; adds points to scoreboard
    public void flattenGoomba()
    {
        GreenfootImage flattened = new GreenfootImage(getImage());
        flattened.scale(flattened.getWidth(), flattened.getHeight() / 2); // shrinks vertically
        setImage(flattened);
        flattenTimer = 0; // start timer

        Scoreboard scoreboard = LevelManager.getScoreboard();
        scoreboard.update(SCORE);
    }

    // Returns true if Goomba is currently flattened
    public boolean isFlattened()
    {
        return flattenTimer > 0;
    }
}
