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
		this.add(BorderLayout.NORTH, tf);
		
	}
	/**
	 * Function to print current Map Data
	 * @param obs 
	 * @param obj - stores Collection of GameObjects
	 */
	public void update(Observable obs, Object obj)	{
		String mapOutput="";
		GameObjectCollection gameObj = (GameObjectCollection) obj;
		IIterator iColl = gameObj.getIterator();
		while(iColl.hasNext())	{
			mapOutput = mapOutput + iColl.getNext().toString();
		}
		this.repaint();
	}
	/**
	 * 
	 * @return the Width of the Game Map
 	 */
	public double getMapWidth()	{
		return (double)getWidth();
	}
	/**
	 * 
	 * @return the Height of the Game Map
	 */
	public double getMapHeight()	{
		return (double)getHeight();
	}
}
