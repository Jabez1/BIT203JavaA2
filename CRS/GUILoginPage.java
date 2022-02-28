package CRS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

/**
 * Creates the Login Page which links to most of 
 * the other use cases
 * @author Chin Ze Han B1901647
 *
 */
public class GUILoginPage {

	private JFrame frame;
	private JTextField textUser;
	private JPasswordField textPass;

	/**
	 * Create the application.
	 */
	public GUILoginPage(CRS crs) {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Login");
		
		JPanel panelSouth = new JPanel();
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(20, 50, 20, 50));
		
		JLabel lblNewLabel_1 = new JLabel("Username: ");
		
		textUser = new JTextField();
		textUser.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		
		textPass = new JPasswordField();
		textPass.setColumns(10);
		panel.setLayout(new GridLayout(0, 2, 0, 30));
		panel.add(lblNewLabel_1);
		panel.add(textUser);
		panel.add(lblNewLabel_2);
		panel.add(textPass);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
	            String username = getTextUser().getText();
	            String inPassword = getTextPass().getText();
	            
	            if(username.isEmpty()) {
	            	JOptionPane.showMessageDialog(frame, 
	            			"Username field cannot be left blank!");
	            }
	            else if (inPassword.isEmpty()) {
	            	JOptionPane.showMessageDialog(frame,
	            			"Password cannot be blank!");
	            }
	            else {
	            	User loginUser = crs.findUser(username);
		    		if (loginUser == null) {
		    			JOptionPane.showMessageDialog(frame, 
		    					"Username not found!");
		    			
		    		}
		    		else if (!loginUser.getPassword().equals(inPassword)) {
		        		JOptionPane.showMessageDialog(frame, 
		        				"Invalid password!");
		        		textPass.setText("");
		        		textPass.requestFocus();
		    		}	            
		            else {
		            	crs.setLoginUser(loginUser);
		            	GUITaskSelect taskWindow= new GUITaskSelect(crs);
		            	taskWindow.getFrame().setVisible(true);
		            	frame.dispose();
		            }
	            }
			}
		});
		panelSouth.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panelSouth.add(btnCancel);
	}

	public JTextField getTextUser() {
		return textUser;
	}

	public void setTextUser(JTextField textUser) {
		this.textUser = textUser;
	}

	public JPasswordField getTextPass() {
		return textPass;
	}

	public void setTextPass(JPasswordField textPass) {
		this.textPass = textPass;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
}


