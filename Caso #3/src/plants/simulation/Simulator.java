package plants.simulation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import plants.climate.SeasonsStatus;
import plants.statuses.StatusManager;
import plants.utils.*;

public class Simulator extends Observable implements Runnable, IConstants {
	private LocalTime startedTime;
	private boolean running = false;
	private StatusManager plantManager;
	private int currentRain;
	private int currentTemperature;
	private LocalTime weatherLastUpdate;
	private int dayPass;
	private ArrayList<SeasonsStatus>estaciones;
	
	
	public Simulator(StatusManager pManager) {
		this.plantManager = pManager;
	}
	
	@Override
	public void run() {
		startedTime = LocalTime.now();
		LocalDate currentTime;
		running = true;
		while (running) {
			try {			
				System.out.println("Han pasado "+dayPass+" dias");
				
				Thread.sleep(CHECKIN_TIME);
				dayPass = (int)ChronoUnit.MILLIS.between(startedTime, LocalTime.now()) / DAY_IN_MILLIS;
				
				SimulatorReport report = new SimulatorReport();
				report.action = UPDATE_DAYS;
				report.days = dayPass;
				
				if (dayPass>=DAYS_IN_YEARS) {
					stop();
				}
				
				this.notify(report);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void stop() {
		running = false;
	}
	

}