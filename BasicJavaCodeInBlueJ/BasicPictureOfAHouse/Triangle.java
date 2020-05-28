import java.awt.*;
import static java.lang.Math.*;   // Simplifies the call to the round method in draw.
/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes and U. Holmer
 * @version 2.01  2018-10-09
 */

public class Triangle extends Shape{
    private double height;
    private double width;
    

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle(double xPosition,double yPosition,String color,boolean isVisible,double width,double height){
        super(xPosition,yPosition, isVisible, color);
        this.height = height;
        this.width = width;
    }    
      

   /**
     * Draw the triangle with current specifications on screen.
     */
    public void draw() {
        if(super.isVisible()) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = 
                { (int)round(super.getXposition()),
                  (int)round(super.getXposition() + (width/2)),
                  (int)round(super.getXposition() - (width/2)) };
            int[] ypoints = 
                { (int)round(super.getYposition()),
                  (int)round(super.getYposition() + height),
                  (int)round(super.getYposition() + height) };
            canvas.draw(this,super.getColor(),new Polygon(xpoints,ypoints,xpoints.length));
            canvas.wait(10);
        }
    }
    
    /**
     * Change the size proportionally according to scale factor.
     */
    public void resize(double scaleFactor)
    {
        erase();
        height *= scaleFactor;
        width *= scaleFactor;
        draw();
    }
}
