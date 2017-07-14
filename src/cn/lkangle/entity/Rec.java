package cn.lkangle.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Rec {
	private int    id;
	private String type;
	private String content;
	private String time;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setTime() {
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd hh.mm.ss a");
		this.time = sFormat.format(date);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
