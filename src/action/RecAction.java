package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import cn.lkangle.biz.RecBiz;
import cn.lkangle.entity.Rec;

public class RecAction implements Action{
	@SuppressWarnings("unchecked")
	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	RecBiz rBiz = new RecBiz();
	
	private String ip;
	private int    rid;
	private int    pageNo = 1;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String delrec()
	{
		if(rBiz.delRec(rid) > 0)
		{
			request.put("rdel", "success");
		} else {
			request.put("rdel", "error");
		}
		getrecs();
		return "delrec";
	}
	public String getrecs()
	{
		int size  = RecBiz.pageSiz;
		int rows  = rBiz.getRows();
		int pages = 0;
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
		List<Rec> list = rBiz.getRec(pageNo);
		request.put("reclist", list);
		request.put("rrows", rows);
		request.put("rpageNo", pageNo);
		request.put("rpages", pages==0?1:pages);
		if(pages < 1){
			request.put("rdisabled", "disabled"); // 用于禁用分页按钮
		}
		return SUCCESS;
	}
	public void jlip()
	{
		rBiz.addRec("登陆信息", "登录地址： " + ip);
	}
}
