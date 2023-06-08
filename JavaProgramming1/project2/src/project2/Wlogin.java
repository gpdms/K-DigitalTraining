package project2;

import java.awt.Color;

import java.awt.EventQueue;

import java.awt.Font;

import java.awt.HeadlessException;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.SQLException;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.time.Instant;

import java.time.ZoneId;

import java.time.ZonedDateTime;

import java.util.Calendar;

import java.util.Date;


import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JPasswordField;

import javax.swing.JTextField;

import javax.swing.SwingConstants;

import javax.swing.Timer;

import javax.swing.JComboBox;


public class Wlogin extends JFrame {

	protected static final int YES_NO_OPTION = 0;

	protected static final int NO = 0;

	protected static final int YES = 0;

	protected static final int YES_OPTION = 0;

	protected static final int NO_OPTION = 0;

	Customer customer;
	SeatUpdate seatUpdate = new SeatUpdate();

	private JFrame frame;

	private JTextField textField;

	private JPasswordField passwordField;

	private JTextField textField_1;

	private JTextField textField_2;

	private JPasswordField passwordField_1;

	private String one;

	private String two;

	private JTextField textField_4;

	private JTextField textField_5;

	private Thread t1;


	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Wlogin window = new Wlogin();

					window.frame.setVisible(true);

					

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}


	/**

	 * Create the application.

	 *

	 * @param opt

	 */

	public Wlogin() {

		initialize();


	}


	/**

	 * Initialize the contents of the frame.

	 */


	private void initialize() {

		customer = new Customer();

		frame = new JFrame();

		frame.setBounds(100, 100, 1200, 850);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		frame.setResizable(false);

		frame.setLocationRelativeTo(null);


		JPanel panel1 = new JPanel();

		panel1.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel1);

		panel1.setLayout(null);


		JLabel lblNewLabel_3 = new JLabel("스터디 카페 키오스크");

		lblNewLabel_3.setBounds(481, 248, 265, 68);

		lblNewLabel_3.setForeground(new Color(0, 128, 255));

		lblNewLabel_3.setFont(new Font("HY견고딕", Font.PLAIN, 24));

		panel1.add(lblNewLabel_3);


		JLabel lblNewLabel = new JLabel("전화번호 :");

		lblNewLabel.setBounds(487, 382, 117, 39);

		lblNewLabel.setForeground(new Color(0, 128, 255));

		lblNewLabel.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);

		panel1.add(lblNewLabel);


		JLabel lblNewLabel_1 = new JLabel("비밀번호 :");

		lblNewLabel_1.setBounds(487, 473, 117, 39);

		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);

		lblNewLabel_1.setForeground(new Color(0, 128, 255));

		lblNewLabel_1.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		panel1.add(lblNewLabel_1);


		textField = new JTextField();

		textField.setBounds(647, 384, 139, 25);

		panel1.add(textField);

		textField.setColumns(10);


		passwordField = new JPasswordField();

		passwordField.setBounds(647, 475, 139, 25);

		panel1.add(passwordField);


		JButton btnNewButton = new JButton("로그인");

		btnNewButton.setBounds(453, 579, 139, 39);


		btnNewButton.setBackground(new Color(0, 128, 255));

		btnNewButton.setForeground(new Color(255, 255, 255));

		btnNewButton.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		panel1.add(btnNewButton);


		JButton btnNewButton_1 = new JButton("초기화");

		btnNewButton_1.setBounds(683, 579, 139, 39);


		btnNewButton_1.setBackground(new Color(0, 128, 255));

		btnNewButton_1.setForeground(new Color(255, 255, 255));

		btnNewButton_1.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		panel1.add(btnNewButton_1);


		JButton btnNewButton_2 = new JButton("회원가입");

		btnNewButton_2.setBounds(910, 693, 176, 52);

		btnNewButton_2.setBackground(new Color(0, 128, 255));

		btnNewButton_2.setForeground(new Color(255, 255, 255));

		btnNewButton_2.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		panel1.add(btnNewButton_2);


		JPanel panel = new JPanel();

		panel.setBounds(0, 0, 1155, 59);

		panel.setBackground(new Color(0, 128, 255));

		panel1.add(panel);


		JPanel panel_1 = new JPanel();

		panel_1.setBounds(0, 58, 1155, 31);

		panel_1.setBackground(new Color(192, 192, 192));

		panel1.add(panel_1);


		JLabel lblNewLabel_5 = new JLabel("New label");

		lblNewLabel_5.setFont(new Font("HY견고딕", Font.PLAIN, 30));

		lblNewLabel_5.setBounds(849, 110, 284, 119);

		panel1.add(lblNewLabel_5);

		ActionListener actionListener = new ActionListener() {


			@Override

			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub

				Date date = new Date();

				DateFormat timeFormat = new SimpleDateFormat("HH시 mm분 ss초");

				String time = timeFormat.format(date);

				lblNewLabel_5.setText(time);

			}

			

		};

		Timer timer = new Timer(1000, actionListener);

		timer.setInitialDelay(0);

		timer.start();

		

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


		JLabel lblNewLabel_4 = new JLabel("전화번호 :");

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


		textField_1 = new JTextField();

		textField_1.setBounds(327, 174, 186, 31);

		panel2.add(textField_1);

		textField_1.setColumns(10);


		textField_2 = new JTextField();

		textField_2.setColumns(10);

		textField_2.setBounds(327, 325, 186, 31);

		panel2.add(textField_2);


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

				

				JButton btnNewButton_4 = new JButton("입실");

				btnNewButton_4.setForeground(new Color(255, 255, 255));

				btnNewButton_4.setBackground(new Color(0, 128, 255));

				btnNewButton_4.setFont(new Font("HY견고딕", Font.PLAIN, 30));

				btnNewButton_4.setBounds(342, 159, 236, 225);

				panel3.add(btnNewButton_4);

				

				JButton btnNewButton_4_1 = new JButton("퇴실");

				btnNewButton_4_1.setForeground(new Color(255, 255, 255));

				btnNewButton_4_1.setBackground(new Color(0, 128, 255));

				btnNewButton_4_1.setFont(new Font("HY견고딕", Font.PLAIN, 30));

				btnNewButton_4_1.setBounds(638, 159, 236, 225);

				panel3.add(btnNewButton_4_1);

				

				JButton btnNewButton_4_2 = new JButton("이용권 정보");

				btnNewButton_4_2.setForeground(new Color(255, 255, 255));

				btnNewButton_4_2.setBackground(new Color(0, 128, 255));

				btnNewButton_4_2.setFont(new Font("HY견고딕", Font.PLAIN, 30));

				btnNewButton_4_2.setBounds(342, 428, 236, 225);

				panel3.add(btnNewButton_4_2);

				

				JButton btnNewButton_4_3 = new JButton("관리자 페이지");

				btnNewButton_4_3.setForeground(new Color(255, 255, 255));

				btnNewButton_4_3.setBackground(new Color(0, 128, 255));

				btnNewButton_4_3.setFont(new Font("HY견고딕", Font.PLAIN, 30));

				btnNewButton_4_3.setBounds(638, 428, 236, 225);

				panel3.add(btnNewButton_4_3);

				

				JLabel lblNewLabel_6 = new JLabel("New label");

				lblNewLabel_6.setFont(new Font("HY견고딕", Font.PLAIN, 30));

				lblNewLabel_6.setBounds(500, 25, 428, 110);

				panel3.add(lblNewLabel_6);

				panel3.setVisible(false);

				

				

				

				

				// seatBtn3.addActionListener(new ActionListener() {

				// public void actionPerformed(ActionEvent e) {

				// int answer = JOptionPane.showConfirmDialog(null, "이 좌석을 선택하시겠습니까?", "확인창", YES_NO_OPTION);

				// if (answer == JOptionPane.YES_OPTION) {

				// panel4.setVisible(false);

				// panel5.setVisible(true);

				// seatBtn3.setBackground(Color.red);

				// } else if (answer == JOptionPane.NO_OPTION) {

				// panel4.setVisible(true);

				// panel5.setVisible(false);

				// }

				// }

				// });

				// seatBtn4.addActionListener(new ActionListener() {

				// public void actionPerformed(ActionEvent e) {

				// panel4.setVisible(false);

				// panel5.setVisible(true);

				// }

				// });

						

						


		JPanel panel4 = new JPanel();

		panel4.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel4);

		panel4.setLayout(null);

		panel4.setVisible(false);


		// 좌석

		JButton seatBtn1 = new JButton("1");

		seatBtn1.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn1.setBounds(110, 638, 80, 80);

		panel4.add(seatBtn1);


		JButton seatBtn2 = new JButton("2");

		seatBtn2.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn2.setBounds(110, 553, 80, 80);

		panel4.add(seatBtn2);


		JButton seatBtn3 = new JButton("3");

		seatBtn3.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn3.setBounds(110, 469, 80, 80);

		panel4.add(seatBtn3);


		JButton seatBtn4 = new JButton("4");

		seatBtn4.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn4.setBounds(110, 382, 80, 80);

		panel4.add(seatBtn4);


		JButton seatBtn5 = new JButton("5");

		seatBtn5.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn5.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn5.setBounds(110, 298, 80, 80);

		panel4.add(seatBtn5);


		JButton seatBtn6 = new JButton("6");

		seatBtn6.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn6.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn6.setBounds(110, 214, 80, 80);

		panel4.add(seatBtn6);


		JButton seatBtn7 = new JButton("7");

		seatBtn7.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn7.setBounds(191, 124, 80, 80);

		panel4.add(seatBtn7);


		JButton seatBtn8 = new JButton("8");

		seatBtn8.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn8.setBounds(272, 124, 80, 80);

		panel4.add(seatBtn8);


		JButton seatBtn9 = new JButton("9");

		seatBtn9.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn9.setBounds(352, 124, 80, 80);

		panel4.add(seatBtn9);


		JButton seatBtn10 = new JButton("10");

		seatBtn10.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn10.setBounds(433, 124, 80, 80);

		panel4.add(seatBtn10);


		JButton seatBtn11 = new JButton("11");

		seatBtn11.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn11.setBounds(514, 124, 80, 80);

		panel4.add(seatBtn11);


		JButton seatBtn12 = new JButton("12");

		seatBtn12.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn12.setBounds(594, 124, 80, 80);

		panel4.add(seatBtn12);


		JButton seatBtn13 = new JButton("13");

		seatBtn13.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn13.setBounds(673, 124, 80, 80);

		panel4.add(seatBtn13);


		JButton seatBtn14 = new JButton("14");

		seatBtn14.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn14.setBounds(749, 124, 80, 80);

		panel4.add(seatBtn14);


		JButton seatBtn15 = new JButton("15");

		seatBtn15.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn15.setBounds(830, 124, 80, 80);

		panel4.add(seatBtn15);


		JButton seatBtn16 = new JButton("16");

		seatBtn16.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn16.setBounds(912, 124, 80, 80);

		panel4.add(seatBtn16);


		JButton seatBtn17 = new JButton("17");

		seatBtn17.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn17.setBounds(999, 214, 80, 80);

		panel4.add(seatBtn17);


		JButton seatBtn18 = new JButton("18");

		seatBtn18.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn18.setBounds(999, 298, 80, 80);

		panel4.add(seatBtn18);


		JButton seatBtn19 = new JButton("19");

		seatBtn19.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn19.setBounds(999, 382, 80, 80);

		panel4.add(seatBtn19);


		JButton seatBtn20 = new JButton("20");

		seatBtn20.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn20.setBounds(999, 469, 80, 80);

		panel4.add(seatBtn20);


		JButton seatBtn21 = new JButton("21");

		seatBtn21.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn21.setBounds(999, 553, 80, 80);

		panel4.add(seatBtn21);


		JButton seatBtn22 = new JButton("22");

		seatBtn22.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn22.setBounds(999, 638, 80, 80);

		panel4.add(seatBtn22);


		JButton seatBtn23 = new JButton("23");

		seatBtn23.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn23.setBounds(352, 382, 80, 80);

		panel4.add(seatBtn23);


		JButton seatBtn24 = new JButton("24");

		seatBtn24.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn24.setBounds(352, 469, 80, 80);

		panel4.add(seatBtn24);


		JButton seatBtn25 = new JButton("25");

		seatBtn25.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn25.setBounds(352, 553, 80, 80);

		panel4.add(seatBtn25);


		JButton seatBtn26 = new JButton("26");

		seatBtn26.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn26.setBounds(433, 382, 80, 80);

		panel4.add(seatBtn26);


		JButton seatBtn27 = new JButton("27");

		seatBtn27.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn27.setBounds(433, 469, 80, 80);

		panel4.add(seatBtn27);


		JButton seatBtn28 = new JButton("28");

		seatBtn28.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn28.setBounds(433, 553, 80, 80);

		panel4.add(seatBtn28);


		JButton seatBtn29 = new JButton("29");

		seatBtn29.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn29.setBounds(673, 382, 80, 80);

		panel4.add(seatBtn29);


		JButton seatBtn30 = new JButton("30");

		seatBtn30.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn30.setBounds(673, 469, 80, 80);

		panel4.add(seatBtn30);


		JButton seatBtn31 = new JButton("31");

		seatBtn31.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn31.setBounds(673, 553, 80, 80);

		panel4.add(seatBtn31);


		JButton seatBtn32 = new JButton("32");

		seatBtn32.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn32.setBounds(749, 382, 80, 80);

		panel4.add(seatBtn32);


		JButton seatBtn33 = new JButton("33");

		seatBtn33.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn33.setBounds(749, 469, 80, 80);

		panel4.add(seatBtn33);


		JButton seatBtn34 = new JButton("34");

		seatBtn34.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		seatBtn34.setBounds(749, 553, 80, 80);

		panel4.add(seatBtn34);


		JPanel panel5 = new JPanel();

		panel5.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel5);

		panel5.setLayout(null);

		panel5.setVisible(false);


		JLabel price_1 = new JLabel("시간권");

		price_1.setForeground(new Color(0, 128, 255));

		price_1.setFont(new Font("HY견고딕", Font.PLAIN, 30));

		price_1.setBounds(140, 150, 107, 68);

		panel5.add(price_1);


		JButton priceBtn1 = new JButton("1시간 2000원");

		priceBtn1.setBackground(new Color(0, 128, 255));

		priceBtn1.setBounds(140, 264, 200, 125);

		priceBtn1.setForeground(new Color(255, 255, 255));

		priceBtn1.setFont(new Font("HY견고딕", Font.PLAIN, 20));


		panel5.add(priceBtn1);


		JLabel price_2 = new JLabel("기간권");

		price_2.setForeground(new Color(0, 128, 255));

		price_2.setFont(new Font("HY견고딕", Font.PLAIN, 30));

		price_2.setBounds(860, 150, 107, 68);

		panel5.add(price_2);


		JButton priceBtn2 = new JButton("2시간 4000원");

		priceBtn2.setForeground(Color.WHITE);

		priceBtn2.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		priceBtn2.setBackground(new Color(0, 128, 255));

		priceBtn2.setBounds(140, 446, 200, 125);

		panel5.add(priceBtn2);


		JButton priceBtn3 = new JButton("4시간 7000원");

		priceBtn3.setForeground(Color.WHITE);

		priceBtn3.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		priceBtn3.setBackground(new Color(0, 128, 255));

		priceBtn3.setBounds(140, 621, 200, 125);

		panel5.add(priceBtn3);


		JButton priceBtn4 = new JButton("6시간 10000원");

		priceBtn4.setForeground(Color.WHITE);

		priceBtn4.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		priceBtn4.setBackground(new Color(0, 128, 255));

		priceBtn4.setBounds(472, 264, 200, 125);

		panel5.add(priceBtn4);


		JButton priceBtn5 = new JButton("8시간 13000원");

		priceBtn5.setForeground(Color.WHITE);

		priceBtn5.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		priceBtn5.setBackground(new Color(0, 128, 255));

		priceBtn5.setBounds(472, 446, 200, 125);

		panel5.add(priceBtn5);


		JButton priceBtn6 = new JButton("10시간 15000원");

		priceBtn6.setForeground(Color.WHITE);

		priceBtn6.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		priceBtn6.setBackground(new Color(0, 128, 255));

		priceBtn6.setBounds(472, 621, 200, 125);

		panel5.add(priceBtn6);


		JButton priceBtn7 = new JButton("1주일 50000원");

		priceBtn7.setForeground(Color.WHITE);

		priceBtn7.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		priceBtn7.setBackground(new Color(0, 128, 255));

		priceBtn7.setBounds(860, 264, 200, 125);

		panel5.add(priceBtn7);


		JButton priceBtn8 = new JButton("2주일 85000원");

		priceBtn8.setForeground(Color.WHITE);

		priceBtn8.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		priceBtn8.setBackground(new Color(0, 128, 255));

		priceBtn8.setBounds(860, 446, 200, 125);

		panel5.add(priceBtn8);


		JButton priceBtn9 = new JButton("4주일 140000원");

		priceBtn9.setForeground(Color.WHITE);

		priceBtn9.setFont(new Font("HY견고딕", Font.PLAIN, 20));

		priceBtn9.setBackground(new Color(0, 128, 255));

		priceBtn9.setBounds(860, 621, 200, 125);

		panel5.add(priceBtn9);


		frame.setVisible(true);


		JPanel panel6 = new JPanel();

		panel6.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel6);

		panel6.setLayout(null);

		panel6.setVisible(false);


		JPanel panel7 = new JPanel();

		panel7.setBounds(0, 0, 1184, 811);

		frame.getContentPane().add(panel7);

		panel7.setVisible(false);

		panel7.setLayout(null);

		
		//이벤트 처리

		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				panel1.setVisible(false);

				panel2.setVisible(true);

			}

		});


		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				textField.setText("");

				passwordField.setText("");

			}

		});

		

		btnNewButton.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {


				String uid = textField.getText();

				String upass = "";

				for (int i = 0; i < passwordField.getPassword().length; i++) {

					upass = upass + passwordField.getPassword()[i];

				}


				if (btnNewButton.getText().equals("로그인")) {

					if (uid.equals("") || upass.equals("")) {

						JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 모두 입력해주세요", "로그인 실패",

								JOptionPane.ERROR_MESSAGE);

						System.out.println("로그인 실패 > 로그인 정보 미입력");

					}


					else if (uid != null && upass != null) {

						try {

							if (customer.logincheck(uid, upass) != null) {

								System.out.println("로그인 성공");

								JOptionPane.showMessageDialog(null, "로그인에 성공했습니다");

								panel3.setVisible(true);

								panel1.setVisible(false);

								lblNewLabel_6.setText(customer.logincheck(uid, upass)+"님 환영합니다!");
								
								seatUpdate.setNum(uid);
								

							} else {

								System.out.println("로그인 실패 > 정보 불일치");

								JOptionPane.showMessageDialog(null, "로그인에 실패했습니다");

							}

						} catch (HeadlessException e1) {


							e1.printStackTrace();

						} catch (SQLException e1) {


							e1.printStackTrace();

						}

					}

				}

			}

		});


		btnNewButton_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String unumber = textField_1.getText();

				String upass = passwordField_1.getText();

				String uname = textField_2.getText();

				if (unumber.equals("") || upass.equals("") || uname.equals("")) {

					JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "회원가입 실패", JOptionPane.ERROR_MESSAGE);

					System.out.println("회원가입 실패 > 회원정보 미입력");

				}


				else if (upass != null && uname != null && unumber != null) {

					if (customer.joinCheck(unumber, upass, uname)) {

						System.out.println("회원가입 성공");

						JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다");

						dispose();

					} else {

						System.out.println("회원가입 실패");

						JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다");

					}

				}


				panel1.setVisible(true);

				panel2.setVisible(false);

			}

		});


		btnNewButton_3_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "아이디 생성에 실패하셨습니다");

				panel1.setVisible(true);

				panel2.setVisible(false);

			}

		});

				
		//좌석선택 이벤트
		JButton[] seatBtn = { seatBtn1, seatBtn2, seatBtn3, seatBtn4, seatBtn5, seatBtn6, seatBtn7, seatBtn8, seatBtn9,

				seatBtn10, seatBtn11, seatBtn12, seatBtn13, seatBtn14, seatBtn15, seatBtn16, seatBtn17, seatBtn18,

				seatBtn19, seatBtn20, seatBtn21, seatBtn22, seatBtn23, seatBtn24, seatBtn25, seatBtn26, seatBtn27,

				seatBtn28, seatBtn29, seatBtn30, seatBtn31, seatBtn32, seatBtn33, seatBtn34 };

		for (JButton seatBtnn : seatBtn) {

			seatBtnn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					int answer = JOptionPane.showConfirmDialog(null, "이 좌석을 선택하시겠습니까?", "확인창", YES_NO_OPTION);

					if (answer == JOptionPane.YES_OPTION) {

						System.out.println("-----------");

						System.out.println("-----------");

						panel4.setVisible(false);

						panel5.setVisible(true);

						seatBtnn.setBackground(Color.red);
						seatBtnn.setEnabled(false); //버튼 비활성화
						seatUpdate.setSeatNum(seatBtnn.getText());
						seatUpdate.sUpdate();
						

						

					} else if (answer == JOptionPane.NO_OPTION) {

						panel4.setVisible(true);

						panel5.setVisible(false);

					}

				}

			});

			

			

		}

		priceBtn6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				panel5.setVisible(false);

				panel4.setVisible(true);

			}

		});

		

		btnNewButton_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				panel4.setVisible(true);

				panel3.setVisible(false);

			}

		});


	}

}
