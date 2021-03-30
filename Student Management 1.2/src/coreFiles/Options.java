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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Options extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame = new Options();
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
	public Options() {
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
	
		JButton btn_add_student = new JButton("Add Student Info");
		btn_add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Add().setVisible(true);
			dispose();
			}
		});
		btn_add_student.setBounds(171, 101, 240, 23);
		body.add(btn_add_student);
		
		JButton btn_display_student = new JButton("Display Student Info");
		btn_display_student.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Display().setVisible(true);
				dispose();
			}
		});
		btn_display_student.setBounds(171, 140, 240, 23);
		body.add(btn_display_student);
		
		JButton btn_delete_student = new JButton("Delete student info");
		btn_delete_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Delete().setVisible(true);
				dispose();
			}
		});
		btn_delete_student.setBounds(171, 180, 240, 23);
		body.add(btn_delete_student);
		
		JButton btn_edit_student = new JButton("Modify Student Info");
		btn_edit_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Modify().setVisible(true);
				dispose();
			}
		});
		btn_edit_student.setBounds(171, 220, 240, 23);
		body.add(btn_edit_student);
		
		}

}
