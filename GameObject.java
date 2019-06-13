package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;


/**
 * @author Daniel Curtis and Curtis Botonis
 * This class generates a GameObject with random Point2D location with GRAY color
 */
public abstract class GameObject	{
	private Point2D location;
	private int color;
	protected static Random rand = new Random();
	
	/**
	 * Default constructor
	 */
	public GameObject()	{
		final int MAX_WIDTH = 1024;
		final int MAX_HEIGHT = 768;
		location = new Point2D((double)rand.nextInt(MAX_WIDTH),(double)rand.nextInt(MAX_HEIGHT));
		color = ColorUtil.GRAY;
		
	}
	/**
	 * @return Point2D location
	 */
	public Point2D getLocation()	{
		return location;
	}
	/**
	 * @return X coordinate of point2D location
	 */
	public double getXCoord()	{
		return location.getX();
	}
	/**
	 * @return Y coordinate of point2D location
	 */
	public double getYCoord()	{
		return location.getY();
	}
	/**
	 * @return the color in [R,G,B] format
	 */
	public String getColor()	{
		return (" color=" + "[" + ColorUtil.red(color) + "," + 
			ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]"); 
	}
	/**
	 * @param newCoord Point2D location
	 * sets the location of the object
	 */
	public void setLocation(Point2D newCoord)	{
		location = newCoord;
	}
	/**
	 * @param colorNum ColorUtil color 
	 * sets the COLOR of the object 
	 */
	public void setColor(int colorNum)	{
		color = colorNum;
	}
	
	
	/**
	 * @return Returns a string with the location and color of the object
	 */
	public String toString()	{
		String thisOne = "loc=" + getLocation() + this.getColor();
		return thisOne;
	}
}
