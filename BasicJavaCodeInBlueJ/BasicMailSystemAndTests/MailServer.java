import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.*;
import java.util.Map;

/**
 * A simple model of a mail server. The server is able to receive
 * mail items for storage, and deliver them to clients on demand.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailServer
{
    // Storage for the arbitrary number of mail items to be stored
    // on the server.
    private HashMap<String,LinkedList<MailItem>> items;
    /**
     * Construct a mail server.
     */
    public MailServer()
    {
        items = new HashMap<String,LinkedList<MailItem>>();
        createMailbox("Postmaster");
    }
    
    
    /*
     * retunerar mailbox som tillhör personen
     */
    public LinkedList<MailItem> getMailbox(String who){
       if(items.get(who) != null){
         return items.get(who);  
       }else {
       return null;    
       }
    }
    
    /*
     * skapar en brevlåda
     */
    public int createMailbox(String user){
        if(items.containsKey(user)){
            return 0;
        }else{
            items.put(user, new LinkedList<MailItem>());
            return 1;
        }
    }
    
    /*
     * skapar flera brevlådor
     */
    public int createMailboxes(String[] user){
        int Counter;
        Counter = 0;
        
        for(int i = 0; i < user.length; i++){
           if(items.containsKey(user[i].toString())){
               
            }else{
                createMailbox(user[i].toString());
                Counter++;
            }
        }
        return Counter;
    }
    
    /**
     * Return how many mail items are waiting for a user.
     * @param who The user to check for.
     * @return How many items are waiting.
     */
    public int howManyMailItems(String who)
    {
        if(items.get(who) != null){
        int count = 0;
        count = items.get(who).size();
        //adds items to how many massages
        return count;
    }
    return -1;
}

    /**
     * Return the next mail item for a user or null if there
     * are none.
     * @param who The user requesting their next item.
     * @return The user's next item.
     */
    public MailItem getNextMailItem(String who)
    {
            if(items.get(who) != null){
            if(items.get(who).isEmpty() == false){
                
                MailItem item  = items.get(who).getFirst();
                items.get(who).remove();
                
                return item;
            
            }
        return null;
    }
    return null;
}
    
    
    /**
     * Add the given mail item to the message list.
     * @param item The mail item to be stored on the server.
     */
    public void post(MailItem item)
    {
        LinkedList<MailItem> MItem;
        String[] to;
        to = item.getTo();
        if(checkFields(item) == false && SpamFilter(item) == false){
            
        for(String who : to){
        MItem = getMailbox(who);
        
        if(MItem == null){
            
           returnToSender(item, who);
           
        }else{
            
           MItem.addFirst(item);
           
        }
        }
        }
    }
    
    /*
     * skickar tbx brevet som saknar mailbox
     */
    
     public void returnToSender(MailItem message,String reciever){  
        if(reciever != "Postmaster" ){
            //kollar den som har skickat brevet och skickar tbx den
           String from = message.getFrom();
           MailItem Postmaster = new MailItem("Postmaster", from, 
                    "Unknown receiver: " + reciever, "Transcript of original message follows: \n" +
                    "----------------------------------\n" + message.toString().replace("\n","\n>"));
            post(Postmaster);
            
            //kollar om postmasters brev kommer tbx och skickar brevet till postmaster istället.
        }else if(reciever == "Postmaster"){
            String[] to = message.getTo();
            MailItem Postmaster = new MailItem("Postmaster", "Postmaster", 
                    "Unknown receiver and unknown sender: " + reciever + to, "Transcript of original message follows: \n" +
                    "----------------------------------\n" + message.toString().replace("\n","\n>"));
                    post(Postmaster);
        }
    }
    
    /*
     * kollar om det saknas en användare eller en motagare 
     */
    private boolean checkFields(MailItem item){
        if((item.getTo().length == 1 && item.getTo()[0].equals("")) || item.getFrom() == null){
         return true;   
        }else{
        return false;
    }
    }
    
    /*
     * kollar spam i body eller subject
     */
    
    public boolean SpamFilter(MailItem item){
        String[] spamarray = { "(?i).*v+i+a+g+r+a.*", "(?i).*s+p+a+m.*"}; 
        if (item.getMessage().replaceAll(" ", "").matches(spamarray[0])
        || item.getSubject().replaceAll(" ", "").matches(spamarray[1]))
        { 
            return true; 
        }
        return false;
    }
        
    
    
    /*
     * medelanden i servern
     */
    public int howManyMessages(){
        int AntaletMeddelanden;
        AntaletMeddelanden = 0;
        
        for(LinkedList<MailItem> Storage : items.values()){
            AntaletMeddelanden += Storage.size();
        }
        return AntaletMeddelanden;
    }
    
}
