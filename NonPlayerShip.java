package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;


	
/**
 * @author Daniel Curtis and Curtis Botonis,
 * Instantiates a NonPLayerShip and MissileLauncher that lives/dies with NonPlayerShip
 *
 */
public class NonPlayerShip extends Ship {

    private int size;
    private MissileLauncher missileLauncher;

    /**
     * Instantiates a NonPLayerShip with random location, direction, and speed from super class.
     * sets color and random size and instantiates a <issileLauncher
     */
    public NonPlayerShip() {
        setColor(ColorUtil.CYAN);
        size = 15 + GameObject.rand.nextInt(10);
        missileLauncher = new MissileLauncher(this.getLocation(), this.getDirection(), this.getSpeed());
    }
    /**
     * @param newSize Int value for new size,
     * sets new size of NonPlayerShip
     */
    public void setSize(int newSize)    {
        this.size = newSize;
    }
    /**
     * @return Size of NonPLayerShip
     */
    public int getSize()    {
        return this.size;
    }
  
    
    public String toString()    {
        String topOne = super.toString();
        String thisOne = " size=" + getSize();
        return "NonPlayerShip: " + topOne + thisOne;
    }


}