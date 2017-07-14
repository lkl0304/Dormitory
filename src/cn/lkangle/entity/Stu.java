package cn.lkangle.entity;

public class Stu {  
	private int    id    ;
	private long   stuid ;
	private String name  ;
	private String sex   ;
	private String lou   ;
	private int    home  ;
	private long   tel   ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getStuid() {
		return stuid;
	}
	public void setStuid(long stuid) {
		this.stuid = stuid;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLou() {
		return lou;
	}
	public void setLou(String lou) {
		this.lou = lou;
	}
	public int getHome() {
		return home;
	}
	public void setHome(int home) {
		this.home = home;
	}

}
