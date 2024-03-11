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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class discustomer extends JFrame {

	private JPanel contentPane;
	Connection con=DataBaseConnection.getConnection();
	PreparedStatement pat;
	ResultSet ra;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					discustomer frame = new discustomer("hi");
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
	public discustomer(final String user) {
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
		
		panel_2.setBackground(new Color(0,100,0));
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
		
		panel_3.setBackground(new Color(51, 0, 102));
		panel_3.setBounds(0, 437, 307, 51);
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
                discomplaint ah = new discomplaint(user);
               
                ah.setTitle("Complaint");
                ah.setVisible(true);
			}
		});
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
		
		JButton btnNewButton = new JButton("Total Customer");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_load1(user);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(412, 101, 213, 43);
		contentPane.add(btnNewButton);
		
		JButton btnBoughtCustomer = new JButton("Bought Customer");
		btnBoughtCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_load2(user);
			}
		});
		btnBoughtCustomer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBoughtCustomer.setBounds(412, 214, 213, 43);
		contentPane.add(btnBoughtCustomer);
		
		JButton btnUnboughtCustomer = new JButton("Unbought Customer");
		btnUnboughtCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_load3(user);
			}
		});
		btnUnboughtCustomer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUnboughtCustomer.setBounds(412, 327, 213, 43);
		contentPane.add(btnUnboughtCustomer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(695, 153, 544, 170);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedrow=table.getSelectedRow();
				textField.setText((String) table.getValueAt(selectedrow, 0));
				textField.setEditable(false);
				textField_1.setText((String) table.getValueAt(selectedrow, 1));
				textField_1.setEditable(false);
				textField_2.setText((String) table.getValueAt(selectedrow, 2));
			}
		});
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("ID       :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(516, 461, 109, 34);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(616, 461, 135, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name      :");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblName.setBounds(912, 461, 109, 34);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(1031, 461, 135, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(616, 555, 135, 34);
		contentPane.add(textField_2);
		
		JLabel lblBought = new JLabel("Bought    :");
		lblBought.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBought.setBounds(496, 553, 109, 34);
		contentPane.add(lblBought);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					try {
						pat=con.prepareStatement("update cus set bought=? where c_id=?");
						pat.setString(1, textField_2.getText());
						pat.setString(2, textField.getText());
						
						pat.executeUpdate();
						JOptionPane.showMessageDialog(null,"Customer updated successfully...");
						table_load3(user);
						textField_1.setText("");
						textField_2.setText("");
						textField.setText("");
						
						
					}
					catch(SQLException ex) {
						ex.printStackTrace();
					}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(974, 555, 118, 34);
		contentPane.add(btnNewButton_1);
		table_load1(user);
		
		
		
	}
	public void table_load1(String user)
	{
		try {
			pat=con.prepareStatement("select c_id,c_name,bought from cus where dis_no=?");
			pat.setString(1, user);
			ra=pat.executeQuery();
			  table.setModel(DbUtils.resultSetToTableModel(ra));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void table_load2(String user)
	{
		try {
			pat=con.prepareStatement("select c_id,c_name,bought from cus where dis_no=? and bought='1'");
			pat.setString(1, user);
			ra=pat.executeQuery();
			  table.setModel(DbUtils.resultSetToTableModel(ra));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void table_load3(String user)
	{
		try {
			pat=con.prepareStatement("select c_id,c_name,bought from cus where dis_no=? and bought='0'");
			pat.setString(1, user);
			ra=pat.executeQuery();
			  table.setModel(DbUtils.resultSetToTableModel(ra));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
