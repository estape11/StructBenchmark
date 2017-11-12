package cr.ac.tec.ce1103.structures.trees;

import cr.ac.tec.ce1103.structures.benchmark.Interfaz;


/**
 * Clase del arbol Binario de Busqueda
 * @author Esteban Ag�ero P�rez
 *
 * @param <Tipo>
 */
public class BinarySearchTree <Tipo extends Comparable > {	
	public static int cont=0;
	public BTNode raiz;
	/**
	 * Clase nodo de arbol binario de busqueda
	 * @author Esteban Ag�ero P�rez
	 *
	 */
	private class BTNode {
		private BinarySearchTree<Tipo> hijoDerecho;
		private BinarySearchTree<Tipo> hijoIzquierdo;
		public Tipo dato;

		private void BTNode(){
			hijoDerecho = null;
			hijoIzquierdo = null;
			dato = null;
		}
	}

	private BinarySearchTree<Tipo> actual;
	public BinarySearchTree(){BTNode raiz = new BTNode();}
	private boolean esVacio(){return (raiz == null);}
	public Tipo Root(){return raiz.dato;}
	/**
	 * Inserta elemetos al arbol
	 * @param dato
	 */
	public void Insert(Tipo dato){
		if (esVacio()) {
			BTNode nuevo = new BTNode();
			nuevo.dato = dato;
			nuevo.hijoDerecho = new BinarySearchTree<Tipo>();
			nuevo.hijoIzquierdo = new BinarySearchTree<Tipo>();
			raiz = nuevo;
		}
		else {
			int comparacion = dato.compareTo(raiz.dato);
			if ( comparacion > 0) {
				(raiz.hijoDerecho).Insert(dato);
			}
			if ( comparacion <= 0){
				(raiz.hijoIzquierdo).Insert(dato);
			}
		}
	}
	/**
	 * Metodo auxiliar de buscar en arboles binarios de busqueda
	 * @param valor
	 * @return
	 */
	private BinarySearchTree<Tipo> searchAux(Tipo valor){
        actual = null;
        if (!esVacio()) {
        	int comparacion = valor.compareTo(raiz.dato);
            if ( comparacion == 0) {
            return this;
            }
            else {
                if (comparacion < 0) {
                    actual = raiz.hijoIzquierdo.searchAux(valor);
                }
                else {
                    actual = raiz.hijoDerecho.searchAux(valor);
                }
            }
        }
        return actual;
	}
	/**
	 * Metodo principal de busqueda
	 * @param valor
	 * @return
	 */
	public Tipo Search(Tipo valor){
		Tipo elementoBuscado= searchAux(valor).raiz.dato;
		return elementoBuscado;
		}
	/**
	 * Verifica si un nodo es una hoja
	 * @return
	 */
	private boolean esHoja() {
        boolean hoja = false;
        if( (raiz.hijoIzquierdo).esVacio() && (raiz.hijoDerecho).esVacio() ) {
            hoja = true;
        }
        return hoja;
    }
	/**
	 * busca el minimo nodo
	 * @return
	 */
	private Tipo Min() {
		BinarySearchTree<Tipo> arbolActual = this; //El minimo del arbol actual
        while( !arbolActual.raiz.hijoIzquierdo.esVacio() ) {
            arbolActual = arbolActual.raiz.hijoIzquierdo;
        }
        Tipo elementoMinimo= arbolActual.raiz.dato;
        arbolActual.raiz=null;
        return elementoMinimo;
    }
	/**
	 * Busca el maximo nodo
	 * @return
	 */
    private Tipo Max() {
        BinarySearchTree<Tipo> arbolActual = this;
        while( !arbolActual.raiz.hijoDerecho.esVacio() ) {
            arbolActual = arbolActual.raiz.hijoDerecho;
        }
        Tipo elementoMaximo= arbolActual.raiz.dato;
            arbolActual.raiz=null;
        return elementoMaximo;
    }
    public void enOrden(BTNode r) {
		if (r != null) {
			enOrden(r.hijoIzquierdo.raiz);
			cont++;
			System.out.println("obtener dato "+r.dato);
			System.out.println("-------------------FIN----------------");
			Interfaz.listaTree.add(r.dato);
			enOrden(r.hijoDerecho.raiz);
			
		}
	}
	/**
	 * Elimina Elementos
	 * @param valor
	 */
	public void Delete(Tipo valor) {
        BinarySearchTree<Tipo> elementoEliminar = searchAux(valor);
        if (!elementoEliminar.esVacio()) { //Cuando el elemento a eliminar no tiene hijos
            if (elementoEliminar.esHoja()) {
                elementoEliminar.raiz = null;
            }
            else {
                if (!elementoEliminar.raiz.hijoIzquierdo.esVacio() && !elementoEliminar.raiz.hijoDerecho.esVacio()) { //Cuando el elemento a eliminar posee 2 hijos
                    elementoEliminar.raiz.dato = elementoEliminar.raiz.hijoDerecho.Min(); 
                }
                else {
                    if (elementoEliminar.raiz.hijoIzquierdo.esVacio()) { //Si solo tiene hijo a la izquierda
                        elementoEliminar.raiz = elementoEliminar.raiz.hijoDerecho.raiz;
                    }else{
                        elementoEliminar.raiz = elementoEliminar.raiz.hijoIzquierdo.raiz;
                    }
                }
            }
        }
    }

}
