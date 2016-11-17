package es.uvigo.ei.sing.dojo.java8.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.function.IntBinaryOperator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorPanelV1 extends JPanel {
	private static final long serialVersionUID = 1L;

	private final JTextField txtLcd;
	
	private Integer operand1;
	
	private IntBinaryOperator operation;
	
	private boolean clearLcd;
	
	public CalculatorPanelV1() {
		super(new BorderLayout());
		
		this.clearLcd = false;
		this.operand1 = null;
		this.operation = null;

		this.txtLcd = new JTextField("0", 40);
		this.txtLcd.setEditable(false);
		this.txtLcd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		this.add(this.txtLcd, BorderLayout.NORTH);
		this.add(createButtonsPanel(), BorderLayout.CENTER);
	}

	private JPanel createButtonsPanel() {
		final JPanel buttonsPanel = new JPanel(new GridLayout(5, 3));
		
		for (int i = 1; i <= 10; i++) {
			final int value = i%10;
			
			final JButton btn = createButton(Integer.toString(value), () -> addNumber(value));
			
			buttonsPanel.add(btn);
		}
		
		final JButton btnAdd = createButton("+", () -> operate(Math::addExact));
		final JButton btnSub = createButton("-", () -> operate(Math::subtractExact));
		final JButton btnMul = createButton("*", () -> operate(Math::multiplyExact));
		final JButton btnDiv = createButton("/", () -> operate(Math::floorDiv));
		final JButton btnEq = createButton("=", this::operate);
		
		buttonsPanel.add(btnAdd);
		buttonsPanel.add(btnSub);
		buttonsPanel.add(btnMul);
		buttonsPanel.add(btnDiv);
		buttonsPanel.add(btnEq);
		
		return buttonsPanel;
	}
	
	private static JButton createButton(String label, Runnable listener) {
		final JButton btn = new JButton(label);
		btn.addActionListener(e -> listener.run());
		
		return btn;
	}

	private void addNumber(int number) {
		if (this.clearLcd || this.getCurrentValue() == 0) {
			this.clearLcd = false;
			this.txtLcd.setText(Integer.toString(number));
		} else {
			this.txtLcd.setText(this.txtLcd.getText() + number);
		}
	}
	
	private void applyOperation() {
		if (this.operand1 != null && this.operation != null) {
			final int result = this.operation.applyAsInt(this.operand1, this.getCurrentValue());
			
			this.operand1 = null;
			this.operation = null;
			this.txtLcd.setText(Integer.toString(result));
		}
	}

	private void operate() {
		this.applyOperation();
		this.clearLcd = true;
	}
	
	private void operate(IntBinaryOperator operator) {
		this.operate();
		
		this.operand1 = Integer.parseInt(this.txtLcd.getText());
		this.operation = operator;
	}
	
	private int getCurrentValue() {
		return Integer.parseInt(this.txtLcd.getText());
	}
}
