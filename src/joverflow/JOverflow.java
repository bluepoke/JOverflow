package joverflow;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.InputEvent;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class JOverflow {
    
    	private static Player player1 = new Player("Player 1", Color.RED);
    	private static Player player2 = new Player("Player 2", Color.YELLOW);
    	private static Player activePlayer = player1;
    	
	private JFrame frmJoverflow;
	private static JLabel lblStatusLabel;
	private static Grid grid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) {
		System.err.println("Could not set system's look and feel.");
	    }
	    EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOverflow window = new JOverflow();
					window.frmJoverflow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JOverflow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJoverflow = new JFrame();
		frmJoverflow.setIconImage(Toolkit.getDefaultToolkit().getImage(JOverflow.class.getResource("/joverflow/img/joverflow.gif")));
		frmJoverflow.setTitle("JOverflow");
		frmJoverflow.setBounds(100, 100, 400, 400);
		frmJoverflow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJoverflow.getContentPane().setLayout(new BorderLayout(0, 0));
		grid = new Grid(8);
		frmJoverflow.getContentPane().add(grid);
		
		lblStatusLabel = new JLabel("New label");
		frmJoverflow.getContentPane().add(lblStatusLabel, BorderLayout.SOUTH);
		
		JMenuBar menuBar = new JMenuBar();
		frmJoverflow.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    System.exit(0);
			}
		});
		
		JMenuItem mntmOptions = new JMenuItem("Options");
		mntmOptions.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
		mnFile.add(mntmOptions);
		mntmQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
		mnFile.add(mntmQuit);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		final JCheckBoxMenuItem chckbxmntmFullscreen = new JCheckBoxMenuItem("Fullscreen");
		chckbxmntmFullscreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			    GraphicsDevice defaultScreenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			    
			    if (chckbxmntmFullscreen.isSelected()) {
				defaultScreenDevice.setFullScreenWindow(frmJoverflow);
			    } else {
				defaultScreenDevice.setFullScreenWindow(null);
			    }
			}
		});
		chckbxmntmFullscreen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.ALT_MASK));
		mnView.add(chckbxmntmFullscreen);		
	}

	public static Player getActivePlayer() {
	    return activePlayer;
	}

	public static void setActivePlayer(Player activePlayer) {
	    JOverflow.activePlayer = activePlayer;
	}

	public static void switchPlayer() {
	    if (activePlayer.equals(player1)) {
		activePlayer = player2;
	    } else {
		activePlayer = player1;
	    }
	    updateStatusbar();
	    
	}

	private static void updateStatusbar() {
	    lblStatusLabel.setText("Player: "+activePlayer.getName());
	    lblStatusLabel.setOpaque(true);
	    lblStatusLabel.setBackground(activePlayer.getColor());
	    
	}
	
	

}
