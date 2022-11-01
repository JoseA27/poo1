package heroes;

public class Magnetismo extends AbstractPower {

	public Magnetismo() {
		this.damage = 20;
	}
	
	@Override
	public void attack() {
		System.out.println("ataco con poder "+this.getDamage());
	}

	@Override
	public void stop() {
		System.out.println("deteniendo el magnetismo");
	}

}
