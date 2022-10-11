package plants.statuses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import plants.plantaJson;
import plants.Plant;
import plants.simulation.SimulatorReport;
import plants.utils.*;

public class StatusManager implements IObserver, IConstants {
	private ArrayList<Plant> garden;
	private plantaJson reader= new plantaJson();
	private ArrayList<String> imagenes = new ArrayList<String>(); 
	
	
	public StatusManager() {
		garden = new ArrayList<Plant>();
	}	
	
	public void crearPlanta(int index) throws FileNotFoundException, IOException, ParseException {
		garden.add(reader.cargarPlant(index));
	}
	
	public void regar() {
		for(Plant currentPlant : garden) {
			currentPlant.regar();
		}	
	}
	
	public void abonar() {
		for(Plant currentPlant : garden) {
			currentPlant.abonar();
		}	
	}
	public ArrayList<String> imagenes() {
		imagenes.clear();
		for(Plant currentPlant : garden) {
			imagenes.add(currentPlant.actualizarImagen());
		}	
		return imagenes;
	}
	public void evaluate(int pCurrentDays) {
		for(Plant currentPlant : garden) {
			currentPlant.evaluatea(pCurrentDays);
		}		
	}
	
	public void updateTemperature(int cantDays, int temperature) {
		for(Plant currentPlant : garden) {
			currentPlant.setTempClima(temperature);
			
		}
	}

	public void updateWater(int cantDays, int agua) {
		for(Plant currentPlant : garden) {
			currentPlant.setAguaClima(agua);
		}	
	}

	public void updateAbono(int cantDays, int abono) {
		for(Plant currentPlant : garden) {
			currentPlant.setAbonoClima(abono);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		SimulatorReport simReport = (SimulatorReport)arg;
		if (simReport.action.compareTo(UPDATE_DAYS)==0) {
			evaluate(simReport.days);
		}
		if (simReport.action.compareTo(UPDATE_WEATHER)==0) {
			updateTemperature(simReport.days, simReport.temperature);
			updateWater(simReport.days, simReport.rain);
			updateAbono(simReport.days, simReport.abono);
		}
		
	}
}