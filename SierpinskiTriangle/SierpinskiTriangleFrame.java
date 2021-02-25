package schl;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SierpinskiTriangleFrame extends JFrame {
	static int r = 0, gr = 0, b = 255;



	//private JTextField jtfOrder = new JTextField("0", 5); // Order
	private SierpinskiTrianglePanel trianglePanel = new SierpinskiTrianglePanel(); // To display the pattern

	public SierpinskiTriangleFrame() {
// Panel to hold label, text field, and a button
		JPanel panel = new JPanel();
		//panel.add(jtfOrder);
		//jtfOrder.setHorizontalAlignment(SwingConstants.RIGHT);
// Add a Sierpinski triangle panel to the frame
		getContentPane().add(trianglePanel);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnMin = new JButton("-");
		panel.add(btnMin);
		
		JButton btnPlus = new JButton("+");
		panel.add(btnPlus);
// Register a listener
		btnMin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trianglePanel.setOrder(trianglePanel.getOrder()-1);
			}
		});
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trianglePanel.setOrder(trianglePanel.getOrder()+1);
			}
		});

	}

}
