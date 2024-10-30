import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * This class is about a graphical ball that bounces around. 
 * The ball moves and determines its own movement.
 * It moves nonestop upward or downward and bounces left right or up down.
 * 
 * @author Pipatporn Chaluthong
 *
 * @version 2024.10.20
 */

public class BoxBall
{
    private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int floor;                // y position of ground
    private final int ceiling;              // x position of ceiling
    private final int rightWall;            // x position of right wall
    private final int leftWall;             // x position of left wall
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private int xSpeed = 1;                // initial upward speed

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param floorPos  the position of the ground (where the wall will bounce)
     * @param leftWallPos the position of the left wall
     * @param rightWallPos the position of the right wall
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                    int floorPos, int ceilingPos, int rightWallPos, 
                    int leftWallPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        floor = floorPos;
        ceiling = ceilingPos;
        rightWall = rightWallPos;
        leftWall = leftWallPos;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;
                
        // check if it has hit the ceiling
        if (yPosition <= ceiling && ySpeed < 0) {
           yPosition = ceiling;
           ySpeed = -ySpeed;
        }
        
        // check if it has hit the left wall 
        if (xPosition >= (leftWall - diameter) && xSpeed > 0) {
            xPosition = (int)(leftWall - diameter);
            xSpeed = -xSpeed;
        }
        
        // check if it has hit the right wall 
        if (xPosition <= rightWall && xSpeed < 0) {
            xPosition = rightWall;
            xSpeed = -xSpeed;
        }

        // check if it has hit the floor
        if (yPosition >= (floor - diameter) && ySpeed > 0) {
            yPosition = (int)(floor - diameter);
            ySpeed = -ySpeed;  
        }

        // draw again at new position
        draw();
    }
    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    /**
     * return the diameter of this ball
     */
    public int getDiameter()
    {
        return diameter;
    }

    
}
