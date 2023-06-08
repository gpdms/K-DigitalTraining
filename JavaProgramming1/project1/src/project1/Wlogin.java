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

import project2.Customer;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class Wlogin extends JFrame {
        Customer customer;
        private JFrame frame;
        private JTextField textField;
        private JPasswordField passwordField;
        private JTextField textField_1;
        private JTextField textField_2;
        private JTextField textField_3;
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

                JLabel lblNewLabel = new JLabel("아이디 :");
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
                lblNewLabel_5.setBounds(43, 140, 284, 119);
                panel1.add(lblNewLabel_5);
                
                Calendar t = Calendar.getInstance();
                int hour = t.get(Calendar.HOUR);
                int min = t.get(Calendar.MINUTE);
                int sec = t.get(Calendar.SECOND);
                one= (+hour+"시 "+min+"분 "+sec+"초 ");
                lblNewLabel_5.setText(one);
                repaint();
                
                

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
                panel3.setVisible(false);
                
                JPanel panel4 = new JPanel();
                panel4.setBounds(0, 0, 1184, 811);
                frame.getContentPane().add(panel4);
                panel4.setLayout(null);
                panel4.setVisible(false);
                
                JButton btnNewButton_4_1_8 = new JButton("7번");
                btnNewButton_4_1_8.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8.setBounds(191, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8);
                
                
                JButton btnNewButton_4_1_8_1 = new JButton("8번");
                btnNewButton_4_1_8_1.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_1.setBounds(272, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8_1);
                
                JButton btnNewButton_4_1_8_2 = new JButton("9번");
                btnNewButton_4_1_8_2.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_2.setBounds(352, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8_2);
                
                JButton btnNewButton_4_1_8_3 = new JButton("10번");
                btnNewButton_4_1_8_3.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_3.setBounds(433, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8_3);
                
                JButton btnNewButton_4_1_8_4 = new JButton("11번");
                btnNewButton_4_1_8_4.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_4.setBounds(514, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8_4);
                
                JButton btnNewButton_4_1_8_5 = new JButton("12번");
                btnNewButton_4_1_8_5.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_5.setBounds(594, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8_5);
                
                JButton btnNewButton_4_1_8_6 = new JButton("13번");
                btnNewButton_4_1_8_6.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_6.setBounds(673, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8_6);
                
                JButton btnNewButton_4_1_8_7 = new JButton("14번");
                btnNewButton_4_1_8_7.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_7.setBounds(749, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8_7);
                
                JButton btnNewButton_4_1_8_8 = new JButton("15번");
                btnNewButton_4_1_8_8.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_8.setBounds(830, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8_8);
                
                JButton btnNewButton_4_1_8_9 = new JButton("16번");
                btnNewButton_4_1_8_9.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_9.setBounds(912, 124, 80, 80);
                panel4.add(btnNewButton_4_1_8_9);
                
                JButton btnNewButton_4_1_8_10 = new JButton("6번");
                btnNewButton_4_1_8_10.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_10.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_10.setBounds(110, 214, 80, 80);
                panel4.add(btnNewButton_4_1_8_10);
                
                JButton btnNewButton_4_1_8_11 = new JButton("5번");
                btnNewButton_4_1_8_11.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_11.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_11.setBounds(110, 298, 80, 80);
                panel4.add(btnNewButton_4_1_8_11);
                
                JButton btnNewButton_4_1_8_12 = new JButton("4번");
                btnNewButton_4_1_8_12.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_12.setBounds(110, 382, 80, 80);
                panel4.add(btnNewButton_4_1_8_12);
                
                JButton btnNewButton_4_1_8_13 = new JButton("3번");
                btnNewButton_4_1_8_13.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_13.setBounds(110, 469, 80, 80);
                panel4.add(btnNewButton_4_1_8_13);
                
                JButton btnNewButton_4_1_8_14 = new JButton("2번");
                btnNewButton_4_1_8_14.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_14.setBounds(110, 553, 80, 80);
                panel4.add(btnNewButton_4_1_8_14);
                
                JButton btnNewButton_4_1_8_15 = new JButton("1번");
                btnNewButton_4_1_8_15.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_15.setBounds(110, 638, 80, 80);
                panel4.add(btnNewButton_4_1_8_15);
                
                JButton btnNewButton_4_1_8_16 = new JButton("23번");
                btnNewButton_4_1_8_16.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_16.setBounds(352, 382, 80, 80);
                panel4.add(btnNewButton_4_1_8_16);
                
                JButton btnNewButton_4_1_8_17 = new JButton("26번");
                btnNewButton_4_1_8_17.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_17.setBounds(433, 382, 80, 80);
                panel4.add(btnNewButton_4_1_8_17);
                
                JButton btnNewButton_4_1_8_18 = new JButton("24번");
                btnNewButton_4_1_8_18.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_18.setBounds(352, 469, 80, 80);
                panel4.add(btnNewButton_4_1_8_18);
                
                JButton btnNewButton_4_1_8_19 = new JButton("27번");
                btnNewButton_4_1_8_19.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_19.setBounds(433, 469, 80, 80);
                panel4.add(btnNewButton_4_1_8_19);
                
                JButton btnNewButton_4_1_8_20 = new JButton("25번");
                btnNewButton_4_1_8_20.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_20.setBounds(352, 553, 80, 80);
                panel4.add(btnNewButton_4_1_8_20);
                
                JButton btnNewButton_4_1_8_21 = new JButton("28번");
                btnNewButton_4_1_8_21.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_21.setBounds(433, 553, 80, 80);
                panel4.add(btnNewButton_4_1_8_21);
                
                JButton btnNewButton_4_1_8_22 = new JButton("29번");
                btnNewButton_4_1_8_22.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_22.setBounds(673, 382, 80, 80);
                panel4.add(btnNewButton_4_1_8_22);
                
                JButton btnNewButton_4_1_8_23 = new JButton("32번");
                btnNewButton_4_1_8_23.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_23.setBounds(749, 382, 80, 80);
                panel4.add(btnNewButton_4_1_8_23);
                
                JButton btnNewButton_4_1_8_24 = new JButton("30번");
                btnNewButton_4_1_8_24.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_24.setBounds(673, 469, 80, 80);
                panel4.add(btnNewButton_4_1_8_24);
                
                JButton btnNewButton_4_1_8_25 = new JButton("33번");
                btnNewButton_4_1_8_25.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_25.setBounds(749, 469, 80, 80);
                panel4.add(btnNewButton_4_1_8_25);
                
                JButton btnNewButton_4_1_8_26 = new JButton("31번");
                btnNewButton_4_1_8_26.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_26.setBounds(673, 553, 80, 80);
                panel4.add(btnNewButton_4_1_8_26);
                
                JButton btnNewButton_4_1_8_27 = new JButton("34번");
                btnNewButton_4_1_8_27.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_27.setBounds(749, 553, 80, 80);
                panel4.add(btnNewButton_4_1_8_27);
                
                JButton btnNewButton_4_1_8_28 = new JButton("17번");
                btnNewButton_4_1_8_28.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_28.setBounds(999, 214, 80, 80);
                panel4.add(btnNewButton_4_1_8_28);
                
                JButton btnNewButton_4_1_8_29 = new JButton("18번");
                btnNewButton_4_1_8_29.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_29.setBounds(999, 298, 80, 80);
                panel4.add(btnNewButton_4_1_8_29);
                
                JButton btnNewButton_4_1_8_30 = new JButton("19번");
                btnNewButton_4_1_8_30.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_30.setBounds(999, 382, 80, 80);
                panel4.add(btnNewButton_4_1_8_30);
                
                JButton btnNewButton_4_1_8_31 = new JButton("20번");
                btnNewButton_4_1_8_31.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_31.setBounds(999, 469, 80, 80);
                panel4.add(btnNewButton_4_1_8_31);
                
                JButton btnNewButton_4_1_8_32 = new JButton("21번");
                btnNewButton_4_1_8_32.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_32.setBounds(999, 553, 80, 80);
                panel4.add(btnNewButton_4_1_8_32);
                
                JButton btnNewButton_4_1_8_33 = new JButton("22번");
                btnNewButton_4_1_8_33.setFont(new Font("HY견고딕", Font.PLAIN, 20));
                btnNewButton_4_1_8_33.setBounds(999, 638, 80, 80);
                panel4.add(btnNewButton_4_1_8_33);

                JPanel panel5 = new JPanel();
                panel5.setBounds(0, 0, 1184, 811);
                frame.getContentPane().add(panel5);
                panel5.setLayout(null);
                panel5.setVisible(false);

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
                                                        if (customer.logincheck(uid, upass)) {
                                                                System.out.println("로그인 성공");
                                                                JOptionPane.showMessageDialog(null, "로그인에 성공했습니다");
                                                                panel4.setVisible(true);
                                                                panel1.setVisible(false);
                                                        } else {
                                                                System.out.println("로그인 실패 > 정보 불일치");
                                                                JOptionPane.showMessageDialog(null, "로그인에 실패했습니다");
                                                        }
                                                } catch (HeadlessException e1) {
                                                        // TODO Auto-generated catch block
                                                        e1.printStackTrace();
                                                } catch (SQLException e1) {
                                                        // TODO Auto-generated catch block
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
                                    if (unumber.equals("") || upass.equals("") || uname.equals("") ) {
                                            JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
                                            System.out.println("회원가입 실패 > 회원정보 미입력");
                                    }

                                    else if ( upass != null && uname != null && unumber != null) {
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
        }
}