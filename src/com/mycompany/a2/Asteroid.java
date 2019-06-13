package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;


/**
 * @author Daniel Curtis and Curtis Botonis
 * This class Inherits from GameObject and MoveableObject,
 * Instantiates an Asteroid with random location and color from GameObject,
 * gets random speed and direction from MoveableObject
 */
public class Asteroid extends MoveableObject {
	
	/**
	 * int value for size of Asteroid
	 */
	private int size;
	
	/**
	 * Default Asteroid constructor, gets location, speed, and direction from parent
	 * Classes, assigns a random value for size, overrides parents COLOR
	 */
	public Asteroid()	{
		final int MAX_SIZE = 30;
		final int MIN_SIZE = 6;
		size = rand.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
		this.setColor(ColorUtil.CYAN);
		System.out.println("An Asteroid has been created");
	}
	/**
	 * @return Int value for size of Asteroid
	 */
	public int getSize()	{
		return size;
	}
	/**
	 * @param newSize Int value for new size
	 */
	public void setSize(int newSize)	{
		if (newSize >= 6 && newSize <= 30) {
		size = newSize;
		}
		else {System.out.println("Error: Invalid size");}
	}
	/**
	 * @return String representation of Asteroid in format 
	 * loc: location color:[R,G,B] speed: direction: size:
	 */
	public String toString()	{
		String topOne = super.toString();
		String thisOne = " size=" + getSize();
		return "Asteroid: " + topOne + thisOne;
	}
}
