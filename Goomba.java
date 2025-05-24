import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Code Goomba's movement.
 * @author (William Li) 
 * @version (05/16/25)
 */
public class Goomba extends Enemy
{
    /**
     * Act - do whatever the Goomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

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

        if (flattenTimer >= 0)
        {
            flattenTimer++;
            if (flattenTimer >= 100) // 2 seconds
            {
                getWorld().removeObject(this);
            }
        }

        checkSpeed();
    }

    public void checkSpeed()
    {
        this.speed = super.getSpeed();
    }

    public void flattenGoomba()
    {
        GreenfootImage flattened = new GreenfootImage(getImage());
        flattened.scale(flattened.getWidth(), flattened.getHeight() / 2); // shrink vertically
        setImage(flattened);
        flattenTimer = 0; // start timer

        Scoreboard scoreboard = ((MyWorld)getWorld()).getScoreboard();
        scoreboard.update(SCORE);
    }

    public boolean isFlattened()
    {
        return flattenTimer > 0;
    }
}
