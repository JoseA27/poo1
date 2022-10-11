package plants;

import plants.statuses.PlantStatus;
import plants.statuses.Status;
import plants.statuses.StatusChangeRule;
import plants.utils.IConstants;

import java.time.LocalDate;
import java.util.*;


public class Plant implements IConstants {
	private String name;
	
	private int currentState;
	private int life;
	private int ageDays;
	private ArrayList<StatusChangeRule> reglas=new ArrayList<StatusChangeRule>();
	private ArrayList<Status> imagenes= new ArrayList<Status>();
	private int abono;
	private int agua;
	private int maxAge;
	private int aguaClima;
	private int abonoClima;
	private int tempClima;
	
	public Plant() {
		this.currentState=0;
		this.ageDays=0;
		this.abono=0;
		this.agua=0;
		this.aguaClima=0;
	}
	
	public void evaluatea(int currentDay) {
		ageDays++;
		StatusChangeRule rule = reglas.get(currentState);
		consumoAbono();
		consumoAgua();
		actualizarImagen();
		if(rule.getMaxDays()<=ageDays && getLife()>=rule.getMinLife()) {
			if(currentState<3) {
				this.currentState++;}}
		if(getAgeDays()>getMaxAge() || getLife()<0) {
			this.currentState=3;
		}
		System.out.println(name+": "+life);
	}
	
	public void consumoAbono(){
		StatusChangeRule rule = reglas.get(currentState);
		if(getAbono()>=rule.getMinAbono() && getAbono()<=rule.getMaxAbono()) {
			this.life+=rule.getEfectoAP();
		}
		else {
			this.life=life+rule.getEfectoAN();}
		this.abono-=(1+getAbonoClima());
	}
	
	public void consumoAgua(){
		StatusChangeRule rule = reglas.get(currentState);
		if((rule.getMinWater()+getTempClima())<=getAgua() && (rule.getMaxWater()+getTempClima())>=getAgua()) {
			this.life+=rule.getEfectoWP();
		}
		else {
			this.life=life+rule.getEfectoWN();
		}
		this.agua-=(1+getAguaClima());
	}
	
	public void regar() {
		this.agua+=10;
	}
	public void abonar() {
		this.abono+=10;
	}
	
	public String actualizarImagen() {
		return imagenes.get(currentState).getStatusPictureURL();
	}
	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int age) {
		maxAge = age;
	}
	public int getAgeinDays() {
		return ageDays;
	}
	
	public int getTimeInYears() {
		return ageDays/DAYS_IN_YEARS;
	}
	
	public void addRule(StatusChangeRule rule) {
		reglas.add(rule);
	}
	public void addImagen(Status pic){
		imagenes.add(pic);
		
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getAgua() {
		return agua;
	}
	public void setAgua(int agua) {
		this.agua = agua;
	}
	public int getAbono() {
		return abono;
	}
	public void setAbono(int abono) {
		this.abono = abono;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAgeDays() {
		return ageDays;
	}

	public void setAgeDays(int ageDays) {
		this.ageDays = ageDays;
	}

	public int getAguaClima() {
		return aguaClima;
	}

	public void setAguaClima(int aguaClima) {
		this.aguaClima = aguaClima;
	}

	public int getAbonoClima() {
		return abonoClima;
	}

	public void setAbonoClima(int abonoClima) {
		this.abonoClima = abonoClima;
	}

	public int getTempClima() {
		return tempClima;
	}

	public void setTempClima(int tempClima) {
		this.tempClima = tempClima;
	}
	
	
}