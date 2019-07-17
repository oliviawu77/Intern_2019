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

	public ArrayList<Data> getData() {
		ArrayList<Data> result=new ArrayList<Data>();
		try {
			String query = "select * from account";
			rs = st.executeQuery(query);
			while (rs.next()) {
				Data data=new Data();
				data.id = rs.getLong("ID");
				data.acc = rs.getString("Account");
				data.pwd = rs.getString("Password");
				data.msg = rs.getString("Message");
				data.email = rs.getString("Email");
				data.sex = rs.getString("Sex");
				data.age = rs.getString("Age");
				data.name = rs.getString("Name");
				result.add(data);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}
	
	public String getSex(String acc) {
		String sex = null;
		try {
			String query = "select * from account";
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (acc.equals(rs.getString("Account")))
				sex = rs.getString("Sex");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return sex;
	}
	
	public Boolean  AccExists(String acc){
		Boolean acc_exists = false;
		try {
			String query = "select * from account";
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (acc.equals(rs.getString("Account")))
				{
					acc_exists = true;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}		
		
		return acc_exists;
	}
	
	
	public String  getPwd(String acc){
		String pwd_result = null;
		try {
			//String query = "SELECT Account, Password FROM account WHERE Account=" + "\"" + acc +"\"";
			String query = "select * from account";
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (acc.equals(rs.getString("Account")))
				{
					pwd_result = rs.getString("Password");
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}				
		return pwd_result;
	}
	public String  getMsg(String acc){
		String msg = null;
		try {
			String query = "select * from account";
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (acc.equals(rs.getString("Account")))
				{
					msg = rs.getString("Message");
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}				
		return msg;
	}	

	public void  changePwd(String acc,String pwd_new){
		try {
			String query = "select * from account";
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (acc.equals(rs.getString("Account")))
				{
					query = "UPDATE `account` SET Password = '"+ pwd_new +"' WHERE Account = '"+ acc +"' ";
					st.executeUpdate(query);
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}				
	}

	public void  changeMsg(String acc,String msg){
		try {
			String query = "select * from account";
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (acc.equals(rs.getString("Account")))
				{
					query = "UPDATE `account` SET Message = '"+ msg +"' WHERE Account = '"+ acc +"' ";
					st.executeUpdate(query);
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}				
	}
	
	public void  CreateUser(String acc,String pwd, String email, String sex, String age, String name){
		try {
			int size = 0;
			String query = "select * from account";
			rs = st.executeQuery(query);
			while (rs.next()) {
					size++;
			}
			size++;
			query = "INSERT INTO `crud`.`account`(`ID`, `Account`, `Password`, `Message`, `Email`, `Sex`, `Age`, `Name`) VALUE('"+ size +"','"+ acc +"','"+ pwd +"','update','"+ email + "','"+ sex +"','"+ age +"','"+name+"')";
			System.out.println(query);
			st.executeUpdate(query);

		} catch (Exception ex) {
			System.out.println(ex);
		}				
	}	

}