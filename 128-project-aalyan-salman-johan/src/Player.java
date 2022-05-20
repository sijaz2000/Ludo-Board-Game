import java.util.ArrayList;

import edu.macalester.graphics.*;
import java.awt.Color;

/**
 * This class is the representation of one of the players in the game, and it sets up their color, their appropriate starting position 
 * in the canvas and that of the numbers of the pieces.
 * 
 */
public class Player 
{
    public GraphicsText player1Text;
    public GraphicsText player2Text;
    public GraphicsText player3Text;
    public GraphicsText player4Text;
    public Ellipse player1;
    public Ellipse player2;
    public Ellipse player3;
    public Ellipse player4;

    /**
     * The cosntructor for the Player class. This constructor sets up the appropriate player color, and positions on the board
     * @param canvas
     * @param color
     */
    public Player(CanvasWindow canvas, Color color)
    {
        player1Text = new GraphicsText();
        player2Text = new GraphicsText();
        player3Text = new GraphicsText();
        player4Text = new GraphicsText();
        player1 = new Ellipse(0, 0, 50, 50);
        player1.setFillColor(color);
        player1.setStrokeWidth(7);
        player2 = new Ellipse(0, 0, 50, 50);
        player2.setFillColor(color);
        player2.setStrokeWidth(7);
        player3 = new Ellipse(0, 0, 50, 50);
        player3.setFillColor(color);
        player3.setStrokeWidth(7);
        player4 = new Ellipse(0, 0, 50, 50);
        player4.setFillColor(color);
        player4.setStrokeWidth(7);

        if(color.equals(Color.RED))
        {
            player1.setCenter(75, 75);
            player2.setCenter(225,75);
            player3.setCenter(75,225);
            player4.setCenter(225,225);
        }
        else if(color.equals(Color.BLUE))
        {
            player1.setCenter(75, 575);
            player2.setCenter(225,575);
            player3.setCenter(75,725);
            player4.setCenter(225,725);
        }
        else if(color.equals(Color.GREEN))
        {
            player1.setCenter(575, 75);
            player2.setCenter(725,75);
            player3.setCenter(575,225);
            player4.setCenter(725,225); 
        }
        else if(color.equals(Color.YELLOW))
        {
            player1.setCenter(575, 575);
            player2.setCenter(725,575);
            player3.setCenter(575,725);
            player4.setCenter(725,725);
        }
        canvas.add(player1);
        canvas.add(player2);
        canvas.add(player3);
        canvas.add(player4);
    }

    /**
     * This method adds all pieces to the list of pieces for the specific player
     */
    public ArrayList<Ellipse> addAllGeeti()
    {
        ArrayList<Ellipse> list = new ArrayList<>();
        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);
        return list;
    }

    /**
     * This method puts the number of the 'geeti' next to the respective geeti
     */
    public void setupTexts(CanvasWindow canvas)
    {
        player1Text.setText("0");
        player1Text.setFontStyle(FontStyle.BOLD);
        player1Text.setPosition(player1.getPosition());
        canvas.add(player1Text);
        player2Text.setText("1");
        player2Text.setFontStyle(FontStyle.BOLD);
        player2Text.setPosition(player2.getPosition());
        canvas.add(player2Text);
        player3Text.setText("2");
        player3Text.setFontStyle(FontStyle.BOLD);
        player3Text.setPosition(player3.getPosition());
        canvas.add(player3Text);
        player4Text.setText("3");
        player4Text.setFontStyle(FontStyle.BOLD);
        player4Text.setPosition(player4.getPosition());
        canvas.add(player4Text);
    }
}