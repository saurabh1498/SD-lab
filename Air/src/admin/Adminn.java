package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.api.jdbc.Statement;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Adminn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JPanel p1=new JPanel();    
    JPanel p2=new JPanel();    
	static DefaultTableModel model_c=new DefaultTableModel(new String[]{"ID","NAME","Fathers Name","Gender","DOB","Phone number","Email","Image","FlightID"}, 0);
	static DefaultTableModel dtt;
	JTable table_1;
	 JTable table;
	private JTextField txtEnterCustomerId;
	private JButton btnSearchCustomer;
	private JButton btnDelete;
	static Statement st;
	JLabel lblNewLabel;
	private JButton btnRefresh;
	private JButton btnUpdate;
	static Connection con;
	private JLabel label;
	private JButton btnNewButton;
	private JButton button;
	public void db() throws Exception
	{
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID","NAME","Source","Destination","Departure","Arrival","charges","seats"}, 0);
		model.addRow(new Object[]{"ID","Name","Source","Destination","Departure","Arrival","Charges","Seats"});
		model_c.addRow(new Object[]{"ID","Name","Fathers Name","Gender","DOB","Phone No","Email","FlightID"});
		 st= (Statement) con.createStatement();
		ResultSet rs =st.executeQuery("SELECT * FROM airline.flights ");
		while(rs.next())
		{     
			String a0 = rs.getString("ID");
		    String a1= rs.getString("Name");
		    String a2 = rs.getString("Source");
		    String a3 = rs.getString("Destination");
		    String a4 = rs.getString("Departure");
		    String a5 = rs.getString("Arrival");
		    String a6 = rs.getString("Charges");
		    String a7 = rs.getString("Seats");
		    model.addRow(new Object[]{a0, a1,a2,a3,a4,a5,a6,a7});
		}
		ResultSet rss= st.executeQuery("Select * from airline.customers");
		while(rss.next())
		{
			String a0 = rss.getString("ID");
		    String a1= rss.getString("Name");
		    String a2 = rss.getString("FathersName");
		    String a3 = rss.getString("Gender");
		    String a4 = rss.getString("DateOfBirth");
		    String a5 = rss.getString("PhoneNumber");
		    String a6 = rss.getString("Email");
		    String a7 = rss.getString("FlightID");
		    //String a7 = rs.getString("Seats");
		    model_c.addRow(new Object[]{a0, a1,a2,a3,a4,a5,a6,a7});
		}
		dtt=model;
	}
	/**
	 * Launch the application.
	 */
	public static void mainnn(String[] args) throws Exception {
		  try {
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	            //SwingUtilities.updateComponentTreeUI(this);
			 // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        JFrame.setDefaultLookAndFeelDecorated(true);
	        
		Class.forName("com.mysql.jdbc.Driver");
		 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","lucifer123");
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminn frame = new Adminn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Adminn() throws Exception {
		super("ADMIN");
		db();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,1630,804); 
		contentPane = new JPanel();
		//ImageIcon m = new ImageIcon("a.jpg");
		///contentPane.setBackground();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Virgin Airlines");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(25, 19, 452, 38);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("X");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(1579, 13, 39, 30);
		contentPane.add(btnNewButton);
		tabbedPane.setBounds(0,70,1630,750);
		contentPane.add(tabbedPane);
		p1.setBorder(null);
		p1.setLayout(null);
		tabbedPane.add("Flight Management",p1);  
		tabbedPane.setOpaque(false);
		table_1 = new JTable();
		table_1.setRowHeight(20);
		table_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		table_1.setBounds(35, 33, 1275, 602);
		table_1.setModel(dtt);
		p1.add(table_1);
		
		JButton btnAddNewFlight = new JButton("Add new Flight");
		btnAddNewFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddFlight.main(null);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAddNewFlight.setBounds(1404, 75, 141, 35);
		p1.add(btnAddNewFlight);
		
		JButton btnEditDetails = new JButton("Edit Details");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table_1.getSelectedRow();
				String s_flight=(String) table_1.getValueAt(i, 0);
				try {
					EditFlightDetails.main(s_flight);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnEditDetails.setBounds(1404, 181, 141, 35);
		p1.add(btnEditDetails);
		
		JButton btnRemoveFlight = new JButton("Remove Flight");
		btnRemoveFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table_1.getSelectedRow();
				String s_flight=(String) table_1.getValueAt(i, 0);
				try {
					st.execute("DELETE FROM airline.flights WHERE ID ="+s_flight);
					lblNewLabel.setText("Row Succesfully deleted");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnRemoveFlight.setBounds(1404, 286, 141, 35);
		p1.add(btnRemoveFlight);
		
		lblNewLabel = new JLabel("Status");
		lblNewLabel.setBounds(12, 665, 420, 33);
		p1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Login.refresh();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnRefresh.setBounds(1404, 398, 141, 35);
		p1.add(btnRefresh);
		p2.setBorder(null);
		tabbedPane.add("Customer Management",p2); 
		p2.setLayout(null);
		
		button = new JButton("Refresh");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(1391, 341, 141, 35);
		p2.add(button);
		
		table = new JTable();
		table.setRowHeight(20);
		table.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		table.setBounds(35, 33, 1275, 571);
		table.setModel(model_c);
		p2.add(table);
	
		
		txtEnterCustomerId = new JTextField();
		txtEnterCustomerId.setText("Enter Customer id here");
		txtEnterCustomerId.setColumns(10);
		txtEnterCustomerId.setBounds(35, 638, 178, 35);
		p2.add(txtEnterCustomerId);
		
		btnSearchCustomer = new JButton("Search Customer");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iddd=txtEnterCustomerId.getText();
				try {
					EditCustomerDetails.main(iddd);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSearchCustomer.setBounds(299, 638, 141, 35);
		p2.add(btnSearchCustomer);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i=table.getSelectedRow();
				String s_cust=(String) table.getValueAt(i, 0);
				try {
					st.execute("DELETE FROM airline.customers WHERE ID ="+s_cust);
					lblNewLabel.setText("Row Succesfully deleted");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(1391, 221, 141, 35);
		p2.add(btnDelete);
		
		btnUpdate = new JButton("Update/View");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				String s_flight=(String) table.getValueAt(i, 0);
				try {
					EditCustomerDetails.main(s_flight);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(1391, 68, 141, 35);
		p2.add(btnUpdate);
		
		p1.setOpaque(false);
		JLabel background=new JLabel(new ImageIcon("a.jpg"));
		p1.add(background);
		background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		background.setBounds(-5,-108,1635,830);
		p2.setOpaque(false);
		
		label = new JLabel(new ImageIcon("a.jpg"));
		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		label.setBounds(-5,-108,1635,830);
		p2.add(label);
		
		JLabel bc=new JLabel(new ImageIcon("a.jpg"));
		bc.setBounds(-10,0,1642,830);
		contentPane.add(bc);
	}
}
