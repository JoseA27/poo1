package robotwar.common.robotbase;

public class DamageLevel {
	protected double damageLevel;
	protected  boolean enabled;
	
	public DamageLevel() {
		this.damageLevel = 100.0;
		this.enabled = true;
	}

	public double getDamageLevel() {
		return damageLevel;
	}

	public void hitDamage(int pLevel) {
		if(this.isEnabled()==false) {
			return;
		}
		//Si es de nivel 1, afecta a la energia directamente, no al arma o direccion
		/* 
		if(pLevel<3) 
			this.damageLevel--;
		*/
		if(pLevel>=3&& pLevel<=5) {
			this.damageLevel-=(this.getDamageLevel()*(pLevel*0.20));
		}
		if(pLevel>=6 && pLevel<=8){
			this.damageLevel-=(this.getDamageLevel()*(pLevel*0.30));
		}
		if(pLevel==9 || pLevel==10) {
			this.enabled=false;
			return;
		}
		if(this.getDamageLevel()<=0) {
			this.enabled=false;
		}
		// dado el nivel saco el % de daño, lo rebajo
		// evaluo si llegue a cero o menos, pongo el enabled en false
	}

	public boolean isEnabled() {
		return enabled;
	}
	
}
