package robotwar.tecdigital;

import java.awt.Graphics;
import java.time.LocalTime;

import robotwar.common.robotbase.DamageLevel;
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class TecDigital extends IRobot{

	public TecDigital(ORIENTATION east) {
		this.setEnergy(100);
	}
	public TecDigital() {
		this.setEnergy(100);
	}
	@Override
	public void damage(int pLevel) {
		if(pLevel==1 || pLevel==2) {
			this.setEnergy(this.energy-1);
			return;
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
	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		// TODO Auto-generated method stub
		
	}
}

