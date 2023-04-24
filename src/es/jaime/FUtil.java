package es.jaime;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fExiste("Fichero.txt"));
	}
	
	public static boolean fExiste (String filename) {
		boolean existe = true;
		try (FileReader lector = new FileReader("src/es/jaime/"+filename)) {	
		} catch (FileNotFoundException fnfe) {
			existe=false;
		} catch (IOException ioe) {
			System.out.println("Errorcillo.");
		}
		return existe;
	}

}
