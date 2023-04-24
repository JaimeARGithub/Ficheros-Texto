package es.jaime;
import java.io.*;
import java.util.Scanner;

public class AppJcopytext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner TECLADO = new Scanner(System.in);
		System.out.println("Por favor, introduce el nombre del fichero a copiar. Sin la extensión.");
		String nombre = TECLADO.next();
		String nombreFicheroEntrada = nombre.concat(".txt");
		String nombreFicheroSalida = nombre.concat("_copy.txt");
		
		try (FileReader lector = new FileReader(nombreFicheroEntrada);
			 BufferedReader filtroLec = new BufferedReader(lector);
			 FileWriter escritor = new FileWriter(nombreFicheroSalida);
			 BufferedWriter filtroEsc = new BufferedWriter(escritor)) {
			
			String línea = filtroLec.readLine();
			while (línea!=null) {
				filtroEsc.write(línea);
				filtroEsc.write("\n");
				línea = filtroLec.readLine();
			}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

}
