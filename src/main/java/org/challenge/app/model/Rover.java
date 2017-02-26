package org.challenge.app.model;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.challenge.app.util.Direction;
import org.challenge.app.util.ERROR;
import org.challenge.app.util.Instruction;
import org.challenge.app.util.MarseRoverException;

/**
 * class for creating rover objects
 * @author Nuwan Walisundar
 *
 */
public class Rover implements Serializable {
	Log log =LogFactory.getLog(Rover.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -8942760322995194643L;
	
	
	public Rover(int cordinateX, int cordinateY, Direction direction) {
		super();
		this.cordinateX = cordinateX;
		this.cordinateY = cordinateY;
		this.direction = direction;
	}
	
	int cordinateX;
	int cordinateY;
	Direction direction;
	
	public void performAction(Instruction instruction,final Plateau plateau)throws MarseRoverException{
		log.info("Trigger move Instruction :"+instruction + " Rover : "+this);
		
		 switch (instruction) {
		case LEFT: 
				rotateLeft();
			break;
		case MOVE_FORWARD:
				moveForward(plateau);
			break;
		case RIGHT:
				rotateRight();
			break;
		case UNDEFINED:
			throw new MarseRoverException(ERROR.INVALID_INSTRUCTION); 
		}
	}
	
	private void rotateLeft()throws MarseRoverException{
		log.info("Trigger Left rotate "+this);
		 switch (direction){
		
		case NORTH:
			this.direction =Direction.WEST;
			break;
		case WEST:
			this.direction =Direction.SOUTH;
			break;
		case SOUTH:
			this.direction =Direction.EAST;
			break;
		case EAST:
			this.direction =Direction.NORTH;
			break;
		
		case UNDEFINED:
			throw new MarseRoverException(ERROR.INVALID_ROTATION);
			}
		
	}
	
	
	private void rotateRight()throws MarseRoverException{
		log.info("Trigger Right rotate "+this);
		 switch (direction){
		
		case NORTH:
			this.direction = Direction.EAST;
			break;
		case EAST:
			this.direction =Direction.SOUTH;
			break;
		case SOUTH:
			this.direction =Direction.WEST;
			break;
		case WEST:
			this.direction =Direction.NORTH;
			break;
			
		case UNDEFINED:
			throw new MarseRoverException(ERROR.INVALID_ROTATION);
			}
		
	}
	
	private void moveForward(final Plateau plateau)throws MarseRoverException{
		log.info("Trigger move "+this);
		 switch (direction){
			
			case NORTH:
				 if(plateau.getyMax()>=this.cordinateY+1){
					 this.cordinateY++;
					 log.info("Rover move to noth by one "+this);
				 }else{
					 log.warn(" rover hit the north wall " +this);
					 //throw new MarseRoverException(ERROR.HIT_NORTH_WALL);
				 }
				break;
			case WEST:
				 if(plateau.getxMin()<=this.cordinateX-1){
					 this.cordinateX--;
					 log.info("Rover move to west by one "+this);
				 }else{
					 log.warn(" rover hit the west wall " +this);
					 //throw new MarseRoverException(ERROR.HIT_WEST_WALL);
				 }
				break;
			
			case SOUTH:
				if(plateau.getyMin()<=this.cordinateY-1){
					this.cordinateY--;
					log.info("Rover move to south by one "+this);
					}else{
						log.warn(" rover hit the south wall " +this);
						// throw new MarseRoverException(ERROR.HIT_SOUTH_WALL);
					}
				break;
			case EAST:
				if(plateau.getxMax()>=this.cordinateX+1){
					this.cordinateX++;

					log.info("Rover move to East by one "+this);
					 //throw new MarseRoverException(ERROR.HIT_EAST_WALL);
				}else{
					log.warn(" rover hit the EAST wall " +this);
					
				}
				break;
			case UNDEFINED:
				throw new MarseRoverException(ERROR.INVALID_ROTATION);
				}
	}
	
	
	
	public int getCordinateX() {
		return cordinateX;
	}
	public void setCordinateX(int cordinateX) {
		this.cordinateX = cordinateX;
	}
	public int getCordinateY() {
		return cordinateY;
	}
	public void setCordinateY(int cordinateY) {
		this.cordinateY = cordinateY;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Rover [cordinateX=" + cordinateX + ", cordinateY=" + cordinateY + ", direction=" + direction + "]";
	}
	 
	
}
