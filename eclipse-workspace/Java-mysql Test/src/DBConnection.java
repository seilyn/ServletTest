import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection{
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "jdbc", "password");
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ���� " + e.getMessage());
		}
	}
	public boolean isAdmin(String mailAddr, String adminPassword) {
		try {
			String query = "SELECT * FROM userinfo WHERE mailaddr = '" + mailAddr + "'and pwd = '" + adminPassword + "'"; 
			rs = st.executeQuery(query);
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� �˻� ���� :" + e.getMessage());
		}
		return false;
	}
}