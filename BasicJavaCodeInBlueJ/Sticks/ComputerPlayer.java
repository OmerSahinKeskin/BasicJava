/**
 * Write a description of class ComputerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerPlayer
{
  private Sticks sticks;
  
  public ComputerPlayer(Sticks sticks){
      this.sticks = sticks;
  }
  
  private boolean isWinningPosistion(int a){
      // kollar vem som kommer vinna
        return !((a % 3) == 1);
    
} 

  public void move(){
      int takeSticks;
      int n;
      //kollar sticksLeft
      n = sticks.sticksLeft();
      //kollar vem som leder och tvingar fram en vinst
      if(isWinningPosistion(n)){ 
        }if(((n - 1) % 3) == 2){
            takeSticks = 2;
            sticks.take(takeSticks);
        }else{
          takeSticks = 1;
          sticks.take(takeSticks);
        }
      
    }
}
 

