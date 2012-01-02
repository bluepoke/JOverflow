package joverflow;

import javax.swing.JPanel;

/**
 * This class represents the grid containing the tiles of the board.
 * 
 * @author pkossek
 * 
 */
public class Grid extends JPanel {

    private Tile[][] tileGrid;
    
    public Grid(int size) {
	// initialize empty grid
	tileGrid = new Tile[size][size];
	for (int row = 0; row<tileGrid.length; row++) {
	    Tile[] tileRow = tileGrid[row];
	    for (int col = 0; col<tileRow.length; col++) {
		tileGrid[row][col] = new Tile();
	    }
	}
    }
}
