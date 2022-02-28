package CRS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CRS.GUIViewAll.TableType;

/**The JDialog that displays either Volunteer
 * or Staff use cases depending on whichever
 * user type logged in 
 * @author Chin Ze Han B1901647
 *
 */
public class GUITaskSelect {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public GUITaskSelect(CRS crs) {

		frame = new JFrame();
		frame.setBounds(400, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(5, 100, 5, 100));
		panel.setLayout(new GridLayout(5, 1, 0, 20));
		
		JButton btnApplyTrip = new JButton("Apply For a Trip");
		btnApplyTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApplyForTrip tripApply = new GUIApplyForTrip(crs);
				tripApply.setModal(true);
				tripApply.setVisible(true);
			}
		});
		
		JButton btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		JButton btnDocs = new JButton("My Documents");
		btnDocs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIViewAll users = new GUIViewAll(crs, TableType.User);
				users.getFrame().setVisible(true);
			}
		});
		
		JButton btnApps = new JButton("My Applications");
		btnApps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIViewAll myApps = new GUIViewAll(crs,
						TableType.VolApplication);
				myApps.getFrame().setVisible(true);

			}
		});
		
		JButton btnOrgTrip = new JButton("Organize Trip");
		btnOrgTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIOrganizeTrip newTrip = new GUIOrganizeTrip(crs);
				newTrip.setModal(true);
				newTrip.setVisible(true);
			}
		});
		
		JButton btnManageApp = new JButton("Manage Applications");
		btnManageApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIManageApps appWin = new GUIManageApps(crs);
				appWin.setModal(true);	
				appWin.setVisible(true);
			}
		});
		
		
		if(crs.getLoginUser() instanceof Volunteer) {
			panel.add(btnApplyTrip);
			panel.add(btnUpdateProfile);
			panel.add(btnDocs);
			panel.add(btnApps);
		}
		else if(crs.getLoginUser() instanceof Staff)  {
			panel.add(btnOrgTrip);
			panel.add(btnManageApp);
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
}
