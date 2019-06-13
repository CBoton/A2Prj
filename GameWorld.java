package com.mycompany.a2;

import java.util.Collection;
import java.util.Vector;
import com.codename1.ui.geom.Point2D;
/**
 * @author Daniel Curtis and Curtis Botonis
 * Generates and controls game world
 *
 */


public class GameWorld {
	// Game data //
	/**
	 * Vector to store GameObjects
	 */
	private Vector<GameObject> gameObj;
	/**
	 * int value of player lives
	 */
	private int playerLives;
	/**
	 * int value of players score
	 */
	private int playerScore; 
	/**
	 * int value of clock time
	 */
	private int clock;
	/**
	 * Tracks if a PlayerShip is in the world.
	 */
	private boolean pship = false;
	/**
	 * Tracks amount of NonPlayerShips  in the world.
	 */
	private int npship = 0;
	/**
	 * Tracks amount of Asteroids in the world.
	 */
	private int astObj = 0;
	/**
	 * Tracks amount of Missiles in the world.
	 */
	private int misObj = 0;
	/**
	 * Tracks number of NonPlayerShip's Missile objects in the world;
	 */
	private int npsMis = 0;
	/**
	 * Tracks if a spaceStation is in the world
	 */
	private boolean station = false;
	
	/**
	 * Constructor instantiates a Vector to store Game Objects
	 */
	public GameWorld()	{
		gameObj = new Vector<GameObject>();
		this.init();
	}
	
	/**
	 * initializes game variables to new game state 
	 */
	public void init()	{
		playerLives = 3;
		playerScore = 0;
		clock = 0;
		
	}
	/**
	 * adds an Asteroid object to the game world
	 */
	public void addAsteroid() {
		Asteroid a = new Asteroid();
		gameObj.add(a);
		astObj++;
		System.out.println("An Asteroid has been created");
	}
	/**
	 * adds a NonPlayerShip object to the world
	 */
	public void addNPS() {
		NonPlayerShip nps = new NonPlayerShip();
		gameObj.add(nps);
		npship++;
		System.out.println("A NonPlayerShip has been created");
	}
	/**
	 * adds a SpaceStation object to the world
	 */
	public void addSpaceStation()	{
		if (!station) {
		SpaceStation ss = new SpaceStation();
		gameObj.add(ss);
		station = true;
		System.out.println("A SpaceStation has been created");
	}
		else
		{
			System.out.println("A SpaceStation has already been created"); 
		}
	}
	/**
	 * adds a PlayerShip object to the world
	 */
	public void addPS() {
		if(!pship)
		{
			PlayerShip ps = new PlayerShip();
			gameObj.add(ps);
			pship = true;
			System.out.println("A PlayerShip has been created");
		}
		else
		{
			System.out.println("You can only have one playerShip at a time");
		}
	}

	  /**
	 * adds a Missile object fired from the PlayerShip object into the world
	 */
	public void psFireMissile() { 
		if(!pship) {System.out.println("You can't shoot missiles without a ship");}
		else { 
		PlayerShip ps = null; 
		  for(int i=0; i <gameObj.size(); i++) { 
			  if(gameObj.elementAt(i) instanceof PlayerShip) { 
				  ps = (PlayerShip) gameObj.elementAt(i); 
				  if(ps.getMissileCount() > 0) { 
					  Missile msl = new Missile(ps.getLocation(),ps.getSpeed(), ps.getLauncherDirection(),pship); 
					  ps.setMissileCount(ps.getMissileCount() - 1);
					  gameObj.add(msl); 
					  misObj++;
					  System.out.println("PlayerShip shot a missile!");
				  }
			  		else {
			  		System.out.println("Error: No missiles remaining!"); 
			  			} 
			  }
		  }
		} 
	  }
	 
