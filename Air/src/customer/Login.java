package customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 * @throws Exception 
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void refresh() throws Exception
	{
		BookFlights.mainn(null);
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 729, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnX.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnX.setBounds(674, 13, 36, 32);
		contentPane.add(btnX);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setForeground(Color.WHITE);
		lblLogIn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 28));
		lblLogIn.setBounds(282, 32, 134, 44);
		contentPane.add(lblLogIn);
		
		JLabel lblNewLabel = new JLabel("Customer ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblNewLabel.setBounds(114, 104, 119, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblPassword.setBounds(114, 178, 100, 32);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(277, 108, 206, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("BNS");
				if(textField.getText().equals("C") && passwordField.getText().equals("C"))
				{
					System.out.println("BUTTONS");
					try {
						BookFlights.mainn(null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(240, 269, 166, 44);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(277, 182, 206, 30);
		contentPane.add(passwordField);
		
		JButton btnLogInAs = new JButton("Log in as Guest");
		btnLogInAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						BookFlights.mainn(null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnLogInAs.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnLogInAs.setBounds(456, 269, 166, 44);
		contentPane.add(btnLogInAs);
		
		JLabel background=new JLabel(new ImageIcon("a.jpg"));
		background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		background.setBounds(0, 0, 829, 468);
		contentPane.add(background);
	}
}
