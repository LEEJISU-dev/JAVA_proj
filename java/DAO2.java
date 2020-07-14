import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class DAO2 extends Frame{
DBCon conn;
	
	DAO2(){
		conn = new DBCon();
	}
	
	public ArrayList<it27Bean> allit_27(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql = "SELECT 27it.date, stu.no, stu.num, stu.name, stu.it,27it.it_att "
				+ "FROM stu, 27it WHERE stu.num = 27it.num and stu.no = '27기';";
		
		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				it27Bean bean = new it27Bean();
				bean.setDate(rs.getString(1));
				bean.setNo(rs.getString(2));
				bean.setNum(rs.getInt(3));
				bean.setName(rs.getString(4));
				bean.setIt(rs.getString(5));
				bean.setIt_att(rs.getString(6));
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
	
	public ArrayList<it27Bean> insertIt_27(){
		Connection con = null;
		Statement stmt = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql = "INSERT 27it(num) SELECT num FROM stu WHERE stu.no = '27기'";
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
	
	public ArrayList<it27Bean> delete_it27(String day){
		Connection con = null;
		Statement stmt = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql = "delete from 27it where date ='"+day+"'";
		
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
	
	public ArrayList<it27Bean> input_It27(String day, String it_att, String num){
		Connection con = null;
		Statement stmt = null;
		ArrayList<it27Bean> list = new ArrayList<>();
		String sql = "update 27it set date='"+day+"',it_att='"+it_att+"'where num = '"+num+"' and date is null";
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
	
	public ArrayList<it27Bean> update_It27(String day, String num){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql ="SELECT 27it.date,stu.no,stu.num, stu.name, stu.it,27it.it_att "
				+ "FROM stu JOIN 27it ON stu.num = 27it.num WHERE DATE ='"+day+"'and 27it.num = '"+num+"'";

		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				it27Bean bean = new it27Bean();
				bean.setDate(rs.getString(1));
				bean.setNo(rs.getString(2));
				bean.setNum(rs.getInt(3));
				bean.setName(rs.getString(4));
				bean.setIt(rs.getString(5));
				bean.setIt_att(rs.getString(6));
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
	
	public ArrayList<it27Bean> update2_It27(String num,String day, String it_att){
		Connection con = null;
		Statement stmt = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql = "update 27it set it_att='"+it_att+"' where num='"+num+"' and date='"+day+"'";
		
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
	
	public ArrayList<jp26Bean> alljp_26(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<jp26Bean> list = new ArrayList<jp26Bean>();
		String sql = "SELECT 26jp.date, stu.no, stu.num, stu.name, stu.jp,26jp.jp_att "
				+ "FROM stu, 26jp WHERE stu.num = 26jp.num AND stu.no = '26기';";
		
		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jp26Bean bean = new jp26Bean();
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
	
	public ArrayList<jp26Bean> insertJp_26(){
		Connection con = null;
		Statement stmt = null;
		ArrayList<jp26Bean> list = new ArrayList<jp26Bean>();
		String sql = "INSERT 26jp(num) SELECT num FROM stu WHERE stu.no = '26기'";
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
	
	public ArrayList<jp26Bean> delete_jp26(String day){
		Connection con = null;
		Statement stmt = null;
		ArrayList<jp26Bean> list = new ArrayList<jp26Bean>();
		String sql = "delete from 26jp where date ='"+day+"'";
		
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
	
	public ArrayList<jp26Bean> input_Jp26(String day, String jp_att, String num){
		Connection con = null;
		Statement stmt = null;
		ArrayList<jp26Bean> list = new ArrayList<>();
		String sql = "update 26jp set date='"+day+"',jp_att='"+jp_att+"'where num = '"+num+"' and date is null";
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
	
	public ArrayList<jp26Bean> update_Jp26(String day,String num){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<jp26Bean> list = new ArrayList<>();
		String sql ="SELECT 26jp.date,stu.no,stu.num, stu.name, stu.jp,26jp.jp_att "
				+ "FROM stu JOIN 26jp ON stu.num = 26jp.num WHERE DATE ='"+day+"'and 26jp.num = '"+num+"'";

		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				jp26Bean bean = new jp26Bean();
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
	
	public ArrayList<jp26Bean> update2_Jp26(String num, String day, String jp_att){
		Connection con = null;
		Statement stmt = null;
		ArrayList<jp26Bean> list = new ArrayList<jp26Bean>();
		String sql = "update 26jp set jp_att='"+jp_att+"' where num='"+num+"' and date='"+day+"'";
		
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

	public ArrayList<it27Bean> allit_26(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql = "SELECT 26it.date, stu.no, stu.num, stu.name, stu.it,26it.it_att "
				+ "FROM stu, 26it WHERE stu.num = 26it.num and stu.no = '26기';";
		
		try {
			con = conn.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				it27Bean bean = new it27Bean();
				bean.setDate(rs.getString(1));
				bean.setNo(rs.getString(2));
				bean.setNum(rs.getInt(3));
				bean.setName(rs.getString(4));
				bean.setIt(rs.getString(5));
				bean.setIt_att(rs.getString(6));
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
	
	public ArrayList<it27Bean> insertIt_26(){
		Connection con = null;
		Statement stmt = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql = "INSERT 26it(num) SELECT num FROM stu WHERE stu.no = '26기';";
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
	public ArrayList<it27Bean> delete_it26(String day){
		Connection con = null;
		Statement stmt = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql = "delete from 26it where date ='"+day+"'";
		
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
	public ArrayList<it27Bean> input_It26(String day, String it_att, String num){
		Connection con = null;
		Statement stmt = null;
		ArrayList<it27Bean> list = new ArrayList<>();
		String sql = "update 26it set date='"+day+"',it_att='"+it_att+"'where num = '"+num+"' and date is null";
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
	
	public ArrayList<it27Bean> update_It26(String day, String num){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql ="SELECT 26it.date,stu.no,stu.num, stu.name, stu.it,26it.it_att "
				+ "FROM stu JOIN 26it ON stu.num = 26it.num WHERE DATE ='"+day+"'and 26it.num = '"+num+"'";

		try{
			con = conn.getConnection();
			stmt = con.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				it27Bean bean = new it27Bean();
				bean.setDate(rs.getString(1));
				bean.setNo(rs.getString(2));
				bean.setNum(rs.getInt(3));
				bean.setName(rs.getString(4));
				bean.setIt(rs.getString(5));
				bean.setIt_att(rs.getString(6));
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
	
	public ArrayList<it27Bean> update2_It26(String num,String day, String it_att){
		Connection con = null;
		Statement stmt = null;
		ArrayList<it27Bean> list = new ArrayList<it27Bean>();
		String sql = "update 26it set it_att='"+it_att+"' where num='"+num+"'and date='"+day+"'";
		
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
	
	public ArrayList<_27Bean> check_all26(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<_27Bean> list = new ArrayList<>();
		String sql ="SELECT 26jp.date, stu.no, stu.num, stu.name, stu.jp,26jp.jp_att, stu.it, 26it.it_att "
				+ "FROM stu JOIN 26jp ON stu.num = 26jp.num LEFT JOIN 26it ON stu.num = 26it.num WHERE stu.no = '26기'";
		
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
	
	public ArrayList<_27Bean> search26(String day){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<_27Bean> list = new ArrayList<_27Bean>();
		String sql = "SELECT 26jp.date, stu.no, stu.num, stu.name, stu.jp,26jp.jp_att, stu.it, 26it.it_att "
				+ "FROM stu JOIN 26jp ON stu.num = 26jp.num LEFT JOIN 26it ON stu.num = 26it.num WHERE 26jp.DATE ='"+day+"' AND stu.no = '26기';";
		
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
