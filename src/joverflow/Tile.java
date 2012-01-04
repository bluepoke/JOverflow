package joverflow;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.RepaintManager;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Tile extends JLabel implements MouseListener {

    private int value = 2;
    private Player owner = null;
    private Tile neighborTop = null;
    private Tile neighborBottom = null;
    private Tile neighborLeft = null;
    private Tile neighborRight = null;
    private static final Border BORDER_INACTIVE = new LineBorder(Color.BLACK);
    private static final Border BORDER_ACTIVE = new LineBorder(Color.WHITE);


    private static final Color DEFAULT_COLOR = Color.GRAY;
    
    private int threshold = 4;
    
    public Tile() {
	super();
	this.addMouseListener(this);
	this.setText(String.valueOf(value));
	this.setBackground(DEFAULT_COLOR);
	this.setBorder(BORDER_INACTIVE);
	this.setHorizontalAlignment(SwingConstants.CENTER);
	this.setVerticalAlignment(SwingConstants.CENTER);
	
    }

    public void setOwner(Player owner) {
	this.owner = owner;
	if (owner != null) {
	    this.setBackground(owner.getColor());
	    this.setOpaque(true);
	} else {
	    this.setBackground(DEFAULT_COLOR);
	}
    }
    
    public void increaseValue(Player owner) {
	setOwner(owner);
	setBorder(BORDER_ACTIVE);
	value++;
	try {
	    Thread.sleep(50);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	setBorder(BORDER_INACTIVE);
	if (value>threshold) {
	    resetValue();
	    this.repaint();
	    if (neighborTop != null) {
		neighborTop.increaseValue(owner);
	    }
	    if (neighborBottom != null) {
		neighborBottom.increaseValue(owner);
	    }
	    if (neighborLeft != null) {
		neighborLeft.increaseValue(owner);
	    }
	    if (neighborRight != null) {
		neighborRight.increaseValue(owner);
	    }
	}
	setText(String.valueOf(value));
    }
    
    private void resetValue() {
	value = 1;
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
	final Player activePlayer = JOverflow.getActivePlayer();
	if (activePlayer.equals(owner) || owner == null) {
	    SwingWorker<Integer, Integer> incraseSW = new SwingWorker<Integer, Integer>() {

		@Override
		protected Integer doInBackground() throws Exception {
		    increaseValue(activePlayer);
		    return null;
		}
		
	    };
	    incraseSW.execute();
	    
	    JOverflow.switchPlayer();
	}
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
