/**
 * Abstract class Point - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Point implements Cloneable
{
 private double xPosition;
 private double yPosition;
 
 
 public abstract void erase();
 public abstract void draw();
 public abstract void resize(double scaleFactor);
 
 public Point clone() throws CloneNotSupportedException{
     try{
      Point Copy = (Point) super.clone();
      return Copy;
        }catch (CloneNotSupportedException e){
         throw new InternalError();   
        }
 }
 
 public Point(double xPosition,double yPosition){
        
        this.xPosition = xPosition;
        this.yPosition = yPosition;

 }
    
 
 public void move(double deltaX,double deltaY) {
           xPosition += deltaX;
            yPosition += deltaY;
 }
        
 /**
 * Move the figure to position (x,y).
     */
 public void moveTo(double x, double y) {
        move(x-xPosition,y-yPosition);
 }

 public double getXposition() {
        return xPosition;
    }
    
 public double getYposition() {
        return yPosition;
 } 
 
}
