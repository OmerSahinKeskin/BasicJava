import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailServerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MailServerTest
{
   private MailServer mailServer;
   private MailItem messEmptyFrom;
   private MailItem messEmptyTo;
   private MailItem mess1User1to2;
   private MailItem mess2User1to2;
   private MailItem messTwoReceivers;
   private MailItem messUnknownReceiver;
   private MailItem messSpamSubj;
   private MailItem messSpamBody; 
   private MailItem testspam; 
    
     /**
     * Default constructor for test class MailServerTest
     */
    public MailServerTest()
    {
    }

     /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    { 
       mailServer = new MailServer();
       mailServer.createMailbox("user1");
       mailServer.createMailbox("user2");
       mailServer.createMailbox("user3");
       messEmptyFrom = new MailItem("", "foo", "", "");
       messEmptyTo = new MailItem("foo", "", "", "");
       mess1User1to2 = new MailItem("user1", "user2", "1", "");
       mess2User1to2 = new MailItem("user1", "user2", "2", "");
       messTwoReceivers = new MailItem("user1", "user2,user3", "", "");
       messUnknownReceiver = new MailItem("user1", "unknown", "foo", "bar");
       messSpamSubj = new MailItem("user1", "user2", "xxxSpAmyyy", "");
       messSpamBody = new MailItem("user1", "user2", "", "xxxvI a Gr AA yyy");
       testspam = new MailItem("user1", "user2", "mitt namn", "jag heter omer");
    }

     /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
      /*
     * testar skicka ett meddelande med tom avsändare
     */
    @Test
    public void testEmptyFrom(){
        mailServer.post(messEmptyFrom);
        assert(mailServer.howManyMessages() == 0);
    }
    
     /*
     * testar skicka ett meddelande med tom motagare
     */
    @Test
    public void testEmptyTo(){
        mailServer.post(messEmptyTo);
        assert(mailServer.howManyMessages() == 0);
    }
    /*
     * testar om ett meddelande som har lästs finns kvar i servern
     */
    @Test
    public void testMessageRemoval(){
         mailServer.post(mess1User1to2);
        assert(mailServer.howManyMessages() == 1);
        mailServer.getNextMailItem("user2");
        assert(mailServer.howManyMessages() == 0);
    }
    
    /*
     * testar att skapa mailbox
     */
    @Test
    public void testCreateMailbox(){
        assert(mailServer.createMailbox("user11") == 1);
    }
    
   /*
    * testar att skapa flera mailbox
    */
   @Test
   public void testCreateMailboxes(){
        int grens;
        grens = 1000;
        String firstname = "user";
        StringBuilder sb = new StringBuilder(10000);
        String [] NameArray = new String [1000];
        for(int i = 0; i<grens; i++){
            String lastname = "[i]";
            sb.append(firstname).append(lastname);
            NameArray[i] = sb.toString();
        }
        assert(mailServer.createMailboxes(NameArray) == 1000);
    }
    
    /*
    * testar om man tar emot mail i lifo 
    */
    @Test 
    public void testReciveOrder(){
        mailServer.post(mess2User1to2);
        mailServer.post(mess1User1to2);
        assert(mailServer.getNextMailItem("user2").getSubject() == "1");
        assert(mailServer.getNextMailItem("user2").getSubject() == "2");
    }
    
   /*
    * testar om man tar emot mail i lifo 
    */
   @Test
   public void testTwoReceivers(){
       mailServer.post(messTwoReceivers);
       assert(mailServer.getNextMailItem("user2").getFrom() == "user1");
   }
   
   /*
    * testar om postmaster fungerar
    */
   @Test
   public void TestReturnToSender(){
        mailServer.post(messUnknownReceiver);
        assertEquals("Postmaster",mailServer.getNextMailItem("user1").getFrom());
   }
   
   /*
    * testar spamfiltret
    */
   @Test
   public void TestspamInSubject(){
       mailServer.post(messSpamSubj);
       assert(mailServer.howManyMessages() == 0);
   }
   
   /*
    * testar spamfiltret i body
    */
   @Test
   public void TestSpamInBody(){
       mailServer.post(messSpamBody);
       assert(mailServer.howManyMailItems("user2") == 0);
       assert(mailServer.howManyMessages() == 0);
   }
   
   @Test
   public void test(){
   mailServer.post(testspam);
   assert(mailServer.howManyMailItems("user2") == 1);
   assert(mailServer.howManyMessages() == 1);
   mailServer.getNextMailItem("user2");
   assert(mailServer.howManyMessages() == 0);
   assert(mailServer.howManyMailItems("user2") == 0);
   }
}
