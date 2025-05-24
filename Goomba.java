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
    
    private int health = 10;
    
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
        if (isTouching(Mario.class) && !isTouched)
        {
            flattenGoomba();
            isTouched = true;
            health--;
        }
        else if (!isTouched)
        {
            moveGoomba();
        }
        
        if(health <= 0)
        {
            getWorld().removeObject(this);
        }
        
        if(health < 10)
        {
            MyWorld myWorld = (MyWorld) getWorld();
            Scoreboard scoreboard = myWorld.getScoreboard();
            scoreboard.update(SCORE);
        }
    }

    private void moveGoomba()
    {
        if (speed < 0)
        {
            setImage(goombaLeft);
            setLocation(getX() - speed, getY());
        }
        else
        {
            setImage(goombaRight);
            setLocation(getX() + speed, getY());
        }
    }

    private void flattenGoomba()
    {
        GreenfootImage flattened = new GreenfootImage(getImage());
        flattened.scale(flattened.getWidth(), flattened.getHeight() / 2); // shrink vertically
        setImage(flattened);
    }
}
