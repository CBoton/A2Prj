package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;

public class MapView extends Container implements Observer	{
	TextField tf;
	/**
	 * Constructor to add MapView Observer
	 */
	public MapView()	{
		//addObserver
		setLayout(new BorderLayout());
		tf = new TextField();
		tf.setEditable(false);
		this.setHeight(768);
		this.setWidth(1024);
		add(BorderLayout.NORTH, tf);
		
	}
	/**
	 * Function to print current Map Data
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj)	{
		
		//NEED TO ADD A toString() to this then call repaint();
		//this.repaint();
	}
	/**
	 * 
	 * @return the Width of the Game Map
 	 */
	public double getMapWidth()	{
		return (double) this.getWidth();
	}
	/**
	 * 
	 * @return the Height of the Game Map
	 */
	public double getMapHeight()	{
		return (double) this.getHeight();
	}
}
