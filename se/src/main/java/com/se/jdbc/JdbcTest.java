package com.se.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

    @Test
    public void demo1() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://120.78.164.205:3306/hzero_platform?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user="hzero";
        String password="hzero";

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

}
