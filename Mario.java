import greenfoot.*;  //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * This class handles Mario's animations, movement, and interactions.
 * Mario loses health when touching a Koopa or a Goomba, and the game ends if health reaches 0.
 * @author(William Li) 
 * @version (05/16/25)
 */
public class Mario extends Actor
{
    private static GreenfootImage[] MarioIdle = 
        {new GreenfootImage("Idle0.png"),
            new GreenfootImage("Idle0.png"),
            new GreenfootImage("Idle0.png"),
            new GreenfootImage("Idle1.png"),
            new GreenfootImage("Idle2.png"),
            new GreenfootImage("Idle3.png"),
            new GreenfootImage("Idle4.png"),
            new GreenfootImage("Idle5.png"),
            new GreenfootImage("Idle6.png"),
            new GreenfootImage("Idle7.png")};

    private static GreenfootImage[] MarioRight = 
        {new GreenfootImage("Right1.png"),
            new GreenfootImage("Right2.png"),
            new GreenfootImage("Right3.png")};

    private static GreenfootImage[] MarioLeft = 
        {new GreenfootImage("Left1.png"),
            new GreenfootImage("Left2.png"),
            new GreenfootImage("Left3.png")};

    private static int FULL_HEALTH = 3;

    // Variables needed for the logic in this class    
    private int frame;
    private int health;
    private int actCounter; 
    private int skipRate;
    private int speed;

    private double gravity, gForce;
    private boolean jumpReady = true, airControl = true, grounded, idler = true;
    private boolean isHit;

    private GreenfootImage[] animation;

    public Mario()
    {
        health = FULL_HEALTH;
        frame = 0;
        speed = 4;
        animation = MarioIdle;
        skipRate = 50;
        actCounter = 0;
        gravity = 1;
        gForce = .6;
    }

    public void act() 
    {
        actCounter++; // Keep track of how many act cycles have happened in the game so far

        // Animation management
        marioAnimator();
        updateAnimations();

        // Movement/Gravity management
        marioMover();
        applyGravity();

        // 4-way collision detection management
        bottomChecker();
        platformAbove();
        checkRightWalls();
        checkLeftWalls();

        checkEnemies();
    }    

    // Code to trigger animations based off of key presses (direction)
    private void marioAnimator()
    {
        if(Greenfoot.isKeyDown("space") && grounded)
        {
            processAnimation(MarioIdle, true, 1);
            grounded = false;
            Greenfoot.playSound("MarioJump.wav");
        }
        else if(Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d") && grounded)
        {
            processAnimation(MarioIdle, true, 150);
        }
        else if(Greenfoot.isKeyDown("a") && animation != MarioLeft && grounded)
        {
            processAnimation(MarioLeft, true, 5);
        }
        else if(Greenfoot.isKeyDown("d") && animation != MarioRight && grounded)
        {
            processAnimation(MarioRight, true, 5);
        }
        else if (!Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d") && grounded && idler)
        {
            processAnimation(MarioIdle, false, 50);
        }
    }

    public void processAnimation(GreenfootImage[] animation, boolean idler, int skipRate)
    {
        // Sets the current animation state
        this.animation = animation;
        this.idler = idler;
        this.skipRate = skipRate;
        // Makes sure the animation doesn't go out of bounds
        checkAnimationBounds();
        
        setImage(animation[frame]);
    }

    // Code to run animations based off of counter and skipRate variables (so we can customize animation speed)
    public boolean animate()
    {
        return actCounter % skipRate == 0;
    }

    public void updateAnimations()
    {
        if(animate())
        {
            setImage(animation[frame]);
            frame++;
            checkAnimationBounds();
        }
    }

    // helper method to ensure you we never run an animation array out of bounds
    public void checkAnimationBounds()
    {
        if(frame >= animation.length)
        {
            frame = 0;
        }        
    }

    public void marioMover()
    {
        // Controls for moving left/right
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - speed, getY());
        }

        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + speed, getY());
        }
        
        // Jumping action
        if(Greenfoot.isKeyDown("space") && jumpReady)
        {
            gravity = -15;
            jumpReady = false;
        }

        if(!Greenfoot.isKeyDown("space") && !jumpReady && airControl)
        {
            if(gravity<0)
            {
                gravity = 0;
            }
            airControl = false;
        }
    }    

    // Apply gravity whenever in the air
    private void applyGravity()
    {
        if(!grounded)
        {
            setLocation(getX(),getY()+(int)gravity);
            gravity += gForce;           
        }
    }

    public int getHealth()
    {
        return health;
    }

    public int getFullHealth()
    {
        return FULL_HEALTH;
    }

    public boolean isFalling() {
        return (gravity > 0) && !grounded;
    }

    // Code to gather check points for Mario's feet
    private void bottomChecker()
    {
        // Information about Mario's dimensions to process collisions
        int marioHeight = getImage().getHeight();
        int yDistance = marioHeight/2 + 1;
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

        if (ceiling instanceof CoinBlock) {
            ((CoinBlock) ceiling).spawnCoin();
        }
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

    // Ensures Mario's collision with the right wall is smooth and glitchless
    private void stopByRightWall(Actor rightWall)
    {
        int wallWidth = rightWall.getImage().getWidth();
        int newX = rightWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - 5, getY());

    }

    // Checks Mario's left side for any Platforms he might collide wit
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
    }    

    private void checkEnemies()
    {
        Object enemy = getOneIntersectingObject(Enemy.class);

        if (enemy != null)
        {
            if (!isHit) {
                isHit = true;

                if (enemy instanceof Koopa)
                {
                    takeDamage();
                } else if (enemy instanceof Goomba)
                {
                    Goomba goomba = (Goomba) enemy;
                    if (isFalling())
                    {
                        goomba.flattenGoomba();
                    } else if (!goomba.isFlattened())
                    {
                        takeDamage();
                    }
                }
            }

        } else {
            isHit = false;
        }
    }

    private void takeDamage()
    {
        health--;
        if(health <=0)
        {
            health = 0;
        } else {
            shrinkMario();
            Greenfoot.playSound("MarioShrinking.mp3");
        }

        updateHeart();
    }

    private void updateHeart()
    {
        List<HealthHeart> hearts = getWorld().getObjects(HealthHeart.class); 

        if(hearts.size() > health)
        {
            getWorld().removeObject(hearts.get(hearts.size() - 1));
        }
    }

    private void shrinkMario()
    {
        GreenfootImage flattened = new GreenfootImage(getImage());
        flattened.scale(flattened.getWidth(), flattened.getHeight() / 2); // shrinks vertically
        setImage(flattened);
    }

}
