package cn.lkangle.biz.lou;

import java.util.List;

import cn.lkangle.entity.Lou;

public interface LouBiz {
	public int pageSiz = 6;
	public int addLou(Lou lou);
	public int delLou(int id);
	public int  xgLou(Lou lou, int id);
	public List<Lou> getLous(int pageNo);
	public List<Lou> getLou(String name);
	public int getRows();
}
