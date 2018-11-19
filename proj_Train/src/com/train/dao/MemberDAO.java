package com.train.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.train.vo.Member;

public class MemberDAO {
	
	
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

	/*public List<Member> getMemberMnum(String mid){	mnum 중복 제거하려다 실패
		Member m;
		ArrayList<Member> mmlist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBERS WHERE MNUM=?";
		
		Connection con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);

			rs = ps.executeQuery();
			mmlist=new ArrayList<>();
			while(rs.next()){
				m = new Member();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setMnum(rs.getInt("mnum"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setBirthday(rs.getString("birthday"));
				m.setPhone(rs.getString("phone"));
				m.setRegdate(rs.getString("regdate"));
				
				mmlist.add(m);
			}
		} catch (SQLException e) {
			System.out.println("회원번호 중복 확인중 오류 발생");
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
		return mmlist;
		
		
	}*/
	/// 회원 조회 : 1사람
	public Member getMember(String mid) {
		Member m = null;
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBERS WHERE MID=?";
		
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if(rs.next()){
				m = new Member();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setMnum(rs.getInt("mnum"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setBirthday(rs.getString("birthday"));
				m.setPhone(rs.getString("phone"));
				m.setRegdate(rs.getString("regdate"));
			
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
		
		return m;
	}

	/// 회원 추가
	public int addMember(Member m) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO MEMBERS(MID, PWD,MNUM, NAME, GENDER, AGE,birthday,phone,regdate) VALUES(?,?,?,?,?, ?, ?, ?, sysdate)";
		
		con = getConn();
		int changeRow = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getMid());
			ps.setString(2, m.getPwd());
			ps.setInt(3, m.getMnum());
			ps.setString(4, m.getName());
			ps.setString(5, m.getGender());
			ps.setInt(6, m.getAge());
			ps.setString(7, m.getBirthday());
			ps.setString(8, m.getPhone());
			changeRow = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("회원 가입중 오류 발생");
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

	public int updateMember(Member m) {
		
		String sql="UPDATE MEMBERS SET PWD=? WHERE MID=?";
		
		Connection con = getConn();
		PreparedStatement ps = null;
		int cr = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getPwd());
			ps.setString(2, m.getMid());
			
			cr = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원 정보 수정중 오류 발생");
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
		
		return cr;
	}

	public int deleteMember(Member m) {
		String sql ="DELETE MEMBERS WHERE MID=?";
    
    Connection con = getConn();
    int cr=0;
    PreparedStatement ps = null;
    try {
       con.setAutoCommit(false);
       
       ps = con.prepareStatement(sql);
       ps.setString(1, m.getMid());         
       cr = cr + ps.executeUpdate();
       
       con.commit();
       
    } catch (SQLException e) {
       System.out.println("회원 정보 삭제중 오류 발생");   
       try {
          con.rollback();
          System.out.println("회원삭제는 롤백 되었습니다.");
       } catch (SQLException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
       }
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
    
    return cr;
}

	public ArrayList<Member> getMembers() {
		Member m;
		ArrayList<Member> mlist = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="SELECT * FROM MEMBERS ORDER BY NAME";

		Connection con = getConn();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			mlist=new ArrayList<>();
			while(rs.next()){
				m = new Member();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setMnum(rs.getInt("mnum"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setBirthday(rs.getString("birthday"));
				m.setPhone(rs.getString("phone"));
				m.setRegdate(rs.getString("regdate"));
				mlist.add(m);
			}
			
		} catch (SQLException e) {
			System.out.println("전체 회원 정보 조회중 오류 발생");
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
		
		return mlist;
	}
}
