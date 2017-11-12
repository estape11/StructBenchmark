package cr.ac.tec.ce1103.structures.trees;

import cr.ac.tec.ce1103.structures.benchmark.Interfaz;
import cr.ac.tec.ce1103.structures.simple.ListaEnlazada;
import cr.ac.tec.ce1103.structures.sort.SortingAlgorithm;

/**
 * 
 * @author Adrian S�nchez
 *
 */
public class AVLTree{
	public NodoAVLTree raiz;
	public static int cont=0;

	public AVLTree() {
		raiz = null;
	}

	public NodoAVLTree obtenerRaiz() {
		return raiz;
	}

	// Buscar Nodo
	public  <AnyType extends Comparable>NodoAVLTree buscar(AnyType d, NodoAVLTree r) {
		if (raiz == null) {
			return null;
		} else if (r.dato == (int)d) {
			return r;
		} else if (r.dato < (int)d) {
			return buscar(d, r.hijoDerecho);
		} else {
			return buscar(d, r.hijoIzquierdo);
		}
	}

	// Obtener el factor de equilibrio
	public int obtenerFe(NodoAVLTree x) {
		if (x == null) {
			return -1;
		} else {
			return x.fe;
		}
	}

	// Rotacion simple a la izquierda
	public NodoAVLTree rotacionIzquierda(NodoAVLTree c) {
		NodoAVLTree auxiliar = c.hijoIzquierdo;
		c.hijoIzquierdo = auxiliar.hijoDerecho;
		auxiliar.hijoDerecho = c;
		c.fe = Math.max(obtenerFe(c.hijoIzquierdo), obtenerFe(c.hijoDerecho)) + 1;
		auxiliar.fe = Math.max(obtenerFe(auxiliar.hijoIzquierdo), obtenerFe(auxiliar.hijoDerecho)) + 1;
		return auxiliar;
	}

	// Rotacion simple derecha
	public NodoAVLTree rotacionDerecha(NodoAVLTree c) {
		NodoAVLTree auxiliar = c.hijoDerecho;
		c.hijoDerecho = auxiliar.hijoIzquierdo;
		auxiliar.hijoIzquierdo = c;
		c.fe = Math.max(obtenerFe(c.hijoIzquierdo), obtenerFe(c.hijoDerecho)) + 1;
		auxiliar.fe = Math.max(obtenerFe(auxiliar.hijoIzquierdo), obtenerFe(auxiliar.hijoDerecho)) + 1;
		return auxiliar;
	}

	// Rotacion Doble a la derecha
	public NodoAVLTree rotacionDobleIzquierda(NodoAVLTree c) {
		NodoAVLTree temp;
		c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
		temp = rotacionIzquierda(c);
		return temp;
	}

	// Rotacion Doble a la derecha
	public NodoAVLTree rotacionDobleDerecha(NodoAVLTree c) {
		NodoAVLTree temp;
		c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
		temp = rotacionDerecha(c);
		return temp;
	}

	// Metodo Insertar Balanceado
	public NodoAVLTree insertarAVL(NodoAVLTree nuevo, NodoAVLTree subAr) {
		NodoAVLTree nuevoPadre = subAr;
		if (nuevo.dato < subAr.dato) {
			if (subAr.hijoIzquierdo == null) {
				subAr.hijoIzquierdo = nuevo;
			} else {
				subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
				if ((obtenerFe(subAr.hijoIzquierdo) - obtenerFe(subAr.hijoDerecho)) == 2) {
					if (nuevo.dato < subAr.hijoIzquierdo.dato) {
						nuevoPadre = rotacionIzquierda(subAr);
					} else {
						nuevoPadre = rotacionDobleIzquierda(subAr);
					}
				}
			}
		} else if (nuevo.dato > subAr.dato) {
			if (subAr.hijoDerecho == null) {
				subAr.hijoDerecho = nuevo;
			} else {
				subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
				if ((obtenerFe(subAr.hijoDerecho) - obtenerFe(subAr.hijoIzquierdo)) == 2) {
					if (nuevo.dato > subAr.hijoDerecho.dato) {
						nuevoPadre = rotacionDerecha(subAr);
					} else {
						nuevoPadre = rotacionDobleDerecha(subAr);
					}
				}
			}
		} else {
			if(subAr.hijoDerecho!=null){
				insertarAVL(nuevo,subAr.hijoDerecho);
			}
			else{
				subAr.hijoDerecho=nuevo;
			}
		}
		// Actualizar altura o factor de equilibrio
		if (subAr.hijoIzquierdo == null && subAr.hijoDerecho != null) {
			subAr.fe = subAr.hijoDerecho.fe + 1;
		} else if (subAr.hijoDerecho == null && subAr.hijoIzquierdo != null) {
			subAr.fe = subAr.hijoIzquierdo.fe + 1;
		} else {
			subAr.fe = Math.max(obtenerFe(subAr.hijoIzquierdo), obtenerFe(subAr.hijoDerecho)) + 1;
		}
		return nuevoPadre;
	}

