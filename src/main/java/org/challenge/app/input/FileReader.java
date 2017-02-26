package org.challenge.app.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.challenge.app.model.Rover;
import org.challenge.app.util.Direction;
import org.challenge.app.util.ERROR;
import org.challenge.app.util.Instruction;
import org.challenge.app.util.MarseRoverException;

class FileReader {
	Log log = LogFactory.getLog(FileReader.class);
	
	private String[] stringArray;
	
	FileReader(final String fileName) throws MarseRoverException{
		
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stringArray = stream.toArray(String[]::new);
			
		}catch(IOException ioe){
			log.error("FileReader",ioe);
			throw new MarseRoverException(ERROR.INVALID_FILE);
		}
	}
	
	/**
	 * get the first line of the file and spit from space.
	 * first index need to be the coordinate of upper right x
	 * @return
	 */
	public  int getUpperRightX( )throws MarseRoverException {
		String[] upper_right_coordinates;
		/**
		 * first line of the file need to be upper right coordinate ,formated as x y
		 */
		try {
			upper_right_coordinates = stringArray[0].split(" ");
		} catch (Exception e) {
			log.error("FileReader",e);
			throw new MarseRoverException(ERROR.INVALID_FIRST_LINE);
		}
		
		/**
		 * first index of the first line need to be a number
		 */
		
		int upper_right_x;
		try {
			upper_right_x = Integer.parseInt( upper_right_coordinates[0].trim());
		} catch (NumberFormatException e) {
			log.error("FileReader",e);
			throw new MarseRoverException(ERROR.INVALID_UPPER_RIGHT_X); 
		}
		return upper_right_x;
	}
	
	/**
	 * get the first line of the file and spit from space.
	 * Second index need to be the coordinate of upper right y
	 * @return
	 */
	public  int getUpperRightY( ) throws MarseRoverException {
		
		String[] upper_right_coordinates;
		/**
		 * first line of the file need to be upper right coordinate ,formated as x y
		 */
		try {
			upper_right_coordinates = stringArray[0].split(" ");
		} catch (Exception e) {
			log.error("FileReader",e);
			throw new MarseRoverException(ERROR.INVALID_FIRST_LINE);
		}
		
		/**
		 * first index of the first line need to be a number
		 */
		
		int upper_right_y;
		try {
			upper_right_y = Integer.parseInt( upper_right_coordinates[1].trim());
		} catch (NumberFormatException e) {
			log.error("FileReader",e);
			throw new MarseRoverException(ERROR.INVALID_UPPER_RIGHT_Y); 
		}
		return upper_right_y;
	}
	
	public List<Commander> readCommanders()throws MarseRoverException{
		
		List <Commander> commanders = Collections.emptyList();
		
		for(int x=1; x<stringArray.length; x+=2){
			String[] firstLineOfRover = stringArray[x].split(" ");
			
			int  roverInitCordinateX,roverInitCordinateY=0;
			char direction;
			Direction enumDir;
			try {
				 roverInitCordinateX = Integer.parseInt( firstLineOfRover[0]);
			} catch (NumberFormatException e) {
				log.error("FileReader.readRovers",e);
				throw new MarseRoverException(ERROR.INVALID_ROVER_CORDINATE_X); 
			}
			try {
				 roverInitCordinateY = Integer.parseInt( firstLineOfRover[1]);
			} catch (NumberFormatException e) {
				log.error("FileReader.readRovers",e);
				throw new MarseRoverException(ERROR.INVALID_ROVER_CORDINATE_Y); 
			}
			
			try {
				direction =  firstLineOfRover[2].toCharArray()[0];
			} catch (NumberFormatException e) {
				log.error("FileReader.readRovers",e);
				throw new MarseRoverException(ERROR.INVALID_ROVER_DIRECTION_CHAR); 
			}
			
			 
				enumDir =Direction.get(firstLineOfRover[2].toCharArray()[0])   ;
				//invalid direction
				if (enumDir.equals(Direction.UNDEFINED)){
					throw new MarseRoverException(ERROR.INVALID_ROVER_DIRECTION); 
				}
				
			//Initialize rovers if null
			if(commanders==null){
				commanders = new ArrayList<Commander>();	
			}	
			
			Rover rover= new Rover(roverInitCordinateX,roverInitCordinateY,enumDir);
			char [] roverInstructions ;
			
			try {
				roverInstructions = stringArray[x+1].toCharArray();
			} catch (Exception e) {
				log.error("readRovers",e);
				throw new MarseRoverException(ERROR.EMPTY_ROVER_INSTRUCTIONS); 
			}
			
			/*
			 * Validate each instruction 
			 * Valid instructions Left -L,Right -R,Move M
			 */
			Commander commander = new Commander(rover);
			
			for (char c : roverInstructions) {
				Instruction tempInstruction = Instruction.get(c);
				if(tempInstruction.equals(Instruction.UNDEFINED)){
					log.warn("Invalid Instruction foudn "+ c);
					throw new MarseRoverException(ERROR.INVALID_ROVER_INSTRUCTION); 	
				}
				commander.addInstaruction(tempInstruction);
			}
			commanders.add(commander);
			
		}
		return commanders;
	}

}
