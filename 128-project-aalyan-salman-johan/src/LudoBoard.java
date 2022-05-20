import java.awt.Color;
import java.util.ArrayList;
import edu.macalester.graphics.*;


/**
 * This is the class that is used to setup the ludo main board. It takes the CanvasWindow as the parameter and sets up the board on that 
 * canvas
 */
public class LudoBoard 
{
    public Rectangle redSide;
    public Rectangle blueSide;
    public Rectangle greenSide;
    public Rectangle yellowSide;
    public ArrayList<Rectangle> blocks;
    
    /**
     * The constructor for the LudoBoard class. It takes the CanvasWindow as the parameter and sets up the board on that canvas
     * @param canvas The CanvasWindow that the board will be drawn on
     */
    public LudoBoard(CanvasWindow canvas)
    {
        redSide = new Rectangle(0,0,300,300);
        blocks = new ArrayList<>();
        redSide.setFillColor(Color.RED);
        redSide.setStrokeColor(Color.BLACK);
        blueSide = new Rectangle(0,500,300,300);
        blueSide.setFillColor(Color.BLUE);
        blueSide.setStrokeColor(Color.BLACK);
        greenSide = new Rectangle(500,0,300,300);
        greenSide.setFillColor(Color.GREEN);
        greenSide.setStrokeColor(Color.BLACK);
        yellowSide = new Rectangle(500,500,300,300);
        yellowSide.setFillColor(Color.YELLOW);
        greenSide.setStrokeColor(Color.BLACK);
        addBlockLineHorizontal(canvas, 0,300, Color.RED);
        addBlockLineHorizontal(canvas, 500, 300, Color.YELLOW);
        addBlockLineVertical(canvas, 300, 0, Color.GREEN);
        addBlockLineVertical(canvas, 300, 500, Color.BLUE);
        canvas.add(redSide);
        canvas.add(greenSide);
        canvas.add(blueSide);
        canvas.add(yellowSide);
    }

    /**
     * This method is responsible for adding the blocks for the red and yellow sides of the board
     * @param canvas The canvas to add to
     * @param startingX The starting x coordinate to start mapping the boxes from
     * @param startingY The starting y coordinate to start mapping the boxes from
     * @param color The color of the side, so as to add the appropriate colored blocks
     */
    public void addBlockLineHorizontal(CanvasWindow canvas, int startingX, int startingY, Color color)
    {
        Double incrementY = 200.0/3;
        int n = 0;
        while(n < 18)
        {
            Rectangle block = new Rectangle(startingX, startingY, 50, incrementY);
            if(color.equals(Color.RED))
            {
                if(n >= 7 && n <= 11 || n==1 || n==14)
                {
                    block.setFillColor(color);
                }
            }
            else if(color.equals(Color.YELLOW))
            {
                if(n >= 6 && n <= 10 || n==16 || n==3)
                {
                    block.setFillColor(color);
                } 
            }
            canvas.add(block);
            startingX += 50;
            n++;
            if(startingX == 300)
            {
                startingX = 0;
                startingY += incrementY;
            }
            else if(startingX == 800)
            {
                startingX = 500;
                startingY += incrementY;
            }
        }
    }

    /**
    * This method is responsible for adding the blocks for the blue and green sides of the board
     * @param canvas The canvas to add to
     * @param startingX The starting x coordinate to start mapping the boxes from
     * @param startingY The starting y coordinate to start mapping the boxes from
     * @param color The color of the side, so as to add the appropriate colored blocks
     */
    public void addBlockLineVertical(CanvasWindow canvas, int startingX, int startingY, Color color)
    {
        Double incrementY = 200.0/3;
        int n = 0;
        int reset = startingX;
        while(n < 18)
        {
            Rectangle block = new Rectangle(startingX, startingY, incrementY, 50);
            if(color.equals(Color.GREEN))
            {
                if(n ==4 || n==5 || n==6 || n==7 || n==10 || n==13 || n==16)
                {
                    block.setFillColor(color);
                }
            }
            else if(color.equals(Color.BLUE))
            {
                if(n ==1 || n==12 || n==4 || n==7 || n==10 || n==11 || n==13)
                {
                    block.setFillColor(color);
                } 
            }
            canvas.add(block);
            startingX += incrementY;
            n++;
            if(startingX == 498)
            {
                startingX = reset;
                startingY += 50;
            }
        }
    }

    /**
     * This method adds all thre blocks in the order that they are supposed to be according to the rules of the game, and sets up different
     * lists of blocks for the different color players
     * @param canvas The canvas to add to
     * @param num The player number
     * @return A lisf of the blocks in the appropriate order, suited to the player number
     */
    public ArrayList<Rectangle> getBlocks(CanvasWindow canvas, int num)
    {
        blocks = new ArrayList<>();
        int x = 55;
        int y=350;
        for (int i = 1; i < 6; i++) 
        {
            blocks.add((Rectangle)canvas.getElementAt(x, y));    
            x+= 50;
        }

        x=350;
        y=260;
        for(int i = 1; i < 14; i++)
        {
            blocks.add((Rectangle) canvas.getElementAt(x,y));
            if(i>=1 && i<= 5)
            {
                y-=50;
            }
            else if(i>= 6 && i<=7)
            {
                x+=66;
            }
            else if(i>=8 && i<=14)
            {
                y+= 50;   
            }
        }

        x=530;
        y=350;
        for (int i = 1; i < 14; i++) 
        {
            blocks.add((Rectangle)canvas.getElementAt(x,y));
            if(i>=1 && i<=5)
            {
                x+=50;
            }    
            else if(i>=6 && i<= 7)
            {
                y+=66;
            }
            else if(i>=8 && i<= 14)
            {
                x-=50;
            }
        }

        x=470;
        y=530;
        for (int i = 1; i < 14; i++) 
        {   
            blocks.add((Rectangle) canvas.getElementAt(x,y));
            if(i>=1 && i<= 5)
            {
                y+=50;
            }
            else if(i>= 6 && i<=7)
            {
                x-=66;
            }
            else if(i>=8 && i<=14)
            {
                y-= 50;   
            }
        }

        x=280;
        y=450;
        for (int i = 1; i < 9; i++) 
        {
            blocks.add((Rectangle) canvas.getElementAt(x,y));
            if(i>=1 && i<= 5)
            {
                x-=50;
            }
            else if(i>=6 && i<=7)
            {
                y-=66;
            }
        }

        int index;
        if(num ==1)
        {
            x=60;
            y=375;
            index = 51;
            for (int i = 0; i < 5; i++) 
            {
                blocks.add(index, (Rectangle) canvas.getElementAt(x,y));
                x+=50;
                index++;
            }
        }
        else if(num==2)
        {
            x=376;
            y=735;
            index = 38;
            for (int i = 0; i < 5; i++) 
            {
                blocks.add(index, (Rectangle) canvas.getElementAt(x,y));
                y-=50;
                index++;
            }   
        }
        else if(num==3)
        {
            x=376;
            y=60;
            index = 12;
            for (int i = 0; i < 5; i++) 
            {
                blocks.add(index, (Rectangle) canvas.getElementAt(x,y));
                y+=50;
                index++;
            } 
        }
        else if(num==4)
        {
            x=735;
            y=376;
            index = 25;
            for (int i = 0; i < 5; i++) 
            {
                blocks.add(index, (Rectangle) canvas.getElementAt(x,y));
                x-=50;
                index++;
            } 
        }
        return blocks;
    }
}