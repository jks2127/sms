package coreFiles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tf_email;
	private JTextField tf_pswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBorder(UIManager.getBorder("TextField.border"));
		header.setBackground(SystemColor.textHighlight);
		header.setBounds(10, 11, 607, 54);
		contentPane.add(header);
		header.setLayout(null);
		
		JPanel body = new JPanel();
		body.setBounds(10, 76, 607, 360);
		contentPane.add(body);
		body.setLayout(null);
		
		JLabel lbl_header_title = new JLabel("Student Management System");
		lbl_header_title.setForeground(new Color(255, 255, 224));
		lbl_header_title.setFont(new Font("Yu Gothic Light", Font.BOLD, 24));
		lbl_header_title.setBounds(66, 11, 441, 37);
		lbl_header_title.setIcon(new ImageIcon("D:\\Videos\\Learn\\Ionic\\UI Components - Ionic Documentation_files\\component-button-icon.png"));
		header.add(lbl_header_title);	
	
		
		//setUndecorated(true);	
		
		tf_email = new JTextField();
		tf_email.setBounds(234, 120, 211, 20);
		body.add(tf_email);
		tf_email.setColumns(10);
		
		tf_pswd = new JTextField();
		tf_pswd.setColumns(10);
		tf_pswd.setBounds(234, 168, 211, 20);
		body.add(tf_pswd);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbl_email.setBounds(160, 120, 74, 20);
		body.add(lbl_email);
		
		JLabel lbl_pswd = new JLabel("Password");
		lbl_pswd.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbl_pswd.setBounds(160, 168, 74, 20);
		body.add(lbl_pswd);
		
		JButton btn_login = new JButton("LogIn");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=CP.createC();
				String q="select * from login;";
				try {
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(q);
					
					if(rs.next()) {
						String email=rs.getString(1);
						String pswd=rs.getString(2);
						if ( (tf_email.getText().equals(email)) && (tf_pswd.getText().equals(pswd)) ) {
							new Options().setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(btn_login, "Credentials does not matches....");
						}
						
					}
					
				} catch (SQLException e1) {
				} 
				
			}
		});
		btn_login.setBackground(new Color(211, 211, 211));
		btn_login.setFont(new Font("Verdana", Font.PLAIN, 12));
		btn_login.setBounds(356, 215, 89, 23);
		body.add(btn_login);
		

	}
}
