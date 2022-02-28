package CRS;

import java.util.ArrayList;
import java.util.List;

/**
 * User who wish to join trip to disaster area.
 * Subclass of User, inherits four attributes from 
 * superclass User.
 * @author KokChyeHock
 *
 */
public class Volunteer extends User {
	private List<Application> applications;
	private List<Document> documents;
	
	/**
	 * Constructor that takes four arguments that are used to 
	 * initialse the attributes, username, password, name and 
	 * phone number. 
	 * @param username Unique username of a user
	 * @param password Password of a user
	 * @param name Name of a user
	 * @param phone Phone number of a user
	 */
	public Volunteer(String username, String password, String name,
		String phone) {
		super(username, password, name, phone);
		setDocuments(new ArrayList<Document>());
		setApplications(new ArrayList<Application>());
	}
	
	/**
	 * Adding a new application to volunteer
	 * @param app Application to a trip
	 */
	public void add(Application app) {
		getApplications().add(app);
	}
	
	/**
	 * Adding document to volunteer
	 * @param doc Document to be added
	 */
	public void add(Document doc) {
		getDocuments().add(doc);
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

	/**
	 * @return the documents
	 */
	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

    /**
     * return a list of trips that is applied by the volunteer
     * @return all trips in string
     */
    public List<Trip> viewTrips(){
    	List<Trip> trips = new ArrayList<Trip>();
    	for (Application app: getApplications())
    		trips.add(app.getTrip());
    	return trips;
    }

	/**
	 * Search for an application based on application ID.
	 * @param appID Application ID
	 * @return Application that matches the application ID,
	 * null otherwise
	 */
    public Application find(String appID) {
    	for (Application app: getApplications())
    		if (app.getApplicationID().equalsIgnoreCase(appID))
    			return app;
    	return null;
    }
    
    /**
     * A method to check whether the volunteer has
     * applied for the Trip with the parametric ID
     * @param tripID ID of the trip to check
     * @return True if the volunteer has applied for
     * the trip with the parametric ID, false otherwise.
     */
    public boolean hasApplied(String tripID) {
    	for (Application app: getApplications())
    		if (app.getTrip().getTripID().equalsIgnoreCase(tripID))
    			return true;
    	return false;
    }
    
    /**
     * Returns the number of applications by the volunteer
     * @return Number of applications submitted by
     * the volunteer
     */
    public int numOfApplications() {
    	return getApplications().size();
    }

    /**
     * Returns the number of documents by the volunteer
     * @return Number of documents uploaded by
     * the volunteer
     */
    public int numOfDocuments() {
    	return getDocuments().size();
    }
      
    /**
     * Return detail of a volunteer as string
     * @return String containing details of a volunteer
     */
    public String toString() {
    	if (numOfApplications() == 0)
    		return super.toString() + " has no applications so far.";
    	else
    		return super.toString() + " has " + numOfApplications() +
    			" applications";
    }
    
    /**
     * @return String containing the details of all 
     * documents uploaded by a volunteer
     */
    public String documentDetails() {
    	if (getDocuments().size() != 0) {
    		String str = "";
    		for (Document doc: getDocuments()) {
    			str += doc + "\n";
    		}
    		return str;
    	}
    	return null;
    }
}