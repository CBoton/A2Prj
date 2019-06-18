package com.mycompany.a2;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
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
		mv = new MapView(gw);
		pv = new PointsView(gw);
		commandMenu();
		gw.addObserver(mv);
		gw.addObserver(pv);
		
		this.addComponent(BorderLayout.CENTER, mv);
		this.addComponent(BorderLayout.NORTH, pv);
		gw.notifyObservers();
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
		Toolbar sideMenu = new Toolbar();
		setToolbar(sideMenu);
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
		CheckBox cBox = new CheckBox("Sound On/Off");
		cBox.addPointerPressedListener(soundCheckCmd);
		cBox.setCommand(soundCheckCmd);
		cBox.putClientProperty("SideComponent", soundCheckCmd);
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
		
		sideMenu.addCommandToSideMenu(quitCmd);
		sideMenu.addCommandToSideMenu(aboutCmd);
		sideMenu.addCommandToSideMenu(soundCheckCmd);
		sideMenu.addCommandToSideMenu(newCmd);
		sideMenu.addCommandToSideMenu(saveCmd);
		sideMenu.addCommandToSideMenu(undoCmd);
		
	}
		
}

