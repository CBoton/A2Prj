package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;

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
	private Label elapsedTimeLabel;
	/**
	 * Label for soundValue
	 */
	private Label soundValueLabel;
	/**
	 * Label for livesValue
	 */
	private Label livesValueLabel;
	
	/**
	 *  Constructor to add build PointsView observer
	 */
	public PointsView()	{
		 setLayout(new GridLayout(4));
		 this.add(playerPoints());
		 this.add(gameClock());
		 this.add(playerLives());
		 this.add(soundStatus());
		 
		 
	}
	/**
	 * updated PointsView Observer
	 */
	public void update(Observable observable, Object data) {
		IGameWorld gw = (IGameWorld) data;
		this.pointsValueLabel.setText("" + ((IGameWorld) observable).getPlayerScore());
		this.elapsedTimeLabel.setText("" + ((IGameWorld) observable).getElapsedTime());
		this.livesValueLabel.setText("" + ((IGameWorld) observable).getLivesRemaining());
		if (((IGameWorld) observable).isSoundEnabled())	{
			this.soundValueLabel.setText("ON");
		}
		else
		{
			this.soundValueLabel.setText("OFF");
		}
		this.repaint();
		
	}
	/**
	 * Container to hold playerScore
	 * @return
	 */
	private Container playerPoints() {
		Container pts = new Container(new BoxLayout(BoxLayout.X_AXIS));
		Label playerScore = new Label("Player Score: ");
		pointsValueLabel = new Label("0");
		pointsValueLabel.getAllStyles().setPaddingRight(5);
		pts.add(playerScore);
		pts.add(pointsValueLabel);
		return pts;
		
	}
	/**
	 * Container to hold the gameClock
	 * @return
	 */
	private Container gameClock() {
		Container clock = new Container(new BoxLayout(BoxLayout.X_AXIS));
		Label clk = new Label("Game Clock: ");
		Label elapsedTimeLabel = new Label("0");
		elapsedTimeLabel.getAllStyles().setPaddingRight(5);
		clock.add(clk);
		clock.add(elapsedTimeLabel);
		return clock;
				
	}
	/**
	 * Container to hold playerLives
	 * @return
	 */
	private Container playerLives()	{
		Container lives = new Container(new BoxLayout(BoxLayout.X_AXIS));
		Label playerLives = new Label("Player Lives: ");
		Label livesValueLabel = new Label("0");
		livesValueLabel.getAllStyles().setPaddingRight(5);
		lives.add(playerLives);
		lives.add(livesValueLabel);
		return lives;
	}
	/**
	 * Container to hold Sound Status
	 * @return
	 */
	private Container soundStatus()	{
		Container sound = new Container(new BoxLayout(BoxLayout.X_AXIS));
		Label soundLabel = new Label("Sound is: ");
		Label soundValueLabel = new Label("OFF");
		soundValueLabel.getAllStyles().setPaddingRight(5);
		sound.add(soundLabel);
		sound.add(soundValueLabel);
		return sound;
	}

}
