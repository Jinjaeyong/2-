package com.train.vo;

public class TicketReservation {
	private String tnum;
	private String gogo;
	private String finish;
	private String owner;
	private String adult;
	private String child;
	private String old;
	private String day;
	private String hour;
	private String minute;
	private String basicseat;
	private String specialseat;
	private String paynum;
	
	public TicketReservation(){
		this(null,null,null,null,null,null,null,null,null,null,null,null,null);
	}
	public TicketReservation(String tnum,String gogo,String finish,String owner,String adult,String child,String old,String day,String hour,String minute,String basicseat,String specialseat,String paynum){
		this.tnum=tnum;
		this.gogo=gogo;
		this.finish=finish;
		this.owner=owner;
		this.adult=adult;
		this.child=child;
		this.old=old;
		this.day=day;
		this.hour=hour;
		this.minute=minute;
		this.basicseat=basicseat;
		this.specialseat=specialseat;
		this.paynum=paynum;
	}
	public String getTnum() {
		return tnum;
	}
	public void setTnum(String tnum) {
		this.tnum = tnum;
	}
	public String getGogo() {
		return gogo;
	}
	public void setGogo(String gogo) {
		this.gogo = gogo;
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getMinute() {
		return minute;
	}
	public void setMinute(String minute) {
		this.minute = minute;
	}
	public String getBasicseat() {
		return basicseat;
	}
	public void setBasicseat(String basicseat) {
		this.basicseat = basicseat;
	}
	public String getSpecialseat() {
		return specialseat;
	}
	public void setSpecialseat(String specialseat) {
		this.specialseat = specialseat;
	}
	public String getPaynum() {
		return paynum;
	}
	public void setPaynum(String paynum) {
		this.paynum = paynum;
	}

	
	
}
