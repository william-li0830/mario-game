import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Code Enemies .
 * @author (William Li) 
 * @version (05/16/25)
 */
public class Enemy extends Actor
{

    public boolean grounded = true;
    public boolean jumpReady = true;
    public boolean airControl = true;    

    protected int speed = 1;
    private double gravity,gForce;

    public Enemy(int speed)
    {
        this.speed = -speed;
        gravity = 1;
        gForce = .1;
    }

    public void act() 
    {
        mover();
        applyGravity();

        // 4-way collision detection management
        bottomChecker();
        platformAbove();
        checkRightWalls();
        checkLeftWalls();          
    }    

    public void applyGravity()
    {
        int koopaHeight = getImage().getHeight();
        int yDistance = koopaHeight/2 + 2;
        Actor ground = getOneObjectAtOffset(0,yDistance,Platform.class);
        if(ground != null)
        {
            gravity = 0;
            setLocation(getX(),getY()-1);
        }
        else
        {
            setLocation(getX(),getY()+(int)gravity);
            gravity += gForce;
        }
    }

    public void mover()
    {
        if(edgeChecker() || platformChecker())
        {
            speed *= -1;
        }
        setLocation(getX()+speed,getY());
    }

    public Boolean edgeChecker()
    {
        return isAtEdge();
    }

    public Boolean platformChecker()
    {
        return isTouching(Platform.class);
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setGravity(int gravity)
    {
        this.gravity = gravity;
    }

    // Code to gather check points for Mario's feet
    private void bottomChecker()
    {
        // Information about Mario's dimensions to process collisions
        int marioHeight = getImage().getHeight();
        int yDistance = marioHeight/2;
        Actor ground = getOneObjectAtOffset(0,yDistance,Platform.class);
        if(ground == null)
        {
            grounded = false;
        }
        else
        {
            grounded = true;
            moveToGround(ground);
        }
    }
    // Controls Mario's interactions with Platforms below him so the interaction is smooth and glitchless; it sets relevant triggers for jumping and animating as well!
    private void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(),newY);
        grounded = true;
        jumpReady = true;
        airControl = true;
    }

    // Checks to see if there is a Platform above Mario and, if so, stops him from moving through it
    private void platformAbove()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/-2);
        Actor ceiling = getOneObjectAtOffset(0, yDistance, Platform.class);
        if(ceiling != null)
        {
            gravity = 0;
            bopHead(ceiling);
        }
    }
    // Code for ensuring Mario's collision with ceilings is smooth and glitchless
    private void bopHead(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }

    // Checks Mario's right side for any Platforms he might collide with
    private void checkRightWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/2);
        Actor rightWall = getOneObjectAtOffset(xDistance, 0, Platform.class);
        if(rightWall != null)
        {
            stopByRightWall(rightWall);
        }
    }
    // Ensures Mario's collisiont with the right wall is smooth and glitchless
    private void stopByRightWall(Actor rightWall)
    {
        int wallWidth = rightWall.getImage().getWidth();
        int newX = rightWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - 5, getY());
        speed *= -1;
    }

    // Checks Mario'sleftt side for any Platforms he might collide wit
    private void checkLeftWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/-2);
        Actor leftWall = getOneObjectAtOffset(xDistance, 0, Platform.class);
        if(leftWall != null)
        {
            stopByLeftWall(leftWall);
        }
    }
    // Ensures Mario's collisiont with the left wall is smooth and glitchle
    private void stopByLeftWall(Actor leftWall)
    {
        int wallWidth = leftWall.getImage().getWidth();
        int newX = leftWall.getX() + (wallWidth + getImage().getWidth())/2;
        setLocation(newX + 5, getY());
        speed *= -1;
    }    
}
