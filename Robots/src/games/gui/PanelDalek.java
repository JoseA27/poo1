package games.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelDalek extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	public static String rutaImagenes = "C:\\Users\\josea\\Desktop\\Imagenes poo\\";
	private int x=0;
	private int y=0;
	private int witdh=100;
	private int height=50;
	private int step=10;
	private int maxX, maxY;
	private int xVelocity = 0;
	private int yVelocity = 0;
	private Timer timer = new Timer(5,this);
 	
	public PanelDalek(int x, int y) {
		this.maxX=x;
		this.maxY=y;
		timer.start();
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  Image imagen = new ImageIcon(rutaImagenes+"Fondo.jpg").getImage();
		  g.drawImage(imagen, 0, 0, null);
		
	}
	
	public void paintDalek() {
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image imagen = new ImageIcon(rutaImagenes+"Dalek.png").getImage();
		g.drawImage(imagen, x, y, null);
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		xVelocity=0;
		yVelocity=0;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		
		if(c == KeyEvent.VK_LEFT) {
			xVelocity=-1;
			yVelocity=0;
		}
		if(c == KeyEvent.VK_UP) {
			xVelocity=0;
			yVelocity=-1;
		}
		if(c == KeyEvent.VK_RIGHT) {
			xVelocity= 1;
			yVelocity= 0;
		}
		if(c == KeyEvent.VK_DOWN) {
			xVelocity= 0;
			yVelocity=1;
		}
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(x<0) {
			xVelocity = 0;
			x=0;
		}
		if(x>(maxX-100)) {
			xVelocity=0;
			x= maxX-100;
		}
		if(y<0) {
			yVelocity=0;
			y = 0;
		}
		if(y>(maxY-200)) {
			yVelocity=0;
			y = maxY-200;
		}
		x = x+xVelocity;
		y = y+yVelocity;
		this.repaint();
	}
/*
	public Graphics getRobotDalek() {
		return this.getGraphics();
	}*/
	
}
