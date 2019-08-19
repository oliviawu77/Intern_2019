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
import jbr.springmvc.model.EmployeeTop50;

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
  
  public int AvgSteps_Employee(){

	  String sql = "SELECT SUM(step)/COUNT(DISTINCT exercise_date)/COUNT(DISTINCT ID) FROM employee WHERE job_grade = '一般員工'";
	  int employeeSteps = jdbcTemplate.queryForObject(sql, Integer.class);
	  return employeeSteps;
  }
  
  public int AvgSteps_Boss(){

	  String sql = "SELECT SUM(step)/COUNT(DISTINCT exercise_date)/COUNT(DISTINCT ID) FROM employee WHERE job_grade = '主管'";
	  int bossSteps = jdbcTemplate.queryForObject(sql, Integer.class);
	  return bossSteps;
  }

  public int AvgSteps_Noshifts(){
	  String sql = "SELECT SUM(step)/COUNT(DISTINCT exercise_date)/COUNT(DISTINCT ID) FROM employee WHERE work_shift = '一般上下班'";
	  int noshiftsSteps = jdbcTemplate.queryForObject(sql, Integer.class);
	  return noshiftsSteps;
  }
  
  public int AvgSteps_shifts(){
	  String sql = "SELECT SUM(step)/COUNT(DISTINCT exercise_date)/COUNT(DISTINCT ID) FROM employee WHERE work_shift = '輪班制'";
	  int shiftsSteps = jdbcTemplate.queryForObject(sql, Integer.class);
	  return shiftsSteps;
  }

  public List<EmployeeTop50> GetTop50(){
	  String sql = "SELECT ID, SUM(step)/COUNT(DISTINCT exercise_date) AS avg_steps FROM employee GROUP BY ID ORDER BY SUM(step)/COUNT(DISTINCT exercise_date) DESC LIMIT 0,50";
	  List<EmployeeTop50> Top50 = jdbcTemplate.query(sql, new EmployeeTop50Mapper());
	  return Top50;
  } 

  public float GetPercent1(){
	  String sql = "SELECT COUNT(*) FROM (SELECT ID FROM employee GROUP BY ID HAVING SUM(step)/COUNT(DISTINCT exercise_date) < 5000) AS AMOUNT";
	  float GetPercent1 = jdbcTemplate.queryForObject(sql, Integer.class);
	  sql = "SELECT COUNT(*) FROM (SELECT ID FROM employee GROUP BY ID ) AS AMOUNT";
	  float Total = jdbcTemplate.queryForObject(sql, Integer.class);
	  GetPercent1 = GetPercent1 / Total;
	  return GetPercent1;
  }
  public float GetPercent2(){
	  String sql = "SELECT COUNT(*) FROM (SELECT ID FROM employee GROUP BY ID HAVING (SUM(step)/COUNT(DISTINCT exercise_date) >= 5000) AND (SUM(step)/COUNT(DISTINCT exercise_date) < 7500)) AS AMOUNT";
	  float GetPercent2 = jdbcTemplate.queryForObject(sql, Integer.class);
	  sql = "SELECT COUNT(*) FROM (SELECT ID FROM employee GROUP BY ID ) AS AMOUNT";
	  float Total = jdbcTemplate.queryForObject(sql, Integer.class);
	  GetPercent2 = GetPercent2 / Total;
	  return GetPercent2;
  }
  public float GetPercent3(){
	  String sql = "SELECT COUNT(*) FROM (SELECT ID FROM employee GROUP BY ID HAVING (SUM(step)/COUNT(DISTINCT exercise_date) >= 7500) AND (SUM(step)/COUNT(DISTINCT exercise_date) < 10000)) AS AMOUNT";
	  float GetPercent3 = jdbcTemplate.queryForObject(sql, Integer.class);
	  sql = "SELECT COUNT(*) FROM (SELECT ID FROM employee GROUP BY ID ) AS AMOUNT";
	  float Total = jdbcTemplate.queryForObject(sql, Integer.class);
	  GetPercent3 = GetPercent3 / Total;
	  return GetPercent3;
  }
  public float GetPercent4(){
	  String sql = "SELECT COUNT(*) FROM (SELECT ID FROM employee GROUP BY ID HAVING SUM(step)/COUNT(DISTINCT exercise_date) >= 10000) AS AMOUNT";
	  float GetPercent4 = jdbcTemplate.queryForObject(sql, Integer.class);
	  sql = "SELECT COUNT(*) FROM (SELECT ID FROM employee GROUP BY ID ) AS AMOUNT";
	  float Total = jdbcTemplate.queryForObject(sql, Integer.class);
	  GetPercent4 = GetPercent4 / Total;
	  return GetPercent4;
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

class EmployeeTop50Mapper implements RowMapper<EmployeeTop50> {

	  public EmployeeTop50 mapRow(ResultSet rs, int arg1) throws SQLException {
		  EmployeeTop50 employeetop50 = new EmployeeTop50();
		  employeetop50.setId(rs.getString("id"));
		  employeetop50.setStep(rs.getInt("avg_steps"));
	    return employeetop50;
	  }  
	}
}