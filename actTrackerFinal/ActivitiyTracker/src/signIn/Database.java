package signIn;
import java.io.*;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Database{
	
	XSSFWorkbook workbook;
	Sheet sheet;
	public User sample;
	public ArrayList<User> users = new ArrayList<User>();
	
	public Database() throws IOException {
		try {
			FileInputStream file= new FileInputStream("testworkbook.xlsx"); //database local to the package
			workbook = new XSSFWorkbook(file); 
			sheet = workbook.getSheetAt(0); //sheet containing user info
			
			for(Row row : sheet) {
				if(row == null)
					sheet.removeRow(row);
			}
			
			int y = sheet.getPhysicalNumberOfRows(); //Number of rows filled with something
			
			// Getting users from excel file into the users arraylist
			for(int i = 0; i < y; i++) {
				if(sheet.getRow(i) != null) {
				Row row = sheet.getRow(i);
					String name = row.getCell(0).toString();
					String username = row.getCell(1).toString();
					String password = row.getCell(2).toString();
					String dob = row.getCell(3).toString();
					String email = row.getCell(4).toString();
					String securityQn = row.getCell(5).toString();
					
					sample = new User(name,username,password,dob,email,securityQn);
					users.add(sample);
				}
			}

			
		}
		finally {
		}
	}
	

	//was a function in old database, but not sure if needed for anything
	void getusers() {
		for(User u : users) {
			System.out.print(u.getName());
		}
	}
	
	//Function that returns user information.
	
	User getUser(String username){
		int rowNumb = sheet.getPhysicalNumberOfRows();
		Row userRow = null;
		User toReturn = null;
		boolean found = false;
		while(found != true) {
			for(int i = 0;i < rowNumb; i++) {
				userRow = sheet.getRow(i);
				Cell userN = userRow.getCell(1);
				String userZ = userN.toString();
				//System.out.println(userZ);
				if( userZ.equals(username)) {
					found = true;
				}
			}
		}
		String name_ = userRow.getCell(0).toString();
		String user_ = userRow.getCell(1).toString();
		String pass_ = userRow.getCell(2).toString();
		String email_ = userRow.getCell(3).toString();
		String dob_ = userRow.getCell(4).toString();
		String secQn_ = userRow.getCell(5).toString();
		toReturn = new User(name_,user_,pass_,email_,dob_,secQn_);
		return toReturn;	
	}
	//Search for a friend by their name
	public ArrayList<User> searchFriend(String name){
		ArrayList<User> result = new ArrayList<User>();
		for (int i = 0; i<users.size();i++) {
			if (users.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
				result.add(users.get(i));
			}
		}
		return result;		
	}
	
		
	void printUser() {
		for(User u : users) {
			System.out.print(u.getName()+ " "+ u.getPassword()+" "+ u.getEmail()+" "+ u.getDOB()+ "\n");
			
		}
	}
	
	
	//Validates if the given username/password is in the database, within the same user info row.
	
	boolean validate(String username, String password) {
		
		
		for( User u : users) {
			if((u.getUserName().equals(username)) && (u.getPassword().equals(password))) {
				return true;
			}
		}
		return false;
	}
	
	//Checks if a given username is in the database (usernames are unique).
	boolean checkUser(String username){
		Row userRow = sheet.getRow(0);
		
		 for(Cell c: userRow) {
			String temp = c.toString();

			if (temp.equals(username)) {
				System.out.print("Database: True");
				return true;
			}	
		 }
		 return false;
	}
	
	//Not yet used anywhere, but may be useful if we let users delete their account.
	void removeUser(User user) {
		for(Row row: sheet) {
			if(row.getCell(1).toString().equals(user.getUserName())){
				sheet.removeRow(row);
			}
		
		}
	}
	
	
	//Adds users to the excel file and the users arraylist.
	public void addUser(String name,String username, String password, String email, String dob, String secQn) throws FileNotFoundException, IOException {
        User temp = new User(name,username,password,email,dob,secQn);
		users.add(temp);
		Row row;
        Object[][] userToAdd = {
                {name,username,password,email,dob,secQn},
        };
        
        
        int rowCount = sheet.getPhysicalNumberOfRows() ;
        row = sheet.getRow(rowCount);
        
        while(row != null) {
        	rowCount++;
        	row = sheet.getRow(rowCount);
        }
        
        row = sheet.createRow(rowCount);
        for (Object[] aBook : userToAdd) {
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer){
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
         
         
        try (FileOutputStream outputStream = new FileOutputStream("testworkbook.xlsx")) {
            workbook.write(outputStream);
        }
      
    }
	
	public ArrayList<Statistics> addData(User current) throws IOException {
		ArrayList<Statistics> data = new ArrayList<Statistics>();
		try {
			FileInputStream file= new FileInputStream("testworkbook.xlsx"); //database local to the package
			workbook = new XSSFWorkbook(file); 
			sheet = workbook.getSheetAt(1); //sheet containing user info
			
			for(Row row : sheet) {
				if(row == null)
					sheet.removeRow(row);
			}
			int y = sheet.getPhysicalNumberOfRows() - 1; //Number of rows filled with something
			String username = current.getUserName();
			// Getting users from excel file into the users arraylist
			for(int i = 0; i < y; i++) {
				if(sheet.getRow(i) != null) {
					Row row = sheet.getRow(i);
					String date = row.getCell(3).toString();
					double altitude = Double.parseDouble(row.getCell(2).toString());
					double time = Double.parseDouble(row.getCell(0).toString());
					double distance = Double.parseDouble(row.getCell(1).toString());
					
					data.add(new Statistics(username,distance,time,altitude,date));
				}
			}
		}
		catch (IOException e){
			System.out.println("Invalid file or bad data");
		}
		return data;
		
	}
	public void updateDatabaseUsers() throws FileNotFoundException, IOException {
		Row row;
		sheet = workbook.getSheetAt(0); 
		for (Row r : sheet) {
			sheet.removeRow(r);
		}
		for (int i = 0;i<users.size();i++) {
			User cur = users.get(i);
			String name = cur.getName();
			String username = cur.getUserName();
			String password = cur.getPassword();
			String email = cur.getEmail();
			String dob = cur.getDOB();
			String ans = cur.getAnsOfSecurityQuestion();
			String friendRequests = "";
			String friends = "";
			String stats = "";
			for (int j = 0;i<cur.getFriendRequests().size();j++) {
				friendRequests += cur.getFriendRequests().get(j).getUserName();
				if (j < cur.getFriendRequests().size()) {
					friendRequests += ";";
				}
			}
			for (int j = 0;i<cur.getFriends().size();j++) {
				friends += cur.getFriends().get(j).getUserName();
				if (j < cur.getFriends().size()-1) {
					friends += ";";
				}
			}
			updateStats(cur);
			String [] userData= {name, username, password, email, dob, ans, friendRequests, friends};
			
			row = sheet.createRow(i);
			for (int j = 0;j<userData.length;j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(userData[j]);
			}
		}
        
         
        try (FileOutputStream outputStream = new FileOutputStream("testworkbook.xlsx")) {
            workbook.write(outputStream);
        }

		
	}
	
	public void updateStats(User u) throws FileNotFoundException, IOException {
		Row row;
		sheet = workbook.getSheetAt(1); 
		for (Row r : sheet) {
			sheet.removeRow(r);
		}
		for (int i = 0;i<u.getStats().size();i++) {
			String date = u.getStats().get(i).getDate();
			double altitude = u.getStats().get(i).getAltitude();
			double time = u.getStats().get(i).getTime();
			double distance = u.getStats().get(i).getDistance();
			String username = u.getStats().get(i).getUserName();
			
			String [] userData= {date, username, String.valueOf(altitude), String.valueOf(time), String.valueOf(distance)};
			
			row = sheet.createRow(i);
			for (int j = 0;j<userData.length;j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(userData[j]);
			}
			
		}
		try (FileOutputStream outputStream = new FileOutputStream("testworkbook.xlsx")) {
            workbook.write(outputStream);
        }

	}
	
	public void uploadData(String file) throws IOException {
		
		sheet = workbook.getSheetAt(1);
		
		ArrayList<Statistics> stats = new ArrayList<Statistics>();
		Reader in = new FileReader(file);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		int skip = 0;
		for (CSVRecord record : records) {
			double time;
			if(skip == 0) {
				 time = 0;
				 skip++;
			}
			else {
				 time = Double.parseDouble(record.get(0));
			}
		    double distance = Double.parseDouble(record.get(1));
		    double altitude = Double.parseDouble(record.get(2));
		    String date = record.get(3);
			System.out.println(time);
			System.out.println(distance);
			System.out.println(altitude);
			System.out.println(date);
		    Statistics stat = new Statistics(sample.getUserName(),time,distance,altitude,date);
		    stats.add(stat);
			}
		Row row;
		for(int i = 0; i < stats.size();i++) {
			row = sheet.createRow(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(stats.get(i).getTime());
				Cell cell2 = row.createCell(1);
				cell2.setCellValue(stats.get(i).getDistance());
				Cell cell3 = row.createCell(2);
				cell3.setCellValue(stats.get(i).getAltitude());
				Cell cell4 = row.createCell(3);
				cell4.setCellValue(stats.get(i).getDate());
				
	
	try (FileOutputStream outputStream = new FileOutputStream("testworkbook.xlsx")) {
        workbook.write(outputStream);
	}
		}
	}
}
