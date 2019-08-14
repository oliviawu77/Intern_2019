package jbr.springmvc.service;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.model.Employee;
import jbr.springmvc.model.EmployeeList;

public interface UserService {

  void register(User user);
  void update(User user);
  void delete(User user);
  void createEmployee(Employee employee);

  User validateUser(Login login);
}
