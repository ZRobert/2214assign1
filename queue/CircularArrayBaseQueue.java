//*******************************************************************
//CircularArrayBaseQueue.java
//Author: 	Robert Payne
//Date: 		07/13/2012
//Class: 	ITCS 2214-021
//
//Purpose:	CircularArrayBaseQueue is an implementation of a circular
//				array queue that can be used with any data type. The
//				methods included are:
//				
//				enqueue(T data)	adds data to the end of the queue
//
//				dequeue(T data)	removes data from the front of the
//										queue
//
//				isFull()				returns true if the array is full;
//										false if not full
//				
//				isEmpty()			returns true if the array is empty;
//										false if it contains something
//
//				size()				returns an integer with the number
//										of elements that contain data
//
//				reset()				shifts the front of the elements  
//										to the [0] element in the array
//
//				reverse()			switches the elements so they are
//										arranged in reverse order
//
//				shuffle()			randomly arranges the elements in
//										the queue; executes n/2 times
//
//				toString()			outputs the data elements in queue
//										order with a "\n" between them
//			
///////////////////////////////////////////////////////////////////*/

package queue;
import java.util.Random;
import stack.*;

public class CircularArrayBaseQueue<T> implements Queue<T> {

////////////////FIELDS////////////////////////////  
	 
	 final private int DEFAULT_CAPACITY = 10;
    private T[] contents;
    private int front;
    private int rear;

/////////////CONSTRUCTORS/////////////////////////  

    public CircularArrayBaseQueue() {
		
		  contents = (T[]) new Object[DEFAULT_CAPACITY];
		  front = 0;
		  rear = 0;
    }//constructor(no arg); sets the array capacity to DEFAULT_CAPACITY

    public CircularArrayBaseQueue(int capacity) {
	
		  contents = (T[]) new Object[capacity];
		  front = 0;
		  rear = 0;
    }//constructor(int); user defined capacity

//////////////METHODS/////////////////////////////
//////////////enqueue/////////////////////////////
//Places data at the end of the queue if the 
//queue is not already filled.
//Updates the rear index to keep track of where
//the next element will go. Handles array wrap-
//around if needed.
//////////////////////////////////////////////////
	 @Override
    public void enqueue(T data) {
	 	  //DO NOT touch this if statement
			if(isFull()) {
				System.out.print("Queue is full: ");
				return;
			}				

			contents[rear] = data;
			rear++;
				
			if(rear == contents.length)
				rear = 0;

	}//enqueue

///////////////dequeue////////////////////////////
//Checks to see if the array is already empty
//before trying to remove an element. Places
//the front element's data in a temporary 
//container. Then the front element is set to null 
//and the front is updated to the index of the
//next element in the queue. Handles array
//wrap-around if needed.
/////////////////////////////////////////////////

	 @Override
    public T dequeue() {
	 	  //DO NOT touch this if statement
			if(isEmpty()) {
				System.out.print("Queue is empty: ");
				return null;
			}
			
			T temp;
			
			temp = contents[front];
			contents[front] = null;
			front++;
			
			if(front == contents.length)
				front = 0;
	 	  	
			if(contents[front] == null)
			{
					front = 0;
					rear = 0;
					return temp;
			}
				
		   //DO NOT touch this if statement
			if(isEmpty()) {
				reset();
			}
			
			return temp;	
	 }//dequeue

////////////////isFull/////////////////////
//Checks the array to see if the queue
//fills the array. Calls the size()
//method to compare it to the size of the
//array. Returns true if the array is full
//and false if it is not filled.
//////////////////////////////////////////

	 @Override
	 public boolean isFull() {
			
			if(size() == contents.length)
				return true;
			
			else		
				return false;
	 }//isFull
	 
////////////////isEmpty///////////////////
//Checks to see if the first element in
//the queue is set to null. This only 
//occurs when the queue is empty, thus
//returning true if it is set to null.
//Otherwise, returns false.
/////////////////////////////////////////

	 @Override
	 public boolean isEmpty() {
  
		  if(contents[front] == null)
		  		return true;
			
			return false;
    }//isEmpty

//////////////size////////////////////////
//size first checks to see if the first
//element is null. If it is it simply
//returns 0. If not, it will then check
//to see if rear contains anything.
//If rear has something in it, that means
//the array is full since it will only
//contain data if it has wrapped around
//and is referencing the same element
//as front. In this case it returns
//the length of the array. If the array
//is not full, it checks to see if the
//front index is less than the rear
//index. If this is the case it
//returns the difference of the two.
//If the front is more than the rear,
//that means the array has wrapped
//around and size will return the 
//result of that calculation.
/////////////////////////////////////////	  
	 @Override
    public int size() {
        
		  if(contents[front] == null)
		 
		  		return 0;
		  
		  else if(contents[rear] != null)
		  
		  		return contents.length;
		  
		  else if(rear > front)
		  
		  		return rear - front;
	
		  else //(front > rear)
		  	   
				return contents.length - front + rear;
			
    }//size
	 
