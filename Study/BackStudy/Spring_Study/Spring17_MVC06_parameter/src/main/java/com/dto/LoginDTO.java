package com.dto;

public class LoginDTO {

	// 변수명과 사용자 데이터 name값이 일치해야함
	String userid;
	String passwd;

	public LoginDTO() {
	}

	public LoginDTO(String userid, String passwd) {
		this.userid = userid;
		this.passwd = passwd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "LoginDTO [userid=" + userid + ", passwd=" + passwd + "]";
	}

}
