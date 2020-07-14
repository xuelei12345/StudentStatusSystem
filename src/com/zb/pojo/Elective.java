package com.zb.pojo;

public class Elective {
	private int id;
	private int cno;
	private String cname;
	private int cnumber;
	private String teacher;
	private String create_time;
	private String major;
	public Elective(int id, int cno, String cname, int cnumber, String teacher, String create_time, String major) {
		super();
		this.id = id;
		this.cno = cno;
		this.cname = cname;
		this.cnumber = cnumber;
		this.teacher = teacher;
		this.create_time = create_time;
		this.major = major;
	}
	public Elective() {
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
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
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
