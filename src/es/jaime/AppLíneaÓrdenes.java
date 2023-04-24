package es.jaime;
import java.io.*;

public class AppLíneaÓrdenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		switch (args[0]) {
		case "jtype" -> {
			String nombreFich = args[1];
			
			try (FileReader lector = new FileReader(nombreFich);
				 BufferedReader filtroLec = new BufferedReader(lector)) {
				
				String línea = filtroLec.readLine();
				while (línea!=null) {
					System.out.println(línea);
					línea = filtroLec.readLine();
				}
				
			} catch (FileNotFoundException fnfe) {
				System.out.println(fnfe);
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
		}
		
		
		
		case "jcopytext"-> {
			String nombreFicheroExtensión = args[1];
			StringBuffer nombreSinExtensiónSB = new StringBuffer(nombreFicheroExtensión.length());
			int posPunto=0;
			for (int i=0;nombreFicheroExtensión.charAt(i)!='.';i++) {
				nombreSinExtensiónSB.append(nombreFicheroExtensión.charAt(i));
				posPunto++;
			}
			String nombreSinExtensión = nombreSinExtensiónSB.toString();
			String nombreFicheroDestino = new String("");
			
			StringBuffer extensiónSB = new StringBuffer();
			for (int i=posPunto;i<nombreFicheroExtensión.length();i++) {
				extensiónSB.append(nombreFicheroExtensión.charAt(i));
			}
			String extensión = extensiónSB.toString();

			
			if (args.length==3) {
				nombreFicheroDestino = args[2];
			} else if (args.length==2) {
				nombreFicheroDestino = new String(nombreSinExtensión+"_copy"+extensión);
			}
			
			
			try (FileReader lector = new FileReader(nombreFicheroExtensión);
				 BufferedReader filtroLec = new BufferedReader(lector);
				 FileWriter escritor = new FileWriter(nombreFicheroDestino);
				 BufferedWriter filtroEsc = new BufferedWriter(escritor)) {
				
				String línea = filtroLec.readLine();
				while (línea!=null) {
					filtroEsc.write(línea+"\n");
					línea=filtroLec.readLine();
				}
				
			} catch (FileNotFoundException fnfe) {
				System.out.println(fnfe);
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
		}
		
		
		
		case "jwc" -> {
			if (args.length==2) {
				int numLíneas = cuentaLíneas(args[1]);
				int numCaracteres = cuentaCaracteres(args[1]);
				int numPalabras = cuentaPalabras(args[1]);
				System.out.printf("Fichero con %d líneas, %d caracteres y %d palabras.%n", numLíneas, numCaracteres, numPalabras);
			} else if (args.length==3) {
				if (args[1].equals("-l")) {
					int numLíneas = cuentaLíneas(args[2]);
					System.out.printf("Fichero con %d líneas.%n", numLíneas);
				} else if (args[1].equals("-c")) {
					int numCaracteres = cuentaCaracteres(args[2]);
					System.out.printf("Fichero con %d caracteres.%n", numCaracteres);
				} else if (args[1].equals("-w")) {
					int numPalabras = cuentaPalabras(args[2]);
					System.out.printf("Fichero con %d palabras.%n", numPalabras);
				}
			}
		}
		}
	}
	
	public static int cuentaLíneas (String nombreFichero) {
		int numLíneas=0;
		
		try (FileReader lector = new FileReader(nombreFichero);
			 BufferedReader filtroLec = new BufferedReader(lector);) {
			
			String línea = filtroLec.readLine();
			while (línea!=null) {
				numLíneas++;
				línea = filtroLec.readLine();
			}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
		return numLíneas;
	}
	
	
	public static int cuentaCaracteres (String nombreFichero) {
		int numCaracteres=0;
		
		try (FileReader lector = new FileReader(nombreFichero);
			 BufferedReader filtroLec = new BufferedReader(lector);) {
				
			String línea = filtroLec.readLine();
			while (línea!=null) {
				numCaracteres=numCaracteres+línea.length();
				línea = filtroLec.readLine();
			}
				
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
		return numCaracteres;
	}
	
	
	public static int cuentaPalabras (String nombreFichero) {
		int numPalabras=0;
		
		try (FileReader lector = new FileReader(nombreFichero);
			 BufferedReader filtroLec = new BufferedReader(lector)) {
			
			String línea = filtroLec.readLine();
			while (línea!=null) {
				String[] palabras = línea.split(" ");
				numPalabras=numPalabras+palabras.length;
				línea = filtroLec.readLine();
			}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
		return numPalabras;
	}

}
