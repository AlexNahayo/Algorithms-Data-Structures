/*  
   This program reads in a list of integers anbd finds the median using Bubble sort.

   @author Alex Nahayo
   @author 15375586
   @version 05/11/2018
 */
   import java.util.*;
    public class BSortAlgo
   {
        public static void main(String[] args)
    { 

         
        Scanner s1 = new Scanner(System.in); //scanner for importing N of array.
        System.out.println("Enter the number of numbers you will input");
        int N = s1.nextInt(); //takes in a value
        s1.nextLine();
        System.out.println("Enter these numbers with a space between them");
        String str=s1.nextLine(); //takes in the value.
        String [] arr=str.split(" "); //storing each value with blank space. 
        int [] myArray = new int[N]; //new int array.

        double median; //initializing median varaible.
        
        //FILLING VALUES FROM STRING ARRAY INTO INT ARRAY
        for(int i=0;i<arr.length;i++) //filling values from string array into int
        {
            myArray[i]=Integer.parseInt(arr[i]); //changing string into an integer
        }
          
           Bubblesort(myArray);//method call.      
                   //filling the array with new values.
        for(int i=0; i < myArray.length; i++)
        {  
           System.out.print(myArray[i] + " ");  
        }  

        ///DETERMING THE MEDIAN 
        if (myArray.length % 2 == 0)
        {
            //this is for if your array has an even ammount of numbers.
            double indexA = myArray[myArray.length / 2 - 1];
            double indexB = myArray[myArray.length / 2];
            median = (indexA + indexB) / 2;
          
        System.out.println(median);
        }
        else
        {
            median = myArray[(myArray.length-1)/2 ];            
            System.out.println(median);
           }

       }
           public static void Bubblesort(int []  values )
           {
               int limit = values.length; //going through the array.
               int temp = 0; //temporary varaible.
               for ( int i = 0; i < values.length; i++)
               { //this will go through all the numbers.

                   limit--; // this will reduce each time a value is in its correct position. (n-1) every times the biggest is found.

                  for( int j = 0; j < limit; j++) //this inner loop will swap each element in respect to the if statement.
                  {

                    if (values[j]> values[j+1])
                    { // if this conditions holds.

                     temp = values[j+1]; //the particular value will be stored in a varaible called temps.
                     values[j+1] = values[j]; //the value of index j+1 can now be over written.
                     values [j]= temp; //copying the the value of temp in j (essentially this swap the two values).
                                       
                       } 
                   }


               }
               


           }
       }    

  





   
