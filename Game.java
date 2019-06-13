package com.mycompany.a2;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form	{
	private GameWorld gw;
	
	public Game()	{
		gw = new GameWorld();
		gw.init();
		play();
	}
	private void play()	{
		Label myLabel=new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener(){ 
			 
			public void actionPerformed(ActionEvent evt) { 
			 
				String sCommand=myTextField.getText().toString(); 
				myTextField.clear(); 
				if(!sCommand.isEmpty())	{
				switch (sCommand.charAt(0))	{ 
				case 'a': 
					gw.addAsteroid();
					break;
				case 'y':
					gw.addNPS();
					break;
				case 'b':
					gw.addSpaceStation();
					break;
				case 's':
					gw.addPS();
					break;
				case 'f':
					gw.psFireMissile();
					break;
				case 'L':
					gw.npsFireMissile();
					break;
				case 'm':
					gw.printMap();
					break;
				case 'p':
					gw.printDisplay();
					break;
				case '>':
					gw.turnLauncher();
					break;
				case 'n':
					gw.resupplyMissiles();
					break;
				case 'k':
					gw.psMissileHitAsteroid();
					break;
				case 'e':
					gw.psMissileHitNPS();
					break;
				case 'E':
					gw.npsMissileHitPS();
					break;
				case 'c':
					gw.psHitAsteroid();
					break;
				case 'h':
					gw.psHitNPS();
					break;
				case 'x':
					gw.twoAsteroidsCollide();
					break;
				case 'I':
					gw.asteroidHitNPS();
					break;
				case 'j':
					gw.hyperspaceJump();
					break;
				case 'i':
					gw.increaseSpeed();
					break;
				case 'd':
					gw.decreaseSpeed();
					break;
				case 'l':
					gw.turnShipLeft();
					break;
				case 'r':
					gw.turnShipRight();
					break;
				case 't':
					gw.clockTicked();
					break;
				case 'q':
				      Boolean bOk= Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");
				     if (bOk) {
				          Display.getInstance().exitApplication();
				    }
				     break;
					//add code to handle rest of the commands } //switch } //actionPerformed } //new ActionListener()  ); //addActionListener  } //play 
				}
				}
			}
		}
		);
		
	}
}

