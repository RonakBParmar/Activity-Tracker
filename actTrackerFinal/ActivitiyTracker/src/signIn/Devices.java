package signIn;

import java.util.ArrayList;

public class Devices {
	private int id;
	private ArrayList<Statistics> data;
	
	public Devices(int id) {
		this.id = id;
	}
	public Devices(int id,ArrayList<Statistics>data) {
		this.id = id;
		this.data = data;
	}
	public int getId() {
		return this.id;
	}
	public ArrayList<Statistics> getData() {
		return this.data;
	}
	public void setData(ArrayList<Statistics> data) {
		this.data = data;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void addData(Statistics stat) {
		this.data.add(stat);
	}

}
