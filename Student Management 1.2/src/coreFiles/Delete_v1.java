package coreFiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Delete_v1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_search;
	private JTextField tf_roll;
	private JTextField tf_name;
	private JTextField tf_address;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_v1 frame = new Delete_v1();
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
	public Delete_v1() {
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

		
		JRadioButton RadioBtn_name = new JRadioButton("Name");
		buttonGroup.add(RadioBtn_name);
		RadioBtn_name.setBounds(168, 7, 72, 23);
		body.add(RadioBtn_name);
		
		JRadioButton RadioBtn_roll = new JRadioButton("Roll No.");
		buttonGroup.add(RadioBtn_roll);
		RadioBtn_roll.setBounds(279, 7, 89, 23);
		body.add(RadioBtn_roll);
		
		tf_search = new JTextField();
		tf_search.setBounds(168, 50, 181, 20);
		body.add(tf_search);
		tf_search.setColumns(10);
		String s=tf_search.getText();
		int x=Integer.parseInt(s);
				
		JButton btn_delete = new JButton("search");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=CP.createC();

				String q="delete from students where sid=?";
				/*if(RadioBtn_name.isSelected() ) {
					q="select * from students where sname=?";
				}
				else if(RadioBtn_roll.isSelected()) {
					q="select * from students where sid=?";
				}*/
				ResultSet rs=null;
				try {

					PreparedStatement pstmt=con.prepareStatement(q);
					pstmt.setInt(1, x);
					rs =pstmt.executeQuery();
					System.out.println(rs.getString(1));
					
					tf_roll.setText(rs.getString(1));
					tf_name.setText(rs.getString(2));
					tf_address.setText(rs.getString(3));

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_delete.setBounds(260, 97, 89, 23);
		body.add(btn_delete);
		
		tf_roll = new JTextField();
		tf_roll.setBounds(42, 237, 160, 20);
		body.add(tf_roll);
		tf_roll.setColumns(10);
		
		tf_name = new JTextField();
		tf_name.setColumns(10);
		tf_name.setBounds(228, 237, 160, 20);
		body.add(tf_name);
		
		tf_address = new JTextField();
		tf_address.setColumns(10);
		tf_address.setBounds(411, 237, 160, 20);
		body.add(tf_address);
		
		JButton btn_delete_confirm = new JButton("Delete");
		btn_delete_confirm.setBounds(260, 282, 89, 23);
		body.add(btn_delete_confirm);
		
		JLabel lbl_delete_confirm = new JLabel("Confirmation ");
		lbl_delete_confirm.setBounds(279, 212, 64, 14);
		body.add(lbl_delete_confirm);
	}
}
