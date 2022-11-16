package robotwar.dalek;

import java.awt.Image;

import javax.swing.ImageIcon;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Annihilator extends Weapon{
	private Image imagen = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Laser.jpg").getImage();
	
	public Annihilator() {
		super(30, 9, 100);
	}
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
	public Image getImagen() {
		return this.imagen;
	}
}