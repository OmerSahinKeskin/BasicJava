/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //input number for changing balance
    private int input;
    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine()
    {
        price = 1000;
        balance = 0;
        total = 0;
    }
    public TicketMachine(int cost){
        //creates another ticketmachine with a cost you enter
        price = cost;
        balance = 0;
        total = 0;
    }
    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount)
    {
        balance = balance + amount;
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        // Simulate the printing of a ticket.
        int amountLeftToPay;
        amountLeftToPay = price - balance;
        if(amountLeftToPay > 0){  //checks if your able to pay
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# Amountleft to pay " + amountLeftToPay + " cents.");
        System.out.println("##################");
        System.out.println();
    }else{
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();
             // Update the total collected with the balance.
        total = total + price;
        balance = balance - price;
        total = gettotal();
        /*// Clear the balance.
        balance = 0;
        */
    }
    }
    public int gettotal(){
        //gets total
        return total;
    }
    public void empty(){
        //empty machine
        total = 0;
    }
    public int emptyMachine(){
        int emptyAmount;
        emptyAmount = total;
        total = 0;
        return emptyAmount;
    }
    public void changeBalance(int input){
        //changes persons balance
        balance = balance + input;
    }
}
