package CRS;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.AbstractTableModel;
/**
 * ApplicationTM is a table model that helps 
 * to populate Application tables with data 
 * @author CHIN ZE HAN B1901647
 */
public class ApplicationTM extends AbstractTableModel {

	private CRS crs;
	private final String[] header = {"Application ID"
			, "Application Date", 
			"Status", "Remarks", "Username", "Trip ID"};
	private ArrayList<Application> crsApps;
	//creates a log of which appID is assigned to which username
	private HashMap<String,String> appUsernames;
	
	
	
	public ApplicationTM(CRS crs) {
		setCrs(crs);
		setCrsApps(new ArrayList<Application>());
		setAppUsernames(new HashMap<String,String>());
		setupCrsApps(crs);

	}
	
	/**
	 * Collects all the applications from all the users
	 * and stores them in a new ArrayList, it also stores
	 * all the applicationIDs and their respective usernames
	 * into a HashMap
	 * @param crs the CRS object that stores the trip
	 * 		  arraylist
	 */
	private void setupCrsApps(CRS crs) {
		for(User user: crs.getUsers())
			if(user instanceof Volunteer) {
				Volunteer vol = (Volunteer) user;
			for(Application app: vol.getApplications()) {
				getCrsApps().add(app);
				getAppUsernames().put(
						app.getApplicationID(),vol.getUsername());
			}
		}
	}

	/**
	 * @param crs a CRS class object to retrieve the application
	 * Lists 
	 * @param crsApps 
	 */
	public ApplicationTM(CRS crs, ArrayList<Application> crsApps) {
		setCrs(crs);
		setCrsApps(crsApps);
		setupCrsApps(crs);
	}
	
	/**
	 * Generates a Table model that only shows
	 * the specific applications of a specified
	 * volunteer
	 * @param crs the CRS object from the application
	 * @param vol the Volunteer that submitted the 
	 * 			  applications
	 */
	public ApplicationTM(CRS crs, Volunteer vol) {
		setCrs(crs);
		setCrsApps(new ArrayList<Application>());
		for(Application app: vol.getApplications()) {
			getCrsApps().add(app);
		}
	}
	/**
	 * @return the crs object
	 */
	public CRS getCrs() {
		return crs;
	}
	
	/**
	 * @param crs the crs to set
	 */
	public void setCrs(CRS crs) {
		this.crs = crs;
	}
	/**
	 * @return the appList
	 */
	public ArrayList<Application> getCrsApps() {
		return crsApps;
	}

	/**
	 * @param appList the appList to set
	 */
	public void setCrsApps(ArrayList<Application> crsApps) {
		this.crsApps = crsApps;
	}

	/**
	 * 
	 * @return the appUsername HashMap
	 */
	public HashMap<String, String> getAppUsernames() {
		return appUsernames;
	}

	/**
	 * 
	 * @param sets the appUsernames HashMap
	 */
	public void setAppUsernames(HashMap<String, String> appUsernames) {
		this.appUsernames = appUsernames;
	}

	@Override
	public int getRowCount() {
		return getCrsApps().size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Application app = getCrsApps().get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return app.getApplicationID();
		case 1:
			return app.getApplicationDate();
		case 2:
			return app.getStatus();
		case 3:
			return app.getRemarks();
		case 4:
			if(getAppUsernames()!=null) {
				return getAppUsernames()
					.get(app.getApplicationID());
			}else {return crs.getLoginUser().getUsername();}

		case 5:
			return app.getTrip().getTripID();
		default:
			return null;
		}
	}
	
	public String getColumnName(int columnIndex) {
		return header[columnIndex];
	}
	
	public Application getApplicationAt(int rowIndex) {
		return crsApps.get(rowIndex);
	}
	
	

}
