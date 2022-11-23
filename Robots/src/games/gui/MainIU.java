package games.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import games.controller.MainController;
import robotwar.common.IConstants;
import robotwar.common.robotbase.MOVEMENT;

import java.util.HashMap;
import java.util.Hashtable;

public class MainIU  extends JFrame implements IConstants, ActionListener, KeyListener, Runnable{

	private static final long serialVersionUID = 1L;
	public static String rutaImagenes = "C:\\Users\\josea\\Desktop\\Imagenes poo\\";
	private Image imagen = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Fondo2.jpg").getImage();
	private MainController controller;
	private MoverDalek mover;
	private HashMap<Integer,MOVEMENT> hash = new HashMap<Integer,MOVEMENT>();

	
	public MainIU(String pTitle, MainController pController, int witdh, int height) {
		super(pTitle);
		controller = pController;
		controller.setWindow(this);
		
		this.setSize(witdh,height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		mover = new MoverDalek();
		this.add(mover);

		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
		hash.put(KeyEvent.VK_LEFT,MOVEMENT.LEFT);
		hash.put( KeyEvent.VK_UP,MOVEMENT.UP);
		hash.put( KeyEvent.VK_DOWN,MOVEMENT.DOWN);
		hash.put(KeyEvent.VK_RIGHT,MOVEMENT.RIGHT);
		
		this.setVisible(true);
	}
	
	public void labelTrampa(int x, int y, Image imagen) {
		JLabel labelTrap = new JLabel();
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		labelTrap.setOpaque(true);
		labelTrap.setBounds(0, 0, IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH);
		mover.add(labelTrap);
		mover.getComponent(mover.getComponentCount()-1).getGraphics().drawImage(imagen, x, y, null);
		
		
	}
	public Graphics getRobotPng() {
		return mover.getGraphics();
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("STOP");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();		
		if(c == KeyEvent.VK_SPACE) {
			controller.disparar(null, getRobotPng());
			return;
		}
		if(c == KeyEvent.VK_ENTER) {
			controller.golpear(null, getRobotPng());
			return;
		}
		Graphics g = mover.getGraphics();
		controller.moveDalek(hash.get(e.getExtendedKeyCode()),LocalTime.now(), g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}


	@Override
	public void run() {
		
		while(true) {
			mover.validate();
		}
		
	}
	
}
