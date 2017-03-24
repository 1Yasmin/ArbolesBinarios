
public class BinarySearchTree <E extends Comparable<E>>{
	private Node<E> root;
	
	//Constructor
	public BinarySearchTree(){
		this.root = null;
	}
	
	// Verifica si un nodo esta en el arbol
	public E find(E id){
		Node<E> current = root;
		while(current!=null){
			if(current.data.equals(id)){
				return current.data;
			}else if(current.data.compareTo(id)>0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return null;
	}
	
	// Regresa el nodo
	public Node<E> getRoot() {
		return root;
	}

	//Cambiar los valores del nodo
	public void setRoot(Node<E> root) {
		this.root = root;
	}

	//Borrar un elemento del arbol
	public boolean delete(E id){
		Node<E> parent = root;
		Node<E> current = root;
		boolean isLeftChild = false;
		while(!current.data.equals(id)){
			parent = current;
			if(current.data.compareTo(id)>0){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//Se encuentra el nodo
		//Caso 1: Si el nodo a borrar no tiene hijos
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Caso 2 : Si el nodo a borrar tiene solo un hijo
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			Node<E> successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	//regresa el sucesor del nodo
	public Node<E> getSuccessor(Node<E> deleleNode){
		Node<E> successsor =null;
		Node<E> successsorParent =null;
		Node<E> current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	
	//Agrega un nodo al arbol
	public void insert(E id){
		Node<E> newNode = new Node<E>(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node<E> current = root;
		Node<E> parent = null;
		while(true){
			parent = current;
			if(id.compareTo(current.data)<0){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	//muestra los nodos del arbol
	public void display(Node<E> root){
		if(root!=null){
			display(root.left);
			System.out.print(root.data + " ");
			display(root.right);
		}
	}
}

//Define el nodo y sus atributos
class Node<E>{
	E data;
	Node<E> left;
	Node<E> right;	
	public Node(E data){
		this.data = data;
		left = null;
		right = null;
	}
}
