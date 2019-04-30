package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;

import com.mysql.cj.api.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EditFlightDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	static String iddd;
	static String name,source,destination,departure,arrival,charges,seats;
	static Statement st;
	JLabel lblStatus;
	JLabel lblNewLabel;
	static EditFlightDetails fm ;
	/**
	 * Launch the application.
	 */
	public static void main(String idd) throws Exception{
		iddd=idd;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","lucifer123");
		
		 st= (Statement) con.createStatement();
		ResultSet rs =st.executeQuery("SELECT * FROM airline.flights where ID="+iddd);
		while(rs.next()){
			name=rs.getString("Name");
		source=rs.getString("Source");
		destination=rs.getString("Destination");
		departure=rs.getString("Departure");
		arrival=rs.getString("Arrival");
		charges=rs.getString("charges");
		seats=rs.getString("Seats");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditFlightDetails frame = new EditFlightDetails();
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
	 * @throws SQLException 
	 */
	public EditFlightDetails() throws SQLException {
		super("Update Flight Details");
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
		panel.setToolTipText("hello");
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 1630, 750);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Source");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		label.setBounds(654, 232, 146, 24);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Status");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(1406, 724, 277, 37);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Name");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		label_2.setBounds(89, 232, 146, 24);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Destination");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		label_3.setBounds(89, 355, 146, 24);
		panel.add(label_3);
		
		textField = new JTextField(destination);
		textField.setColumns(10);
		textField.setBounds(269, 355, 211, 28);
		panel.add(textField);
		
		JLabel label_4 = new JLabel("Departure");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		label_4.setBounds(654, 349, 146, 24);
		panel.add(label_4);
		
		textField_1 = new JTextField(source);
		textField_1.setColumns(10);
		textField_1.setBounds(834, 232, 211, 28);
		panel.add(textField_1);
		
		textField_2 = new JTextField(name);
		textField_2.setColumns(10);
		textField_2.setBounds(269, 237, 211, 28);
		panel.add(textField_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("hello");
		dateChooser.setBounds(834, 343, 211, 28);
		panel.add(dateChooser);
		
		JLabel label_5 = new JLabel("Arrival");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		label_5.setBounds(89, 479, 146, 24);
		panel.add(label_5);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(269, 479, 211, 28);
		panel.add(dateChooser_1);
		
		JLabel label_6 = new JLabel("Charges");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		label_6.setBounds(654, 466, 146, 37);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Seats");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		label_7.setBounds(89, 579, 146, 24);
		panel.add(label_7);
		
		textField_3 = new JTextField(charges);
		textField_3.setColumns(10);
		textField_3.setBounds(834, 475, 110, 28);
		panel.add(textField_3);
		
		textField_4 = new JTextField(seats);
		textField_4.setColumns(10);
		textField_4.setBounds(269, 575, 110, 28);
		panel.add(textField_4);
		
		JButton btnUpdate = new JButton("Update ");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=lblNewLabel.getText();
				String nm="'"+textField_2.getText()+"'";
				String Source = "'"+textField_1.getText()+"'";
				String Destination= "'"+textField.getText()+"'";
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String startDateString = dateFormat.format(dateChooser.getDate());  
				String Departure="'"+startDateString+"'";
				String startDateString_1 = dateFormat.format(dateChooser_1.getDate());  
				String Arrival="'"+startDateString_1+"'";				
				String Charges =textField_3.getText();
				String Seats = textField_4.getText();
				try {
						
	st.execute("UPDATE airline.flights SET ID="+id+",Name="+nm+",Source="+Source+",Destination="+Destination+",Departure="+Departure+",Arrival="+Arrival+",Charges="+Charges+",Seats="+Seats+" WHERE ID="+id);
	//
			lblStatus.setText("data added Succesfully ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					lblStatus.setText("(id ready exist )Failed please enter new flight  ");
					e1.printStackTrace();
					
				}
				
				fm.setVisible(false);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(270, 657, 146, 37);
		panel.add(btnUpdate);
		
		JLabel label_8 = new JLabel("ID");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		label_8.setBounds(89, 159, 146, 24);
		panel.add(label_8);
		
	 lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(282, 159, 198, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setText(iddd);
		
		JLabel label_9 = new JLabel(departure);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_9.setBounds(1071, 343, 146, 30);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel(arrival);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_10.setBounds(506, 473, 118, 30);
		panel.add(label_10);
		
		lblStatus = new JLabel("New label");
		lblStatus.setBounds(1562, 708, 56, 16);
		panel.add(lblStatus);
		
		JLabel lblCustomerDetails = new JLabel("Flight Details");
		lblCustomerDetails.setForeground(Color.WHITE);
		lblCustomerDetails.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 40));
		lblCustomerDetails.setBounds(68, 52, 394, 65);
		panel.add(lblCustomerDetails);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fm.setVisible(false);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(465, 657, 146, 37);
		panel.add(btnExit);
		/*
		
		*/
		JLabel background=new JLabel(new ImageIcon("a.jpg"));
		background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		background.setBounds(-60,-60,1997,880);
		panel.add(background);
	}
}
