package robotwar.dalek;

import javax.swing.ImageIcon;

public class AgujeroNegro extends Trap{
	public AgujeroNegro() {
		super(800,400,50,100,10);
		this.imagen = new ImageIcon(this.ruta+"BlackHole.png").getImage();
	}
}
