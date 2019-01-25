/**
 * Irish Presidential election simulation problem for general election(2018)
   Each candidates probablities were obtained from Paddy Power

 * @author (Alex Nahayo) 
 * @version (25-10-2018)
 */
import java.util.*;
public class PresidentialElection
{
		public static void main(String [] args)
	{
		int numSuccess  =	0; //COUNTS NUMBER OF SUCCESS. 
		int electCounter = 	0; //ELECTION SIMUNLATION.
		//LIST OF CANDIDATES.
		double candidate1 = 0; //Michael D Higgins
		double candidate2 = 0; //Sean Gallagher
		double candidate3 = 0; //Peter Casey
		double candidate4 = 0; //Liadh Ni Riada
		double candidate5 = 0; //Joan Freeman
		double candidate6 = 0; //Gavin Duffy	
		double ran = 0;

	for(int i=1;i<=1000;i++)
	{
		electCounter++;
	
			for (int j=0; j<=3000000; j++)//THE FIRST ELECTION. 3 MILLION PEOPLE VOTING
		{

			ran = (double) (Math.random() * (100.0)); //GENERATES RANDOM DOUBLE 0-100.
			
			if (ran>=0 && ran <=89.0)
			{
  				candidate1++; 	
			}
		 	else if (ran>89.0 && ran <=93.3)
			{
				candidate2++;
			}
			else if (ran>93.3 && ran <=96.0)
			{
				candidate3++; 
			}
			else if (ran>96.0 && ran <=98.2)
			{
				candidate4++; 
			}
			else if (ran>98.2 && ran <=99.1)
			{
				candidate5++;	
			}		
			else 
			{
				candidate6++; 
			}
		}
			if 		((candidate1>candidate2) && (candidate2>candidate3) && (candidate3>candidate4) && (candidate4>candidate5) && (candidate5>candidate6)) //determines if the order is a correct.
				{
						numSuccess++;
						System.out.println(numSuccess + ": List Match!");
				}

			else
			{
					 System.out.println(nElection + ": List Doesn't Match!");

			}
			
	}

		
			double probability = (double)numSuccess/(double)electCounter; //this obtains probability of the order once simulation is complete //TOTAL PROBABILTY 
			System.out.println(probability);


	}	





}
