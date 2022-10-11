package plants.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import game.controller.MainFrameController;
import game.gui.MainFrame;
import plants.plantaJson;
import plants.climate.StatusClimateManager;
import plants.simulation.Simulator;
import plants.statuses.StatusManager;

public class program {
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {
		
		
		
		StatusManager manager = new StatusManager();
		Simulator sim = new Simulator(manager);
		StatusClimateManager clima = new StatusClimateManager();
		sim.addObserver(manager);
		sim.addObserver(clima);
		clima.setManager(manager);
		MainFrameController controller = new MainFrameController(manager, sim, clima);
		sim.addObserver(controller);
		MainFrame window = new MainFrame("Prueba", controller);
		}
	}
