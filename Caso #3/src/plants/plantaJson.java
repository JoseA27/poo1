package plants;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import plants.climate.Seasons;
import plants.climate.SeasonsStatus;
//import Status.plantStatus;
//import Status.statusChangeRule;
import plants.statuses.PlantStatus;
import plants.statuses.Status;
import plants.statuses.StatusChangeRule;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class plantaJson {
	private PlantStatus status;
	private String name;
	private ArrayList<Seasons>estaciones= new ArrayList<Seasons>();;
	
	public Plant cargarPlant(int index) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
	
		Object objeto = parser.parse(new FileReader("C:\\Users\\Usuario\\eclipse-workspace\\Caso #3\\plantas.json"));
		JSONObject json = (JSONObject)objeto;
		
		JSONArray lista= (JSONArray)json.get("Plantas");
		
		JSONObject ubicacion=(JSONObject)lista.get(index);
		String nombre=(String)ubicacion.get("nombre");
		Plant plant=new Plant();
		plant.setLife(Integer.valueOf((String)ubicacion.get("vida")));
		plant.setName(nombre);
		plant.setMaxAge(Integer.valueOf((String)ubicacion.get("dias")));
		JSONArray estadosArray =(JSONArray)ubicacion.get("estados");
		
		for(int i=0;i<estadosArray.size();i++) {
			 StatusChangeRule rule=new  StatusChangeRule();
			JSONObject nivel = (JSONObject)estadosArray.get(i);
			rule.setMaxDays(Integer.valueOf((String)nivel.get("max_dias")));
			rule.setMinDays(Integer.valueOf((String)nivel.get("min_dias")));
			rule.setMaxLife(Integer.valueOf((String)nivel.get("max_vida")));
			rule.setMinLife(Integer.valueOf((String)nivel.get("min_vida")));
			rule.setMaxAbono(Integer.valueOf((String)nivel.get("max_abono")));
			rule.setMinAbono(Integer.valueOf((String)nivel.get("min_abono")));
			rule.setMaxWater(Integer.valueOf((String)nivel.get("max_agua")));
			rule.setMinWater(Integer.valueOf((String)nivel.get("min_agua")));
			rule.setEfectoAN(Integer.valueOf((String)nivel.get("efectoAN")));
			rule.setEfectoAP(Integer.valueOf((String)nivel.get("efectoAP")));
			rule.setEfectoWP(Integer.valueOf((String)nivel.get("efectoWP")));
			rule.setEfectoWN(Integer.valueOf((String)nivel.get("efectoWN")));
			plant.addRule(rule);
			
			Status picture =new Status();
			picture.setName((String)nivel.get("nivel"));
			picture.setStatusPictureURL((String)nivel.get("imagen"));
			plant.addImagen(picture);
			
		}
		return plant;
	}
		public ArrayList<Seasons> cargarSeasons() throws FileNotFoundException, IOException, ParseException {
			JSONParser parser = new JSONParser();
			Object objeto = parser.parse(new FileReader("C:\\Users\\Usuario\\eclipse-workspace\\Caso #3\\seasons.json"));
			JSONObject json = (JSONObject)objeto;
			JSONArray lista= (JSONArray)json.get("Seasons");
			
			for (int i=0; i<lista.size();i++) {
				JSONObject ubicacion=(JSONObject)lista.get(i);
				int start= Integer.valueOf((String)ubicacion.get("start"));
				int end= Integer.valueOf((String)ubicacion.get("end"));
				String name= (String)ubicacion.get("estacion");
				Seasons season = new Seasons();
				season.setName(name);
				season.setStart(start);
				season.setEnd(end);
				
				JSONArray estadosArray =(JSONArray)ubicacion.get("estado");
				
				for(int n=0;n<estadosArray.size();n++) {
					 SeasonsStatus estacion=new  SeasonsStatus();
					JSONObject nivel = (JSONObject)estadosArray.get(n);
					estacion.setName((String)nivel.get("condition"));
					estacion.setWater(Integer.valueOf((String)nivel.get("water")));
					estacion.setAbono(Integer.valueOf((String)nivel.get("abono")));
					estacion.setTemp(Integer.valueOf((String)nivel.get("temp")));
					
					season.loadStatus(estacion);
					
				}
				estaciones.add(season);
			}
			return estaciones;
	}

}
