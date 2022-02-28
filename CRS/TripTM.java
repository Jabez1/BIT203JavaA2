package CRS;

import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.table.AbstractTableModel;
/**
 * TripTM is a table model that helps 
 * to populate Trip tables with data * 
 * Student ID B1901647
 * @author CHIN ZE HAN
 */
public class TripTM extends AbstractTableModel {

	private CRS crs;
	private final String[] header = {"Trip ID", 
			"Description","Trip Date", "Location", 
			"Max Volunteers", "Crisis Type",
			"Organizer"};
	private ArrayList<Trip> crsTrips;
	
	public TripTM(CRS crs) {
		setCrs(crs);
		setCrsTrips(new ArrayList<Trip>(crs.getTrips()));
	}
	

	/**
	 * 
	 * @param crs
	 * @param crsTrips
	 */
	public TripTM(CRS crs,  ArrayList<Trip> crsTrips) {
		setCrs(crs);
		setCrsTrips(crsTrips);
	}
	/**
	 * @return the crs
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
	public ArrayList<Trip> getCrsTrips() {
		return crsTrips;
	}

	/**
	 * @param appList the appList to set
	 */
	public void setCrsTrips(ArrayList<Trip> crsTrips) {
		this.crsTrips = crsTrips;
	}
	
	@Override
	public int getRowCount() {
		return getCrsTrips().size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Trip trip = getCrsTrips().get(rowIndex);
		Staff orgnzr= crs.getOrganizer(trip);
		
		switch (columnIndex) {
		case 0:
			return trip.getTripID();
		case 1:
			return trip.getDescription();
		case 2:
			return trip.getTripDate();
		case 3:
			return trip.getLocation();
		case 4:
			return trip.getNumVolunteers();
		case 5:
			return trip.getCrisisType();
		case 6:
			return orgnzr.getUsername();
		default:
			return null;
		}
	}
	
	public String getColumnName(int columnIndex) {
		return header[columnIndex];
	}
	
	public Trip getTripAt(int rowIndex) {
		return crsTrips.get(rowIndex);
	}
	
	

}
