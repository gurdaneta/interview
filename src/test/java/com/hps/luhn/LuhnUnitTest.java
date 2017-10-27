package com.hps.luhn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LuhnUnitTest {

	Luhn luhn;

	@Before
	public void setUp() throws Exception {
		luhn = new Luhn();
	}

	@Test
	public void generateCheckDigit() {
	 assertEquals(9, luhn.generateCheckDigit(927398719));
	}

	@Test
	public void isValidLuhn() {
		assertFalse(luhn.isValidLuhn(927398710));
		assertFalse(luhn.isValidLuhn(927398711));
		assertFalse(luhn.isValidLuhn(927398712));
		assertFalse(luhn.isValidLuhn(927398713));
		assertFalse(luhn.isValidLuhn(927398714));
		assertFalse(luhn.isValidLuhn(927398715));
		assertFalse(luhn.isValidLuhn(927398716));
		assertFalse(luhn.isValidLuhn(927398717));
		assertFalse(luhn.isValidLuhn(927398718));
		assertTrue(luhn.isValidLuhn(927398719));
	}
	
	@Test
	public void generateCheckDigitRealCard() {
	 assertEquals(2, luhn.generalCheckDigitRealCard("378282246310005"));
	}
	
	//Validate Real Credit Card
	@Test
	public void isValidLuhnRealCard() {
		assertTrue(luhn.isValidLuhnRealCard("378282246310005"));//American Express
		assertFalse(luhn.isValidLuhnRealCard("927398710"));
		assertTrue(luhn.isValidLuhnRealCard("927398719"));
		assertTrue(luhn.isValidLuhnRealCard("6011111111111117"));//Discover
		assertTrue(luhn.isValidLuhnRealCard("5555555555554444"));//Master Card
		assertTrue(luhn.isValidLuhnRealCard("38520000023237"));//dinner club Card
		
	}

	@Test
	public void countRange() {
		assertEquals(1, luhn.countRange(927398710, 927398720));
	}
	
	//For 28 long - gift card
	@Test
	public void generateCheckDigitGiftCard() {
	 assertEquals(9, luhn.generalCheckDigitRealCard("3782822463100059876567898767"));
	 assertEquals(7, luhn.generalCheckDigitRealCard("3782822463100059876567898768"));
	 assertEquals(4, luhn.generalCheckDigitRealCard("3782822463100059876567898760"));
	 assertEquals(2, luhn.generalCheckDigitRealCard("3782822463100059876567898761"));
	}
	
}
