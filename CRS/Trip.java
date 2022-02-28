package CRS;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import CRS.Application.Status;

/**
 * Trip organised by staff to disaster area. Type of
 * trips are Flood, Earthquake, Wild Fire.
 * @author KokChyeHock
 * Date:
 */
public class Trip implements Serializable {
	public enum CrisisType {
		FLOOD,EARTHQUAKE,WILDFIRE;
	}
	
	static int tripIdGen = 1;
	
	private String tripID;
	private String description;
	private LocalDate tripDate;
	private String location;
	private int numVolunteers;
	private CrisisType crisisType;
	private List<Application> applications;
	
	/**
     * Create a Trip object.
	 * @param description String describing the trip.
	 * @param tripDate Date the trip will be initiated.
	 * @param location Location the trip will be heading to.
	 * @param numVolunteers Maximum number of volunteers required.
	 * @param crisisType Type of crisis the trip is organised for.
	 */
	public Trip(String description, String location, LocalDate tripDate, 
		int numVolunteers, CrisisType crisisType) {
	        
		setTripID(tripIdGen++);
		setDescription(description);
		setTripDate(tripDate);
		setLocation(location);
		setNumVolunteers(numVolunteers);
	    setCrisisType(crisisType);
	    setApplications(new ArrayList<>());
	}
 
	/**
	 * @return the tripIdGen
	 */
	public static int getTripIdGen() {
		return tripIdGen;
	}
	
	/**
	 * @param tripIdGen the tripIdGen to set
	 */
	public static void setTripIdGen(int tripIdGen) {
		Trip.tripIdGen = tripIdGen;
	}
	
	/**
	 * @return the tripID
	 */
	public String getTripID() {
		return tripID;
	}
	
	/**
	 * @param tripID the tripID to set
	 */
	public void setTripID(int tripID) {
		this.tripID = String.format("T%02d", tripID);
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the tripDate
	 */
	public LocalDate getTripDate() {
		return tripDate;
	}
	
	/**
	 * @param tripDate the tripDate to set
	 */
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * @return the numVolunteers
	 */
	public int getNumVolunteers() {
		return numVolunteers;
	}
	
	/**
	 * @param numVolunteers the numVolunteers to set
	 */
	public void setNumVolunteers(int numVolunteers) {
		this.numVolunteers = numVolunteers;
	}
	
	/**
	 * @return the crisisType
	 */
	public CrisisType getCrisisType() {
		return crisisType;
	}
	
	/**
	 * @param crisisType the crisisType to set
	 */
	public void setCrisisType(CrisisType crisisType) {
		this.crisisType = crisisType;
	}
	
	/**
	 * @return the applications
	 */
	public List<Application> getApplications() {
		return applications;
	}
	
	/**
	 * @param applications the applications to set
	 */
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
	public boolean addApplication(Application app) {
		getApplications().add(app);
		return true;
	}
	
	/**
	 * Search for an application based on application ID.
	 * @param appID Application ID
	 * @return Application that matches the application ID,
	 * null otherwise
	 */
	public Application findApplication(String appID) {
		for (Application app: getApplications())
			if (app.getApplicationID().equalsIgnoreCase(appID))
				return app;
		return null; 
	}
	
	/**
	 * @return True if there is slot available for this 
	 * trip, false otherwise
	 */
	public boolean isAvailable() {
		int count = 0;
		for (Application app: getApplications())
			if (app.getStatus().equals(Status.ACCEPTED))
				count ++;
		return count < getNumVolunteers();
	}
	
	/**
	 * Compare this Trip object with the specific object. The 
	 * result is true if and only if the argument is a Trip object
	 * and has the same trip ID as this Trip object.
	 * @param obj Trip object to test for equality with this 
	 * Trip object.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Trip) {
			return getTripID().equalsIgnoreCase(
				((Trip) obj).getTripID());
		}
		return false;
	}
	
	/**
	 * Returns a string representation of a trip.
	 * @return A string representing details of a trip.
	 */
	public String toString() {
		return String.format("%s (%s at %s) required %d volunteers," + 
			"\n    leaving at %s", getTripID(), getCrisisType(), 
			getLocation(), getNumVolunteers(), getTripDate());
	}

	/**
	 * @return The number of applications submitted by 
	 * volunteers.
	 */
	public int numOfApplications() {
		return getApplications().size();
	}
}
