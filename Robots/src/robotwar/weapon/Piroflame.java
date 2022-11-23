package robotwar.weapon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Arrays;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Piroflame extends Weapon{
	
	public Piroflame() {
		super(100, 6,500);
		this.setPosX(0);
		this.setPosY(0);
	}
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		this.posX=0;
		this.posY=0;
		ORIENTATION[][] orientationSet = {{ORIENTATION.NORTH, ORIENTATION.SOUTH},{ORIENTATION.EAST,ORIENTATION.WEST}};
		int[] array = {-1,1,1,-1};	
		System.out.println(pDirection);
		Arrays.stream(orientationSet[1]).filter(x->x==pDirection)
			.forEach(x->setPosX(this.posX + this.attackDistance*array[pDirection.getValue()]));
		Arrays.stream(orientationSet[0]).filter(x->x==pDirection)
			.forEach(x->setPosY(this.posY + this.attackDistance*array[pDirection.getValue()]));
		System.out.println("X=" + this.posX + "Y=" + this.posY );
	}
}
