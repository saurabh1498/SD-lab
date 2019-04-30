package admin;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.jdbc.PreparedStatement;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EditCustomerDetails extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	static EditCustomerDetails fm;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static Statement st;
	static String idd,name,fatnm,gen,dob,pnnum,email;
	private JTextField textField_4;
	JLabel lblStatus;
	ButtonGroup bg = new ButtonGroup();
	static Blob b;
	static Image image;
	private JTextField textField_5;
	FileDialog jp;
	static Connection coon;
	/**
	 * Launch the application.
	 */
	public static void main(String s) throws Exception{
		idd=s;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","lucifer123");
		coon=con;
		 st= (Statement) con.createStatement();
		 
		ResultSet rs =st.executeQuery("SELECT * FROM airline.customers where ID="+s);
		
		while(rs.next()){
			name=rs.getString("Name");
		fatnm=rs.getString("FathersName");
		gen=rs.getString("Gender");
		dob=rs.getString("DateOfBirth");
		pnnum=rs.getString("PhoneNumber");
		email=rs.getString("Email");
		b=(Blob) rs.getBlob("Image");
		}
		//InputStream binaryStream = b.getBinaryStream(0, b.length());
		byte[] imageBytes = b.getBytes(1, (int) b.length());
		// image = ImageIO.read(binaryStream);
		 image = ImageIO.read(new ByteArrayInputStream(imageBytes));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCustomerDetails frame = new EditCustomerDetails();
					 fm = frame;
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
	public EditCustomerDetails() {
		super("Edit Customer Details");
		 jp = new FileDialog(this,"Choose a file",FileDialog.LOAD);
		
		 
		 setUndecorated(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0, 0,1630,750);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 1618, 750);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("Customer Details");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 35));
		label.setBounds(55, 35, 262, 72);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		label_1.setBounds(55, 179, 170, 25);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Fathers Name");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		label_2.setBounds(637, 179, 151, 25);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Gender");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		label_3.setBounds(55, 286, 170, 25);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("DOB");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		label_4.setBounds(637, 286, 151, 25);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Phone Number");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		label_5.setBounds(55, 394, 170, 25);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Email ");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		label_6.setBounds(637, 394, 151, 25);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Photo");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_7.setBounds(1386, 112, 68, 25);
		panel.add(label_7);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String id=textField_4.getText();
				String nm="'"+textField.getText()+"'";
				String fatnmm = "'"+textField_1.getText()+"'";
				String gend= "'"+bg.getSelection().getActionCommand()+"'";
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String startDateString = textField_5.getText();  
				String dobb="'"+startDateString+"'";
				String phn= textField_2.getText();				
				String emaill ="'"+textField_3.getText()+"'";*/
				String id=textField_4.getText();
				String nm=textField.getText();
				String fatnmm = textField_1.getText();
				String gend=bg.getSelection().getActionCommand();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String startDateString = textField_5.getText();  
				String dobb=startDateString;
				String phn= textField_2.getText();				
				String emaill =textField_3.getText();
				lblStatus.setText(emaill);
				try {
						
	//st.execute("UPDATE airline.customers SET ID="+id+",Name="+nm+",FathersName="+fatnmm+",Gender="+gend+",DateOfBirth="+dobb+",PhoneNumber="+phn+",Email="+emaill+",Image=null WHERE ID="+id);
	// InputStream is= new FileInputStream(new File(ImgPath)); 
		PreparedStatement  st= (PreparedStatement  ) coon.prepareStatement("UPDATE airline.customers SET Name= ?,FathersName=?,Gender=?,DateOfBirth=?,PhoneNumber=?,Email=?,Image=? WHERE ID=?");
		st.setString(1, nm);
		st.setString(2, fatnmm);
		st.setString(3, gend);
		st.setString(4, dobb);
		st.setString(5, phn);
		st.setString(6, emaill);
		st.setBlob(7,b);
		st.setString(8, id);
		st.execute();
			lblStatus.setText("data added Succesfully ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					lblStatus.setText("(id ready exist )Failed please enter new flight  ");
					e1.printStackTrace();
					
				}
			fm.setVisible(false);	
			}
		});
		button.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		button.setBounds(637, 663, 166, 34);
		panel.add(button);
		
		textField = new JTextField(name);
		textField.setColumns(10);
		textField.setBounds(248, 173, 280, 31);
		panel.add(textField);
		
		textField_1 = new JTextField(fatnm);
		textField_1.setColumns(10);
		textField_1.setBounds(823, 173, 276, 31);
		panel.add(textField_1);
		
		textField_2 = new JTextField(pnnum);
		textField_2.setColumns(10);
		textField_2.setBounds(248, 385, 280, 37);
		panel.add(textField_2);
		
		textField_3 = new JTextField(email);
		textField_3.setColumns(10);
		textField_3.setBounds(823, 385, 276, 34);
		panel.add(textField_3);
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setBounds(248, 288, 92, 25);
		bg.add(radioButton);
		if(gen=="Male")
			radioButton.setSelected(true);
		radioButton.setActionCommand("Male");
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Female");
		radioButton_1.setBounds(344, 288, 92, 25);
		bg.add(radioButton_1);
		if(gen=="Female")
			radioButton.setSelected(true);
		radioButton_1.setActionCommand("Female");
		panel.add(radioButton_1);
		
		JButton btnUpdatePhoto = new JButton("Update Photo");
		btnUpdatePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdatePhoto.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnUpdatePhoto.setBounds(1346, 399, 161, 34);
		panel.add(btnUpdatePhoto);
		
		JLabel label_8 = new JLabel(new ImageIcon(image));
		label_8.setBounds(1288, 150, 219, 215);
		panel.add(label_8);
		
		 lblStatus = new JLabel("New label");
		lblStatus.setBounds(1386, 716, 254, 34);
		panel.add(lblStatus);
		
		JLabel lblCustomerId = new JLabel("Customer Id");
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		lblCustomerId.setBounds(55, 504, 170, 25);
		panel.add(lblCustomerId);
		
		textField_4 = new JTextField(idd);
		textField_4.setBounds(248, 495, 280, 34);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(gen);
		lblNewLabel_1.setBounds(492, 286, 114, 25);
		panel.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(823, 277, 276, 34);
		textField_5.setText(dob);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fm.setVisible(false);
			}
		});
		btnExit.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		btnExit.setBounds(957, 663, 166, 34);
		panel.add(btnExit);
		
		JLabel background=new JLabel(new ImageIcon("a.jpg"));
		background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		background.setBounds(-60,-60,1997,880);
		panel.add(background);
	}
}
