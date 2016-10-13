package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	public void testManyNumbers() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}
	@Test
	public void testManyNumbersInput1() {
		assertEquals(1, Calculator.add("0,0,0,1"));
	}
	@Test
	public void testNewLineChar() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testNewLineCharInput2() {
		assertEquals(18, Calculator.add("1\n2\n3,10\n1,1"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddNegNumber() {
		assertEquals("Negatives not allowed: -4,-5", Calculator.add("2,-4,3,-5"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddNegNumberInput1() {
		assertEquals("Negatives not allowed: -1", Calculator.add("-1,2"));
	}
}
