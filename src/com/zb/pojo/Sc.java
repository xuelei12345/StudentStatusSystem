package com.zb.pojo;

public class Sc {
	private Integer id;
	private int sno;
	private int cno;
	private int grade;
	private String create_time;
	private String cname;
	private String teacher;
	
	private String sname;
	private String sclass;

	
	public Sc(int id, int sno, int cno, int grade, String create_time, String cname, String teacher, String sname,
			String sclass) {
		super();
		this.id = id;
		this.sno = sno;
		this.cno = cno;
		this.grade = grade;
		this.create_time = create_time;
		this.cname = cname;
		this.teacher = teacher;
		this.sname = sname;
		this.sclass = sclass;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public Sc() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
