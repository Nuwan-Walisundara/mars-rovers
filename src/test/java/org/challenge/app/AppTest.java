package org.challenge.app;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private final static String BASE_DIR="/RandD/Test/EYEPAX/mars-rovers/testresource";
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1()
    {
    	App app =new App();
    	app.main(BASE_DIR+File.separatorChar+"test1.txt");
        assertTrue( true );
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp2()
    {
    	App app =new App();
    	app.main(BASE_DIR+File.separatorChar+"test2.txt");
        assertTrue( true );
    }
}
