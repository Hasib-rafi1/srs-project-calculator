import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CalculatorTest {


	Calculator calculator = new Calculator();
	@BeforeEach
	void setUp() throws Exception {
		calculator.setNumberOne(14.00);
		calculator.setNumberTwo(7.00);
	}

	@Test
	void addTest() {
		calculator.setMode(Calculator.BiOperatorModes.add);
		Double a =calculator.calculateBiImpl();
		Double b = 21.0;
		assertEquals(a,b);
	}
	
	@Test
	void minusTest() {
		calculator.setMode(Calculator.BiOperatorModes.minus);
		Double a =calculator.calculateBiImpl();
		Double b = 7.0;
		assertEquals(a,b);
	}

	@Test
	void multiplyTest() {
		calculator.setMode(Calculator.BiOperatorModes.multiply);
		Double a =calculator.calculateBiImpl();
		Double b = 98.0;
		assertEquals(a,b);
	}
	
	@Test
	void devideTest() {
		calculator.setMode(Calculator.BiOperatorModes.divide);
		Double a =calculator.calculateBiImpl();
		Double b = 2.0;
		assertEquals(a,b);
	}
	
	@Test
	void silverRatioOperator() {
		Double a = calculator.calculateMono(Calculator.MonoOperatorModes.silverRatioOperator,2.00);
		Double b = 0.8284271246000001;
		assertEquals(a,b);
	}
	
	@Test
	void toggleValue() {
		Double a = calculator.calculateMono(Calculator.MonoOperatorModes.toggle,4.00);
		Double b = -4.00;
		assertEquals(a,b);
	}
	
	@Test
	void squreRoot() {
		Double a = calculator.calculateMono(Calculator.MonoOperatorModes.squareRoot,4.00);
		Double b = 2.00;
		assertEquals(a,b);
	}
	
	@Test
	void squre() {
		Double a = calculator.calculateMono(Calculator.MonoOperatorModes.square,2.00);
		Double b = 4.00;
		assertEquals(a,b);
	}
	@Test
	void silverRatioValue() {
		Double a = calculator.getSilverRatio();
		Double b = 2.4142135623;
		assertEquals(a,b);
	}
}
