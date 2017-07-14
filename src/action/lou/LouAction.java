package action.lou;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import cn.lkangle.biz.RecBiz;
import cn.lkangle.biz.lou.LouBiz;
import cn.lkangle.biz.lou.impl.LouBizImpl;
import cn.lkangle.biz.student.StuBiz;
import cn.lkangle.entity.Lou;

public class LouAction implements Action{
	@SuppressWarnings("unchecked")
	private Map<String , Object> request  = (Map<String, Object>)ActionContext.getContext().get("request");
	private HttpServletResponse  response = ServletActionContext.getResponse();
	LouBiz lBiz = new LouBizImpl();
	RecBiz rBiz = new RecBiz();
	
	Lou lou = new Lou();
	private String lname;
	private String linfo;
	private int    lid;
	private int    pageNo;
	private int    xg;
	
	public String getLinfo() {
		return linfo;
	}
	public void setLinfo(String linfo) {
		this.linfo = linfo;
	}
	public int getXg() {
		return xg;
	}
	public void setXg(int xg) {
		this.xg = xg;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public Lou getLou() {
		return lou;
	}
	public void setLou(Lou lou) {
		this.lou = lou;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String addlou()
	{
		if(lBiz.addLou(lou) > 0)
		{
			request.put("add", "success");
			rBiz.addRec("楼层添加", "楼层：" + lou.getName() + " 被添加");
		} else {
			request.put("add", "error");
		}
		getlous();
		return "addlou";
	}
	
	public String dellou()
	{
		if(lBiz.delLou(lid) > 0){
			request.put("del", "success");
			rBiz.addRec("楼层删除", "楼层：" + lname + " 被删除");
		}else {
			request.put("del", "error");
		}
		getlous();
		return "dellou";
	}
	
	public String update()
	{
		lou.setId(lid);
		lou.setName(lname);
		lou.setInfo(linfo);
		if(lBiz.xgLou(lou, lid) > 0){
			request.put("update", "success");
			rBiz.addRec("修改楼层信息", "楼层：" + lou.getName() + " 信息被修改");
		} else {
			request.put("update", "error");
		}
		getlous();
		return "update";
	}
	public String search()
	{
		List<Lou> list = lBiz.getLou(lname);
		request.put("loulist", list);
		
		if(xg == 1){  // 用于修改的查询
			return "xginfo";
		} else {
			if(list.size() > 0){
				request.put("lrows", 1);
			} else {
				request.put("lrows", 0);
			}
			request.put("lpageNo", 1);
			request.put("lpages", 1);
			return "search";
		}
	}
	
	public String getlous()
	{
		int size  = StuBiz.pageSiz;
		int rows  = lBiz.getRows();
		int pages = 0; // 页数
		if(rows%size > 0){
			pages = rows/size + 1;
		}else{
			pages = rows/size;
		}
		if(pageNo > pages){
			pageNo = pages;
		}
		if(pageNo <= 1){
			pageNo = 1;
		}
		List<Lou> list = lBiz.getLous(pageNo);
		request.put("loulist", list);
		request.put("lrows", rows);
		request.put("lpageNo", pageNo);
		request.put("lpages", pages==0?1:pages);
		if(pages < 1){
			request.put("ldisabled", "disabled"); // 用于禁用分页按钮
		}
		return SUCCESS;
	}
	public void yzlou() throws IOException
	{
		if(lBiz.getLou(lname).size() > 0)
		{
			PrintWriter w = response.getWriter();
			w.println("chunzai");
			w.close();
		}
	}
}