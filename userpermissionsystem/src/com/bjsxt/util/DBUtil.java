package com.bjsxt.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * JDBC的公共类
 * 
 * @author Administrator
 * 
 */
public class DBUtil {

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static  ResultSet  rs=null;
	
	/**
	 * 创建一个连接
	 * @return
	 */
	public static Connection getConnection() {		
		try {
			
		    /*Class.forName("oracle.jdbc.driver.OracleDriver");
			// 获取连接
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "bjsxt", "bjsxt");*/
	 
			
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			
			conn = DriverManager.getConnection("proxool.test");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	/**
	 * 关闭数据库资源
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 执行insert、update、delete 三个DML操作
	 * @param sql
	 * @param prams
	 * @return
	 */
	public static int executeUpdate(String sql, Object[] prams) {
		
		conn = getConnection();
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				pstmt.setObject(i + 1, prams[i]);
			}
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * 执行查询所返回的Resultset对象
	 **/
	
	public static ResultSet executeQuery (String sql, Object[] prams) {
		
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				pstmt.setObject(i + 1, prams[i]);
			}
			
			    rs = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}	
}
