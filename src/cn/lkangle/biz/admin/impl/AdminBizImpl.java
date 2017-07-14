package cn.lkangle.biz.admin.impl;

import java.sql.*;

import cn.lkangle.biz.admin.AdminBiz;
import cn.lkangle.dao.MySql;

public class AdminBizImpl implements AdminBiz{
	MySql dao = new MySql(); 
	@Override
	public boolean login(String name, String pass) {
		if(name.length() < 1  || pass.length() < 1)	{
			return false;
		}
		String sql = "select * from admin where name = '" + name + "' and pass = '" + pass + "'";
		return dao.execSql(sql);
	}
	
	@Override
	public boolean change(String oPass, String nPass) {
		boolean    cg   = false;
		Connection con  = dao.getCon();
		String[]   np   = {nPass};
		String     sql1 = "select * from admin where name = 'admin'";
		String     sql2 = "update admin set pass = ? where name = 'admin'";
		try {
			PreparedStatement pre = con.prepareStatement(sql1);
			ResultSet         res = pre.executeQuery();
			if(res.next()){
				String p = res.getString("pass");
				if(!oPass.equals(p)){
					return cg;
				}
				
				if(dao.execSql(sql2, np) > 0){
					cg = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cg;
	}
}
