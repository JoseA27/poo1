package robotwar.main;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.tools.FileObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import games.controller.MainController;
import games.gui.MainIU;
import robotwar.Colision.ManejadorColision;
import robotwar.common.*;
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.Weapon;
import robotwar.dalek.*;
import robotwar.weapon.*;

public class program {
	public static void main(String args[]) throws InterruptedException {
		
		MainController controller = new MainController();
		MainIU window = new MainIU("Prueba", controller,IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH);
		ManejadorColision manager = new ManejadorColision();
		Dalek dalek = Dalek.getInstante();
		Weapon laser = WeaponFactory.createDinamico("Laser");
		Weapon gunstick = WeaponFactory.createDinamico("Gunstick");
		Weapon flame = WeaponFactory.createDinamico("Piroflame");
		
		//Json----------------------------------
		dalek.setEnergy(50);
		Gson gson = new Gson();
			
		String info =gson.toJson(dalek);
		System.out.print(info);
		Dalek copiaDalekJson = gson.fromJson(info, Dalek.class);
		//---------------------------------------
		copiaDalekJson.addWeapon(laser);
		copiaDalekJson.addWeapon(laser);
		copiaDalekJson.addStrike(gunstick);
		copiaDalekJson.addStrike(flame);
		
		controller.setDalek(copiaDalekJson);
		manager.addObserver(copiaDalekJson);
		
		Sierra sierra = new Sierra();
		Fire fuego = new Fire();
		AgujeroNegro blackHole = new AgujeroNegro();
		controller.setManejadorColision(manager);
		controller.agregarTrampas(sierra);
		controller.agregarTrampas(fuego);
		controller.agregarTrampas(blackHole);
		window.run();

					
		try {
	        var fileOutputStream = new FileOutputStream("robotsCaso.dat");
	        
	        var objOutputStream = new ObjectOutputStream(fileOutputStream);
	        
	        objOutputStream.writeObject(dalek);
	 
	        fileOutputStream.close();
	        objOutputStream.close();
	        
	    } catch ( FileNotFoundException e ) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    
		try {
	        var fileInputStream = new FileInputStream("robotsCaso.dat");
	        var objectInputStream = new ObjectInputStream(fileInputStream);
	         
	        IRobot robooooot = (Dalek) objectInputStream.readObject();
	         
	        objectInputStream.close();
	        fileInputStream.close();
	         
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
		System.out.println(dalek.getEnergy());
	}
			
		
}
