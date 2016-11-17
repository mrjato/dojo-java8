package es.uvigo.ei.sing.dojo.java8.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorPanelV2 extends JPanel {
	private static final long serialVersionUID = 1L;

	private final JTextField txtLcd;
	
	private Optional<IntUnaryOperator> operation;
	
	private boolean clearLcd;
	
	public CalculatorPanelV2() {
		super(new BorderLayout());
		
		this.clearLcd = false;
		this.operation = Optional.empty();

		this.txtLcd = new JTextField("0", 40);
		this.txtLcd.setEditable(false);
		this.txtLcd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		this.add(this.txtLcd, BorderLayout.NORTH);
		this.add(createButtonsPanel(), BorderLayout.CENTER);
	}

	private JPanel createButtonsPanel() {
		final JPanel buttonsPanel = new JPanel(new GridLayout(5, 3));
		
		IntStream.rangeClosed(1, 10)
			.map(value -> value % 10)
			.mapToObj(value -> createButton(Integer.toString(value), () -> addNumber(value)))
		.forEach(buttonsPanel::add);
		
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
	
	private static JButton createButton(String label, Runnable action) {
		final JButton btn = new JButton(label);
		btn.addActionListener(e -> action.run());
		
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
		this.operation
			.map(op -> op.applyAsInt(this.getCurrentValue()))
		.ifPresent(value -> {
			this.operation = Optional.empty();
			this.txtLcd.setText(Integer.toString(value));
		});
	}
	
	private void operate(IntBinaryOperator operator) {
		this.operate();
		
		final int op1 = Integer.parseInt(this.txtLcd.getText());
		this.operation = Optional.of(op2 -> operator.applyAsInt(op1, op2));
	}

	private void operate() {
		this.applyOperation();
		this.clearLcd = true;
	}
	
	private int getCurrentValue() {
		return Integer.parseInt(this.txtLcd.getText());
	}
}
