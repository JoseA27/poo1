package robotwar.weapon;

import java.awt.Image;

import javax.swing.ImageIcon;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class PaginaCaida extends Weapon{
	private Image imagen = new ImageIcon("").getImage();
	
	
	public PaginaCaida() {
		super(20, 5, 20);
	}

	
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
	public Image getImagen() {
		return this.imagen;
	}
}
