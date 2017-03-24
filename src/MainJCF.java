import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainJCF {

	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in); 
		String cadena;
		String texto = "";
		String textoTraducido = "";		
	
		TreeSet<Asociacion<String, String>> b = new TreeSet<>();
		
		//Utilizacion de buffered Reader para obtener los datos de un archivo de texto
		FileReader fr = new FileReader("diccionario.txt");
	 	BufferedReader bf = new BufferedReader(fr);
	 	
	 	// Limpia la cadena de palabras para formar las asociaciones
		while ((cadena = bf.readLine()) != null) {
			cadena = cadena.replaceAll("[()]", "");
			String[] datos = cadena.split("\\s*,\\s*");
			
			// crear las asociaciaciones
			b.add(new Asociacion<String, String>(datos[0], datos[1]));
		}
		bf.close(); // cierra el txt
		
		System.out.print("Elementos in-order: \n");
		//Imprime los elementos del arbol in-order
		for( Iterator it = b.iterator(); it.hasNext(); ) { 
				Asociacion<String,String> x = (Asociacion<String,String>)it.next();
			    System.out.println(x.toString());
			}
		
		System.out.println("\n");
		// leer el txt que se traducira
		fr = new FileReader("texto.txt");
		bf = new BufferedReader(fr);
		while ((cadena = bf.readLine()) != null) {
			texto += cadena + "\n";
			cadena = cadena.replace(",", "").replace(".", "").toLowerCase();
			String[] palabras = cadena.split("\\s+");
			// recorrer las palabras
			for(int i=0; i<palabras.length;i++){
				
				Asociacion<String, String> match = new Asociacion<String, String>(palabras[i], "");
				for( Iterator it = b.iterator(); it.hasNext(); ) { 
					Asociacion<String,String> x = (Asociacion<String,String>)it.next();
				    if (x.compareTo(match)==0){ // si esta en el diccionario la traduce
				    	textoTraducido += x.value + " ";
				    	}
					}
				 if(b.contains(match)== false){  // si no esta en el diccionario no la traduce
				    	textoTraducido += "*" + palabras[i] + "* ";
				    }
				
			}
		}
		bf.close(); // cierra el txt
	
		// imprime el texto original que se debia traducir
		System.out.println("Texto Original:\n" + texto);
		// imprime el texto traducido
		System.out.println("Texto Traducido:\n" + textoTraducido);
		
		}
	
}

