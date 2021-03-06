package org.challenge.app.util;

public enum ERROR {
INVALID_FIRST_LINE("MR001","First line of the file need to be upper right  cordinate of Plateau "),
INVALID_UPPER_RIGHT_X("MR002","Invalid nuber found at first line of the file . Unable to define upper right cordinate of x "),
INVALID_UPPER_RIGHT_Y("MR003","Invalid nuber found at first line of the file . Unable to define upper right cordinate of Y"),
INVALID_FILE("MR004","invalid file provided as input"), 
INVALID_ROVER_CORDINATE_X("MR005","Initial x cordinate of a rover need to be valid iniger"),
INVALID_ROVER_CORDINATE_Y("MR006","Initial y cordinate of a rover need to be valid iniger"),
INVALID_ROVER_DIRECTION("MR007","Initial rover direction need to be N ,E,S,W "), 
INVALID_ROVER_DIRECTION_CHAR("MR008","Initial rover direction need to be a char "),
EMPTY_ROVER_INSTRUCTIONS("MR009","empty instruction sequece defined "),
INVALID_ROVER_INSTRUCTION("MR009","INSTRUCTION need to be L,R,M "),
INVALID_ROTATION("MR010"," Rotation Undefined for the rover  "),
INVALID_INSTRUCTION("MR011"," Invalid instruction given  "), 
HIT_NORTH_WALL("MR012"," Rover hit North wall , stop movement  "), 
HIT_WEST_WALL("MR013"," Rover hit west wall , stop movement  "), 
HIT_SOUTH_WALL("MR014"," Rover hit south wall , stop movement  "), 
HIT_EAST_WALL("MR015"," Rover hit east wall , stop movement  "), 
INVALID_X_CORDINATE("MR016","Initial x coordinate is out side of Platu . Rover cannot place out side of Platu.   "),
INVALID_Y_CORDINATE("MR017","Initial y coordinate  is out side of Platu. Rover cannot place out side of Platu.   ");
	
	private String code;
	private String msg;

	ERROR(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public String toString(){
		return "ERROR CODE : "+ this.code +"| ERROR MESSAGE : "+ this.msg;
	}
}
