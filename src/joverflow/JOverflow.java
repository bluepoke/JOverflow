package joverflow;

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
import java.awt.event.InputEvent;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JOverflow {

	private JFrame frmJoverflow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frmJoverflow.setTitle("JOverflow");
		frmJoverflow.setBounds(100, 100, 400, 400);
		frmJoverflow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJoverflow.getContentPane().add(new Grid(10));
		
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

}
