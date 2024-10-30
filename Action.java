import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;


/**
 * This class shows an animation of a bouncing ball with the Canvas class. 
 *
 * @author Pipatporn Chaluthong
 * @version (2024.10.20)
 */
public class Action
{
    // instance variables - replace the example below with your own
    private Canvas myCanvas;
    //private Random bouncing;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public Action()
    {
        myCanvas = new Canvas("Action", 600, 500);
    }
    
    /**
     * Simulate two bouncing balls.
     * @param numberOfBalls the number of the ball.
     */
    public void tryAction(int numberOfBalls)
    {
        Random random = new Random();
        
        int floor = 400;   // position of the floor
        int ceiling = 80; // position of the ceiling 
        int right = 50; // position of the right wall
        int left = 550; // postion of the left wall

        myCanvas.setVisible(true);

        // draw the rectangle
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, floor, 550, floor);
        myCanvas.drawLine(50, ceiling, 550, ceiling);
        myCanvas.drawLine(right, 80, right, 400);
        myCanvas.drawLine(left, 80, left, 400);
        

        // create and show the balls
        BoxBall[] balls = new BoxBall[numberOfBalls];
        for (int i = 0; i < numberOfBalls; i++) {
            // Create random size
            int diameter = 8 + random.nextInt(10); 
            // Give a random color
            Color color = new Color(random.nextInt(256), random.nextInt(256), 
                            random.nextInt(256)); 
            
            // Start from center of the rectangle
            int xPosition = (left + right) / 2 - diameter / 2
                                + random.nextInt(500);
            int yPosition = ceiling + 10 + random.nextInt(300);
            
            // Random speed
            int xSpeed = 5 + random.nextInt(1);
            int ySpeed = 5 + random.nextInt(1); 
            
            
            balls[i] = new BoxBall(xPosition, yPosition, diameter, 
                        color, floor, ceiling, right, left, myCanvas);
            balls[i].draw();
        }
        
        // make them bounce
        boolean finished = false;
        while(!finished) {
            myCanvas.wait(2);
            for (BoxBall ball : balls) {
                ball.move();
            }
        }

    }

}
