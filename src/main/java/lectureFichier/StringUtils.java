package lectureFichier;

public class StringUtils {
	
	String chaine;
	
	public static String traitementCaracteresSpe(String chaine){
		return chaine.replace("'", "''").replace("\\", "");
	}
	
	public static double toDouble(String chaine) {
		if(!chaine.isEmpty()) {
			try {
				return Double.parseDouble(chaine);
			} catch (Exception e) {
				System.out.println("Mauvais format dans la String : " + e.getMessage());
				return 0.0;
			}
			
		}else {
			return 0.0;
		}
	}

}
