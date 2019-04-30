package customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.api.jdbc.Statement;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class FlightResult extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static DefaultTableModel model = new DefaultTableModel(new String[]{"ID","NAME","Source","Destination","Departure","Arrival","charges","seats"}, 0);
	private JTable table;
	JLabel stat;
	static FlightResult frame;
	static int chargess,nuAdult,nuChild;
	
	/**
	 * Launch the application.
	 */
	 public static void FR(String source,String Destination,String date,int adult,int child) throws Exception {
		 model.addRow(new Object[]{"ID","Name","Source","Destination","Departure","Arrival","Charges","Seats"});
			
		nuAdult=adult;
		nuChild=child;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","lucifer123");
		
		Statement st= (Statement) con.createStatement();
		ResultSet rs =st.executeQuery("SELECT * FROM airline.flights where Departure="+date+"and Source="+'"'+source+'"'+"and Destination="+'"'+Destination+'"');
		while(rs.next())
		{     
			String a0 = rs.getString("ID");
		    String a1= rs.getString("Name");
		    String a2 = rs.getString("Source");
		    String a3 = rs.getString("Destination");
		    String a4 = rs.getString("Departure");
		    String a5 = rs.getString("Arrival");
		    String a6 = rs.getString("Charges");
		    chargess = rs.getInt("Charges");
		    
		    String a7 = rs.getString("Seats");
		    model.addRow(new Object[]{a0, a1,a2,a3,a4,a5,a6,a7});
		}
		EventQueue.invokeLater(new Runnable() {			
			public void run() {
				try {
					 frame = new FlightResult();
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
	public FlightResult() {
		super("Results");
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

	
		JButton button_1 = new JButton("X");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(1577, 13, 41, 25);
		contentPane.add(button_1);
		
		
		JLabel lblFlightsAvaliable = new JLabel("Avaliable Flights");
		lblFlightsAvaliable.setForeground(new Color(255, 255, 255));
		lblFlightsAvaliable.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		lblFlightsAvaliable.setBounds(45, 29, 221, 44);
		contentPane.add(lblFlightsAvaliable);
		
		JButton btnBook = new JButton("Back");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					BookFlights.mainn(null);
					frame.setVisible(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBook.setBounds(45, 651, 374, 74);
		contentPane.add(btnBook);
		
		JButton button = new JButton("Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				String s_flight=(String) table.getValueAt(i, 0);
				int totalamount = chargess*nuAdult + chargess*nuChild;
				stat.setText(String.valueOf(totalamount));
				CustomerDetails.CD(s_flight,totalamount);
				frame.setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(1097, 651, 371, 74);
		contentPane.add(button);
		
		table = new JTable();
		table.setSelectionBackground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(19);
		table.setBorder(null);
		table.setForeground(new Color(255, 255, 255));
		table.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		table.setBounds(45, 101, 1425, 520);
		table.setModel(model);
		table.setOpaque(false);
		contentPane.add(table);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		
		stat = new JLabel("");
		stat.setBounds(0, 0, 158, 16);
		contentPane.add(stat);
		
		JLabel background=new JLabel(new ImageIcon("a.jpg"));
		background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		background.setBounds(-60,-60,1997,880);
		contentPane.add(background);
		
	}
}
