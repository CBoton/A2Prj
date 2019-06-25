package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

/**
 * @author Daniel Curtis and Curtis Botonis
 * This class Inherits from GameObject and MoveableObject,
 * Instantiates a Missile with location from Player/NonPlayerShip and color from GameObject,
 * speed and direction determined by Player/NonPlayerShip.
 */

public class Missile extends MoveableObject	implements IDrawable{
	private int fuelLevel;
	private boolean playerShip;
	
	/**
	 * Constructor creates a Missile.
	 * @param location location of Ship creating Missile
	 * @param speed speed of Ship creating Missile
	 * @param dir direction of Ship creating Missile
	 * @param ps true = PlayerShip, false = NonPlayerShip
	 */
	public Missile(Point2D location, int speed, int dir, boolean ps )    {
        final int MAX_FUEL = 15;
        this.fuelLevel = MAX_FUEL;
        this.setLocation(location);
        this.setColor(ColorUtil.MAGENTA);
        this.setSpeed(speed + 20);
        this.setDirection(dir);
        playerShip = ps;
        if(ps) { System.out.println("PlayerShip shot a missile!");}
        else { System.out.println("NonPlayerShip shot a missile!");}
	}
	/**
	 * @return True = PlayerShip Missile or  False = NonPlayerShip Missile.
	 */
	public boolean getMissileType()	{
		if(playerShip)	return true;
		
		return false;
	}
	/**
	 * Decrements Missile Fuel level
	 */
	public void decrementFuelLevel()	{
		--this.fuelLevel;
	}
	/**
	 * @return Int value for fuel level
	 */
	public int getFuelLevel()	{
		return fuelLevel;
	}
	/**
	 * @return String representation of Missile in format 
	 * loc: location color:[R,G,B] speed: direction: fuel:
	 */
	public String toString()	{
		String topOne;
		String thisOne = " fuel=" + this.getFuelLevel();
		if(playerShip)	
			topOne = "PS's Missile: " + super.toString();
		else 
			topOne = "NPS's Missile: " + super.toString();
		
		return topOne + thisOne;
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int x = (int)(pCmpRelPrnt.getX() + this.getXCoord());
		int y = (int)(pCmpRelPrnt.getY() + this.getYCoord());
		g.setColor(this.getColor());
		g.fillRect(x, y, 4, 10);
	}
	
		
	
}
