package stack;

public interface Stack<T> {

	public void push(T data);
	
	public T pop();
	
	public T bottom();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public int size();
	
	@Override
	public String toString();	
	
}