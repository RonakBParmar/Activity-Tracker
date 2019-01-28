package signIn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Button;

public class ChangePass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePass frame = new ChangePass();
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
	public ChangePass() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 328, 715);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ChangePass.class.getResource("/images/Set-of-technology-security-with-data-background-vector-03.jpg")));
		lblNewLabel.setBounds(-141, 330, 487, 413);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Change");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Jokerman", Font.BOLD, 33));
		lblNewLabel_1.setBounds(42, 86, 210, 79);
		panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password...");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Jokerman", Font.BOLD, 33));
		lblPassword.setBounds(42, 167, 210, 79);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(433, 236, 311, 36);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(433, 343, 311, 36);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_2 = new JLabel("New Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(433, 208, 113, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 13));
		lblConfirmPassword.setBounds(433, 313, 128, 25);
		contentPane.add(lblConfirmPassword);
		
		Button button = new Button("Confirm");
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(250, 128, 114));
		button.setBounds(489, 433, 207, 52);
		contentPane.add(button);
	}
}
