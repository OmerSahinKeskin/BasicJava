/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Club
{
    // Define any necessary fields here ...
    private LinkedList<Membership> members;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        members = new LinkedList<Membership>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     * @return true if member was added, false ow.
     */
    public boolean join(Membership member) {
        Iterator<Membership> mb = members.iterator();
        if(member == null){
            return false;
        }
        //checks if email already exists
        while(mb.hasNext()){
        if((mb.next().getEpost().equals(member.getEpost()))){
            return false;
        }
        }
        //if not add member
        members.add(member);
        return true;
    }
    public boolean delete(String email){  
        Iterator<Membership> mb = members.iterator();
          if((email==null) || (email.equals("")))
          {
             return false;
          }
          
          
          while(mb.hasNext())
          {
              //Membership Temp=mb.next();
              if(mb.next().getEpost().equals(email))
              {
                  mb.remove();
                  return true;
              }
          }
          return false;
        }
    
    public Membership findmember(String email){
        //checks for everyemail until it finds the email address of the one you searched for
        for(Membership member : members){
            if(email.equals(member.getEpost())){
             return member;   
            }
        }
        return null;
    }
 
    /**
     * Return the number of members in this club.
     * @return The number of stored Membership objects.
     */
    public int numberOfMembers()
    {
        return members.size();
    }
    public void intersect(Club other){
        //checks if other is null if its not it calls printAllMembers method to print both clubs members.
        if(other == null){
         System.out.println("didnt work");   
        }else{
            for(Membership mb : members)
        if(other.findmember(mb.getEpost()) != null){
            System.out.println(mb.toString());
        }
        }
    }
    
    public int transferAll(Club other){
      int numberOfMembersAdded;
      numberOfMembersAdded = 0;
      //checks if you try to transfer same club and prints out an error
      if(other == this){
          System.out.println("you cant refer to the same object here!!");
          return 0;
        }else{
            //checks every member in members and adds it to the normal list
         for(Membership member : other.members){
             if(this.join(member)){
             numberOfMembersAdded++;    
             }
         }
         //clears everything on the other club
         other.members.clear();
         return numberOfMembersAdded;
        }
      
    }
    /** 
     * Print membership info about all members in this club.
     */
    public void printAllMembers()
    {
        String member;
        // prints out every member
        for(int index = 0;index<members.size(); index++){
            member = members.get(index).toString();
            System.out.println(member);
        }
    }
    
    public String getEmailAdresses(){
        //checks for an email address
       Iterator<Membership> mb = members.iterator();
       StringBuilder sb = new StringBuilder(256);
       while(mb.hasNext())
         {
             Membership TStorage=mb.next();
             if(mb.hasNext())
             {
             sb.append(TStorage.getEpost());
             sb.append(" , ");
            }
            else
             sb.append(TStorage.getEpost());
            
         }
         String s=sb.toString();
         return s;
      
      }
    
    public int joinedInMonth(int month, int year){
       int Counter;
       Counter = 0;
       //checks if the month is valid
       if(month < 1 || month > 12){
           System.out.println("Put in a real month. Between 1 - 12");
       }else{
       for(Membership member : members){
           //checks given month to see how many joined in that month and year
           if(year == member.getYear() && month == member.getMonth()){
               Counter++;
            }
        }
    }
    return Counter;
    }
        
    public ArrayList<Membership> purge(int month, int year){
        ArrayList<Membership> RemovedList = new ArrayList<Membership>();
        Iterator<Membership> mb = members.iterator();
        //checks month and year so the month is in the intervall 1-12 and year is not negative
          if((month<1 || month>12 || year<1))
          {
              System.out.println("Put in a real month. Between 1 - 12 or put in a real year (not negative)");
              return null ;
          }
          
          while (mb.hasNext())
          {
              Membership TStorage=mb.next();
              if(TStorage.getYear()==year && TStorage.getMonth()==month) 
              {
                  delete(TStorage.getEpost());
                  RemovedList.add(TStorage);
              }
          
          }
          
          for(Membership Counter: RemovedList)
          {
              System.out.println(Counter.getEpost());
          }
          return RemovedList;
        }
    }

