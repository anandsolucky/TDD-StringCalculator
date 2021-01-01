import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	StringCalculator sc;
	@BeforeEach
	void init() {
		sc = new StringCalculator();
	}
	
	@Test
	void testOneSimpleAdd() throws NegativeNumberException {
		int expected = 2;
		assertEquals(expected, sc.add("1,1"), "Simple add operation failed");
		expected = 4;
		assertEquals(expected, sc.add("2,2"), "Simple add operation failed");
		expected = 5;
		assertEquals(expected, sc.add("3,2"), "Simple add operation failed");
		expected = 0;
		assertEquals(expected, sc.add(""), "Simple add operation failed");
	}
	
	@Test
	void testTwoUknownAmountOfNumber() throws NegativeNumberException {
		int expected = 6;
		assertEquals(expected, sc.add("1,2,3"), "test 2 unknown amount of number failed");
		expected = 10;
		assertEquals(expected, sc.add("1,1,1,2,5"), "test 2 unknown amount of number failed");
	}
	
	@Test
	void testThreeAllowNewLine() throws NegativeNumberException {
		int expected = 6;
		assertEquals(expected, sc.add("1\n2,3"), "test 3 allowing new line character failed");
		expected = 7;
		assertEquals(expected, sc.add("1\n2\n3,1"), "test 3 allowing new line character failed");
	}
	@Test
	void testFourSupportDiffDelim() throws NegativeNumberException {
		int expected = 3;
		assertEquals(expected, sc.add("//;\n1;2"), "test 4 allowing custom delimiter support failed");
		expected = 3;
		assertEquals(expected, sc.add("//>\n1>2"), "test 4 allowing custom delimiter support failed");
	}
	@Test
	void testFiveNegativeNumberNotAllowed() {
		try {
			sc.add("5,4,-3");
			fail("test 5, couldn't throw exception");
		} catch (NegativeNumberException e) {
			assertThrows(NegativeNumberException.class, ()->sc.add("5,4,-3"));	
		}
	}
	@Test
	void testSixIgnoreBiggerNumberThenThousand() throws NegativeNumberException {
		int expected = 2;
		assertEquals(expected, sc.add("1001,2"), "test 6, Bigger number then 1000 should be ignored");
	}
}
