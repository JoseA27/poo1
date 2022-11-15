package games.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PngDalek extends JPanel{

	private static final long serialVersionUID = 1L;
	public static String rutaImagenes = "C:\\Users\\josea\\Desktop\\Imagenes poo\\";
	private Image imagen = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Dalek.png").getImage();
	
	public PngDalek() {
		this.setOpaque(true);
	}
	
	
	@Override
	  protected void paintComponent(Graphics g) {
		g.drawImage(imagen, 0, 0, null);
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
	}

}
