package ration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import ration.cushome;
import ration.DataBaseConnection;
//import ration.connection;

import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class login {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	Connection con=DataBaseConnection.getConnection();
	public String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.setBounds(0, 0, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username   :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(498, 216, 183, 49);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(498, 267, 279, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password  :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(498, 387, 105, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		String[] role= {"distributors","customers"};
		final JComboBox comboBox = new JComboBox(role);
		comboBox.setBounds(493, 132, 279, 43);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Select role  :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(493, 84, 123, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(498, 438, 279, 43);
		passwordField.setEchoChar('*');
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = textField.getText();
                password =new String( passwordField.getPassword());
                Object roleo=comboBox.getSelectedItem();
				String roles=roleo.toString();
                
                try {
                	
                	if(roles=="customers") {
                
                PreparedStatement st = con
                        .prepareStatement("Select * from customers where cus_name=? and cus_pass=?");
//                	st.setString(1, roles);
                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                	
                    
                    if (rs.next()) {
                        frame.dispose();
                        cushome ah = new cushome(userName);
                       
                        ah.setTitle("Home");
                        ah.setVisible(true);
//                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username & Password");
                    }
                	}
                	
                	else if(roles=="distributors") {
                        
                        PreparedStatement st = con
                                .prepareStatement("Select name from distributors where dis_name=? and dis_pass=?");
//                        	st.setString(1, roles);
                            st.setString(1, userName);
                            st.setString(2, password);
                            ResultSet rs = st.executeQuery();
                        	
                            
                            if (rs.next()) {
                                frame.dispose();
                                dishome ah = new dishome(rs.getString("name"));
                               
                                ah.setTitle("Home");
                                ah.setVisible(true);
//                                JOptionPane.showMessageDialog(null, "You have successfully logged in");
                            } else {
                                JOptionPane.showMessageDialog(null, "Wrong Username & Password");
                            }
                        	}
                }
                catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(579, 569, 117, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\divya\\Downloads\\bruno-kelzer-tSPhAIl0QUU-unsplash.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1284, 661);
		frame.getContentPane().add(lblNewLabel_3);
	}

	
	public JTextField getTextField() {
		return textField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
}

