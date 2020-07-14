package com.zb.pojo;

public class Compulsory {
	private int id;
	private int cno;
	private String cname;
	private int cnnumber;
	private String teacher;
	private String create_time;
	private String major;
	public Compulsory(int id, int cno, String cname, int cnnumber, String teacher, String create_time, String major) {
		super();
		this.id = id;
		this.cno = cno;
		this.cname = cname;
		this.cnnumber = cnnumber;
		this.teacher = teacher;
		this.create_time = create_time;
		this.major = major;
	}
	public Compulsory() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCnnumber() {
		return cnnumber;
	}
	public void setCnnumber(int cnnumber) {
		this.cnnumber = cnnumber;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
}
