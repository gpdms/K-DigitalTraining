package project1;

import java.awt.EventQueue;


import javax.swing.JFrame;

import javax.swing.JButton;

import java.awt.BorderLayout;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import javax.swing.JPasswordField;

import javax.swing.JLabel;

import java.awt.Font;

import java.awt.HeadlessException;

import java.awt.Color;

import javax.swing.JTree;

import javax.swing.tree.DefaultTreeModel;

import javax.swing.tree.DefaultMutableTreeNode;

import javax.swing.JToolBar;

import javax.swing.JTabbedPane;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;

import javax.swing.JOptionPane;

import javax.swing.JMenu;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.sql.SQLException;


import javax.swing.JPanel;

import javax.swing.SwingConstants;


public class SeatEx extends JFrame{

	private JFrame frame;

	private JTextField textField;

	private JPasswordField passwordField;

	private JTextField textField_1;

	private JTextField textField_2;

	private JTextField textField_3;

	private JPasswordField passwordField_1;


	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					SeatEx window = new SeatEx();

					window.frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}


	/**

	 * Create the application.

	 * @param opt

	 */

	public SeatEx() {

		initialize();

		

	}

	

	/**

	 * Initialize the contents of the frame.

	 */

	private void initialize() {

		frame = new JFrame();

		frame.setBounds(100, 100, 1200, 850);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		frame.setResizable(false);



		

		

		JPanel panel1 = new JPanel();

		panel1.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel1);

		panel1.setLayout(null);

		

		JLabel lblNewLabel_3 = new JLabel("좌석 선택");

		lblNewLabel_3.setForeground(new Color(0, 128, 255));

		lblNewLabel_3.setFont(new Font("HY견고딕", Font.PLAIN, 24));

		lblNewLabel_3.setBounds(481, 248, 50, 50);

		panel1.add(lblNewLabel_3);

		

		
		JButton btnNewButton = new JButton("로그인");

		btnNewButton.setBackground(new Color(0, 128, 255));

		btnNewButton.setBounds(453, 579, 139, 39);

		btnNewButton.setForeground(new Color(255, 255, 255));

		btnNewButton.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		panel1.add(btnNewButton);

		

		

		JPanel panel = new JPanel();

		panel.setBackground(new Color(0, 128, 255));

		panel.setBounds(0, 0, 1155, 59);

		panel1.add(panel);

		

		JPanel panel_1 = new JPanel();

		panel_1.setBackground(new Color(192, 192, 192));

		panel_1.setBounds(0, 58, 1155, 31);

		panel1.add(panel_1);

		

		

		JPanel panel2 = new JPanel();

		panel2.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel2);

		panel2.setVisible(false);

		panel2.setLayout(null);

		

		

		JLabel lblNewLabel_2 = new JLabel("회원 가입");

		lblNewLabel_2.setForeground(new Color(0, 128, 255));

		lblNewLabel_2.setFont(new Font("HY견고딕", Font.PLAIN, 27));

		lblNewLabel_2.setBounds(340, 48, 164, 84);

		panel2.add(lblNewLabel_2);

		

		JLabel lblNewLabel_4 = new JLabel("아이디 :");

		lblNewLabel_4.setForeground(new Color(0, 128, 255));

		lblNewLabel_4.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		lblNewLabel_4.setBounds(193, 174, 141, 36);

		panel2.add(lblNewLabel_4);

		

		JLabel lblNewLabel_4_1 = new JLabel("비밀번호 :");

		lblNewLabel_4_1.setForeground(new Color(0, 128, 255));

		lblNewLabel_4_1.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		lblNewLabel_4_1.setBounds(193, 250, 141, 36);

		panel2.add(lblNewLabel_4_1);

		

		JLabel lblNewLabel_4_2 = new JLabel("이름 :");

		lblNewLabel_4_2.setForeground(new Color(0, 128, 255));

		lblNewLabel_4_2.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		lblNewLabel_4_2.setBounds(193, 325, 141, 36);

		panel2.add(lblNewLabel_4_2);

		

		JLabel lblNewLabel_4_3 = new JLabel("전화번호 :");

		lblNewLabel_4_3.setForeground(new Color(0, 128, 255));

		lblNewLabel_4_3.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		lblNewLabel_4_3.setBounds(193, 400, 141, 36);

		panel2.add(lblNewLabel_4_3);

		

		textField_1 = new JTextField();

		textField_1.setBounds(327, 174, 186, 31);

		panel2.add(textField_1);

		textField_1.setColumns(10);

		

		textField_2 = new JTextField();

		textField_2.setColumns(10);

		textField_2.setBounds(327, 325, 186, 31);

		panel2.add(textField_2);

		

		textField_3 = new JTextField();

		textField_3.setColumns(10);

		textField_3.setBounds(327, 400, 186, 31);

		panel2.add(textField_3);

		

		passwordField_1 = new JPasswordField();

		passwordField_1.setBounds(327, 250, 186, 31);

		panel2.add(passwordField_1);

		

		JButton btnNewButton_3 = new JButton("생성");

		btnNewButton_3.setBackground(new Color(0, 128, 255));

		btnNewButton_3.setForeground(new Color(255, 255, 255));

		btnNewButton_3.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		btnNewButton_3.setBounds(192, 496, 151, 58);

		panel2.add(btnNewButton_3);

		

		JButton btnNewButton_3_1 = new JButton("취소");

		btnNewButton_3_1.setBackground(new Color(0, 128, 255));

		btnNewButton_3_1.setForeground(new Color(255, 255, 255));

		btnNewButton_3_1.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		btnNewButton_3_1.setBounds(378, 496, 151, 58);

		panel2.add(btnNewButton_3_1);

		

		

		

		JPanel panel3 = new JPanel();

		panel3.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel3);

		panel3.setLayout(null);

		

		JPanel panel4 = new JPanel();

		panel4.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel4);

		panel4.setLayout(null);

		

		JPanel panel5 = new JPanel();

		panel5.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel5);

		panel5.setLayout(null);

		

		JPanel panel6 = new JPanel();

		panel6.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel6);

		panel6.setLayout(null);

		

		JPanel panel7 = new JPanel();

		panel7.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel7);

	}

}




