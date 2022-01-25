package coreFiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Modify extends JFrame {

	private JPanel contentPane;
	JTextField tf_new_name;
	JTextField tf_new_phone;
	JTextField tf_new_address;
	
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
	public Modify() {
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
		
		JButton Btn_back = new JButton("<-");
		Btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Options().setVisible(true);
				dispose();
			}
		});
		Btn_back.setBounds(10, 14, 46, 34);
		header.add(Btn_back);

		JLabel lbl_enter_sid = new JLabel("Enter student ID to modify");
		lbl_enter_sid.setBounds(10, 16, 154, 14);
		body.add(lbl_enter_sid);

		JTextField tf_sidToModify = new JTextField();
		tf_sidToModify.setBounds(10, 41, 172, 20);
		body.add(tf_sidToModify);
		tf_sidToModify.setColumns(10);

		tf_new_name = new JTextField();
		tf_new_name.setBounds(375, 13, 203, 20);
		body.add(tf_new_name);
		tf_new_name.setColumns(10);
		
		tf_new_phone = new JTextField();
		tf_new_phone.setColumns(10);
		tf_new_phone.setBounds(375, 41, 203, 20);
		body.add(tf_new_phone);
		
		tf_new_address = new JTextField();
		tf_new_address.setColumns(10);
		tf_new_address.setBounds(375, 73, 203, 20);
		body.add(tf_new_address);
		
		JLabel lbl_name = new JLabel("New name");
		lbl_name.setBounds(283, 16, 82, 14);
		body.add(lbl_name);
		
		JLabel lbl_phone = new JLabel("New phone no.");
		lbl_phone.setBounds(283, 44, 82, 14);
		body.add(lbl_phone);
		
		JLabel lbl_address = new JLabel("New address");
		lbl_address.setBounds(283, 76, 82, 14);
		body.add(lbl_address);
		
		
		JButton btn_modify = new JButton("Modify");
		btn_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
										
				int x=Integer.parseInt(tf_sidToModify.getText());
				
				
				JButton btn_confirm_modify = new JButton("Confirm New Info");
				btn_confirm_modify.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Students st=new Students();
						st.setName(tf_new_name.getText());
						st.setPhone(tf_new_phone.getText());
						st.setAddress(tf_new_address.getText());

						try {
							StudentDao.update(x, st);
							
							//Refresh table to reflect the modifications
							
							JScrollPane scrollPane = new JScrollPane();
							scrollPane.setBounds(0, 144, 607, 216);
							body.add(scrollPane);
							
							JTable table = new JTable();
							scrollPane.setViewportView(table);
							Connection con=CP.createC();
							ResultSet rs;
							try {
								rs = StudentDao.showFromDB(con);
								table.setModel(DbUtils.resultSetToTableModel(rs));

							} catch (SQLException e1) {
								e1.printStackTrace();
							}

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});
				btn_confirm_modify.setBounds(461, 110, 117, 23);
				body.add(btn_confirm_modify);
			}
		});
		btn_modify.setBounds(93, 72, 89, 23);
		body.add(btn_modify);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 144, 607, 216);
		body.add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		Connection con=CP.createC();
		ResultSet rs;
		try {
			rs = StudentDao.showFromDB(con);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		
	}
}
