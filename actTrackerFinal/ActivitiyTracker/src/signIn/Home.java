package signIn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.TextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JProgressBar;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Window;

public class Home extends JFrame {

	//creating variables
	private JPanel contentPane;
	private JPasswordField passwordField;
	int xx,xy;
	private JTextField Username_f;
	private static Manager manager;
	
	/**
	 *
	 * Launch the application.
	 */
	//main class to start program
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(false);
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.print("Exception");
					e.printStackTrace();
				}
			}
		});
	}

	//Initalizing the frame
	public Home() throws IOException {
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/logo4.PNG")));
		manager = new Manager();
		setResizable(false);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 750);
		contentPane = new JPanel();
		
		//ContentPane = main panel
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//panel = sub panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 304, 715);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//Title
		JLabel title = new JLabel("ACTIVITY TRACKER");
		title.setForeground(new Color(255, 250, 250));
		title.setFont(new Font("Georgia", Font.BOLD, 22));
		title.setBounds(24, 542, 280, 53);
		panel.add(title);
		
		// Cover picture
		JLabel image = new JLabel("New label");
		image.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		image.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y= arg0.getYOnScreen();
				Home.this.setLocation(x-xx,y-xy);
			}
		});
		
		image.setIcon(new ImageIcon(Home.class.getResource("/images/222.jpg")));
		image.setBounds(0, 0, 341, 459);
		panel.add(image);
		
		//SIGN IN BUTTON
		Button login = new Button("Log In");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String user = Username_f.getText();
				String password = String.valueOf(passwordField.getPassword());
				boolean b = manager.accessUser(user, password);
				manager.current.setUserName(user);
				if(b == true) {
	
					System.out.print("signed in");
					JFrame signin = null;
					try {
						signin = new ProfilePage2();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					signin.setVisible(true);
					setVisible(false);
				}
				else {
					System.out.print("error");
					JOptionPane.showMessageDialog(null, "Invalid username or password");
					
				}

			}
		});
		login.setFont(new Font("Dialog", Font.BOLD, 15));
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(250, 128, 114));
		login.setBounds(449, 447, 196, 50);
		contentPane.add(login);
		
		//Username field
		Username_f = new JTextField();
		Username_f.setBounds(435, 267, 221, 32);
		contentPane.add(Username_f);
		Username_f.setColumns(10);
		
		//Password field
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordField.setBounds(435, 369, 221, 32);
		contentPane.add(passwordField);
		
		//Username label
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 13));
		lblUsername.setBounds(435, 230, 87, 24);
		contentPane.add(lblUsername);
		
		//Password label
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 13));
		lblPassword.setBounds(435, 332, 87, 24);
		contentPane.add(lblPassword);
		
		//Button to register an account
		Button signUp = new Button("Sign up");
		signUp.setBackground(new Color(250, 128, 114));
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame signUp = null;
				try {
					signUp = new Registration();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				signUp.setVisible(true);
				setVisible(false);
			}
		});
		signUp.setFont(new Font("Dialog", Font.BOLD, 12));
		signUp.setForeground(new Color(255, 255, 255));
		signUp.setBounds(798, 20, 79, 24);
		contentPane.add(signUp);
		
		//New User label
		JLabel lblNewUser = new JLabel("New User?");
		lblNewUser.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewUser.setBounds(722, 28, 70, 16);
		contentPane.add(lblNewUser);
		
		//Image
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/images/BetterLogo.PNG")));
		lblNewLabel.setBounds(333, 61, 403, 140);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u00A9 2018 Group 3. All Rights Researved.");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(435, 699, 271, 16);
		contentPane.add(lblNewLabel_1);
	}
	//Function to return manager - used to transfer manage to different jframe.
	public static Manager getManager() { 
		return manager;
	}
}
