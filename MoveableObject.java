package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

/**
 * @author Daniel Curtis and Curtis Botonis
 * Adds speed and direction to GameObject
 *
 */
public abstract class MoveableObject extends GameObject implements IMove {
	private int speed;
	private int direction;
	
	/**
	 * Default Constructor
	 * Adds random speed and direction to MoveableObject
	 */
	public MoveableObject()	{
		
		final int MAX_SPEED = 21;
		final int MAX_DIRECTION = 359;
		speed = rand.nextInt(MAX_SPEED);
		direction = rand.nextInt(MAX_DIRECTION);	
	}
	/**
	 * @return Int value for speed
	 */
	public int getSpeed()	{
		return speed;
	}
	/**
	 * @return Int value for direction (0-359)
	 */
	public int getDirection()	{
		return direction;
	}
	/**
	 * @param newSpeed Int value for new speed
	 */
	public void setSpeed(int newSpeed)	{
		speed = newSpeed;
	}
	/**
	 * @param newDirection Int value for new direction
	 */
	public void setDirection(int newDirection)	{
		direction = newDirection;
	}
	/**
	 * Move all MoveableObjects to their new location
	 * based off their current heading and speed
	 */
	public void move()	{
		int theta = this.getDirection();
		double oldLocX, oldLocY;
		double deltaX = 0.0;
		double deltaY = 0.0;
		if(theta == 0 || theta == 180)	{
			deltaX = Math.sin(Math.toRadians(90-theta))*this.getSpeed();
		}
		else if (theta == 90 || theta == 270)	{
			deltaY = Math.cos(Math.toRadians(90-theta))*this.getSpeed();
		}
		else	{
			deltaX = Math.sin(Math.toRadians(90-theta))*this.getSpeed();
			deltaY = Math.cos(Math.toRadians(90-theta))*this.getSpeed();
		}
		deltaX = Math.round(deltaX * 10.0)/10.0;
		deltaY = Math.round(deltaY * 10.0)/10.0;
		oldLocX = Math.round(this.getXCoord());
		oldLocY = Math.round(this.getYCoord());
		
		Point2D newLoc = new Point2D(deltaX+oldLocX,deltaY+oldLocY);
		
		this.setLocation(newLoc);
	}
	public String toString()	{
		String topOne = super.toString();
		String thisOne = " speed=" + getSpeed() + " dir=" + getDirection();
		return topOne + thisOne;
	}
}
