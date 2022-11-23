package games.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MoverDalek extends JPanel{

	private static final long serialVersionUID = 1L;
	public static String rutaImagenes = "C:\\Users\\josea\\Desktop\\Imagenes poo\\";
	public MoverDalek() {
		this.setLayout(null);
	}
	
	@Override
	  protected void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  Image imagen = new ImageIcon(rutaImagenes+"Fondo3.png").getImage();
		  g.drawImage(imagen, 0, 0, null);
		
	}
	
	@Override
	public void paint(Graphics g) {
		this.paintComponent(g);
		//super.paint(g);
	}
}
