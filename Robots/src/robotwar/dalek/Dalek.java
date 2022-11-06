package robotwar.dalek;

import java.awt.Graphics;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import robotwar.common.robotbase.DamageLevel;
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Dalek extends IRobot{
	
	public Dalek() {
	}
	
	public Dalek(ORIENTATION pOrientation) {
		super(pOrientation);
		this.agregarDamageDirection();
	}

	@Override
	public void move(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		this.updateOrientation(pMove);
		
	}
	
	@Override
	public void damage(int pLevel) {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		switch(randomNum) {
		case 1:
			System.out.println("WEAPON");
			this.getWeapon(ThreadLocalRandom.current().nextInt(0,this.getWeaponIndex()+1)).hitDamage(pLevel);
			break;
		case 2:
			System.out.println("STRIKE");
			this.getStrike(ThreadLocalRandom.current().nextInt(0,this.getStrikeIndex()+1)).hitDamage(pLevel);
			break;
		case 3:
			System.out.println("ORIENTATION");
			this.getDamageOrientation(ThreadLocalRandom.current().nextInt(0,3+1)).hitDamage(pLevel);;
			break;
		}
	}
	public void updateOrientation(MOVEMENT pMove) {
		Arrays.stream(MOVEMENT.values()).filter(x->x==MOVEMENT.LEFT).forEach(x->this.setOrientation(ORIENTATION.WEST));
		Arrays.stream(MOVEMENT.values()).filter(x->x==MOVEMENT.RIGHT).forEach(x->this.setOrientation(ORIENTATION.EAST));
		Arrays.stream(MOVEMENT.values()).filter(x->x==MOVEMENT.UP).forEach(x->this.setOrientation(ORIENTATION.NORTH));
		Arrays.stream(MOVEMENT.values()).filter(x->x==MOVEMENT.DOWN).forEach(x->this.setOrientation(ORIENTATION.SOUTH));
	}
	public void agregarDamageDirection() {
		for (int i=0;i<4;i++) {
			this.directionsdamage[i]= new DamageLevel();
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
	public void setOrientation(ORIENTATION pOrientation) {
		this.currentOrientation=pOrientation;
	}
	public ORIENTATION getOrientation() {
		return this.currentOrientation;
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
