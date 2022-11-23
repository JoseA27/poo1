package robotwar.dalek;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import robotwar.Colision.DamageReport;
import robotwar.common.IConstants;
import robotwar.common.robotbase.DamageLevel;
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.dalek.Dalek;
import robotwar.utils.IObserver;
import robotwar.utils.Observable;

public class TecDigital extends IRobot implements IObserver, Serializable{

	private static final long serialVersionUID = 1L;
	private static TecDigital tec;
	private String ruta = "C:\\Users\\josea\\Desktop\\Imagenes poo\\";	
	private HashMap <MOVEMENT, ORIENTATION> movementSet = new HashMap<MOVEMENT, ORIENTATION>(); 
	private int pixelDistance;
	private int witdh = 100;
	private int height = 145;
	
	
	private TecDigital() {
		this.agregarDamageDirection();
		this.setPixelDistance(0);
		this.setEnergy(100);
		this.setSpeed(90);
	}
	
	private TecDigital(ORIENTATION pOrientation, int speed) {
		super(pOrientation, speed);
		this.agregarDamageDirection();
		this.setPixelDistance(0);
		this.setEnergy(100);
		movementSet.put(MOVEMENT.UP, ORIENTATION.NORTH);
		movementSet.put(MOVEMENT.DOWN, ORIENTATION.SOUTH);
		movementSet.put(MOVEMENT.RIGHT, ORIENTATION.EAST);
		movementSet.put(MOVEMENT.LEFT, ORIENTATION.WEST);
	}
	public static TecDigital getInstante() {
		if (tec==null) {
			tec = new TecDigital(ORIENTATION.EAST, 100);
		}
		return tec;
	}
	@Override
	public void move(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		this.setOrientation(movementSet.get(pMove));
		
		if(!this.getDamageOrientation(movementSet.get(pMove).getValue()).isEnabled() ||this.getEnergy()<0)
			return;
		
		int distancia = ((int)ChronoUnit.MILLIS.between(pActionTime, LocalTime.now()) * this.getSpeed() )/IConstants.ROBOT_MOVEMENT_LENGTH;
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
		g.drawImage(new ImageIcon(this.ruta + "Dalek.png").getImage(), this.getPosX(), this.getPostY(), null);
		g.drawRect(this.getPosX(), this.getPostY(), 100, 145);
	}
	@Override
	public void damage(int pLevel) {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		switch(randomNum) {
		case 1:
			System.out.println("asasasasassasa");
			this.weapons[ThreadLocalRandom.current().nextInt(0,this.getWeaponIndex()+1)].getLevel();
			break;
		case 2:
			System.out.println("mmmmmmmmmmmmmmmm");
			this.strikes[ThreadLocalRandom.current().nextInt(0,this.getStrikeIndex()+1)].getLevel();
			break;
		case 3:
			//this.getDamageOrientation(ThreadLocalRandom.current().nextInt(0,3+1)).hitDamage(pLevel);
			break;
		default:
			//this.getDamageOrientation(ThreadLocalRandom.current().nextInt(0,3+1)).hitDamage(pLevel);
			break;
		}
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
	@Override
	public void hit(int pStrikeId, LocalTime pActionTime, Graphics g  ) {
		if(!this.strikes[pStrikeId].isEnabled())
			return;
		super.hit(pStrikeId, pActionTime, g);
		Weapon arma = this.strikes[pStrikeId];
		System.out.println(arma.getPosX());
		g.setColor(Color.blue);
		g.draw3DRect(this.getPosX(),this.getPostY(), (arma.getPosX()+this.posX), (arma.getPosY()+this.posY), true);
	}
	
	@Override
	public void fire(int pWeaponId, LocalTime pActionTime, Graphics g) {
		if(!this.weapons[pWeaponId].isEnabled())
			return;
		super.fire(pWeaponId, pActionTime, g);
		Weapon arma = this.weapons[pWeaponId];
		g.setColor(Color.red);
		g.drawLine(this.getPosX(),this.getPostY(), (arma.getPosX()+this.posX), (arma.getPosY()+this.posY));
	}
	
	@Override
	public void update(Observable pObservable, Object args) {
		DamageReport report = (DamageReport) args;
		this.damage(report.pLevel);
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
	public DamageLevel getDamageOrientation(int index) {
		return this.directionsdamage[index];
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

	public int getWitdh() {
		return witdh;
	}

	public int getHeight() {
		return height;
	}
	
}

