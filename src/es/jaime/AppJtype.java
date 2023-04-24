package es.jaime;
import java.io.*;
import java.util.Scanner;

public class AppJtype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner TECLADO = new Scanner(System.in);
		System.out.println("Por favor, escribe el nombre del fichero a utilizar.");
		String nombre = TECLADO.next();
		
		try (FileReader lector = new FileReader(nombre);
			BufferedReader filtro = new BufferedReader(lector)) {
			
			String línea = filtro.readLine();
			while (línea!=null) {
				System.out.println(línea);
				línea=filtro.readLine();
			}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

}
