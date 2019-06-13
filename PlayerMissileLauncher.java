package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;
/**
 * @author Daniel Curtis and Curtis Botonis
 * This class Inherits from GameObject and MoveableObject,
 * Instantiates a MissileLauncher with location from Player/NonPlayerShip and color from GameObject,
 * speed and direction determined by Player/NonPlayerShip.
 */

@SuppressWarnings("unused")

public class PlayerMissileLauncher extends MissileLauncher implements ISteer {
	private PlayerShip playerShip;
	
	/**
	 * @param location location of PlayerShip (passed from method call in GameWorld)
	 * @param speed speed of PlayerShip (passed from method call in GameWorld)
	 * @param dir direction of PlayerShip (passed from method call in GameWorld)
	 */
	public PlayerMissileLauncher(Point2D location, int speed, int dir)	{
		super(location,speed,dir);
		this.setLocation(location);
		this.setSpeed(speed);
		this.setDirection(dir);
	}
	
	/**
	 * Turn PLayerMissileLauncher left 2 degrees
	 */
	public void steerLeft() {
		this.setDirection(this.getDirection() - 2);
	}
	/**
	 * Turn PLayerMissileLauncher right 2 degrees
	 */
	public void steerRight() {
		this.setDirection(this.getDirection() + 2);
	}
}
