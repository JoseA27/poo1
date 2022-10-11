package plants.climate;

import java.util.ArrayList;
import java.util.Random;
import plants.climate.*;

public class Seasons {
	private String name;
	private int start;
	private int end;
	private ArrayList<SeasonsStatus>status= new  ArrayList<SeasonsStatus>();
	
	public Seasons() {
			
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public void loadStatus(SeasonsStatus st) {
		status.add(st);
	}
	
	public SeasonsStatus returnValues() {
		Random random= new Random();
		int index=random.nextInt(status.size());
		SeasonsStatus currentStatus = status.get(index);
		return currentStatus;
	}
	
}
