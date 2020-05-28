// This will not compile until you have constructed class Group.
public class HouseTest 
{
    public static void main()
    {
        Group house = HousePicture.getPicture();
        house.draw();
        
        Group house2 = house.clone();
        house2.move(100,-10);
        house2.resize(0.5);
        
        Group house3 = house2.clone();
        // first try this but NOT the moveTo call
        house3.move(60,180);
        // and then this but NOT the move call
        house3.moveTo(150,100);
        // and then BOTH! Is the house now drawn in the
        // correct position?
        
        
        
    }
}
