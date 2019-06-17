package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;
/**
 * @author Daniel Curtis and Curtis Botonis
 * @This class Inherits from GameObject, and MoveableObject
 * Instantiates a MissileLauncher with location, direction and speed of a Ship
 * 
 */

public class MissileLauncher extends MoveableObject{
	
	/**
	 * @param location location of a Ship (passed from method call in GameWorld)
	 * @param speed speed of a Ship (passed from method call in GameWorld)
	 * @param dir direction of a Ship (passed from method call in GameWorld)
	 */
    public MissileLauncher(Point2D location, int speed, int dir)    {
        this.setLocation(location);
        this.setSpeed(speed);
        this.setDirection(dir);
    }
    
	public String toString()	{
		String topOne = super.toString();
		return topOne;
	}
}
