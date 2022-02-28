package CRS;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import CRS.Trip.CrisisType;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

/**The JDialog that allows staff to 
 * create new Trip objects and organize 
 * Trips
 * @author Chin Ze Han B1901647
 *
 */

public class GUIOrganizeTrip extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField tfTripDate;
	private JTextField tfDestination;
	private JTextField tfDescription;
	private JComboBox cbCrisisType;
	private JTextField tfNumOfVol;

	/**
	 * Create the dialog.
	 */
	public GUIOrganizeTrip(CRS crs) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 5));
		contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		{
			JLabel lblNewLabel = new JLabel("Trip Date (dd/MM/yyyy)");
			contentPanel.add(lblNewLabel);
		}
		{
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			tfTripDate = new JFormattedTextField(format);
			contentPanel.add(tfTripDate);
			tfTripDate.setColumns(10);
			MaskFormatter dateMask;
			try {
				dateMask = new MaskFormatter("##/##/####");
	            dateMask.install(tfTripDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		{
			JLabel lblNewLabel_1 = new JLabel("Destination");
			contentPanel.add(lblNewLabel_1);
		}
		{
			tfDestination = new JTextField();
			contentPanel.add(tfDestination);
			tfDestination.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Description");
			contentPanel.add(lblNewLabel_2);
		}
		{
			tfDescription = new JTextField();
			contentPanel.add(tfDescription);
			tfDescription.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Crisis Type");
			contentPanel.add(lblNewLabel_3);
		}
		{
			cbCrisisType = new JComboBox(CrisisType.values());
			contentPanel.add(cbCrisisType);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Volunteer Capacity");
			contentPanel.add(lblNewLabel_4);
		}
		{
			tfNumOfVol = new JTextField();
			contentPanel.add(tfNumOfVol);
			tfNumOfVol.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Create");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String tripDateTxt = tfTripDate.getText();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
						LocalDate tripDate = LocalDate.parse(
								tripDateTxt,formatter);
						String destination = tfDestination.getText();
						String description = tfDescription.getText();
						CrisisType crisis = (CrisisType) cbCrisisType.getSelectedItem();
						int numVol= 0;
						
						try {
						numVol = Integer.parseInt(tfNumOfVol.getText());
						}catch(NumberFormatException NumFEx) {
			            	JOptionPane.showMessageDialog(contentPanel, 
			            			NumFEx + "\nPlease Enter a Number for Volunteer"
			            					+ " Capacity");
			            	tfNumOfVol.setText("");
						}
						
						if(tripDate.isBefore(LocalDate.now())) {
			            	JOptionPane.showMessageDialog(contentPanel, 
			            			"Trip Date cannot be before today");
						}
						else if(destination.isBlank()) {
			            	JOptionPane.showMessageDialog(contentPanel, 
			            			"Destination has to be specified");
						}
						else if(description.isBlank()) {
			            	JOptionPane.showMessageDialog(contentPanel, 
			            			"Description has to be specified");
						}
						else if(cbCrisisType.getSelectedIndex() == -1) {
			            	JOptionPane.showMessageDialog(contentPanel, 
			            			"Please select a crisis type");
						}
						else if(numVol<=5) {
			            	JOptionPane.showMessageDialog(contentPanel, 
			            			"Volunteer capacity should be a "
			            			+ "minimum of 5");
						}
						else {
							Trip newTrip = new Trip(destination, 
									description, tripDate, numVol, crisis);
							int check = crs.getTrips().size();
							crs.addTrip(newTrip);					
							crs.setOrganizer(crs.getLoginUser(), newTrip);
							
							if(check== crs.getTrips().size()) {
				            	JOptionPane.showMessageDialog(contentPanel, 
				            			"Trip was not added");
							}
							else {
				            	JOptionPane.showMessageDialog(contentPanel, 
				            			"Trip added successfully!");
				            	tfTripDate.setText("");
				            	tfDestination.setText("");
				            	tfDescription.setText("");
				            	tfNumOfVol.setText("");
							}

						}
								
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTfTripDate() {
		return tfTripDate;
	}

	public void setTfTripDate(JFormattedTextField tfTripDate) {
		this.tfTripDate = tfTripDate;
	}

	public JTextField getTfDestination() {
		return tfDestination;
	}

	public void setTfDestination(JTextField tfDestination) {
		this.tfDestination = tfDestination;
	}

	public JTextField getTfDescription() {
		return tfDescription;
	}

	public void setTfDescription(JTextField tfDescription) {
		this.tfDescription = tfDescription;
	}

	public JComboBox getCbCrisisType() {
		return cbCrisisType;
	}

	public void setCbCrisisType(JComboBox cbCrisisType) {
		this.cbCrisisType = cbCrisisType;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
	
	

}
