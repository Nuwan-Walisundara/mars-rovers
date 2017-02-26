package org.challenge.app.input;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.challenge.app.model.Plateau;
import org.challenge.app.util.MarseRoverException;

public class Invoker {
	private Plateau plateau;
	private List<Commander> commanders ;
	Log log =LogFactory.getLog(Invoker.class);
		
	public void initialize(final String filepath)throws MarseRoverException{
		FileReader fileReader = new FileReader (filepath);
		//Reading map coordinate
		plateau = new Plateau(fileReader.getUpperRightX(),fileReader.getUpperRightY());
		
		/*
		 * reading roves from the file
		 */
		commanders = fileReader.readCommanders();
		
	}
	
	
	public void invokeMove()throws MarseRoverException{
		log.info(" Invoke move ");
		for (Commander commander : commanders) {
		
			try {
				commander.moveOver(plateau);
			} catch (Exception e) {
				log.warn(" Commander stoped "+ e);
				continue;
			}
		}
	}
	
	public void printLastLocation()throws MarseRoverException{
		log.info(" Invoke move ");
		for (Commander commander : commanders) {
		
			System.out.println(commander.getRoverCordinates());
		}
	}
	
}
