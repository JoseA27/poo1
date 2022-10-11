package plants.climate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import plants.plantaJson;
import plants.simulation.Simulator;
import plants.simulation.SimulatorReport;
import plants.statuses.StatusChangeRule;
import plants.statuses.StatusManager;
import plants.utils.IConstants;
import plants.utils.IObserver;
import plants.utils.Observable;

public class StatusClimateManager implements IObserver, IConstants{
	private Simulator sim;
	private ArrayList<Seasons> seasons=new ArrayList<Seasons>();
	private plantaJson reader= new plantaJson();
	private StatusManager manager;
	private int currentDay;
	private int currentSeason;
	private int currentRain;
	private int currentTemperature;
	private int currentAbono;
	private String nameSeason;
	private String nameClima;
	
	public StatusClimateManager() throws FileNotFoundException, IOException, ParseException {
		this.seasons=reader.cargarSeasons();
		this.currentDay=0;
		this.currentSeason=0;
	}
	
	@Override
	public void update(Observable pObservable, Object args) {
		SimulatorReport simReport = (SimulatorReport)args;
		currentDay=simReport.days;
		
		if (getCurrentDay()%3==0) {
			Seasons season = seasons.get(currentSeason);
			
			if (getCurrentDay()>=season.getEnd()) {
				if (getCurrentSeason()<3) {
					this.currentSeason++;
				}
			}
			nameSeason=season.getName();
			System.out.println(season.getName());
			SeasonsStatus condition=season.returnValues();
			System.out.println(condition.getName());
			nameClima = condition.getName();
			updateWeather(condition.getTemp(),condition.getWater(), condition.getAbono());
		}
	}
	
	
	public void updateWeather(int pTemp, int pRain, int pAbono) {
		this.currentTemperature = pTemp;
		this.currentRain = pRain;
		this.currentAbono= pAbono;
		
		SimulatorReport report = new SimulatorReport();
		report.action = UPDATE_WEATHER;
		report.rain = pRain;
		report.temperature = pTemp;
		report.abono = pAbono;
		report.days = currentDay;
		
		manager.update(sim, report);
	}
	
	
	public int getCurrentDay() {
		return currentDay;
	}

	public int getCurrentSeason() {
		return currentSeason;
	}

	public void setManager(StatusManager manager) {
		this.manager = manager;
	}

	public String getNameSeason() {
		return nameSeason;
	}

	public String getNameClima() {
		return nameClima;
	}
	
}
