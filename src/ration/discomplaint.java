package ration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

public class discomplaint extends JFrame {

	private JPanel contentPane;
	Connection con=DataBaseConnection.getConnection();
	PreparedStatement pat;
	ResultSet ra;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					discomplaint frame = new discomplaint("hi");
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
	public discomplaint(final String user) {
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
		
		panel.setBounds(0, 224, 307, 51);
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
                dishome ah = new dishome(user);
               
                ah.setTitle("Home");
                ah.setVisible(true);
			}
		});
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
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(51, 0, 102));
			}
			public void mouseClicked(MouseEvent e) {
				dispose();
                disitem ah = new disitem(user);
               
                ah.setTitle("Items");
                ah.setVisible(true);
			}
		});
		
		
		panel_1.setBackground(new Color(51, 0, 102));
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
		
		JLabel lblNewLabel_1_1 = new JLabel("ITEMS QUANTITY");
		
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(253, 245, 230));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(81, 0, 153, 51);
		panel_1.add(lblNewLabel_1_1);
		
		final JPanel panel_2 = new JPanel();
		
		panel_2.setBackground(new Color(51, 0, 102));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(128, 128, 128));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(51, 0, 102));
			}
			public void mouseClicked(MouseEvent e) {
				dispose();
                discustomer ah = new discustomer(user);
               
                ah.setTitle("Customer");
                ah.setVisible(true);
			}
		});
		panel_2.setBounds(0, 369, 307, 51);
		paneMenu.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(10, 0, 61, 51);
		try {
		    img = ImageIO.read(new File("C:\\\\Users\\\\divya\\\\Downloads\\\\rating.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		dimg = img.getScaledInstance(lblNewLabel_3_2.getWidth(), lblNewLabel_3_2.getHeight(),
		        Image.SCALE_SMOOTH);
		lblNewLabel_3_2.setIcon(new ImageIcon(dimg));
	
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("CUSTOMER");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(253, 245, 230));
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(99, 0, 106, 51);
		panel_2.add(lblNewLabel_1_2);
		
		final JPanel panel_3 = new JPanel();
		
		panel_3.setBackground(new Color(0,100,0));
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
		
		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textArea.setBounds(469, 324, 622, 100);
		
		contentPane.add(textArea);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textArea_1.setBounds(469, 523, 618, 100);
		
		contentPane.add(textArea_1);

		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedrow=table.getSelectedRow();
				textArea.setText((String) table.getValueAt(selectedrow, 0));
				textArea.setEditable(false);
				textArea_1.setText((String) table.getValueAt(selectedrow, 1));
			}
		});
		table.setRowSelectionAllowed(true);
		
		
		
		JLabel lblNewLabel = new JLabel("Previous Complaints  :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(417, 62, 233, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Request  :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(417, 264, 157, 32);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Response  :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(428, 466, 146, 32);
		contentPane.add(lblNewLabel_4);
		
				
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String req=textArea.getText();
					
					String res=textArea_1.getText();
					
					
					  
					  pat=con.prepareStatement("update complaint set response=? where request=?");
					  pat.setString(1, res);
					  pat.setString(2, req);
					  
					  pat.executeUpdate();
					  JOptionPane.showMessageDialog(null,"Response sent successfully...");
					  table_load(user);
					  
					  
					  
				}
				catch(SQLException eq) {
					eq.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(1126, 554, 120, 32);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(465, 109, 631, 111);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		
		table_load(user);
		
		
		
		
		
	}
	
	public void table_load(String user)
	{
		try {
			pat=con.prepareStatement("select request,response from complaint where dis_id=?");
			pat.setString(1, user);
			ra=pat.executeQuery();
			  table.setModel(DbUtils.resultSetToTableModel(ra));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
