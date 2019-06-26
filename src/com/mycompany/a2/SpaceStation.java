package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

/**
 * @author Daniel Curtis and Curtis Botonis
 *
 */
@SuppressWarnings("unused")

public class SpaceStation extends FixedObject implements IDrawable{
	private int blinkRate;
	private boolean lightOn;
	
	/**
	 * Instantiates a SpaceStation with super's ID and adds random blinkRate of light
	 */
	public SpaceStation()	{
		final int MAX_BLINK_RATE = 6;
		blinkRate = GameObject.rand.nextInt(MAX_BLINK_RATE) + 1;
		lightOn = false;
		setColor(ColorUtil.WHITE);
		System.out.println("Space Station has been added");
	}
	/**
	 * @return Int value for SpaceStation's blinkRate
	 */	
	public int getBlinkRate() {
		return blinkRate;
	}
	/**
	 * @param newBlinkRate Int value for new blink rate of SpaceStation
	 */
	public void setBlinkRate(int newBlinkRate)	{
		if (newBlinkRate >= 1 && newBlinkRate <=6 ) {
			blinkRate = newBlinkRate;
			}
			else {System.out.println("Error: Invalid BlinkRate");}
	}
	/**
	 * Turns blinkingLight on/off
	 */
	public void switchLightOn() {
		lightOn = true;
	}
	
	public void switchLightOff() {
		lightOn = false;
	}
	public String toString()	{
		String topOne = super.toString(); 
		String thisOne = " rate=" + blinkRate;
		return "Station: " + topOne + thisOne; 
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int x = (int)(pCmpRelPrnt.getX() + this.getXCoord());
		int y = (int)(pCmpRelPrnt.getY() + this.getYCoord());
		int xpoints[] =  {x-8, x-16, x-8, x+8, x+16, x+8};
		int ypoints[] = {y+8, y, y-8, y-8, y, y+8};
		int npoints = 6;
		g.setColor(this.getColor());
		if (lightOn) {
			g.fillPolygon(xpoints, ypoints, npoints);
		}
		else {
			g.drawPolygon(xpoints, ypoints, npoints);
		}
	}
}
