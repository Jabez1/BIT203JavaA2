package CRS;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CRS contains a collection of Trip objects, a collection
 * of User objects, and hold the User object of the user 
 * that has logged in
 * @author Chin Ze Han B1901647
 */
public class CRS implements Serializable{
	public enum UserType {
		MANAGER, STAFF, VOLUNTEER
	}
	
	private List<User> users;
	private List<Trip> trips;
	private User loginUser;
	
	/**
	 * Constructor for CRS
	 */
	public CRS() {
		setUsers(new ArrayList<User>());
		setTrips(new ArrayList<Trip>());
		setLoginUser(null);
	}
	
	/**
	 * Adding user to CRS, could be a Staff or a 
	 * volunteer
	 * @param aUser New user to be added.
	 */
	public void addUser(User aUser) {
		getUsers().add(aUser);
	}
	
	/**
	 * Adding new trip organised by staff.
	 * @param aTrip New trip to be added
	 */
	public void addTrip(Trip aTrip) {
		getTrips().add(aTrip);
	}
	
	/**
	 * Finding a user based on the unique username.
	 * @param username username of user
	 * @return The user whose username matches the
	 * parametric username, null otherwise
	 */
	public User findUser(String username) {
		for (User user: getUsers())
			if (user.getUsername().equalsIgnoreCase(username))
				return user;
		return null;
	}
	
	/**
	 * Find a trip based on the trip ID
	 * @param tripID ID of trip to search
	 * @return Trip which matches parametric ID,
	 * null otherwise
	 */
	public Trip findTrip(String tripID) {
		for (Trip trip: getTrips())
			if (trip.getTripID().equalsIgnoreCase(tripID))
				return trip;
		return null;
	}
	
	/**
	 * @return Number of users in CRS
	 */
	public int numOfUsers() {
		return getUsers().size();
	}
	
	/**
	 * @return Number of organised trips in CRS
	 */
	public int numOfTrips() {
		return getTrips().size();
	}
	
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
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
	
	
	/**
	 * Returns all applications submitted for trips.
	 * trip 
	 * @return String containing the details of all 
	 * applications submitted for trips.
	 */
	public String allApplications() {
		String str = "";
		for (Trip trip: getTrips()) {
			if (trip.numOfApplications() != 0) {
				for (Application app: trip.getApplications())
					str += app + "\n";
			}
		}
		return str;
	}

	/**
	 * 
	 * @return User object that logged in
 	 */
	public User getLoginUser() {
		return loginUser;
	}

	/**
	 * 
	 * @param loginUser to set
	 */
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	/**
	 * Finds the Staff that is responsible
	 * for organizing the trip specified
	 * @param trip to find organizer of
	 * @return Staff object that is responsible for
	 * 	       organizing the trip
	 */
	public Staff getOrganizer(Trip trip) {
		return getUsers()
				.stream()
				.filter(Staff.class:: isInstance)
				.map(staff -> (Staff) staff)
				.filter(staff -> 
				staff.getTrips().contains(trip))
				.findFirst()
				.orElse(null);
	}
	
	/**
	 * Adds the trip to the User's List<Trip> 
	 * @param User that is responsible for organizing the Trip
	 * @param trip target trip to be added into the 
	 * 		  specified user's trip list
	 */
	public void setOrganizer(User user, Trip trip) {
		getUsers()
		.stream()
		.filter(Staff.class:: isInstance)
		.map(staff -> (Staff) staff)
		.filter(staff ->staff.equals(user))
		.findFirst()
		.ifPresent(staff -> staff.addTrip(trip));
	}
	
	
	
}