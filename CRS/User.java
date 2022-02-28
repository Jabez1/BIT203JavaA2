package CRS;

import java.io.Serializable;
import java.util.List;

/**
 * An abstract that represents a user in the CRS System. Each
 * user will have a unique username, password, name, and phone
 * number.
 * @author KokChyeHock
 * Date:
 */
public abstract class User implements Serializable {
	private String username;
	private String password;
	private String name;
	private String phone;
	
	/**
	 * Constructor that takes four arguments that are used to 
	 * initialise the attributes, username, password, name and 
	 * phone number. 
	 * @param username Unique username of a user
	 * @param password Password of a user
	 * @param name Name of a user
	 * @param phone Phone number of a user
	 */
	public User(String username, String password, String name,
		String phone) {
		setUsername(username);
		setPassword(password);
		setName(name);
		setPhone(phone);
	}
	
	/**
	 * Default constructor of a User
	 */
	public User() {
		this("not set", "not set", "not set", "not set");
	}

	/**
	 * Getter for username
	 * @return Username of a user
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Setter for username
	 * @param username New username 
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Getter for password
	 * @return Password of a user
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Setter for password of a user
	 * @param password New password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Getter for name
	 * @return Name of a user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for name
	 * @param name New name of a user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for phone
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter for phone
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Abstract method to view trips.
	 * To be implemented by subclasses.
	 * @return Collections of trips
	 */
	public abstract List<Trip> viewTrips();
	
	/**
	 * Checking for equality of two User objects.
	 * Two users are deemed to be equal if their usernames
	 * are the same
	 * @param obj User object to check for equality
	 * @return true if both users have the same username, 
	 * false otherwise.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof User)
			return getUsername().equalsIgnoreCase(
				((User) obj).getUsername());
		return false;
	}
	
	/**
	 * Returns a string representation of a user
	 * @return A string representing details of a user
	 */
	public String toString() {
		return String.format("%s (%s) with phone %s and password: %s", 
			getName(), getUsername(), getPhone(), getPassword());
	}
	
	/**
	 * Compare two uses according to their full name, lexicographically
	 * @return the value 0 if full name of parametric user is equal to this 
	 * user's full name; a value greater than 0 if full name of parametric 
	 * user is lexicographically less than the full name of this user; and a 
	 * value less than 0 if full name of parametric user is lexicographically
	 * greater than full name of this user.
	 */
	public int compareTo(User rhs) {
		return getName().compareTo(rhs.getName());
	}
}