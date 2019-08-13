package jbr.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.model.Employee;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public void register(User user) {
	    userDao.register(user);
	  }
  public void update(User user) {
	    userDao.update(user);
	  }
  public void delete(User user) {
	  userDao.delete(user);
  	};
    public void updateEmployee(Employee employee) {
  	  userDao.updateEmployee(employee);
    	};    	
  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
