/**
 * Write a description of class Sticks here.
 * 
 * @author 
 * @version 
 */
public class Sticks
{
    //instansvariabler
    private int maxNoOfSticks;
    private int sticksLeft;

public Sticks(int n){
    //initsierar med antalet sticks du vill ha
    maxNoOfSticks = n;
    sticksLeft    = n;
}
public Sticks(){
    //inistierar med defualt sticks(21)
    maxNoOfSticks = 21;
    sticksLeft    = 21;
}
public void newGame(){
    //startar nytt spel med valt sticks
    sticksLeft = maxNoOfSticks;
}
public int sticksLeft(){
    //retunerar sticks som är kvar
    return sticksLeft;
}
public boolean canTake(int n){
    //kollar om du kan ta sticks från högen
    if(n < 1 || n > 2 || n > this.sticksLeft){
        return false;
    }else{
    return true;
    }
}
public void take(int n){
    //tar n antalet sticks
    sticksLeft = sticksLeft - n;
    /*if(sticksLeft >=0){
        sticksLeft = sticksLeft;
    }else{
        sticksLeft = 0;
    }*/
}
}

