/**
 * This uses the stack to create a directional System. using North, South, East, West, Back (pops the stack in temp variable) and Arrive (to pop the final values). 
 * @author (Alex Nahayo) 
 * @version (19-11-2018)
 */
import java.util.*;

public class Stack
{

		 private int maxSize; // size of stack array
		 private String[] stackArray;
		 private int top; // top of stack

	public Stack (int s) { // constructor

		 maxSize = s; // set array size
		 stackArray = new String[maxSize]; // create array
		 top = -1; // no items yet
	} 

	public void push(String j) { // put item on top of stack

		 top++;
		 stackArray[top] = j; // increment top, insert item
	}

	public String pop() { // take item from top of stack

		return stackArray[top--]; //access item, decrement top
	}

	public String peek() { // peek at top of stack

	 	return stackArray[top];
	}

	public boolean isEmpty() { // true if stack is empty

	 	return (top == -1);
	}

	public boolean isFull() { // true if stack is full

	 	return (top == maxSize-1);
	}

	public void makeEmpty() { // empty stack

		top=-1;
	}


	public static void main(String [] args)
	{	

		Scanner s1 = new Scanner(System.in); 
		Stack theStack = new Stack (101); //initializing the stack varaible 

		String a6 = "ARRIVED"; //for the pop case, which will pop all the values in the stack.


		String myWord; // this variable takes in the string from the user.

		do
		{
			myWord = s1.nextLine();


				switch(myWord) //this will reverse the cases when th user enters 
		{
		case "GO NORTH":
		    theStack.push("GO SOUTH"); //pushin oposite direction.
		break;
		case "GO SOUTH":
		    theStack.push("GO NORTH");
		    break;
		case "GO EAST":
		    theStack.push("GO WEST");
		    break;
		case "GO WEST": 
		   theStack.push("GO EAST");
		    break;

		case "GO BACK":
			String hole = theStack.pop();
			break;
		}
		
		} while(myWord != "ARRIVED" );	

		if( myWord.equals(a6) == true ){

		while (!myWord.isEmpty()){

			String pop =  theStack.pop();

	 	System.out.println(pop);
		 }

	}
	}

	

 
}


