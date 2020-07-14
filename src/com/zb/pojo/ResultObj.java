package com.zb.pojo;



public class ResultObj {
	
	public ResultObj(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public static final ResultObj  DELETE_SUCCESS =new ResultObj(200,"删除成功");
	public static final ResultObj  DELETE_FALSE =new ResultObj(500,"删除失败");
	public static final ResultObj  UPDATE_SUCCESS =new ResultObj(200,"更新成功");
	public static final ResultObj  UPDATE_FALSE =new ResultObj(500,"更新失败");
	public static final ResultObj  LOGIN_SUCCESS =new ResultObj(200,"登陆成功");
	public static final ResultObj  LOGIN_FALSE =new ResultObj(500,"登陆失败");
	public static final ResultObj  ADD_SUCCESS =new ResultObj(200,"添加成功");
	public static final ResultObj  ADD_FALSE =new ResultObj(500,"添加失败");
	public static final ResultObj  ADD_HOT =new ResultObj(200,"选课成功");
	public static final ResultObj  SELECT_COURSE =new ResultObj(200,"该课程已被选择");
	public static final ResultObj  INSERT_SUCCESS =new ResultObj(200,"录入成功");
	public static final ResultObj  LIUXUE_SUCCESS =new ResultObj(200,"留学成功");
	public static final ResultObj  XIUXUE_SUCCESS =new ResultObj(200,"休学成功");
	public static final ResultObj  INSERT_FALSE =new ResultObj(500,"录入失败");
	public int code;
	public String msg;	
}
