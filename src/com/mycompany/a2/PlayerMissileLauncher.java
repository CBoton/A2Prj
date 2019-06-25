package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
/**
 * @author Daniel Curtis and Curtis Botonis
 * This class Inherits from GameObject and MoveableObject,
 * Instantiates a MissileLauncher with location from Player/NonPlayerShip and color from GameObject,
 * speed and direction determined by Player/NonPlayerShip.
 */

public class PlayerMissileLauncher extends MissileLauncher implements ISteer, IDrawable {
	/**
	 * @param location location of PlayerShip (passed from method call in GameWorld)
	 * @param speed speed of PlayerShip (passed from method call in GameWorld)
	 * @param dir direction of PlayerShip (passed from method call in GameWorld)
	 */
	public PlayerMissileLauncher(Point2D location, int speed, int dir)    {
	        super(location, speed, dir);
	        this.setLocation(location);
	        this.setSpeed(speed);
	        this.setDirection(dir);
	}
	/**
	 * Turn PLayerMissileLauncher left 2 degrees
	 */
	public void steerLeft(){
		if(this.getDirection() >= 2) {
		this.setDirection(getDirection() - 2);
		}
		else {this.setDirection(this.getDirection() + 358);}
		System.out.println("Turned MissileLauncher left");
	}
	/**
	 * Turn PLayerMissileLauncher right 2 degrees
	 */
	public void steerRight() {
		if (this.getDirection() <= 357) {
		this.setDirection(getDirection() + 2);
		}
		else {this.setDirection(this.getDirection() - 358);}
		System.out.println("Turned MissileLauncher right");
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int x = (int)(pCmpRelPrnt.getX() + this.getXCoord());
		int y = (int)(pCmpRelPrnt.getY() + this.getYCoord());
		g.setColor(ColorUtil.BLACK);
		g.drawLine(x, y, x+10, y+10);
	}
}
