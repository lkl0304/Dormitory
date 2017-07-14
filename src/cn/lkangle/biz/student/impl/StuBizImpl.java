package cn.lkangle.biz.student.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.lkangle.biz.student.StuBiz;
import cn.lkangle.dao.MySql;
import cn.lkangle.entity.Stu;

public class StuBizImpl implements StuBiz{
	
	MySql dao = new MySql();
	@Override
	public int addStu(Stu stu) {
		int cg = 0;
		String[] arr = new String[6];
		String   sql = "insert into student (stuid, name, sex, lou, home, tel) values (?, ?, ?, ?, ?, ?)";
		if(stu != null){
			arr[0] = String.valueOf(stu.getStuid());
			arr[1] = stu.getName();
			arr[2] = stu.getSex();
			arr[3] = stu.getLou();
			arr[4] = String.valueOf(stu.getHome());
			arr[5] = String.valueOf(stu.getTel());
			
			cg = dao.execSql(sql, arr);
		}
		return cg;
	}

	@Override
	public int delStu(int id) {
		String[] arr = {String.valueOf(id)};
		String sql = "delete from student where id = ?";
		return dao.execSql(sql, arr);
	}

	@Override
	public int xgStu(Stu stu, int id) {
		int cg = 0;
		String[] arr = new String[7];
		String   sql = "update student set stuid = ?, name = ?, sex = ?, lou = ?, home = ?, tel = ? where id = ?"; 
		if(stu != null)
		{
			arr[0] = String.valueOf(stu.getStuid());
			arr[1] = stu.getName();
			arr[2] = stu.getSex();
			arr[3] = stu.getLou();
			arr[4] = String.valueOf(stu.getHome());
			arr[5] = String.valueOf(stu.getTel());
			arr[6] = String.valueOf(id);
			
			cg = dao.execSql(sql, arr);
		}
		return cg;
	}

	@Override
	public List<Stu> getStus(int pageNo) {
		List<Stu> list = new ArrayList<>();
		
		int num =  (pageNo - 1)*pageSiz;
		
		String sql="select * from student order by id asc limit " + num + "," + pageSiz; 
		try {
			ResultSet rs = dao.getResu(sql);
			while(rs.next()){
				Stu stu = new Stu();
				stu.setId(rs.getInt("id"));
				stu.setStuid(rs.getLong("stuid"));
				stu.setName(rs.getString("name"));	
				stu.setSex(rs.getString("sex"));
				stu.setLou(rs.getString("lou"));
				stu.setHome(rs.getInt("home"));
				stu.setTel(rs.getLong("tel"));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getRows() {
		String sql = "select count(*) as myrows from student";
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
	
	@Override
	public List<Stu> getStu(String name) {
		List<Stu> stus = new ArrayList<>();
		String sql = "select * from student where name = '" + name + "'";
		if(name != null)
		{
			try {
				ResultSet rs = dao.getResu(sql);
				if (rs.next()) {
					Stu stu = new Stu();
					stu.setId(rs.getInt("id"));
					stu.setStuid(rs.getLong("stuid"));
					stu.setName(rs.getString("name"));
					stu.setSex(rs.getString("sex"));
					stu.setLou(rs.getString("lou"));
					stu.setHome(rs.getInt("home"));
					stu.setTel(rs.getLong("tel"));
					stus.add(stu);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stus;
	}
	

}
