import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays and updates the player's score on screen.
 * The score can be increased by calling the update method.
 * 
 */
public class Scoreboard extends Actor
{
    private int fontSize, score;
    private Color textColor, backColor;
    private String text;
    
    public Scoreboard(int s)
    {
        this.score = s;
        this.text = "SCORE: " + score;
        fontSize = 25;
        textColor = Color.WHITE;
        backColor = new Color(0, 0, 0, 0);
        updateImage();
    }
    
    public void update(int change)
    {
        score += change;
        setLabel("SCORE: " + score);
    }
    
    public void setLabel(String txt)
    {
        this.text = txt;
        updateImage();
    }
    
    public void updateImage()
    {
        GreenfootImage thisImage = new GreenfootImage(text, fontSize, textColor, backColor);
        setImage(thisImage);
    }
    
    public int getScore()
    {
        return score;
    }
}
