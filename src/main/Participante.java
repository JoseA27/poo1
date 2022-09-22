package main;

import main.Participante;

public class Participante implements Comparable<Participante> {
	private String nombre;
	private int juegos;
	private int puntos;
	
	public Participante(String n, int games, int points) {
		this.nombre=n;
		this.juegos=games;
		this.puntos=points;
	}

	@Override
	public int compareTo(Participante o) {
		if (o.getJuegos()-this.juegos==0) {
			if (o.getPuntos()-this.puntos==0) {
				return 0;}
			else if (o.getPuntos()-this.puntos<0) {
				return -1;
			}
			else {
				return 1;
			}
		}
		else if (o.getJuegos()-this.juegos<1){
			return 1;
		}
		else {
			return -1;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getJuegos() {
		return juegos;
	}

	public int getPuntos() {
		return puntos;
	}
}
