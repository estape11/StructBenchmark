package cr.ac.tec.ce1103.structures.sort;
/**
 * Clase maestra de todos los algoritmos de ordenaminto
 * @author Esteban Agüero Pérez
 *
 * @param <Tipo>
 */
public class SortingAlgorithm <Tipo extends Comparable>{
	public static String[] inputArr1;
	private int heapSize;
	/**
	 * Realiza ordenamiento BubbleSort
	 * @param arreglo
	 * @return arreglo ordenado
	 */
	public Tipo[] BubbleSort ( Tipo[] arreglo){
		Tipo datoAuxiliar;
		boolean cambio;
		boolean bandera=true;
		while (bandera){
			cambio=false;
			for (int i=1;i<arreglo.length;i++){
				int comparacion = arreglo[i].compareTo(arreglo[i-1]);
				if (comparacion < 0){ 
					datoAuxiliar=arreglo[i]; //guarda el valor antes del swap
					arreglo[i]=arreglo[i-1];
					arreglo[i-1]=datoAuxiliar;
					cambio=true;
				}
			}
			
			if (!cambio){break;}//si es false osea no hubo cambios
		}
		return arreglo; //Esta de mas ya que el metodo modifica el arreglo original
	}
	/**
	 * Realiza ordenamiento SelectionSort
	 * @param arreglo
	 */
	public void SelectionSort(Tipo[] arreglo){
		int min;
		for(int i=0; i< arreglo.length; i++){
			min=i;
			for(int j=i+1; j<arreglo.length; j++){
				if(arreglo[j].compareTo(arreglo[min])<0){
					min=j;
				}
			}
			if(min != i){
				final Tipo temp = arreglo[i];
				arreglo[i] = arreglo[min];
				arreglo[min] = temp;

			}
		}
	} 
	/**
	 * Realiza el ordenamiento InsertionSort
	 * @param arreglo
	 */
	public void InsertionSort(Tipo[] arreglo){
		Tipo temp;
		int i;
		for (int j = 1; j < arreglo.length; j++ ){
			temp = arreglo[j];
			i = j-1;
			while ((i>-1)&& (arreglo[i].compareTo(temp) > 0)){
				arreglo[i+1] = arreglo[i];
				i = i-1;
			}
			arreglo[i+1] = temp;
		}
	}
	
	/**
	 * Realiza ordenamiento QuickSort
	 * @param arreglo
	 */
	public void QuickSort ( Tipo[] arreglo){
		arreglo=quickSortAux(arreglo,0,arreglo.length-1); //Es el indice maximo y es -1 por que empieza en 0 no en 1

	} 
	/**
	 * Metodo Auxiliar del QuickSort
	 * @param nuevoArreglo
	 * @param izquierda
	 * @param derecha
	 * @return
	 */
	private Tipo[] quickSortAux ( Tipo[] nuevoArreglo, int izquierda, int derecha){
		if (izquierda>=derecha){return nuevoArreglo;} //Quiere decir que el puntero derecho y el puntero izquierdo estan en el mismo lugar
		int der=derecha,izq=izquierda; //Se hacen nuevos apuntadores para mas adelante poder delimitar los nuevos arreglos
		if (izquierda!=derecha){
			Tipo elementoAux;
			int pivote=izquierda; //se toma arbitrariamente para empezar a comparar con la lista
			while (izquierda!=derecha){
				while (nuevoArreglo[derecha].compareTo(nuevoArreglo[pivote])>=0 && izquierda<derecha){
					derecha--;
				}
				while (nuevoArreglo[izquierda].compareTo(nuevoArreglo[pivote])<0 && izquierda<derecha){
					izquierda++;
				}
				if (derecha!=izquierda){
					elementoAux= nuevoArreglo[derecha];
					nuevoArreglo[derecha]=nuevoArreglo[izquierda];
					nuevoArreglo[izquierda]=elementoAux;
				}
			}
			
			if (izquierda==derecha){
				quickSortAux(nuevoArreglo, izq, izquierda-1);
				quickSortAux(nuevoArreglo, izquierda+1, der);
			}
		}
		else{
			return nuevoArreglo;
			}
		return nuevoArreglo;
		
	}
	/**
	 * Realiza ordenamiento HeapSort
	 * @param arreglo
	 */
	public void HeapSort(Tipo[] arreglo){
    	BUILD_MAX_HEAP(arreglo);
    	for(int i=arreglo.length-1;i>=0;i--){
    		Tipo temp = arreglo[0];
            arreglo[0]=arreglo[i];
            arreglo[i]=temp;
            heapSize  = heapSize-1;
            MAX_HEAPIFY(arreglo,0);
    	}
    }
	/**
	 * Metodo auxiliar
	 * @param i
	 * @return
	 */
    private int LEFT(int i){return 2*i+1;}
    /**
     * Metodo auxiliar
     * @param i
     * @return
     */
    private int RIGHT(int i){return 2*i+2;}
    /**
     * Metodo auxiliar
     * @param arreglo
     */
    private void BUILD_MAX_HEAP (Tipo[] arreglo){
    	heapSize=arreglo.length;
    	for(int i=arreglo.length/2; i>=0;i--)
        {
            MAX_HEAPIFY(arreglo, i);
        }
    }
    /**
     * Metodo auxiliar
     * @param arreglo
     * @param i
     */
    private void MAX_HEAPIFY(Tipo[] arreglo,int i)
    {
        int l=LEFT(i);
        int r=RIGHT(i);
        int largestElementIndex = -1;
        if(l<heapSize && arreglo[l].compareTo(arreglo[i])>0){
            largestElementIndex = l;
        }
        else{
        	largestElementIndex=i;
        }
        if(r<heapSize && arreglo[r].compareTo(arreglo[largestElementIndex])>0){
            largestElementIndex = r;
        }
        if(largestElementIndex!=i)
        {
            Tipo temp = arreglo[i];
            arreglo[i]=arreglo[largestElementIndex];
            arreglo[largestElementIndex]=temp;
            MAX_HEAPIFY(arreglo, largestElementIndex);
        }
     }
    
    public void mergeSort(Comparable [ ] a)
	{
		Comparable[] tmp = new Comparable[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


	private void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


    private void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
    
    /**
     * Crea arreglos aleatorios
     * @param N
     * @return
     */
    public Integer[] RandomArray(int N){
		Integer[] arreglo= new Integer[N];
		for(int i=0; i<arreglo.length; i++){
			arreglo[i] = (int)(Math.random()*100);
		}
		return arreglo;
		
	}
    
}
