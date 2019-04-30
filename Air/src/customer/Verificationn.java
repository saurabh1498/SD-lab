package customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Verificationn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static int pin,i;
	static Verificationn fm;
	static String emaill;
	static String Amount,ID,name,FathersName,DateOfBirth,Gender,Phone,email,ImgPath;
	/**
	 * Launch the application.
	 */
	public static void main(String amt,String id,String nm,String fnm,String gen,String dobb,String phone,String imgPath,String em,int args) {
		pin=args;
		emaill=em;
///
		Amount=amt;
		ID=id;
		name=nm;
		FathersName=fnm;
		Gender=gen;
		DateOfBirth=dobb;
		Phone=phone;
		email=em;
		ImgPath=imgPath;
///
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verificationn frame = new Verificationn();
					fm=frame;
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
	public Verificationn() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 729, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVerification = new JLabel("Verification");
		lblVerification.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 30));
		lblVerification.setBounds(283, 25, 185, 35);
		contentPane.add(lblVerification);
		
		JLabel lblEmail = new JLabel("OTP sent to");
		lblEmail.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblEmail.setBounds(45, 104, 152, 35);
		contentPane.add(lblEmail);
		
		JLabel label = new JLabel(emaill);
		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		label.setBounds(214, 66, 283, 35);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Verify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane jp = new JOptionPane();
				 i=Integer.parseInt(textField.getText());
				 System.out.println(pin+"this is pin");
				 System.out.println(i+"this is text");
				if(i==pin)
				{
					//System.out.println("they are equal");
					jp.showMessageDialog(fm,"OTP Verification Successful","Alert",JOptionPane.WARNING_MESSAGE);
					ConfermCustomerDeatils.CCD(Amount,ID,name,FathersName,Gender,DateOfBirth,Phone,ImgPath,emaill);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				}else{
					//System.out.println("they are not");
					jp.showMessageDialog(fm,"Wrong password OTP Verification Faild","Alert",JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(283, 210, 152, 52);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(224, 109, 320, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(676, 13, 41, 25);
		contentPane.add(button);
		
		JLabel background=new JLabel(new ImageIcon("a.jpg"));
		background.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		background.setBounds(0, 0, 829, 468);
		contentPane.add(background);
	}
}
