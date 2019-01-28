package signIn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.List;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Scrollbar;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class ProfilePage2 extends JFrame {
	private User current;
	private JPanel contentPane;
	private JTextField textField;
	private Manager manager;
	private JComboBox comboBox;
	private JButton btnAdd;
	private JPanel panel_1;
	private JLabel lblEmail;
	private JComboBox comboBox_1;
	private JTextArea textArea;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton DataButton;
	private JScrollPane scrollPane;
	private JButton importDatabtn;
	private JTextArea textArea_1;
	private ArrayList<Statistics> stats;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePage2 frame = new ProfilePage2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public ProfilePage2() throws IOException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProfilePage2.class.getResource("/images/logo4.PNG")));
		manager = Home.getManager();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		importDatabtn = new JButton("Import Data");
		importDatabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		importDatabtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String file = JOptionPane.showInputDialog("Enter the input file below:",null);
				try {
					manager.database.uploadData(file);
				} catch (IOException e1) {
					JOptionPane.showInputDialog(null,"oopsie woopsie! File cannot be found. Try Again.");
					e1.printStackTrace();
				}
				
			}
		
		});
		importDatabtn.setBounds(325, 444, 177, 87);
		importDatabtn.setForeground(Color.WHITE);
		importDatabtn.setFont(new Font("Arial", Font.BOLD, 15));
		importDatabtn.setBackground(new Color(250, 128, 114));
		importDatabtn.setVisible(false);
		contentPane.add(importDatabtn);
		
		

		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 224, 715);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(224, 0, 663, 156);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		try {
		
		btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = comboBox.getSelectedItem().toString();
				try {
					manager.addFriend(name);
				comboBox.removeItem(name);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(56, 408, 97, 25);
		btnAdd.setVisible(false);
		panel.add(btnAdd);
		
		comboBox = new JComboBox();
		comboBox.setBounds(12, 363, 200, 22);
		comboBox.setVisible(false);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Welcome,");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 34));
		lblNewLabel.setBounds(22, 39, 143, 31);
		panel.add(lblNewLabel);
		}
		catch(NullPointerException e) {
			System.out.println("null error");
		}

		try {
		System.out.print(manager.current.getUserName());
		JLabel lblEmail = new JLabel(manager.current.getUserName());
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Script MT Bold", Font.BOLD, 30));
		lblEmail.setBounds(22, 83, 176, 44);
		panel.add(lblEmail);
		}
		catch(NullPointerException e) {
			System.out.print("Null point error");
		}
		JLabel lblSearchFriends = new JLabel("Search Friends");
		lblSearchFriends.setForeground(new Color(0, 0, 0));
		lblSearchFriends.setFont(new Font("Arial", Font.BOLD, 13));
		lblSearchFriends.setBounds(0, 244, 131, 24);
		panel.add(lblSearchFriends);
		
		Button logout = new Button("Log out");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame home = null;
				try {
					home = new Home();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				home.setVisible(true);
				setVisible(false);
				
				
			}
		});
		logout.setActionCommand("Log out");
		logout.setFont(new Font("Dialog", Font.PLAIN, 15));
		logout.setForeground(new Color(0, 0, 0));
		logout.setBackground(new Color(250, 128, 114));
		logout.setBounds(29, 662, 166, 31);
		panel.add(logout);
		
		JCheckBox addedButton = new JCheckBox("");
		addedButton.setBounds(6, 0, 97, 23);
		addedButton.setVisible(false);
		addedButton.setSelected(false);
		panel.add(addedButton);
		
		JCheckBox addedButton1 = new JCheckBox("");
		addedButton1.setBounds(6, 0, 97, 23);
		addedButton1.setVisible(false);
		addedButton1.setSelected(false);
		panel.add(addedButton1);
		
		DataButton = new JButton("Default Data");
		DataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addedButton.setSelected(true);
				addedButton1.setSelected(true);
				DataButton.setVisible(false);
				try {
					manager.importData();
					comboBox_1.setVisible(true);
					btnNewButton.setVisible(true);
					importDatabtn.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Import Successful");
			}
		});
		DataButton.setForeground(Color.WHITE);
		DataButton.setFont(new Font("Arial", Font.BOLD, 15));
		DataButton.setBackground(new Color(250, 128, 114));
		DataButton.setBounds(575, 444, 196, 87);
		DataButton.setVisible(false);
		contentPane.add(DataButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(10, 269, 202, 31);
		panel.add(textField);
		textField.setColumns(10);
		DataButton.setBackground(new Color(250, 128, 114));
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.removeAllItems();
				String search =textField.getText();
				ArrayList<User> list = manager.search(search);
				ArrayList<String> used = new ArrayList<String>();
				for(User u: list) {
					comboBox.addItem(u.getUserName());
				}
				
				if(list.size() > 0) {
					comboBox.setVisible(true);
					btnAdd.setVisible(true);
				}
			}
		});
		btnSearch_1.setBounds(56, 313, 97, 25);
		btnSearch_1.setBackground(new Color(250, 128, 114));
		panel.add(btnSearch_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ProfilePage2.class.getResource("/images/2345.jpg")));
		lblNewLabel_1.setBounds(-301, 0, 525, 715);
		panel.add(lblNewLabel_1);
		
		
		Button Walking = new Button("Running");
		Walking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Walking.setBackground(new Color(255,88,79));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Walking.setBackground(new Color(255, 228, 181));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnNewButton_1.setVisible(false);
				comboBox_1.setVisible(false);
				btnNewButton.setVisible(false);
				DataButton.setVisible(true);
				textArea_1.setVisible(false);
				scrollPane.setVisible(false);
				importDatabtn.setVisible(true);
				
			}
		});
		Walking.setBounds(32, 21, 102, 99);
		panel_1.add(Walking);
		Walking.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		Walking.setBackground(new Color(255, 228, 181));
		
		Button Biking = new Button("Biking");
		Biking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Biking.setBackground(new Color(255,88,79));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Biking.setBackground(new Color(255, 228, 181));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBox_1.setVisible(false);
				btnNewButton.setVisible(false);
				DataButton.setVisible(false);
				scrollPane.setVisible(false);
				btnNewButton_1.setVisible(true);
				importDatabtn.setVisible(false);
				textArea_1.setVisible(false);
			
				
			}
		});
		Biking.setFont(new Font("Kristen ITC", Font.BOLD, 15));
		Biking.setBackground(new Color(255, 228, 181));
		Biking.setBounds(165, 21, 102, 99);
		panel_1.add(Biking);
		
		Button AddActivity = new Button("+");
		AddActivity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AddActivity.setBackground(new Color(255,88,79));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AddActivity.setBackground(new Color(255, 228, 181));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Oops! Feature coming soon.");
			}
		});
		AddActivity.setFont(new Font("Kristen ITC", Font.BOLD, 23));
		AddActivity.setBackground(new Color(255, 228, 181));
		AddActivity.setBounds(300, 21, 102, 99);
		panel_1.add(AddActivity);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setOrientation(Scrollbar.HORIZONTAL);
		scrollbar.setBounds(0, 135, 663, 21);
		scrollbar.setVisible(false);
		panel_1.add(scrollbar);
		
		JComboBox<Comparable> friendRequestDisplay = new JComboBox<Comparable>();
		friendRequestDisplay.setBounds(546, 11, 91, 20);
		ArrayList<User> list = manager.current.getFriendRequests();
		friendRequestDisplay.addItem(list.size());
		for (User u : list) {
			friendRequestDisplay.addItem(u.getUserName());
		}
		panel_1.add(friendRequestDisplay);
		
		JButton AcceptButton = new JButton("Accept");
		AcceptButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (friendRequestDisplay.getSelectedItem().toString().equals(list.size())) {
					JOptionPane.showMessageDialog(null, "Please select a friend request");
				}else {
					String username = friendRequestDisplay.getSelectedItem().toString();
					manager.acceptRequest(username);
					String displayString = username + "added to friends";
					JOptionPane.showMessageDialog(null, displayString);
					friendRequestDisplay.removeAllItems();
					ArrayList<User> list = manager.current.getFriendRequests();
					friendRequestDisplay.addItem(list.size());
					for (User u : list) {
						friendRequestDisplay.addItem(u.getUserName());
					}
				}
			}
		});
		AcceptButton.setBounds(546, 41, 89, 23);
		AcceptButton.setBackground(new Color(255, 228, 181));
		panel_1.add(AcceptButton);
		panel_1.add(scrollbar);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ProfilePage2.class.getResource("/images/666.jpg")));
		lblNewLabel_2.setBounds(-132, 0, 827, 155);
		panel_1.add(lblNewLabel_2);
		
		Button Search = new Button("Search");
		Search.setBounds(0, 0, 117, 31);
		contentPane.add(Search);
		Search.setForeground(Color.BLACK);
		Search.setFont(new Font("Dialog", Font.PLAIN, 15));
		Search.setBackground(new Color(250, 128, 114));
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(290, 227, 529, 204);
		textArea.setRows(15);
		textArea.setColumns(15);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 227, 529, 204);
		scrollPane.setVisible(false);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		
		ArrayList<Statistics> stats = manager.importData();

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select Run"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBounds(384, 188, 203, 25);
		
		ArrayList<String> cb = new ArrayList<String>();
		/*	
		for(Statistics s : stats) {
			int found = 0;
				for(String t : cb) {
				if((s.getDate().equals(t) == true)) {
					found = 1;
				}
			}
			if(found == 0) {
			comboBox_1.addItem(s.getDate());
			}
			
			cb.add(s.getDate());
			*/
		comboBox_1.addItem("Run 1");
		comboBox_1.addItem("Run 2");
		comboBox_1.addItem("Run 3");
		comboBox_1.addItem("All");
		comboBox_1.setVisible(false);
		contentPane.add(comboBox_1);
		
		btnNewButton = new JButton("Go");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(599, 188, 108, 26);
		btnNewButton.setVisible(false);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Import Data");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "No Data To Import.");
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(250, 128, 114));
		btnNewButton_1.setBounds(461, 455, 196, 60);
		btnNewButton_1.setVisible(false);
		contentPane.add(btnNewButton_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_1.setBounds(290, 446, 529, 124);
		textArea_1.setVisible(false);
		contentPane.add(textArea_1);
		
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int size = manager.importData().size();
					ArrayList<Statistics> stats = manager.importData();
					ArrayList<Statistics> cstats = new ArrayList<Statistics>();
				int i2 = 1;
				textArea.setText(null);
				textArea_1.setText(null);
				int count = 0;
				boolean done = false;
				for(Statistics i : stats) {
				
				if((i.getTime() == 0) && (comboBox_1.getSelectedItem().equals("All"))) {
				String s = String.format("\n%2s %10s %12s %12s %12s",("Run "+Integer.toString(i2)),"Date","Time","Distance","Altitude\n");
				textArea.append(s);
				++i2;
				}
		
					if((i.getTime() != 0) && (comboBox_1.getSelectedItem().equals("All"))) {
						String s1 =	String.format("%15s %10s %10s %10s\n",i.getDate(),Double.toString(i.getTime()),
						Double.toString(i.getDistance()),Double.toString(i.getAltitude()));
						cstats.add(i);
						textArea.append(s1);
				
					}
					if((i.getTime() == 0) && (comboBox_1.getSelectedItem().equals("Run 1"))&& done==false) {
						String s = String.format("\n%2s %10s %12s %12s %12s",("Run"+Integer.toString(1)),"Date","Time","Distance","Altitude\n");
						textArea.append(s);					
						done = true;
						}
					if((i.getTime() == 0) && (comboBox_1.getSelectedItem().equals("Run 2"))&& done==false) {
						String s = String.format("\n%2s %10s %12s %12s %12s",("Run"+Integer.toString(2)),"Date","Time","Distance","Altitude\n");
						textArea.append(s);					
						done = true;
						}
					if((i.getTime() == 0) && (comboBox_1.getSelectedItem().equals("Run 3"))&& done==false) {
						String s = String.format("\n%2s %10s %12s %12s %12s",("Run"+Integer.toString(3)),"Date","Time","Distance","Altitude\n");
						textArea.append(s);					
						done = true;
						
						}
					
					if((comboBox_1.getSelectedItem().equals("Run 1")) && count < 2){
						if (i.getTime() == 0) {
							count+=1;
						}
						else {
							String s1 =	String.format("%18s %10s %10s %10s\n",i.getDate(),Double.toString(i.getTime()),
							Double.toString(i.getDistance()),Double.toString(i.getAltitude()));
							textArea.append(s1);
							cstats.add(i);
						}
					}
					
					if((comboBox_1.getSelectedItem().equals("Run 2")) && count < 3){
						if (i.getTime() == 0) {
							count+=1;
						}
						else if (count > 1){
							String s1 =	String.format("%18s %10s %10s %10s\n",i.getDate(),Double.toString(i.getTime()),
							Double.toString(i.getDistance()),Double.toString(i.getAltitude()));
							textArea.append(s1);
							cstats.add(i);
						}
					}
					
					if((comboBox_1.getSelectedItem().equals("Run 3")) && count < 4){
						if (i.getTime() == 0) {
							count+=1;
						}
						else if (count > 2){
							String s1 =	String.format("%18s %10s %10s %10s\n",i.getDate(),Double.toString(i.getTime()),
							Double.toString(i.getDistance()),Double.toString(i.getAltitude()));
							textArea.append(s1);
							cstats.add(i);
						}
					}
					

					else if((i.getTime() != 0) && (i.getDate().equals(comboBox_1.getSelectedItem()))){
						String s1 =	String.format("%18s %10s %10s %10s\n",i.getDate(),Double.toString(i.getTime()),
						Double.toString(i.getDistance()),Double.toString(i.getAltitude()));
						cstats.add(i);
						textArea.append(s1);
		
					}
				}
				String h = String.format("%5s %12s %15s %15s\n","Avg. Speed","Avg. Time","Avg. Distance", "Avg. Altitude");
				textArea_1.append(h);
				
				double avgSpeed = 0;
				double avgTime = 0;
				double avgDist = 0;
				double avgAlt = 0;
				int size2 = cstats.size();
				for(Statistics s1 : cstats) {
					avgSpeed = avgSpeed + (s1.getDistance()/s1.getTime());
					avgTime = avgTime + s1.getTime();
					avgDist = avgDist + s1.getDistance();
					avgAlt = avgAlt + s1.getAltitude();
				}
				avgSpeed = avgSpeed / size2;
				avgTime = avgTime / size2;
				avgDist = avgDist / size2;
				avgAlt = avgAlt / size2;
				
				String a = String.format("%5.2f %15.2f %15.2f %15.2f\n",avgSpeed,avgTime,avgDist,avgAlt);
				textArea_1.append(a);
				scrollPane.setVisible(true);
				btnNewButton_1.setVisible(false);
				contentPane.add(scrollPane);
				scrollPane.setViewportView(textArea);
				textArea_1.setVisible(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			}
		});
		
	}
}
