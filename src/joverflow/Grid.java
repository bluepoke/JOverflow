package joverflow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * This class represents the grid containing the tiles of the board.
 * 
 * @author pkossek
 * 
 */
public class Grid extends JPanel {

    private Tile[][] tileGrid;
    private Dimension tileSize = new Dimension(20, 20);
    private Border border = new LineBorder(Color.BLACK);
    
    public Grid(int size) {
	// initialize empty grid
	GridLayout gl = new GridLayout(size, size);
	this.setLayout(gl);
	
	Tile t;
	tileGrid = new Tile[size][size];
	for (int row = 0; row<tileGrid.length; row++) {
	    Tile[] tileRow = tileGrid[row];
	    for (int col = 0; col<tileRow.length; col++) {
		t = new Tile();
		tileGrid[row][col] = t; 
		t.setPreferredSize(tileSize);
		t.setBorder(border);
		t.setHorizontalAlignment(SwingConstants.CENTER);
		t.setVerticalAlignment(SwingConstants.CENTER);
		this.add(tileGrid[row][col]);
	    }
	}
    }
    
    public void setTileSize(int width, int height) {
	this.tileSize  = new Dimension(width, height);
	for (int row = 0; row<tileGrid.length; row++) {
	    Tile[] tileRow = tileGrid[row];
	    for (int col = 0; col<tileRow.length; col++) {
		tileGrid[row][col].setPreferredSize(tileSize);
	    }
	}
    }
}
