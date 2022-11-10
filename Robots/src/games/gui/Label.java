package games.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		repaint();
	}
}
