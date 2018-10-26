package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	
	public static Connection getConnection() throws Exception {
		Connection conn=null;
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf8", "root", "java0000");
        return conn;
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs!=null) {
            try {rs.close();} catch(Exception e){e.printStackTrace();}
        }
        if(stmt!=null) {
            try {stmt.close();} catch(Exception e){e.printStackTrace();}
        }
        if(conn!=null) {
            try {conn.close();} catch(Exception e){e.printStackTrace();}
        }
	}
	
}
