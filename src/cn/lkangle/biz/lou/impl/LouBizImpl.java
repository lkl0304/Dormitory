package cn.lkangle.biz.lou.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cn.lkangle.biz.lou.LouBiz;
import cn.lkangle.dao.MySql;
import cn.lkangle.entity.Lou;

public class LouBizImpl implements LouBiz{
	MySql dao = new MySql();

	@Override
	public int addLou(Lou lou) {
		int cg = 0;
		String[] arr = new String[2];
		String   sql = "insert into lou (name, info) values (?, ?)";
		if(lou != null)
		{
			arr[0] = lou.getName();
			arr[1] = lou.getInfo();
			cg = dao.execSql(sql, arr);
		}
		return cg;
	}

	@Override
	public int delLou(int id) {
		String[] arr = {String.valueOf(id)};
		String sql = "delete from lou where id = ?";
		return dao.execSql(sql, arr);
	}

	@Override
	public int xgLou(Lou lou, int id) {
		int cg = 0;
		String[] arr = new String[3];
		String   sql = "update lou set name = ?, info = ? where id = ?";
		if(lou != null)
		{
			arr[0] = lou.getName();
			arr[1] = lou.getInfo();
			arr[2] = String.valueOf(id);
			cg = dao.execSql(sql, arr);
		}
		return cg;
	}

	@Override
	public List<Lou> getLou(String name) {
		List<Lou> list = new ArrayList<>();
		String sql = "select * from lou where name = '" + name + "'";
		if(name != null)
		{
			try {
				ResultSet rs = dao.getResu(sql);
				if(rs.next())
				{
					Lou lou = new Lou();
					lou.setId(rs.getInt("id"));
					lou.setName(rs.getString("name"));
					lou.setInfo(rs.getString("info"));
					list.add(lou);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Lou> getLous(int pageNo) {
		List<Lou> list = new ArrayList<>();

		int num = (pageNo - 1)*pageSiz;
		
		String sql="select * from lou order by id asc limit " + num + "," + pageSiz; 
		try {
			ResultSet rs = dao.getResu(sql);
			while(rs.next()){		
				Lou lou = new Lou();
				lou.setId(rs.getInt("id"));
				lou.setName(rs.getString("name"));
				lou.setInfo(rs.getString("info"));
				list.add(lou);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getRows() {
		String sql = "select count(*) as myrows from lou";
		int rows = 0;
		try {
			ResultSet rs = dao.getResu(sql);
			if(rs.next()){ 
				rows = rs.getInt("myrows");
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return rows;
	}
}
