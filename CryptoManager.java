/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: 
 * Due: 03/19/2024
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming  assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: __Kyle Yee________
*/


public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';	//A character value that is not changed, the "space" is the equivalent value to 32 in ASCII 
	private static final char UPPER_RANGE = '_';	//A character value that is not changed, the "underscore" is the equivalent value to 95 in ASCII 
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1; //A integer value that is not changed, the math of finding a range between two numbers. 

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) { //This method is for determining if a string in between the lower and upper range.
		 
		boolean result = true;
		for(int index = 0; index < plainText.length(); index++) //For loop that goes through each character in the string. 
		{
			if(!(plainText.charAt(index)>=LOWER_RANGE && plainText.charAt(index)<=UPPER_RANGE)) //If-statement/condition that returns false when not in the certain range. 
			{
				result = false;
			}
			
		}
		return result;	//Returns the result true or false. Depending on the if-condition. 
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {	//This method encrypts a String according to Caesar Cipher. 
		String ceasarEncryption = "";
		
		if(!isStringInBounds(plainText))	//if-condition that checks if the string is valid, between the upper and lower range. 
		{
			return "The selected string is not in bounds, Try again.";	//When not, returns this message. 
		}
		
		if(isStringInBounds(plainText))		//When valid and between the range, will continue to encrypt. 
		{
			for(int index = 0; index < plainText.length(); index++)	//For loop that goes through each character in the string. 
			{
				char ceasarChar = plainText.charAt(index);	
				int encryptedChar = ((int)ceasarChar+key);	//Takes each character in the string and encrypts by substituting to a integer.
				
				while(encryptedChar > UPPER_RANGE)		//While integer is greater than upper range, its subtracted to get into the range.
				{
					encryptedChar = encryptedChar - RANGE; 
				}
				ceasarEncryption = ceasarEncryption + (char)encryptedChar; //The new encrypted integer is converted to according character value. 
			}
			
		}
		return ceasarEncryption;	//Returns the new encrypted character value. 
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {	//This method encrypts a string due to Bellaso Cipher. 
		String bellasoEncryption = "";
		
		for(int index = 0; index < plainText.length(); index++)	//For loop that goes through each character in the string.
		{
			char bellasoChar = plainText.charAt(index);
			int encryptedChar = ((int)bellasoChar+(int)bellasoStr.charAt(index%bellasoStr.length()));
			//Key word is stretched to the string length, then substituted to an integer.  
			
			while(encryptedChar > UPPER_RANGE)
			{
				encryptedChar = encryptedChar - RANGE;	//While integer is greater than upper range, its subtracted to get into the range.
			}
			bellasoEncryption = bellasoEncryption + (char)encryptedChar;
		}
		return bellasoEncryption;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {	//This method is very similar to Ceasar Encryption method, except this time we work backwards.
		String ceasarDecryption = "";
		
		for(int index = 0; index < encryptedText.length(); index++) //For loop that goes through each character in the string.
		{
			char ceasarChar = encryptedText.charAt(index);
			int decryptChar = ((int)ceasarChar - key);
			
			while(decryptChar < LOWER_RANGE)	//While integer is less than lower range, its incremented to get into the range.
			{
				decryptChar = decryptChar + RANGE;
			}
			ceasarDecryption = ceasarDecryption + (char)decryptChar;
		}
		return ceasarDecryption;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
	String bellasoDecryption = "";
		
		for(int index = 0; index < encryptedText.length(); index++)	//For loop that goes through each character in the string.
		{
			char bellasoChar = encryptedText.charAt(index);
			int decryptChar = ((int)bellasoChar - (int)bellasoStr.charAt(index%bellasoStr.length()));
			
			while(decryptChar < LOWER_RANGE)	//While integer is less than lower range, its incremented to get into the range.
			{
				decryptChar = decryptChar + RANGE;
			}
			bellasoDecryption = bellasoDecryption + (char)decryptChar;
		}
		return bellasoDecryption;
	}
}