package joverflow;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Tile extends JLabel implements MouseListener {

    private int value = 4;
    private Player owner = null;
    private Tile neighborTop = null;
    private Tile neighborBottom = null;
    private Tile neighborLeft = null;
    private Tile neighborRight = null;

    private static final Color DEFAULT_COLOR = Color.GRAY;
    
    private int threshold = 4;
    
    public Tile() {
	super();
	this.addMouseListener(this);
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
    
    public void increaseValue() {
	value++;
//	try {
//	    Thread.sleep(100);
//	} catch (InterruptedException e) {
//	    e.printStackTrace();
//	}
	if (value>threshold) {
	    resetValue();
	    this.repaint();
	    if (neighborTop != null) {
		neighborTop.increaseValue();
	    }
	    if (neighborBottom != null) {
		neighborBottom.increaseValue();
	    }
	    if (neighborLeft != null) {
		neighborLeft.increaseValue();
	    }
	    if (neighborRight != null) {
		neighborRight.increaseValue();
	    }
	}
	setText(String.valueOf(value));
    }
    
    private void resetValue() {
	value = 0;
	setText(String.valueOf(value));
    }
    
    public void setNeighbors(Tile top, Tile bottom, Tile left, Tile right) {
	neighborTop = top;
	neighborBottom = bottom;
	neighborLeft = left;
	neighborRight = right;
	recalculateThreshold();
    }

    private void recalculateThreshold() {
	int newThreshold = 0;
	if (neighborTop != null)
	    newThreshold++;
	if (neighborBottom != null)
	    newThreshold++;
	if (neighborLeft != null)
	    newThreshold++;
	if (neighborRight != null)
	    newThreshold++;
	threshold = newThreshold;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	increaseValue();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }
}
