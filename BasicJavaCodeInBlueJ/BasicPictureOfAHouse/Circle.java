import java.awt.*;
import java.awt.geom.*;
import static java.lang.Math.*;   // Simplifies the call to the round method in draw.
/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes and U. Holmer
 * @version 2.01  2018-10-09
 */

public class Circle extends Shape{
    private double diameter;

     /**
     * Create a new circle at default position with default color.
     */
    
    public Circle(double xPosition,double yPosition,String color,boolean isVisible,double diameter){
        super(xPosition, yPosition, isVisible, color);
        this.diameter = diameter;
    }
 

    /**
     * Draw the circle with current specifications on screen.
     */
    public void draw() {
        if(super.isVisible()) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, super.getColor(), 
                new Ellipse2D.Double(
                    (int)round(super.getXposition()), 
                    (int)round(super.getYposition()), 
                    (int)round(diameter), 
                    (int)round(diameter)));
            canvas.wait(10);
        }
    }
    
    /**
     * Change the size proportionally according to scale factor.
     */
    public void resize(double scaleFactor) {
        erase();
        diameter *= scaleFactor;
        draw();
    }
}
