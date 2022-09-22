package main;

import java.util.ArrayList;
import java.util.Collections;


public class main {
	public static void main(String[] args) {
		ArrayList<Participante> Lista= new ArrayList();
		
		Participante Maria = new Participante("Maria", 11, 23);
		Participante Kristel = new Participante("Kristel", 11, 21);
		Participante Ana = new Participante("Ana", 13, 23);
		Participante Maria2 = new Participante("Maria", 13, 23);
		Participante Laura = new Participante("Laura", 13, 19);
		Participante Lucia = new Participante("Lucia", 14, 25);
		Participante Sofia = new Participante("Sofia", 14, 30);
		
		Lista.add(Maria);
		Lista.add(Kristel);
		Lista.add(Ana);
		Lista.add(Maria2);
		Lista.add(Laura);
		Lista.add(Lucia);
		Lista.add(Sofia);
		
		Collections.sort(Lista);
		
		for (Participante participante: Lista) {
			System.out.println(participante.getNombre()+" "+participante.getJuegos()+" "+participante.getPuntos());
		}
		
	}
}