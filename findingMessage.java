
// Question:
//Alice’s public key is (24852977, 2744, 8414508). You eavesdrop on the line and
// observe Bob send her the cipher (15268076, 743675). Extract the message by any
// means.
// Warning: for the programming part, make sure to use longs rather than ints (you
// may need to put an ‘l’ at the end of the number). Also, make sure to keep 
// modulo-ing every time the number in the calculation gets a little too big – never
// do large power multiplications straight off because Java cannot process large
// numbers like this.
// As a result, it might be worthwhile to use these recursive methods for modulo
// multiplication and modulo raising to a power. These work efficiently and ensure
// that the numbers never get too big. 
/**
 * 
 * @author (Alex Nahayo) 
 * @version (02-04-2019)
 */
 
import java.util.Scanner;
public class findingMessage {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		//String array for reading in public key (p, g, result).
        String Arr[] = sc.nextLine().split(" ");
        //splits THE given string in three parts, p,g and g^x mod d p(result).
		long p = Long.parseLong(Arr[0]);
		long g = Long.parseLong(Arr[1]);
		long result = Long.parseLong(A[2]);
		
		long x = 0;
		//Try every possible value for x (private key ) between 0 and p until until it satifies  g^x mod p
		for(long i = 0; i < p; i++){
			//each time it is stored in the in the temp fro comaparison.
			long temp = modPow(g, i, p);
			if(temp == result){
				x = i;
				break;
			}	
		}
		
		//string array for reading in given cipher (c1, c2)
       	String Arr2[] = sc.nextLine().split(" ");
       	//getting c1 and c2 and placeing them in log variable.
		long c1 = Long.parseLong(Arr2[0]);
		long c2 = Long.parseLong(Arr2[1]);
		
		//escapping once values have beeen chosen
		sc.close();
		
		//forumula to getting the message ( c1^p-1-x mod p)
		long power = p - 1 - x;
		long first = modPow(c1, power, p);
		
		//Print out the message 
		System.out.println(modMult(first, c2, p));
	}
	
	//Power mod method 
	public static long modPow(long number, long power, long modulus){
	//raises a number to a power with the given modulus
	//when raising a number to a power, the number quickly becomes too large to handle
	//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
	//however you want the algorithm to work quickly - having a multiplication loop would result in an O(n) algorithm!
	//the trick is to use recursion - keep breaking the problem down into smaller pieces and use the modMult method to join them back together
		 if(power==0)
			 return 1;
		 else if (power%2==0) {
			 long halfpower=modPow(number, power/2, modulus);
			 return modMult(halfpower,halfpower,modulus);
		 }else{
			 long halfpower=modPow(number, power/2, modulus);
			 long firstbit = modMult(halfpower,halfpower,modulus);
			 return modMult(firstbit,number,modulus);
		 }
	}
	 

	public static long modMult(long first, long second, long modulus){
	//multiplies the first number by the second number with the given modulus
	//a long can have a maximum of 19 digits. Therefore, if you're multiplying two ten digits numbers the usual way, things will go wrong
	//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
	//however you want the algorithm to work quickly - having an addition loop would result in an O(n) algorithm!
	//the trick is to use recursion - keep breaking down the multiplication into smaller pieces and mod each of the pieces individually
		 if(second==0)
			 return 0;
		 else if (second%2==0) {
			 long half=modMult(first, second/2, modulus);
			 return (half+half)%modulus;
		 }else{
			 long half=modMult(first, second/2, modulus);
			 return (half+half+first)%modulus;
		 }
	}
}
