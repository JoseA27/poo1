package games.controller;

import java.awt.Graphics;
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
	public void moveDalek(MOVEMENT pmove, Graphics g) {
		dalek.move(pmove, null, g);
	}
	public Dalek getDalek() {
		return dalek;
	}
	public void setDalek(Dalek dalek) {
		this.dalek = dalek;
	}
	
}
