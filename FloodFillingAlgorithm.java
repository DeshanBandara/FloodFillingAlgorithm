import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FloodFillingAlgorithm extends JFrame implements MouseListener
{
    Graphics g;
    int x, y, x1, y1;
    Color pixel[][] = new Color [800][800];

    FloodFillingAlgorithm()
    {
        setSize(800,800);
        setTitle("Filling Algorithm");
        setLocationRelativeTo(null);
        setVisible(true);
        //setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        g=getGraphics();
        getContentPane().setBackground(Color.black);
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseClicked(MouseEvent m)
    {
        x1 = m.getX();
        y1 = m.getY();
        drawObject(x1, y1);
        floodFill(x1, y1, Color.red, Color.yellow);
    }
    public void mousePressed(MouseEvent m){}
    public void mouseReleased(MouseEvent m){}
    public void mouseExited(MouseEvent m){}

    Color getPixel(int x, int y)
    {
        return pixel[x][y];
    }
    void setPixel(int x, int y, Color c)
    {
        g=getGraphics();
        g.setColor(c);
        pixel[x][y] = g.getColor();
        g.drawOval(x,y,10,10);
    }

    void drawObject(int x1, int y1)
    {
        for(x=x1; x<x1+100; x++)
        {
            for(y=y1; y<y1+100; y++)
            {
                setPixel(x, y, Color.red);
            }
        }
    }

    void floodFill(int x, int y, Color oldColor, Color newColor)
    {
        Color pixelColor = getPixel(x, y);
        if(oldColor == newColor)
        {
            return;
        }
        if(pixelColor != oldColor)
        {
            return;
        }
        if(pixelColor == oldColor)
        {
            setPixel(x, y, newColor);
            floodFill(x+1, y, oldColor, newColor);
            floodFill(x-1, y, oldColor, newColor);
            floodFill(x, y+1, oldColor, newColor);
            floodFill(x, y-1, oldColor, newColor);
        }
    }

    public static void main(String[] args)
    {
        new FloodFillingAlgorithm();
    }
} 