	 //DO NOT TOUCH	 
	 public int whereIsFront() {
	 		return front;
	 }
	 
	 //DO NOT TOUCH	 
	 public int whereIsRear() {
	 	  	return rear;
	 }
///////////////reset//////////////////
//reset moves the elements so that the
//front of the queue is located at
//index 0 and keeps the elements
//contiguous. This method takes into
//account for wrapping so that the
//integrity of the data structure is
//maintained.
/////////////////////////////////////
  
 	 @Override
	 public void reset() {
			T temp;
			int size = size();
	
		
			if(front == 0)
				return;
			
			else if(front < rear)
			{
				for(int i = 0; i < size; i++)
					{
						contents[i] = contents[front + i];
						contents[front+i] = null;
					}
			 
				rear = rear - front;
				front = 0;
				return;
			}
			
			else if(front >= rear)
			{				
				if(rear == 0)
					temp = contents[contents.length - 1];
				else
					temp = contents[rear - 1];
				for(int k = front; k > 0; k--)
				{
					for(int i = 0; i < size; i++)
					{
						if(k + i == contents.length)
						{
							contents[contents.length - 1] = contents[0];
							contents[0] = null;
						}
						else if(k + i > contents.length)
						{
							contents[k + i - (contents.length + 1)] = contents[k + i - contents.length];
							contents[k + i - contents.length] = null; 
						}
						else //k+ i < contents.length
						{
							contents[k+i - 1] = contents[k + i];
							contents[k + i] = null;
						}

					}
					front--;
					rear--;
					if(rear == -1)
						rear = contents.length - 1;
						
				}
				
				if(size == contents.length)
					contents[contents.length -1] = temp;
			}
			
	 }//reset
	 
/////////////reverse///////////////////
//The reverse method switches the front
//half elements with the rear elements
//without changing the indexes for
//front and rear. This is accomplished
//by using a temp for both instance
//variables. It is also made to handle
//a wrap-around case.
///////////////////////////////////////	 
	 @Override
	 public void reverse() {
	 	
	 	int tempRear = rear;
		int tempFront = front;
		T tempContainer;
		int size = size();
		boolean meet = false;

		while(!(size < 2) && !meet)
		{
			tempRear--;
			if(tempRear == -1)
				tempRear = contents.length - 1;

			tempContainer = contents[tempFront];
			contents[tempFront] = contents[tempRear];
			contents[tempRear] = tempContainer;
			
			tempFront++;
			if(tempFront == tempRear || tempFront + 1 == tempRear || tempFront - 1 == tempRear)
				meet = true;
			
			if(tempFront == contents.length)
				tempFront = 0;
			
	 }

}//reverse()

///////////////shuffle////////////////////////
//The shuffle method uses random integers to
//swap the elements around. It repeats this
//n/2 number of times since that is enough
//to give every element a chance to be swapped
//////////////////////////////////////////////	 
	 @Override
	 public void shuffle() {
	 		
	 		int i = 0;
			T tempContainer;
			Random randomNumber = new Random();
			int tempRear;
			int randRear;
			int randFront;
			int size = size();
			
			if(rear == 0)
				tempRear = contents.length -1;
			else
				tempRear = rear - 1;
				
			if(size> 1)
			{
				while(i <= size/2)
				{  
					if(front >= tempRear)
					{
						do{
							randRear = randomNumber.nextInt(contents.length);
							randFront = randomNumber.nextInt(contents.length);
							}while(randFront < front || randFront > (contents.length - 1)
									 || randRear >= tempRear || randRear < 0);
					}
					else //(front < tempRear)
						do{
							randRear = randomNumber.nextInt(contents.length);
							randFront = randomNumber.nextInt(contents.length);
							}while(randFront > tempRear || randFront < front ||
									 randRear < front || randRear > tempRear  || randFront == randRear);
									
				tempContainer = contents[randFront];
				contents[randFront] = contents[randRear];
				contents[randRear] = tempContainer;
					
				i++;
			}	
			
	 } 
}
////////////toString///////////////////////
//Overrides the toString method to output
//each of the elements in the queue in 
//order as in the queue.
///////////////////////////////////////////
    @Override
    public String toString() {
			
			reset();
			String tempString = contents[front] + "\n";
			int size = size();
			
			for(int i = 1; i < size; i++)
			
			{
				
				if(i == contents.length)
					i = 0;
				tempString += contents[i] + "\n";
			}
			
			return tempString;		
    }//toString
}//eof
