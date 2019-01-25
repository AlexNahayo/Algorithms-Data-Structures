/**

This code calculates if a credit card is valid or invalid.
@author (Alex Nahayo)
@version (01-10-2018) */
import java.util.Scanner;

public class Luhnsalg1 { public static void main(String [] args) {

	Scanner myScan = new Scanner(System.in); // creates a scanner object, links it to the input device.
	System.out.println("Enter a your credit card number  :  "); // ask the user to enter a number.
	String line = myScan.nextLine();//get values from the user.
			
	int sumGreat = 0; // adds even numbers greater than 9
	int sumEless = 0; // adds even numbers less than 9.
	int sumO = 0; //sum of odd numbers.
	int Ddigit = 0; //double the digit.
	int together = 0; //adds numbers together.
    
    	boolean EvenL = true;			
		if (line.length()%2==0) //determines if the code is of even length 
	{
		EvenL = true; 
		//System.out.println(line.length());	
	}

		else //if the code is of odd length
	{
		EvenL = false;	
		//System.out.println(line.length());	
	}
			//this result then goes into this for loop accordingly
			for (int i = line.length() - 1 ; i >= 0 ; i--)
		{ 
			int digit = Character.getNumericValue(line.charAt(i)); //converts string into and integer.		
			Ddigit = 2*digit ; //this doubles the digit.
				
				//double even number greater than 9.
				if  (EvenL && Ddigit > 9)
			{ 
				while (Ddigit > 0) //breaks down each digit.
				{
					sumGreat = sumGreat + Ddigit% 10; //adds all none 
					Ddigit = Ddigit/10 ;
				} 		
			}		
				//double even numbers less than 9.
				else if (EvenL && Ddigit <= 9 )
			{	
					sumEless = sumEless + Ddigit ;
			}
				//add the odd numbers
				else
			{	
						sumO = sumO + Ddigit/2; //the diving by two reverse the 							
			}
		}	
				//test for validation.
					together = sumO + sumEless + sumGreat; //sums up the code.
				if (together % 10 ==0 )
			{
				System.out.println("VALID");
			}
				else 
			{
				System.out.println ("INVALID");
			}
	}
}
