import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainBinarySearchTree {
	
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in); 
		String cadena;
		String texto = "";
		String textoTraducido = "";
		
		BinarySearchTree<Asociacion<String, String>> b = new BinarySearchTree<>();
		
		//Utilizacion de buffered Reader para obtener los datos de un archivo de texto
		FileReader fr = new FileReader("diccionario.txt");
	 	BufferedReader bf = new BufferedReader(fr);
		while ((cadena = bf.readLine()) != null) {
			cadena = cadena.replaceAll("[()]", "");
			String[] datos = cadena.split("\\s*,\\s*");
			
			b.insert(new Asociacion<String, String>(datos[0], datos[1]));
			//System.out.println(datos[1]);
		}
		bf.close(); // cierra el txt
		
		
		//Imprime los elementos del arbol in-order
		System.out.print("Elementos in-order: ");
		b.display(b.getRoot());
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
				Asociacion<String, String> match = b.find(new Asociacion<String, String>(palabras[i], ""));
				if(match != null){  // si esta en el diccionario la traduce
					textoTraducido += match.value + " ";
				}else{				// si no esta en el diccionario no la traduce
					textoTraducido += "*" + palabras[i] + "* ";
				}
			}
		}
		bf.close(); // cierra el txt
		
		// imprime el texto original que se debia traducir
		System.out.println("Texto Original:\n" + texto);
		// imprime el texto traducido
		System.out.println("Texto Traducido:\n" + textoTraducido);
		
		//b.display(b.getRoot());
	}
	
}