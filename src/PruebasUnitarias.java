import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class PruebasUnitarias {
	
	// Prueba unitaria del metodo de insertar con el Binary SearchTree
	@Test
	public void insertarBST() {
		BinarySearchTree<Asociacion<Integer, Integer>> b = new BinarySearchTree<>();
		b.insert(new Asociacion<Integer,Integer>(1,3));
		assertEquals("Insercion: ", b.delete(new Asociacion<Integer, Integer>(1, 0)),true);
	}

	// Prueba unitaria del metodo de buscar con el BinarySearchTree
	@Test
	public void buscarBST() {
		BinarySearchTree<Asociacion<Integer, Integer>> b = new BinarySearchTree<>();
		b.insert(new Asociacion<Integer,Integer>(1,3));
		assertEquals("Insercion: ", b.find(new Asociacion<Integer, Integer>(1, 0)).value,3,0.001);
	}


	// Prueba unitaria del metodo de insertar implementando los JCF
	@Test
	public void insertarJCF(){
		TreeSet<Asociacion<String, String>> arbol = new TreeSet<>();
		String ingles = "hello";
		String espanol = "hola";
		arbol.add(new Asociacion<String,String>(ingles, espanol));
		assertEquals("Insercion: ", arbol.contains(new Asociacion<String, String>(ingles, espanol)), true);
	}
	
	// Prueba unitaria del metodo de buscar implementando los JCF
	@Test
	public void buscarJCF(){
		String ingles = "hello";
		String espanol = "hola";
		Asociacion<String,String> arbol1 = new Asociacion<String,String>(ingles, espanol);
		assertEquals("Insercion: ", (new Asociacion<String, String>(ingles, espanol)).compareTo(arbol1), 0);
	}
}
