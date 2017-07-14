package cn.lkangle.biz.student;

import java.util.List;

import cn.lkangle.entity.Stu;

public interface StuBiz {
	public int pageSiz = 6;// 每页显示6条数据
	public int addStu(Stu stu);
	public int delStu(int id);
	public int  xgStu(Stu stu, int id);
	public List<Stu> getStus(int pageNo);
//	public List<Stu> getStu(int id);
	public List<Stu> getStu(String name);
	public int getRows();
}
