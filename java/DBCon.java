import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {  //db connection�� ����ϴ� Ŭ����

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/proj?characterEncoding=utf8&verifyServerCertificate=FALSE&useSSL=TRUE";
	String id = "root";
	String pw = "1234";
	
	Connection con = null;
	
	public DBCon() {
		try {
			Class.forName(driver);  //odbc6.jar ����̹��� �ڹ� ��ü��
			con = DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public Connection getConnection() {
		return con;
	}
}
