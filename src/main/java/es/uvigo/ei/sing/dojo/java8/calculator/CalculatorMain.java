package es.uvigo.ei.sing.dojo.java8.calculator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CalculatorMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			final JFrame frame = new JFrame("Calculator");
			
//			frame.setContentPane(new CalculatorPanelV1());
			frame.setContentPane(new CalculatorPanelV2());
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setVisible(true);
		});
	}

}
