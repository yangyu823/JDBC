package com.mycompany.app;

import java.sql.*;

import jdk.internal.dynalink.beans.StaticClass;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] argv) {

        System.out.println("---- MySQL JDBC Connection Testing ----");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not been Registered!");
            e.printStackTrace();
            return;
        }
        System.out.println("CentOS MySQL database connected!");

        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/testdb","ora", "password");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from shop");
            System.out.println();
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3));
            conn.close();


        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        }







    }
}