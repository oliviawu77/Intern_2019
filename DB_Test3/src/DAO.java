import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DAO {
    public static void main(String[] args) {
	DAO obj_DAO=new DAO();
	obj_DAO.Check_Data();
    }
    public void Check_Data(){
	DB_Connection obj_DB_Connection=new DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	try {
		System.out.println(connection);
	    String query="select * from user";
	    ps=connection.prepareStatement(query);
	    ResultSet rs=ps.executeQuery();
	    while(rs.next()){
	        System.out.println("name- "+rs.getString("name"));
	    }
	} catch (Exception e) {
	    System.out.println(e);
	}
    }

}