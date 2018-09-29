package com.evil.jdbc;

import com.evil.util.Console;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Properties;

/**
 * @author qinhu
 * @date 2018-09-18
 */
public class MysqlJdbcDemo {

    private String url;
    private Properties info=new Properties();

    public MysqlJdbcDemo(String url, String user, String password) {
        this.url = url;
        info.put("user", "root");
        info.put("password", "root");
    }

    public Connection getConnectionByDriverManager() throws SQLException {
        return  DriverManager.getConnection(url,info) ;
    }

    public Connection getConnetionByClassForName() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        return  ((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance()).connect(url,info);
    }

    public Connection getConectionByNew() throws SQLException {
        Driver driver = new Driver();
        return driver.connect(url, info);
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        final String url="jdbc:mysql://192.168.0.102:3306/test?characterEncoding=utf-8";
        final String user="root";
        final String password="root";

        MysqlJdbcDemo demo=new MysqlJdbcDemo(url,user,password);

        Connection connectionByDriverManager = demo.getConnectionByDriverManager();
//        Connection connetionByClassForName = demo.getConnetionByClassForName();
//        Connection conectionByNew = demo.getConectionByNew();

        Statement statement = connectionByDriverManager.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            Console.out(resultSet.getString(2));
        }
    }

}
