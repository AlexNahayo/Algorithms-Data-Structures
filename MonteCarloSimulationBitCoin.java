/**
 * This algorithm uses Monte Carlo Simulation (to replicate bitcoin mining) in this particular case simulated a six sided die and the probability of rolling a 6 and minining a bitcoin at the same time. 
 * @author (Alex Nahayo) 
 * @version (18-12-2018)
 */
import java.util.*;

	public class MonteCarloSimulationBitCoin {


		public static void main(String[] args){ 

     	 	///simulation rolling a dice and print out the results
			Random r = new Random();

     	 	//probabilities of getting each face of a 6 sided dies
     	 	int dieOne = 0;
     	 	int dieTwo = 0;
     	 	int dieThree = 0;
     	 	int dieFour = 0;
     	 	int dieFive = 0;
     	 	int dieSix = 0;
     	 	int diceRolls = 1;
     	 	int dieNumber = 0; 

     	 	int simulation = 1000000;

     	 	int bitCoinCounter = 0;

        int time = 0;
        
        double average=0;
     	 

	     	  while (diceRolls<= simulation){
	     	 	dieNumber = r.nextInt(6); //this will generate a random interger from 0-5 which is 1 to sick 
	     	 	dieNumber++; //this will take care of the zero so it qwill infact range from 1-6.
          time =  diceRolls*3;
	     	 	
	     	 	 if (dieNumber == 1) {
			        	dieOne++;
			    } 
			    else if (dieNumber == 2) {
			        	dieTwo++;
			    } 
			    else if (dieNumber == 3) {
			       		dieThree++;
			    } 
			    else if (dieNumber== 4) {
			        	dieFour++;
			    } else if (dieNumber == 5) {
			        	dieFive++;
			    }
			    else if (dieNumber == 6 && time % 600 == 0 ) {
			        	dieSix++;
			    }
	     	 	
	     	 	diceRolls++;
       		}

          average = (double)(diceRolls)/dieSix ;

       		System.out.println();
         System.out.println("The average number of getting a 6 is " + average);
       	}   	
    }


	
