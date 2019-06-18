package com.mycompany.a2;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.mycompany.commands.*;

import java.util.Observable;

public class Game extends Form	{
	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	
	public Game()	{
		this.setLayout(new BorderLayout());
		gw = new GameWorld();
		mv = new MapView();
		pv = new PointsView();
		commandMenu();
		
		gw.addObserver(mv);
		gw.addObserver(pv);
		
		this.addComponent(BorderLayout.CENTER, mv);
		this.addComponent(BorderLayout.NORTH, pv);
		
		gw.init();
		this.show();
		
		//play();
	}
	
	private void commandMenu() {
		/**
		 * Create container to store controlPanel buttons.
		 */
		Container controlPanel = new Container();
		controlPanel.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		controlPanel.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		
		/**
		 * Add Asteroid
		 */
		//AddAsteroidCmd addAstCmd = new AddAsteroidCmd(gw);
	
		/**
		 * Add Non Player Ship
		 */
		//AddNPSCmd addNPSCmd = new AddNPSCmd(gw);
		
		/**
		 * Add Space Station
		 */
		//AddStationCmd addStationCmd = new AddStationCmd(gw);

		/**
		 * Add Player Ship
		 */
		//AddPSCmd addPSCmd = new AddPSCmd(gw);

		/**
		 * Increase Player Ship Speed
		 */
		//IncreaseSpeedCmd increaseSpeedCmd = new IncreaseSpeedCmd(gw);
		
		/**
		 * Decrease Player Ship Speed
		 */
		//DecreaseSpeedCmd decreaseSpeedCmd = new DecreaseSpeedCmd(gw);
		
		/**
		 * Turn Left Player Ship
		 */
		//TurnPSLeftCmd turnPSLeftCmd = new TurnPSLeftCmd(gw);
		
		/**
		 * Turn Right Player Ship
		 */
		//TurnPSRightCmd turnPsRightCmd = new TurnPSRightCmd(gw);
		
		/**
		 * Turn Left Missile Launcher
		 */
		//TurnMLLeftCmd turnMLLeftCmd = new TurnMLLeftCmd(gw);
		
		/**
		 * Turn Right Missile Launcher
		 */
		//TurnMLRightCmd turnMLRightCmd = new TurnMLRightCmd(gw);
		
		/**
		 * Player Ship firing 
		 */
		//PSFireCmd psFireCmd = new PSFireCmd(gw);
		
		/**
		 * Non Player Ship firing
		 */
		//NPSFireCmd npsFireCmd = new NPSFireCmd(gw);
		
		/**
		 * Jump
		 */
		//JumpCmd jumpCmd = new JumpCmd(gw);
		
		/**
		 * Load Missiles to Player Ship
		 */
		//ReloadPSCmd reloadPsCmd = new ReloadPSCmd(gw);
		
		/**
		 * Player Ship Missile hits Asteroid
		 */
		//PSMissileHitAsteroidCmd psMissileHitAsteroidCmd = new psMissileHitAsteroidCmd(gw);
		
		/**
		 * Player Ship Missile Hits Non Player Ship
		 */
		//PSMissileHitNPSCmd psMissileHitNPSCmd = new PSMissileHitNPSCmd(gw);
		
		/**
		 * Non Player Ship Missiles Hits Player Ship
		 */
		//NPSMissileHitPSCmd npsMissileHitPSCmd = new NPSMissileHitPSCmd(gw);
		
		/**
		 * Player Ship Hits Asteroid
		 */
		//PSHitsAsteroidCmd psHitsAsteroidCmd = new PSHitsAsteroidCmd(gw);
		
		/**
		 * Player Ship hits Non Player Ship
		 */
		//PSHitsNPSCmd psHitsNPSCmd = new PSHitsNPSCmd(gw);
		
		/**
		 * Asteroid hits another Asteroid
		 */
		//TwoAsteroidsCollideCmd twoAsteroidsCollideCmd = new TwoAsteroidsCollideCmd(gw);
		
		/**
		 * Asteroid hits Non Player Ship
		 */
		//AsteroidHitsNPSCmd asteroidHitsNPSCmd = new AsteroidHitsNPSCmd(gw);
		
		/**
		 * Run a tick command
		 */
		//TickCmd tickCmd = new TickCmd(gw);
		
///////*****SIDE MENU******/////////
		
		/**
		 * Quit the Game
		 */
		QuitCmd quitCmd = new QuitCmd(gw);
		
		/**
		 * About
		 */
		AboutCmd aboutCmd = new AboutCmd(gw);
		
		/**
		 * Sound Check Box
		 */
		SoundCheckCmd soundCheckCmd = new SoundCheckCmd(gw);
		
		/**
		 * New
		 */
		NewCmd newCmd = new NewCmd(gw);
		
		/**
		 * Save
		 */
		SaveCmd saveCmd = new SaveCmd(gw);
		
		/**
		 * Undo
		 */
		UndoCmd undoCmd = new UndoCmd(gw);
		
	}
		
	/*private void play()	{
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
					case '<':
						gw.turnLauncherLeft();
						break;
					case '>':
						gw.turnLauncherRight();
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
						gw.quit();
						Boolean bOk= Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");
					     if (bOk) {
					          Display.getInstance().exitApplication();
					    }
					     break;
				}
				}
			}
		}
		);
		
	}*/

	
}

