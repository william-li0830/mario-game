import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    private Text thankYouForPlaying;
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    
    //TODO: add a EndScreen image and some sort of button
    public EndScreen()
    { 
        super(600, 400, 1); 
        prepare();
    }
    
     /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
     int centerX = getWidth()/2;
     int centerY = getHeight()/2;
     
     thankYouForPlaying = new Text("THANK YOU FOR PLAYING!", Color.RED, 40);
     addObject(thankYouForPlaying, centerX, centerY);
    }
}
