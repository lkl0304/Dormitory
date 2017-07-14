package action.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import action.RecAction;
import action.lou.LouAction;
import action.student.StuAction;
import cn.lkangle.biz.RecBiz;
import cn.lkangle.biz.admin.AdminBiz;
import cn.lkangle.biz.admin.impl.AdminBizImpl;
import cn.lkangle.util.CookieUtil;

public class AdminAction implements Action {
	private static String AD_COOKIE = "admin.cookie";
	StuAction stuaction = new StuAction(); 
	RecAction rAction   = new RecAction();
	LouAction lAction   = new LouAction();
	RecBiz    rBiz      = new RecBiz();
	AdminBiz aBiz       = new AdminBizImpl();
	CookieUtil cUtil    = new CookieUtil();
	
	private HttpServletRequest  request  = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private Map<String, Object> session  = (Map<String, Object>)ActionContext.getContext().getSession();

	
	private String oldpass ;
	private String newpass ;
	private String username; 
	private String password;
	private String mima    ;
	
	public String getOldpass() {
		return oldpass;
	}
	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}
	public String getNewpass() {
		return newpass;
	}
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		String cookie = cUtil.getCookie(request, AD_COOKIE);
		if(cookie != null)
		{
			String[] split = cookie.split(",");
			if(aBiz.login(split[0], split[1])){
				request.setAttribute("aname", split[0]);
				request.setAttribute("apass", split[1]);
			}
		}
		return SUCCESS;
	}

	public String admin() {
		String name = (String) session.get("aName");
		String pass = (String) session.get("aPass");
		if(pass != null){
			if(aBiz.login(name, pass)){
				stuaction.getstus();
				rAction.getrecs();
				lAction.getlous();
				return SUCCESS;
			}
		}
		request.setAttribute("login", ERROR);  // login.jsp中跳转
		return ERROR;
	}
	
	public String login() {
		if(aBiz.login(username, password)) {
			session.put("aName", username);
			session.put("aPass", password);
//			rBiz.addRec("管理员登录", "");
			if (mima != null && mima.length() > 3) {
				cUtil.setCookie(response, AD_COOKIE, username + "," + password);
			} else { // 清除cookie
				cUtil.delcookie(request, response, AD_COOKIE);
			}
			
			request.setAttribute("login", SUCCESS);
			return SUCCESS;
		}
		request.setAttribute("err", ERROR); // 登录失败提示
		return ERROR;
	}
	public String logout() {
		session.remove("aName");
		session.remove("aPass");
		request.setAttribute("login", ERROR); // login.jsp中跳转
		return "logout";
	}
	public String change()
	{
		if(aBiz.change(oldpass, newpass)){
			request.setAttribute("change", "success");
		}else {
			request.setAttribute("change", "error");
		}
		rBiz.addRec("管理员修改密码", "原: " + oldpass + " 新: " + newpass);
		return SUCCESS;
	}
}
