package cr.ac.tec.ce1103.structures.simple;
/**
 * Clase de busqueda binaria
 * @author Daniela Hernández
 *
 * @param <Tipo>
 */
public class BinarySearch <Tipo extends Comparable>{
	private int indiceBusqueda;
	public int getIndiceBuscado(){return indiceBusqueda;}
	public static Integer[] RandomArray(){
		Integer arreglo[] = new Integer[10];
		for (int i=0; i<arreglo.length; i++){
			arreglo[i] = (int)(Math.random()*100);
		}
		return arreglo;
	}
	/**
	 * Ordenamiento bubblesort
	 * @param arreglo
	 * @return
	 */
	public Tipo[] Ordenar(Tipo[] arreglo){
		Tipo temp;
		for(int ordenados = 0; ordenados<arreglo.length; ordenados++ ){
			int desordenados = arreglo.length-ordenados;
			int j = 0;
			for(int i=0; i<desordenados-1;i++){
				j=i+1;
				if(arreglo[i].compareTo(arreglo[j])>0){
					temp=arreglo[i];
					arreglo[i]=arreglo[j];
					arreglo[j]=temp;
				}
			}
			
		}	
		return arreglo;
	}
	/**
	 * Realiza la busqueda de
	 * @param arreglo
	 * @param buscado
	 * @return valor del indice
	 */
	public Integer Busqueda(Tipo[] arregloOrdenado , Tipo Dato)  {
		
		int superior = arregloOrdenado.length - 1 ;
		int inferiror = 0;
		int medio;

		while(inferiror<=superior){
			//se toma la parte entera
			medio = (inferiror + superior)/2;
			if(Dato.compareTo(arregloOrdenado[medio])> 0)
				inferiror = medio + 1 ;
			else if (Dato.compareTo(arregloOrdenado[medio]) < 0)
				superior = medio - 1;
			else
				return medio;

		}
		return -1;
	}

}
