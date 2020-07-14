package com.zb.pojo;

public class Teacher {
	private int id;
	private String admin;
	private String pwd;
	public Teacher(int id, String admin, String pwd) {
		this.id = id;
		this.admin = admin;
		this.pwd = pwd;
	}
	public Teacher() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
