package game.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import game.gui.MainFrame;
import plants.climate.StatusClimateManager;
import plants.simulation.Simulator;
import plants.simulation.SimulatorReport;
import plants.statuses.StatusManager;
import plants.utils.IObserver;
import plants.utils.Observable;

public class MainFrameController implements IObserver {
	private MainFrame controlledFrame;
	private StatusManager manager;
	private StatusClimateManager climate;
	private Simulator sim;
	
	
	public MainFrameController(StatusManager manejador, Simulator simulador, StatusClimateManager pclimate) {
		this.manager=manejador;
		this.sim=simulador;
		this.climate=pclimate;
		Thread simThread = new Thread(sim);
		simThread.start();
	}
	public void setWindow(MainFrame pframe) {
		controlledFrame= pframe;
	}
	
	public void crearPlanta(int index) throws FileNotFoundException, IOException, ParseException {
		manager.crearPlanta(index);
	}
	
	public void regarPlantas() {
		System.out.println("\nRegando Plantas\n");
		manager.regar();
	}
	
	public void abonarPlantas() {
		System.out.println("\nAbonando Plantas\n");
		manager.abonar();
	}
	
	public ArrayList<String> actualizarImagenes(){
		return manager.imagenes();
	}
	
	@Override
	public void update(Observable pObservable, Object args) {
		SimulatorReport simReport = (SimulatorReport)args;
		controlledFrame.update(simReport.days, climate.getNameSeason(), climate.getNameClima());
		controlledFrame.Planta(actualizarImagenes());
		//actualizarImagenes();
	}
}