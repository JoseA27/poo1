package robotwar.main;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.dalek.*;
import robotwar.gui.Ejemplo_Move_2;
public class program {
	public static void main(String args[]) {
		/*
		Dalek dalek = new Dalek();
		Laser laser = new Laser();
		Laser laser2 = new Laser();
		Laser laser3 = new Laser();
		
		dalek.addWeapon(laser);
		dalek.addStrike(laser2);
		dalek.addStrike(laser3);
		
		//laser.fire(0, 0, null);
		//laser.hitDamage(3);
		
		//dalek.damage(6);
		//dalek.damage(3);
		laser.hitDamage(3);
		laser.hitDamage(6);
		
		System.out.println(laser.getDamageLevel());
		//System.out.println(dalek.getEnergy());*/
		
		//Ejemplo_Move ejemplo = new Ejemplo_Move();
		Ejemplo_Move_2 ejemplo2 = new Ejemplo_Move_2();
		//ejemplo.Simular();
		ejemplo2.Simular();
	}
}
