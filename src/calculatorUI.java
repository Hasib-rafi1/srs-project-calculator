import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class calculatorUI implements ActionListener {

	private final JFrame frame;
	private final JPanel panel;
	private final JPanel buttonPanel;
	private final JPanel numberPanel;
	private final JPanel sidePanel;
	private final JPanel operatorPanel;
	private final JPanel equalPanel;
	private final JTextArea text;
	private final JButton but[], butSilverRatioNumber, butSilverRatioOperator ,butAdd, butMinus, butMultiply, butDivide,
	butEqual, butCancel,butDecimalSeparator,btnToggle,butSquareRoot,butSquare;
	private final Calculator calc;

	private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9"};

	public calculatorUI() {
		frame = new JFrame("Special Calculator");
		frame.setResizable(false);
		panel = new JPanel(new GridLayout(2,0));
		buttonPanel = new JPanel(new GridLayout(0,2));
		numberPanel =new JPanel(new GridLayout(0,3));
		operatorPanel =new JPanel(new GridLayout(4,1));
		equalPanel = new JPanel(new GridLayout(0,1));
		sidePanel = new JPanel(new GridLayout(0,2));
		text = new JTextArea(2, 45);
		but = new JButton[10];
		for (int i = 0; i < 10; i++) {
			but[i] = new JButton(String.valueOf(i));
		}
		butSilverRatioNumber = new JButton("δs - Value");
		butSilverRatioOperator = new JButton("δs - Operator");
		butAdd = new JButton("+");
		butMinus = new JButton("-");
		butMultiply = new JButton("*");
		butDivide = new JButton("/");
		butEqual = new JButton("=");
		btnToggle = new JButton("+/-");
		butCancel = new JButton("C");
		butSquareRoot = new JButton("√a");
		butSquare = new JButton("x*x");
		butDecimalSeparator = new JButton(".");
		calc = new Calculator();
	}

	public void init() {
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.add(text);
		panel.add(buttonPanel);
		buttonPanel.add(numberPanel);
		buttonPanel.add(sidePanel);
		sidePanel.add(operatorPanel);
		sidePanel.add(equalPanel);

		for (int i = 1; i < 10; i++) {
			numberPanel.add(but[i]);
			but[i].addActionListener(this);

		}

		numberPanel.add(butSilverRatioNumber);
		numberPanel.add(but[0]);
		but[0].addActionListener(this);
		numberPanel.add(butDecimalSeparator);


		operatorPanel.add(butAdd);
		operatorPanel.add(butMinus);
		operatorPanel.add(butMultiply);
		operatorPanel.add(butDivide);


		equalPanel.add(butCancel);        
		equalPanel.add(butSilverRatioOperator);      
		equalPanel.add(btnToggle);
		equalPanel.add(butSquare);
		equalPanel.add(butSquareRoot);
		equalPanel.add(butEqual);

		disableBtn();

		butSilverRatioNumber.addActionListener(this);
		butSilverRatioOperator.addActionListener(this);
		butAdd.addActionListener(this);
		butMinus.addActionListener(this);
		butMultiply.addActionListener(this);
		butDivide.addActionListener(this);
		butDecimalSeparator.addActionListener(this);
		butEqual.addActionListener(this);
		butCancel.addActionListener(this);
		btnToggle.addActionListener(this);
		butSquare.addActionListener(this);
		butSquareRoot.addActionListener(this);

	}

	public void activeBtn() {
		butSilverRatioOperator.setEnabled(true);
		btnToggle.setEnabled(true);
		butSquare.setEnabled(true);
		butSquareRoot.setEnabled(true);
		butSilverRatioOperator.setEnabled(true);
	}

	public void disableBtn() {
		butSilverRatioOperator.setEnabled(false);
		btnToggle.setEnabled(false);
		butSquare.setEnabled(false);
		butSquareRoot.setEnabled(false);
		butSilverRatioOperator.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();

		for (int i = 0; i < 10; i++) {
			if (source == but[i]) {
				text.replaceSelection(buttonValue[i]);
				butSilverRatioNumber.setEnabled(false);
				activeBtn();
				return;
			}
		}
		if (source == butSilverRatioNumber) {
			text.replaceSelection("2.4142135623");
			butSilverRatioNumber.setEnabled(false);
			activeBtn();

		}
		if(source== butDecimalSeparator) {
			text.replaceSelection(".");
			butSilverRatioNumber.setEnabled(false);
			butDecimalSeparator.setEnabled(false);
			return;
		}
		if (source == butAdd) {
			writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()));
			butSilverRatioNumber.setEnabled(true);
			butDecimalSeparator.setEnabled(true);

		}

		if (source == butMinus) {
			writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
			butSilverRatioNumber.setEnabled(true);
			butDecimalSeparator.setEnabled(true);
		}

		if (source == butMultiply) {
			writer(calc.calculateBi(Calculator.BiOperatorModes.multiply,
					reader()));
			butSilverRatioNumber.setEnabled(true);
			butDecimalSeparator.setEnabled(true);
		}

		if (source == butDivide) {
			writer(calc
					.calculateBi(Calculator.BiOperatorModes.divide, reader()));
			butSilverRatioNumber.setEnabled(true);
			butDecimalSeparator.setEnabled(true);
		}
		if (source == butSilverRatioOperator) {
			writer(calc
					.calculateMono(Calculator.MonoOperatorModes.silverRatioOperator, reader()));
			butSilverRatioNumber.setEnabled(true);
			butDecimalSeparator.setEnabled(true);
		}

		if(source == btnToggle) {
			writer(calc
					.calculateMono(Calculator.MonoOperatorModes.toggle, reader()));
		} 
		if (source == butSquare) {
			writer(calc.calculateMono(Calculator.MonoOperatorModes.square,
					reader()));
		}

		if (source == butSquareRoot) {
			writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot,
					reader()));
		}



		if (source == butEqual) {
			writer(calc.calculateEqual(reader()));
			butSilverRatioNumber.setEnabled(true);
			butDecimalSeparator.setEnabled(true);
		}

		if (source == butCancel) {
			writer(calc.reset());
			butSilverRatioNumber.setEnabled(true);
			butDecimalSeparator.setEnabled(true);
			disableBtn();
		}

		text.selectAll();
	}

	public Double reader() {
		Double num;
		String str;
		str = text.getText();
		num = Double.valueOf(str);

		return num;
	}

	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			text.setText("");
		} else {
			text.setText(Double.toString(num));
		}
	}
}
