package org.challenge.app.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Direction {

	NORTH('N'),
	EAST('E'),
	SOUTH('S'),
	WEST('W'),
	UNDEFINED('U');
	
	
	private char direction;
	private static Map<Character,Direction> directionsMap = new HashMap<Character,Direction>();
	
	Direction(char direct){
	this.direction =direct;	
	}
	 
	static {
		for (Direction enumVal : EnumSet.allOf(Direction.class)){
			directionsMap.put( enumVal.direction , enumVal);
		}
	}
	
	public static Direction get(char direction) {
		if(directionsMap.containsKey(direction)){
			directionsMap.get(direction);
		}
		return UNDEFINED;
	}
}
