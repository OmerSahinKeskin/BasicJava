

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MailItemTest
{
    private MailItem mi;
    
    /**
     * Default constructor for test class MailItemTest
     */
    public MailItemTest()
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
        mi = new MailItem("FROM","TO","SUBJECT","BODY");
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
  
  /**
     * testmethod
     */
    @Test
    public void testAccessors(){
        MailItem testmail=new MailItem("From","to","Subject","Messege");
        assertEquals("From",testmail.getFrom());
        assertEquals("to",testmail.getTo()[0]);
        assertEquals("Messege",testmail.getMessage());
        assertEquals("Subject",testmail.getSubject());
    }    
}
