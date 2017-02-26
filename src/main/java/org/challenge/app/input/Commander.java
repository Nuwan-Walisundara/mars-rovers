package org.challenge.app.input;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.challenge.app.model.Plateau;
import org.challenge.app.model.Rover;
import org.challenge.app.util.Instruction;
import org.challenge.app.util.MarseRoverException;

public class Commander {
	private Rover rover  ;
	private List<Instruction> insructionList;
	private  Log log =LogFactory.getLog(Commander.class);
	
	Commander( Rover rover  ){
		this.rover =rover ;
	}
	
	public void addInstaruction(Instruction i){ 
		if(insructionList==null){
			insructionList = new ArrayList<Instruction>();
			
		}
		insructionList.add(i);
	}
	
	public void moveOver(final Plateau plateau) throws MarseRoverException{
		log.info("Trigger move over Plateau :"+plateau);
		for (Instruction instruction : insructionList) {
			try {
				rover.performAction(instruction,plateau);
			} catch (Exception e) {
				log.error("moveOver" ,e);
			}
		}
	}

	public String getRoverCordinates() {
		// TODO Auto-generated method stub
		return rover.getCordinateX()+" " +rover.getCordinateY()+ " " +rover.getDirection().getCode();
	}
}
