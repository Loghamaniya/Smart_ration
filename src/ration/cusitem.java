package ration;

import java.awt.EventQueue;
import java.io.*;
import java.util.*; 

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

import net.proteanit.sql.DbUtils;

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
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class cusitem extends JFrame {

	private JPanel contentPane;
	static String word="hi";
//	static String word="hi";
	Connection con=DataBaseConnection.getConnection();
	PreparedStatement pat;
	ResultSet ra;
	private JTable table;
	ArrayList<String> al = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cusitem frame = new cusitem(word);
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
	public cusitem(final String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 700);
		setLocationRelativeTo(null);
//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(51, 0, 102));
		paneMenu.setBounds(0, 0, 307, 661);
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
		
		final JPanel panel = new JPanel();
		
		panel.setBackground(new Color(51, 0, 102));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(51, 0, 102));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
                cushome ah = new cushome(user);
               
                ah.setTitle("Home");
                ah.setVisible(true);
			}
		});
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
		
		final JPanel panel_1 = new JPanel();
		
		panel_1.setBackground(new Color(0, 100, 0));
		panel_1.setBounds(0, 297, 307, 51);
		
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
		
		final JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(51, 0, 102));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.size()>0) {
					dispose();
	                cuspayment ah = new cuspayment(al,user);
	               
	                ah.setTitle("Payment");
	                ah.setVisible(true);
					
				}
				else {
					dispose();
	                cuspayment ah = new cuspayment(user);
	               
	                ah.setTitle("Payment");
	                ah.setVisible(true);
				}
				
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
		
		final JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(51, 0, 102));
			}
			public void mouseClicked(MouseEvent e) {
				dispose();
                cuscomplaint ah = new cuscomplaint(user);
               
                ah.setTitle("Complaint");
                ah.setVisible(true);
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
		
		JLabel lblNewLabel = new JLabel("Allocated items  :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(435, 66, 184, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(480, 131, 659, 136);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Select the items   :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(435, 334, 215, 30);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Payment  ->");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.size()>0) {
					dispose();
	                cuspayment ah = new cuspayment(al,user);
	               
	                ah.setTitle("Payment");
	                ah.setVisible(true);
					
				}
				else {
					dispose();
	                cuspayment ah = new cuspayment(user);
	               
	                ah.setTitle("Payment");
	                ah.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(894, 554, 163, 40);
		contentPane.add(btnNewButton);
		
		
		
		
		
//		JCheckBox chckbxNewCheckBox = new JCheckBox("rice");
//		chckbxNewCheckBox.setBounds(510, 411, 97, 23);
//		contentPane.add(chckbxNewCheckBox);
		
		try {
			pat=con.prepareStatement("select no,i_name from items;");
			ra=pat.executeQuery();
			while(ra.next()) {
				String nos=ra.getString("no");
				int no=Integer.parseInt(nos);
//			ra.next();
				final JCheckBox chckbxNewCheckBox = new JCheckBox(ra.getString("i_name"));
				chckbxNewCheckBox.setBounds(510, 370+(no*30), 97, 23);
//				al.add(ra.getString("i_name"));
				chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(chckbxNewCheckBox.isSelected()) {
							al.add(chckbxNewCheckBox.getText());
						}
						else {
							al.remove(chckbxNewCheckBox.getText());
						}
						
					}
				});
				contentPane.add(chckbxNewCheckBox);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		table_load();
		
		
	}
	
	public void table_load()
	{
		try {
			pat=con.prepareStatement("select * from items");
			ra=pat.executeQuery();
			  table.setModel(DbUtils.resultSetToTableModel(ra));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public cusitem(String no,final String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 700);
		setLocationRelativeTo(null);
//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(51, 0, 102));
		paneMenu.setBounds(0, 0, 307, 661);
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
		
		final JPanel panel = new JPanel();
		
		panel.setBackground(new Color(51, 0, 102));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(51, 0, 102));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
                cushome ah = new cushome(user);
               
                ah.setTitle("Home");
                ah.setVisible(true);
			}
		});
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
		
		final JPanel panel_1 = new JPanel();
		
		panel_1.setBackground(new Color(0, 100, 0));
		panel_1.setBounds(0, 297, 307, 51);
		
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
		
		final JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(51, 0, 102));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(al.size()>0) {
					dispose();
	                cuspayment ah = new cuspayment(al,user);
	               
	                ah.setTitle("Payment");
	                ah.setVisible(true);
					
				}
				else {
					dispose();
	                cuspayment ah = new cuspayment(user);
	               
	                ah.setTitle("Payment");
	                ah.setVisible(true);
				}
				
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
		
		final JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(51, 0, 102));
			}
			public void mouseClicked(MouseEvent e) {
				dispose();
                cuscomplaint ah = new cuscomplaint(user);
               
                ah.setTitle("Complaint");
                ah.setVisible(true);
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
	
		
		JLabel lblNewLabel_4 = new JLabel("You already bought item for this month !");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_4.setBounds(514, 297, 659, 26);
		contentPane.add(lblNewLabel_4);
		
	}
}

