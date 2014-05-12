//*******************************************************************
//Main.java
//Author: 	Robert Payne
//Date: 		07/13/2012
//Class: 	ITCS 2214-021
//
//Purpose:	To test the implementation of ArrayBaseStack.java
//				and CircularArrayBaseQueue.java. The main tests
//				CircularArrayBaseQueue by sending a series of
//          method calls checking the functionality of the data
//				structure. ArrayBaseStack is tested by user input
//				since it is easier to verify that it is working 
//				correctly... namely no wrap-around feature like in
//				CircularArrayBaseQueue.
//				
///////////////////////////////////////////////////////////////////*/

import java.util.Scanner;
import stack.*;
import queue.*;

public class Main {

	  //you can use the following initializations to debug your implementations
    public static void main(String[] args) {		 
		   
		  ArrayBaseStack<String> abs = new ArrayBaseStack<String>();
		  
        CircularArrayBaseQueue<String> cbq = new CircularArrayBaseQueue<String>();
		  
		  Scanner keyboard = new Scanner(System.in);
		  String tempInput;
		  
		  //isEmpty case 1 check
		  if(cbq.isEmpty())
		  		System.out.println("Empty passed");
			else
				System.out.println("Initialization failed");
			System.out.println();
			
			//isFull case 1 check
			if(cbq.isFull())
				System.out.println("isFull failure");
			else
				System.out.println("isFull initialization ok");
			System.out.println();
			
			//checks the position of front and rear
			System.out.println("Front: " + cbq.whereIsFront());
			System.out.println();
			System.out.println("Rear: " + cbq.whereIsRear());
			System.out.println();
			
			//enqueues 'a' 'b' 'c'
			cbq.enqueue("a");
			cbq.enqueue("b");
			cbq.enqueue("c");
			
			//toString check
			System.out.println(cbq.toString());
			
				   
			//enqueues 'a' 'b' 'c' again
			cbq.enqueue("a");
			cbq.enqueue("b");
			cbq.enqueue("c");
		
			/* for testing a capacity <=6 queue
			/////////////////////////////////////////
			if(cbq.isFull())
				System.out.println("isFull is working correctly after full 0/2 queue");
			else
				System.out.println("isFull is not working correctly on full 0/2 queue");
				
			*/
			
			//enqueue and size check should be 7
			cbq.enqueue("d");
			System.out.println();
			if(cbq.size() == 7)
				System.out.println("===Size 7 ok===");
			else
				System.out.println("===Size Fail===");
			System.out.println();
			
			//dequeues the first 'a' 'b'; should be left with cabcd; size 5
			System.out.println("Dequeue: " + cbq.dequeue() + "\n");
			System.out.println("Dequeue: " + cbq.dequeue() + "\n");
			
			//enqueues 'd' 'e' 'f'; queue: cabcddef
			cbq.enqueue("d");
			cbq.enqueue("e");
			cbq.enqueue("f");
		
			//Front rear size 2, 0, 2
			System.out.println("Size: " + cbq.size() + "\n");
			System.out.println("Front: " + cbq.whereIsFront() + "\n");
			System.out.println("Rear: " + cbq.whereIsRear() + "\n");
			
			//outputs the current queue and resets it 
			//c, a, b, c, d, d, e, f
			//Front 0, Rear 8
			System.out.print(cbq.toString());
			
			//Shows that the rear has changed because of reset
			System.out.println("Rear post reset: " + cbq.whereIsRear());
			System.out.println();
		   
			//dequeues c a b; cddef should be left
			System.out.print("\n\ndequeue x 3: " + cbq.dequeue());
			System.out.print(cbq.dequeue());
			System.out.println(cbq.dequeue());
			System.out.println();
			
			//size check, should be 5
			System.out.println("\n" + cbq.size() + " === Size ====");
			
			//Front and Rear check after dequeue
			//Front 3
			//Rear 8
			System.out.println(cbq.whereIsFront());
			System.out.println();
			System.out.println(cbq.whereIsRear());
			System.out.println();
			
			//Enqueues d,e,f; should be cddefdef size 7 after this
			System.out.println("\n=====Enqueue d e f========\n");
			cbq.enqueue("d");
			cbq.enqueue("e");
		 	cbq.enqueue("f");
			
			//Front and Rear check
			System.out.println(cbq.whereIsFront());
			System.out.println();
			System.out.println(cbq.whereIsRear());
			System.out.println();
			
			//toStrings call reverse... so we will call them after reverse
			//System.out.println("\n" + cbq.toString());
			//System.out.println(cbq.toString());
			cbq.reset();
			//Reverse function check
			//was c,d,d,e,f,d,e,f
			System.out.println("\n***Reverse***\n");	
			cbq.reverse();
			//now f,e,d,f,e,d,d,c
			
			//Front and Rear check after reverse
			//Front 3
			//Rear 1
			System.out.println("Reverse finished\n" + "\n Front: " 
									 + cbq.whereIsFront() + "\n Rear: "
									 + cbq.whereIsRear() + "\n");
			
			//toString call should ouput fedfeddc
			System.out.println(cbq);
			
			//size 3 queue check on reverse
			/*
			if(tempInput.compareTo("fed")==0)
				System.out.println("Reverse test 1 pass");
			else
				System.out.println("Reverse test 1 fail");
			*/
			//Dequeues to test the front and rear for shuffle					
			System.out.println("Dequeue: " + cbq.dequeue());
			System.out.println("Dequeue: " + cbq.dequeue());								
			//queue looks like this now: d,f,e,d,d,c
			
			//Front and Rear check 2, 8				
			System.out.println(cbq.whereIsFront());
			System.out.println(cbq.whereIsRear());
			
			//Redisplays size: 6
			System.out.println("Size: " + cbq.size());
			
			//Shuffles
			System.out.println("Shuffle beginning...");
			cbq.shuffle();
			System.out.println("Shuffle finished");
			System.out.println(cbq.whereIsFront());
			System.out.println(cbq.whereIsRear());
			
			System.out.println(cbq.toString());
			System.out.println(cbq.size());
			
			while(0 < cbq.size())
			{
				System.out.print(cbq.dequeue() + "\n");
			}
			
		/* for user testing of CircularBaseQueue.java	
		  while(true)
		  {
		  		System.out.println("Empty? " + cbq.isEmpty());
				System.out.println("Full? " + cbq.isFull());
				System.out.println("Enter an element into the data structure \n"
										+ "z to dequeue \n"
										+ "u to reset \n"
										+ "q to reverse \n"
										+ "w to suffle \n"
										+ "e to show front index \n"
										+ "r to show rear index \n"
										+ "t to size \n"
										+ "y to string \n"
										+ "x to end");
										
				tempInput =keyboard.nextLine();
				
				if(tempInput.compareTo("u") == 0) //reset()
					cbq.reset();
				
				else if(tempInput.compareTo("q") == 0) //reverse()
					cbq.reverse();
				
				else if(tempInput.compareTo("w") == 0) //shuffle()
					cbq.shuffle();
					
				else if(tempInput.compareTo("e") == 0) //whereIsFront()
					System.out.println("Front: " + cbq.whereIsFront());
					
				else if(tempInput.compareTo("r") == 0) //whereIsRear()
					System.out.println("Rear: " + cbq.whereIsRear());
					
				else if(tempInput.compareTo("t") == 0) //size()
					System.out.println("Size: " + cbq.size());
				
				else if(tempInput.compareTo("y") == 0) //toString()
					System.out.println(cbq);
					
				else if(tempInput.compareTo("z") == 0)
					System.out.println("Dequeued : " + cbq.dequeue());
				
				else if(tempInput.compareTo("x") == 0)
					break;
				
				else{
					System.out.println("Enqueued : " + tempInput);
					cbq.enqueue(tempInput);
				}	
		}
		  
		  */
		  //Testing for ArrayBaseStack.java
		  while(!abs.isFull())  
		  {
		  		System.out.println("Empty? " + abs.isEmpty());
				System.out.println("Full? " + abs.isFull());		
				System.out.println("Enter an element into the data structure (x to end): ");
		  		tempInput =(keyboard.nextLine());
		  	
		  		if(tempInput.compareTo("x") == 0)
					break;
				else
					abs.push(tempInput);
		  }
		  
		  System.out.println("Stack:" + abs);
		  System.out.println("Size: " + abs.size());
		  System.out.println("Full? " + abs.isFull());
		  System.out.println("Empty? " + abs.isEmpty());
		  System.out.println("Pop: " + abs.pop());
		  System.out.println("Push: 10");
		  abs.push("10");
		  System.out.println("Stack : " + abs);
		  System.out.println("Bottom : " + abs.bottom());
		  //Asks for a new stack array size
		  //will pop all of the elements from the old stack and push them
		  //onto the new stack
		  System.out.println("Enter size of new array: ");
		  
		  ArrayBaseStack<String> abs2 =new ArrayBaseStack<String>(keyboard.nextInt());
		  while(!abs.isEmpty())
		  		abs2.push(abs.pop());
			
			System.out.println("New Stack: " + abs2);
			
	 }
   
}