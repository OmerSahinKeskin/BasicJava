import java.util.*;
/**
 * Write a description of class Group here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Group extends Point
{
    private ArrayList<Point> Plist = new ArrayList<Point>(); 

    public Group clone(){
        try { 
            Group copy = (Group)super.clone();    
            copy.Plist = (ArrayList<Point>)Plist.clone();
            
            for ( int Counter = 0; Counter < Plist.size(); Counter++ ){
                
                
                copy.Plist.set(Counter,Plist.get(Counter).clone());  

            }
            
            return copy;
        }
        catch (CloneNotSupportedException e) { 
            throw new InternalError(); 

        }

    }
    
    public Group(double xPosition,double yPosition){
        super(xPosition, yPosition);
    }

    public void add(Point item){
        try {
            Plist.add(item.clone());
        }
        
        catch (CloneNotSupportedException e) { 
            throw new InternalError(); 

        }
    }
    
    public void draw(){
        
        for(Point Pshape:Plist){
         Pshape.draw();   
        }
        
    }
    
    public void erase(){
        
        for(Point Pshape:Plist){
         Pshape.erase();   
        }
        
    }
    
    public void move(double dx,double dy){
        double Xold = getXposition();
        double Yold = getYposition();
       super.move(dx, dy);
        
       for(Point Pshape:Plist){
           Pshape.moveTo(((Pshape.getXposition() - Xold) + getXposition()), ((Pshape.getYposition() - Yold) + getYposition()));
        } 
        
        
    }
    
    public void resize(double scaleFactor){
        double Xold = super.getXposition();
        double Yold = super.getYposition();
        
        
    
       for(Point Pshape:Plist){
   //var resize objectet hamnar, bäräkna förhållandet melan objecten. 
        Pshape.resize(scaleFactor);
        Pshape.moveTo(((Pshape.getXposition()*scaleFactor) + (Xold * scaleFactor)) , (Pshape.getYposition()*scaleFactor) + (Yold * scaleFactor));
    }
    
    
    
    
    
    }
    
}
