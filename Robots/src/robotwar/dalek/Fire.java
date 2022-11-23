package robotwar.dalek;

import javax.swing.ImageIcon;

public class Fire extends Trap{
	public Fire() {
		super(400,600,20,40,1);
		this.imagen = new ImageIcon(this.ruta+"Fuego.png").getImage();
	}
}
