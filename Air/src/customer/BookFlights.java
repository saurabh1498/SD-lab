package customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.api.jdbc.Statement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.Color;

public class BookFlights extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static BookFlights frame;
	static JLabel Status = new JLabel("");
	static String cities[];
	static String cities_1[];
	JComboBox<String> comboBox,comboBox_1;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void mainn (String[] args) throws Exception{
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //SwingUtilities.updateComponentTreeUI(this);
		//	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","lucifer123");
	
		Statement st= (Statement) con.createStatement();
		ResultSet rs =st.executeQuery("select * from flights");
		cities=new String[50];
		cities_1=new String[50];
		int z=0;
		while(rs.next()){
			String a=rs.getString("Source");
			String b=rs.getString("Destination");
			cities[z]=a;
			cities_1[z]=b;
			
			Status.setText("result is "+a);
			z++;	
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new BookFlights();
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
	public BookFlights() {
		super("Customer");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1630,750);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		ImageIcon m = new ImageIcon("a.jpg");
		///contentPane.setBackground();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFlightBooking = new JLabel("Flight Booking");
		lblFlightBooking.setForeground(new Color(255, 255, 255));
		lblFlightBooking.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 50));
		lblFlightBooking.setBounds(388, 36, 357, 81);
		contentPane.add(lblFlightBooking);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setForeground(new Color(255, 255, 255));
		lblFrom.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		lblFrom.setBounds(266, 157, 73, 36);
		contentPane.add(lblFrom);
		
		JLabel lblNewLabel = new JLabel("To");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		lblNewLabel.setBounds(266, 244, 56, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblDepartureDate = new JLabel("Departure Date");
		lblDepartureDate.setForeground(new Color(255, 255, 255));
		lblDepartureDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		lblDepartureDate.setBounds(266, 338, 207, 37);
		contentPane.add(lblDepartureDate);
		
		JLabel lblAdult = new JLabel("Adult");
		lblAdult.setForeground(new Color(255, 255, 255));
		lblAdult.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		lblAdult.setBounds(311, 439, 94, 25);
		contentPane.add(lblAdult);
		
		JLabel lblNewLabel_1 = new JLabel("Child");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(692, 437, 82, 28);
		contentPane.add(lblNewLabel_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(839, 440, 88, 27);
		contentPane.add(spinner_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(538, 445, 73, 27);
		contentPane.add(spinner);
		JButton btnSearchFlights = new JButton("Search Flights ");
		btnSearchFlights.setForeground(new Color(0, 0, 0));
		btnSearchFlights.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		btnSearchFlights.setBounds(461, 570, 234, 37);
		contentPane.add(btnSearchFlights);
		
		 comboBox = new JComboBox();
		 comboBox.setBackground(new Color(34, 139, 34));
		comboBox.setBounds(535, 164, 239, 37);
		
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setBounds(535, 251, 239, 36);
		int i=0;
		while(i<20)
		{
			if(cities[i] != null)
			comboBox.addItem(cities[i]);
			comboBox_1.addItem(cities_1[i]);
			i++;
			Status.setText("Data Retrived");
		}
		contentPane.add(comboBox);
		contentPane.add(comboBox_1);
		
		
		Status.setBounds(6, 542, 277, 37);
		contentPane.add(Status);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(535, 338, 239, 37);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(1577, 13, 41, 25);
		contentPane.add(btnNewButton);
		
		JLabel background=new JLabel(new ImageIcon("a.jpg"));
		background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		background.setBounds(-60,-60,1997,880);
		contentPane.add(background);
		
		btnSearchFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String source=(String)comboBox.getSelectedItem();
				String Destination=(String)comboBox_1.getSelectedItem();
				int Adult=(int)spinner.getValue();
				int Child=(int)spinner_1.getValue();
			
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String startDateString = dateFormat.format(dateChooser.getDate());  
				String st='"'+startDateString+'"';
				Status.setText("result is "+startDateString+st);
				try {
					FlightResult.FR(source,Destination,st,Adult,Child);
				} catch (Exception e) {
					//e.printStackTrace();
				}
				frame.setVisible(false);
				
			}
		});
		
	}
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
