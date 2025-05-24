import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Code for in-game texts.
 * @author (William Li) 
 * @version (05/16/25)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage TextImage;
    Color color;
    int size;
    public Text(String Text, Color color, int size)
    {
        this.color = color;
        this.size = size;

        TextImage = new GreenfootImage(Text, size, color, new Color(0,0,0,0));
        setImage(TextImage);
    }

    public void updateText(String Text)
    {
        TextImage = new GreenfootImage(Text, this.size, this.color, new Color(0,0,0,0));
        setImage(TextImage);
    }

}
