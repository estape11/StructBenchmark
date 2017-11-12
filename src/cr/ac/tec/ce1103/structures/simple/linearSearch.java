package cr.ac.tec.ce1103.structures.simple;
/**
 * Realiza una busqueda lineal
 * @author Daniela Hern�ndez
 *
 */
public class linearSearch {
	public static  int pointer=0;
	public static  boolean result=false;
	public  <AnyType extends Comparable<? super AnyType>> void search(AnyType[] a, int value){
		result=false;
		for (int i=0;i<a.length;i++){
			int val =(int)a[i];
			if(val==value){
				pointer=i;
				result=true;
				break;
			}
		}
		
	}

}
