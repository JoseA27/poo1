package prueba;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class panel extends JPanel{

	private static final long serialVersionUID = 1L;
	final int originalTitleSize = 16;
	final int scale = 3;
	final int title = originalTitleSize*scale;
	final int rows= 16;
	final int  colmuns = 12;
	private int width;
	private int height;
	
	public panel(int w, int h) {
		this.width=w;
		this.height=h;
		this.setPreferredSize(new Dimension(this.width,this.height));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
	
}
