package games.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import games.controller.MainController;
import robotwar.common.IConstants;
import robotwar.common.robotbase.MOVEMENT;

public class MainIU  extends JFrame implements IConstants, ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	public static String rutaImagenes = "C:\\Users\\josea\\Desktop\\Imagenes poo\\";
	private Image imagen = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Dalek.png").getImage();
	private MainController controller;
	private PanelDalek panel;
	private panel background;
	private MoverDalek mover;
	private Timer timer = new Timer(5,this);
	private int x;
	private int y;
	
	public MainIU(String pTitle, MainController pController, int witdh, int height) {
		super(pTitle);
		controller = pController;
		controller.setWindow(this);
		timer.start();
		
		this.setSize(witdh,height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setX(0);
		this.setY(0);
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
		mover.repaint();
		mover.validate();
		
		if(mover.getComponentCount()==0) {
			JLabel label = new Label(IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH);
			mover.add(label);
			mover.getComponent(0).getGraphics().drawImage(imagen, this.x, this.y, null);
			System.out.println("\nXXXX"+x);
		}
		
		
		Graphics g = mover.getComponent(0).getGraphics();
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_LEFT) {
			 this.setX(controller.getXDalek(MOVEMENT.LEFT, g));
			
			//controller.moveDalek(MOVEMENT.LEFT, g);
		}
		if(c == KeyEvent.VK_UP) {
			this.setY(controller.getYDalek(MOVEMENT.UP, g));
			//controller.moveDalek(MOVEMENT.UP, g);
		}
		if(c == KeyEvent.VK_RIGHT) {
			this.setX(controller.getXDalek(MOVEMENT.RIGHT, g));
			//controller.moveDalek(MOVEMENT.RIGHT, g);
		}
		if(c == KeyEvent.VK_DOWN) {
			this.setY(controller.getYDalek(MOVEMENT.DOWN, g));
			//controller.moveDalek(MOVEMENT.DOWN, g);
		}
		//mover.getComponent(0).repaint();
		//mover.repaint();
		mover.validate();
		mover.remove(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
