package cr.ac.tec.ce1103.structures.simple;

import java.util.NoSuchElementException;

import cr.ac.tec.ce1103.structures.benchmark.Interfaz;
/**
 * 
 * Clase de listas enlazadas
 *
 * @param <E>
 */
public class DoubleLinkedList<E> {
 
    public Node head;
    private Node tail;
    private int size;
     
    public DoubleLinkedList() {
        size = 0;
    }
    /**
     * this class keeps track of each element information
     * @author java2novice
     *
     */
    private class Node {
        E element;
        Node next;
        Node prev;
 
        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    /**
     * returns the size of the linked list
     * @return
     */
    public int size() { return size; }
     
    /**
     * return whether the list is empty or not
     * @return
     */
    public boolean isEmpty() { return size == 0; }
     
    /**
     * adds element at the starting of the linked list
     * @param element
     */
    public void addFirst(E element) {
        Node tmp = new Node(element, head, null);
        if(head != null ) {head.prev = tmp;}
        head = tmp;
        if(tail == null) { tail = tmp;}
        size++;
        System.out.println("adding: "+element);
    }
     
    /**
     * adds element at the end of the linked list
     * @param element
     */
    public void addLast(E element) {
         
        Node tmp = new Node(element, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
        System.out.println("adding: "+element);
    }
     
    /**
     * this method walks forward through the linked list
     */
    public void iterateForward(){
         
        System.out.println("iterating forward..");
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }
     
    /**
     * this method walks backward through the linked list
     */
    public void iterateBackward(){
         
        System.out.println("iterating backword..");
        Node tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }

	public void remove(int dato,Node cabeza,int cont){
    	if(cont>=this.size()){
    		System.out.println("NO ESTA");
    	}
    	else if(dato==(int)cabeza.element){
    		cabeza.prev.next=cabeza.next;
    		cabeza.next.prev=cabeza.prev;
    		size--;
    				
    	}else{
    		remove(dato,cabeza.next,cont+1);
    	}
    	
    }
    public int search(int dato,Node cabeza,int cont){
    	
    	if(cont>=this.size()){
    		System.out.println("NO ESTA");
    		return -1;
    	}
    		else if(dato==(int)cabeza.element){
    			System.out.println(cont);
    			return cont;
    		}else{
    			System.out.println(cabeza.element);
    			Interfaz.listaTree.add((int)(cabeza.element));
    			return search(dato,cabeza.next,cont+1);
    		}
    	
    }
     
    /**
     * this method removes element from the start of the linked list
     * @return
     */
    public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: "+tmp.element);
        return tmp.element;
    }
     
    /**
     * this method removes element from the end of the linked list
     * @return
     */
    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: "+tmp.element);
        return tmp.element;
    }
     
    public static void main(String a[]){
         
    	DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
        dll.addLast(10);
        dll.addLast(34);
        dll.addLast(56);
        dll.addLast(364);
        dll.addLast(3);
        dll.addLast(6);
        dll.addLast(9);
        dll.addLast(12);
        dll.addLast(15);
        dll.search(360, dll.head, 0);
        dll.remove(3, dll.head,0);
        System.out.println("LA cabeza es "+dll.head.element);
        dll.search(364, dll.head, 0);
       
    }
}
