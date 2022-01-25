package coreFiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

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
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField tf_search;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
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
	public Delete() {
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
						
		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				if(RadioBtn_roll.isSelected()) {
					int x=Integer.parseInt(tf_search.getText());
					StudentDao.deleteFromDB(x);
				}else if(RadioBtn_name.isSelected()) {
					String x=tf_search.getText();
					StudentDao.deleteFromDB(x);
					JOptionPane.showMessageDialog(tf_search, "Student info deleted successfully");
				}
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 144, 607, 216);
				body.add(scrollPane);
				
				table = new JTable();
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
		});
		btn_delete.setBounds(260, 97, 89, 23);
		body.add(btn_delete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 144, 607, 216);
		body.add(scrollPane);
		
		table = new JTable();
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
