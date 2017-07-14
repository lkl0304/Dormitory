package cn.lkangle.biz;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cn.lkangle.dao.MySql;
import cn.lkangle.entity.Rec;

public class RecBiz {
	public static int pageSiz = 6;
	MySql dao = new MySql();
	
	public int addRec(String type, String content){
		int cg       = 0;
		Rec rec      = new Rec();
		String[] arr = new String[3];
		
		rec.setType(type);
		rec.setContent(content);
		rec.setTime();  // 记录时间
		
		String   sql = "insert into record (type, content, time) values (?, ?, ?)";
		if(rec != null)
		{
			arr[0] = rec.getType();
			arr[1] = rec.getContent();
			arr[2] = rec.getTime();
			cg     = dao.execSql(sql, arr);
		}
		return cg;
	}
	
	public int delRec(int id) {
		String   sql = "delete from record where id = ?";
		String[] arr = {String.valueOf(id)};
		return dao.execSql(sql, arr);
	}
	
	public List<Rec> getRec(int pageNo){
		List<Rec> recs = new ArrayList<>();
//		Date start = new Date();
		
		// 106条数据测试时间还快点来。。。
		int num = pageSiz;
		if(pageNo > 0){
			num = pageNo*pageSiz;
		}
		String sql="select * from record ORDER BY id ASC LIMIT " + num; 
		try {
			ResultSet re = dao.getResu(sql);
			for(int i = 1;re.next() && i <= num; i++)
			{
				if(i > num - pageSiz){
					Rec rec = new Rec();
					rec.setId(re.getInt("id"));
					rec.setType(re.getString("type"));
					rec.setContent(re.getString("content"));
					rec.setTime(re.getString("time"));
					recs.add(rec);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		int num = (pageNo - 1)*pageSiz;
//		
//		String sql="select * from record order by id asc limit " + num + "," + pageSiz; 
//
//		try {
//			ResultSet re = dao.getResu(sql);
//			while(re.next()){
//				Rec rec = new Rec();
//				rec.setId(re.getInt("id"));
//				rec.setType(re.getString("type"));
//				rec.setContent(re.getString("content"));
//				rec.setTime(re.getString("time"));
//				recs.add(rec);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Date end = new Date();
//		System.out.println(end.getTime() - start.getTime());
 		return recs;
	}
	
	public int getRows() {
		String sql = "select count(*) as myrows from record";
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
