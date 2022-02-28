package CRS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CRS.Trip.CrisisType;
import CRS.GUIViewAll.TableType;


public class CRSGUI {

	private JFrame frame;
	static Scanner kbd;
	private CRS crs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRSGUI window = new CRSGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CRSGUI() {
		setCrs(new CRS());
		addUsers(crs);

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(5, 100, 5, 100));
		panel.setLayout(new GridLayout(5, 1, 0, 20));
		
		JButton loginBtn = new JButton("Login");
		panel.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUILoginPage loginPage = new GUILoginPage(crs);
				loginPage.getFrame().setVisible(true);
			}
		});
		
		JButton signUpBtn = new JButton("Sign Up");
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUISignUp signUpPage = new GUISignUp(crs);
				signUpPage.getFrame().setVisible(true);
			}
		});
		panel.add(signUpBtn);
		
		JButton viewAllUsersBtn = new JButton("View All Users");
		viewAllUsersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIViewAll viewAll = new GUIViewAll(crs, TableType.User);
				viewAll.getFrame().setVisible(true);
			}
		});
		panel.add(viewAllUsersBtn);
		
		JButton viewAllTripsBtn = new JButton("View All Trips");
		viewAllTripsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIViewAll viewAll = new GUIViewAll(crs, TableType.Trip);
				viewAll.getFrame().setVisible(true);
			}
		});
		panel.add(viewAllTripsBtn);
		
		JButton fileManageBtn = new JButton("Manage Data File");
		fileManageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIFileManage fm = new GUIFileManage(crs);
				fm.setVisible(true);
				if(fm.isModCheck()) {
					setCrs(fm.getNewCrs());
				}
				
			}
		});
		panel.add(fileManageBtn);

	}

    /**
     * Method used to initialise some domain objects, such as 
     * staff (admin), and volunteer.
     */
    public static void addUsers(CRS crs) {
		crs.addUser(new Staff("manager", "manager", "James Bond", 
				"012-1234567", "Manager", LocalDate.of(2000, 3, 28)));
		crs.addUser(new Volunteer("benjamin", "benjamin", 
				"Benjamin", "012-4"));
		crs.addUser(new Staff("jimmy", "jimmy", 
				"Jimmy", "011-1", "Admin", LocalDate.of(2009, 1, 20)));
		crs.addUser(new Staff("jenny", "jenny", 
				"Jenny", "011-3", "Junior Admin", LocalDate.of(2020, 11, 11)));
		crs.addUser(new Volunteer("alex", "alex", 
				"Alex", "012-5"));
		
		Trip trip = new Trip("5.5 Richter Scale", "Metropolitan City", 
				LocalDate.of(2021, 3, 22), 3, CrisisType.EARTHQUAKE);
			crs.addTrip(trip);
			crs.setOrganizer(crs.getUsers().get(2), trip);
			
			
		Application app = new Application(LocalDate.now(), 
				trip, (Volunteer) crs.getUsers().get(1));
			trip.addApplication(app);
			app.setTrip(trip);
			
    }
    
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return CRS object
	 */
	public CRS getCrs() {
		return crs;
	}

	/**
	 * 
	 * @param crs to set
	 */
	public void setCrs(CRS crs) {
		this.crs = crs;
	}

	
	
}
