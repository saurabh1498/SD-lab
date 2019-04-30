package customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ConfermCustomerDeatils extends JFrame {

	private JPanel contentPane;
	static String Amount,ID,name,FathersName,DateOfBirth,Gender,Phone,email,ImgPath;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel label,label_8;
	FileDialog jp;
	ImageIcon mj;
	
	/**
	 * Launch the application.
	 */
	public static void CCD(String amtt,String id,String nm,String fnm,String gen,String dobb,String phone,String imgPath,String em) {
		//
		Amount=amtt;
		ID=id;
		name=nm;
		FathersName=fnm;
		Gender=gen;
		DateOfBirth=dobb;
		Phone=phone;
		email=em;
		ImgPath=imgPath;	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfermCustomerDeatils frame = new ConfermCustomerDeatils();
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
	public ConfermCustomerDeatils() {
		jp=new FileDialog(this,"Choose a file",FileDialog.LOAD);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,1630,750);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		///contentPane.setBackground();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 1119, 750);
		panel.setOpaque(false);
		contentPane.add(panel);
		
		JLabel lblConfirmCustomerDetails = new JLabel("Confirm Customer Details");
		lblConfirmCustomerDetails.setForeground(new Color(255, 255, 255));
		lblConfirmCustomerDetails.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 40));
		lblConfirmCustomerDetails.setBounds(44, 32, 486, 45);
		panel.add(lblConfirmCustomerDetails);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		label_1.setBounds(46, 178, 95, 25);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Fathers Name");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		label_2.setBounds(46, 230, 173, 25);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Gender");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		label_3.setBounds(46, 285, 95, 25);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("DOB");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		label_4.setBounds(46, 342, 95, 25);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Phone Number");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		label_5.setBounds(46, 393, 173, 25);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Email ");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		label_6.setBounds(46, 444, 68, 25);
		panel.add(label_6);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				try {
					databs();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(567, 630, 173, 58);
		panel.add(button);
		
		textField = new JTextField(name);
		textField.setColumns(10);
		textField.setBounds(257, 178, 332, 22);
		panel.add(textField);
		
		textField_1 = new JTextField(FathersName);
		textField_1.setColumns(10);
		textField_1.setBounds(257, 230, 332, 22);
		panel.add(textField_1);
		
		textField_2 = new JTextField(Gender);
		textField_2.setColumns(10);
		textField_2.setBounds(257, 285, 332, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField(DateOfBirth);
		textField_3.setColumns(10);
		textField_3.setBounds(257, 342, 332, 22);
		panel.add(textField_3);
		
		JLabel label_9 = new JLabel(Amount);
		label_9.setForeground(new Color(255, 255, 255));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_9.setBounds(257, 506, 268, 25);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Total Amount");
		label_10.setForeground(new Color(255, 255, 255));
		label_10.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		label_10.setBounds(46, 509, 162, 25);
		panel.add(label_10);
		
		JLabel label_12 = new JLabel("");
		label_12.setForeground(Color.RED);
		label_12.setBounds(12, 547, 303, 25);
		panel.add(label_12);
		
		textField_4 = new JTextField(Phone);
		textField_4.setColumns(10);
		textField_4.setBounds(257, 393, 332, 22);
		panel.add(textField_4);
		
		 label = new JLabel("--");
		label.setText(email);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(257, 441, 335, 25);
		panel.add(label);
		
		 label_8 = new JLabel();
		 label_8.setBounds(1285, 149, 219, 215);
		 contentPane.add(label_8);
		 label_8.setIcon(new ImageIcon(ImgPath));
		 
		 JLabel label_7 = new JLabel("Photo");
		 label_7.setBounds(1380, 95, 68, 25);
		 contentPane.add(label_7);
		 label_7.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		 
		 JButton button_1 = new JButton("Upload Photo");
		 button_1.setBounds(1326, 397, 147, 25);
		 contentPane.add(button_1);
		 button_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		jp.setDirectory("C:\\");
		 		jp.setFile("*.jpg");
		 		jp.setVisible(true);
		 			  mj = new ImageIcon(jp.getDirectory()+ jp.getFile());
		 			   ImgPath = jp.getDirectory()+ jp.getFile();
		 				label_8.setIcon(mj);
		 	}
		 });
		 button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		 
		 JButton button_2 = new JButton("X");
		 button_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		System.exit(0);
		 	}
		 });
		 button_2.setBackground(Color.WHITE);
		 button_2.setBounds(1577, 13, 41, 25);
		 contentPane.add(button_2);
		 
		 JLabel background=new JLabel(new ImageIcon("a.jpg"));
		 background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		 background.setBounds(-122,-66,1997,880);
		 contentPane.add(background);
	}
	public void databs() throws Exception
	{
		/*String nmm="'"+textField.getText()+"'";
		String fnmm="'"+textField_1.getText()+"'";
		String Gender="'"+textField_2.getText()+"'";
		String DOB="'"+textField_3.getText()+"'";
		String pn=textField_4.getText();
		String em="'"+label.getText()+"'";*/
		String nmm=textField.getText();
		String fnmm=textField_1.getText();
		String Gender=textField_2.getText();
		String DOB=textField_3.getText();
		String pn=textField_4.getText();
		String em=label.getText();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","lucifer123");
		 InputStream is= new FileInputStream(new File(ImgPath)); 
		PreparedStatement  st= (PreparedStatement  ) con.prepareStatement("Insert into airline.customers (Name,FathersName,Gender,DateOfBirth,PhoneNumber,Email,Image,FlightID) values (?,?,?,?,?,?,?,?)");
		st.setString(1, nmm);
		st.setString(2, fnmm);
		st.setString(3, Gender);
		st.setString(4, DOB);
		st.setString(5, pn);
		st.setString(6, em);
		st.setBlob(7,is);
		st.setString(8,ID);
		st.executeUpdate(); 
		//InputStream is= new FileInputStream(new File(ImgPath)); 
		//st.execute("Insert into airline.customers (Name,FathersName,Gender,DateOfBirth,PhoneNumber,Email,Image) values ("+nmm+","+fnmm+","+Gender+","+DOB+","+pn+","+em+","+is+")");
		JOptionPane.showMessageDialog(null, "Booking Succesful Please print your ticket");
	     System.exit(0);
		// Insert into airline.customers (Name,FathersName,Gender,DateOfBirth,---PhoneNumber---,Email) values ('pp','aa','xx','ww',787,'tt')
	}
}