	/**
	 * adds a Missile object fired from the NonPlayerShip object into the world
	 */
	public void npsFireMissile() {
		if(npship == 0) {System.out.println("Error: No NonPlayerShip in game");}
		else {
		NonPlayerShip nps = null;
		for(int i=0; i < gameObj.size(); i++)	{
			if(gameObj.elementAt(i) instanceof NonPlayerShip) {
				nps = (NonPlayerShip) gameObj.elementAt(i);
				if(nps.getMissileCount() > 0)	{
					Missile msl = new Missile(nps.getLocation(),nps.getSpeed(), nps.getDirection(), false);
					nps.setMissileCount(nps.getMissileCount() - 1);
					gameObj.add(msl);
					npsMis++;
					System.out.println("NonPlayerShip shot a missile!");
				}
				else	{
					System.out.println("Error: NonPlayerShip is out of Missiles");
				}
			}
		  }
		}
		}
	/**
	 * prints all of the objects that are currently in the GameWorld
	 */
	public void printMap()	{
		if (gameObj.size() == 0) {System.out.println("Error: The game world is empty");}
		else {
		for(int i=0; i < gameObj.size(); i++)	{
			if(gameObj.elementAt(i) instanceof PlayerShip) {
				PlayerShip ps = (PlayerShip) gameObj.elementAt(i);
				System.out.println(ps.toString());
			}
			else if(gameObj.elementAt(i) instanceof NonPlayerShip)	{
				NonPlayerShip nps = (NonPlayerShip) gameObj.elementAt(i);
				System.out.println(nps.toString());
			}
			else if(gameObj.elementAt(i) instanceof Asteroid)	{
				Asteroid ast = (Asteroid) gameObj.elementAt(i);
				System.out.println(ast.toString());
			}
			else if(gameObj.elementAt(i) instanceof SpaceStation)	{
				SpaceStation ss = (SpaceStation) gameObj.elementAt(i);
				System.out.println(ss.toString());
			}
			else if(gameObj.elementAt(i) instanceof Missile)	{
				Missile mis = (Missile) gameObj.elementAt(i);
				System.out.println(mis.toString());
			}
		}
		}
	}
	/**
	 * prints the amount of players lives, their score, and clock time
	 */
	public void printDisplay() {
        System.out.println("Playerlives: " + playerLives + " PlayerScore: " + playerScore + " Clock: " + clock);
    }
	
	/**
	 * reloads PlayerSHips missile supply to 10
	 */
	public void resupplyMissiles() {

		if(!pship) {System.out.println("Error: No PlayerSHip to reload");}
		else {
        for(int i=0; i < gameObj.size(); i++)    {
            if(gameObj.elementAt(i) instanceof PlayerShip) {
                PlayerShip ps = (PlayerShip) gameObj.elementAt(i);
                if(ps.getMissileCount() < 10) {
                    ps.reloadMissiles();
                    
                }
            }
        }
		}
    }
	/**
	 * turns the PLayerShipMissileLauncher clockwise
	 */
	public void turnLauncher() {
		if(!pship) {System.out.println("Error: No PlayerShip means no missile launcher to turn");}
		else {
		PlayerShip ps = null;
		for(int i =0; i< gameObj.size(); i++)	{
			if(gameObj.elementAt(i) instanceof PlayerShip)	{
				ps = (PlayerShip) gameObj.elementAt(i);
				ps.revolveLauncher();
		
			}
		}
		}
	}
	/**
	 * A PLayerShip's Missile hits and destroys an Asteroid, 
	 * removing one of each from the game world
	 */
	public void psMissileHitAsteroid()     {
		if (misObj == 0) {System.out.println("Error: No missiles to explose Asteroids");}
		else if(astObj == 0) {System.out.println("Error: There are no Asteroids to explode");}
		else {
		Missile m = null;
	    int msl = -1;
	    int ast = -1;
	    
	    for (int i = 0; i < gameObj.size(); i++) {
	            if (gameObj.elementAt(i) instanceof Missile && msl == -1) {
	                m = (Missile) gameObj.elementAt(i);
	            	if(m.getMissileType())	{
	            		msl = i;
	             	}
	            }
	            if (gameObj.elementAt(i) instanceof Asteroid && ast == -1)	{
	                	ast = i;
	            }
	            if (msl != -1 && ast != -1 && msl < ast)	{
	            	gameObj.remove(ast);
	            	gameObj.remove(msl);
	            	System.out.println("PlayerShip destroyed an Asteroid");
	            	playerScore += 5;
	            }
	            else if(msl != -1 && ast != -1 && ast < msl){
	            	gameObj.remove(msl);
	            	gameObj.remove(ast);
	            	System.out.println("PlayerShip destroyed an Asteroid");
	            	playerScore += 5;
	            }
	    }
		}
	}

