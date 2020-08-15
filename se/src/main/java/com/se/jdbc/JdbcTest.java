package com.se.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

    @Test
    public void demo1() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://49.233.146.217:3306/mysql?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user="root";
        String password="bd3cf1rzh.";

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

}
