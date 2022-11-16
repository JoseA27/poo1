package robotwar.factory;
import robotwar.common.*;
import robotwar.common.robotbase.Weapon;
import robotwar.tecdigital.Bug;

public class PowersFactory {
	private static String packageName = "robotwar.";


	public static Weapon createDinamico(String pPower ) {
		Weapon result = null;

		try {
			String className = packageName+pPower;
			result = (Weapon)Class.forName(className).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			result = new Bug();
		}
		
		return result;
	}

}