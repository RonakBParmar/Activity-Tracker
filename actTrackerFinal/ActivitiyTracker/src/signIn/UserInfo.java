package signIn;

import java.util.ArrayList;

public class UserInfo extends User {
	public ArrayList<Statistics> stat =new ArrayList<Statistics>();
	public ArrayList<Devices> device = new ArrayList<Devices>();
	
	public UserInfo() {
		super();
		
	}
	/**
	 * @param name
	 * @param userName
	 * @param password
	 * @param dOB
	 * @param email
	 * @param ansOfSecurityQuestion
	 */
	public UserInfo(String name, String userName, String password, String dOB, String email,
			String ansOfSecurityQuestion) {
		super(name, userName, password, dOB, email, ansOfSecurityQuestion);
	}
	/**
	 * @param stats
	 * @param device
	 */
	public UserInfo(ArrayList<Statistics> stat, ArrayList<Devices> device) {
		super();
		this.stat = stat;
		this.device = device;
	}
	
	
	/**
	 * @return the stat
	 */
	public ArrayList<Statistics> getStat() {
		return stat;
	}
	/**
	 * @return the device
	 */
	public ArrayList<Devices> getDevice() {
		return device;
	}
	
	public void addStats(Statistics Data) {
		stat.add(Data);
	}
	
	public void addDevice(Devices newDevice) {
		device.add(newDevice);
	}
	
	public void removeDevice(Devices device) {
		for (int i = 0;i<this.device.size(); i++) {
			if (this.device.get(i).equals(device)) {
				this.device.remove(i);
			}
		}
	}
	
	public void removeStats(Statistics Data) {
		for (int i = 0; i<this.stat.size(); i++) {
			if(this.stat.get(i).equals(Data)) {
				stat.remove(i); 
			}
		}
	}
	
}
