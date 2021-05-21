package Member_4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import Main.Home_Frame;
import dbConnect.DBConnect;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class AddSessionRooms {

	private JFrame frame;
	private JRadioButton rdbtnConsecutive; 
	private JRadioButton rdbtnParallelSessions;
	private JRadioButton rdbtnNonOverlapping;
	private JComboBox rooms_1;
	private JComboBox roomsss;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSessionRooms window = new AddSessionRooms();
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
	
	
	public void fillRoom() {

		try {
			Connection con = DBConnect.connect();
			
			String query="select * from location";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();

			while(rs.next()) {
				String group=rs.getString("roomName");
			
				
				roomsss.addItem(group);
			
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}/**/
	}
	
	
	public AddSessionRooms() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBackground(Color.YELLOW);
		frame.setTitle("Add Session Rooms");		
		
		frame.setBounds(100, 40, 1350, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);	
	

		
			
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1344, 103);
		panel.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel company_name = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name.setBounds(128, 10, 1206, 93);
		panel.add(company_name);
		company_name.setHorizontalAlignment(SwingConstants.CENTER);
		company_name.setForeground(new Color(0, 0, 128));
		company_name.setFont(new Font("Sylfaen", Font.BOLD, 28));
		company_name.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(214, 10, 72, 72);
		panel.add(lblNewLabel_7);
		
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_2 = new JLabel("Select Session");
		lblNewLabel_2.setBounds(272, 317, 163, 25);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_2_1 = new JLabel("Select Room");
		lblNewLabel_2_1.setBounds(276, 570, 134, 25);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(Color.BLACK);

		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(178, 660, 1082, 124);
		panel_3.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Select Session");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(272, 461, 156, 33);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.BLACK);
	
		
		
		
		rooms_1 = new JComboBox();
		rooms_1.setBounds(639, 460, 273, 48);
		rooms_1.setModel(new DefaultComboBoxModel(new String[] {"Select Session","1","2","3"}));
		
		rooms_1.setForeground(new Color(255, 255, 0));
		rooms_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));	
		rooms_1.setBackground(new Color(0, 0, 0));
		rooms_1.setBorder(new LineBorder(Color.BLACK, 2));
		frame.getContentPane().add(rooms_1);
		

		
		
		
		
		roomsss = new JComboBox();
		/**/
		roomsss.setModel(new DefaultComboBoxModel(new String[] {"Select a Room"}));
		
		roomsss.setForeground(new Color(255, 255, 0));
		roomsss.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));	
		roomsss.setBackground(new Color(240, 240, 240));
	//	roomsss.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		 
		roomsss.setBackground(new Color(51, 51, 51));
		roomsss.setBounds(639, 567, 273, 48);
		frame.getContentPane().add(roomsss);
		
		
		rdbtnConsecutive = new JRadioButton("Consecutive Sessions");
		rdbtnConsecutive.setBackground(new Color(0, 206, 209));
		rdbtnConsecutive.setBounds(639, 293, 273, 33);
		rdbtnConsecutive.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(rdbtnConsecutive);
		rdbtnConsecutive.setForeground(Color.BLACK);
		rdbtnConsecutive.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		
		rdbtnParallelSessions = new JRadioButton("Parrallel Sessions");
		rdbtnParallelSessions.setBackground(new Color(0, 206, 209));
		rdbtnParallelSessions.setBounds(639, 336, 273, 33);
		rdbtnParallelSessions.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(rdbtnParallelSessions);
		rdbtnParallelSessions.setForeground(Color.BLACK);
		rdbtnParallelSessions.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		
		rdbtnNonOverlapping = new JRadioButton("Non Overlapping");			
		rdbtnNonOverlapping.setBackground(new Color(0, 206, 209));
		rdbtnNonOverlapping.setBounds(639, 382, 273, 37);
		rdbtnNonOverlapping.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(rdbtnNonOverlapping);

		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(106, 90, 205));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				String sessionType = null;
				String session = null;
				String room = null;
				String Combosession = rooms_1.getSelectedItem().toString();
				String Comboroom = roomsss.getSelectedItem().toString();
				String sessionSign = Combosession +" " + Comboroom;
				
				
				if(rooms_1.getSelectedItem().toString().equals("") || roomsss.getSelectedItem().toString().equals("") || rooms_1.getSelectedItem().toString().equals("Select Session..") ||  roomsss.getSelectedItem().toString().equals("Select a Room..") ) {
					JOptionPane.showMessageDialog(null, "Please fill the Data");			
				}else {
					
					
					 
	                if (rdbtnConsecutive.isSelected()) { 
	                	sessionType = "Consecutive";
	                	System.out.println("Session type" + sessionType);
	     
	                	
	                }else if (rdbtnParallelSessions.isSelected()) { 
	                	sessionType = "Parallel"; 
	                
	                	
	                	
	                } else if (rdbtnNonOverlapping.isSelected()) { 
	                	sessionType = "Non overlapping"; 
	                	
	                	
	                } else { 
	                	JOptionPane.showMessageDialog(panel, "Please select a Type", "Warning Select a Session ",JOptionPane.WARNING_MESSAGE);
	                } 
	                
	               
	   /*   */            try {
						 Connection con = DBConnect.connect();
	
		                    String query = "INSERT INTO roomSession values(null, '" + Combosession + "','" + Comboroom + "','"+ sessionSign +"')";
	
		                    Statement sta = con.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                        JOptionPane.showMessageDialog(btnSave, "This alredy exists");
		                    } else {
		                        JOptionPane.showMessageDialog(btnSave,
		                            "Successfully inserted");
		                    }
		                    con.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                	
		                }     
		
				}
			}
		});
		btnSave.setBounds(312, 42, 163, 50);
		panel_3.add(btnSave);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(220, 20, 60));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rooms_1.removeAllItems();
				rooms_1.setModel(new DefaultComboBoxModel(new String[] {"Select Session..","1","2","3"}));
				rdbtnConsecutive.setSelected(false);
				rdbtnNonOverlapping.setSelected(false);
        		rdbtnParallelSessions.setSelected(false);

				roomsss.setSelectedIndex(0);				
			}
		});
		btnClear.setBounds(542, 42, 163, 50);
		panel_3.add(btnClear);
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(219, 112, 147));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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

		
		
		btnNewButton.setBounds(764, 44, 170, 50);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(0, 250, 154));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ViewRooms MWD = new ViewRooms();
				try {
					ViewRooms.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});

		btnNewButton_1.setBounds(72, 42, 163, 50);
		panel_3.add(btnNewButton_1);
		
		JLabel lblSessionRooms = new JLabel("Session Rooms");
		lblSessionRooms.setForeground(Color.RED);
		lblSessionRooms.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblSessionRooms.setBounds(553, 116, 273, 52);
		frame.getContentPane().add(lblSessionRooms);
		
	

		fillRoom();
		
	}	
}