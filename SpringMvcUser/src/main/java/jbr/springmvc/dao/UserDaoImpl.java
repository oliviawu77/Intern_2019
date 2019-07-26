package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;


  public void register(User user) {
	  try {
	        String sql = "insert into account values(?,?,?,?,?,?,?,?)";

	        jdbcTemplate.update(sql, new Object[] { user.getId(), user.getAcc(), user.getPwd(), "null",
				  user.getEmail(), user.getSex(), user.getAge(), user.getName() });
	  }
	  catch (Exception ex) {
			System.out.println(ex);
		}
}
  

  public void update(User user) {
	  try {
			String sql = null;
			System.out.println(sql+"this is test");
	        if(user.getName()!=""){
	        	sql = "UPDATE `account` SET Name = '"+ user.getName() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	System.out.println(sql);
	        	jdbcTemplate.update(sql);		
	        	}
	        if(user.getPwd()!=""){
	        	sql = "UPDATE `account` SET Name = '"+ user.getPwd() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	System.out.println(sql);
	        	jdbcTemplate.update(sql);		
	        	}
	        if(user.getMsg()!=""){
	        	sql = "UPDATE `account` SET Name = '"+ user.getMsg() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	System.out.println(sql);
	        	jdbcTemplate.update(sql);		
	        	}
	        if(user.getEmail()!=""){
	        	sql = "UPDATE `account` SET Name = '"+ user.getEmail() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	System.out.println(sql);
	        	jdbcTemplate.update(sql);		
	        	}
	        if(user.getSex()!=""){
	        	sql = "UPDATE `account` SET Name = '"+ user.getSex() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	System.out.println(sql);
	        	jdbcTemplate.update(sql);		
	        	}
	        if(user.getAge()!=""){
	        	sql = "UPDATE `account` SET Name = '"+ user.getAge() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	System.out.println(sql);
	        	jdbcTemplate.update(sql);		
	        	}		        
	  }
	  catch (Exception ex) {
			System.out.println(ex);
		}
}  

  public List<User> getUserList(){

	  String sql = "select * from account";
	  List<User> result = jdbcTemplate.query(sql, new UserMapper());
	  return result;
  }

  public User validateUser(Login login) {

    String sql = "select * from account where Account='" + login.getUsername() + "' and Password='" + login.getPassword()
        + "'";

    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }

  public String getSex(Login login) {
	  	String sex = null;
	    String sql = "select Sex from account where Account='" + login.getUsername();

	    List<User> users = jdbcTemplate.query(sql, new UserMapper());

	    return sex;
	  }

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setId(rs.getInt("ID"));
    user.setAcc(rs.getString("Account"));
    user.setPwd(rs.getString("Password"));
    user.setMsg(rs.getString("Message"));
    user.setEmail(rs.getString("Email"));
    user.setSex(rs.getString("Sex"));
    user.setAge(rs.getString("Age"));
    user.setName(rs.getString("Name"));
    return user;
  }
}
}