package com.bankaccounts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;


import javax.swing.JButton;

import java.sql.*;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class login {

	private JFrame frame;
	
	private final int WINDOW_H = 505;

	private final int WINDOW_W = 780;
	
	private JPasswordField passwordField;
	
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	
	Connection connection = null;
	
	
	
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
		connection = sqlconnection.dbConnector();
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, WINDOW_W, WINDOW_H);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelWelcome = new JLabel("Welcome to JBank of America");
		labelWelcome.setIcon(new ImageIcon("C:\\Users\\joshu\\OneDrive\\Pictures\\Icons\\iconfinder_00-ELASTOFONT-STORE-READY_bank_2703084.png"));
		labelWelcome.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 31));
		labelWelcome.setBounds(10, 10, 502, 194);
		frame.getContentPane().add(labelWelcome);
		
		JLabel labelAccountID = new JLabel("Account Identification Number:");
		labelAccountID.setIcon(new ImageIcon("C:\\Users\\joshu\\OneDrive\\Pictures\\Icons\\seo-and-web.png"));
		labelAccountID.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 30));
		labelAccountID.setBounds(10, 223, 547, 65);
		frame.getContentPane().add(labelAccountID);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
		passwordField.setEchoChar('*');
		passwordField.setBounds(10, 328, 502, 40);
		frame.getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from info where username=? and password=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, passwordField.getText());

		
					ResultSet rs = pst.executeQuery();
					int count = 0;
					
					while(rs.next()) {
						
						count=count +1;
						
					}
					
					if(count ==1) 
					
					{
						
						JOptionPane.showMessageDialog(null, "Identification number Correct");

						
					}
					
					else if(count>1) {
						
						JOptionPane.showMessageDialog(null, "Duplicate Identification number");

					}
					
					else {
						JOptionPane.showMessageDialog(null, "Try again...");

					}
					
					
				
					
					
					
			} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1);
				}
				
				finally {
					try {
						
						
						
					} catch(Exception e1) {
						
						JOptionPane.showMessageDialog(null, e1);

						
					}
				}
				
				
				
				
		  }
		});
		
		
		loginButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 25));
		loginButton.setBounds(10, 382, 300, 76);
		frame.getContentPane().add(loginButton);
	}
	
	
	private class SwingAction extends AbstractAction {
		
		
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	
	private class SwingAction_1 extends AbstractAction {
		
		
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		
		public void actionPerformed(ActionEvent e) {
		}
	}
}
