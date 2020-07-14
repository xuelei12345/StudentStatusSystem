package com.zb.pojo;

public class Student {
	private int id;
	private String sname;
	private int sclass;
	private int sno;
	private int sage;
	private String create_time;
	private int deleted;
	private String spwd;
	private String major;
	public Student(int id, String sname, int sclass, int sno, int sage, String create_time, int deleted, String spwd,
			String major) {
		this.id = id;
		this.sname = sname;
		this.sclass = sclass;
		this.sno = sno;
		this.sage = sage;
		this.create_time = create_time;
		this.deleted = deleted;
		this.spwd = spwd;
		this.major = major;
	}
	public Student() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSclass() {
		return sclass;
	}
	public void setSclass(int sclass) {
		this.sclass = sclass;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
	
}
