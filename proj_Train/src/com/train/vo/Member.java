package com.train.vo;

import java.util.Scanner;

public class Member {
	private String mid;
	private String pwd;
	private int mnum;
	private String name;
	private String gender;
	private int age;
	private String birthday;
	private String solar;
	private String phone;
	private String regdate;
	
	

	public Member() {
		this(null,null,0,null,null,0,null,null,null,null);
	}
	
	public Member(String mid, String pwd, int mnum, String name,String gender, int age, String birthday,String solar,String phone,String regdate) {
		this.mid=mid;
		this.pwd=pwd;
		this.mnum=mnum;
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.birthday=birthday;
		this.solar=solar;
		this.phone=phone;
		this.regdate=regdate;
	}

	
	

	

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getSolar() {
		return solar;
	}

	public void setSolar(String solar) {
		this.solar = solar;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void memberView() {
		System.out.println("------------------------");
		System.out.println("아이디 : "+mid);
		System.out.println("비밀번호 : "+pwd);
		System.out.println("이름 : "+name);
		System.out.println("성별 : "+gender);
		System.out.println("나이 : "+age);
		System.out.println("------------------------");
		
	}

	
	
	
}
