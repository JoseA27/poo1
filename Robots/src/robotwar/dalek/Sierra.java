package robotwar.dalek;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sierra extends Trap{
	public Sierra() {
		super(100,200,50,100,5);
		this.imagen = new ImageIcon(this.ruta+"sierra2.png").getImage();
	}
}
