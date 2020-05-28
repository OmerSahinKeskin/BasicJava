
/**
 * Write a description of class GameEngine here.
 * 
 * @author 
 * @version 
 */
public class GameEngine
{
  private ComputerPlayer computerPlayer;
  private UserInterface ui;
  private HumanPlayer humanPlayer;
  private Sticks sticks;
 public void gameEngine(){
      /* initierar alla obj s� att computer player k�nner till sticks
         och humanPlayer k�nner till sticks och userinterface*/
      ui                     = new UserInterface();
      sticks                 = new Sticks();
      computerPlayer         = new ComputerPlayer(sticks);
      humanPlayer            = new HumanPlayer(sticks,ui);
 }
 public void gameEngine(int antaletStickor){
      /* initierar alla obj s� att computer player k�nner till sticks
         och humanPlayer k�nner till sticks och userinterface*/
      ui                     = new UserInterface();
      sticks                 = new Sticks(antaletStickor);
      computerPlayer         = new ComputerPlayer(sticks);
      humanPlayer            = new HumanPlayer(sticks,ui);
 }
 public void runGame(){
      /*//kallar p� metoden gameEngine
      gameEngine();*/
      //h�ller ig�ng spelet
      int n;
      while(true){
        //kollar antalet stickor som �r kvar och sparar den p� n
        //printar ut antalet stickor kvar
        ui.sticksLeftMsg(sticks.sticksLeft());
        //kollar antalet stickor och vem som vinner
        humanPlayer.move();
        n = sticks.sticksLeft();
        if(n == 0){
        ui.computerWinMsg();
        break;
        }
        computerPlayer.move();
        n = sticks.sticksLeft();
        if(n == 0){
        ui.playerWinMsg();
        break;
        }
        
  }
  
 }
}
