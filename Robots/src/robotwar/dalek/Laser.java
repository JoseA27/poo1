package robotwar.dalek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import robotwar.common.robotbase.*;

public class Laser extends Weapon{
	
	public Laser() {
		super(100, 3);
	}

	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
	
	@Override
	public void hitDamage(int pLevel){
		
		Stream<Integer> listaUno = Stream.of(3,4,5);
		Stream<Integer> listaDos = Stream.of(6,7,8);
		Stream<Integer> listaTres = Stream.of(9,10);
	
		listaUno.filter(x->x==pLevel).forEach(x->this.damageLevel-=(this.getDamageLevel()*(pLevel*0.20)));
		listaDos.filter(x->x==pLevel).forEach(x->this.damageLevel-=(this.getDamageLevel()*(pLevel*0.30)));
		listaTres.filter(x->x==pLevel).forEach(x->this.enabled=false);
	}
}
