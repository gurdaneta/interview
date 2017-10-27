package com.hps.luhn;


/**
 * @see https://en.wikipedia.org/wiki/Luhn_algorithm#Description
 */
public class Luhn {

	/**
	 * TODO
	 * 
	 * Accepts a card number and determines if the card number is a valid number
	 * with respect to the Luhn algorithm.
	 * 
	 * @param cardNumber
	 *            the card number
	 * 
	 * @return true if the card number is valid according to the Luhn algorithm,
	 *         false if not
	 */
	public boolean isValidLuhn(int cardNumber) {		
		boolean doubleDigit = false;
		int sum = getCheckDigit(cardNumber, doubleDigit);
		
		return (sum % 10) == 0;
	}

	/**
	 * Accepts a partial card number (excluding the last digit) and generates
	 * the appropriate Luhn check digit for the number.
	 * 
	 * @param cardNumber
	 *            the card number (not including a check digit)
	 * 
	 * @return the check digit
	 */
	public int generateCheckDigit(int cardNumber) {
		boolean doubleDigit = true;
		int sum = getCheckDigit(cardNumber, doubleDigit);
		
		return (1000 - sum) % 10;
	}

	/**
	 * @param cardNumber
	 * @return
	 */
	private int getCheckDigit(int cardNumber, boolean doubleDigit) {
		int sum = 0;
		while (cardNumber  > 0) {
		// starting from the right (rightmost is the unknown check digit)
			int digit = cardNumber % 10; 

			if (doubleDigit) { // double the value of every second digit
				digit *= 2;

				// if two digits, use the sum of the digits
				if (digit > 10) {
					digit = digit / 10 + digit % 10; 
				}
			}
			doubleDigit = !doubleDigit;
			
			sum += digit;
			
			cardNumber /= 10; // remaining digits to the left
		}
		return sum;
	}
	
	/**
	 * TODO
	 * 
	 * Accepts two card numbers representing the starting and ending numbers of
	 * a range of card numbers and counts the number of valid Luhn card numbers
	 * that exist in the range, inclusive.
	 * 
	 * @param startRange
	 *            the starting card number of the range (may not be valid luhn)
	 * @param endRange
	 *            the ending card number of the range (may not be a valid luhn)
	 * 
	 * @return the number of valid Luhn card numbers in the range, inclusive
	 */
	public int countRange(int startRange, int endRange) {
		int newValue = startRange;
		int n = 0;
		while (newValue <= endRange){
			if (isValidLuhn(newValue))
			{
				n++;
			}
			newValue = newValue + 1;	
		}
		return n;
	}
	//To validate real credit card
	public boolean isValidLuhnRealCard(String cardNumber) {
		 
		boolean doubleDigit = false;
		int sum = getCheckDigitForRealCard(cardNumber, doubleDigit);
		
        return (sum % 10) == 0;
    }
	
	//generalCheckDigitRealCard
	public int generalCheckDigitRealCard(String cardNumber) {
		boolean doubleDigit = true;
		int sum = getCheckDigitForRealCard(cardNumber, doubleDigit);
        
		return (1000 - sum) % 10;
    }
	
	//get digit for real credit card
	private int getCheckDigitForRealCard(String cardNumber, boolean doubleDigit){
		int sum = 0;
		for (int i = cardNumber.length() - 1; i >= 0; i--)
        {
                int digit = Integer.parseInt(cardNumber.substring(i, i + 1));
                if (doubleDigit)
                {
                		digit *= 2;
                        if (digit > 9)
                        {
                        	digit = digit / 10 + digit % 10; 
                        }
                }
                sum += digit;
                doubleDigit = !doubleDigit;
        }
		return sum;
	}
}
