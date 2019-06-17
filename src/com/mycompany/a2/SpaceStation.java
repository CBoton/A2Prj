package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

/**
 * @author Daniel Curtis and Curtis Botonis
 *
 */
@SuppressWarnings("unused")

public class SpaceStation extends FixedObject {
	private int blinkRate;
	private boolean lightOn;
	
	/**
	 * Instantiates a SpaceStation with super's ID and adds random blinkRate of light
	 */
	public SpaceStation()	{
		final int MAX_BLINK_RATE = 6;
		blinkRate = GameObject.rand.nextInt(MAX_BLINK_RATE) + 1;
		lightOn = true;
		setColor(ColorUtil.LTGRAY);
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
	public void switchLightOnOff() {
		if(blinkRate == 0)
			lightOn = true;
		else
			lightOn = false;
	}
	
	public String toString()	{
		String topOne = super.toString(); 
		String thisOne = " rate=" + blinkRate;
		return "Station: " + topOne + thisOne; 
	}
}
