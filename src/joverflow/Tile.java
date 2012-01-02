package joverflow;

import java.awt.Color;

import javax.swing.JLabel;

public class Tile extends JLabel {

    private int value = 0;
    private Player owner = null;

    private static final Color DEFAULT_COLOR = Color.GRAY;
    
    public Tile() {
	super();
	this.setText(String.valueOf(value));
	this.setBackground(DEFAULT_COLOR);
    }

    public void setOwner(Player owner) {
	this.owner = owner;
	if (owner != null) {
	    this.setBackground(owner.getColor());
	} else {
	    this.setBackground(DEFAULT_COLOR);
	}
    }
}
