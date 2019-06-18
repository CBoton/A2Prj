package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.plaf.Border;

public class AButton extends Button{
	
	public AButton(String buttonSays) {
		super(buttonSays);
		this.getAllStyles().setBgTransparency(200);
		this.getUnselectedStyle().setBgColor(ColorUtil.YELLOW);
		this.getAllStyles().setFgColor(ColorUtil.BLACK);
		this.getAllStyles().setPadding(TOP, 5);
		this.getAllStyles().setPadding(BOTTOM, 5);
		this.getAllStyles().setBorder(Border.createLineBorder(1,
				ColorUtil.BLACK));
		
		
		
	}

}
