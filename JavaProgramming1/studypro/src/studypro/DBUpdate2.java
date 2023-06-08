package studypro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUpdate2 {
        Connection conn;
        Statement stmt;
        ResultSet rs;

        String number;
        int seatNum;
        int stime;
        int sminute;
        int ssecond;
        int etime;
        int eminute;
        int esecond;
        int twoT;
        int paytime;
                int payprice;
        

        // 전화번호 세팅 메소드
        void setNum(String number) {
                this.number = number;
        }

        // 좌석번호 세팅 메소드
        void setSeatNum(int seatNum) {
                this.seatNum = seatNum;
        }

        // 입실시간 세팅 메소드
        void setTime(int stime) {
                this.stime = stime;
        }
        //입실분 세팅 메소드
        void setMinute(int sminute) {
                this.sminute = sminute;
        }
        //입실 초 세팅 메소드
        void setSecond(int ssecond) {
                        this.ssecond = ssecond;
        }
        
        //퇴실시간 세팅 메소드
        void endTime(int etime) {
                this.etime = etime;
        }
        //퇴실분 세팅 메소드
        void endMinute(int eminute) {
                this.eminute = eminute;
        }
        
        //퇴실초 세팅 메소드
        void endSecond(int esecond) {
                this.esecond = esecond;
        }
        
        //결제 2시간 세팅 메소드
        void twoTime(int twoT) {
                this.twoT = twoT;
        }
        
        //결제 시간 세팅 메소드
        void paytime(int paytime) {
                this.paytime = paytime;
        }
        
        // 결제 금액 세팅 메소드
        void payprice(int payprice) {
                this.payprice = payprice;
        }

                // 드라이버, DB연결 메소드
        void DBConnect() {
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }
                System.out.println("드라이버 완료");
                try {
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                System.out.println("접속 완료");
        }

        // 좌석번호 삽입 메소드
        void sUpdate() {
                DBConnect();

                try {
                        stmt = conn.createStatement();
                        int result = stmt
                                        .executeUpdate("update customer2 set seat ='" + seatNum + "'where number ='" + number + "'");
                        System.out.println(result + "건 입력 성공");
                } catch (SQLException e) {
//         System.out.println("좌석정보 삽입 실패");
                        e.printStackTrace();
                }
                return;
        }

        // 좌석번호 제거 메소드
        void dUpdate() {
                DBConnect();

                try {
                        stmt = conn.createStatement();
                        int result = stmt.executeUpdate("update customer2 set seat =null where number ='" + number + "'");
                        System.out.println(result + "건 입력 성공");
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        // 시작시간 삽입 메소드
        void stimeUpdate() {
                DBConnect();
                try {
                        stmt = conn.createStatement();
                        int result = stmt
                                        .executeUpdate("update customer2 set starttime =" + stime + " where number ='" + number + "'");
                        System.out.println(result + "건 입력 성공");
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        // 시작분 삽입 메소드
        void sminuteUpdate() {
                DBConnect();
                try {
                        stmt = conn.createStatement();
                        int result = stmt
                                        .executeUpdate("update customer2 set startminute =" + sminute + " where number ='" + number + "'");
                        System.out.println(result + "건분 입력 성공");
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        // 시작 초 삽입 메소드
        
        void ssecondUpdate() {
                DBConnect();
            try {
                    stmt = conn.createStatement();
                    int result = stmt
                                    .executeUpdate("update customer2 set startsecond =" + ssecond + " where number ='" + number + "'");
                    System.out.println(result + "건분 입력 성공");
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
        
        // 종료시간 삽입 메소드
        void etimeUpdate() {
                DBConnect();
                try {
                        stmt = conn.createStatement();
                        int result = stmt
                                        .executeUpdate("update customer2 set endtime =" + etime + " where number ='" + number + "'");
                        System.out.println(result + "건 입력 성공");
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        // 종료분 삽입 메소드
        void eminuteUpdate() {
                DBConnect();
                try {
                        stmt = conn.createStatement();
                        int result = stmt
                                        .executeUpdate("update customer2 set endminute =" + eminute + " where number ='" + number + "'");
                        System.out.println(result + "건 입력 성공");
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        //종료초 삽입 메소드
        
        void esecondUpdate() {
                DBConnect();
            try {
                    stmt = conn.createStatement();
                    int result = stmt
                                    .executeUpdate("update customer2 set endsecond =" + esecond + " where number ='" + number + "'");
                    System.out.println(result + "건 입력 성공");
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
        
        

        // 선택된 좌석번호 리턴 메소드
        int SelectSeat() {
                DBConnect();
                try {
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT seat from customer2 where number='" + number + "'");
                        if (rs.next()) {
                                int seatNum = rs.getInt("seat");
                                System.out.println("정보가 1건 존재합니다 좌석번호 :" + seatNum);
                                return seatNum;
                        } else {
                                System.out.println("정보가 존재하지 않습니다.");
                        }

                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                return 0;
        }

        
                //결제한 시간 메소드
                public void paytimeUpdate() {
                        DBConnect();
            try {
                    stmt = conn.createStatement();
                    int result = stmt
                                    .executeUpdate("update customer2 set paytime =" + paytime + " where number ='" + number + "'");
                    System.out.println(result + "건 입력 성공");
            } catch (SQLException e) {
                    e.printStackTrace();
            }
                        
                }
                
            //결제 금액 메소드
                
                public void paypriceUpdate() {
                    DBConnect();
        try {
                stmt = conn.createStatement();
                int result = stmt
                                .executeUpdate("update customer2 set payprice =" + payprice + " where number ='" + number + "'");
                System.out.println(result + "건 입력 성공");
        } catch (SQLException e) {
                e.printStackTrace();
        }
                    
            }

                
                // 시작 시간 + 결제한 시간 메소드
                public void outtimeUpdate() {
                        DBConnect();
            try {        
                            stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT starttime from customer2 where number='" + number + "'");
                        int startTime = 0;
                        if (rs.next()) {
                                startTime = rs.getInt("starttime");
                        }
                        
                    stmt = conn.createStatement();
                    int result = stmt
                                    .executeUpdate("update customer2 set outtime = " + (paytime + startTime) + " where number ='" + number + "'");
                    System.out.println(result + "건 입력 성공");
            } catch (SQLException e) {
                    e.printStackTrace();
            }
                        
                }
                
                // 이름 선택 메소드
             public String selectName() {
                             DBConnect();
                             try {
                                                stmt = conn.createStatement();
                                                rs = stmt.executeQuery("select * from customer2 name where number='" + number + "'");
                                                while(rs.next()) {
                                                        
                                                        return rs.getString("name");
//                                                        rs.getInt("starttime");
//                                                        rs.getInt("startminute");
//                                                        rs.getInt("statsecond");
                                                }
                                        } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                        }
                                        return number;
                    
             }
             
             
             // 시작 시간 선택 메소드
             public int selectStarttime() {
                     DBConnect();
                          try {
                                                stmt = conn.createStatement();
                                                rs = stmt.executeQuery("select starttime, startminute, startsecond from customer2 where number='" + number + "'");
                                                while(rs.next()) {
                                                        
                                                        return rs.getInt("starttime");
                                                        
                                                        

                                                }
                                        } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                                
                                        }
                                return sminute;
                                        
             }
             
             
          // 시작분 선택 메소드
             public int selectStartminute() {
                     DBConnect();
                          try {
                                                stmt = conn.createStatement();
                                                rs = stmt.executeQuery("select starttime, startminute, startsecond from customer2 where number='" + number + "'");
                                                while(rs.next()) {
                                                        
                                                        return rs.getInt("startminute");
                                                        
                                                        

                                                }
                                        } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                                
                                        }
                                return sminute;
                                        
             }
             
             
          // 시작초 선택 메소드
             public int selectStartsecond() {
                     DBConnect();
                          try {
                                                stmt = conn.createStatement();
                                                rs = stmt.executeQuery("select starttime, startminute, startsecond from customer2 where number='" + number + "'");
                                                while(rs.next()) {
                                                        
                                                        return rs.getInt("startsecond");
                                                        
                                                        

                                                }
                                        } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                                
                                        }
                                return sminute;
                                        
             }
             
          // 끝나는 시간 선택 메소드
             public int selectouttime() {
                     DBConnect();
                          try {
                                                stmt = conn.createStatement();
                                                rs = stmt.executeQuery("select outtime from customer2 where number='" + number + "'");
                                                while(rs.next()) {
                                                        
                                                        return rs.getInt("outtime");
                                                        
                                                        

                                                }
                                        } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                                
                                        }
                                return sminute;
                                        
             }
             
             
          // 좌석가격 선택 메소드
             public int selectpayprice() {
                     DBConnect();
                          try {
                                                stmt = conn.createStatement();
                                                rs = stmt.executeQuery("select payprice from customer2 where number='" + number + "'");
                                                while(rs.next()) {
                                                        
                                                        return rs.getInt("payprice");
                                                        
                                                        

                                                }
                                        } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                                
                                        }
                                return payprice;
                                        
             }
             
             
                 
}