package robotwar.main;
import games.controller.MainController;
import games.gui.MainIU;
import robotwar.common.IConstants;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.dalek.*;
import robotwar.gui.Ejemplo_Move_2;
public class program {
	public static void main(String args[]) throws InterruptedException {
		/*
		
		Laser laser = new Laser();
		Laser laser2 = new Laser();
		Laser laser3 = new Laser();
		
		dalek.addWeapon(laser);
		dalek.addStrike(laser2);
		dalek.addStrike(laser3);
		//laser.hitDamage(3);
		dalek.damage(7);
		//laser.hitDamage(6);
		dalek.move(MOVEMENT.LEFT, null, null);
		System.out.println(dalek);
		System.out.println(laser.getDamageLevel());
		/*
		//System.out.println(dalek.getEnergy());
		*/
		//Ejemplo_Move ejemplo = new Ejemplo_Move();
		
		MainController controller = new MainController();
		MainIU window = new MainIU("Prueba", controller,IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH);
		Dalek dalek = new Dalek(ORIENTATION.EAST, 200);
	

		controller.setDalek(dalek);
		//Ejemplo_Move_2 ejemplo2 = new Ejemplo_Move_2();
		//ejemplo.Simular();
		//ejemplo2.Simular();
	}
}
