package CRS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import javax.swing.JButton;

/**To allow Managers to  
 * Create a new Staff Object and register 
 * a new staff into the system
 * @author Chin Ze Han B1901647
 *
 */
public class GUIRecordStaff {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	public GUIRecordStaff(CRS crs) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(5, 100, 5, 100));
		panel.setLayout(new GridLayout(0, 2, 20, 20));
		
		JLabel lblNewLabel = new JLabel("Username:");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Full Name:");
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number:");
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Position:");
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Date Joined");
		panel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		panel.add(btnNewButton_1);
	}

}
