package org.challenge.app.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Instruction {
	LEFT('L'),
	RIGHT('R'),
	MOVE_FORWARD('M'),
	UNDEFINED('U');
	
	
	private char instruction;
	private static Map<Character,Instruction> InstructionMAP = new HashMap<Character,Instruction>();
	
	Instruction(char instruction){
	this.instruction =instruction;	
	}
	 
	static {
		for (Instruction enumVal : EnumSet.allOf(Instruction.class)){
			InstructionMAP.put( enumVal.instruction , enumVal);
		}
	}
	
	public static Instruction get(char direction) {
		if(InstructionMAP.containsKey(direction)){
			return InstructionMAP.get(direction);
		}
		return UNDEFINED;
	}
}
