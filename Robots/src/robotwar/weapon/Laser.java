package robotwar.weapon;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.ImageIcon;

import robotwar.common.robotbase.*;

public class Laser extends Weapon{
	
	public Laser() {
		super(100, 3,500);
		this.setPosX(0);
		this.setPosY(0);
	}
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		this.posX=0;
		this.posY = 0;
		ORIENTATION[][] orientationSet = {{ORIENTATION.NORTH, ORIENTATION.SOUTH},{ORIENTATION.EAST,ORIENTATION.WEST}};
		int[] array = {-1,1,1,-1};	
		System.out.println(pDirection);
		Arrays.stream(orientationSet[1]).filter(x->x==pDirection)
			.forEach(x->setPosX(this.posX + this.attackDistance*array[pDirection.getValue()]));
		Arrays.stream(orientationSet[0]).filter(x->x==pDirection)
			.forEach(x->setPosY(this.posY + this.attackDistance*array[pDirection.getValue()]));
	}
}