	/**
	 * A PlayerShip's Missile has destroyed an NonPlayerShip,
	 * Missile and NonPlayerShip removed from game,
	 * player score + 10.
	 */
	public void psMissileHitNPS()     {
		if (misObj == 0) {System.out.println("Error: No missiles to explose NPS");}
		else if(npship == 0) {System.out.println("Error: There are no NPS to explode");}
		else {
		Missile m = null;
	    int msl = -1;
	    int nps = -1;
	    
	    for (int i = 0; i < gameObj.size(); i++) {
	            if (gameObj.elementAt(i) instanceof Missile && msl == -1) {
	                m = (Missile) gameObj.elementAt(i);
	            	if(m.getMissileType())	{
	            		msl = i;
	             	}
	            }
	            if (gameObj.elementAt(i) instanceof NonPlayerShip && nps == -1)	{
	                	nps = i;
	            }
	            if (msl != -1 && nps != -1 && msl < nps)	{
	            	gameObj.remove(nps);
	            	gameObj.remove(msl);
	            	System.out.println("PlayerShip destroyed a NonPlayerShip");
	            	playerScore += 10;
	            }
	            else if(msl != -1 && nps != -1 && nps < msl){
	            	gameObj.remove(msl);
	            	gameObj.remove(nps);
	            	System.out.println("PlayerShip destroyed a NonPlayerShip");
	            	playerScore += 10;
	            }
	    }
		}
	}

	/**
	 * A NonPlayerShip's Missile has hit the PlayerShip,
	 * removing the PlayerShip from the world and removing one of 
	 * the players lives.
	 */
	public void npsMissileHitPS() {
		if (!pship) {System.out.println("Error: No PlayerShip to explode");}
		else if(npship == 0) {System.out.println("Error: No NPS on the map");}
	else if(npsMis == 0) {System.out.println("Error: The NPS hasn't shot any Missiles");}
	else {
		Missile m = null;
	    int msl = -1;
	    int ps = -1;
	    
	    for (int i = 0; i < gameObj.size(); i++) {
	            if (gameObj.elementAt(i) instanceof Missile && msl == -1) {
	                m = (Missile) gameObj.elementAt(i);
	            	if(!m.getMissileType())	{
	            		msl = i;
	             	}
	            }
	            if (gameObj.elementAt(i) instanceof PlayerShip && ps == -1)	{
	                	ps = i;
	            }
	            if (msl != -1 && ps != -1 && msl < ps)	{
	            	gameObj.remove(ps);
	            	gameObj.remove(msl);
	            	System.out.println("A NonPlayerShip's Missile has destroyed the PlayerShip");
	            	pship = false;
	            	playerLives--;
	            	if(playerLives == 0)	{
	            		System.out.println("GameOver");
	            		printDisplay();
	            		System.exit(0);
	            	}
	            	else	{
	            	playerLives -= 1;
	            	}
	            }
	            else if(msl != -1 && ps != -1 && ps < msl)	{
	            	gameObj.remove(msl);
	            	gameObj.remove(ps);
	            	System.out.println("A NonPlayerShip's Missile has destroyed the PlayerShip");
	            	pship = false;
	            	playerLives--;
	            	if(playerLives == 0)	{
	            		System.out.println("GameOver");
	            		printDisplay();
	            		System.exit(0);
	            	}
	            	else	{
	            	playerLives -= 1;
	            	}
	            }
	    }
	}
	}

