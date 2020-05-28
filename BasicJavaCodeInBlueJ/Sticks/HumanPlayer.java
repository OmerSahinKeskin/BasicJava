/**
 * Write a description of class ComputerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HumanPlayer
{
 //instans variabler
private Sticks sticks;
private UserInterface ui;

public HumanPlayer(Sticks sticks,UserInterface ui){
    //intsierar de olika objecten
    this.sticks = sticks;
    this.ui     = ui;
}
public void move(){
    //anv�ndarens move
    int n;
    while(true){
    //printar ut hur m�nga sticks som �r kvar
    ui.howManySticksMsg();
    //l�ser in input
    n = ui.nextInt();
    /*kollar input om talet �r 1 eller 2 och forts�tter inte tills den f�r
    en 1 eller 2*/
    if(sticks.canTake(n)){
       sticks.take(n);
       break;
    }
    else{
        ui.illegalMoveMsg();
    }
}
}
}