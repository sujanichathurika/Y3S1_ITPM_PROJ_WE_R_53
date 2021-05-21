package Member_4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Main.Home_Frame;
import dbConnect.DBConnect;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Static_Managemet {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private int gSum, gSum2, gSum23, gSum24;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Static_Managemet window = new Static_Managemet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setData() {

		try {
			Connection con = DBConnect.connect();
	
	
			String query="select count (*) as allLoc from lecturers ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();			
			String sum = rs.getString("allLoc");
			gSum = Integer.parseInt(sum);	
			textField.setText(sum);

		
			String query2="select count (*) as allLoc from studentGroups ";
			PreparedStatement pst2=con.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			String su2m = rs2.getString("allLoc");
			gSum2 = Integer.parseInt(su2m);			
			textField_1.setText(su2m);
			
	
			String query23="select count (*) as allLoc from subjects ";
			PreparedStatement pst23=con.prepareStatement(query23);
			ResultSet rs23=pst23.executeQuery();
			String su2m3 = rs23.getString("allLoc");
			gSum23 = Integer.parseInt(su2m3);			
			textField_2.setText(su2m3);
	
	
			String query24="select count(*) as allc from location ";
			PreparedStatement pst24=con.prepareStatement(query24);
			ResultSet rs24=pst24.executeQuery();
			String su2m4 = rs24.getString("allc");
			gSum24 = Integer.parseInt(su2m4);			
			textField_3.setText(su2m4);
	
			System.out.println(gSum24);
		}
		catch(Exception load) {
			load.printStackTrace();
		}	
	}
	/**
	 * Create the application.
	 */
	public Static_Managemet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(32, 178, 170));
		frame.setBounds(100, 100, 1229, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1221, 90);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(img));
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBackground(Color.BLUE);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(199, 201, 116, 82);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(435, 197, 116, 86);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(696, 201, 116, 82);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(961, 201, 116, 82);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Registered Lecturers");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(175, 315, 169, 60);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Registered Subjects");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(419, 315, 169, 60);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Registered Student Groups");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(659, 315, 224, 60);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Registered Of Rooms");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(938, 315, 169, 60);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_Frame MWD = new Home_Frame();
				try {
					Home_Frame.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		
		
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(552, 453, 153, 52);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 638, 1211, 65);
		frame.getContentPane().add(panel_2);
		
		setData();
	}
}
