package robotwar.dalek;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Hashtable;
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
	private LocalTime currentTime;
	
	public Dalek() {
		this.agregarDamageDirection();
		this.setPixelDistance(0);
		this.setEnergy(100);
		this.setSpeed(90);
	}
	
	public Dalek(ORIENTATION pOrientation, int speed) {
		super(pOrientation, speed);
		this.agregarDamageDirection();
		this.setPixelDistance(0);
		this.setEnergy(100);
	}

	@Override
	public void move(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		if(this.getEnergy()<0) {
			return;
		}
		this.updateOrientation(pMove);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 int distancia = ((int)ChronoUnit.MILLIS.between(pActionTime, LocalTime.now()) * this.getSpeed() )/1000;
		 System.out.println(distancia);
		System.out.println(LocalTime.now());
		System.out.println(pActionTime);
		this.validarDistanciaRecorrida(distancia);
		MOVEMENT[][] stream= {{MOVEMENT.UP,MOVEMENT.DOWN},{MOVEMENT.LEFT,MOVEMENT.RIGHT}};
		int[] array = {-1,1,-1,1};
		
		Arrays.stream(stream[1]).filter(x->x.getValue()==pMove.getValue())
			.forEach(x->setPosX(this.posX + distancia*array[pMove.getValue()]));
		Arrays.stream(stream[0]).filter(x->x.getValue()==pMove.getValue())
			.forEach(x->setPosY(this.posY + distancia*array[pMove.getValue()]));
		this.refreshMove(pMove, pActionTime, g);
	}
	@Override
	protected void refreshMove(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		this.validarMove();
		System.out.println(this.getPostY()+" + "+this.getPosX());
		g.drawImage(imagen, this.getPosX(), this.getPostY(), null);
		g.dispose();
		
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
		Object [][] array = {{0,IConstants.ARENA_WIDTH},{0, IConstants.ARENA_HEIGTH-200}};
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
	public void validarDistanciaRecorrida(int pDistancia){
		this.setPixelDistance(this.getPixelDistance()+pDistancia);
		System.out.println("Pixel: "+this.getPixelDistance() + "\t"+this.getEnergy());
		
		if(this.getPixelDistance()>IConstants.ROBOT_MOVEMENT_LENGTH) {
			this.setPixelDistance(0);
			this.setEnergy(this.getEnergy()-1);
			System.out.println("Energia"+this.getEnergy());
		}
	}
	
	//Attacks
	
	public void ataque(int pStrikeId, Graphics g ) {
		Weapon arma = this.getStrike(pStrikeId);
		//g.drawImage(arma.getImage(),arma.getPosX(), this.getPostY(), null);
		hit(pStrikeId, null, g);
	}
	
	public void disparo(int pWeaponId, Graphics g ) {
		Weapon arma = this.getWeapon(pWeaponId);
		//g.drawImage(arma.getImage(),arma.getPosX(), this.getPostY(), null);
		fire(pWeaponId, null, g);
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
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return this.speed;
	}
	
}
