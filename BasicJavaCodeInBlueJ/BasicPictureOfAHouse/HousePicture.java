/**
 * A picture of a house
 * 
 * @author Uno Holmer 
 * @version 2018-10-09
 */
public class HousePicture{
    private static Group pic = null;
    
    private HousePicture() {}
    
    public static Group getPicture()
    {
        if ( pic == null ) {
            pic = new Group(0,0);
            // wall
            pic.add(new Square(60,130,"red",true,90));
            // window
            pic.add(new Square(80,150,"black",true,30));
            // roof
            pic.add(new Triangle(105,60,"green",true,120,70));
            // sun
            pic.add(new Circle(200,50,"yellow",true,60));
        }
        return pic;
    }
}