package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;

public class MapView extends Container implements Observer    {
    private TextField tf;
    
    /**
     * Constructor to add MapView Observer
     */
    public MapView(GameWorld gw)    {
        setLayout(new BorderLayout());
        tf = new TextField();
        tf.setEditable(false);
        this.setHeight(768);
        this.setWidth(1024);
    }
    /**
     * Function to print current Map Data
     * @param obs 
     * @param obj - stores Collection of GameObjects
     */
    public void update(Observable obs, Object obj)    {
    	GameWorldProxy igw = (GameWorldProxy) obj;
    	igw.printMap();
    	this.repaint();
    }
}
