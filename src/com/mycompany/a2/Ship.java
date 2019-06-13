package com.mycompany.a2;



/**
 * @author Daniel Curtis and Curtis Botonis
 * 
 *
 */
public abstract class Ship extends MoveableObject{
	
	private int missileCount;
	
	/**
	 * Adds missiles to a MoveableObject
	 */
	public Ship()	{
		final int MAX_MISSILE_COUNT = 10;
		this.missileCount = MAX_MISSILE_COUNT;
	}
	/**
	 * Reduces ships missile count by 1
	 */
	public void decrementMissileCount()	{
	 --missileCount;
	}
	/**
	 * @return The number of Missile's a Ship has
	 */
	public int getMissileCount()	{
		return missileCount;
	}
	/**
	 * @param newMissileCount 
	 */
	public void setMissileCount(int newMissileCount)	{
		if (newMissileCount <= 10) {
		missileCount = newMissileCount;}
		else System.out.println("Error: You can't have more than 10 missiles");
	}
	public String toString()	{
		String topOne = super.toString();
		String thisOne = " missiles=" + getMissileCount();
		return topOne + thisOne;
	}
}
