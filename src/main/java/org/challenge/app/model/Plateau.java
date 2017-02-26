package org.challenge.app.model;

import java.io.Serializable;

/**
 * class for creating Map objects
 * @author Nuwan Walisundar
 *
 */
public class Plateau implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3293684948468359353L;
	private int xMin =0; //always set to zero
	private int yMin=0;
	
	
	public Plateau(int xMax, int yMax) {
		super();
		this.xMax = xMax;
		this.yMax = yMax;
	}
	
	
	private int xMax;
	private int yMax;
	
	public int getxMax() {
		return xMax;
	}
	public void setxMax(int xMax) {
		this.xMax = xMax;
	}
	public int getyMax() {
		return yMax;
	}
	public void setyMax(int yMax) {
		this.yMax = yMax;
	}
	public int getxMin() {
		return xMin;
	}
	public int getyMin() {
		return yMin;
	}
	
	

}
