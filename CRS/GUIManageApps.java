package CRS;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.GridLayout;

/**The JDialog that allows Staff to
 * Approve or reject applications 
 * @author Chin Ze Han B1901647
 *
 */
public class GUIManageApps extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the dialog.
	 */
	public GUIManageApps(CRS crs) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		scrollPane = new JScrollPane();
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new ApplicationTM(crs));
		scrollPane.setViewportView(table);
		contentPanel.add(scrollPane);
		{
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
			contentPanel.add(rdbtnNewRadioButton_1);
		}
		{
			JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
			contentPanel.add(rdbtnNewRadioButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Confirm = new JButton("Confirm");
				Confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int application = table.getSelectedRow();
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

	
}
