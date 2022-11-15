package games.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel{
	
	private static final long serialVersionUID = 1L;
	public static String rutaImagenes = "C:\\Users\\josea\\Desktop\\Imagenes poo\\";
	private int x;
	private int y;
	
	public Label(int witdh, int height) {
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0,0,witdh, height);
		//this.setLocation(0, 0);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		repaint();
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
