
public class Calculator {
	public enum BiOperatorModes {
		normal, add, minus, multiply, divide 
	}

	public enum MonoOperatorModes {
		silverRatioOperator,toggle,square, squareRoot
	}

	private Double num1, num2;
	private BiOperatorModes mode = BiOperatorModes.normal;

	public Double calculateBiImpl() {
		if (mode == BiOperatorModes.normal) {
			return num2;
		}
		if (mode == BiOperatorModes.add) {
			return num1 + num2;
		}
		if (mode == BiOperatorModes.minus) {
			return num1 - num2;
		}
		if (mode == BiOperatorModes.multiply) {
			return num1 * num2;
		}
		if (mode == BiOperatorModes.divide) {
			return num1 / num2;
		}

		// never reach
		throw new Error();
	}

	public Double calculateBi(BiOperatorModes newMode, Double num) {
		if (mode == BiOperatorModes.normal) {
			num2 = 0.0;
			num1 = num;
			mode = newMode;
			return Double.NaN;
		} else {
			num2 = num;
			num1 = calculateBiImpl();
			mode = newMode;
			return num1;
		}
	}

	public Double calculateEqual(Double num) {
		return calculateBi(BiOperatorModes.normal, num);
	}

	public Double reset() {
		num2 = 0.0;
		num1 = 0.0;
		mode = BiOperatorModes.normal;

		return Double.NaN;
	}

	public Double calculateMono(MonoOperatorModes newMode, Double num) {
		if (newMode == MonoOperatorModes.silverRatioOperator) {
			return (num * 2.4142135623)-(2*num);
		}

		if (newMode == MonoOperatorModes.toggle) {
			return (num * -1);
		}

		if (newMode == MonoOperatorModes.square) {
			return num * num;
		}
		if (newMode == MonoOperatorModes.squareRoot) {
			return Math.sqrt(num);
		}

		// never reach
		throw new Error();
	}

	public void setNumberOne(Double num) {
		num1 = num;
	}

	public void setNumberTwo(Double num) {
		num2 = num;
	}
	
	public void setMode(BiOperatorModes op) {
		mode = op;
	}
	
	public Double getSilverRatio() {
		return 2.4142135623;
	}
	public static void main(String[] args) {
		calculatorUI calculatorUI = new calculatorUI();
		calculatorUI.init();
	}
}
