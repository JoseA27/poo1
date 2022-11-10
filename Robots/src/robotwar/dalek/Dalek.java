package robotwar.dalek;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import robotwar.common.IConstants;
import robotwar.common.robotbase.DamageLevel;
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Dalek extends IRobot{

	private Image imagen = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Dalek.png").getImage();
	private Image bg = new ImageIcon("C:\\Users\\josea\\Desktop\\Imagenes poo\\Fondo.jpg").getImage();
	private int pixelDistance;
	public Dalek() {
		this.agregarDamageDirection();
		this.setPixelDistance(0);
		this.setEnergy(100);
	}
	
	public Dalek(ORIENTATION pOrientation) {
		super(pOrientation);
		this.agregarDamageDirection();
		this.setPixelDistance(0);
	}

	@Override
	public void move(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		this.updateOrientation(pMove);
		this.validarDistanciaRecorrida();
		if(pMove==MOVEMENT.LEFT) {
			this.setPosX(this.getPosX()-3);
		}
		if(pMove==MOVEMENT.UP) {
			this.setPosY(this.getPostY()-3);
		}
		if(pMove==MOVEMENT.RIGHT) {
			this.setPosX(this.getPosX()+3);
		}
		if(pMove==MOVEMENT.DOWN) {
			this.setPosY(this.getPostY()+3);
		}
		this.validarMove();
		g.drawImage(bg,0,0,null);
		g.drawImage(imagen, this.getPosX(), this.getPostY(), null);
	}
	
	@Override
	public void damage(int pLevel) {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		switch(randomNum) {
		case 1:
			System.err.println("WEAPON");
			this.getWeapon(ThreadLocalRandom.current().nextInt(0,this.getWeaponIndex()+1)).hitDamage(pLevel);
			break;
		case 2:
			System.out.println("STRIKE");
			this.getStrike(ThreadLocalRandom.current().nextInt(0,this.getStrikeIndex()+1)).hitDamage(pLevel);
			break;
		case 3:
			System.out.println("ORIENTATION");
			this.getDamageOrientation(ThreadLocalRandom.current().nextInt(0,3+1)).hitDamage(pLevel);
			break;
		}
	}
	@Override
	public void hit(int pStrikeId, LocalTime pActionTime, Graphics g ) {
		
	}
	
	public void updateOrientation(MOVEMENT pMove) {
		MOVEMENT[][] stream= {{MOVEMENT.UP},{MOVEMENT.DOWN},{MOVEMENT.LEFT},{MOVEMENT.RIGHT}};
		Arrays.stream(stream[0]).filter(x->x==pMove).forEach(x->this.setOrientation(ORIENTATION.NORTH));
		Arrays.stream(stream[1]).filter(x->x==pMove).forEach(x->this.setOrientation(ORIENTATION.SOUTH));
		Arrays.stream(stream[2]).filter(x->x==pMove).forEach(x->this.setOrientation(ORIENTATION.WEST));
		Arrays.stream(stream[3]).filter(x->x==pMove).forEach(x->this.setOrientation(ORIENTATION.EAST));
	}
	
	public void agregarDamageDirection() {
		for (int i=0;i<4;i++) {
			this.directionsdamage[i]= new DamageLevel();
		}
	}
	
	public void validarMove() {
		if(this.getPosX()<0) {
			this.setPosX(0);
		}
		if(this.getPosX()>(IConstants.ARENA_WIDTH-100)) {
			this.setPosX(IConstants.ARENA_WIDTH-100);
		}
		if(this.getPostY()<0) {
			this.setPosY(0);
		}
		if(this.getPostY()>(IConstants.ARENA_HEIGTH-200)) {
			this.setPosY(IConstants.ARENA_HEIGTH-200);
		}
	}
	public void validarDistanciaRecorrida(){
		System.out.println("Pixel: "+this.getPixelDistance());
		this.setPixelDistance(this.getPixelDistance()+1);
		if(this.getPixelDistance()>IConstants.ROBOT_MOVEMENT_LENGTH) {
			this.setPixelDistance(0);
			this.setEnergy(this.getEnergy()-1);
			System.out.println("Energia"+this.getEnergy());
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

	public int getPixelDistance() {
		return pixelDistance;
	}

	public void setPixelDistance(int pixelDistance) {
		this.pixelDistance = pixelDistance;
	}
	
}
