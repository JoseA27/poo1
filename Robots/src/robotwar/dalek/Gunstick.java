package robotwar.dalek;

import java.awt.Image;

import javax.swing.ImageIcon;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Gunstick extends Weapon{
	private Image imagen = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Fuego.jpg").getImage();
	
	public Gunstick() {
		super(70, 1, 100);
	}
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
	public Image getImagen() {
		return this.imagen;
	}
}

