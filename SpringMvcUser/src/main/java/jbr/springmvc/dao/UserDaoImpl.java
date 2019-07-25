package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import controller.Data;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

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

  public User validateUser(Login login) {

    String sql = "select * from account where Account='" + login.getUsername() + "' and Password='" + login.getPassword()
        + "'";

    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
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