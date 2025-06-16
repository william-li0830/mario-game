import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Koopa enemy with walking and shell animations.
 * Can be touched by Mario to enter shell state and pop out after a delay.
 */
public class Koopa extends Enemy
{
    private static GreenfootImage[] LEFT = 
        {new GreenfootImage("KoopaLeft0.png"),
            new GreenfootImage("KoopaLeft1.png"),
            new GreenfootImage("KoopaLeft2.png")};

    private static GreenfootImage[] RIGHT = 
        {new GreenfootImage("KoopaRight0.png"),
            new GreenfootImage("KoopaRight1.png"),
            new GreenfootImage("KoopaRight2.png")};            

    private static GreenfootImage[] LEFT_SHELL = 
        {new GreenfootImage("LeftShell0.png"),
            new GreenfootImage("LeftShell1.png"),
            new GreenfootImage("LeftShell2.png"),
            new GreenfootImage("LeftShell3.png")};

    private static GreenfootImage[] RIGHT_SHELL = 
        {new GreenfootImage ("RightShell0.png"),
            new GreenfootImage ("RightShell1.png"),
            new GreenfootImage("RightShell2.png"),
            new GreenfootImage("RightShell3.png")};

    private static int SPEED = 2;
    private GreenfootImage[] animation;
    // Variables to deal with contacting Mario
    private boolean isTouched;

    // Variable for jumping
    private int jumpTimer;
    private int touchTimer;
    private int skipRate, actCounter, frame;

    public Koopa()
    {
        super(SPEED);
        animation = LEFT;
        actCounter = 0;
        skipRate = 20;
        frame = 0;
        isTouched = false;
        touchTimer = 0;
        jumpTimer = 0;
    }

    public void act()
    {
        super.act();
        actCounter++;
        checkSpeed();
        checkTouched();
        setAnimation();
        updateAnimations();
        jumper();
    }

    public void checkSpeed()
    {
        this.speed = super.getSpeed();
    }

    // The code that allows the Koopa go to into its shell after being touched by Mario and then, after some time, pop out again!
    public void checkTouched()
    {
        //Trigger for when Koopa touches Mario
        if(isTouching(Mario.class) && !isTouched)
        {
            isTouched = true;
            touchTimer = 0;
        }
        //Timer and trigger to return Koopa back to normal state after some time
        if(isTouched)
        {
            touchTimer++;
        }
        if(touchTimer % 200 == 0)
        {
            isTouched = false;
        }  
    }

    public void setAnimation()
    {
        // Animations for left motion
        if(speed < 0)
        {
            if(isTouched && animation != LEFT_SHELL)
            {
                processAnimation(LEFT_SHELL,5);
            }
            else if(!isTouched && animation != LEFT)
            {
                processAnimation(LEFT,20);
            }
        }
        //Animations for right motion
        if (speed > 0)
        {
            if(isTouched && animation != RIGHT_SHELL)
            {
                processAnimation(RIGHT_SHELL,5);
            }
            else if(!isTouched && animation != RIGHT)
            {
                processAnimation(RIGHT,20); 
            } 
        }
    }

    public void processAnimation(GreenfootImage[] anim,int skip)
    {
        this.animation = anim;
        this.skipRate = skip;
        frame = 0;
    }

    public void updateAnimations()
    {
        if(animate())
        {
            if(frame >= animation.length)
            {
                frame = 0;
            }
            setImage(animation[frame]);
            frame++;
        }
    }

    public boolean animate()
    {
        return actCounter % skipRate == 0;
    }

    public void jumper()
    {
        jumpTimer++;
        if(jumpTimer % 150 == 0)
        {
            super.setGravity(-5);
        }
    }
} 
