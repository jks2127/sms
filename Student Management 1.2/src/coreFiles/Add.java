package coreFiles;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import coreFiles.CP;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private static JTextField tf_name;
	private static JTextField tf_phone;
	private static JTextField tf_address;
	private static JTextField tf_roll;
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
	public Add() {
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
		
		JLabel lbl_header_title = new JLabel("Student Management System");
		lbl_header_title.setForeground(new Color(255, 255, 224));
		lbl_header_title.setFont(new Font("Yu Gothic Light", Font.BOLD, 24));
		lbl_header_title.setBounds(66, 11, 441, 37);
		lbl_header_title.setIcon(new ImageIcon("D:\\Videos\\Learn\\Ionic\\UI Components - Ionic Documentation_files\\component-button-icon.png"));
		header.add(lbl_header_title);
		
		JButton btn_back = new JButton("<-");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Options().setVisible(true);
				dispose();
			}
		});
		btn_back.setBounds(10, 11, 46, 32);
		header.add(btn_back);
		
		JPanel body = new JPanel();
		body.setBounds(10, 76, 607, 360);
		contentPane.add(body);
		body.setLayout(null);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setBounds(88, 102, 84, 19);
		body.add(lbl_name);
		
		JLabel lbl_phone = new JLabel("Phone");
		lbl_phone.setBounds(88, 140, 84, 19);
		body.add(lbl_phone);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setBounds(88, 175, 84, 19);
		body.add(lbl_address);
		
		tf_name = new JTextField();
		tf_name.setColumns(10);
		tf_name.setBounds(182, 101, 189, 20);
		body.add(tf_name);
		
		tf_phone = new JTextField();
		tf_phone.setColumns(10);
		tf_phone.setBounds(182, 139, 189, 20);
		body.add(tf_phone);
		
		tf_address = new JTextField();
		tf_address.setColumns(10);
		tf_address.setBounds(182, 174, 189, 59);
		body.add(tf_address);
		
		Connection con=CP.createC();
		JButton btn_submit = new JButton("Submit");
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean f=StudentDao.InsertStudentToDB(con);
				if(f) {
					JOptionPane.showMessageDialog(btn_submit, "Info added successfully...");
				}
			}
		});
		btn_submit.setBounds(282, 264, 89, 23);
		body.add(btn_submit);
		
		tf_roll = new JTextField();
		tf_roll.setColumns(10);
		tf_roll.setBounds(182, 65, 189, 20);
		body.add(tf_roll);
		
		JLabel lbl_roll = new JLabel("Roll No.");
		lbl_roll.setBounds(88, 68, 84, 19);
		body.add(lbl_roll);
		
	}

	public static JTextField getTextField_r() {
		return tf_roll;
	}
	public static JTextField getTextField() {
		return tf_name;
	}

	public static JTextComponent getTextField_1() {
		return tf_phone;
	}

	public static JTextComponent getTextField_2() {
		return tf_address;
	}
}
