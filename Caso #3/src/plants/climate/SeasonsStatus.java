package plants.climate;

public class SeasonsStatus {
	public String name;
	public int water;
	public int abono;
	private int temp;
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getAbono() {
		return abono;
	}
	public void setAbono(int abono) {
		this.abono = abono;
	}
}
