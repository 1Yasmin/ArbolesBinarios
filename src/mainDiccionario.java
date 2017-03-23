import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class mainDiccionario {
	
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
		bf.close();
		
		fr = new FileReader("texto.txt");
		bf = new BufferedReader(fr);
		while ((cadena = bf.readLine()) != null) {
			texto += cadena + "\n";
			cadena = cadena.replace(",", "").replace(".", "").toLowerCase();
			String[] palabras = cadena.split("\\s+");
			for(int i=0; i<palabras.length;i++){
				Asociacion<String, String> match = b.find(new Asociacion<String, String>(palabras[i], ""));
				if(match != null){
					textoTraducido += match.value + " ";
				}else{
					textoTraducido += "*" + palabras[i] + "* ";
				}
			}
		}
		bf.close();
		
		System.out.println(texto);
		System.out.println(textoTraducido);
		
		//b.display(b.getRoot());
	}
	
}
