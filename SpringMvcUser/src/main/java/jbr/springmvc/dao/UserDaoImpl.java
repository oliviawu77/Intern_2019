package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.model.Employee;
import jbr.springmvc.model.EmployeeList;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;
  
  public void createEmployee(Employee employee) {
	  try {
		  	String sql = null;
	        sql = "insert into `employee` values(?,?,?,?,?,?,?)";
	        jdbcTemplate.update(sql, new Object[] {employee.getId(), employee.getJob_grade(), employee.getJob_position(), 
	        		employee.getWork_shift(), employee.getExercise_date(), employee.getExercise_week(), employee.getStep() });
	  }
	  catch (Exception ex) {
			System.out.println(ex);
		}	  	  
  };

  public void delete(User user) {
	  try {
	        String sql = "delete from account where Account = ?";
	        jdbcTemplate.update(sql, new Object[] {user.getAcc()});
	  }
	  catch (Exception ex) {
			System.out.println(ex);
		}	  
  };

  public void register(User user) {
	  try {
		  	String sql = "SELECT MAX(ID) FROM ACCOUNT";
		  	int tmp_id = jdbcTemplate.queryForObject(sql,Integer.class) + 1;
		  	
	        sql = "insert into account values(?,?,?,?,?,?,?,?)";
	        jdbcTemplate.update(sql, new Object[] { tmp_id, user.getAcc(), user.getPwd(), "null",
				  user.getEmail(), user.getSex(), user.getAge(), user.getName() });
	  }
	  catch (Exception ex) {
			System.out.println(ex);
		}
}
  

  public void update(User user) {
	  try {
			String sql = null;
			String sex = user.getSex();			
	        if(user.getName()!=""){
	        	sql = "UPDATE `account` SET Name = '"+ user.getName() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	jdbcTemplate.update(sql);		
	        	}
	        if(user.getPwd()!=""){
	        	sql = "UPDATE `account` SET Password = '"+ user.getPwd() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	jdbcTemplate.update(sql);		
	        	}
	        if(user.getMsg()!=""){
	        	sql = "UPDATE `account` SET Message = '"+ user.getMsg() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	jdbcTemplate.update(sql);		
	        	}
	        if(user.getEmail()!=""){
	        	sql = "UPDATE `account` SET Email = '"+ user.getEmail() +"' WHERE Account = '"+ user.getAcc() +"' ";
	        	jdbcTemplate.update(sql);		
	        	}
	        if(sex.equals("male")){
	        	sql = "UPDATE `account` SET Sex = 'male' WHERE Account = '"+ user.getAcc() +"' ";
	        	jdbcTemplate.update(sql);		
	        	}
	        if(sex.equals("female")){
	        	sql = "UPDATE `account` SET Sex = 'female' WHERE Account = '"+ user.getAcc() +"' ";
	        	jdbcTemplate.update(sql);		
	        	} 	        
	        if(user.getAge()!=""){
	        	sql = "UPDATE `account` SET Age = '"+ user.getAge() +"' WHERE Account = '"+ user.getAcc() +"' ";
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
  
  public List<Employee> getEmployee(String id){

	  String sql = "SELECT * from `employee` WHERE id = '" + id + "'";
	  List<Employee> result = jdbcTemplate.query(sql, new EmployeeMapper());
	  return result;
  }

  public Employee getEmployeeInformation(String id){

	  String sql = "SELECT * from `employee` WHERE id = '" + id + "' LIMIT 0,1 ";
	  List<Employee> employee = jdbcTemplate.query(sql, new EmployeeMapper());
	  return employee.size() > 0 ? employee.get(0) : null;
  }  
  
  
  public List<EmployeeList> getEmployeeList(){

	  String sql = "SELECT DISTINCT id from `employee`";
	  List<EmployeeList> result = jdbcTemplate.query(sql, new EmployeeListMapper());
	  return result;
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

class EmployeeMapper implements RowMapper<Employee> {

	  public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getString("id"));
		employee.setJob_grade(rs.getString("job_grade"));
		employee.setJob_position(rs.getString("job_position"));
		employee.setWork_shift(rs.getString("work_shift"));
		employee.setExercise_date(rs.getString("exercise_date"));
		employee.setExercise_week(rs.getString("exercise_week"));
	    employee.setStep(rs.getString("step"));
	    return employee;
	  }  
	}

class EmployeeListMapper implements RowMapper<EmployeeList> {

	  public EmployeeList mapRow(ResultSet rs, int arg1) throws SQLException {
		EmployeeList employeeList = new EmployeeList();
		employeeList.setId(rs.getString("id"));
	    return employeeList;
	  }  
	}
}