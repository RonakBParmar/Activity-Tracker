package signIn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.ImageIcon;

public class ForgotPass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPass frame = new ForgotPass();
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
	public ForgotPass() {
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
		panel.setBounds(0, 0, 331, 715);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ForgotPass.class.getResource("/images/pro_tips_on_how_to_get.jpg")));
		lblNewLabel_1.setBounds(-161, 279, 534, 452);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Forgot Password ?");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Jokerman", Font.BOLD, 28));
		lblNewLabel_2.setBounds(24, 120, 295, 49);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(396, 230, 345, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(396, 346, 345, 41);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Security Question");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(396, 201, 137, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblSecurityAnswer = new JLabel("Security Answer");
		lblSecurityAnswer.setFont(new Font("Arial", Font.BOLD, 13));
		lblSecurityAnswer.setBounds(396, 317, 137, 16);
		contentPane.add(lblSecurityAnswer);
		
		Button button = new Button("Next");
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.setBackground(new Color(250, 128, 114));
		button.setForeground(new Color(255, 255, 255));
		button.setBounds(463, 433, 206, 50);
		contentPane.add(button);
	}

}
