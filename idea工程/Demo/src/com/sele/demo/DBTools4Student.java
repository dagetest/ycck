package com.sele.demo;

import java.sql.*;


public class DBTools4Student {
    private static String userId = null;
    private static String stuId = null ;

    private static String delUserSql = "delete from users where mobile = ? ";

    private static String delUserGroupSql = "delete from  users_groups where user_id = ? ";

    private static String delStuSql = "delete from students where user_id = ? ";

    private static String delPCAppointmentSql = "delete from  pc_appointment where stu_id = ? ";

    private static String delStuWeaksSql = "delete from  student_weaks  where stu_id = ?";

    private static String delCouponsSql = "delete from coupons where user_id = ? ";

    public static void main(String[] args) {
        String mobile = "15000697603" ;
        DBTools4Student.allowDuplicateRegiste(mobile);
    }

    public static void allowDuplicateRegiste(String mobile){
        Connection conn = getConnection();
        try {
            getId(conn,mobile);
            clearRegisteData(conn,mobile);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static Connection getConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://121.40.83.12:3306/ts?"
                + "user=forge&password=zhangmen1dui1&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        }
        System.out.println("成功加载MySQL驱动程序");
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    private static void getId(Connection conn,String mobile) throws Exception{
        String queryUserSql = null ;
        String queryStuSql = null ;
        Statement stmt = null;
        ResultSet userRs = null;
        ResultSet stuRs = null;
        stmt = conn.createStatement();

        queryUserSql = "select * from users where mobile = '"+mobile+"' ";
        userRs = stmt.executeQuery(queryUserSql);
        while (userRs.next()) {
            userId = userRs.getString("id");
            System.out.println("userID:"+userId );
        }

        queryStuSql = "select * from students where user_id = '"+userId+"'";
        stuRs = stmt.executeQuery(queryStuSql);
        while (stuRs.next()) {
            stuId = stuRs.getString("id");
            System.out.println("stuId:"+stuId );
        }

    }
    private static void clearRegisteData(Connection conn,String mobile)  throws Exception {
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement pps = null;
        if(userId != null  && stuId != null && mobile !=null){
            delData(conn,pps,mobile,delUserSql);
            delData(conn,pps,userId,delUserGroupSql);
            delData(conn,pps,userId,delStuSql);
            delData(conn,pps,stuId,delPCAppointmentSql);
            delData(conn,pps,stuId,delStuWeaksSql);
            delData(conn,pps,userId,delCouponsSql);
        }
        if(pps != null){
            pps.close();
        }
        conn.commit();

    }
    private static void delData(Connection conn,PreparedStatement pps,String param,String sql) throws Exception{
        pps = conn.prepareStatement(sql);
        pps.setString(1,param);
        pps.executeUpdate();
    }
}