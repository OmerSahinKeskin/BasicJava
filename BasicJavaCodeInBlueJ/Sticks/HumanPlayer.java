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
    //användarens move
    int n;
    while(true){
    //printar ut hur många sticks som är kvar
    ui.howManySticksMsg();
    //läser in input
    n = ui.nextInt();
    /*kollar input om talet är 1 eller 2 och fortsätter inte tills den får
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