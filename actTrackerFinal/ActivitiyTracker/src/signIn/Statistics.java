package signIn;

public class Statistics {
	
	private String userName;
	private double distance;
	private double time;
	private double altitude;
	private String Date;
	
	public Statistics(String user2,double time2, double distance2, double altitude2, String date2) {
		this.userName = user2;
		this.distance = distance2;
		this.time = time2;
		this.altitude = altitude2;
		this.Date = date2;
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return this.userName;
	}
	public double getDistance() {
		return this.distance;
	}
	public double getTime() {
		return this.time;
	}
	public double getAltitude() {
		return this.altitude;
	}
	public String getDate() {
		return this.Date;
	}
	
	public void setUserName(String username) {
		this.userName = username;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public void setDate(String Date) {
		this.Date = Date;
	}
	public String toString() {
		return "UserName: " + this.userName +"Distance: "+ String.valueOf(this.distance)+ "Time: "+String.valueOf(this.time)+"Altitude: "+String.valueOf(this.altitude)+"Date: "+this.Date;
	}

}
