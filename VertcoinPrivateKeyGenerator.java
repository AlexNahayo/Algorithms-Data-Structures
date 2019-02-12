/**
 * This algorithm created vertcoin private key. 
 * 
 * @author Alex Nahayo
 * @version 12/02/2019
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random; //for random number.
import java.math.BigInteger;


public class VertcoinPrivateKeyGenerator {

		private static final String alphabet = "123456789ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		private static final BigInteger base58 = BigInteger.valueOf(58); //referece for dividing.


 static String sha256(String input) throws NoSuchAlgorithmException {

		 byte[] in = hexStringToByteArray(input);

		 MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		 
		 byte[] result = mDigest.digest(in);

		 StringBuffer sb = new StringBuffer();


	 for (int i = 0; i < result.length; i++) {
	 	sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	 }
	 return sb.toString();
 }

	 public static byte[] hexStringToByteArray(String s) {
			 
			 int len = s.length();
			 byte[] data = new byte[len / 2];
	 
		 for (int i = 0; i < len; i += 2) {
			 data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
			 + Character.digit(s.charAt(i+1), 16));
		 }
	 return data;
	 }

	 //Method for conversion.
	 private static String getRandomHexString(int numchars){
	 	
	 	Random randomNumber = new Random();
	 	
	 	StringBuffer sb = new StringBuffer();
	 	
	 	while(sb.length() < numchars){
	 		sb.append(Integer.toHexString(randomNumber.nextInt()));
	 	}

	 	return sb.toString().substring(0,numchars);

	 }

	 	public static void main(String[] args) {

		//String secret = "5JvVGV1AkvZdeQ4HCmBXK59sZaxrVgohPGGuSDYzsMJhNv47Ypx";
		String eighty = "80"; 
		String secret =  getRandomHexString(64); //Converts string to Hex

		//80 + random hex
		secret = eighty.concat(secret);


		//storing the value of the new string
		String eightyString = secret;

		//System.out.println("Random Hex Byte: " + secret);	 	


		String hashing = null;
		//first hashing  
	 	try{
	 		hashing = sha256(secret);
	 		//System.out.println(sha256(secret));
	 }
	 	catch (NoSuchAlgorithmException e){
	 }
	 	//second hashing

	 	try{
	 		hashing = sha256(secret);
	 		//sSystem.out.println(sha256(secret));
	 }
	 	catch (NoSuchAlgorithmException e){
	 }

	 	String newTEXT = hashing.substring(0,8);

	 	//stick the 8 bit strign to thr end of the eighty string.
	 	String secret2 = eightyString.concat(newTEXT);

	 	BigInteger bignumber = new BigInteger(secret2, 16); //from hex to decimal.

	 //Now we need to convert bignumber into decimal and then to base 58
	 	String final58number = ""; //private key.

	 	while(bignumber.compareTo(base58)>=0){

	 		BigInteger mod58 = bignumber.mod(base58); //storage for mod 58. (remainder)
	 		final58number = alphabet.charAt(mod58.intValue())+final58number; //concatinating the different remainders. check in the list above for convertion
	 		bignumber = bignumber.subtract(mod58); //subtracts bignumber when going down the list to get the next number for division
	 		bignumber = bignumber.divide(base58); //divides each number by base 58.  
	 	}
	 		final58number = alphabet.charAt(bignumber.intValue())+final58number; //last numbet < 58 doesn't hold condition.
	 		System.out.println(final58number); //prints out the private key. KEEP THIS SAFE.
	}
}
