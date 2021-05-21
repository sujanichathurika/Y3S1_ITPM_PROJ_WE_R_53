package Member_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Main.Home_Frame;
import dbConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class Manage_tag_Registration {

	private JFrame frame;
	private JTable table;
	private JTextField display_ID;
	private JTextField dis_tag_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_tag_Registration window = new Manage_tag_Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manage_tag_Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				try {
					Connection con = DBConnect.connect();
					
					String query="select * from tag";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 1107, 784);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tag Registration");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(374, 86, 231, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(new Color(255, 153, 51));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = DBConnect.connect();					
					String query="UPDATE tag SET tagName ='"+dis_tag_name.getText()+"' WHERE tagID='"+ display_ID .getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					
				}
				catch(Exception ea) {
					ea.printStackTrace();
				}
				}
				
				
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(94, 368, 256, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from tag where tagID='"+display_ID.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
					
					}
					catch(Exception en) {
						en.printStackTrace();
						
					}

			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(360, 368, 256, 48);
		frame.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(123, 104, 238));
		btnClear.setForeground(Color.BLACK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
		
				dis_tag_name.setText(null);
			
				
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBounds(646, 368, 256, 48);
		frame.getContentPane().add(btnClear);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(38, 467, 256, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tag Name");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(38, 581, 256, 48);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		display_ID = new JTextField();
		display_ID.setBounds(148, 467, 256, 40);
		frame.getContentPane().add(display_ID);
		display_ID.setColumns(10);
		
		dis_tag_name = new JTextField();
		dis_tag_name.setColumns(10);
		dis_tag_name.setBounds(148, 586, 256, 40);
		frame.getContentPane().add(dis_tag_name);
	 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 144, 959, 214);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRow=table.getSelectedRow();
			    display_ID.setText(table.getValueAt(selectedRow, 0).toString());
			   
			    dis_tag_name.setText(table.getValueAt(selectedRow, 1).toString());
			  
		
			               
										 
			}
		});
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1088, 78, -1085, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(1096, 81, -1085, 12);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_main = new JSeparator();
		separator_main.setForeground(Color.BLACK);
		separator_main.setBackground(Color.BLACK);
		separator_main.setBounds(0, 81, 1103, 12);
		frame.getContentPane().add(separator_main);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tag_Registration MWD = new Tag_Registration();
				try {
					Tag_Registration.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});

		btnNewButton_1.setBounds(850, 678, 110, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel company_name_1 = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name_1.setHorizontalAlignment(SwingConstants.CENTER);
		company_name_1.setForeground(new Color(0, 0, 128));
		company_name_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		company_name_1.setBackground(Color.LIGHT_GRAY);
		company_name_1.setBounds(0, 0, 1077, 93);
		frame.getContentPane().add(company_name_1);
			
	}
}
