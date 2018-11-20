

/**
 * This application demonstrates the use of the Scanner class 
 * This program takes in any number denoted n and find prime numbers p1 and p2 such that p1 is the nearest prime number below 'n' 
   and p2 is the nearest prime number above 'n' on the number line. 
 * 
 * @author Alex Nahayo
 * @version 15/10/2018
 */
import java.util.Scanner;


public class Prime 
{



     public static void main(String args[]) 
      {

             Scanner myScanner = new Scanner(System.in);
              System.out.println("Please enter your number for n");
             int n = myScanner.nextInt();
            int abovePrime = 0;
            int belowPrime = 0;    
            int finalResult = 0;            



            for (int i = n+1;  i>0; i++) //looking for primes above n 

            {

                        if(isPrime(i)) //looking for prime be

                        {
                             abovePrime = i; 
                             break;


                        } 


            }

                  
                  for (int i =n-1; i>=2; i--) //looking for primes below n

                  {


                        if(isPrime(i))

                        {
                             belowPrime = i;
                             break; //stops when prime is found
                       

                        } 



                  }



                        finalResult = abovePrime - belowPrime;
                        System.out.println(finalResult);
      }              



            public static boolean isPrime(int n) //method for checking primes.
            {

                  for (int j =2; j< n; j++)

                  {
                        if(n%j==0) //checking if it's not prime i.e. this code is checking all posible values for j 

                        {
                              return false; 

                        }


                  }


                  return true;   
            }     


}

