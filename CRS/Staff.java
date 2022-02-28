	package CRS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent staff whose can be manager, or
 * administrator. Staff working as administrator will 
 * organised trip to the disaster area to provide
 * relief services.
 * Subclass of User.
 * @author KokChyeHock
 * Date:
 */
public class Staff extends User {
	private String position;
	private LocalDate dateJoined;
	private List<Trip> trips;
	
	/**
	 * Constructor for Staff, with four attributes inherited from
	 * superclass User, and additional two attributes.
	 * @param username Unique username of a user
	 * @param password Password of a user
	 * @param name Name of a user
	 * @param phone Phone number of a user
	 * @param position Position of staff
	 * @param dateJoined Date the staff joined the CRS
	 */
	public Staff(String username, String password, String name,
		String phone, String position, LocalDate dateJoined) {
		super(username, password, name, phone);
		setPosition(position);
		setDateJoined(dateJoined);
		setTrips(new ArrayList<Trip>());
	}
	
	public void addTrip(Trip aTrip) {
		getTrips().add(aTrip);
	}
	
	public Trip findTrip(String tripID) {
		for (Trip aTrip: getTrips())
			if (aTrip.getTripID().equalsIgnoreCase(tripID))
				return aTrip;
		return null;
	}

    /**
     * return a list of trips that is organised by the staff
     * @return all trips in string
     */	
	public List<Trip> viewTrips() {
		return getTrips();
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the dateJoined
	 */
	public LocalDate getDateJoined() {
		return dateJoined;
	}

	/**
	 * @param dateJoined the dateJoined to set
	 */
	public void setDateJoined(LocalDate dateJoined) {
		this.dateJoined = dateJoined;
	}

	/**
	 * @return the trips
	 */
	public List<Trip> getTrips() {
		return trips;
	}

	/**
	 * @param trips the trips to set
	 */
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	
	public int numOfTrips() {
		return getTrips().size();
	}
}
