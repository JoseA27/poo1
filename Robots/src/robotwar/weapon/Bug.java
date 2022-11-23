package robotwar.weapon;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import robotwar.common.*;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Bug extends Weapon{
	
	private Image imagen = new ImageIcon("").getImage();
	
	
	public Bug() {
		super(50, 5, 10);
	}

	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
	public Image getImagen() {
		return this.imagen;
	}
}
