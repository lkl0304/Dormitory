package cn.lkangle.dao;

import java.sql.*;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MySql {
	private static DataSource ds  = null;
	private Connection        con = null;
	private PreparedStatement pre = null;
	
	// �������ӳ�  c3p0
	static {
		ComboPooledDataSource cps = new ComboPooledDataSource("dorm");
		ds = cps;
	}
	// �������ӳ� dbcp
//	static {
//		Properties pps = new Properties();
//		InputStream in = new MySql().getClass().getClassLoader().getResourceAsStream("dbcp-config.properties");
//		try {
//			pps.load(in);
//			MySql.ds = BasicDataSourceFactory.createDataSource(pps);
//		} catch (Exception e) {
//			System.err.println("�����ļ�����ʧ�ܣ�");
//			e.printStackTrace();
//		}
//	}
	public Connection getCon()
	{
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	// ��ͨ���� û�йر�
//	public Connection getCon(){
//		String url  = "jdbc:mysql://localhost:3306/dorm?characterEncoding=gbk";
//		String user = "root";
//		String pass = "root";
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			return DriverManager.getConnection(url, user, pass);
//		} catch (Exception e) {
//			System.err.println("���ݿ�����ʧ�ܣ�");
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public int execSql(String sql, String[] arr) // ִ�����ݿ� �� ɾ �Ĳ���
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
	public boolean execSql(String sql) { // ���ڲ�
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
