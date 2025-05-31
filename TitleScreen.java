import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        super(600, 400, 1);  
        GreenfootImage bg = new GreenfootImage("Title Screen.jpg");
        bg.scale(600, 400);
        setBackground(bg);
        
        prepare();
    }

    private void prepare()
    {

        addObject(new StartButton(), 300 , 234); //starts the game
    }

}
