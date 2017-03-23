import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class mainDiccionario {
	
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in); 
		String cadena;
		
		/*Asociacion<String, String> aso = new Asociacion<>("h", "hola");
		Asociacion<String, String> aso1 = new Asociacion<>("d", "hola");
		Asociacion<String, String> aso2= new Asociacion<>("h", "hola");
		Asociacion<String, String> aso3 = new Asociacion<>("w", "hola");
		Asociacion<String, String> aso4 = new Asociacion<>("t", "hola");*/
		
		BinarySearchTree<Asociacion<String, String>> b = new BinarySearchTree<>();
		/*b.insert(aso);b.insert(aso1);b.insert(aso2);
		b.insert(aso3);b.insert(aso4);
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(aso3));*/
		/*System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(b.root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(b.root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(b.root);*/
		
		//Utilizacion de buffered Reader para obtener los datos de un archivo de texto
		FileReader fr = new FileReader("palabras.txt");
	 	BufferedReader bf = new BufferedReader(fr);

		while ((cadena = bf.readLine()) != null) {
			cadena = cadena.replaceAll("[()]", "");
			String[] datos = cadena.split("\\s*,\\s*");
			
			b.insert(new Asociacion<String, String>(datos[0], datos[1]));
			System.out.println(datos[1]);
		}
		bf.close();
		
		b.display(b.getRoot());

		// Obtiene la frase que el usuario desea traducir
		System.out.println("Ingrese la frase que desea traducir: ");
		String frase = sc.nextLine();

	}
	
}
