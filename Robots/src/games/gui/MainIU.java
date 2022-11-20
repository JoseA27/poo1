package games.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import games.controller.MainController;
import robotwar.common.IConstants;
import robotwar.common.robotbase.MOVEMENT;

public class MainIU  extends JFrame implements IConstants, ActionListener, KeyListener, Runnable{

	private static final long serialVersionUID = 1L;
	public static String rutaImagenes = "C:\\Users\\josea\\Desktop\\Imagenes poo\\";
	private Image imagen = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Dalek.png").getImage();
	private MainController controller;
	private PanelDalek panel;
	private panel background;
	private MoverDalek mover;
	//private Timer timer = new Timer(5,this);

	
	public MainIU(String pTitle, MainController pController, int witdh, int height) {
		super(pTitle);
		controller = pController;
		controller.setWindow(this);
		//timer.start();
		
		this.setSize(witdh,height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//background = new panel(witdh, height);
		//panel = new PanelDalek(witdh, height);
		mover = new MoverDalek();
		//this.add(background);
		this.add(mover);
		//this.add(panel);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		this.setVisible(true);
	}
	
	
	public Graphics getRobotPng() {
		return mover.getGraphics();
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		Graphics g = mover.getGraphics();
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_LEFT) {
			 controller.moveDalek(MOVEMENT.LEFT,LocalTime.now(), g);
		}
		if(c == KeyEvent.VK_UP) {
			controller.moveDalek(MOVEMENT.UP, LocalTime.now(),g);
		}
		if(c == KeyEvent.VK_RIGHT) {
			controller.moveDalek(MOVEMENT.RIGHT, LocalTime.now(),g);
		}
		if(c == KeyEvent.VK_DOWN) {
			controller.moveDalek(MOVEMENT.DOWN, LocalTime.now(),g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}


	@Override
	public void run() {
		
		while(true) {
		}
		
	}
	
}