	/**
	 * The PlayerShip has collided with an Asteroid,
	 * removing both from the game world and removing
	 * a player life
	 */
	public void psHitAsteroid() {
		if (!pship) {System.out.println("Error: There is no ship on the map");}
		else if (astObj == 0) {System.out.println("Error: There is no Asteroid on the map");}
		else {
		Asteroid a = null;
	    int ast = -1;
	    int ps = -1;
	    
	    for (int i = 0; i < gameObj.size(); i++) {
	            if (gameObj.elementAt(i) instanceof Asteroid && ast == -1) {
	                a = (Asteroid) gameObj.elementAt(i);
	                ast = i;
	            }
	            if (gameObj.elementAt(i) instanceof PlayerShip && ps == -1)	{
	                	ps = i;
	            }
	            if (ast != -1 && ps != -1 && ast < ps)	{
	            	gameObj.remove(ps);
	            	gameObj.remove(ast);
	            	System.out.println("PlayerShip collided with an Asteroid");
	            	if(playerLives <= 0)	{
	            		System.out.println("GameOver");
	            		printDisplay();
	            		System.exit(0);
	            	}
	            	else	{
	            	playerLives -= 1;
	            	}
	            }
	            else if(ast != -1 && ps != -1 && ps < ast){
	            	gameObj.remove(ast);
	            	gameObj.remove(ps);
	            	System.out.println("PlayerShip collided with an Asteroid");
	            	if(playerLives <= 0)	{
	            		System.out.println("GameOver");
	            		printDisplay();
	            		System.exit(0);
	            	}
	            	else	{
	            	playerLives -= 1;
	            	}
	            }
	    }
		}
		
	}

	/**
	 * A PlayerShip collided with a NonPLayerShip,
	 * removing the PlayerShip and NonPlayerShip from the world
	 * and removing a player life
	 */
	public void psHitNPS() {
		if (!pship) {System.out.println("Error: There is no ship on the map");}
		else if (npship == 0) {System.out.println("Error: There is no NPS on the map");}
		else {
	    int nps = -1;
	    int ps = -1;
	    
	    for (int i = 0; i < gameObj.size(); i++) {
	            if (gameObj.elementAt(i) instanceof PlayerShip && ps == -1) {
	                ps = i;
	            }
	            if (gameObj.elementAt(i) instanceof NonPlayerShip && nps == -1)	{
	                	nps = i;
	            }
	            if (nps != -1 && ps != -1 && nps < ps)	{
	            	gameObj.remove(ps);
	            	gameObj.remove(nps);
	            	System.out.println("PlayerShip collided with a NonPlayerShip");
	            	if(playerLives <= 0)	{
	            		System.out.println("GameOver");
	            		printDisplay();
	            		System.exit(0);
	            	}
	            	else	{
	            	playerLives -= 1;
	            	}
	            }
	            else if(nps != -1 && ps != -1 && ps < nps){
	            	gameObj.remove(nps);
	            	gameObj.remove(ps);
	            	System.out.println("PlayerShip collided with a NonPlayerShip");
	            	if(playerLives <= 0)	{
	            		System.out.println("GameOver");
	            		printDisplay();
	            		System.exit(0);
	            	}
	            	else	{
	            	playerLives -= 1;
	            	}
	            }
	    }
		}
	}
	
	/**
	 * Two Asteroids collide removing both from the world
	 */
	public void twoAsteroidsCollide() {
		if (astObj < 2) {System.out.println("Error: Less than two asteroids created");}
		else {
		int ast;
		int astArr[] = new int[5];
		int j = 0;
		for(int i=0; i <gameObj.size(); i++) {
			if (gameObj.elementAt(i) instanceof Asteroid && j >= 0) {
                astArr[j] = i;
                ++j;
            }
		}
			gameObj.remove(astArr[j-1]);
			gameObj.remove(astArr[j-2]);
			System.out.println("An Asteroid collided with another Asteroid");
		}
	}
	
	/**
	 * An Asterpoid collides with a NonPlayerShip removing both from the world
	 */
	public void asteroidHitNPS() {
		if (astObj == 0) {System.out.println("Error: There are no Asteroids in the world");}
	else if(npship == 0) {System.out.println("Error: There are no Asteroids in the world");}
		
	    else {
	    	int nps = -1;
		    int ast = -1;
	    for (int i = 0; i < gameObj.size(); i++) {
	            if (gameObj.elementAt(i) instanceof Asteroid && ast == -1) {
	                ast = i;
	            }
	            if (gameObj.elementAt(i) instanceof NonPlayerShip && nps == -1)	{
	                nps = i;
	            }
	            if (nps != -1 && ast != -1 && nps < ast)	{
	            	gameObj.remove(ast);
	            	gameObj.remove(nps);
	            	System.out.println("An Asteroid collided with a NonPlayerShip");
	            }
	            else if(nps != -1 && ast != -1 && ast < nps){
	            	gameObj.remove(nps);
	            	gameObj.remove(ast);
	            	System.out.println("An Asteroid collided with a NonPlayerShip");
	            }
	            	
	    }
	    }
		
	}

