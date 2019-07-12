package controller;
import java.sql.*;
import java.util.ArrayList;

public class DBController {
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	
	public DBController() {
		con = null;
		st = null;
		rs = null;
		get_connection();
	}
    
	public static void get_connection() {
		con = null;
		try {
			// Class 的靜態 forName() 方法實現動態加載類別
			Class.forName("com.mysql.jdbc.Driver");
			// 3306|MySQL開放此端口
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "12345678");
			st = con.createStatement();
			
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}
	public void setData(){
		//INSERT INTO `crud`.`user` (`id`, `name`, `mail`, `phone`) VALUES 
		//('4', 'Amy', 'amy3344@yahoo.com.tw', '0934569043');
		try {
			String id_new = "'10'";
			String acc_new = "'coco'";
			String pwd_new = "'test@example.com'";		
			System.out.println(st);
			String query = "INSERT INTO `crud`.`account` (`id`, `name`, `mail`, `phone`) VALUES (" + id_new + ", "+ acc_new +", "+ pwd_new +");";
			//String query = "INSERT INTO `crud`.`user` (`id`, `name`, `mail`, `phone`) VALUES ('77', 'Carol', 'amy3344@yahoo.com.tw', '0934569043');";
			System.out.println(query);
			st.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(ex);
		}		
	}

	public ArrayList<Data> getData() {
		ArrayList<Data> result=new ArrayList<Data>();
		try {
			System.out.println(st);
			String query = "select * from account";
			rs = st.executeQuery(query);
			while (rs.next()) {
				Data data=new Data();
				data.id = rs.getLong("ID");
				data.acc = rs.getString("Account");
				data.pwd = rs.getString("Password");
				result.add(data);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public String  getPwd(String acc){
		String pwd_result = null;
		try {
			acc = "'" + "'";
			String query = "SELECT Password FROM account WHERE Account=" + acc;
			
			//String query = "INSERT INTO `crud`.`user` (`id`, `name`, `mail`, `phone`) VALUES ('77', 'Carol', 'amy3344@yahoo.com.tw', '0934569043');";
			System.out.println(query);
			rs = st.executeQuery(query);
			pwd_result = rs.getString("Password");

		} catch (Exception ex) {
			System.out.println(ex);
		}				
		
		return pwd_result;
	}
	
	

}