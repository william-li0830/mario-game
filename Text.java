import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Code for in-game texts.
 * @author (William Li)
 */
public class Text extends Actor
{
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
