package robotwar.tecdigital;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class EntregaShooter extends Weapon{
	
	
	public EntregaShooter() {
		super(20, 5, 70);
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
	}
	
	public void restar(int pLevel,double d) {
		
	}
}
