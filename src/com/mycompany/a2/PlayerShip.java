package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;
/**
 * @author Daniel Curtis and Curtis Botonis
 * @This class Inherits from GameObject, MoveableObject and Ship
 * Instantiates a Player with location in center of map and color from GameObject,
 * speed and direction are 0 and 90. Also instantiates a PlayerMissileLauncher that lives/dies with the Ship.
 */
public class PlayerShip extends Ship implements ISteer	{
	private PlayerMissileLauncher playerLauncher;
	/**
	 * Constructs a PlayerShip
	 */
	public PlayerShip()	{
		Point2D center = new Point2D(512,384);
		this.setLocation(center);
		this.setColor(ColorUtil.GREEN);
		this.setDirection(90);
		this.setSpeed(0);
		playerLauncher = new PlayerMissileLauncher(center, this.getSpeed(), this.getDirection());
		System.out.println("A PlayerShip has been created");
	}
	/**
	 * Increases speed of Ship by 1
	 */
	public void increaseSpeed()	{
		if(this.getSpeed() == 20) {
			setSpeed(20);
			System.out.println("Error: Ship is at full speed");
		}
		else
			setSpeed(this.getSpeed() + 1);
		System.out.println("PlayerShip is going faster");
			
	}
	/**
	 * Decreases speed of Ship by 1
	 */
	public void decreaseSpeed()	{
		if(this.getSpeed() == 0) {
			setSpeed(0);
		System.out.println("Error: If you went any slower you would be going backwards");
		}
		else
			setSpeed(this.getSpeed() - 1);
		System.out.println("PlayerShip is going slower");
	}
	/**
	 * Reloads ships Missiles to a max value of 10
	 */
	public void reloadMissiles()	{
		final int MAX_MISSILES = 10;
		this.setMissileCount(MAX_MISSILES);
		System.out.println("Missiles have been reloaded");
	}
	/**
	 * Turns ship left 2 degrees
	 */
	public void steerLeft() {
		if(this.getDirection() >= 2) {
		this.setDirection(getDirection() - 2);
		playerLauncher.steerLeft();
		}
		else {
			this.setDirection(this.getDirection() + 358);
			playerLauncher.steerLeft();
			}
		System.out.println("The PlayerShip has turned left");
	}
	/**
	 * Turns ship right 2 degrees
	 */
	public void steerRight() {
		if (this.getDirection() <= 357) {
		this.setDirection(getDirection() + 2);
		playerLauncher.steerRight();
		}
		else {
			this.setDirection(this.getDirection() - 358);
			playerLauncher.steerRight();
		}
		System.out.println("The PlayerShip has turned right");
	}
	/**
	 * @return Int direction of PlayerMissileLauncher
	 */
	public int getLauncherDirection()	{
		return playerLauncher.getDirection();
	}
	/**
	 * Turns PlayerMissileLauncher 2 degrees clockwise
	 */
	public void revolveLauncher()	{
		playerLauncher.steerRight();
	}
	
	/**
	 * Turns PlayerMissile Launcher 2 degrees counterclockwise
	 */
	public void revolveLauncherLeft()	{
		playerLauncher.steerLeft();
	}
	/**
	 * Return PlayerShip to Center of the screen
	 */
	public void returnToCenter()	{
		Point2D center = new Point2D(512,384);
		this.setLocation(center);
	}
	
	public String toString()	{
		String topOne = super.toString();
		String thisOne = " Missile launcher dir=" + getLauncherDirection();
		return "PlayerShip: " + topOne+ thisOne;
	}
}
