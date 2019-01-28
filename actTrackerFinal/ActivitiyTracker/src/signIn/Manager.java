package signIn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Manager {
	User current = new User("name", "Username", "Password","Email", "Dob","ansOfSecurityQuestion");
	Database database;
	
	public Manager() throws IOException{
		database = new Database(); //First iteration of the database
	}
	
	//Function that Creates the user
	void createUser(String name, String userName, String password, String dOB, String email, String ansOfSecurityQuestion) throws FileNotFoundException, IOException
	{
		boolean check = database.checkUser(userName);
		if(check != true){
			database.addUser(name,  userName,  password,  dOB,  email,  ansOfSecurityQuestion);
			System.out.println("created");
		}
	}
	
	//Removing the user
	void removeUser()
	{
		database.removeUser(current);
		current = null;
	}
	
	//Accessing the user
	boolean accessUser(String username, String password)
	{
		User temp = null;
		boolean access = database.validate(username, password);
		
		if(access == true)
			temp = database.getUser(username);
		if (temp != null) {
			System.out.print("not null");
			current = temp;
			return true;
		}
		else {
			return false;
		}
	}
	
	//Adding Friend
	void addFriend(String friend) throws FileNotFoundException, IOException
	{
		for(User u: database.users) {
			if(u.getUserName().equals(friend)){
				u.addRequest(current);
			}
		}
		database.updateDatabaseUsers();
	}
	
	//Searching a user
	public ArrayList<User> search(String user)
	{
		return database.searchFriend(user);
	}
	
	//Removing the friend
	void removeFriend(User friend)
	{
		current.removeFriend(friend);
		friend.removeFriend(current);
	}
	
	//Validating if the user is in the database
	boolean validate(String username, String password){
		
		if(database.validate(username, password) == true) {
			current = database.getUser(username);
			return true;
		}
		return false;
	}
	//Import data from a csv file
	public ArrayList<Statistics> importData() throws IOException{
		ArrayList<Statistics> data = null;
		try {
			data = database.addData(current);
			for (int i = 0;i<data.size();i++) {
				if (data.get(i).getUserName().equals(current.getUserName())) {
					current.setStatistics(data.get(i));
				}
			}
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	//Function to print stats in cmd line
	public void printStats() {
		ArrayList<Statistics> data = current.getStats();
		for (int i = 0; i<data.size();i++) {
			System.out.println(data.get(i).toString());
		}
	}
	//Function to accept a friends request.
	public void acceptRequest(String username) {
		for (User u : current.getFriendRequests()) {
			if (u.getUserName().equals(username)) {
				current.acceptFriendRequest(u);
			}
		}
	}

}
