import java.io.PrintStream;
import java.util.NoSuchElementException;

class StringDoubleEndedQueueImpl <T> implements StringDoubleEndedQueue <T> {
	
	private int size = 0;
	
	public class Node<T> {
		T item;
		Node<T> next;
		Node<T> prev;
		public Node (T v){
			item = v;
			next = null;
			prev = null;
		}
	}private Node <T>head ;
	private Node<T> tail ;
	
	public boolean isEmpty() {
		return (head==null);
	}
	

	/**
	 * insert a String item at the front of the queue
	 */
	public void addFirst(T item) {
		
		Node<T> t = new Node<T>(item);
       if(head == null) {    
           head = tail = t;  
        }else { 
        	head.prev = t; 
        	t.next = head; 
        	head = t;
            t.prev = null; 
         }
		this.size = this.size + 1 ;
	}
	/**
	 * remove and return the item at the front of the queue
	 * @return String from the front of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T removeFirst() throws NoSuchElementException{	
		if (size!=0 ){
			T k= head.item;
			if (size!=1) {		
				head = head.next;	
				head.prev = null;
			}else {
				head = tail = null ; 		
			}
			this.size = this.size - 1;	
			
			return k;
		}
		throw new NoSuchElementException(); 	
	}	
	

	/**
	 * insert a String item at the end of the queue
	 */
	public void addLast(T item) {
		Node <T>t = new Node<T>(item);
		if (size==0) {
			tail = head = t;	
		}else {
		tail.next = t;
		t.prev = tail;
		tail = t;
		}
		this.size = this.size + 1;
	}

	/**
	 * remove and return the item at the end of the queue
	 * @return String from the end of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T removeLast() throws NoSuchElementException{
		if (size!=0) {	
			T n = tail.item;
			if (size!=1) {	
				tail = tail.prev;	
				tail.next = null;
			}
			else{
				
                head = tail = null ;	
			}	
			this.size = this.size - 1;
			
			return n;
	    }else {
	    	throw new NoSuchElementException();
	    }
	}
	
	/**
	 * return without removing the item at the front of the queue
	 * @return String from the front of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T getFirst() {
		if (size!=0){
			
			T m= head.item;
			
			return m ;
		}else{
			throw new NoSuchElementException();
		}			
	}

	/**
	 * return without removing the item at the end of the queue
	 * @return String from the end of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T getLast() {
		if (size!=0){	
			T m= tail.item;		
			return m;
		}else{
			throw new NoSuchElementException();
		}		
	}
	/**
	 * print the String items of the queue, starting from the front, 
     	 * to the print stream given as argument. For example, to 
         * print the elements to the
	 * standard output, pass System.out as parameter. E.g.,
	 * printQueue(System.out);
	 */
	public void printQueue(PrintStream stream) {	
		Node<T> s = head;
		while (s!=null) {
			stream.print(s.item);
			s= s.next;
		}
	}
	
	public int size() {
		return size;
	}		
}