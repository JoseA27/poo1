package games.controller;

import java.awt.Graphics;
import java.time.LocalTime;
import games.gui.*;
import robotwar.Colision.ManejadorColision;
import robotwar.common.IConstants;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.dalek.Dalek;
import robotwar.dalek.Trap;
import robotwar.utils.Observable;

public class MainController extends Observable implements IConstants{
	private MainIU controlledFrame;
	private Dalek dalek;
	private ManejadorColision manejador;
	
	
	
	public void setWindow(MainIU pframe) {
		controlledFrame= pframe;
	}
	public void moveDalek(MOVEMENT pmove, LocalTime pTime, Graphics g) {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dalek.move(pmove, pTime, g);
		manejador.validarDamageTrap(dalek.getPosX(),dalek.getPostY());
	}
	public void disparar(LocalTime pTime, Graphics g) {
		dalek.fire(0, null, g);
	}
	public void golpear(LocalTime pTime, Graphics g) {
		dalek.hit(0, null, g);
	}
	public Dalek getDalek() {
		return dalek;
	}
	public void setDalek(Dalek dalek) {
		this.dalek = dalek;
	}
	public void setManejadorColision(ManejadorColision manejador) {
		this.manejador = manejador;
	}
	public void agregarTrampas(Trap trampa) {
		controlledFrame.labelTrampa(trampa.getPosX(), trampa.getPosY(), trampa.getImagen());
		manejador.addColisiones(trampa);
	}
}
