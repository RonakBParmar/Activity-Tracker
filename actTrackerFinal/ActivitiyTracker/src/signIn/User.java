package signIn;

import java.util.ArrayList;

public class User {
	private String name;
	private String userName;
	private String password;
	private String DOB;
	private String email;
	private String ansOfSecurityQuestion;
	private ArrayList<User> friends = new ArrayList<User>();
	private ArrayList<User> friendRequests = new ArrayList<User>();
	private ArrayList<Statistics> stats = new ArrayList<Statistics>();
	//private UserInfo info;
	/**
	 * @param name
	 * @param userName
	 * @param password
	 * @param dOB
	 * @param email
	 * @param ansOfSecurityQuestion
	 */

	/**
	 * 
	 */
	public User() {
	}
	
	public User(String name, String userName, String password, String dOB, String email, String ansOfSecurityQuestion) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.DOB = dOB;
		this.email = email;
		this.ansOfSecurityQuestion = ansOfSecurityQuestion;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the dOB
	 */
	public String getDOB() {
		return DOB;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the ansOfSecurityQuestion
	 */
	public String getAnsOfSecurityQuestion() {
		return ansOfSecurityQuestion;
	}

	/**
	 * @return the friends
	 */
	public ArrayList<User> getFriends() {
		return friends;
	}

	/**
	 * @return the friendRequests
	 */
	public ArrayList<User> getFriendRequests() {
		return friendRequests;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param ansOfSecurityQuestion the ansOfSecurityQuestion to set
	 */
	public void setAnsOfSecurityQuestion(String ansOfSecurityQuestion) {
		this.ansOfSecurityQuestion = ansOfSecurityQuestion;
	}

	public void addFriend(User friend) {
		this.friends.add(friend);
		if (this.friendRequests.contains(friend))
			this.friendRequests.remove(friend);
	}

	public void addRequest(User friendRequest) {
		this.friendRequests.add(friendRequest);
	}
	public void removeFriend(User friend) {
		if (this.friends.contains(friend))
			this.friends.remove(friend); 
	}
	public void setStatistics(Statistics stat) {
		this.stats.add(stat);
	}
	public ArrayList<Statistics> getStats(){
		return this.stats;
	}
	public void acceptFriendRequest(User friend) {
		if (this.friendRequests.contains(friend)) {
			this.friendRequests.remove(friend);
			this.friends.add(friend);
		}
	}
}
