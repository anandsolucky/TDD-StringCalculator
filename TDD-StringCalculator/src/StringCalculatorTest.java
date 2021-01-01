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
	void testOneSimpleAdd() {
		int expected = 2;
		assertEquals(expected, sc.add("1,1"), "Simple add operation failed");
		
	}
}
