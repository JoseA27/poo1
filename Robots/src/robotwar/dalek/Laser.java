package robotwar.dalek;

import java.util.ArrayList;

import robotwar.common.robotbase.*;

public class Laser extends Weapon{
	
	private 
	
	public Laser() {
		super(100, 3);
	}

	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
	}
	
	@Override
	public void hitDamage(int pLevel){
		if(this.isEnabled()==false) {
			return;
		}/*
		ArrayList<Integer> parametros = new ArrayList<Integer>();
		parametros.add(1);
		parametros
		System.out.print(parametros.get(1));
		*/
		
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(pLevel);
		lista.stream().filter(x->x==1 || x==1)
			.forEach(System.out.println(x));
		if(pLevel<3) 
			this.damageLevel--;
		
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
	}
	
	public void restar(int pLevel,double d) {
		this.damageLevel-=(this.getDamageLevel()*(pLevel*d));
	}
}
