package joverflow;

import java.awt.Color;

public class Player {

	private Color color;
	private String name;
	
	public Player (String name, Color color) {
	    this.name = name;
	    this.color = color;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof Player) {
		Player playerObj = (Player) obj;
		if (playerObj.getName().equals(name) && playerObj.getColor().equals(color)) {
		    return true;
		}
	    } 
		
	    return false;
	    
	}
}
