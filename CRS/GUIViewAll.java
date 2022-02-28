package CRS;

import java.awt.EventQueue;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;


/**The JDialog that displays all objects of a
 * certain type in a table
 * @author Chin Ze Han B1901647
 *
 */
public class GUIViewAll {

	public enum TableType{
		VolApplication,
		Application,
		User,
		Trip
	}
	private JFrame frame;
	private JTable table;
	private JTable table2;
	private CRS crs;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	

	public GUIViewAll(CRS crs, TableType tt) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane2 = new JScrollPane();
		
		
		if (tt == TableType.User) {
			
			String[] header = {"Username","Password","Full Name","User Type"};
			Object[][] data = new Object[crs.getUsers().size()][];
			for(int i = 0; i<crs.getUsers().size(); i++) {
				Object[] info = {
						crs.getUsers().get(i).getUsername(),
						crs.getUsers().get(i).getPassword(),
						crs.getUsers().get(i).getName(),
						crs.getUsers().get(i).getClass().getSimpleName()
				};
				data[i]= info;
			}
			
		

			table = new JTable(data, header);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			panel.add(scrollPane);
			
			
			table2= new JTable();
			table2.setModel(new ApplicationTM(crs));
			scrollPane2.setViewportView(table2);
			panel.add(scrollPane2);
			
		
		}
		else if(tt == TableType.Trip) {
			table= new JTable();
			table.setModel(new TripTM(crs));
			scrollPane.setViewportView(table);
			scrollPane.setPreferredSize(new Dimension(1000,400));
			panel.add(scrollPane);
		}
		else if(tt== TableType.VolApplication) {
			table= new JTable();
			Volunteer vol = (Volunteer) crs.getLoginUser();
			table.setModel(new ApplicationTM(crs, vol));
			scrollPane.setViewportView(table);
			scrollPane.setPreferredSize(new Dimension(1000,400));
			panel.add(scrollPane);
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTable getTable2() {
		return table2;
	}

	public void setTable2(JTable table2) {
		this.table2 = table2;
	}
	
	public CRS getCrs() {
		return crs;
	}

	public void setCrs(CRS crs) {
		this.crs = crs;
	}
	
	
}