	// Metodo para Insertar SImple
	public <AnyType extends Comparable>void insertar(AnyType d) {
		NodoAVLTree nuevo = new NodoAVLTree(d);
		if (raiz == null) {
			raiz = nuevo;
		} else {
			raiz = insertarAVL(nuevo, raiz);
		}
	}

	// Recorrer en Orden
	public void enOrden(NodoAVLTree r) {
		if (r != null) {
			enOrden(r.hijoIzquierdo);
			cont++;
			System.out.println("obtener dato "+r.dato);
			System.out.println("-------------------FIN----------------");
			Interfaz.listaTree.add(r.dato);
			enOrden(r.hijoDerecho);
			
		}
	}

	// Buscar Menor
	public NodoAVLTree findMin(NodoAVLTree t) {
		if (t == null)
			return null;
		else if (t.hijoIzquierdo == null)
			return t;
		return findMin(t.hijoIzquierdo);
	}

	// Balancear
	public NodoAVLTree balancear(NodoAVLTree t) {
		if (t == null)
			return t;
		if (obtenerFe(t.hijoIzquierdo) - obtenerFe(t.hijoDerecho) > 1)
			if (obtenerFe(t.hijoIzquierdo.hijoIzquierdo) >= obtenerFe(t.hijoIzquierdo.hijoDerecho))
				t = rotacionIzquierda(t);
			else
				t = rotacionDobleIzquierda(t);
		else if (obtenerFe(t.hijoDerecho) - obtenerFe(t.hijoIzquierdo) > 1)
			if (obtenerFe(t.hijoDerecho.hijoDerecho) >= obtenerFe(t.hijoDerecho.hijoIzquierdo))
				t = rotacionDerecha(t);
			else
				t = rotacionDobleDerecha(t);
		t.fe = Math.max(obtenerFe(t.hijoIzquierdo), obtenerFe(t.hijoDerecho)) + 1;
		return t;
	}

	// Eliminar
	public <AnyType extends Comparable> NodoAVLTree eliminarAVL(AnyType x, NodoAVLTree t) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		sb.append("");
		sb1.append("");
		sb.append(x);
		sb1.append(t.dato);
		String var = sb.toString();
		String var1 = sb1.toString();
		if (t == null)
			return t;
		int compareResult = var.compareTo(var1);
		if (compareResult < 0)
			t.hijoIzquierdo = eliminarAVL(x, t.hijoIzquierdo);
		else if (compareResult > 0)
			t.hijoDerecho = eliminarAVL(x, t.hijoDerecho);
		else if (t.hijoIzquierdo != null && t.hijoDerecho != null)

		{
			t.dato = findMin(t.hijoDerecho).dato;
			t.hijoDerecho = eliminarAVL(t.dato, t.hijoDerecho);
		} else
			t = (t.hijoIzquierdo != null) ? t.hijoIzquierdo : t.hijoDerecho;
		return balancear(t);
	}

	public static void main(String[] args) {
		AVLTree arbol = new AVLTree();
		SortingAlgorithm<Integer> sort=new SortingAlgorithm<>();
		Integer[] arreglo=sort.RandomArray(100);
		for(int i=0;i<100;i++){
			arbol.insertar(arreglo[i]);
			System.out.println(i);
		}
		
	}

}
