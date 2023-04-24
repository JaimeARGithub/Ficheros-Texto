package es.jaime;
import java.util.Scanner;
import java.io.*;

public class AppCalcTextFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner TECLADO = new Scanner(System.in);
		System.out.println("Por favor, introduce el nombre del fichero.");
		String nombreFich = TECLADO.next();
		
		try (FileReader lector = new FileReader(nombreFich);
			 BufferedReader filtroLec = new BufferedReader(lector);) {
			
			char operador = (char) filtroLec.read();
			
			switch (operador) {
			case '+' -> {
				System.out.println("Sumando...");
				String primerNumeroStr = filtroLec.readLine();
				primerNumeroStr = filtroLec.readLine();
				int primerNumero = Integer.parseInt(primerNumeroStr);
				
				String numOperarStr = filtroLec.readLine();
				while (numOperarStr!=null) {
					primerNumero = primerNumero + Integer.parseInt(numOperarStr);
					numOperarStr = filtroLec.readLine();
				}
				System.out.println(primerNumero);
			}
			
			case '-' -> {
				System.out.println("Restando...");
				String primerNumeroStr = filtroLec.readLine();
				primerNumeroStr = filtroLec.readLine();
				int primerNumero = Integer.parseInt(primerNumeroStr);
				
				String numOperarStr = filtroLec.readLine();
				while (numOperarStr!=null) {
					primerNumero = primerNumero - Integer.parseInt(numOperarStr);
					numOperarStr = filtroLec.readLine();
				}
				System.out.println(primerNumero);
			}
			case 'x' -> {
				System.out.println("Multiplicando...");
				String primerNumeroStr = filtroLec.readLine();
				primerNumeroStr = filtroLec.readLine();
				int primerNumero = Integer.parseInt(primerNumeroStr);
				
				String numOperarStr = filtroLec.readLine();
				while (numOperarStr!=null) {
					primerNumero = primerNumero * Integer.parseInt(numOperarStr);
					numOperarStr = filtroLec.readLine();
				}
				System.out.println(primerNumero);
			}
			case '/' -> {
				System.out.println("Dividiendo...");
				String primerNumeroStr = filtroLec.readLine();
				primerNumeroStr = filtroLec.readLine();
				int primerNumero = Integer.parseInt(primerNumeroStr);
				
				String numOperarStr = filtroLec.readLine();
				while (numOperarStr!=null) {
					primerNumero = primerNumero / Integer.parseInt(numOperarStr);
					numOperarStr = filtroLec.readLine();
				}
				System.out.println(primerNumero);
			}
			}
			
			
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

}
