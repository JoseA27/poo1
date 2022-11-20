package games.controller;

import java.awt.Graphics;
import java.time.LocalTime;
import java.util.Arrays;

import games.gui.*;
import robotwar.common.IConstants;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.dalek.Dalek;

public class MainController implements IConstants{
	private MainIU controlledFrame;
	private Dalek dalek;

	public void setWindow(MainIU pframe) {
		controlledFrame= pframe;
	}
	public void moveDalek(MOVEMENT pmove, LocalTime pTime, Graphics g) {
		dalek.move(pmove, pTime, g);
	}
	public Dalek getDalek() {
		return dalek;
	}
	public void setDalek(Dalek dalek) {
		this.dalek = dalek;
	}
	public int getXDalek(MOVEMENT pmove, Graphics g) {
		dalek.move(pmove, null, g);
		System.out.println(dalek.getPosX());
		return dalek.getPosX();
	}
	public int getYDalek(MOVEMENT pmove, Graphics g) {
		dalek.move(pmove, null, g);
		System.out.println(dalek.getPostY());
		return dalek.getPostY();
	}
}
