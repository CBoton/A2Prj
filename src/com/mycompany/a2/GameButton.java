package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
/**
 * 
 * @author Daniel Curtis and Curtis Botonis
 *
 */
public class GameButton extends Button{
/**
 * 
 * @param txt 
 * Builds GameButtons to add to West Border
 */
	public GameButton(String txt) {
		super(txt);
		this.getAllStyles().setBgColor(ColorUtil.BLACK);
		this.getAllStyles().setFgColor(ColorUtil.GREEN);
		this.getAllStyles().setPadding(5, 5, 5, 5);
		this.getAllStyles().setBgTransparency(255);
		
	}

}
