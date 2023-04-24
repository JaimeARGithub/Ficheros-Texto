package es.jaime;
import java.util.Scanner;
import java.io.*;


public class AppJwc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner TECLADO = new Scanner(System.in);
		System.out.println("Por favor, introduce el nombre del fichero a analizar.");
		String nombreFich = TECLADO.next();
		int numCars=0;
		int numLíneas=0;
		
		try (FileReader lector = new FileReader(nombreFich);
			 BufferedReader filtroLec = new BufferedReader(lector);) {
			
			String línea = filtroLec.readLine();
			while (línea!=null) {
				numCars = numCars + línea.length();
				numLíneas++;
				línea = filtroLec.readLine();
			}
			
			System.out.printf("El fichero consta de %d caracteres y %d líneas.%n", numCars, numLíneas);
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("No se ha encontrado el archivo.");
		} catch (IOException ioe) {
			System.out.println("Excepción de tipo IOE.");
		}
		
	}

}
