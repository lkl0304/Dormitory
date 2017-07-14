 package action.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import cn.lkangle.biz.RecBiz;
import cn.lkangle.biz.student.StuBiz;
import cn.lkangle.biz.student.impl.StuBizImpl;
import cn.lkangle.entity.Stu;

public class StuAction implements Action {
	@SuppressWarnings("unchecked")
	private Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	private HttpServletResponse response = ServletActionContext.getResponse();
	StuBiz sBiz = new StuBizImpl();
	
	RecBiz rBiz = new RecBiz();  // �����¼���õ���
	
	private int    sid;  // ��¼Ҫ���»���ɾ����ѧ��id
	private String sname;
	private int    xg;    // ����search�����ж����޸Ļ�������
	private int    pageNo = 1;
	private Stu    stu;

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String addstu(){
		if(sBiz.addStu(stu) > 0){
			request.put("add", "success");
			rBiz.addRec("���ѧ��", "ѧ����" + stu.getName() + " �����");
		} else {
			request.put("add", "error");
		}
		getstus();
		return "addstu";
	}
	public String delstu()
	{
		if(sBiz.delStu(sid) > 0){
			request.put("del", "success");
			rBiz.addRec("ɾ��ѧ��", "ѧ����" + sname + " ��ɾ��");
		}else {
			request.put("del", "error");
		}
		getstus();
		return "delstu";
	}
	public String getstus()
	{
		int size  = StuBiz.pageSiz;
		int rows  = sBiz.getRows();
		int pages = 0; // ҳ��
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
		List<Stu> list = sBiz.getStus(pageNo);
		request.put("stulist", list);
		request.put("rows", rows);
		request.put("pageNo", pageNo);
		request.put("pages", pages==0?1:pages);
		if(pages < 1){
			request.put("disabled", "disabled"); // ���ڽ��÷�ҳ��ť
		}
		return SUCCESS;
	}
	public String search()
	{
		List<Stu> list = sBiz.getStu(sname);
		request.put("stulist", list);
		if(xg == 1){  // �����޸ĵĲ�ѯ
			return "xginfo";
		} else {
			if(list.size() > 0){
				request.put("rows", 1);
			} else {
				request.put("rows", 0);
			}
			request.put("pageNo", 1);
			request.put("pages", 1);
			return "search";
		}
	}
	public void update() throws IOException
	{
		if(sBiz.xgStu(stu, sid) > 0){
//			request.put("update", "success");
			PrintWriter w = response.getWriter();
			w.println("update success");
			w.close();
			
			rBiz.addRec("�޸�ѧ����Ϣ", "ѧ����" + stu.getName() + " ��Ϣ���޸�");
		} else {
			request.put("update", "error");
		}
//		getstus();
//		return "update";
	}
	public void yzstu() throws IOException // û��ʹ��
	{
		if(sBiz.getStu(sname).size() > 0)
		{
			PrintWriter w = response.getWriter();
			w.println("chunzai");
			w.close();
		}
	}
}
