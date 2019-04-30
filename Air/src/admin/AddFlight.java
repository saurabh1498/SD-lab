package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.mysql.cj.api.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddFlight extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	static Statement st;  
	static AddFlight ff;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","lucifer123");
		 st= (Statement) con.createStatement();
	//	 st.execute("insert into flights(ID,Name,Source,Destination,Departure,Arrival,Charges,Seats) values (11,'f6','Pune','malacia','2018-03-04','2018-03-06',600,100)");
		 UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlight frame = new AddFlight();
					ff=frame;
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
	public AddFlight() {
		super("Add new Flight");
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
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0,0,1630,750);
		contentPane.add(panel);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setForeground(Color.WHITE);
		lblSource.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblSource.setBounds(98, 273, 105, 24);
		panel.add(lblSource);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(1365, 713, 277, 37);
		panel.add(lblStatus);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblName.setBounds(645, 150, 73, 24);
		panel.add(lblName);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblDestination.setBounds(645, 273, 131, 24);
		panel.add(lblDestination);
		
		textField_1 = new JTextField();
		textField_1.setBounds(825, 273, 211, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setForeground(Color.WHITE);
		lblDeparture.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblDeparture.setBounds(98, 395, 131, 24);
		panel.add(lblDeparture);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(278, 273, 211, 28);
		panel.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(825, 150, 211, 28);
		panel.add(textField_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(278, 389, 211, 28);
		panel.add(dateChooser);
		
		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setForeground(Color.WHITE);
		lblArrival.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblArrival.setBounds(645, 391, 131, 24);
		panel.add(lblArrival);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(825, 391, 211, 28);
		panel.add(dateChooser_1);
		
		JLabel lblCharges = new JLabel("Charges");
		lblCharges.setForeground(Color.WHITE);
		lblCharges.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblCharges.setBounds(98, 485, 131, 37);
		panel.add(lblCharges);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setForeground(Color.WHITE);
		lblSeats.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblSeats.setBounds(98, 579, 131, 24);
		panel.add(lblSeats);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')) {
	                    e.consume();
	                }
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(278, 494, 110, 28);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')) {
	                    e.consume();
	                }
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(278, 582, 110, 28);
		panel.add(textField_4);
		
		JButton btnAddFlight = new JButton("Add Flight");
		btnAddFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String id= textField_5.getText();
				String nm="'"+textField_2.getText()+"'";
				String Source = "'"+textField.getText()+"'";
				String Destination= "'"+textField_1.getText()+"'";
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String startDateString = dateFormat.format(dateChooser.getDate());  
				String Departure="'"+startDateString+"'";
				String startDateString_1 = dateFormat.format(dateChooser_1.getDate());  
				String Arrival="'"+startDateString_1+"'";				
				String Charges =textField_3.getText();
				String Seats = textField_4.getText();
				try {
						
	st.execute("insert into flights(ID,Name,Source,Destination,Departure,Arrival,Charges,Seats) values ("+id+","+nm+","+Source+","+Destination+","+Departure+","+Arrival+","+Charges+","+Seats+")");
			lblStatus.setText("data added Succesfully ");
				} catch (SQLException e1) {
					lblStatus.setText("(id ready exist )Failed please enter new flight  ");
					e1.printStackTrace();
					
				}
			}
		});
		btnAddFlight.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		btnAddFlight.setBounds(221, 687, 146, 37);
		panel.add(btnAddFlight);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblId.setBounds(98, 150, 73, 24);
		panel.add(lblId);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				  char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')) {
	                    e.consume();
	                }
	                
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(278, 153, 211, 28);
		panel.add(textField_5);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ff.setVisible(false);
				try {
					Adminn.mainnn(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnExit.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		btnExit.setBounds(582, 687, 146, 37);
		panel.add(btnExit);
		
		JLabel lblAddNewFlight = new JLabel("Add New Flight");
		lblAddNewFlight.setForeground(Color.WHITE);
		lblAddNewFlight.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 35));
		lblAddNewFlight.setBounds(60, 39, 282, 62);
		panel.add(lblAddNewFlight);
		
		JLabel background=new JLabel(new ImageIcon("a.jpg"));
		background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		background.setBounds(-60,-60,1997,880);
		panel.add(background);
	}
}
