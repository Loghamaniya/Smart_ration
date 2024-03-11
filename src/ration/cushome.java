package ration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ration.login;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

//import head.course;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class cushome extends JFrame {

	private JPanel contentPane;
	static String word="hi";
	static String id="1";
	Connection con=DataBaseConnection.getConnection();
	private JTextField textField;
	PreparedStatement pat;
	ResultSet ra;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	final JPanel panel_1;
	final JPanel panel_2;
	final JPanel panel_3 ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cushome frame = new cushome();
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
	public cushome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 700);
		setLocationRelativeTo(null);
//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,204,102));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Card    No          :");
		lblNewLabel.setBounds(579, 102, 159, 26);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Card Holder      :");
		lblNewLabel_2.setBounds(579, 168, 159, 26);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(797, 102, 118, 26);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(797, 168, 116, 26);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBounds(0, 0, 307, 661);
		paneMenu.setBackground(new Color(51, 0, 102));
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(10, 11, 287, 146);
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("C:\\\\Users\\\\divya\\\\Downloads\\\\andy-hermawan-uFdCDgnoNVI-unsplash.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(),
		        Image.SCALE_SMOOTH);
//		ImageIcon imageIcon = new ImageIcon(dimg);
		lblIcon.setIcon(new ImageIcon(dimg));
		
		paneMenu.add(lblIcon);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(0, 224, 307, 51);
		paneMenu.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("HOME");
		lblNewLabel_1.setForeground(new Color(253, 245, 230));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(102, 0, 106, 51);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 0, 61, 51);
		try {
		    img = ImageIO.read(new File("C:\\\\Users\\\\divya\\\\Downloads\\\\house.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		dimg = img.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(),
		        Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(dimg));
		
		panel.add(lblNewLabel_3);
		
		panel_1 = new JPanel();
		
		panel_1.setBackground(new Color(51, 0, 102));
		panel_1.setBounds(0, 297, 307, 51);
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(51, 0, 102));
			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				dispose();
//                cusitem ah = new cusitem();
//               
//                ah.setTitle("Items");
//                ah.setVisible(true);
//			}
		});
		paneMenu.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(10, 0, 61, 51);
		try {
		    img = ImageIO.read(new File("C:\\\\Users\\\\divya\\\\Downloads\\\\purchase-order.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		dimg = img.getScaledInstance(lblNewLabel_3_1.getWidth(), lblNewLabel_3_1.getHeight(),
		        Image.SCALE_SMOOTH);
		lblNewLabel_3_1.setIcon(new ImageIcon(dimg));
		
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ALLOCATED ITEMS");
		
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(253, 245, 230));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(81, 0, 153, 51);
		panel_1.add(lblNewLabel_1_1);
		
		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(51, 0, 102));
			}
			
		});
		panel_2.setBackground(new Color(51, 0, 102));
		panel_2.setBounds(0, 369, 307, 51);
		paneMenu.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(10, 0, 61, 51);
		try {
		    img = ImageIO.read(new File("C:\\\\Users\\\\divya\\\\Downloads\\\\banking.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		dimg = img.getScaledInstance(lblNewLabel_3_2.getWidth(), lblNewLabel_3_2.getHeight(),
		        Image.SCALE_SMOOTH);
		lblNewLabel_3_2.setIcon(new ImageIcon(dimg));
	
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("PAYMENT");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(253, 245, 230));
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(99, 0, 106, 51);
		panel_2.add(lblNewLabel_1_2);
		
		panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(51, 0, 102));
			}
			
		});
		panel_3.setBackground(new Color(51, 0, 102));
		panel_3.setBounds(0, 437, 307, 51);
		paneMenu.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setBounds(10, 0, 61, 51);
		try {
		    img = ImageIO.read(new File("C:\\\\Users\\\\divya\\\\Downloads\\\\negative.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		dimg = img.getScaledInstance(lblNewLabel_3_3.getWidth(), lblNewLabel_3_3.getHeight(),
		        Image.SCALE_SMOOTH);
		lblNewLabel_3_3.setIcon(new ImageIcon(dimg));
		
		panel_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("COMPLAINTS");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(new Color(253, 245, 230));
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(103, 0, 106, 51);
		panel_3.add(lblNewLabel_1_3);
		
		final JPanel panel_3_1 = new JPanel();
		panel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3_1.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3_1.setBackground(new Color(51, 0, 102));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
                login d = new login();
                d.frame.setTitle("login");
                d.frame.setVisible(true);
			}
		});
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(51, 0, 102));
		panel_3_1.setBounds(0, 508, 307, 51);
		paneMenu.add(panel_3_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("");
		lblNewLabel_3_3_1.setBounds(10, 0, 61, 51);
		try {
		    img = ImageIO.read(new File("C:\\\\Users\\\\divya\\\\Downloads\\\\check-out.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		dimg = img.getScaledInstance(lblNewLabel_3_3.getWidth(), lblNewLabel_3_3.getHeight(),
		        Image.SCALE_SMOOTH);
		lblNewLabel_3_3_1.setIcon(new ImageIcon(dimg));
		
		panel_3_1.add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("LOG OUT");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setForeground(new Color(253, 245, 230));
		lblNewLabel_1_3_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(103, 0, 106, 51);
		panel_3_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Card Members  :");
		lblNewLabel_4.setBounds(579, 302, 159, 26);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Distributor No   :");
		lblNewLabel_2_1.setBounds(579, 232, 159, 26);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(797, 231, 116, 27);
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(557, 371, 502, 127);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
	
	
	

	
	public cushome(String userName)
	{
//		this.word=userName;
		this();
		this.word=userName;
		load();
		
	}
	public void table_load()
	{
		try {
			pat=con.prepareStatement("select c_member,age,gender from members where c_id=?");
			pat.setString(1, id);
			ra=pat.executeQuery();
			  table.setModel(DbUtils.resultSetToTableModel(ra));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void load()
	{
//		textField.setText(word);
		try {
		 pat=con.prepareStatement("select c_id,c_name,dis_no from cus where pass=?;");
		 pat.setString(1, word);
		ra=pat.executeQuery();
		if(ra.next()==true)
		{
			textField.setText(ra.getString(1));
			id=ra.getString(1);
			textField_1.setText(ra.getString(2));
			textField_2.setText(ra.getString(3));
		}
		}
		 catch (SQLException sqlException) {
             sqlException.printStackTrace();
         }
		table_load();
		panel_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 pat=con.prepareStatement("select bought from cus where pass=?;");
					 pat.setString(1, word);
					ra=pat.executeQuery();
					if(ra.next()==true)
					{
						if(ra.getBoolean("bought")) {
							dispose();
			                cusitem ah = new cusitem("no",word);
			               
			                ah.setTitle("Items");
			                ah.setVisible(true);
							
						}
						else {
							dispose();
			                cusitem ah = new cusitem(word);
			               
			                ah.setTitle("Items");
			                ah.setVisible(true);
							
						}
						
					}
					}
					 catch (SQLException sqlException) {
			             sqlException.printStackTrace();
			         }
				
				
			}
		});
		
		panel_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
                cuspayment ah = new cuspayment(word);
               
                ah.setTitle("Payment");
                ah.setVisible(true);
			}
		});
		
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(51, 0, 102));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
                cuscomplaint ah = new cuscomplaint(word);
               
                ah.setTitle("Complaint");
                ah.setVisible(true);
			}
		});
		
	}
}
