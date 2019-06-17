package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;

public class PointsView extends Container implements Observer {
	/**
	 * Label for the pointsValue
	 */
	private Label pointsValueLabel;
	/**
	 * Label for missileCritValue
	 */
	private Label missileCritValueLabel;
	/**
	 * Label for total time elapsed
	 */
	private Label elapsedTimeValueLabel;
	/**
	 * Label for soundValue
	 */
	private Label soundValueLabel;
	/**
	 * Label for livesValue
	 */
	private Label livesValueLabel;
	
	/**
	 *  Constructor to add PointsView observer
	 */
	public PointsView()	{
		 
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}
	
}