	/**
	 * Returns the PlayerShip to the center of the map
	 */
	public void hyperspaceJump() {
		if (!pship) {System.out.println("Error: No PlayerShip to enter hyperspace");}
		else {
		PlayerShip p = null;
		Point2D center = new Point2D(512,384);
		for (int i = 0; i < gameObj.size(); i++) {
			if(gameObj.elementAt(i) instanceof PlayerShip)	{
				p = (PlayerShip) gameObj.elementAt(i);
				p.setLocation(center);
				System.out.println("PlayerShip has entered hyperspace");
			}
		}
		}
		
	}

	/**
	 * Increases the PlayerShips speed
	 */
	public void increaseSpeed() {
		if (!pship) {System.out.println("Error: No PlayerShip to speed up");}
		else {
		PlayerShip p = null;
		for (int i = 0; i < gameObj.size(); i++) {
			if(gameObj.elementAt(i) instanceof PlayerShip)	{
				p = (PlayerShip) gameObj.elementAt(i);
				p.increaseSpeed();
				
			}
		}
		}
	}

	/**
	 * Decreases the PlayerShips speed
	 */
	public void decreaseSpeed() {
		if (!pship) {System.out.println("Error: No PlayerShip to slow down");}
		else {
		PlayerShip p = null;
		for (int i = 0; i < gameObj.size(); i++) {
			if(gameObj.elementAt(i) instanceof PlayerShip)	{
				p = (PlayerShip) gameObj.elementAt(i);
				p.decreaseSpeed();
				System.out.println("PlayerShip is going slower");
			}
		}
		}
	}
	/**
	 * Turns the PlayerShip left
	 */
	public void turnShipLeft() {
		if (!pship) {System.out.println("Error: No PlayerShip to turn");}
		else {
		PlayerShip ps = null;
		for(int i=0; i <gameObj.size(); i++) {
			if (gameObj.elementAt(i) instanceof PlayerShip) {
                ps = (PlayerShip) gameObj.elementAt(i);
                ps.steerLeft();
                System.out.println("PlayerShip turn left");
            }
		}
		}
	}
	
	/**
	 * Turns the PlayerShip right
	 */
	public void turnShipRight() {
		if (!pship) {System.out.println("Error: No PlayerShip to turn");}
		else {
		PlayerShip ps = null;
		for(int i=0; i <gameObj.size(); i++) {
			if (gameObj.elementAt(i) instanceof PlayerShip) {
                ps = (PlayerShip) gameObj.elementAt(i);
                ps.steerRight();
                System.out.println("PlayerShip turn right");
            }
		}
		}
	}
	/**
	 * MoveableObjects move(), missile fuel decreases or burns out
	 * Space Station light blinks, gameClock increases
	 */
	public void clockTicked() {
		for (int i=0; i<gameObj.size(); i++) {    
			if (gameObj.elementAt(i) instanceof IMove) {     
				IMove mObj = (IMove)gameObj.elementAt(i);
				mObj.move(); 
				System.out.println("MoveableObject has moved");
			}
			if(gameObj.elementAt(i) instanceof Missile)	{
				Missile ms = (Missile)gameObj.elementAt(i);
				if(ms.getFuelLevel()==0)	{
					gameObj.removeElement(ms);
					System.out.println("A missile has been removed");
				}
				else	{
					ms.decrementFuelLevel();
					System.out.println("A missile has lost fuel");
				}
			}
			if(gameObj.elementAt(i) instanceof SpaceStation)	{
				SpaceStation ss = null;
				ss = (SpaceStation)gameObj.elementAt(i);
				if(clock%ss.getBlinkRate() == 0)	{
					ss.switchLightOnOff();
					System.out.println("The light hast turned on/off");
				}
			}			
		}
		clock++;
		System.out.println("Clock has ticked");
	}
	
	
}
