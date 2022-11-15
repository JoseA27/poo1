package robotwar.dalek;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.ImageIcon;

import robotwar.common.robotbase.*;

public class Laser extends Weapon{
	
	private Image imagen = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Laser.jpg").getImage();
	
	public Laser() {
		super(100, 3,4000);
	}

	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
	
	public Image getImagen() {
		return this.imagen;
	}
}
