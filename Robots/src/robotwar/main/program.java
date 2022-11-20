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
		
		
		MainController controller = new MainController();
		MainIU window = new MainIU("Prueba", controller,IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH);
		Dalek dalek = new Dalek(ORIENTATION.EAST, 200);
		controller.setDalek(dalek);
		window.run();
		
		
		//Ejemplo_Move_2 ejemplo2 = new Ejemplo_Move_2();
		//ejemplo.Simular();
		//ejemplo2.Simular();
	}
}
