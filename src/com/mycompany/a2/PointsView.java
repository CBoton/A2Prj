package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;


public class PointsView extends Container implements Observer {
	
	private Label pointsValue;
	private Label livesValue;
	private Label clockValue;
	
	
	/**
	 *  Constructor to add build PointsView observer
	 * @param gw 
	 */
	public PointsView(GameWorld gw)	{
	
	Label pointsText = new Label("Points: ");
	pointsValue = new Label("XXX");
	pointsText.getAllStyles().setFgColor(ColorUtil.BLACK);
	Label livesText = new Label("Lives: ");
	livesValue = new Label("X");
	livesText.getAllStyles().setFgColor(ColorUtil.BLACK);
	Label clockText = new Label("Time: ");
	clockValue = new Label("XXX");
	clockText.getAllStyles().setFgColor(ColorUtil.BLACK);
	
	Container myContainer = new Container();
	myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
	
	
	
	myContainer.add(pointsText);
	myContainer.add(pointsValue);
	myContainer.add(livesText);
	myContainer.add(livesValue);
	myContainer.add(clockText);
	myContainer.add(clockValue);
	this.add(myContainer);
		 
		 
	}
	/**
	 * updated PointsView Observer
	 */
	@Override
	public void update(Observable observable, Object data) {
		GameWorld gw = (GameWorld) observable;
		pointsValue.setText("" + gw.getPlayerScore());
		livesValue.setText("" + gw.getLivesRemaining());
		clockValue.setText("" + gw.getElapsedTime());
		
		this.repaint();
		
	}
}
	