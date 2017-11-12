package cr.ac.tec.ce1103.structures.trees;
/**
 * 
 * @author Adrian Sanchez
 *
 */
public class NodoAVLTree <AnyType extends Comparable>{
	public int dato, fe;
	NodoAVLTree hijoIzquierdo, hijoDerecho;

	NodoAVLTree(AnyType d) {
		this.dato = (int) d;
		this.fe = 0;
		this.hijoDerecho = null;
		this.hijoIzquierdo = null;
	}
//
	
}
