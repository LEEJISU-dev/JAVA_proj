import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class DAO extends Frame{
	DBCon conn;
	
	DAO(){
		conn = new DBCon();
	}
	
	public ArrayList<AdminBean> login(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AdminBean> list = new ArrayList<AdminBean>();
		String sql = "select * from admin";
		AdminBean bean;
		
		try {
			
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				bean = new AdminBean();
				bean.setId(rs.getString(1));
				bean.setPw(rs.getString(2));
				list.add(bean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<STUBean> allstu(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<STUBean> list = new ArrayList<STUBean>();
		String sql = "select * from stu";
		
		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				STUBean bean = new STUBean();
				bean.setNum(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setJumin(rs.getString(3));
				bean.setSex(rs.getString(4));
				bean.setJp(rs.getString(5));
				bean.setIt(rs.getString(6));
				bean.setPhone(rs.getString(7));
				bean.setNo(rs.getString(8));
				list.add(bean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<STUBean> insertSTU(String name,String jumin, String sex, String jp, String it, String phone, String no){
		Connection con = null;
		Statement stmt = null;
		ArrayList<STUBean> list = new ArrayList<STUBean>();
		String sql = "insert into stu (name, jumin, sex, jp, it, phone, no) values ('"+name+"','"+jumin+"','"+sex+"','"+jp+"','"+it+"','"+phone+"','"+no+"')";
		
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "이미 있는 학생 입니다");
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<STUBean> deleteSTU(String num){
		Connection con = null;
		Statement stmt = null;
		ArrayList<STUBean> list = new ArrayList<STUBean>();
		String sql = "delete from stu where num ='"+num+"'";
		
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<STUBean> searchSTU(String num){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<STUBean> list = new ArrayList<STUBean>();
		String sql = "select * from stu where num ='"+num+"'";
		
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				STUBean bean = new STUBean();
				bean.setNum(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setJumin(rs.getString(3));
				bean.setSex(rs.getString(4));
				bean.setJp(rs.getString(5));
				bean.setIt(rs.getString(6));
				bean.setPhone(rs.getString(7));
				bean.setNo(rs.getString(8));
				list.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<STUBean> updateSTU(String num){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<STUBean> list = new ArrayList<STUBean>();
		String sql ="select * from stu where num='"+num+"'";
		
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				STUBean bean = new STUBean();
				bean.setNum(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setJumin(rs.getString(3));
				bean.setSex(rs.getString(4));
				bean.setJp(rs.getString(5));
				bean.setIt(rs.getString(6));
				bean.setPhone(rs.getString(7));
				bean.setNo(rs.getString(8));
				list.add(bean);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<STUBean> updateSTU2(String num, String name, String jumin, String sex, String jp, String it, String phone, String no){
		Connection con = null;
		Statement stmt = null;
		ArrayList<STUBean> list = new ArrayList<STUBean>();
		String sql = "update stu set name='"+name+"',jumin='"+jumin+"',sex='"+sex+"',jp='"+jp+"',it='"+it+"',phone='"+phone+"',no='"+no+"'where num='"+num+"'";
		
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<jp27Bean> alljp_27(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<jp27Bean> list = new ArrayList<jp27Bean>();
		String sql = "SELECT 27jp.date, stu.no, stu.num, stu.name, stu.jp,27jp.jp_att FROM stu, 27jp WHERE stu.num = 27jp.num AND stu.no = '27기';";
		
		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jp27Bean bean = new jp27Bean();
				bean.setDate(rs.getString(1));
				bean.setNo(rs.getString(2));
				bean.setNum(rs.getInt(3));
				bean.setName(rs.getString(4));
				bean.setJp(rs.getString(5));
				bean.setJp_att(rs.getString(6));
				list.add(bean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<jp27Bean> insertJp_27(){
		Connection con = null;
		Statement stmt = null;
		ArrayList<jp27Bean> list = new ArrayList<jp27Bean>();
		String sql = "INSERT 27jp(num) SELECT num FROM stu WHERE stu.no = '27기'";
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<jp27Bean> delete_Jp27(String day){
		Connection con = null;
		Statement stmt = null;
		ArrayList<jp27Bean> list = new ArrayList<jp27Bean>();
		String sql = "delete from 27jp where date ='"+day+"'";
		
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<jp27Bean> input_Jp27(String day, String jp_att, String num){
		Connection con = null;
		Statement stmt = null;
		ArrayList<jp27Bean> list = new ArrayList<>();
		String sql = "update 27jp set date='"+day+"',jp_att='"+jp_att+"' where num = '"+num+"' and date is null";
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<jp27Bean> update_Jp27(String day, String num){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<jp27Bean> list = new ArrayList<>();
		String sql ="SELECT 27jp.date,stu.no,stu.num, stu.name, stu.jp,27jp.jp_att "
				+ "FROM stu JOIN 27jp ON stu.num = 27jp.num WHERE DATE ='"+day+"'and 27jp.num = '"+num+"'";

		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				jp27Bean bean = new jp27Bean();
				bean.setDate(rs.getString(1));
				bean.setNo(rs.getString(2));
				bean.setNum(rs.getInt(3));
				bean.setName(rs.getString(4));
				bean.setJp(rs.getString(5));
				bean.setJp_att(rs.getString(6));
				list.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<jp27Bean> update2_Jp27(String num, String day, String jp_att){
		Connection con = null;
		Statement stmt = null;
		ArrayList<jp27Bean> list = new ArrayList<jp27Bean>();
		String sql = "update 27jp set jp_att='"+jp_att+"' where num='"+num+"' and date='"+day+"'";
		
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<_27Bean> check_all27(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<_27Bean> list = new ArrayList<>();
		String sql ="SELECT 27jp.date, stu.no, stu.num, stu.name, stu.jp,27jp.jp_att, stu.it, 27it.it_att "
				+ "FROM stu JOIN 27jp ON stu.num = 27jp.num LEFT JOIN 27it ON stu.num = 27it.num WHERE stu.no = '27기'";
		
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				_27Bean bean = new _27Bean();
				bean.setDate(rs.getString(1));
				bean.setNo(rs.getString(2));
				bean.setNum(rs.getInt(3));
				bean.setName(rs.getString(4));
				bean.setJp(rs.getString(5));
				bean.setJp_att(rs.getString(6));
				bean.setIt(rs.getString(7));
				bean.setIt_att(rs.getString(8));
				list.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<_27Bean> search27(String day){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<_27Bean> list = new ArrayList<_27Bean>();
		String sql = "SELECT 27jp.date, stu.no, stu.num, stu.name, stu.jp,27jp.jp_att, stu.it, 27it.it_att "
				+ "FROM stu JOIN 27jp ON stu.num = 27jp.num LEFT JOIN 27it ON stu.num = 27it.num WHERE 27jp.DATE ='"+day+"' AND stu.no = '27기';";
		
		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				_27Bean bean = new _27Bean();
				bean.setDate(rs.getString(1));
				bean.setNo(rs.getString(2));
				bean.setNum(rs.getInt(3));
				bean.setName(rs.getString(4));
				bean.setJp(rs.getString(5));
				bean.setJp_att(rs.getString(6));
				bean.setIt(rs.getString(7));
				bean.setIt_att(rs.getString(8));
				list.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
}