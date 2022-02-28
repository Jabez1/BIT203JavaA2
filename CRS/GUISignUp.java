package CRS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**The JDialog that allows new volunteers
 * to sign up and create a new Volunteer object
 * @author Chin Ze Han B1901647
 *
 */
public class GUISignUp {

	private JFrame frame;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfFullName;
	private JTextField tfPhone;

	/**
	 * Create the application.
	 */
	public GUISignUp(CRS crs) {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 30, 30, 100, 50, 200, 30, 30, 30, 30, 30, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 5, 5);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		frame.getContentPane().add(splitPane, gbc_splitPane);
		
		JLabel lblNewLabel = new JLabel("Username:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		tfUsername = new JTextField();
		GridBagConstraints gbc_tfUsername = new GridBagConstraints();
		gbc_tfUsername.insets = new Insets(0, 0, 5, 5);
		gbc_tfUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsername.gridx = 5;
		gbc_tfUsername.gridy = 1;
		frame.getContentPane().add(tfUsername, gbc_tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 3;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfPassword = new JTextField();
		GridBagConstraints gbc_tfPassword = new GridBagConstraints();
		gbc_tfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPassword.insets = new Insets(0, 0, 5, 5);
		gbc_tfPassword.gridx = 5;
		gbc_tfPassword.gridy = 3;
		frame.getContentPane().add(tfPassword, gbc_tfPassword);
		tfPassword.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Full Name:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 5;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tfFullName = new JTextField();
		GridBagConstraints gbc_tfFullName = new GridBagConstraints();
		gbc_tfFullName.insets = new Insets(0, 0, 5, 5);
		gbc_tfFullName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFullName.gridx = 5;
		gbc_tfFullName.gridy = 5;
		frame.getContentPane().add(tfFullName, gbc_tfFullName);
		tfFullName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 7;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfPhone = new JTextField();
		GridBagConstraints gbc_tfPhone = new GridBagConstraints();
		gbc_tfPhone.insets = new Insets(0, 0, 5, 5);
		gbc_tfPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPhone.gridx = 5;
		gbc_tfPhone.gridy = 7;
		frame.getContentPane().add(tfPhone, gbc_tfPhone);
		tfPhone.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = tfPassword.getText();
				String fullName = tfFullName.getText();
				String phone = tfPhone.getText();
					
				if(username.isBlank()) {
	            	JOptionPane.showMessageDialog(frame, 
	            			"Username cannot be blank");
				}
				else if(password.isBlank()) {
	            	JOptionPane.showMessageDialog(frame, 
	            			"Password cannot be blank");
				}
				else if(fullName.isBlank()) {
	            	JOptionPane.showMessageDialog(frame, 
	            			"Full name must be entered");
				}
				else if(!phone.matches("01\\d{8,9}")) {
	            	JOptionPane.showMessageDialog(frame, 
	            			"Invalid Phone Number");
				}
				else {
					Volunteer vol = new Volunteer(username, 
							password, fullName, phone);
					crs.addUser(vol);
	            	JOptionPane.showMessageDialog(frame, 
	            			"Volunteer Added Successfully");
	            	tfUsername.setText("");
	            	tfPassword.setText("");
	            	tfFullName.setText("");
	            	tfPhone.setText("");
				}
			}
		});
		GridBagConstraints gbc_btnSignUp = new GridBagConstraints();
		gbc_btnSignUp.insets = new Insets(0, 0, 5, 5);
		gbc_btnSignUp.gridx = 3;
		gbc_btnSignUp.gridy = 9;
		frame.getContentPane().add(btnSignUp, gbc_btnSignUp);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 9;
		frame.getContentPane().add(btnCancel, gbc_btnCancel);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField() {
		return tfUsername;
	}

	public void setTextField(JTextField textField) {
		this.tfUsername = textField;
	}

	public JTextField getTextField_1() {
		return tfPassword;
	}

	public void setTextField_1(JTextField textField_1) {
		this.tfPassword = textField_1;
	}

	public JTextField getTextField_2() {
		return tfFullName;
	}

	public void setTextField_2(JTextField textField_2) {
		this.tfFullName = textField_2;
	}

	public JTextField getTextField_3() {
		return tfPhone;
	}

	public void setTextField_3(JTextField textField_3) {
		this.tfPhone = textField_3;
	}

	
}
