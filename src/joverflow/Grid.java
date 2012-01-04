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
    private static final int DEFAULT_SIZE = 10;

    public Grid() {
	this(DEFAULT_SIZE);
    }
    
    public Grid(int size) {
	// initialize empty grid
	
	GridLayout gl = new GridLayout(size, size);
	this.setLayout(gl);

	Tile t;
	tileGrid = new Tile[size][size];
	for (int row = 0; row < tileGrid.length; row++) {
	    Tile[] tileRow = tileGrid[row];
	    for (int col = 0; col < tileRow.length; col++) {
		t = new Tile();
		tileGrid[row][col] = t;
		this.add(tileGrid[row][col]);
	    }
	}
	// setup neighbors
	Tile nt, nb, nl, nr; // neighbors top, bottom, left, right
	for (int row = 0; row < tileGrid.length; row++) {
	    Tile[] tileRow = tileGrid[row];
	    for (int col = 0; col < tileRow.length; col++) {
		t = tileGrid[row][col];
		if (row > 0) {
		    nt = tileGrid[row - 1][col];
		} else {
		    nt = null;
		}
		if (row < tileGrid.length - 1) {
		    nb = tileGrid[row + 1][col];
		} else {
		    nb = null;
		}
		if (col > 0) {
		    nl = tileGrid[row][col-1];
		} else {
		    nl = null;
		}
		if (col < tileRow.length-1) {
		    nr = tileGrid[row][col+1];
		} else {
		    nr = null;
		}
		t.setNeighbors(nt, nb, nl, nr);
	    }
	}
    }

    public void resizeTiles() {
	for (int row = 0; row < tileGrid.length; row++) {
	    Tile[] tileRow = tileGrid[row];
	    for (int col = 0; col < tileRow.length; col++) {
		tileGrid[row][col].resize();
		
	    }
	}
    }
}
