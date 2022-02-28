package CRS;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**The JDialog to allow volunteers
 * to Apply For Trips 
 * 
 * @author Chin Ze Han
 *
 */
public class GUIApplyForTrip extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	private TripTM tripTM;

	/**
	 * Create the dialog.
	 */
	public GUIApplyForTrip(CRS crs) {
		setTripTM(new TripTM(crs));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		scrollPane = new JScrollPane();
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(getTripTM());
		scrollPane.setViewportView(table);
		contentPanel.add(scrollPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Confirm = new JButton("Apply");
				Confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int trip = table.getSelectedRow();
						Trip selTrip = getTripTM().getTripAt(trip);
						
						Application newApp = 
								new Application(LocalDate.now()
										,selTrip, (Volunteer)crs.getLoginUser());
						if(selTrip.addApplication(newApp)) {
			            	JOptionPane.showMessageDialog(contentPanel, 
			            			"Applied for Trip successfully!");
						}
					}
				});
				Confirm.setVerticalAlignment(SwingConstants.BOTTOM);
				Confirm.setActionCommand("OK");
				buttonPane.add(Confirm);
				getRootPane().setDefaultButton(Confirm);
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

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public TripTM getTripTM() {
		return tripTM;
	}

	public void setTripTM(TripTM tripTM) {
		this.tripTM = tripTM;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
	

}
