package customer;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CustomerDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JLabel lblNewLabel,lblNewLabel_1;
	JLabel picz;
	FileDialog jp;
	JOptionPane oo;
	ImageIcon mj;
	JDateChooser dateChooser;
	ButtonGroup bg=new ButtonGroup();  
	static int amt;
	static String flight_id;
	String Path;
	
	/**
	 * Launch the application.
	 */
	public static void CD(String flightid,int rs) {
		amt=rs;
		flight_id=flightid;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDetails frame = new CustomerDetails();
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
	public CustomerDetails() {
		super("Customer Details");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,1630,750);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		//ImageIcon m = new ImageIcon("a.jpg");
		///contentPane.setBackground();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jp=new FileDialog(this,"Choose a file",FileDialog.LOAD);
		oo=new JOptionPane();
		
		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(1577, 13, 41, 25);
		contentPane.add(button);
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setForeground(new Color(255, 255, 255));
		lblCustomerDetails.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 40));
		lblCustomerDetails.setBounds(44, 32, 353, 42);
		contentPane.add(lblCustomerDetails);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lblName.setBounds(46, 223, 208, 25);
		contentPane.add(lblName);
		
		JLabel lblFathersName = new JLabel("Fathers Name");
		lblFathersName.setForeground(new Color(255, 255, 255));
		lblFathersName.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lblFathersName.setBounds(46, 290, 193, 25);
		contentPane.add(lblFathersName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lblGender.setBounds(46, 361, 193, 25);
		contentPane.add(lblGender);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setForeground(new Color(255, 255, 255));
		lblDob.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lblDob.setBounds(46, 425, 162, 25);
		contentPane.add(lblDob);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(255, 255, 255));
		lblPhoneNumber.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lblPhoneNumber.setBounds(44, 506, 210, 32);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lblEmail.setBounds(44, 593, 127, 25);
		contentPane.add(lblEmail);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setForeground(new Color(255, 255, 255));
		lblPhoto.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		lblPhoto.setBounds(1320, 49, 68, 25);
		contentPane.add(lblPhoto);
///////////////////////////////////////////////////////////////////////////////////////////////////////////		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_1.setText("**All Fields are Mandatory**");
				String name=textField.getText();
				String FathersName= textField_1.getText();
				String gendar= bg.getSelection().getActionCommand();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String startDateString = dateFormat.format(dateChooser.getDate());  
				String dobb='"'+startDateString+'"';
				String phone=textField_2.getText();
				String emaill = textField_3.getText();
				String imgPath=Path;
				int randomPIN = (int)(Math.random()*9000)+1000;
				String otp = String.valueOf(randomPIN);
				String amm=String.valueOf(amt);
				//stat.setText(otp);
				SMail sm = new SMail();
				sm.sendMail(emaill, otp);
				Verificationn.main(amm,flight_id,name,FathersName,gendar,dobb,phone,imgPath,emaill,randomPIN);
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(796, 643, 173, 58);
		contentPane.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(266, 214, 335, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(266, 290, 335, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(266, 506, 335, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(266, 586, 335, 32);
		contentPane.add(textField_3);
		
	    dateChooser = new JDateChooser();
		dateChooser.setBounds(266, 423, 100, 25);
		contentPane.add(dateChooser);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(266, 359, 92, 25);
		rdbtnMale.setActionCommand("Male");
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(390, 363, 127, 25);
		rdbtnFemale.setActionCommand("Female");
		contentPane.add(rdbtnFemale);
		
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);    
		JButton btnUploadPhoto = new JButton("Upload Photo");
		btnUploadPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			jp.setDirectory("C:\\");
			jp.setFile("*.jpg");
			jp.setVisible(true);
				 mj = new ImageIcon(jp.getDirectory()+ jp.getFile());
				  Path =jp.getDirectory()+ jp.getFile();
					picz.setIcon(mj);
					//stat.setText(jp.getDirectory()+jp.getFile());
			}
		});
		btnUploadPhoto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUploadPhoto.setBounds(1271, 365, 147, 25);
		contentPane.add(btnUploadPhoto);
		
		ImageIcon v = new ImageIcon("c.png");
		picz = new JLabel(v);
		picz.setForeground(new Color(255, 255, 255));
		picz.setBackground(new Color(255, 255, 255));
		picz.setBounds(1235, 99, 241, 243);
		
		contentPane.add(picz);
		
		lblNewLabel = new JLabel(String.valueOf(amt));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 36));
		lblNewLabel.setBounds(266, 643, 268, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setForeground(new Color(255, 255, 255));
		lblTotalAmount.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lblTotalAmount.setBounds(44, 661, 195, 25);
		contentPane.add(lblTotalAmount);
		
		JLabel lblforVerificationThrough = new JLabel("(For OTP Verification)");
		lblforVerificationThrough.setForeground(new Color(255, 255, 255));
		lblforVerificationThrough.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblforVerificationThrough.setBounds(613, 593, 173, 25);
		contentPane.add(lblforVerificationThrough);
		
		 lblNewLabel_1 = new JLabel("");
		 lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(12, 547, 303, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(172, 448, 106, 34);

		JLabel background=new JLabel(new ImageIcon("a.jpg"));
		background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		background.setBounds(-38,-63,1997,846);
		contentPane.add(background);
	}
}
