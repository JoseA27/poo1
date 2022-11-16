package robotwar.dalek;
import javax.swing.ImageIcon;
import java.awt.Image;



import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Piroflame extends Weapon{
	private Image imagen = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Fuego.jpg").getImage();
	
	public Piroflame() {
		super(70, 5, 300);
	}
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
	public Image getImagen() {
		return this.imagen;
	}
}
