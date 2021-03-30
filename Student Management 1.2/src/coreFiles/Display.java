package coreFiles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Display extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Display() {
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
			
		Connection con=CP.createC();
		ResultSet rs = null;
		try {
			rs = StudentDao.showFromDB(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 587, 338);
		body.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.setBackground(Color.WHITE);
		
		
	}
}
