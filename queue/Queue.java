package queue;

public interface Queue<T> {

    public void enqueue(T data);

    public T dequeue();

    public boolean isEmpty();
	 
	 public boolean isFull();

    public int size();
	 
	 public void reset();
	  
	 public void reverse();
	
	 public void shuffle();
	 	 
	 @Override
	 public String toString();

}
