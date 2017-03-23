import static org.junit.Assert.*;

import org.junit.Test;

public class PruebasUnitarias {

	@Test
	public void insertar() {
		BinarySearchTree<Asociacion<Integer, Integer>> b = new BinarySearchTree<>();
		b.insert(new Asociacion<Integer,Integer>(1,3));
		assertEquals("Insercion: ", b.delete(new Asociacion<Integer, Integer>(1, 0)),true);
	}
	
	@Test
	public void buscar() {
		BinarySearchTree<Asociacion<Integer, Integer>> b = new BinarySearchTree<>();
		b.insert(new Asociacion<Integer,Integer>(1,3));
		assertEquals("Insercion: ", b.find(new Asociacion<Integer, Integer>(1, 0)).value,3,0.001);
	}

}
