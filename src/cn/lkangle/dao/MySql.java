package cn.lkangle.dao;

import java.sql.*;

import cn.lkangle.util.Constant;

public class MySql {
	private Connection        con = null;
	private PreparedStatement pre = null;
	
	public Connection getCon() {
		try {
			Class.forName(Constant.JDBC);
			con = DriverManager.getConnection(Constant.MYSQL, Constant.USER, Constant.PASS);
		} catch (Exception e) {
			System.err.println("连接失败!");
			System.err.println(Constant.MYSQL + "  " + Constant.USER + "  " + Constant.PASS);
			e.printStackTrace();
		}
		return con;
	}
	
	public int execSql(String sql, String[] arr) // 执行数据库 增 删 改操作
	{
		int cg = 0;
		con = getCon();
		if(arr.length > 0 && sql.length() > 0)
		{
			try {
				pre = con.prepareStatement(sql);
				for(int i = 0; i < arr.length; i++){
					pre.setString(i + 1, arr[i]);
				}
				cg = pre.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cg;
	}
	public boolean execSql(String sql) { // 用于查
		boolean cg = false;
		con = getCon();
		try {
			pre = con.prepareStatement(sql);
			ResultSet res = pre.executeQuery();
			if(res.next()){
				cg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cg;
	}
	public ResultSet getResu(String sql) {
		ResultSet resultSet = null;
		con = getCon();
		try {
			pre = con.prepareStatement(sql);
			resultSet = pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
}
