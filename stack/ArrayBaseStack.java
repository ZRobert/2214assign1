//*******************************************************************
//ArrayBaseStack.java
//Author: 	Robert Payne
//Date: 		07/13/2012
//Class: 	ITCS 2214-021
//
//Purpose:	ArrayBase Stack is an implementation of an array 
//				stack that can be used with any data type. The
//				methods included are:
//				
//				push(T data)		adds data to the top of the stack
//
//				pop(T data)			removes data from the top of the 
//										stack
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
//				toString()			outputs the data elements in queue
//										order with a "\n" between them
//			
///////////////////////////////////////////////////////////////////*/

package stack;

public class ArrayBaseStack<T> implements Stack<T> {
	
/////////////////FIELDS//////////////////////////
	final private int DEFAULT_CAPACITY = 10;
   private T[] contents;
	private int top;

////////////////CONSTRUCTORS//////////////////////
	public ArrayBaseStack() {

		  contents = (T[])(new Object[DEFAULT_CAPACITY]);
		  top = DEFAULT_CAPACITY - 1;

 	}//constructor(no arg); sets the array capacity to DEFAULT_CAPACITY

   public ArrayBaseStack(int capacity) {
		 
		  contents = (T[])(new Object[capacity]);
		  top = capacity -1;
   }//constructor(int); sets the array capacity to the input integer    

//////////////////METHODS//////////////////////////
//////////////////push/////////////////////////////
//This method takes data in and pushes it on to the
//current top of the stack and updates the top
//so the next element will go on top.
///////////////////////////////////////////////////	
	@Override
    public void push(T data) {
	 	  //DO NOT touch this if statement	
	 	  if(isFull()) {
		  		System.out.println("Stack is full");
				return;
		  }
		  	  		
		  contents[top] = data;
		  top--;
    }//push

/////////////////////pop//////////////////////////
//Takes the top element off of the stack and 
//returns the contents to the caller. Updates
//the top index.
//////////////////////////////////////////////////
	@Override
    public T pop() {
	 	  //DO NOT touch this if statement
	 	  if(isEmpty()) {
		  		System.out.println("Stack is empty");
				return null;
		  }
		  
		  T tempContainer;
		  
		  tempContainer = contents[top+1];
		  contents[top+1] = null;
		  if(!isEmpty())
		  		top++;
		  return tempContainer;
    }//pop

///////////////bottom/////////////////////////
//Bottom checks to see what the bottom element
//contains and then returns it. It does not
//update any indexes.
///////////////////////////////////////////////
	@Override
    public T bottom() {
	 	   //DO NOT touch this if statement
	 		if(isEmpty()) {
				System.out.println("Stack is empty");
				return null;
			}
			
			return contents[contents.length - 1];
    }//bottom
	 
///////////////////isEmpty//////////////////////
//Checks the bottom of the stack to see if there
//is anything in there. If it is equal to null
//then the whole stack is empty.
////////////////////////////////////////////////
	@Override
    public boolean isEmpty() {
	 
			if(contents[contents.length - 1] == null)
  				return true;
			else
				return false;  
	 }//isEmpty

////////////////isFull//////////////////////////
//Checks the last element of the array to see if
//it has something in it. If it does then the
//stack is full.
////////////////////////////////////////////////
	@Override 
	 public boolean isFull() {

			if(contents[0] != null)
				return true;
			else
				return false;
	 }//isFull

/////////////////size//////////////////////////
//Calculates the size of the stack based on the
//position of the top relative to the bottom
//and returns it as an integer.
///////////////////////////////////////////////
	@Override
    public int size() {
	 	
			return contents.length - top -1;
    }//size

//////////////////toString/////////////////////
//Converts the data from the stack into a 
//string seperating each element with a "\n"
//and outputs the string to the caller.
///////////////////////////////////////////////
	@Override	 
	 public String toString() {
			
			String tempString = contents[top + 1] + "\n";
			
			for(int i = top + 2; i < contents.length; i++)
				tempString += contents[i] + "\n";
			
			return tempString;
	 }//toString
}//eof
