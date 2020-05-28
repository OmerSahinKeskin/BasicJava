import static java.lang.Math.*;
import java.awt.*;
/**
 * Abstract class Shape - write a description of the class here
 * 
 * @author: 
 * Date: 
 */

public abstract class Shape extends Point
{    
    private String color;
    private boolean isVisible;
      
   public Shape(double xPosition,double yPosition, boolean isVisible, String color){
        super(xPosition, yPosition);
        this.isVisible = isVisible;
        this.color = new String(color);
   }

    
    
   public abstract void draw();
   public abstract void resize(double scaleFactor);
   
   public String getColor() {
        return color;
    }
    
   public boolean isVisible() {
        return isVisible;
   }
   
   public void erase()
   {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
   }
   
   public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
   public void move(double deltaX,double deltaY) {
        erase();         
        super.move(deltaX,deltaY);
        draw();
    } 


   /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }
   
   /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    
}
