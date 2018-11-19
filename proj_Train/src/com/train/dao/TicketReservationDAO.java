package com.train.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.train.vo.TicketReservation;

public class TicketReservationDAO {

	String url="jdbc:oracle:thin:@211.238.142.96:1521:orcl";
	String user="MYTRAIN";
	String pwd="111111";
	
	public Connection getConn() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 정보가 잘못되었습니다. 다시 확인하세요.");
			e.printStackTrace();
		}
		return con;
	}
	
	/*public int insertTR(TicketReservation tr){
		Connection con=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO TICKETRESERVATIONS(tnum,gogo, finish,owner, adult,child,old,day,hour,minute,specialseat,paynum) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		con = getConn();
		int changeRow = 0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tr.getTnum());
			ps.setString(2, tr.getGogo());
			ps.setString(3, tr.getFinish());
			ps.setString(4, tr.getOwner());
			ps.setString(5, tr.getAdult());
			ps.setString(6, tr.getChild());
			ps.setString(7, tr.getOld());
			ps.setString(8, tr.getDay());
			ps.setString(9, tr.getHour());
			ps.setString(10, tr.getMinute());
			ps.setString(12, tr.getPaynum());
			ps.setString(11, tr.getSpecialseat());
			changeRow = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("첫번째 정보 입력 중 오류 발생");
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}
		
		return changeRow;
	}*/
	
	public int insertTRB(TicketReservation tr){
		Connection con=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO TICKETRESERVATIONS(tnum,gogo, finish,owner, adult,child,old,day,hour,minute,BASICSEAT,PAYNUM)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	
		con = getConn();
		int changeRow = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tr.getTnum());
			ps.setString(2, tr.getGogo());
			ps.setString(3, tr.getFinish());
			ps.setString(4, tr.getOwner());
			ps.setString(5, tr.getAdult());
			ps.setString(6, tr.getChild());
			ps.setString(7, tr.getOld());
			ps.setString(8, tr.getDay());
			ps.setString(9, tr.getHour());
			ps.setString(10, tr.getMinute());
			ps.setString(11, tr.getBasicseat());
			ps.setString(12, tr.getPaynum());
			changeRow = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("자리 입력 중 오류 발생");
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}
		
		return changeRow;
	}
	
	public int insertTRS(TicketReservation tr){
		Connection con=null;
		PreparedStatement ps=null;
		//String sql="INSERT INTO TRAINCHECKS(TICKETNUM,SPECIALSEAT,PAYNUM)VALUES((SELECT MAX(TO_NUMBER(TICKETNUM))+1 FROM TRAINCHECKS),?,?)";
		String sql="INSERT INTO TICKETRESERVATIONS(tnum,gogo, finish,owner, adult,child,old,day,hour,minute,SPECIALSEAT,PAYNUM)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		con = getConn();
		int changeRow = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tr.getTnum());
			ps.setString(2, tr.getGogo());
			ps.setString(3, tr.getFinish());
			ps.setString(4, tr.getOwner());
			ps.setString(5, tr.getAdult());
			ps.setString(6, tr.getChild());
			ps.setString(7, tr.getOld());
			ps.setString(8, tr.getDay());
			ps.setString(9, tr.getHour());
			ps.setString(10, tr.getMinute());
			ps.setString(11, tr.getSpecialseat());
			ps.setString(12, tr.getPaynum());
			changeRow = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("자리 입력 중 오류 발생");
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}
		
		return changeRow;
	}
	
	
	/*public List<TicketReservation> getTRlist(String mid){
		
		String sql = "SELECT * FROM TICKETRESERVATIONS WHERE OWNER=? ORDER BY TO_NUMBER(GOGO) DESC";
		
		TicketReservation tr;
		List<TicketReservation> trlist = new ArrayList<>();
		Connection con = getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			while(rs.next()){
				tr = new TicketReservation();
				tr.setGogo(rs.getString("gogo"));
				tr.setFinish(rs.getString("finish"));
				tr.setOwner(rs.getString("owner"));
				tr.setAdult(rs.getString("adult"));
				tr.setChild(rs.getString("child"));
				tr.setOld(rs.getString("old"));
				tr.setDay(rs.getString("day"));
				tr.setHour(rs.getString("hour"));
				tr.setMinute(rs.getString("minute"));

				trlist.add(tr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}

		return trlist;
	
	}*/
	
	public TicketReservation  getBasicseat(String basicseat){
		TicketReservation tr = null;
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TICKETRESERVATIONS WHERE BASICSEAT=?";
		
		con = getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, basicseat);
			rs = ps.executeQuery();

			if(rs.next()){
				tr = new TicketReservation();
				tr.setTnum(rs.getString("tnum"));
				tr.setBasicseat(rs.getString("basicseat"));
				
			} 
		} catch (SQLException e) {
			System.out.println("SQLException 문장 오류");
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}
		return tr;
	}
	
	public TicketReservation getSpecialseat(String specialseat){
		TicketReservation tc = null;
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TICKETRESERVATIONS WHERE SPECIALSEAT=?";

		con = getConn();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, specialseat);
			rs = ps.executeQuery();

			if(rs.next()){
				tc = new TicketReservation();
				tc.setTnum(rs.getString("tnum"));
				tc.setSpecialseat(rs.getString("specialseat"));
				
			} 
		} catch (SQLException e) {
			System.out.println("SQLException 문장 오류");
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}
		return tc;
	}
	
	public String getTnum(String mid){
		String tnum = null;
		String sql = "SELECT tnum FROM TICKETRESERVATIONS WHERE OWNER=? ORDER BY TO_NUMBER(TNUM) DESC";
		System.out.println(mid);
		Connection con = getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
	
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);

			rs = ps.executeQuery();
			while(rs.next()){
				/*TicketReservation tr = new TicketReservation();*/
				/*tr.setTnum(rs.getString("tnum"));*/
				tnum = rs.getString("tnum");
			}

		} catch (SQLException e) {
			System.out.println("소유 계좌 정보 조회중 오류 발생");
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}
		return tnum;
	}
	
	
	
	
	
	
	
	
	
	
	public List<TicketReservation> getTRtnum(String mid){
		List<TicketReservation> trlist = new ArrayList<>();
		String sql = "SELECT * FROM TICKETRESERVATIONS WHERE OWNER=? ORDER BY TO_NUMBER(TNUM) DESC";
		Connection con = getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
	
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);

			rs = ps.executeQuery();
			trlist=new ArrayList<>();
			while(rs.next()){
				TicketReservation tr = new TicketReservation();
				tr.setTnum(rs.getString("tnum"));
				tr.setGogo(rs.getString("gogo"));
				tr.setFinish(rs.getString("finish"));
				tr.setOwner(rs.getString("owner"));
				tr.setAdult(rs.getString("adult"));
				tr.setChild(rs.getString("child"));
				tr.setOld(rs.getString("old"));
				tr.setDay(rs.getString("day"));
				tr.setHour(rs.getString("hour"));
				tr.setMinute(rs.getString("minute"));
				tr.setBasicseat(rs.getString("basicseat"));
				tr.setSpecialseat(rs.getString("specialseat"));
				tr.setPaynum(rs.getString("paynum"));
				System.out.println("tr.getTnum() :" +tr.getTnum());
				System.out.println("tr.getOwner() :" +tr.getOwner());
				trlist.add(tr);
			}

		} catch (SQLException e) {
			System.out.println("소유 계좌 정보 조회중 오류 발생");
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}
		return trlist;
	}
	
	public TicketReservation getInfor(String tnum){
		TicketReservation tr = null;
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TICKETRESERVATIONS WHERE tnum=?";
	
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tnum);
			rs = ps.executeQuery();
			
			if(rs.next()){
				tr = new TicketReservation();
				tr.setTnum(rs.getString("tnum"));
				tr.setGogo(rs.getString("gogo"));
				tr.setFinish(rs.getString("finish"));
				tr.setOwner(rs.getString("owner"));
				tr.setAdult(rs.getString("adult"));
				tr.setChild(rs.getString("child"));
				tr.setOld(rs.getString("old"));
				tr.setDay(rs.getString("day"));
				tr.setHour(rs.getString("hour"));
				tr.setMinute(rs.getString("minute"));
				tr.setBasicseat(rs.getString("basicseat"));
				tr.setSpecialseat(rs.getString("specialseat"));
				
			} 
		} catch (SQLException e) {
			System.out.println("SQLException 문장 오류");
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}

		return tr;
	}
	
	
}
