package robotwar.dalek;

import java.util.concurrent.ThreadLocalRandom;

import robotwar.common.robotbase.DamageLevel;
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Dalek extends IRobot{

	public Dalek(ORIENTATION east) {
		this.setEnergy(100);
	}
	public Dalek() {
		this.setEnergy(100);
	}
	@Override
	public void damage(int pLevel) {
		if(pLevel==1 || pLevel==2) {
			this.setEnergy(this.energy-1);
			return;
		}
		int randomNum = ThreadLocalRandom.current().nextInt(1, 1 + 1);
		
		System.out.println(randomNum);

		switch(randomNum) {
		case 1:
			System.out.println("WEAPON");
			this.getWeapon(this.getWeapon().length-1).hitDamage(pLevel);
			break;
		case 2:
			System.out.println("STRIKE");
			this.getStrike(this.getStrike().length-1).hitDamage(pLevel);
			break;
		case 3:
			System.out.println("ORIENTATION");
			this.getDamageOrientation(this.getDamageLevelOrientation().length).hitDamage(pLevel);;
			break;
		}
	}
	
	public void setEnergy(int energia) {
		this.energy=energia;
	}
	public int getEnergy() {
		return this.energy;
	}
	public void setPosX(int x) {
		this.posX = x;
	}
	public int getPosX() {
		return this.posX;
	}
	public void setPosY(int y) {
		this.posY=y;
	}
	public int getPostY() {
		return this.posY;
	}
	
	public int getWeaponIndex() {
		return this.weaponIndex;
	}
	
	public int getStrikeIndex() {
		return this.strikeIndex;
	}
	
	public Weapon[] getWeapon() {
		return this.weapons;
	}
	public Weapon[] getStrike() {
		return this.strikes;
	}
	public DamageLevel[] getDamageLevelOrientation() {
		return this.directionsdamage;
	}
	public Weapon getWeapon(int index) {
		return this.weapons[index];
	}
	public Weapon getStrike(int index) {
		return this.strikes[index];
	}
	public DamageLevel getDamageOrientation(int pLevel) {
		return this.directionsdamage[pLevel];
	}
}
