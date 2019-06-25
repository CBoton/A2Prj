package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
/**
 * @author Daniel Curtis and Curtis Botonis,
 * Instantiates a NonPLayerShip and MissileLauncher that lives/dies with NonPlayerShip
 *
 */

public class NonPlayerShip extends Ship implements IDrawable{

	private int size;
	private MissileLauncher missileLauncher;
	
	/**
     * Instantiates a NonPLayerShip with random location, direction, and speed from super class.
     * sets color and random size and instantiates a <issileLauncher
     */
	public NonPlayerShip() {
		setMissileCount(4);
		missileLauncher = new MissileLauncher(this.getLocation(), this.getSpeed(), this.getDirection());
		setColor(ColorUtil.CYAN);
		size = 15 + GameObject.rand.nextInt(10);
		System.out.println("A NonPlayerShip has been created");
	}
	/**
     * @param newSize Int value for new size,
     * sets new size of NonPlayerShip
     */
	public void setSize(int newSize)	{
		if(newSize >= 15 && newSize <= 25) {
	        this.size = newSize;
	    	}
	    	else {
	    		System.out.println("Error: Invalid size");
	    	}
	}
	/**
     * @return Size of NonPLayerShip
     */
	public int getSize()	{
		return this.size;
	}
	public String toString()	{
		String topOne = super.toString();
		String thisOne = " size=" + getSize();
		return "NonPlayerShip: " + topOne + thisOne;
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int x = (int)(pCmpRelPrnt.getX() + this.getXCoord());
		int y = (int)(pCmpRelPrnt.getY() + this.getYCoord());
		g.setColor(ColorUtil.MAGENTA);
		g.fillArc(x, y, this.getSize(), this.getSize(), 0, 360);
	}

}
