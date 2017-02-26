package org.challenge.app;

import org.challenge.app.input.Invoker;
import org.challenge.app.util.MarseRoverException;


public class App 
{
    public static void main( String[] args )
    {
    	try {
    		Invoker invoker =	new Invoker();
    		invoker.initialize(args[0]);
    		
    		invoker.invokeMove();
    		 
		} catch (MarseRoverException e) {
			e.printStackTrace();
		}
    } 
	
	
	public  void main( String args )
    {
    	try {
    		Invoker invoker =	new Invoker();
    		invoker.initialize(args);
    		
    		invoker.invokeMove();
    		invoker.printLastLocation();
    		 
		} catch (MarseRoverException e) {
			e.printStackTrace();
		}
    }
}
