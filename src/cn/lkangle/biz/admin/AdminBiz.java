package cn.lkangle.biz.admin;

public interface AdminBiz {
	public boolean login(String name, String pass);
	public boolean change(String oPass, String nPass);
}
