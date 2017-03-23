import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class mainDiccionario {
	
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in); 
		String cadena;
		
		//Utilizacion de buffered Reader para obtener los datos de un archivo de texto
		FileReader fr = new FileReader("palabras.txt");
	 	BufferedReader bf = new BufferedReader(fr);
	 	
	 	 while((cadena = bf.readLine())!=null) {
	          System.out.println(cadena);
	      }
	      bf.close();
	      
	      //Obtiene la frase que el usuario desea traducir
	      System.out.println("Ingrese la frase que desea traducir: ");
	      String frase = sc.nextLine();
	      
	      
	}
	
}
