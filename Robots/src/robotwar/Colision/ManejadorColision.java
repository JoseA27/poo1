package robotwar.Colision;

import java.util.ArrayList;
import java.util.Arrays;

import robotwar.common.robotbase.Weapon;
import robotwar.dalek.Trap;
import robotwar.utils.Observable;

public class ManejadorColision extends Observable{
	public ArrayList<Trap> colisiones = new ArrayList<Trap>();
	public ArrayList<Weapon> armasColision = new ArrayList<Weapon>();
	
	public void addColisiones(Trap b) {
		this.colisiones.add(b);
	}
	
	public void validarDamageTrap(int x, int y) {
		colisiones.stream().filter(m->(m.getPosX()+m.getWidth())>=x)
				.filter(m->m.getPosX()<=x)
				.filter(m->(m.getPosY()+m.getHeight())>=y)
				.filter(m->m.getPosY()<=y)
				.forEach(this::hitbox);
	}
	
	public void validarWeaponDamage() {
		
	}
	public void hitbox(Trap colision) {
		DamageReport report = new DamageReport();
		report.pLevel = colision.getLevel();
		notify(report);
	}
}
